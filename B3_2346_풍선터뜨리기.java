import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Ballon {
	int first_index;
	int data;
	
	Ballon(int first_index, int data){
		this.first_index = first_index;
		this.data = data;
	}

	
}
public class Main{
	static Ballon getList(int index, int data) {
		Ballon b = new Ballon(index, data);
		return b;
	}
	
	public static void main(String [] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t_num = Integer.parseInt(bf.readLine());
		
		LinkedList<Ballon> list = new LinkedList<Ballon>();
		String str = bf.readLine();
		String[] arr = str.split(" ");
	
		//풍선 list 생성 
		for(int i=0;i<t_num;i++) {
			Ballon temp =  new Ballon(i,Integer.parseInt(arr[i]));
			list.add(temp);
		}
		
		
		int kill = 0; int data =0;
		StringBuilder sb = new StringBuilder();
		
		while(list.size()>0) {
			if(data > 0) {	//값이 양수일 때
				for(int i=0;i<data-1;i++) {
					kill++;
					if(kill >= list.size()) {
						kill = 0;
					}
				}
			}else if(data < 0){	//값이 음수일 때
				data = data * -1;	//와 이렇게 할 수가 있구나
				for(int i=0;i<data;i++) {
					kill--;
					if(kill<0) {
						kill = list.size()-1;
					}
				}
				
			}
			Ballon ball = list.get(kill);
			data = ball.data;
			
			sb.append(ball.first_index+1 +" ");
			
			list.remove(kill);
			if(kill == list.size()) {
				kill = 0;
			}
			
		}
		System.out.println(sb);
		
		/*
		 * 이거 구현 안 하고는 못 풀까?
		 * 인덱스로만 계산은 못 하나?
		 * 해보고 싶다.
		 */
	}

	
}