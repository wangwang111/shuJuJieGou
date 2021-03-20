package chazhao;

/*
 * 二分查找
 */
public class ChaZhao {

    /*
     * 二分查找(有序排列)
     *
     * 要求表中key有序排列
     */
    static int binSearch(int[] arr, int key) {
        int low = 0, high = arr.length, mid;

        while (low <= high) {
            mid = low + (high - low) / 2;

            if (key == arr[mid]) {
                return mid + 1;
            }
            if (key < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] R = {1, 2, 3, 4};
        int result = binSearch(R, 2);
        System.out.println(result);
    }

}