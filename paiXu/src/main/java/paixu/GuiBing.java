package paixu;

/*
 * 归并排序
 *
 * 二路归并算法时间复杂度O(nlog^2N)，空间复杂度O(n)
 *
 * 空间复杂度
 * 堆排序O(1) < 快速排序O(log^2N) < 归并排序O(n)
 */
public class GuiBing {

    /*
     * Merge():一次二路归并，将两个相邻的有序子序列归并为一个有序序列
     */
    static void merge(int[] arr, int low, int mid, int high) {
        int i = low, j = mid + 1, k = 0;        //k是R1下标,i，j分别是第1,2段的下标
        int newArr[] = new int[high - low + 1];

        while (i <= mid && j <= high) {
            if (arr[i] < arr[j]) {            //将第一段中的纪录放入R1中
                newArr[k] = arr[i];
                i++;
                k++;
            } else {
                newArr[k] = arr[j];            //将第二段中纪录放入R1中
                j++;
                k++;
            }
        }

        while (i < mid) {                //将第一段余下部分复制到R1
            newArr[k] = arr[i];
            i++;
            k++;
        }
        while (j < high) {                //将第二段余下部分复制到R1
            newArr[k] = arr[j];
            j++;
            k++;
        }

        for (k = 0, i = low; i <= high; k++, i++) {        //将R1复制回R中
            arr[i] = newArr[k];
        }
    }

    /*
     * 一趟二路归并(段长为length)
     */
    static void mergePass(int[] arr, int length) {
        int i;
        for (i = 0; i + 2 * length - 1 < arr.length; i = i + 2 * length) {        //归并length长的两个相邻子表
            merge(arr, i, i + length, i + 2 * length - 1);
        }

        if (i + length - 1 < arr.length) {                            //余下两个子表，后者长度小于length
            merge(arr, i, i + length - 1, arr.length - 1);            //归并这两个子表
        }
    }

    /*
     * 二路归并排序算法
     */
    static void mergeSort(int R[]) {
        for (int length = 1; length < R.length; length = 2 * length)
            mergePass(R, length);                    //共经过(log^2N向上取值)趟
    }

    public static void main(String[] args) {
//        int[] a = {1, 32, 2, 45, 5, 12};
//
//        mergeSort(a);
//
//        for (Integer s : a) {
//            System.out.print(s + " ");
//        }



    }
}

