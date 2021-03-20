package a;

public class HeLanGuoQi {

	public void HeLan(int[] arr) {

		int begin=0;
		int current=0;
		int end=arr.length-1;
		
		while(current<=end) {
			if(arr[current]==0) {
				
				swap(arr,current,begin);
				current++;
				begin++;
			}else if(arr[current]==1) {
				
				current++;
			}else {			//µ±arr[current]=2
				swap(arr,current,end);
				end--;
			}
		}
	}

	private void swap(int[] arr, int i, int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
}
