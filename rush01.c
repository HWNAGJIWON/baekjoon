#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <io.h>

int up[5] = {0,1,2,2,3};
int down[5] = {0,2,3,2,1};
int left[5] = {0,1,2,3,2};
int right[5] = {0,3,2,2,1};





int map[5][5] = { { 0,0,0,0,0 }, { 0,0,0,0,0 }, 
{ 0,0,0,0,0 }, { 0,0,0,0,0 },{ 0,0,0,0,0 } };

typedef struct Pos {
	int row;
	int col;
}Pos;

//전체 맵에 4가 3개인 경우 나머지 1개 4의 위치를 반환
Pos find_4()
{
	struct Pos find_4;
	find_4.col = 0; 
	find_4.row = 0;
	int i = 1;
	int j = 1;
	int num4 = 0;
	int r_check[5] = { 0,0,0,0,0 };
	int c_check[5] = { 0,0,0,0,0 };
	while (i < 5) 
	{
		j = 1;
		while (j < 5)
		{
			if (map[i][j] == 4) {
				r_check[i] = 1;
				c_check[j] = 1;
			}
			j++;
		}
		i++;
	}
	i = 1; j = 1;
	while (i < 5)
	{
		if (r_check[i] == 0)
			find_4.row = i;
		if (c_check[i] == 0)
			find_4.col = i;
		i++;
	}
	printf("find_r return = (%d, %d)\n", find_4.row, find_4.col);
	return find_4;
}

	int arr12[] = { 0, 4, 1, 2, 3, 4, 2, 1, 3 };
	int arr13[] = { 0, 4, 3, 1, 2, 4, 1, 3, 2, 4, 2, 3, 1 };
	int arr14[] = { 0,4,3,2,1 };
	int arr22[] = { 0,1,4,2,3,2,4,1,3, 3,4,1,2, 3,2,4,1,3,1,4,2,0,2,1,4,3 };
	int arr23[] = { 0,1,4,3,2,2,4,3,1, 3,4,2,1 };
	int arr21[] = { 0,3,2,1,4, 3,1,2,4 };
	int arr31[] = { 0, 2, 1, 3, 4, 2, 3, 1, 4, 1, 3, 2, 4 };
	int arr41[] = { 0,1,2,3,4 };

int* left_right_to_array(int left, int right)
{
	if (left == 1 && right == 2)
		return arr12;
	if (left == 1 && right == 3)
		return arr13;
	if (left == 1 && right == 4)
		return arr14;
	if (left == 2 && right == 2)
		return arr22;
	if (left == 2 && right == 3)
		return arr23;
	if (left == 2 && right == 1)
		return arr21;
	if (left == 3 && right == 1)
		return arr31;
	if (left == 4 && right == 1)
		return arr41;
}

void init()
{
	int i = 1;
	int count_4 = 0;
	while (i < 5)
	{
		if (left[i] == 1) {
			map[i][1] = 4;
			count_4++;
		}	
		if (right[i] == 1) {
			map[i][4] = 4;
			count_4++;
		}
		if (left[i] == 4) {
			map[i][1] = 1;
		}
		if (right[i] == 4) {
			map[i][4] = 1;
		}
		if (left[i] == 1 && right[i] == 4)
		{
			int j = 0;
			while (++j < 5) {
				map[i][j] = j;
			}
		}
		if (left[i] == 4 && right[i] == 1)
		{
			int j = 4;
			while (--j > 0) {
				map[i][j] = j;
			}
		}

		if (left[i] == 1 && right[i] == 2)
			map[i][4] = 3;
		if (left[i] == 2 && right[i] == 1)
			map[i][1] = 3;
		if (left[i] == 2 && right[i] == 3)
		{
			count_4++;
			map[i][2] = 4;
		}
		if (left[i] == 3 && right[i] == 2)
		{
			count_4++;
			map[i][3] = 4;
		}
		if (count_4 == 3)
		{
			Pos four_pos = find_4();
			map[four_pos.row][four_pos.col] = 4;
		}
		i++;
	}
}

