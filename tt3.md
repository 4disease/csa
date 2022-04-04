## Sorts

### Insertion Sort

```java
static void insertionSort(int arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
```
Insertion sort is another linear algorithm that sorts elements from index [0] to index [n-1]. In the inner loop of this algorithm, it find the gap, insertion point for the next item and inserts it. Each inner loop leave the list partially sorted according to outer loops index.

### Bubble Sort

```java
public static void bubbleSort(int arr[]) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
```
Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in wrong order.

### Selection Sort
```java
public static void selectionSort(int arr[]) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            int mindex = i;
            for (int j = i+1; j < len; j++) {
                mindex = j;
            }
            int temp = arr[mindex];
            arr[mindex] = arr[i];
            arr[i] = temp;
        }
    }
```
Selection sort is a linear sort algorithm as it moves from index [0] to [n-1]. In an inner loop it in a second linear loop that compares two elements (like seen in the visual below) and notes which is smallest, after cycling to the end it swaps the smallest number to the lowest in the round.

### Merge Sort
```java
public static void mergeSort(int arr[], int start, int end) {
        if (end > start) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            gather(arr, start, mid, end);
        }
    }
```
This algorithm uses a divide and conquer algorithm, versus linear algorithm of insertion or selection sort. Looking at it can be complicated, but it is more simple than it looks. It divides the array into two different groups recursively, until it gets only two to compare, swaps if necessary. Then it pops out of the recursion, observe the cascading and then the inverted assembly in illustration, after pop it puts each split group back together using a sorted comparison.
