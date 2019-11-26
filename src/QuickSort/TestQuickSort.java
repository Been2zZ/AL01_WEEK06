package QuickSort;

import java.io.*;

public class TestQuickSort {
    public static void main(String[] args) throws FileNotFoundException {
        QuickSort q = new QuickSort();

        File F = new File("data06.txt");
        int[] QuickSort = q.insert(F);
        int[] Randomized_QuickSort = q.insert(F);

        q.quickSort(QuickSort, 0, QuickSort.length - 1);
        q.write(QuickSort, "QuickSort.txt");

        q.quickSort_withRandom(Randomized_QuickSort, 0, Randomized_QuickSort.length - 1);
        q.write(Randomized_QuickSort, "Randomized_QuickSort.txt");

    }
}
