
import java.util.Scanner;


public class Main {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int num_copy = num;
		
		long a=1, b=1;
		long result=0;
		if(num > 2) {
			while(num-->2) {
				result=a+b;
				a=b;
				b=result;
			}
		}else {
			result = 1;
		}
		System.out.println(result);
		
	}
		
}
//������ �ִ밪 �ּҰ��� ���� ���� �Է��غ���