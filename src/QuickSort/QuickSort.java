package QuickSort;

import java.io.*;

public class QuickSort {

    public int[] insert(File F) throws FileNotFoundException {
        /** File read & Array insert */
        FileReader fr = new FileReader(F);
        BufferedReader br = new BufferedReader(fr);

        String[] temp = null;

        try {
            String line = "";
            while((line = br.readLine()) != null){
                temp = line.split(",");
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.err.println(e);
        }

        int size = temp.length;

        int[] Arr = new int[size];

        for(int i = 0; i < Arr.length; i++)
            Arr[i] = Integer.parseInt(temp[i]);

        return Arr;
    }

    public void write(int[] A, String filename) {
        /** File write */
        File file = new File(filename);
        FileWriter writer = null;
        try {
            writer = new FileWriter(file, true);
            for (int i = 0; i < A.length; i++) {
                writer.write(A[i] + "\r\n");
                writer.flush();
            }
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(writer != null) writer.close();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }

    private int partition(int[] A, int p, int r) {
        int x = A[r];
        int i  = p - 1;
        int temp;

        for(int j = p; j < r; j++) {
            if(A[j] <= x) {
                i++;
                /** swap A[i], A[j] */
                temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        i++;
        /** swap A[i], A[r] */
        temp = A[i];
        A[i] = A[r];
        A[r] = temp;

        return i;
    }

    private int randomizedPartition(int[] A, int p, int r) {
        /** random value p ~ r */
        int i = (int)Math.random() * r + p;

        /** swap A[i], A[r] */
        int temp = A[r];
        A[r] = A[i];
        A[i] = temp;

        return partition(A, p, r);
    }

    public void quickSort(int[] A, int p, int r) {
        /** Quick Sort */
        if(p < r) {
            int q = partition(A, p, r);
            quickSort(A, p, q - 1);
            quickSort(A, q + 1, r);
        }
    }

    public void quickSort_withRandom(int[] A, int p, int r) {
        /** randomize Quick Sort */
        if(p < r) {
            int q = randomizedPartition(A, p, r);
            quickSort_withRandom(A, p, q - 1);
            quickSort_withRandom(A, q + 1, r);
        }

    }
}
