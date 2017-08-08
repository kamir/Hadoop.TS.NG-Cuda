package tsa.rng;

import jcuda.Pointer;
import jcuda.Sizeof;
import jcuda.jcurand.JCurand;
import jcuda.jcurand.curandGenerator;
import jcuda.runtime.JCuda;

import static jcuda.jcurand.JCurand.*;
import static jcuda.jcurand.curandRngType.CURAND_RNG_PSEUDO_DEFAULT;
import static jcuda.runtime.JCuda.*;
import static jcuda.runtime.cudaMemcpyKind.cudaMemcpyDeviceToHost;

/**
 * Created by kamir on 25.05.17.
 */
public class RNGModuleCUDA extends RNGModule {

    public void init( int n ) {

        super.init( n );

    }

    @Override
    public float[] createRandomSeries(int n, int seed) {

        // Enable exceptions and omit all subsequent error checks
        JCuda.setExceptionsEnabled(true);
        JCurand.setExceptionsEnabled(true);

        curandGenerator generator = new curandGenerator();

        // Allocate n floats on device
        Pointer deviceData = new Pointer();
        cudaMalloc(deviceData, n * Sizeof.FLOAT);

        // Create pseudo-random number generator
        curandCreateGenerator(generator, CURAND_RNG_PSEUDO_DEFAULT);

        // Set seed
        curandSetPseudoRandomGeneratorSeed(generator, seed);

        // Generate n floats on device
        curandGenerateUniform(generator, deviceData, n);

        // Copy device memory to host
        cudaMemcpy(Pointer.to(hostData), deviceData,
                n * Sizeof.FLOAT, cudaMemcpyDeviceToHost);

        // Cleanup
        curandDestroyGenerator(generator);
        cudaFree(deviceData);

        return hostData;
    }
}
