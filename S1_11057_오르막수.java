
import java.util.Scanner;

public class Main {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int first[] = {1,1,1,1,1,1,1,1,1,1};
		int res[] = new int[10];
		
		int num = sc.nextInt();
		int num_copy = num;
		while(num-->0) {
			for(int i=9;i>=0;i--) {
				if(i==9){
					res[i] = first[i]%10007;
				}
				else {
					res[i] = (first[i] + res[i+1])%10007;
				}
				//System.out.print(res[i]+", ");
				//9부터 0까지 출력됨
			}//System.out.println();
			
			for(int i=0;i<10;i++) {
				first[i] = res[i];
			}
		}
		int sum = 0;
		if(num_copy==1) {
			sum = 10;
			
		}else {
			sum=res[0]%10007;
		}
		System.out.println(sum%10007);
		
		
	}
		
}