# This script starts a local spark-shell on Mirko's MacBook
#
# Relevant JAR files from related projects are added to the Spark-Context
# A custom spark-configuration file is used as CDSW would do.
#

#
# Here I develop the Metadata capturing module for an advanced data governance system
# using Cloudera Navigator, and an additional SOLR collection.
#



export SPARK_LOCAL_IP="127.0.0.1"
export SOLR_HOST="127.0.0.1"
export ZK_HOST="127.0.0.1"
export SPARK_CONFIG="/GITHUB/cuda-tsa/spark-defaults.conf"

#
# ADD JAR File for dspm-toolkit to the Spark-Shell
#
#  Hadoop.TS: 						hts-training-exercises-0.3-jar-with-dependencies.jar
#  Spark convenience tools:  		SparkShellUtilities.jar
#  Gephi-Toolkit for local raphs:  	gephi-toolkit-0.9.2-20170113.202843-77-all.jar"
#  ETOSHA-Network-Profile:
export JARS="--jars /GITHUB/cuda-tsa/hadoop-ts-core-1.2.5.jar,/GITHUB/SparkShellUtilities/out/artifacts/s2u_jar/s2u.jar,/sparkws/bin/gephi-toolkit-0.9.2-20170113.202843-77-all.jar"




#
# Clean Artifacts created by InteliJ
#
#zip -d /GITHUB/claerity-cloudera/XWARE42/shop-crawl/out/artifacts/any23_extractor_tool_jar/any23-extractor-tool.jar META-INF/*.RSA META-INF/*.DSA META-INF/*.SF
#zip -d cuda-ts.jar META-INF/*.RSA META-INF/*.DSA META-INF/*.SF


#
# !!! Warning !!!
#
#
#  This caused a problem with Hive-Metastore ... !!!
#
#/GITHUB/HadoopTS.3/GITHUB/hts-training-exercises/target/hts-training-exercises-0.3-jar-with-dependencies.jar,



#
# Where did we start the shell?
#
pwd
ls



#
# You can use * for import all jars into a folder when adding in conf/spark-defaults.conf .
#
#spark.driver.extraClassPath /fullpath/*
#spark.executor.extraClassPath /fullpath/*

#
# Add missing JAR
#
#    For any23 we have to provide the ASM Jar in Version 3.2
#
#mvn install:install-file -Dfile=asm-3.2.jar -DgroupId=asm -DartifactId=asm -Dversion=3.2 -Dpackaging=jar


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
#    Copy a schema.xml to Zookeeper
#
# solr zk cp file:/GITHUB/claerity-cloudera/XWARE42/apache-solr-6.5.0/server/solr/shop_crawl/conf/schema.xml zk:/configs/shopCrawl/schema.xml -z localhost:9983


#
# SOLR in cloud modus
#
#start -c -m 1g -z localhost:2181 -a "-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=1044"

#
# Run Spark 1.6.3 ...
#
#/Users/kamir/Downloads/spark-1.6.3-bin-hadoop2.6/bin/spark-shell --master local[4] $JARS
#


cd /GITHUB/cuda-tsa
mvn clean compile install
cp /GITHUB/cuda-tsa/target/cuda-tsa-0.1.0-SNAPSHOT-jar-with-dependencies.jar /GITHUB/cuda-tsa/bin/all.jar

#----------------------
# Goto Spark 2.2.0 ...
#----------------------
#echo $SPARK_CONFIG
cp $SPARK_CONFIG /Users/kamir/Downloads/spark-2.2.0-bin-hadoop2.6/conf/spark-defaults.conf
#cat /Users/kamir/Downloads/spark-2.2.0-bin-hadoop2.6/conf/spark-defaults.conf
/Users/kamir/Downloads/spark-2.2.0-bin-hadoop2.6/bin/spark-shell --master local[4] $JARS --repositories http://maven.restlet.org,http://bits.netbeans.org/maven2/,https://oss.sonatype.org/content/repositories/snapshots/,https://mvnrepository.com/artifact/asm/asm

