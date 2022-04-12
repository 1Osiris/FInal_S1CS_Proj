//Julian Matthews Final ICS project. Find which sorting method is faster under certain circumstances 12/16/2021
import java.util.Arrays;
public class CalcUp {

    void calculator (int x, double y) {

        insertionSort object2 = new insertionSort();
        MergeSort object = new MergeSort();
        long totalInsertionSortExecutionTime = 0;
        long totalMergeSortExecutionTime = 0;

        for (int j = 0; j < y; j++) {
            int[] arr = new int[x];
            arrRandomize(arr);

            int[] arr2 = Arrays.copyOf(arr, x);
            System.out.println("Original array: " + Arrays.toString(arr));
            long startTimeMerge = System.nanoTime();
            object.sort(arr, 0, arr.length - 1);
            long endTimeMerge = System.nanoTime();
            long executionTimeMerge = endTimeMerge - startTimeMerge;

            long startTimeInsertion = System.nanoTime();
            object2.sort(arr2);
            long endTimeInsertion = System.nanoTime();
            long executionTimeInsertion = endTimeInsertion - startTimeInsertion;
            System.out.println("Sorted array:   " + Arrays.toString(arr));
            totalMergeSortExecutionTime = totalMergeSortExecutionTime + executionTimeMerge;
            totalInsertionSortExecutionTime = totalInsertionSortExecutionTime + executionTimeInsertion;
        }

        double avgMergeSortExecutionTime =  totalMergeSortExecutionTime/y;
        double avgInsertionSortExecutionTime = totalInsertionSortExecutionTime/y;
        //avg time it takes to sort the array in nanoseconds using mergesort

        System.out.println("the average time it took for the insertion method to " +
                "execute was  " + avgInsertionSortExecutionTime + " nanoseconds" );
        System.out.println("the average time it took for the mergesort method to " +
                "execute was  " + avgMergeSortExecutionTime + " nanoseconds" );
        if (avgInsertionSortExecutionTime > avgMergeSortExecutionTime) {
            System.out.println("on average, the mergesort method was about " +
                    ((100*((avgInsertionSortExecutionTime / avgMergeSortExecutionTime)))-100)
                    + "% faster");
        } else if (avgMergeSortExecutionTime > avgInsertionSortExecutionTime) {
            System.out.println("on average, the insertion method was about " +
                    ((100*((avgMergeSortExecutionTime / avgInsertionSortExecutionTime)))-100)
                    + "% faster");
        }
        for (double z = 0.2; z < 1.0; z+= 0.2) {
            long totalInsertionSortExecutionTime0 = 0;
            long totalMergeSortExecutionTime0 = 0;

            for (int j = 0; j < y; j++) {
                int[] arr = new int[x];
                arrRandomize(arr);

                for (int n = 0; n < (int)(x*z); n++) {
                    arr[n] = 0;
                }
                int[] arr2 = Arrays.copyOf(arr, x);
                System.out.println("Original array: " + Arrays.toString(arr));
                long startTimeMerge = System.nanoTime();
                object.sort(arr, 0, arr.length - 1);
                long endTimeMerge = System.nanoTime();
                long executionTimeMerge = endTimeMerge - startTimeMerge;

                long startTimeInsertion = System.nanoTime();
                object2.sort(arr2);
                long endTimeInsertion = System.nanoTime();
                long executionTimeInsertion = endTimeInsertion - startTimeInsertion;
                System.out.println("Sorted array:   " + Arrays.toString(arr));
                totalMergeSortExecutionTime0 = totalMergeSortExecutionTime0 + executionTimeMerge;
                totalInsertionSortExecutionTime0 = totalInsertionSortExecutionTime0 + executionTimeInsertion;
            }
            double avgMergeSortExecutionTime0 = totalMergeSortExecutionTime0/y;
            double avgInsertionSortExecutionTime0 = totalInsertionSortExecutionTime0/y;

            System.out.println("When the array was " + ((int)(z * 100)) + "% filled,the " +
                    "average time it took for the insertion method to " +
                    "execute was  " + avgInsertionSortExecutionTime0 + " nanoseconds" );
            System.out.println("When the array was " + ((int)(z * 100)) + "% filled, the " +
                    "average time time it took for the mergesort method to " +
                    "execute was  " + avgMergeSortExecutionTime0 + " nanoseconds" );
            if (avgInsertionSortExecutionTime0 > avgMergeSortExecutionTime0) {
                System.out.println("on average, when the array is " + ((int)(z * 100)) + "% filled, the " +
                        "mergesort method was about " +
                        (100*((avgInsertionSortExecutionTime0 / avgMergeSortExecutionTime0))-100)
                        + "% faster");
            } else if (avgMergeSortExecutionTime0 > avgInsertionSortExecutionTime0) {
                System.out.println("on average, when the array is " + ((int)(z * 100)) + "% filled, " +
                        "the insertion method was about " +
                        (100*((avgMergeSortExecutionTime0 / avgInsertionSortExecutionTime0))-100)
                        + "% faster");
            }
        }
    }
    public static void arrRandomize(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] =  (int)Math.ceil((Math.random() * (arr.length + 1)));
        }
    }
}
