#
# This script prepares the CUDA-TSA library in a running docker container.
#

#-------------------------------------------------------------------------------
# install external libraries into a local Maven-repository
#-------------------------------------------------------------------------------

export HADOOP_TS_NG_VERSION=2.5.0
export HADOOP_TS_NG_CUDA_VERSION=0.2.0

#
#
#
mvn install:install-file -Durl=file:///home/cdsw/demo1/cuda-tsa/lib -Dfile=/home/cdsw/demo1/cuda-tsa/lib/hadoop-ts-core-$HADOOP_TS_VERSION.jar -DgroupId=com.cloudera -DartifactId=hadoop-ts-core -Dpackaging=jar -Dversion=$HADOOP_TS_VERSION

#
#
#
mvn clean compile package install

cp target/cuda-tsa-$HADOOP_TS_NG_CUDA_VERSION-SNAPSHOT-jar-with-dependencies.jar lib/cuda-tsa-$HADOOP_TS_NG_CUDA_VERSION.jar


