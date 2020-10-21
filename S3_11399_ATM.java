import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{

	
	
	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(bf.readLine());
		
		int arr[] = new int [num];
		
		String ss = bf.readLine();
		String ssArray[] = ss.split(" ");
		for(int i=0;i<num;i++) {
			arr[i] = Integer.parseInt(ssArray[i]);
		}
		
		
		int arr2[] = new int [num];
		
		
		
		//최소 시간순으로 정렬
		Arrays.sort(arr);
		
		/*
		System.out.println("arr정렬결과");
		for(int j=0;j<num;j++) {
			System.out.print(arr[j]+" ");
		}System.out.println();
		*/
		
		arr2[0] = arr[0];
		
		for(int i=1;i<num;i++) {
			arr2[i] = arr[i]+arr2[i-1];
		}
		/*
		System.out.println("arr2 출력");
		for(int j=0;j<num;j++) {
			System.out.print( arr2[j]+" ");
		}System.out.println();
		*/
		int rst=0;
		for(int j=0;j<num;j++) {
			rst += arr2[j];
		}
		
		System.out.println(rst);
		
		
		
	}
}