
import java.io.*;
import java.util.*;

public class Main {
	static int n, m, v;
	static int [][] map;
	static boolean visit[];
	static boolean visit2[];
	static StringBuilder sb = new StringBuilder();
	static StringBuilder sb2 = new StringBuilder();
	
	static void bfs(int s) {
		Queue<Integer> q = new LinkedList<>();
		q.add(s);
	
		while(!q.isEmpty()) {
			int a = q.poll();
			sb.append(a+" ");
			
			visit[a] = true;
			for(int i=1;i<=n;i++) {
				if(map[a][i]==1 && !visit[i]) {
					q.add(i);
					visit[i]=true;
					
				}
			}
			
		}
		System.out.println(sb);
		
	}

	
	static void dfs(int s) {
		Stack<Integer> stack = new Stack<>();
		stack.add(s);
		sb2.append(s + " ");
		
		while(!stack.empty()) {
			int a = stack.peek();
			
			int noPush = 0;
			
			visit2[a] = true;
			for(int i=1;i<=n;i++) {
				if(map[a][i]==1 && !visit2[i]) {
					stack.push(i);
					noPush = 1;
						sb2.append(i+" ");
					visit2[i] = true;
					break;
				}
			}
			if(noPush == 0) {
				stack.pop();
			}
		}
	
		System.out.println(sb2);
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] s = bf.readLine().split(" ");
		n = Integer.parseInt(s[0]); // 정점의 개수
		m = Integer.parseInt(s[1]); // 간선의 개수
		v = Integer.parseInt(s[2]); //탐색을 시작할 정점의 번호
		
	
		map = new int [n+1][n+1];
	
		visit = new boolean[n+1];
		visit2 = new boolean[n+1];
		
		for(int i=0;i<m;i++) {
			String[] s2 = bf.readLine().split(" ");
			int a = Integer.parseInt(s2[0]);
			int b = Integer.parseInt(s2[1]);
			
			map[a][b] = map[b][a] = 1;
		}
		
		dfs(v);
		bfs(v);
		
	

	}

}
