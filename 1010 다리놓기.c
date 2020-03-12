#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h> 

long long Factorial(int num) {
	//printf("\ncur loc // Factorial1 // num1 : %d\n", num);
	long long result=1;
	if (num <= 1) {
		result = 1;

	}
	else if (num >= 2) {
		for (int i = 2; i <= num; i++) {
				result *= i;
				//printf("Factorial 1 :  num1 >= 2 : i가 %d일때 = (%lld)\n", i,result);
		}//printf("\n");
	}
	//printf("\nFactorial1 result : %lld\n", result);
	return result;
}

long long Factorial2(int num1, int num2) {
	//printf("\ncur loc // Factorial2 // num1 : %d, num2 : %d\n", num1, num2);
	long long result = 1;
	if (num1 <= 1) {
		result = 1;
	}
	else if (num1 >= 2) {
		for (int i = num2 + 1; i <= num1; i++) {
			result = result * i;
			//printf("Factorial 2 : num1 >= 2 : num1이 %d일때  result = %lld\n",i, result);
		}//printf("\n");
		
	}
	//printf("\nFactorial2 result : %lld\n", result);
	return result;
}


int main(void) {
	int how;
	scanf("%d", &how);
	for (int i = 0; i < how; i++) {
		int  n, m;
			scanf("%d %d", &n, &m);
			int num1 = m;
			int num2;
			int num3;
			if (n > (m - n)) {
				num2 = n;
				num3 = m - n;
			}
			else {
				num2 = m - n;
				num3 = n;
			}
			long long result = Factorial2(num1, num2) / Factorial(num3);
			printf("%lld\n", result);
	}
	
}
/*
		1.조합 구하는 방식
		2. int의 범위 초과 & overflow 안 나게 계산하기
		3. nCk = nCn-k
*/