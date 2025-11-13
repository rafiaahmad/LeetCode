# [Rat Maze With Multiple Jumps](https://www.geeksforgeeks.org/problems/rat-maze-with-multiple-jumps3852/1)
## Medium
A maze is given as n*n&nbsp;matrix of blocks where source block is the upper left most block i.e., matrix[0][0] and destination block is lower rightmost block i.e., matrix[n-1][n-1]. A rat starts from source and has to reach the destination. 
The rat can move in only two directions: first forward (if possible) or down. 
In the maze matrix, 0 means the block is the dead end and non-zero number means the block can be used in the path from source to destination. The non-zero value of mat[i][j] indicates number of maximum jumps rat can make from cell mat[i][j].&nbsp;
Return a maxtrix of size n*n in which&nbsp;1 at (i, j) represents the cell is taken into the path otherwise 0 .
Note : If multiple solutions exist, the shortest earliest hop will be accepted. For the same hop distance at any point, forward will be preferred over downward.&nbsp;
Example:
Input: {{2,1,0,0},{3,0,0,1},{0,1,0,1},
{0,0,0,1}}
Output: {{1,0,0,0},{1,0,0,1},{0,0,0,1},
{0,0,0,1}}
Explanation: Rat started with matrix[0][0] and 
can jump up to 2 steps right/down. First check 
matrix[0][1] as it is 1, next check 
matrix[0][2] ,this won't lead to the solution. 
Then check matrix[1][0], as this is 3(non-zero)
,so we can make 3 jumps to reach matrix[1][3]. 
From matrix[1][3] we can move downwards taking 
1 jump each time to reach destination at 
matrix[3][3].

Example 2:
Input: {{2,1,0,0},{2,0,0,1},{0,1,0,1},
{0,0,0,1}}
Output: {{-1}}
Explanation: As no path exists so, -1.

&nbsp;
Your Task:You don't need to read or print anyhting, Your task is to complete the function&nbsp;ShortestDistance()&nbsp;which takes the matrix as input parameter and returns a matrix of size n if path exists otherwise returns a matrix of 1x1 which contains -1. In output matrix, 1&nbsp;at (i, j) represents the cell is taken into the path otherwise 0 if any path exists.&nbsp;
Expected Time Complexity:&nbsp;O(n*n*k) where k is max(matrix[i][j])Expected Space Complexity:&nbsp;O(1)&nbsp;
Constraints:1 &lt;= n &lt;= 501 &lt;= matrix[i][j] &lt;= 20