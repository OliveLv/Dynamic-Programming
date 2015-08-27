/** 
 * https://www.hackerrank.com/challenges/maxsubarray 
 * Problem Statement

Given an array A={a1,a2,…,aN} of N elements, find the maximum possible sum of a

Contiguous subarray
Non-contiguous (not necessarily contiguous) subarray.
Empty subarrays/subsequences should not be considered.

This Youtube video by Ben Wright might be useful to understand the Kadane algorithm for the maximum subarray in a 1-D sequence.



Input Format

First line of the input has an integer T. T cases follow. 
Each test case begins with an integer N. In the next line, N integers follow representing the elements of array A.

Constraints:

1≤T≤10
1≤N≤105
−104≤ai≤104
The subarray and subsequences you consider should have at least one element.

Output Format

Two, space separated, integers denoting the maximum contiguous and non-contiguous subarray. At least one integer should be selected and put into the subarrays (this may be required in cases where all elements are negative).

Sample Input

2 
4 
1 2 3 4
6
2 -1 2 3 4 -5
Sample Output

10 10
10 11
Explanation

In the first case: 
The max sum for both contiguous and non-contiguous elements is the sum of ALL the elements (as they are all positive).

In the second case: 
[2 -1 2 3 4] --> This forms the contiguous sub-array with the maximum sum. 
For the max sum of a not-necessarily-contiguous group of elements, simply add all the positive elements. 
 * @Title: TheMaximumSubarray.java 
 * @author lxh  
 * @date Aug 26, 2015 5:08:51 PM  
 * 
 */
package com.DP;

import java.util.Scanner;

public class TheMaximumSubarray {
	public static void main(String []args){
		Scanner cin=new Scanner(System.in);
		int T=cin.nextInt();
		for(int t=0;t<T;t++){
			int n=cin.nextInt();
			int sc=0,snc=0;
			int maxSC=Integer.MIN_VALUE,maxSNC=Integer.MIN_VALUE;
			//int []a=new int[n];
			for(int i=0;i<n;i++){
				int val=cin.nextInt();
				if(val>maxSNC)maxSNC=val;
				if(val>0)snc+=val;
				if(val+sc<val){
					sc=val;
				}else
					sc+=val;
				if(sc>maxSC)maxSC=sc;
			}
			if(sc>maxSC)maxSC=sc;
			if(maxSNC<0)System.out.println(maxSC+" "+maxSNC);
			else
				System.out.println(maxSC+" "+snc);
		}
	}
}
