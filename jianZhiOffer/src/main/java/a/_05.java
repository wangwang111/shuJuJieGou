package a;

public class _05 {

	/*
	 * �滻�ո�
	 */

	public static void replace(char[] chas) {
		if (chas == null || chas.length == 0) {
			return;
		}
		int num = 0;
		int len = 0;

		//����һ�鷢�ֿո�����
		for (len = 0; len < chas.length && chas[len] != 0; len++) {
			if (chas[len] == ' ') {
				num++;
			}
		}
		int j = len + num * 2 - 1;
		for (int i = len - 1; i > -1; i--) {
			if (chas[i] != ' ') {
				chas[j--] = chas[i];
			} else {
				chas[j--] = '0';
				chas[j--] = '2';
				chas[j--] = '%';
			}
		}

	}
	
}