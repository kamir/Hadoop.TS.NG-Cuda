/*
 * JCuda - Java bindings for NVIDIA CUDA
 *
 * Copyright 2008-2016 Marco Hutter - http://www.jcuda.org
 */
package tsa.dfa;

import org.apache.hadoopts.chart.simple.MultiChart;
import org.apache.hadoopts.chart.simple.SigmaFilter;
import org.apache.hadoopts.data.TestDataFactory;
import org.apache.hadoopts.data.export.OriginProject;
import org.apache.hadoopts.data.series.Messreihe;
import org.apache.hadoopts.statphys.detrending.MultiDFATool4;

import java.util.Locale;
import java.util.Vector;

/**
 *
 * This application compares multiple RNGs.<br>
 *
 *
 *
 * The CUDA example is based on a port of the NVIDIA CURAND documentation example.
 *
 */
public class DFAExperiments
{

    static int zRuns = 5;
    static boolean showPlotFrame = false;

    static boolean useGPU = false;
    static boolean useHTSA;

    static int[] lengths = { 1000, 10000, 100000, 1000000 };

    public static void main(String args[])
    {




        Locale.setDefault(new Locale("en", "USA"));

        if ( args == null || args.length < 3) {
            zRuns = 10;
            showPlotFrame = true;
            useGPU = false;
        }
        else {
            zRuns = Integer.parseInt( args[0] );
            showPlotFrame = Boolean.parseBoolean( args[1] );
            useGPU = Boolean.parseBoolean( args[2] );
        }


        Vector<String> labels = new Vector<String>();

        Vector<DFAModule> modules = new Vector();

        Vector<Messreihe> results = new Vector();

        Vector<Vector<Messreihe>> tmp = new Vector();








        if( useHTSA ) {
            DFAModuleHTSA1 dfam1 = new DFAModuleHTSA1();
            modules.add(dfam1);
            Messreihe mr4 = new Messreihe();
            labels.add(DFAModuleHTSA1.class.getName());
            results.add(mr4);
        }

        if( useGPU ) {
            DFAModuleCUDA dfam2 = new DFAModuleCUDA();
            modules.add( dfam2 );
            Messreihe mr1 = new Messreihe();
            labels.add( DFAModuleCUDA.class.getName() );
            results.add(mr1);
        }



        for (DFAModule rngm : modules) {

            Vector<Messreihe> rTemp = new Vector<Messreihe>();

            for( int r=0; r < zRuns; r++ ) {

                Messreihe mrRun = new Messreihe();

                mrRun.setLabel( rngm.toString() + "_" + r );

                rTemp.add( mrRun );

            }

            tmp.add( rTemp );
        }

        int r = 0;
        while ( r < zRuns ){

        System.out.println( ">> RUN " + r );

        for (int n : lengths) {

            int i = 0;
            for (DFAModule module : modules) {

                System.out.println(module.toString() + " => " + n);

                module.init(n);

                double t0 = System.currentTimeMillis();

                float[] hostData = module.createRandomSeries(n, n);

                Messreihe mr = getMessreiheForFloatArray( hostData );

                double t1 = System.currentTimeMillis();

                runDFA( mr );

                double t2 = System.currentTimeMillis();

                double dt = t2 - t1;

                // System.out.println(module.toString() + " => " + dt + " ms ");

                results.elementAt(i).addValuePair(n, dt);

                tmp.elementAt(i).elementAt(r).addValuePair(n, dt);

                i++;
            }

        }
        r++;


    }
        Vector<Messreihe> show = new Vector<Messreihe>();

        int l = 0;
        for( Vector<Messreihe> runsResults : tmp ) {


            SigmaFilter sf = new SigmaFilter();

            for( Messreihe m : runsResults ) {
                sf.addCollect( m, false );
            }

            sf.aggregate();

            Messreihe mr =  Messreihe.averageForAll( runsResults );
            mr.xValues = labelVector();

            mr.setLabel( labels.elementAt( l ) );
            show.add( mr );

            l++;
        }

        if ( showPlotFrame ) {

            String title = "Creation Time vs. Length of  Random Number Series on Multiple RNGs (zRuns=" + zRuns + ")";
            String tx = "# of random numbers";
            String ty = "time to calc F(s) [ms]";

            MultiChart.setSmallFont();

            MultiChart.open(show, title, tx, ty, true);


        }

            OriginProject op = new OriginProject();

        long time = System.currentTimeMillis();

            try {

                op.initBaseFolder( "out/rng_report_" + zRuns + "_" + time );
                op.addMessreihen( show , "rng" , true );

            }
            catch (Exception e) {
                e.printStackTrace();
            }


         try {
             dsp.DSProjectHelper.setSysClipboardText(zRuns + "_" + time);
         }
         catch( Exception ex ) {
             System.out.println("> Copy & Paste feature not available. " );

         }

        System.out.println("#Please add the time stamp into the script: scripts/gnuplot/tsbucket_report.plot");
        System.out.println("> zRuns : " + zRuns);
        System.out.println("> time  : " + time);



    }

    private static void runDFA(Messreihe mr) {

        MultiDFATool4 tool = new MultiDFATool4();
        tool.logLogResults = true;
        tool.showCharts = true;
        tool.storeCharts = true;

        Vector<Messreihe> vmr = new Vector<Messreihe>();
        vmr.add(mr);

        // nun werden die Berechnungen für verschiedene Ordnungen durchgeführt
        int[] orders = { 2 };
        for (int i : orders) {
            try {
                tool.runDFA(vmr, i);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }

        }

    }

    private static Messreihe getMessreiheForFloatArray(float[] hostData) {
        Messreihe mr = new Messreihe();
        int c = 0;
        for ( float v : hostData ) {
           mr.addValuePair((double)c, (double)v );
           c++;
        }
        return mr;
    }

    private static Vector labelVector() {
        Vector<Double> l = new Vector<Double>();
        for(int le : lengths ) {
            l.add((double)le);
        }
        return l;
    }

    public static Vector<Messreihe> getTestReihen( int anz ) {
        stdlib.StdRandom.initRandomGen(1);


        int[] length = { 1000, 500, 250, 500, 2500,
                3500, 1450, 2500, 700, 3000,
                1000, 600, 200, 100, 2000,
                1234, 5678, 2222, 100, 10  };

        Vector<Messreihe> vmr = new Vector<Messreihe>();
        for (int i = 0; i < anz; i++) {

            Messreihe mr = TestDataFactory.getDataSeriesRandomValues_RW(length[i]);
            mr.setLabel("R" + i + " [" + length[i] + "]");
            vmr.add(mr);
        }

        return vmr;
    }
}
