#
# install external libraries into the local mvn-repo
#-------------------------------------------------------------------------------
mvn install:install-file -Durl=file:///home/cdsw/demo1/lib -Dfile=/home/cdsw/demo1/lib/hadoop-ts-core-1.2.4.jar -DgroupId=com.cloudera -DartifactId=hadoop-ts-core -Dpackaging=jar -Dversion=1.2.4

