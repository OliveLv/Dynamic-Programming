/**  
 * https://www.hackerrank.com/challenges/stockmax 
 * Problem Statement

Your algorithms have become so good at predicting the market that you now know what the share price of Wooden Orange Toothpicks Inc. (WOT) will be for the next N days.

Each day, you can either buy one share of WOT, sell any number of shares of WOT that you own, or not make any transaction at all. What is the maximum profit you can obtain with an optimum trading strategy?

Input

The first line contains the number of test cases T. T test cases follow:

The first line of each test case contains a number N. The next line contains N integers, denoting the predicted price of WOT shares for the next N days.

Output

Output T lines, containing the maximum profit which can be obtained for the corresponding test case.

Constraints

1 <= T <= 10 
1 <= N <= 50000

All share prices are between 1 and 100000

Sample Input

3
3
5 3 2
3
1 2 100
4
1 3 1 2
Sample Output

0
197
3
Explanation

For the first case, you cannot obtain any profit because the share price never rises. 
For the second case, you can buy one share on the first two days, and sell both of them on the third day. 
For the third case, you can buy one share on day 1, sell one on day 2, buy one share on day 3, and sell one share on day 4.
 * @Title: StockMaximize.java 
 * @author lxh  
 * @date Aug 26, 2015 7:28:56 PM  
 * 
 */
package com.DP;

import java.util.Scanner;

public class StockMaximize {
	public static void main(String []args){
		Scanner cin=new Scanner(System.in);
		int T=cin.nextInt();
		// according to http://stackoverflow.com/questions/9514191/maximizing-profit-for-given-stock-quotes
		for(int t=0;t<T;t++){
			int n=cin.nextInt();
			long a[]=new long[n];
			for(int i=0;i<n;i++)a[i]=cin.nextLong();
			long S[]=new long[n];
			S[n-1]=a[n-1];
			for(int i=n-2;i>=0;i--)
				S[i]=Math.max(S[i+1], a[i]);
			long ps=0;
			for(int i=0;i<n;i++)
				ps+=Math.max(0, S[i]-a[i]);
			System.out.println(ps);
		}
/*		for(int t=0;t<T;t++){
			int n=cin.nextInt();
			long []a=new long[n+1];
			for(int i=1;i<=n;i++)
				a[i]=cin.nextLong();
			long [][]f=new long[n+1][n+1];
			for(int i=1;i<=n;i++){
				for(int j=0;j<i;j++)
					f[i][0]=Math.max(f[i][0], f[i-1][j]+j*a[i]);
				for(int j=1;j<i;j++){
					f[i][j]=Math.max(f[i-1][j], f[i-1][j-1]-a[i]);
				}
				f[i][i]=f[i-1][i-1]-a[i];
			}
			long max=Long.MIN_VALUE;
			for(int i=0;i<=n;i++)
				max=Math.max(max, f[n][i]);
			System.out.println(max);
		}*/
	}
}
