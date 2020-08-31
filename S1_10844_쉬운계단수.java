
import java.util.Scanner;

public class Main {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int copy_num = num;
	
		long n[] = {0,1,1,1,1,1,1,1,1,1};
		long result1[] = new long[10];
		
		
		while(num-- > 1) {
			for(int i=0;i<10;i++) {
				if(i == 0) {
					result1[i] = n[i+1]% 1000000000;
				}else if(i == 9) {
					result1[i] = n[i-1]% 1000000000;
				}else {
					result1[i] = (n[i-1]+n[i+1])% 1000000000;
				}
				//System.out.print(result1[i]+", ");
			}//System.out.println();
			
			for(int j=0;j<10;j++) {
				n[j] = result1[j]% 1000000000;
			}
		}
		
		long sum=0;
		if(copy_num > 1) {
			for(int m=0;m<10;m++) {
				sum += (result1[m]% 1000000000);
			}
		}else if(copy_num == 1){
			sum = 9;
		}
		
		
		System.out.println(sum% 1000000000);
	}
		
}
