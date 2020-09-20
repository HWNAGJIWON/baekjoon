import java.util.Scanner;

public class Main{
	static long fib[] = new long[91] ;
	
	static long Calcu(int num) {
		if(fib[num]!=0)
			return fib[num];
		else {
			fib[num] = Calcu(num-1)+Calcu(num-2);
			return fib[num];
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		
		fib[0] = 0; fib[1] = 1; fib[2] = 1;
		 
		System.out.println(Calcu(num));
		
		
	}
}
