
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main{
	static void left_arrow(Stack<Character> left,Stack<Character> right) {
		if(left.size()>0) {
			Character temp = left.pop();
			right.push(temp);
			
		}else {
			
		}
	}
	static void right_arrow(Stack<Character> left,Stack<Character> right) {
		if(right.size()>0) {
			Character temp = right.pop();
			left.push(temp);
		
		}else {
			
		}
	}
	static void back_space(Stack<Character> left) {
		if(left.size()>0) {
			Character trash = left.pop();
		}
		
	}
	
	static void insert(Stack<Character> left, char arr) {
		left.push(arr);
	}
	
	static String end(Stack<Character> left,Stack<Character> right) {
		
		//StringBuffer 클래스에 reverse가 있구나 
		//딴 건 뭐 있을까
		StringBuffer result = new StringBuffer();
		//StringBuilder result = new StringBuilder();
		
		while(!left.isEmpty()) {
			result.append(left.pop());
			
		}
		result.reverse();
		while(!right.isEmpty()) {
			result.append(right.pop());
			
		}
		String result2 = result.toString();
		return result2;
	}
	//A<B<<C>D<>>EF
	//CBDAEF
	
	
	public static void main(String [] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//익숙해지자 BufferedReader
		int t_num = Integer.parseInt(br.readLine());
		
		for(int i=0;i<t_num;i++) {
			char[] arr = br.readLine().toCharArray();
			//String arr[] = s1.split("");
			
			Stack<Character> left = new Stack<Character>();
			Stack<Character> right = new Stack<Character>();
			
			int count=0;
			int length = arr.length;
			

			for(int ok=0;ok<length;ok++) {
				
				if(arr[ok] == '<') {
					left_arrow(left,right);
				}
				else if(arr[ok]== '>') {
					right_arrow(left,right);
				}
				else if(arr[ok]== '-') {
					back_space(left);
				}
				else {
					
					insert(left,arr[ok]);
				}
				
			}
			System.out.println(end(left,right));
			
			
			
		}
		
		
	}
	
}
