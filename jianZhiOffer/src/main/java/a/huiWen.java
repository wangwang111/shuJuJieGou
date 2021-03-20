package a;

public class huiWen {

	boolean isPalindrome(char s[]) {
		
		if(s==null || s.length<1)
			return false;
		
		int front=0;
		int back=s.length-1;
		
		while(front < back) {
			if(s[front]!=s[back])
				return false;
			
			++front;
			++back;
		}
		
		return true;
	}
}
