package paixu;

/*
 * 交换排序
 * 1.冒泡排序
 * 2.快速排序
 */
public class JiaoHuan {

    /*
     * 冒泡排序
     * 初始有序区为空
     * i=0 ~ n-2，共n-1趟使整个数据有序
     *
     * 最好时间复杂度O(n),最坏和平均时间复杂度O(n^2)
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {            //比较找本趟最小关键字的纪录
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp;
                    temp = arr[j];                //R[j] <--> R[j-1]
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }


    /*
     * 改进后，冒泡排序
     * 一旦某一趟比较式不出现纪录交换，说明已经排好序了，就可以结束本算法
     */
    public static void BubbleSort2(int[] R) {
        boolean exchange;
        for (int i = 0; i < R.length - 1; i++) {
            exchange = false;
            for (int j = R.length - 1; j > i; j--) {            //比较，找出最小关键字的纪录
                if (R[j] < R[j - 1]) {
                    int temp;
                    temp = R[j];
                    R[j] = R[j - 1];
                    R[j - 1] = temp;
                    exchange = true;
                }
            }

            if (exchange == false) {                //中途结束算法
                return;
            }
        }
    }


    /*
     * 快速排序
     * 每趟是表的第一个元素放入适当位置（归位），将表一分为二，对子表按递归方式继续这种划分，
     * 直至划分的子表长度为0或1（递归出口）
     *
     * 时间复杂度O(nlogn),空间复杂度O(nlogn)
     */
    //对R[s]至R[t]的元素进行快速排序
    public static void quickSort(int[] arr, int start, int end) {    //start数组起始位置，end数组终止位置
        int i = start, j = end;
        int temp;

        if (start < end) {                                //区间内至少存在2个元素的情况
            temp = arr[start];                            //用区间的第一个记录作为基准
            while (i != j) {                        //从两端交替向中间扫描，直至i=j为止
                while (i < j && arr[j] >= temp)
                    j--;
                arr[i] = arr[j];
                while (i < j && arr[i] <= temp)
                    i++;
                arr[j] = arr[i];
            }
            arr[i] = temp;
            quickSort(arr, start, i - 1);                //对左区间递归排序
            quickSort(arr, i + 1, end);                //对右区间递归排序
        }
        //递归出口，不需要任何操作
    }


    public static void main(String[] args) {
        int[] a = {1, 32, 2, 45, 5, 12};

//		BubbleSort2(a);
        quickSort(a, 0, a.length - 1);

        for (Integer s : a) {
            System.out.print(s + " ");
        }
    }

}
