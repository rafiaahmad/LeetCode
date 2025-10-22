# [Substrings with K Distinct](https://www.geeksforgeeks.org/problems/count-number-of-substrings4528/1)
## Medium
You are given a string s consisting&nbsp;of lowercase characters and an integer k, You have to count all possible substrings that have exactly k distinct characters.
Examples :
Input: s = "abc", k = 2
Output: 2
Explanation: Possible substrings are ["ab", "bc"]

Input: s = "aba", k = 2
Output: 3
Explanation: Possible substrings are ["ab", "ba", "aba"]
Input: s = "aa", k = 1
Output: 3Explanation: Possible substrings are ["a", "a", "aa"]
Constraints:1 ≤ s.size() ≤ 1061 ≤ k ≤ 26