void printMap()
{
	int i = 1;
	int j = 1;
	while (i < 5)
	{
		printf("%d :", i);
		j = 1;
		while (j < 5)
		{
			printf(" %d", map[i][j]);
			j++;
		}
		i++;
		printf("\n");
	}
}

//행에 채워진 개수
int count_row(int *row_num)
{
	int i = 1;
	int j = 1;
	int count = 0;
	while (i < 5)
	{
		j = 1;
		count = 0;
		while (j < 5)
		{
			if (map[i][j] != 0)
				count++;
			j++;
		}
		//printf("row_num[%d] = %d", i, count);
		row_num[i] = count;
		i++;
	}
	i = 1;
	int max_row = 0;
	while (i < 5) {
		if (row_num[i] > row_num[max_row])
			max_row = i;
		i++;
	}

	return max_row;

}

//위의 이미 입력된 행들과 
int checkcol(int inputcol, int cmpcol)
{
	int i = 1;
	int j = 1;
	int col[5] = { 0,0,0,0,0 };
	
	printf("In the checkcol, \n");
	while (i < 5)
	{
		if (map[inputcol][i] != 0) {
			printf("map[%d][%d] = %d\n\n", inputcol, i, map[inputcol][i]);
			col[i]++;
			printf("\ncol[%d] = %d", i, col[i]);
		}
			
		printf("col[%d] = %d\n", i, col[i]);
		i++;
	}
	
	return 0;
	//이 행에는 중복이 없다.
	if (col[cmpcol] == 0)
		return 1;
	//행에 중복이 있다 => 못 넣는다.
	return 0;
}

int** nextArr; 

//위로 올라갈 행을 반환
void backtracking(int deep, int now_r, int try)
{

	printf("\n\n\nIn the backtracking Function, ");
	if (deep == 5) {
		return;
	}
	int deep0;
	deep0 = 1;
	printf("\ndeep = %d now_r = %d try = %d\n", deep, now_r, try);
	int l = left[now_r];
	int r = right[now_r];
	int *nextArr;
	nextArr = left_right_to_array(l, r);

	//sizeof도 구현해야함
	if (try > sizeof(nextArr))
	{
		printf("\nError\n");
		return;
	}


	int i = 1;
	int j = 1;

	
	while (i < 5) {
		//새로들어갈 배열과 이미 들어간 배열에서 중복이 있다 -> break;
		printf("if (checkcol(%d, nextArr[%d] ) == 0)\n", j, try * i + (i+1));
		if (deep0 == 1 || checkcol(i, nextArr[try * i + i + 1]) == 0)
		{
			backtracking(deep, now_r, try++);
		}
		if (try *  +i + 1 > sizeof(nextArr))
			break;
		i++;
	}
	//새로운 배열이 맵에 들어가도 된다. map 배열에 복사
	while (j < 5) {
		map[i][j] = nextArr[try * j + j];
		j++;
	}
	backtracking(deep++, (now_r) % 4 + 1, 0);

	return 1;
}


int main(int argc, char *argv[])
{
	int i;
	int row_num[] = {0,0,0,0,0};

	init();
	printMap();

	i = 1;

	count_row(row_num);
	//start_row setting
	int start_row = count_row(row_num);
	printf("start_row = %d\n", start_row);
	backtracking(0, start_row, 0);



	
	//int arr12[6][5] =
	//int arr13[6][5] = { {0,4,3,1,2}, {0,4,1,3,2}, {0,4,2,3,1} };
	//int arr14[6][5] = { {0,4,3,2,1} };
	//int arr22[6][5] = { {0,1,4,2,3}, {0,2,4,1,3}, {0,3,4,1,2}, {0,3,2,4,1}, {0,3,1,4,2},{0,2,1,4,3} };
	//int arr23[6][5] = { {0,1,4,3,2},{0,2,4,3,1}, {0,3,4,2,1} };
	//int arr21[6][5] = { {0,3,2,1,4}, {0,3,1,2,4} };
	//int arr31[6][5] = { {0,2,1,3,4},{0,2,3,1,4},{0,1,3,2,4} };
	//int arr41[6][5] = { {0,1,2,3,4} };



}
