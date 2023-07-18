//**********************************************************
// SortDriver.java
// Brice Pieterse
// Driver class for testing various algorithms on the Sorting class
//**********************************************************

import java.util.Arrays;
import java.util.Random;
import java.util.function.Function;


public class SortDriver {

    public static void main(String[] args){

        // Run the script with an arg to do comparison tests (problem set 3)
        if(args.length > 0){

            Integer[][] arraysWith10 = generateArrays(10, 3, false);
            Integer[][] arraysWith10Sorted = generateArrays(10, 3, true);


            Integer[][] arraysWith100 = generateArrays(100, 3, false);
            Integer[][] arraysWith100Sorted = generateArrays(100, 3, true);


            Integer[][] arraysWith1000 = generateArrays(1000, 3, false);
            Integer[][] arraysWith1000Sorted = generateArrays(1000, 3, true);

            
            Function<Integer[], Integer[]>[] methods = createMethodArray(3);


            methods[0] = Sorting::bubbleSort;
            methods[1] = Sorting::bubbleSort2;
            methods[2] = Sorting::shellSort;


            // testing 10s
            for (int i = 0; i < methods.length; i++){
                System.out.println("Sorting the array with 10 unsorted");
                methods[i].apply(arraysWith10[i]);
                System.out.println("Sorting the array with 10 already sorted");
                methods[i].apply(arraysWith10Sorted[i]);
            }


            // testing 100s
            for (int j = 0; j < methods.length; j++){
                System.out.println("Sorting the array with 100 unsorted");
                methods[j].apply(arraysWith100[j]);
                System.out.println("Sorting the array with 100 already sorted");
                methods[j].apply(arraysWith100Sorted[j]);
            }


            // testing 1000s
            for (int k = 0; k < methods.length; k++){
                System.out.println("Sorting the array with 1000 unsorted");
                methods[k].apply(arraysWith1000[k]);
                System.out.println("Sorting the array with 1000 already sorted");
                methods[k].apply(arraysWith1000Sorted[k]);
            }



        } 

        // Else we run general tests (problem sets 1-2)
        else {
            // SHELL SORT METHOD TESTS

            Integer[] original = { 9, 6, 8, 12, 3, 1, 7 };
            Integer[] set1 = { 1, 23, 32, 1, 5, 1, 5, 7, 9, 17 };
            Integer[] set2 = { 12, 62, 19, 46, 294, 2, 3, 33, 1234, 134 };

            System.out.println("Running Shell sort on 3 arrays.");
            Sorting.shellSort(original);
            Sorting.shellSort(set1);
            Sorting.shellSort(set2);


            // BUBBLE SORT METHOD TESTS

            System.out.println("Running bubble sort on already sorted array.");

            //original has been sorted by the shellsort algorithm already
            Sorting.bubbleSort(original);

            System.out.println("Running modified bubble sort on already sorted array.");

            Sorting.bubbleSort2(original);

            Integer[] original2 = { 9, 6, 8, 12, 3, 1, 7 };

            System.out.println("Running bubble sort on a non sorted array.");

            Sorting.bubbleSort(original2);

            Integer[] original3 = { 9, 6, 8, 12, 3, 1, 7 };

            System.out.println("Running modified bubble sort on a non sorted array.");

            Sorting.bubbleSort2(original3);
        }


    }

    // returns sorted or unsorted arrays of Integers for sort testing
    public static Integer[][] generateArrays(int size, int copies, boolean sorted){

        Integer[][] arrays = new Integer[copies][size];
        Random random = new Random();
        Integer nextElement;
        Integer lastElement = 0;

        for (int i = 0; i < size; i++){

            if (sorted){
                nextElement = lastElement + random.nextInt(10);
            } 
            else {
                nextElement = random.nextInt(100);
            }

            for (Integer[] arr : arrays){
                arr[i] = nextElement;
            }

            lastElement = nextElement;

        }

        return arrays;
    }


    @SuppressWarnings("unchecked")
    private static <T> Function<T[], T[]>[] createMethodArray(int size) {
        return (Function<T[], T[]>[]) new Function<?, ?>[size];
    }


}
