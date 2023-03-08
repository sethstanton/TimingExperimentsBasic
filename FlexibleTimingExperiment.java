package com.company;

import java.util.Arrays;
import java.util.Random;

public class FlexibleTimingExperiment {
    public static void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }
    //bingo sort is an extension of selection sort
    static int bingo;
    static int nextBingo;

    public static void maxMin(int[] arr, int n){
        for(int i = 1; i <n; i++){
            bingo = Math.min(nextBingo, arr[i]);
        }
    }

    public static int[] bingoSort(int[] arr, int n){
        bingo = arr[0];
        nextBingo = arr[0];
        maxMin(arr,n);
        int largestEle = nextBingo;
        int nextElePos = 0;
        while (bingo < nextBingo){
            int startPos = nextElePos;
            for (int i = startPos; i < n; i++){
                if( arr[i] == bingo){
                    int temp = arr[i];
                    arr[i] = arr[nextElePos];
                    arr[nextElePos] = temp;
                    nextElePos = nextElePos + 1;
                }
                else if (arr[i] < nextBingo)
                    nextBingo = arr[i];
            }
            bingo = nextBingo;
            nextBingo = largestEle;
        }
        return arr;
    }

    public static void bubbleSort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n - i - 1; i++)
            for (int j = 0; j < n - i -1; j++)
                if (arr[j] > arr[j+1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }

    public static void insertionSort(int arr[]){
        int n = arr.length;
        for (int i = 1; i < n; ++i){
            int key = arr[i];
            int j = i - 1;
            while( j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j=j-1;
            }
            arr[j+1] = key;
        }
    }

    public static void bogoSort(int arr[]){
        while(isSorted(arr) == false)
            shuffle(arr);
    }
   static void shuffle(int arr[]){
        for (int i = 1; i < arr.length;i++)
            swap(arr,i,(int)(Math.random()*i));
    }
    static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static boolean isSorted(int arr[]){
        for(int i = 1; i < arr.length; i++)
            if (arr[i]< arr[i-1])
                return false;
            return true;
    }

    public static void main(String[] args) {

        // Initialize array size and maximum value of array elements
        int arraySize = 1000;
        int maxValue = 1000;

        // Create an array of random integers
        int[] array = new int[arraySize];
        Random rand = new Random();
        for (int i = 0; i < arraySize; i++) {
            array[i] = rand.nextInt(maxValue);
        }

        // Perform selection sort and measure the time taken
        long startTime = System.nanoTime();
        System.out.println("Unsorted Array " + Arrays.toString(array));
        selectionSort(array);
        //bingoSort(array, 10000);

        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;

        // Print the sorted array and the time taken
        System.out.println("Sorted array: " + Arrays.toString(array));
        System.out.println("Time taken for selection sort: " + elapsedTime + " nanoseconds");

        double elapsedTimeInSecond = (double) elapsedTime / 1000000000;
        System.out.println(elapsedTimeInSecond + " Seconds");
    }


}
