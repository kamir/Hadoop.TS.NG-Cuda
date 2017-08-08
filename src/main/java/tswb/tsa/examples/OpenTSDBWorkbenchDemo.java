package tswb.tsa.examples;


import connectors.opentsdb.OpenTSDBClient;
import org.apache.hadoopts.data.series.Messreihe;
import org.apache.hadoopts.hadoopts.buckets.generator.TSBucketCreator_Sinus;
import org.apache.hadoopts.hadoopts.core.TSBucket;

import java.io.File;
import java.util.Vector;

/**
 * Created by kamir on 05.08.17.
 */
public class OpenTSDBWorkbenchDemo {

    public static void main(String[] ARGS) throws Exception {

        /**
         * needed for working with Hadoop XML-Properties files.
         */
        System.setProperty("javax.xml.parsers.DocumentBuilderFactory", "com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl");


        // Creata a TSBucket and store on disc / HDFS


        ARGS = new String[1];
        ARGS[0] = "sine-wave-bucket";

        TSBucketCreator_Sinus.main( ARGS );



        // Load a bucket from disc ... and put it into OpenTSDB

        TSBucket bucket = TSBucket.createEmptyBucket();
        bucket.setInMemory(true);
        
        bucket.loadFromSequenceFile( new File( "tstest/sine-wave-bucketabucket.ts.seq_sinus_.tsb.vec.seq")  );







        // PROCESSING IS STILL EMPTY ...
        // final TSBucket tsBucket = bucket.processBucket( "peak filter", new SingleTsPeakFilterTool() );


        int i = 0;
        Vector<Messreihe> rows = bucket.getBucketData();
        for( Messreihe r : rows ) {
            i++;
            r.setLabel( "demo2 distr=sine,id=" + i );
        }

        //
        // Naive approach on an edge-node using one OpenTSDB API
        //
        OpenTSDBClient client = OpenTSDBClient.getClient();
        client.storeBucketData( rows , System.currentTimeMillis() );



        //
        // Distributed approach on multiple chodesn nodes
        //
        OpenTSDBClient client1 = OpenTSDBClient.getClient( "cc-poc-mk-1.gce.cloudera.com" );
        OpenTSDBClient client2 = OpenTSDBClient.getClient( "cc-poc-mk-2.gce.cloudera.com" );
        OpenTSDBClient client3 = OpenTSDBClient.getClient( "cc-poc-mk-3.gce.cloudera.com" );
        OpenTSDBClient client4 = OpenTSDBClient.getClient( "cc-poc-mk-4.gce.cloudera.com" );



        i = 0;
        bucket.loadFromSequenceFile( new File( "tstest/sine-wave-bucketabucket.ts.seq_sinus_.tsb.vec.seq")  );
        Vector<Messreihe> rowsA = (Vector<Messreihe>) bucket.getBucketData();
        for( Messreihe r : rowsA ) {
            i++;
            r.setLabel( "demoA c=1,id=" + i );
        }


        i = 0;
        bucket.loadFromSequenceFile( new File( "tstest/sine-wave-bucketabucket.ts.seq_sinus_.tsb.vec.seq")  );
        Vector<Messreihe> rowsB = (Vector<Messreihe>) bucket.getBucketData();
        for( Messreihe r : rowsB ) {
            i++;
            r.setLabel( "demoA c=2,id=" + i );
        }

        i = 0;
        bucket.loadFromSequenceFile( new File( "tstest/sine-wave-bucketabucket.ts.seq_sinus_.tsb.vec.seq")  );
        Vector<Messreihe> rowsC = (Vector<Messreihe>) bucket.getBucketData();
        for( Messreihe r : rowsC ) {
            i++;
            r.setLabel( "demoA c=3,id=" + i );
        }

        i = 0;
        bucket.loadFromSequenceFile( new File( "tstest/sine-wave-bucketabucket.ts.seq_sinus_.tsb.vec.seq")  );
        Vector<Messreihe> rowsD = (Vector<Messreihe>) bucket.getBucketData();
        for( Messreihe r : rowsD ) {
            i++;
            r.setLabel( "demoA c=4,id=" + i );
        }

        long t0 = System.currentTimeMillis();

        client1.storeBucketData( rowsA, t0 );

        client2.storeBucketData( rowsB, t0 );

        client3.storeBucketData( rowsC, t0 );

        client4.storeBucketData( rowsD, t0 );











        //
        // parallel approach using the RDD with TimeSeries in Spark ...
        //



    }
}
