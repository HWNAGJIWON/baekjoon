import java.util.*;

public class Main{
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int arr [] = new int[num];
	
		int Y=0,M=0;
		
		for(int i=0;i<num;i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int y=0;y<num;y++) {
			Y += (arr[y]/30+1) * 10;
			
		}
		
		for(int m=0;m<num;m++) {
			M += (arr[m]/60+1) * 15;
			
		}
	
		if(Y==M) {
			System.out.println("Y M " + Y);
		}else if(Y > M) {
			System.out.println("M "+M);
		}else {
			System.out.println("Y "+Y);
		}
	}
}
