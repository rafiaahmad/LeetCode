# [Min distance between two given nodes of a Binary Tree](https://www.geeksforgeeks.org/problems/min-distance-between-two-given-nodes-of-a-binary-tree/1)
## Hard
Given a binary tree with n nodes and two node values, a and b, your task is to find the minimum distance between them. The given two nodes are guaranteed to be in the binary tree and all node values are unique.
Examples :
Input: Tree = [1, 2, 3]
&nbsp;       1
&nbsp;     /  \
&nbsp;    2    3
a = 2, b = 3
Output: 2
Explanation: We need the distance between 2 and 3. Being at node 2, we need to take two steps ahead in order to reach node 3. The path followed will be: 2 -&gt; 1 -&gt; 3. Hence, the result is 2. 
Input: Tree = [11, 22, 33, 44, 55, 66, 77]
&nbsp;       11
&nbsp;     /   \
&nbsp;    22  33    /  \  /  \  44 55 66 77
a = 77, b = 22
Output: 3
Explanation: We need the distance between 77 and 22. Being at node 77, we need to take three steps ahead in order to reach node 22. The path followed will be: 77 -&gt; 33 -&gt; 11 -&gt; 22. Hence, the result is 3.
Input: Tree = [1, 2, 3]
&nbsp;       1
&nbsp;     /  \
&nbsp;    2    3
a = 1, b = 3
Output: 1
Constraints:2 &lt;= number of nodes &lt;= 105