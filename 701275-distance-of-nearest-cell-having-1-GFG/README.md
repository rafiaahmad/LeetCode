# [Distance of nearest cell having 1](https://www.geeksforgeeks.org/problems/distance-of-nearest-cell-having-1-1587115620/1)
## Medium
Given a binary grid[][],&nbsp;where each cell contains either 0 or 1, find the distance of the nearest 1&nbsp;for every cell in the grid.The distance between two cells (i1, j1)&nbsp; and (i2, j2) is calculated as |i1 - i2| + |j1 - j2|.&nbsp;You need to return a matrix of the same size, where each cell (i, j) contains the minimum distance from grid[i][j] to the nearest cell having value 1.
Note:&nbsp;It is guaranteed that there is at least one cell with value 1 in the grid.
Examples
Input: grid[][] = [[0, 1, 1, 0],                 [1, 1, 0, 0],                 [0, 0, 1, 1]]
Output: [[1, 0, 0, 1],         [0, 0, 1, 1],         [1, 1, 0, 0]]
Explanation: The grid is -
- 0's at (0,0), (0,3), (1,2), (1,3), (2,0) and (2,1) are at a distance of 1 from 1's at (0,1), (0,2), (0,2), (2,3), (1,0) and (1,1) respectively.

Input: grid[][] = [[1, 0, 1],                 [1, 1, 0],                 [1, 0, 0]]
Output: [[0, 1, 0],         [0, 0, 1],         [0, 1, 2]]
Explanation: The grid is -
- 0's at (0,1), (1,2), (2,1) and (2,2) are at a  distance of 1, 1, 1 and 2 from 1's at (0,0), (0,2), (2,0) and (1,1) respectively.

Constraints:1 ≤ grid.size() ≤ 2001 ≤ grid[0].size() ≤ 200