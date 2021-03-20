package paixu;

/*
 * 选择排序
 * 1.简单选择排序
 * 2.堆排序
 */
public class XuanZe {

    /*
     * 共经过n-1趟排序
     */
    public static void SelectSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {            //做第i趟排序
            int k = i;
            for (int j = i + 1; j < arr.length; j++) {            //找出最小元素
                if (arr[j] < arr[k]) {
                    k = j;
                }
            }

            if (k != i) {                    //R[i]<-->R[k]
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            }
        }
    }

    /*
     * 堆排序
     * 堆定义：一个序列R[1..n]，关键字分别为k1,k2,.....,kn
     *
     * 堆排序的关键是构造堆，这里采用筛选算法建堆()
     * 所谓“筛选”指的是，对一颗左/右子树均为堆的完全二叉树，“调整”根节点使整个二叉树也成为一个堆
     *
     * 筛选过程：
     * 把根节点放入临时变量temp中，比较左右孩子选出最大的一个，和临时变量比较，如果小，则把孩子
     * 放入堆中，接着temp比较孙子节点，如果小，放入父节点
     *
     * 1.仅仅处理从根节点--》某个叶子节点的路径上的节点
     * 2.n个节点的完全二叉树的高度为log^2(n+1)向上取整
     * 3.所有筛选的时间复杂度O(log^2N)
     *
     */
    //筛选算法
    private static void sift(int arr[], int low, int high) {    //R[low..high]
        int i = low, j = 2 * i;                    //R[j]是R[i]的左孩子
        int temp = arr[i];
        while (i <= high) {
            if (j < high && arr[j] < arr[j + 1])
                j++;                        //j指向大孩子
            if (temp < arr[j]) {                    //双亲小
                arr[i] = arr[j];                    //将R[j]调整到双亲节点位置上
                i = j;                        //修改i和j值，以便继续向下筛选
                j = 2 * i;
            } else {
                break;                        //双亲大，不再调整
            }
        }
        arr[i] = temp;
    }

    //堆算法
    public static void HeapSort(int[] arr) {
        int i;
        int temp;
        for (i = arr.length / 2; i >= 1; i--) {        //循环建立初始堆
            sift(arr, i, arr.length);
        }

        for (i = arr.length; i >= 2; i--) {            //进行n-1次循环，完成堆排序
            temp = arr[1];
            arr[1] = arr[i];
            arr[i] = temp;
            sift(arr, 1, i - 1);                //筛选R[1]节点，得到i-1个节点的堆
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 32, 2, 45, 5, 12};

        HeapSort(a);

        for (Integer s : a) {
            System.out.print(s + " ");
        }
    }
}