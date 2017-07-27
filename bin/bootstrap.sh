#
# install external libraries into the local Maven-repo
#-------------------------------------------------------------------------------
mvn install:install-file -Durl=file:///home/cdsw/demo1/cuda-tsa/lib -Dfile=/home/cdsw/demo1/cuda-tsa/lib/hadoop-ts-core-1.2.4.jar -DgroupId=com.cloudera -DartifactId=hadoop-ts-core -Dpackaging=jar -Dversion=1.2.4

mvn compile exec:java -Dexec.mainClass="connectors.cmtsq.ClouderaManageTSQClient"

mvn compile exec:java -Dexec.mainClass="cudatsa.rng.RNGExperiments"

mvn compile exec:java -Dexec.mainClass="tswb.tsa.generator.ExampleBucketCreator"

