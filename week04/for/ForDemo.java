/*
	�����Ӽ����1�ӵ�100������ʹﵽ1000���˳�
*/
public class ForDemo {
	public static void main(String[] args) {
		int s = 0;
		for(int i=1;i<=100;i++) {
			s += i;
			if (s>=1000)
				break;
		}
		System.out.println("i="+i+",s="+s);
	}
}