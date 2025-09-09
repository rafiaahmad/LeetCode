# [Count Inversions](https://www.geeksforgeeks.org/problems/inversion-of-array-1587115620/1)
## Medium
Given an array of integers arr[]. You have to find the Inversion Count of the array.&nbsp;Note :&nbsp;Inversion count is the number of pairs of elements (i, j) such that i &lt; j and arr[i] &gt; arr[j].
Examples:
Input: arr[] = [2, 4, 1, 3, 5]Output: 3
Explanation: The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
Input: arr[] = [2, 3, 4, 5, 6]Output: 0
Explanation: As the sequence is already sorted so there is no inversion count.
Input: arr[] = [10, 10, 10]Output: 0
Explanation: As all the elements of array are same, so there is no inversion count.
Constraints:1 ≤ arr.size()&nbsp;≤ 1051 ≤ arr[i] ≤ 104