# [Count distinct pairs with difference k](https://www.geeksforgeeks.org/problems/count-distinct-pairs-with-difference-k1233/1)
## Medium
Given an integer array of size n and a non-negative integer k, count all distinct pairs with a difference equal to k, i.e., A[ i ] - A[ j ] = k.&nbsp;
Example 1:
Input: array = {1, 5, 4, 1, 2}, k = 0
Output: 1
Explanation: There is only one pair (1, 1) whose difference equal to 0.

Example 2;
Input: array = {1, 5, 3}, k = 2
Output: 2
Explanation: There are two pairs (5, 3) and (1, 3) whose difference equal to 2.

Your Task:You don't need to read or print anything. Your task is to complete the function&nbsp;TotalPairs() which takes array and k as input parameters and returns the count of all distinct pairs.
Expected Time Complexity:&nbsp;O(n)Expected Space Complexity:&nbsp;O(n)
Constraints:2 &lt;= n &lt;= 1040 &lt;= k &lt;= 1041 &lt;= nums[i] &lt;= 106