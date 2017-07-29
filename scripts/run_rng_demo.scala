import jcurand.samples.JCurandSample
val args = Array("5")
JCurandSample.main( args )


  
  
import cudatsa.rng.RNGExperiments
// 1 round
// no chart, only console output
val args = Array("5", "false", "true")
RNGExperiments.main( args )
  
  

  
# Edit the report script:
#==============
# vi demo1/cuda-tsa/scripts/gnuplot/tsbucket_report.plot

# RUN Gnuplot script:
#==============
#!gnuplot demo1/cuda-tsa/scripts/gnuplot/tsbucket_report.plot