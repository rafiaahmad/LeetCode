# [Handshakes](https://www.geeksforgeeks.org/problems/handshakes1303/1)
## Medium
We have N&nbsp;persons sitting on a round table. Any person can do a handshake with any other person. 

&nbsp; &nbsp; &nbsp;1
2&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;3
&nbsp; &nbsp; &nbsp;4

Handshake with 2-3 and 1-4 will cause cross.

In how many ways these N&nbsp;people can make handshakes so that no two handshakes cross each other.&nbsp;N would be even.&nbsp; 
&nbsp;

Example 1:

Input:
N = 2
Output:
1
Explanation:
{1,2} handshake is
possible.


Example 2:

Input:
N = 4
Output:
2
Explanation:
{{1, 2}, {3, 4}} are the
two handshakes possible.
{{1, 3}, {2, 4}} is another
set of handshakes possible.



Your Task:
You don't need to read input or print anything. Your task is to complete the function count()&nbsp;which takes&nbsp;an integer N&nbsp;as input parameters&nbsp;and returns an integer, the total number of handshakes possible so that no two handshakes cross each other.
&nbsp;

Expected Time Complexity: O(2N)
Expected Space Complexity: O(1)
&nbsp;

Constraints:
1 &lt;= N &lt;= 30
