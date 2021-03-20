package test;

public class Demo1 {

	int SeqSearch(int[] R,int key) {
		int i=0;
		while(i<R.length && R[i]!=key) {
			i++;
		}
		
		if(i>=R.length) {
			return -1;
		}else {
			return i+1;
		}
	}
	
	public static void main(String[] args) {
		
	}
}
