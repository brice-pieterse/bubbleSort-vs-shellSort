
# Shell Sort vs. Bubble Sort vs. Modified Bubble Sort

## Description

The goal of this project is used to experiment with Bubble Sort (common), Bubble Sort (modified), and ShellSort algorithms.


## Usage

Comment back in any output logs you'd like to see.

Run ```java SortDriver``` to run some basic tests.

Run ```java SortDriver arg``` to run more in-depth tests on unsorted and already sorted arrays of 10, 100, and 1000 elements.


## Findings

NOTE: Each time the program is run, new sorted and unsorted data arrays will be created so these results may vary. The following is a log of the results for one particular run of the program. Copies of the same sorted and unsorted arrays are used to compare the effeciency of the algorithms (For example, each of the three algorithms will be tested with the same 10 item unsorted array).

The project collected the following data for unsorted arrays of 10, 100, and 1000 elements:

| Algo                    | Data                           | Comparisons    | Swaps     | Exec. Time (ms)    |
|-------------------------|--------------------------------|----------------|-----------|--------------------|
| Bubble sort             | 10 item (unsorted)             | 45             | 31        | 0                  |
| Modified Bubble sort    | 10 item (unsorted)             | 44             | 31        | 0                  |
| ShellSort               | 10 item (unsorted)             | 44             | 10        | 0                  |
| Bubble sort             | 100 item (unsorted)            | 4950           | 2256      | 0                  |
| Modified Bubble sort    | 100 item (unsorted)            | 4929           | 2256      | 0                  |
| ShellSort               | 100 item (unsorted)            | 2517           | 382       | 0                  |
| Bubble sort             | 1000 item (unsorted)           | 499500         | 244144    | 8                  |
| Modified Bubble sort    | 1000 item (unsorted)           | 495495         | 244144    | 7                  |
| ShellSort               | 1000 item (unsorted)           | 57642          | 5518      | 2                  |




The project collected the following data for already sorted arrays of 10, 100, and 1000 elements:


| Algo                    | Data                           | Comparisons    | Swaps     | Exec. Time    |
|-------------------------|--------------------------------|----------------|-----------|---------------|
| Bubble sort             | 10 item (already sorted)       | 45             | 0         | 0             |
| Modified Bubble sort    | 10 item (already sorted)       | 9              | 0         | 0             |
| ShellSort               | 10 item (already sorted)       | 22             | 0         | 0             |
| Bubble sort             | 100 item (already sorted)      | 4950           | 0         | 0             |
| Modified Bubble sort    | 100 item (already sorted)      | 99             | 0         | 0             |
| ShellSort               | 100 item (already sorted)      | 503            | 0         | 0             |
| Bubble sort             | 1000 item (already sorted)     | 499500         | 0         | 2             |
| Modified Bubble sort    | 1000 item (already sorted)     | 999            | 0         | 0             |
| ShellSort               | 1000 item (already sorted)     | 8006           | 0         | 0             |



## Connecting the data to the Theory


### Bubble sort vs Modified Bubble sort

The Modified bubble sort algorithm introduces a boolean flag. If a complete pass is made without any swaps, it follows that every element is less than its adjacent element, thus the entire array is already sorted. For a 10 item array, we see this leads to only 9 comparisons. Using the common bubble sort, however, we don't get the luxury of knowing if any swaps were made or not. This means we'll need to run 8 more passes, with one less comparison each time. Even in cases where the array is unsorted, we'll often see less comparisons with the modified bubble sort than a common bubble sort (since later passes can often be emitted as we realize the array is already sorted completely) and so it is preferred.

In terms of time complexity, we consider worst case scenario. For both the modified bubble sort and common bubble sort, we use two nested loops. The top-level loop will run n times for an n-item array, which is a linear function. The inner loop will compare adjacent elements, starting with (n-1) comparisons for the first pass and removing a comparison for each subsequent pass. Since the numbers of items being removed on each pass can be represented by a linear function, the number of times the inner loop runs is a linear function (a linear function - another linear function is still a linear function). Therefore the combined complexity of the algorithms is the same, O(n^2).

The data collected in our experiment supports these findings. Plotting (10, 45), (100, 4950), and (1000, 499500), quadratic growth becomes apparent.


### Shellsort

Shellsort was an interesting algorithm to explore. It combines 3 loops to sort an array of comparable objects. We define a gap size to be half the array size, and the top level loop with run so long as this gap size remains greater than 0 as we decrease its size by half each iteration (due to Java's fractional truncations, we can be sure this will happen. In other languages, we may need to be more careful.). The inner loops will combine to run a sort of bubble sort on the array, comparing elements but only those separated by gap size, with several passes if needed to ensure the elements separated by gap size have all been sorted.

Deriving the complexity of Shellsort is difficult, but it's commonly accepted to have an average case scenario of O(n ^ 4/3). My attempt at reasoning about it is as follows: 

- The upper level loop is O(log^2 n) since if we have n elements we want x such that 2^x = n. That x is log^2 n.
- The first inner loop will take care of running several passes if needed to ensure those elements separated by gap size have been sorted. This where it gets difficult to analyze, since the number of comparisons will increase due to a smaller gap size, but also decrease due to elements having already been sorted on previous gap sizes.
- The final loop will take care of comparisons. If we suppose only a single pass was needed in the loop above, total comparisons made will be a geometric sequence:  2 + 4 + 8 + ... + (n-1) = 2 * (n - 1) which is linear. This is O(n). Again, this is only best case scenario.

The algorithm will be less performant than O(n log^2 n) but possibly more performant than O(n^2).

By examining the results of our experiment, this is in fact true. Shell sort beats bubble sort on unsorted arrays of 10, 100, and 1000 elements. This becomes very apparent in the 1000 element case, where shell sorts comparisons were dramatically less.

This would suggest Shellsort will have better results than algorithms like bubble sort, but likely poorer results than O(n log^2 n) algorithms like merge sort.
