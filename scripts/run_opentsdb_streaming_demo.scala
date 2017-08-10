import connectors.opentsdb.OpenTSDBConnector
import sun.security.util.SignatureFileVerifier


val data = Array(1, 2, 3, 4, 5)

val distData = sc.parallelize(data)



#
#
#
# >  val connector = new OpenTSDBConnector
# java.lang.SecurityException: no manifiest section for signature file entry org/bouncycastle/jce/provider/JDKMessageDigest$RIPEMD256.class
# at sun.security.util.SignatureFileVerifier.verifySection(SignatureFileVerifier.java:440)
# at sun.security.util.SignatureFileVerifier.processImpl(SignatureFileVerifier.java:295)
# at sun.security.util.SignatureFileVerifier.process(SignatureFileVerifier.java:238)
#
#
#



distData.mapPartitionsWithIndex{
                     // 'index' represents the Partition No
                     // 'iterator' to iterate through all elements
                     //                         in the partition
                     (index, iterator) => {
                          println("Called in Partition -> " + index)
                          val myList = iterator.toList

                          val connector = new OpenTSDBConnector
                          connector.openSocket()



                          // In a normal user case, we will do the
                          // the initialization(ex : initializing database)
                          // before iterating through each element
                          myList.map(x => x + " -> " + index).iterator

                          connector.close()

                     }
                  }




