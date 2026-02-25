# [Shortest Source to Destination Path](https://www.geeksforgeeks.org/problems/shortest-source-to-destination-path3544/1)
## Medium
Given a&nbsp;2D binary matrix A(0-based index) of dimensions NxM. Find the minimum number of steps required to reach from (0,0) to (X, Y).Note: You can only move left, right, up and down, and only through cells that contain 1.
Example 1:
Input:
N=3, M=4
A=[[1,0,0,0], 
   [1,1,0,1],   [0,1,1,1]]
X=2, Y=3 
Output:
5
Explanation:
The shortest path is as follows:
(0,0)-&gt;(1,0)-&gt;(1,1)-&gt;(2,1)-&gt;(2,2)-&gt;(2,3).
Example 2:
Input:
N=3, M=4
A=[[1,1,1,1],
   [0,0,0,1],   [0,0,0,1]]
X=0, Y=3
Output:
3
Explanation:
The shortest path is as follows:
(0,0)-&gt;(0,1)-&gt;(0,2)-&gt;(0,3).
Your Task:You don't need to read input or print anything. Your task is to complete the function shortestDistance() which takes the integer N, M, X, Y, and the 2D binary matrix A as input parameters and returns the minimum number of steps required to go from (0,0) to (X, Y).If it is impossible to go from (0,0) to&nbsp;(X, Y),then function returns -1. If value of the cell (0,0) is 0&nbsp;(i.e&nbsp; A[0][0]=0)&nbsp;then return -1.
Constraints:1 &lt;= N,M &lt;= 2500 &lt;= X &lt; N0 &lt;= Y &lt; M0 &lt;= A[i][j] &lt;= 1