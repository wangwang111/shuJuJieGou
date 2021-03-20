package a;

public class _48 {

	/*
	 * ������ظ��ַ������ַ���
	 * ʱ�临�Ӷ�O(n),�ռ临�Ӷ�O(n)
	 * 
	 * ���������ÿ���ַ�λ�õ�������Զ����ظ��Ӵ����������ֵ��������ظ��Ӵ�
	 * 
	 * ������iλ������ظ��Ӵ��ĳ���,��Ҫ��������
	 *
	 * 1.��ϣ��map  -->����ͳ����ÿ���ַ�֮ǰ���ֵ�λ��
	 * 2.����pre   -->  ������s[i-1]��β������£�����ظ��Ӵ��ĳ���
	 * 
	 * map��key��ʾĳ���ַ���valueΪ����ַ����һ�γ��ֵ�λ��
	 */
	public static int maxUnique(String str) {
		if (str == null || str.equals("")) {
			return 0;
		}
		char[] chas = str.toCharArray();
		int[] map = new int[256];
		for (int i = 0; i < 256; i++) {
			map[i] = -1;
		}
		int len = 0;
		int pre = -1;
		int cur = 0;
		for (int i = 0; i != chas.length; i++) {
			pre = Math.max(pre, map[chas[i]]);
			cur = i - pre;
			len = Math.max(len, cur);
			map[chas[i]] = i;
		}
		return len;
	}
}