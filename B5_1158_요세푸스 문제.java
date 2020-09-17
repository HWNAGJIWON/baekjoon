import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main{
	static String res ="<";
	
	static void result(int q_poll) {
		res = res + q_poll + ", ";
	}
	
	
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		Queue q = new LinkedList();
		
		for(int i=1;i<=n;i++) {
			q.add(i);
		}
		
		
		int count = 1;
		while(q.size() > 1) {
			if(count == k) {
				count = 1;
				result((int)q.poll());
			}else {
				count ++;
				int temp = (int) q.poll();
				q.add(temp);
			}
		}
		if(q.size() == 1) {
			res = res + q.poll();
		}
		
		System.out.println(res+">");
		
		
	}
	
}