package a;

import java.util.ArrayList;
import java.util.HashSet;

public class _03 {

	/*
	 * ��Ŀһ���������ظ�����
	 *  ��һ������Ϊn���������������ֶ���n-1�ķ�Χ��
	 * 1.hash
	 * 2.��ͷ��βɨ����������е����֣���ɨ�赽�±�Ϊi�������ǣ�
	 * ���ȱȽ�������֣�m��ʾ���ǲ��ǵ���i��
	 * ����ǣ������ɨ����һ�����֣�������ǣ������͵�m�����ֽ��бȽϣ�
	 * ������͵�m��������ȣ����ҵ�һ���ظ����֣��������ȣ����͵�m�����ֽ���
	 * �ظ��˹���
	 * 
	 * 
	 * ��Ŀ��
	 * ���޸������ҳ��ظ�������
	 * 
	 * ��һ������Ϊn+1�������������ֶ���1~n�ķ�Χ��
	 * ���ö���˼�룬��1~n�������м������m��Ϊ�����֣�
	 * ǰ��һ��Ϊ1~m,����һ��m+1~n
	 * ���1~m���ֳ���m����ô��һ������ظ����֣�������һ��
	 * �ظ��˹��̣�ֱ���ҵ��ظ�����
	 */

	
	/*
	 * ��Ŀһ
	 * ����һ
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

	
	//����2
	boolean duplicate(int numbers[], int[] duplication) {
		if (numbers == null || numbers.length <= 0)
			return false;

		//�Ϸ�����֤ 
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

				// ����numbers[i]��numbers[numbers[i]]
				int temp = numbers[i];
				numbers[i] = numbers[temp];
				numbers[temp] = temp;
			}
		}

		return false;
	}
	
	
	/*
	 * ��Ŀ��
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
