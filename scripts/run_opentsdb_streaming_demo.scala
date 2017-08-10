import connectors.opentsdb.OpenTSDBConnector


val data = Array(1, 2, 3, 4, 5)

val distData = sc.parallelize(data)

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




