import jcurand.samples.JCurandSample
val args = Array("1")
JCurandSample.main( args )


  
  
import cudatsa.rng.RNGExperiments
// 1 round
// no chart, only console output
val args = Array("1", "false", "true")
RNGExperiments.main( args )
