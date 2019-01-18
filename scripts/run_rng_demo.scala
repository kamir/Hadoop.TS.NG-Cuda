import org.ctsp.cuda.tsa.examples.rng.RNGExperiments
import org.ctsp.cuda.tsa.examples.rng.jcurand.JCurandSample


val args = Array("5")
JCurandSample.main( args )



// 1 round
// no chart, only console output
val args = Array("5", "false", "true")
RNGExperiments.main( args )

/*
     GENERATE THE CHART WITH GNUPLOT FROM STORED TIME SERIES BUCKET
 */
  
// Edit the report script:
// =======================
// vi ./scripts/gnuplot/tsbucket_report.plot

// RUN Gnuplot script:
// =======================
// !gnuplot demo1/cuda-tsa/scripts/gnuplot/tsbucket_report.plot