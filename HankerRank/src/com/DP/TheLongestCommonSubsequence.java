/**   
 * https://www.hackerrank.com/challenges/dynamic-programming-classics-the-longest-common-subsequence
 * Problem Statement

A subsequence is a sequence that can be derived from another sequence by deleting some elements without changing the order of the remaining elements. Longest common subsequence (LCS) of 2 sequences is a subsequence, with maximal length, which is common to both the sequences. 

Given two sequence of integers, A=[a1,a2,¡­,an] and B=[b1,b2,¡­,bm], find any one longest common subsequence.

In case multiple solutions exist, print any of them. It is guaranteed that at least one non-empty common subsequence will exist.

Recommended References

This Youtube video tutorial explains the problem and its solution quite well.



Input Format

First line contains two space separated integers, n and m, where n is the size of sequence A, while m is size of sequence B. In next line there are n space separated integers representing sequence A, and in third line there are m space separated integers representing sequence B.

n m
A1 A2 ¡­ An 
B1 B2 ¡­ Bm  
Constraints

1¡Ün¡Ü100 
1¡Üm¡Ü100 
0¡Üai<1000,where i¡Ê[1,n] 
0¡Übj<1000,where j¡Ê[1,m]

Output Format

Print the longest common subsequence and each element should be separated by at least one white-space. In case of multiple answers, print any one of them.

Sample Input

5 6
1 2 3 4 1
3 4 1 2 1 3
Sample Output

1 2 3
Explanation

There is no common subsequence with length larger than 3. And "1 2 3", "1 2 1", "3 4 1" are all correct answers.
 * @Title: TheLongestCommonSubsequence.java 
 * @author lxh  
 * @date Aug 27, 2015 8:23:12 PM  
 * 
 */
package com.DP;

import java.util.Scanner;

public class TheLongestCommonSubsequence {
	public static void main(String []args){
		Scanner cin=new Scanner(System.in);
		int n=cin.nextInt();
		int m=cin.nextInt();
		int []a=new int[n+1];
		int []b=new int[m+1];
		int [][]dp=new int[n+1][m+1];
		int [][]f=new int[n+1][m+1];
		for(int i=1;i<=n;i++)a[i]=cin.nextInt();
		for(int i=1;i<=m;i++)b[i]=cin.nextInt();
		for(int i=1;i<=n;i++){
			for(int j=1;j<=m;j++){
				f[i][j]=Math.max(f[i-1][j], f[i][j-1]);
				if(a[i]==b[j])f[i][j]=Math.max(f[i][j],f[i-1][j-1]+1);
			}
		}
/*		for(int i=1;i<=n;i++){
			for(int j=1;j<=m;j++)
				System.out.print(f[i][j]+" ");
			System.out.println();
		}*/
		int l=f[n][m];
		int []res=new int[l];
		int x=n;
		int y=m;
		for(;l>0;){
			//System.out.println(x+" "+y+" "+a[x]+" "+b[y]+" "+f[x-1][y-1]+" "+l);
			if(a[x]==b[y]&&f[x-1][y-1]+1==l){
				res[--l]=a[x];
				x--;
				y--;
			}else if(f[x-1][y]==l)x--;
			else
				y--;
		}
		for(int i=0;i<f[n][m];i++){
			if(i!=0)System.out.print(" ");
			System.out.print(res[i]);
		}
	}
}
