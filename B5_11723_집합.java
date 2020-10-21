import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
	static int set[] = new int[21];
	
	
	
	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		
		int num = Integer.parseInt(bf.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		
		
		for(int i=0;i<num;i++) {
			String line = bf.readLine();
			String split[] = line.split(" ");
			
		
			
			if(split[0].contentEquals("add")) {
				
				set[Integer.parseInt(split[1])] = 1;
				
			}else if(split[0].contentEquals("remove")) {
				
				set[Integer.parseInt(split[1])] = 0;
				
			}else if(split[0].contentEquals("check")) {
				
				if(set[Integer.parseInt(split[1])]==1)
					sb.append("1\n");
				else
					sb.append("0\n");
						
			}else if(split[0].contentEquals("toggle")) {
				
				if(set[Integer.parseInt(split[1])]==1) {
					set[Integer.parseInt(split[1])]=0;
				}else {
					set[Integer.parseInt(split[1])]=1;
				}
				
				
			}else if(split[0].contentEquals("all")) {
				for(int u=1;u<21;u++) {
					set[u] = 1;
				}
								
			}else if(split[0].contentEquals("empty")) {
				for(int u=1;u<21;u++) {
					set[u] = 0;
				}
				
				
			}else {
				
			}
				
		}
		
		System.out.println(sb.toString());
		
	}
}