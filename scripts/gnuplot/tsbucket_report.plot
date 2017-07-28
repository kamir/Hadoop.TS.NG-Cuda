OUTPUT_FILE="/GITHUB/cuda-tsa/out/plot.png"

INPUT_FOLDER="out/rng_report_1501260382077"
INPUT_FOLDER_LABEL="out/rng-report-1501260382077"

DATA_FILE="/GITHUB/cuda-tsa/".INPUT_FOLDER."/tab_rng.dat"



set terminal png
set output "".OUTPUT_FILE

set datafile separator "\t"



#set title "TSBucket Report in Semi-log scaling : ".INPUT_FOLDER_LABEL." (NO CUDA)"
set title INPUT_FOLDER_LABEL." (NO CUDA)"

set grid
set autoscale

#set logscale y
#set logscale x

set ylabel "creation time [ms]"
set xlabel "# of random number"

# 3 rows
plot DATA_FILE using 1:2 with lines title "Commons Math R", DATA_FILE using 3:4 with lines title "Commons Math S", DATA_FILE using 5:($6 * 1) with lines title "java.util.Random"

# 4 rows
#plot DATA_FILE using 1:2 with lines title "JCuda", DATA_FILE using 3:4 with lines title "Commons Math R", DATA_FILE using 5:($6 * 1) with lines title "Commons Math S", DATA_FILE using 7:8 with lines title "java.util.Random"
