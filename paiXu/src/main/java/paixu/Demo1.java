package paixu;

public class Demo1 {

    public static void QuickSort(int[] R, int s, int t) {
        int i = s, j = t;
        int temp;
        if (s < t) {
            temp = R[s];
            while (i != j) {
                while (j > i && R[j] >= temp)
                    j--;
                R[i] = R[j];
                while (i < j && R[i] <= temp)
                    i++;
                R[j] = R[i];
            }
            R[i] = temp;
            QuickSort(R, s, i - 1);
            QuickSort(R, i + 1, t);
        }
    }

    public static void QuickSort2(int[] R, int s, int t) {
        int i = s, j = t;
        if (s < t) {
            int temp = R[s];
            while (i != j) {
                while (j > i && R[j] >= temp)
                    j--;
                R[i] = R[j];
                while (i < j && R[i] <= temp)
                    i++;
                R[j] = R[i];
            }
            R[i] = temp;
            QuickSort(R, s, i - 1);
            QuickSort(R, i + 1, t);
        }
    }

    public static void printArray(int[] R) {
        for (int i = 0; i < R.length; i++) {
            System.out.print(R[i] + " ");
        }
    }

    public static void main(String[] args) {
        int R[] = {2, 32, 23, 4, 5, 9};
        QuickSort(R, 0, R.length - 1);
        printArray(R);
    }
}
