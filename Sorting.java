//**********************************************************
// Sorting.java
// Brice Pieterse
// Class that implements various sorting methods
//**********************************************************
import java.util.Arrays;

public class Sorting {
    
    // implementation of the shellsort algorithm
    public static <T extends Comparable<T>> T[] shellSort(T[] data){

        // Code block to measure execution time
        long startTime = System.currentTimeMillis();

        int gap = data.length/2;
        int comparisons = 0;
        int swaps = 0;

        while(gap > 0){

            boolean swapFlag = true;

            while (swapFlag){

                swapFlag = false;

                for (int s = 0; s < data.length - gap; s++){
                    comparisons++;
                    if(data[s].compareTo(data[s + gap]) > 0){
                        swapFlag = true;
                        swaps++;
                        Sorting.swap(data, s, s + gap);
                    }
                }
            }

            gap = gap / 2; 

        }
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        //System.out.println("Execution time: " + elapsedTime + " milliseconds");
        //System.out.println("ShellSort: total comparisons - " + comparisons + ", total swaps - " + swaps);

        return data;
    }


    public static <T extends Comparable<T>> T[] bubbleSort(T[] data){
        // Code block to measure execution time
        long startTime = System.currentTimeMillis();
        int comparisons = 0;
        int swaps = 0;
        
        for (int position = data.length - 1; position > 0; position--){

            for (int index = 0; index < position; index++){

                comparisons++;
                if(data[index].compareTo(data[index + 1]) > 0){
                    swaps++;
                    Sorting.swap(data, index, index+1);
                }

            }

            System.out.println("Ran a pass in bubble sort");

        }

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        //System.out.println("Execution time: " + elapsedTime + " milliseconds");
        //System.out.println("Bubble sort: total comparisons - " + comparisons + ", total swaps - " + swaps);

        return data;
    }


    // Modified bubble sort to stop when it recognizes the list is sorted
    // no additional passes
    public static <T extends Comparable<T>> T[] bubbleSort2(T[] data){
        // Code block to measure execution time
        long startTime = System.currentTimeMillis();
        boolean swapFlag = true;
        int position = data.length - 1;
        int comparisons = 0;
        int swaps = 0;

        while(position > 0 && swapFlag){

            swapFlag = false;

            for (int index = 0; index < position; index++){
                comparisons++;
                if(data[index].compareTo(data[index + 1]) > 0){
                    swaps++;
                    swapFlag = true;
                    Sorting.swap(data, index, index+1);
                }

            }

            System.out.println("Ran a pass in modified bubble sort");

            position--;

        }

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        //System.out.println("Execution time: " + elapsedTime + " milliseconds");
        //System.out.println("Modified bubble sort: total comparisons - " + comparisons + ", total swaps - " + swaps);

        return data;
    }


    public static <T extends Comparable<T>> void swap(T[] data, int p1, int p2){
        T temp = data[p1];
        data[p1] = data[p2];
        data[p2] = temp;
        System.out.println("Swap occured: " + Arrays.toString(data));
    }

}
