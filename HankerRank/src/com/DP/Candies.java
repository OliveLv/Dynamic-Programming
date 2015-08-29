/**   
 * Problem Statement

Alice is a kindergarden teacher. She wants to give some candies to the children in her class.  All the children sit in a line, and each  of them has a rating score according to his or her performance in the class.  Alice wants to give at least 1 candy to each child. If two children sit next to each other, then the one with the higher rating must get more candies. Alice wants to save money, so she needs to minimize the total number of candies.

Input Format

The first line of the input is an integer N, the number of children in Alice's class. Each of the following N lines contains an integer that indicates the rating of each child.

1 <= N <= 105 
1 <= ratingi <= 105

Output Format

Output a single line containing the minimum number of candies Alice must buy.

Sample Input

3  
1  
2  
2
Sample Output

4
Explanation

Here 1, 2, 2 is the rating. Note that when two children have equal rating, they are allowed to have different number of candies. Hence optimal distribution will be 1, 2, 1.
 * @Title: Candies.java 
 * @author lxh  
 * @date Aug 29, 2015 8:22:37 PM  
 * 
 */
package com.DP;

import java.util.Scanner;
// the solution is greedy method
public class Candies {
	public static void main(String []args){
		Scanner cin=new Scanner(System.in);
		long n=cin.nextLong();
		long []r=new long[(int)n];
		long []c=new long[(int)n];
		for(int i=0;i<n;i++){
			r[i]=cin.nextLong();
			c[i]=1;
		}
		// make sure the right max satisfies the condition
		for(int i=1;i<n;i++){
			if(r[i]>r[i-1])c[i]=c[i-1]+1;
		}
		// make sure the left max satisfies the condition
		for(int i=(int)n-2;i>=0;i--){
			if(r[i]>r[i+1]&&c[i]<=c[i+1])
				c[i]=c[i+1]+1;
		}
		int s=0;
		for(int i=0;i<n;i++)
			s+=c[i];
		System.out.println(s);
	}
}
