import java.util.Arrays;
import java.util.Scanner;

public class Testing2 {

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        boolean showArr = true;
        boolean allArr = true;
        boolean specificArr = true;
        int arrNum = 0;
        System.out.println("""
                I will sort random integer arrays using a mergesort function and an insertion sort function.
                Then I will compare which function sorted the arrays faster.\s
                Before I do that, you can determine some factors.""");
        System.out.println("How many indexes do you want your array to have?");
        int x = input.nextInt();

        System.out.println("\nHow many arrays do you want to be sorted");
        int y = input.nextInt();

        System.out.println("Do you want to see the sorted arrays before and after they are sorted? (Yes or No) \n" +
                "If you do not put yes then I won't show the sorted arrays");
        String see = input.nextLine();
        if (see.equalsIgnoreCase("yes")) {
            showArr = true;
        } else {
            showArr = false;
            allArr = false;
            specificArr = false;
            arrNum = 0;
        }

        if (showArr) {
            System.out.println("You gave me the amount of arrays you want to be sorted. \n" +
                    "do you want me to show a specific array or all arrays? (specific or all) \n (ex: you asked for 10 arrays to be sorted" +
                    " and you wanted to see the fifth array before and after it was sorted)");
            String specific = input.nextLine();
            if (specific.equalsIgnoreCase("specific")) {
                specificArr = true;
            } else if (specific.equalsIgnoreCase("all")) {
                allArr = true;
                specificArr = false;
                arrNum = 0;
            } else {
                allArr = false;
                specificArr = false;
                arrNum = 0;
            }
            if (specificArr) {
                allArr = false;
                System.out.println("What array number do you want to see");
                arrNum = input.nextInt();
            }
        }
        calculator(x,y,showArr,specificArr,allArr,arrNum);
    }
    public static void calculator (int x, int y, boolean showArr, boolean specificArr,
                                   boolean allArr, int arrNum) {
        insertionSort object2 = new insertionSort();
        MergeSort object = new MergeSort();

        long totalInsertionSortExecutionTime = 0;
        long totalMergeSortExecutionTime = 0;

        int[] arr = new int[x];
        for (int j = 0; j < y; j++) {
            arrRandomize(arr);
            int[] arr2 = Arrays.copyOf(arr, x);

            long startTimeMerge = System.nanoTime();
            object.sort(arr, 0, arr.length - 1);
            long endTimeMerge = System.nanoTime();
            long executionTimeMerge = endTimeMerge - startTimeMerge;

            long startTimeInsertion = System.nanoTime();
            object2.sort(arr2);
            long endTimeInsertion = System.nanoTime();
            long executionTimeInsertion = endTimeInsertion - startTimeInsertion;

            if (showArr) {
                if (allArr) {
                    System.out.println(Arrays.toString(arr));
                }
                if (specificArr) {
                    if (j == arrNum) {
                        System.out.println(Arrays.toString(arr));
                    }
                }
            }


            totalMergeSortExecutionTime = totalMergeSortExecutionTime + executionTimeMerge;
            totalInsertionSortExecutionTime = totalInsertionSortExecutionTime + executionTimeInsertion;
        }

        long avgMergeSortExecutionTime =  totalMergeSortExecutionTime/y;
        long avgInsertionSortExecutionTime = totalInsertionSortExecutionTime/y;
        //avg time it takes to sort the array in nanoseconds using mergesort
        //System.out.println(avgMergeSortExecutionTime);
        System.out.println(avgInsertionSortExecutionTime);
        System.out.println(avgMergeSortExecutionTime);
    }
    public static void arrRandomize(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * arr.length + 1);
        }
    }
}