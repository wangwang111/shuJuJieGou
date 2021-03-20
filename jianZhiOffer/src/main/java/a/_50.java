package a;

import java.util.LinkedHashMap;

/*
 * 第一个出现一次的字符
 */
public class _50 {

	/*
	 * hash表 
	 */
	public int FirstNotRepeation(String str) {
		
		LinkedHashMap<Character,Integer> map=new LinkedHashMap<Character,Integer>();
		for(int i=0;i<str.length();i++) {
			if(map.containsKey(str.charAt(i))) {
				int time=map.get(str.charAt(i));
				map.put(str.charAt(i), ++time);
			}else {
				map.put(str.charAt(i),1);
			}
		}
		
		int pos=-1;
		int i=0;
		while(i<str.length()) {
			char c=str.charAt(i);
			if(map.get(c)==1) {
				return i;
			}
		}
		return pos;
		
	}
}
