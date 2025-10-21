# [Swapping pairs make sum equal](https://www.geeksforgeeks.org/problems/swapping-pairs-make-sum-equal4142/1)
## Medium
Given two arrays of integers a[] and b[], the task is to check if a pair of values (one value from each array) exists such that swapping the elements of the pair will make the sum of two arrays equal.
Examples :
Input: a[] = [4, 1, 2, 1, 1, 2], b[] = [3, 6, 3, 3]
Output: true
Explanation: Sum of elements in a[] = 11, Sum of elements in b[] = 15, To get same sum from both arrays, we can swap following values: 1 from a[] and 3 from b[]
Input: a[] = [5, 7, 4, 6], b[] = [1, 2, 3, 8]
Output: true
Explanation: We can swap 6 from array a[] and 2 from array b[]
Input: a[] = [3, 3], b[] = [6, 5, 6, 6]
Output: false
Constraints:1 ≤ a.size() ≤ 1061 ≤ b.size() ≤ 1061 ≤ a[i] ≤ 1031 ≤ b[i] ≤ 103