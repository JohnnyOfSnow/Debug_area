// 1222.cpp : 定義主控台應用程式的進入點。
//

#include "stdafx.h"
#include <time.h>
#include <stdio.h>
#include <iostream>
#include <stdlib.h>
#include <cstdlib>
#include <cmath>
using namespace std;
void a(int num[]);
void b(int fir, int las, int max, int min);
int Max1 = 0;
int Max2 = 0;
int Min1 = 0;
int Min2 = 0;
int Max = 0;
int Min = 0;
int fir = 0;
int las = 129;
int num[129] = {};
int _tmain(int argc, _TCHAR* argv[]) 
{


	unsigned seed;
	seed = (unsigned)time(NULL);
	srand(seed);
	for (int i = 0; i < 129; i++){
		num[i] = rand() % 128 + 1;

	}
	for (int i = 0; i < 129; i++){
		if (i % 10 == 0){
			cout << "" << endl;
		}
		else{
			cout << " ";
			cout << num[i];
		}
	}

	cout << " " << endl;
	a(num);
	b(0, 129, 0, 0);
	system("pause");
	return 0;
}

void a(int num[]){
	int max = num[0];
	int min = num[0];
	for (int i = 0; i < 129; i++){
		if (max<num[i]){
			max = num[i];
		}

	}
	cout << max << endl;
	cout << " " << endl;
	for (int i = 0; i < 129; i++){
		if (min>num[i]){
			min = num[i];
		}

	}
	cout << min << endl;
}
void b(int fir, int las, int Max, int Min){
	if (fir == las){
		Max = num[fir];
		Min = num[fir];
		
	}
	else{
		
		int m = (int)(((las - fir) / 2));
		b(fir,m, Max1, Min1);
		b(m, las, Max2, Min2);
		if (Max2>Max1){
			Max = Max2;
		}
		else{
			Max = Max1;
		}
		cout << Max;
		cout << "" << endl;
		if (Min2<Min1){
			Min = Min2;
		}
		else{
			Min = Min1;
		}
		cout << Min;
		
	}
}
