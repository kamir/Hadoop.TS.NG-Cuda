#!/usr/bin/env bash

# This script starts a local spark-shell on Mirko's MacBook.
#
# Relevant JAR files from related projects are added to the Spark-shell session.
# A custom spark-configuration file is used in the same way like CDSW would do.
#



#
# REBUILD VIA MAVEN ....
#
#cd /GITHUB/Hadoop.TS.NG
#mvn clean compile install
#
#cd /GITHUB/cuda-tsa
# mvn clean compile package install



cd /GITHUB/cuda-tsa/scripts



ls
pwd



export SPARK_LOCAL_IP="127.0.0.1"
export SOLR_HOST="127.0.0.1"
export ZK_HOST="127.0.0.1"
export SPARK_CONFIG="/GITHUB/cuda-tsa/spark-defaults.conf"



#
# ADD JAR File for dspm-toolkit to the Spark-Shell
#
#  Spark convenience tools:  		SparkShellUtilities.jar
export JARS="--jars /GITHUB/cuda-tsa/dist/cuda-tsa.jar,/GITHUB/Hadoop.TS.NG/target/hadoop-ts-ng-2.3.0-jar-with-dependencies.jar"



#
# Clean Artifacts created by InteliJ
#
zip -d /GITHUB/cuda-tsa/dist/cuda-tsa.jar META-INF/*.RSA META-INF/*.DSA META-INF/*.SF
zip -d /GITHUB/Hadoop.TS.NG/target/hadoop-ts-ng-2.3.0-jar-with-dependencies.jar META-INF/*.RSA META-INF/*.DSA META-INF/*.SF



#
# Peparation of the SOLR Server
#
#    Start the SOLR Server:
#
echo
echo Start SOLR with this line:
echo --------------------------
echo /GITHUB/claerity-cloudera/XWARE42/apache-solr-6.5.0/bin/solr start -cloud -p 8983 -s "/GITHUB/claerity-cloudera/XWARE42/apache-solr-6.5.0/example/cloud/node1/solr"
echo



#
# Run Spark 1.6.3 ...
#
#/Users/kamir/Downloads/spark-1.6.3-bin-hadoop2.6/bin/spark-shell --master local[4] $JARS
#



#----------------------
# Goto Spark 2.2.0 ...
#----------------------
echo $SPARK_CONFIG
cp $SPARK_CONFIG /Users/kamir/Downloads/spark-2.2.0-bin-hadoop2.6/conf/spark-defaults.conf
cat /Users/kamir/Downloads/spark-2.2.0-bin-hadoop2.6/conf/spark-defaults.conf
/Users/kamir/Downloads/spark-2.2.0-bin-hadoop2.6/bin/spark-shell --master local[4] $JARS --repositories http://maven.restlet.org,http://bits.netbeans.org/maven2/,https://oss.sonatype.org/content/repositories/snapshots/,https://mvnrepository.com/artifact/asm/asm

