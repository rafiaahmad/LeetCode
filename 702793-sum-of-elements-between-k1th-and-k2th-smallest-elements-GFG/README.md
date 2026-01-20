# [Sum of elements between k1'th and k2'th smallest elements](https://www.geeksforgeeks.org/problems/sum-of-elements-between-k1th-and-k2th-smallest-elements3133/1)
## Easy
Given an array A[]&nbsp;of N&nbsp;positive&nbsp;integers and two positive integers K1 and K2. Find the sum of all elements between K1th and&nbsp;K2th smallest elements of the array.&nbsp;It may be assumed that (1 &lt;= k1 &lt; k2 &lt;= n).
&nbsp;
Example 1:
Input:
N  = 7
A[] = {20, 8, 22, 4, 12, 10, 14}
K1 = 3, K2 = 6
Output:
26
Explanation:
3rd smallest element is 10
6th smallest element is 20
Element between 10 and 20 
12,14. Their sum = 26.
&nbsp;
Example 2:
Input
N = 6
A[] = {10, 2, 50, 12, 48, 13}
K1= 2, K2 = 6
Output:
73
&nbsp;
Your Task:&nbsp;&nbsp;You don't need to read input or print anything. Your task is to complete the function&nbsp;sumBetweenTwoKth()&nbsp;which takes the array A[], its size N and two integers K1 and K2 as inputs and returns the sum of all the elements between K1th and K2th smallest elements.&nbsp;
Expected Time Complexity: O(N. log(N))Expected Auxiliary Space: O(N)
&nbsp;
Constraints:1 ≤ N ≤ 1051 ≤ K1, K2 ≤ 105