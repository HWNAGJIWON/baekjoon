import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{

	
	
	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		Set<String> hm = new HashSet<String>();
		Set<String> hm2 = new HashSet<String>();
		
		
		
		String first = bf.readLine();
		String split[] = first.split(" ");
		//split[0] = 듣도 x , split[1] = 보도 x
		
		int no_listen = Integer.parseInt(split[0]);
		int no_see = Integer.parseInt(split[1]);
		
		
		for(int i=0;i<no_listen;i++) {
			String s = bf.readLine();
			hm.add(s);
		}
		
		for(int j=0;j<no_see;j++) {
			String s2 = bf.readLine();
			if(hm.contains(s2)) {
				hm2.add(s2);
			}
		}
		System.out.println(hm2.size());
		
		
		//Set을 List로 변환
		List<String> print = new ArrayList<String>(hm2);
		//List 정렬
		Collections.sort(print);
		
		//결과 출력
		for( String ss : print) {
		
			System.out.println(ss);
		}
		
	}
}
