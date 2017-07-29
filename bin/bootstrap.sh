#
# install external libraries into the local Maven-repo
#-------------------------------------------------------------------------------

export HADOOP_TS_VERSION=1.2.5
mvn install:install-file -Durl=file:///home/cdsw/demo1/cuda-tsa/lib -Dfile=/home/cdsw/demo1/cuda-tsa/lib/hadoop-ts-core-$HADOOP_TS_VERSION.jar -DgroupId=com.cloudera -DartifactId=hadoop-ts-core -Dpackaging=jar -Dversion=$HADOOP_TS_VERSION

mvn compile exec:java -Dexec.mainClass="connectors.cmtsq.ClouderaManageTSQClient"

#mvn compile exec:java -Dexec.mainClass="cudatsa.rng.RNGExperiments"

#mvn compile exec:java -Dexec.mainClass="tswb.tsa.generator.ExampleBucketCreator"

