# [Equilibrium Point](https://www.geeksforgeeks.org/problems/equilibrium-point-1587115620/1)
## Easy
Given an array of integers arr[], the task is to find the first equilibrium point&nbsp;in the array.
The equilibrium point in an array is an index (0-based indexing) such that the sum of all elements before&nbsp;that index is the&nbsp;same&nbsp;as the&nbsp;sum&nbsp;of elements&nbsp;after&nbsp;it.&nbsp;Return -1 if no such point exists.&nbsp;
Examples:
Input: arr[] = [1, 2, 0, 3]Output: 2 
Explanation: The sum of left of index 2 is 1 + 2 = 3 and sum on right of index 2 is 3.
Input: arr[] = [1, 1, 1, 1]Output: -1
Explanation: There is no equilibrium index in the array.
Input: arr[] = [-7, 1, 5, 2, -4, 3, 0]Output: 3
Explanation: The sum of left of index 3 is -7 + 1 + 5 = -1 and sum on right of index 3 is -4 + 3 + 0 = -1.
Constraints:3 &lt;= arr.size() &lt;= 105-104 &lt;= arr[i] &lt;= 104