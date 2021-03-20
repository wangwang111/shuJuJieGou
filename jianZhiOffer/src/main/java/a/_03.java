package a;

import java.util.ArrayList;
import java.util.HashSet;

public class _03 {

	/*
	 * 题目一，数组中重复数字
	 *  在一个长度为n的数组里所有数字都在n-1的范围内
	 * 1.hash
	 * 2.从头到尾扫描这个数组中的数字，当扫描到下标为i的数字是，
	 * 首先比较这个数字（m表示）是不是等于i，
	 * 如果是，则接着扫描下一个数字，如果不是，拿它和第m个数字进行比较，
	 * 如果它和第m个数字相等，就找到一个重复数字，如果不相等，它和第m个数字交互
	 * 重复此过程
	 * 
	 * 
	 * 题目二
	 * 不修改数组找出重复的数字
	 * 
	 * 在一个长度为n+1的数组所有数字都在1~n的范围内
	 * 利用二分思想，从1~n的数字中间的数字m分为两部分，
	 * 前面一半为1~m,后面一半m+1~n
	 * 如果1~m数字超过m，那么这一半存在重复数字，否则，另一半
	 * 重复此过程，直到找到重复数字
	 */

	
	/*
	 * 题目一
	 * 方法一
	 */
	public static ArrayList<Integer> duplicate(int[] numbers) {

		ArrayList<Integer> arr = new ArrayList<>();
		HashSet<Integer> map = new HashSet<>();

		for (int i = 0; i < numbers.length; i++) {
			if (map.contains(numbers[i])) {
				arr.add(numbers[i]);
			} else {
				map.add(numbers[i]);
			}
		}

		return arr;
	}

	
	//方法2
	boolean duplicate(int numbers[], int[] duplication) {
		if (numbers == null || numbers.length <= 0)
			return false;

		//合法性验证 
		for (int i = 0; i < numbers.length; ++i) {
			if (numbers[i] < 0 || numbers[i] > numbers.length - 1)
				return false;
		}

		for (int i = 0; i < numbers.length; ++i) {
			while (numbers[i] != i) {
				if (numbers[i] == numbers[numbers[i]]) {
					duplication[0] = numbers[i];
					return true;
				}

				// 交换numbers[i]和numbers[numbers[i]]
				int temp = numbers[i];
				numbers[i] = numbers[temp];
				numbers[temp] = temp;
			}
		}

		return false;
	}
	
	
	/*
	 * 题目二
	 */
	int getDuplication( int numbers[]){
	    if(numbers == null || numbers.length <= 0)
	        return -1;

	    int start = 1;
	    int end = numbers.length - 1;
	    while(end >= start){
	        int middle = (end - start) /2 + start;
	        int count = countRange(numbers, start, middle);
	        if(end == start){
	            if(count > 1)
	                return start;
	            else
	                break;
	        }

	        if(count > (middle - start + 1))
	            end = middle;
	        else
	            start = middle + 1;
	    }
	    return -1;
	}

	int countRange(int[] numbers, int start, int end){
	    if(numbers == null)
	        return 0;

	    int count = 0;
	    for(int i = 0; i < numbers.length; i++)
	        if(numbers[i] >= start && numbers[i] <= end)
	            ++count;
	    return count;
	}
	
}
