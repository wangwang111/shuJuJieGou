package a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class _45 {
	
	/*
	 * 把数组排成最小的数
	 * 
	 * 例如{3,32,321}打印这3个数字的最小数字321323
	 */
	public static String printMinNumber(int[] numbers) {
		int n;
		String s="";
		ArrayList<Integer> list=new ArrayList<>();
		n=numbers.length;
		
		for(int i=0;i<n;i++) {
			list.add(numbers[i]);
		}
		
		Collections.sort(list,new Comparator<Integer>() {

			@Override
			public int compare(Integer str1, Integer str2) {
				String s1=str1+""+str2;
				String s2=str2+""+str2;
				return s1.compareTo(s2);
			}
		});
		
		for(Integer j:list) {
			s+=j;
		}
		
		return s;
	}
	
	public static void main(String[] args) {
		System.out.println(printMinNumber(new int[] {1,2,3,2}));
	}
}
