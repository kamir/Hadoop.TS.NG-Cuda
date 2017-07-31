#
# install external libraries into a local Maven-repository
#-------------------------------------------------------------------------------

export HADOOP_TS_VERSION=1.2.5

mvn install:install-file -Durl=file:///home/cdsw/demo1/cuda-tsa/lib -Dfile=/home/cdsw/demo1/cuda-tsa/lib/hadoop-ts-core-$HADOOP_TS_VERSION.jar -DgroupId=com.cloudera -DartifactId=hadoop-ts-core -Dpackaging=jar -Dversion=$HADOOP_TS_VERSION

mvn clean compile package install

cp target/cuda-tsa-0.2.0-SNAPSHOT-jar-with-dependencies.jar lib/cuda-tsa-0.2.jar


