/**   
 * Problem Statement

Given a list of n integers, A={a1,a2,¡­,an}, and another integer, k representing the expected sum. Select zero or more numbers from A such that the sum of these numbers is as near as possible, but not exceeding, to the expected sum (k).

Note

Each element of A can be selected multiple times.
If no element is selected then the sum is 0.
Input Format

The first line contains T the number of test cases. 
Each test case comprises of two lines. First line contains two integers, n k, representing the length of list A and expected sum, respectively. Second line consists of n space separated integers, a1,a2,¡­,an, representing the elements of list A.

Constraints 
1¡ÜT¡Ü10 
1¡Ün¡Ü2000 
1¡Ük¡Ü2000 
1¡Üai¡Ü2000,where i¡Ê[1,n]
Output Format

Output T lines, the maximum sum for each test case which is as near as possible, but not exceeding, to the expected sum (k).

Sample Input

2
3 12
1 6 9
5 9
3 4 4 4 8
Sample Output

12
9
Explanation

In the first test case, one can pick {6, 6}. In the second, we can pick {3,3,3}.
 * @Title: Knapsack.java 
 * @author lxh  
 * @date Aug 31, 2015 8:45:54 PM  
 * 
 */
package com.DP;

import java.util.Scanner;

public class Knapsack {
	public static void main(String []args){
		Scanner cin=new Scanner(System.in);
		int T=cin.nextInt();
		for(int t=1;t<=T;t++){
			int n=cin.nextInt();
			int k=cin.nextInt();
			int []a=new int[n+1];
			int [][]dp=new int[n+1][k+1];
			for(int i=1;i<=n;i++)a[i]=cin.nextInt();
			for(int i=1;i<=n;i++){
				for(int j=0;j<=k;j++){
					dp[i][j]=dp[i-1][j];
					for(int m=1;j+m*a[i]<=k;m++){
						dp[i][j]=Math.max(dp[i][j], dp[i-1][j+m*a[i]]+m*a[i]);
					}
				}
			}
			/*for(int i=1;i<=n;i++){
				for(int j=0;j<=k;j++)
					System.out.print(dp[i][j]+" ");
				System.out.println();
			}*/
			int max=Integer.MIN_VALUE;
			for(int j=0;j<=k;j++)
				if(dp[n][j]>max)max=dp[n][j];
			System.out.println(max);
			
		}
	}
}
