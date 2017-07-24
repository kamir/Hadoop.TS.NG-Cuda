package de.semanpix.cudatsa.rng;

/**
 * Created by kamir on 25.05.17.
 */
abstract public class RNGModule {

    float[] hostData = null;

    public float[] getRandomSeries() {
        return hostData;
    }

    void init( int n ) {
        // Allocate n floats on host
        hostData = new float[n];
    };

    abstract float[] createRandomSeries( int n, int seed );

}
