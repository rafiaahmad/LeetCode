# [Reversing the equation](https://www.geeksforgeeks.org/problems/reversing-the-equation2205/1)
## Easy
Given a mathematical equation that contains only numbers and +, -, *, /. Print the equation in reverse, such that the equation is reversed, but the numbers remain the same.It is guaranteed that the given equation is valid, and there are no leading zeros.
Example 1:
Input:
S = "20-3+5*2"
Output: 2*5+3-20
Explanation: The equation is reversed with
numbers remaining the same.

Example 2:
Input: 
S = "5+2*56-2/4"
Output: 4/2-56*2+5
Explanation: The equation is reversed with
numbers remaining the same.

Your Task:You don't need to read input or print anything. Your task is to complete the function&nbsp;reverseEqn()&nbsp;which takes the string S representing the equation as input and returns the resultant string representing the equation in reverse.
Expected Time Complexity:&nbsp;O(|S|).Expected Auxiliary Space:&nbsp;O(|S|).
Constraints:1&lt;=|S|&lt;=105The string contains only the characters '0' - '9', '+', '-', '*', and '/'.
 S = "20-3+5*2"
Output: 2*5+3-20

-> Start from end 

4 -> this is NE (+, -, *, /) Push it into stack -> Stack.push(4)
/ -> Symbol
 -> stack.pop() -> rev =  4
-> concatenate -> rev = 2 + (/) = 4/

2 -> this is NE (+, -, *, /) Push it into stack -> Stack.push(2)
- -> Symbol
 -> stack.pop() -> rev =  4/ + (2) = 4/2
-> concatenate -> rev = 4/2 + (-) = 4/2-


6 -> this is NE (+, -, *, /) Push it into stack -> Stack.push(6)
5 -> this is NE (+, -, *, /) Push it into stack -> Stack.push(65)
* -> Symbol
 -> stack.pop() -> rev =  rev + (5) = 4/2-5
-> concatenate -> rev = rev + (6) = 4/2-56
->  concatenate -> rev = rev + () = 4/2-56*

2 -> this is NE (+, -, *, /) Push it into stack -> Stack.push(2)
+ -> Symbol
 -> stack.pop() -> rev  += 2 //  4/2-56*2
->  concatenate -> rev = rev + () = 4/2-56*2+

5 -> this is NE (+, -, *, /) Push it into stack -> Stack.push(5)
 “ “ -> stack.pop() = rev += 4/2-56*2+5

&nbsp;
