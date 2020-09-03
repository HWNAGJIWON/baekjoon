
import java.util.Scanner;

public class Main {
	static int one[] = new int [41];
	static int zero[] = new int [41];
	
	static int get_one(int n) {
		if(n>=2 && one[n] == 0) {
			one[n] = get_one(n-1) + get_one(n-2);
		}
		else if(n==0) {
			one[0] = 0;
		}else if(n == 1) {
			one[1] = 1;
		}
		return one[n];
	}
	
	static int get_zero(int n) {
		if(n>=2 && zero[n] == 0) {
			zero[n] = get_zero(n-1) + get_zero(n-2);
		}
		else if(n==0) {
			zero[0] = 1;
		}else if(n==1) {
			zero[1] = 0;
		}
		return zero[n];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//테스트 수
		int t = sc.nextInt();
		
		// 0<=N<40
		for(int i=0;i<t;i++) {
			int n = sc.nextInt();
			System.out.println(get_zero(n)+" "+get_one(n));
		}

	}

}
