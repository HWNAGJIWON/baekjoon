#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h> 
#include <stdbool.h>
bool visited[10000][10000] = { false , };
bool visited2[10000][10000] = { false, };
short connect[1001][1001] = { 0, };	//vertex끼리 연결되면 1
short connect2[1001][1001] = { 0, };	//vertex끼리 연결되면 1


int count = 1;
int count2 = 1;

void DFS(int n, int v) {
	if (count == n) {
		return;
	}
	if (n < 0) return;
	int index=0;
	int min=1000;
	
	for (int i = 0; i <= n; i++) {
		if (connect[v][i] > 0 && (v != i) && visited[v][i] == false) {
			//노드끼리 연결되어있고 && 같은 노드가 아니고 && 방문한 노드가 아니면
			if (min > i) {
				min = index = i;
			}
		}
	}
	if (min==1000) { 
		return;
	}
	else {
		for (int i = 0; i <= n; i++) {
			visited[v][i] = visited[i][v] = true;
			
		}
		printf("%d ", index);
	}
	count++;
	DFS(n, index);
}


void BFS(int n,int v) {
	printf("BFS 시작\n n은 %d v는 %d\n",n,v);
	int bfs[1001] = { 0, };
	if (count2 == n) {
		for (int i = 0; i <= n; i++) {
			printf("\n\n!!!!STOP!!!! bfs[%d] = %d\n",i,bfs[i]);
		}
		return;
	}
	
	int temp = 0;
	int index = 0;
	int cnt = 0;
	
	for (int i = 0; i < 1001; i++) {
		if (connect2[v][i] > 0 && v != i && visited2[v][i] == false) {
			//노드끼리 연결되어있고 && 같은 노드가 아니고 && 방문한 노드가 아니면
			
			bfs[temp++] = i;
			printf("bfs[temp : %d] = i : %d", temp, i);
			index = i;
			v = bfs[cnt++];
			printf("v test : %d", v);
			printf("	bfs[%d] = %d\n", temp, bfs[temp]);
			for (int i = 0; i <= n; i++) {
				visited2[v][i] = visited2[i][v] = true;
			}

		}
	}if (index == 0) {
		printf("index가 0이라서 return으로 종료됨\n");
		return;
	}
	
	count2++;
	BFS(n, index);
}

int main(void) {
	
	int n, m, v;
	scanf("%d %d %d", &n, &m, &v);

	
	for (int i = 0; i < m; i++) {
		int one, two;
		scanf("%d %d", &one, &two);
		connect[one][two] = connect[two][one] = 1;
		connect2[one][two] = connect2[two][one] = 1;

	}


	//printf("%d ", v);
	//DFS(n, v);
	BFS(n, v);
}
