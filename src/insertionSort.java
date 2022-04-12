import java.util.Arrays;

public class insertionSort {
    public static void main(String[] args) {
        int[] arr = new int [5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (arr.length + 1));}
        System.out.println(Arrays.toString(arr));
    }
        void sort(int[] arr){
        for(int i=1; i<arr.length-1; i++){
            int temp = arr[i];
            int j= i-1;
            while(j>=0 && temp <= arr[j]){
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = temp;
        }
    }
}



