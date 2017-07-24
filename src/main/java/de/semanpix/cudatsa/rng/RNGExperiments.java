/*
 * JCuda - Java bindings for NVIDIA CUDA
 *
 * Copyright 2008-2016 Marco Hutter - http://www.jcuda.org
 */
package de.semanpix.cudatsa.rng;

import org.apache.hadoopts.chart.simple.MultiChart;
import org.apache.hadoopts.chart.simple.SigmaFilter;
import org.apache.hadoopts.data.series.Messreihe;

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
public class RNGExperiments
{

    static int zRuns = 10;

    static int[] lengths = { 100, 200, 300, 400, 500, 600, 700, 800, 900, 1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000,
                             10000, 25000, 50000, 100000, 200000,300000,400000,500000, 600000, 700000, 800000, 900000, 1000000, 2000000, 3000000, 4000000, 5000000, 6000000, 7000000, 8000000, 9000000, 10000000 };

    public static void main(String args[])
    {

        Vector<String> labels = new Vector<String>();

        Vector<RNGModule> modules = new Vector();

        Vector<Messreihe> results = new Vector();

        Vector<Vector<Messreihe>> tmp = new Vector();



        RNGModuleCUDA rng1 = new RNGModuleCUDA();
        modules.add( rng1 );
        Messreihe mr1 = new Messreihe();
        labels.add( RNGModuleCUDA.class.getName() );
        results.add(mr1);


        RNGModuleACMR rng2 = new RNGModuleACMR();
        modules.add( rng2 );
        Messreihe mr2 = new Messreihe();
        labels.add( RNGModuleACMR.class.getName() );
        results.add(mr2);

        RNGModuleACMS rng3 = new RNGModuleACMS();
        modules.add( rng3 );
        Messreihe mr3 = new Messreihe();
        labels.add( RNGModuleACMS.class.getName() );
        results.add(mr3);

        RNGModuleJUR rng4 = new RNGModuleJUR();
        modules.add( rng4 );
        Messreihe mr4 = new Messreihe();
        labels.add( RNGModuleJUR.class.getName() );
        results.add(mr4);



        for (RNGModule rngm : modules) {

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
            for (RNGModule rngm : modules) {

                System.out.println(rngm.toString() + " => " + n);

                rngm.init(n);

                double t0 = System.currentTimeMillis();

                float[] hostData = rngm.createRandomSeries(n, n);

                double t1 = System.currentTimeMillis();

                double dt = t1 - t0;

                // System.out.println(rngm.toString() + " => " + dt + " ms ");

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

        MultiChart.setSmallFont();
        MultiChart.open(show, true);

    }

    private static Vector labelVector() {
        Vector<Double> l = new Vector<Double>();
        for(int le : lengths ) {
            l.add((double)le);
        }
        return l;
    }

}
