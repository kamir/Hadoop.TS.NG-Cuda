package connectors.opentsdb;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by kamir on 24.06.17.
 *
 * https://hc.apache.org/httpcomponents-client-ga/examples.html
 *
 * Simple example for data ingestion to OpenTSDB using the REST-API.
 *
 */
public class OpenTSDBConnector {

    public static final String VARIABLE_TEMPLATE_METRIC = "___METRIC___";
    public static final String VARIABLE_TEMPLATE_VALUE = "___VALUE___";
    public static final String VARIABLE_TEMPLATE_TS = "___TS___";
    public static final String VARIABLE_TEMPLATE_TAG_KEY = "___TAG_KEY___";
    public static final String VARIABLE_TEMPLATE_TAG_VALUE = "___TAG_VALUE___";

    public static void main( String[] args) throws Exception {

        String template = initTSToSend();

        long t0 = System.currentTimeMillis();

        // URL url = new URL("http://cdsw-mk8-1.vpc.cloudera.com:4343/api/put");
        URL url = new URL("http://127.0.0.1:4242/api/put");


        // TODO : Write Benchmark

        // THE BULK LOAD IS NOT WORKING
        int i = 0;
        while ( i < 10 ) {

            HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
            httpCon.setDoOutput(true);
            httpCon.setRequestMethod("POST");

            OutputStreamWriter out = new OutputStreamWriter( httpCon.getOutputStream() );

            i++;

            OpenTSDBEvent e = new OpenTSDBEvent();
            e.metric = "sys.cpu.idle";
            e.tags.put( "server", "2");
            e.tags.put( "rack", "1");
            e.tags.put( "ds", "1");
            e.timestamp = "" + (t0 + (i*1000));
            e.value = (Math.random() * 5009) + "";

            String pl = e.toJSON();

            System.out.println( pl );

            out.write( pl );

            out.close();
            InputStream ins = httpCon.getInputStream();
            BufferedReader bins = new BufferedReader( new InputStreamReader(ins) );

            while( bins.ready() )
                System.out.println( bins.readLine() );

        }



    }

    private static String initTSToSend() {

        String s = null;

        try {

            s = new String(Files.readAllBytes(Paths.get( "/GITHUB/cuda-tsa/src/main/resources/datapoint")));
            System.out.println( s );

            System.out.println( "\n***************************************************" );


        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return s;

    }
}
