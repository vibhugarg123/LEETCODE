// Given an integer n, return the number of trailing zeroes in n!.

// Follow up: Could you write a solution that works in logarithmic time complexity?

// [Problem-172]Factorial Trailing Zeroes

// Example 1:

// Input: n = 3
// Output: 0
// Explanation: 3! = 6, no trailing zero.
// Example 2:

// Input: n = 5
// Output: 1
// Explanation: 5! = 120, one trailing zero.
// Example 3:

// Input: n = 0
// Output: 0

// Constraints:

// 0 <= n <= 104

/*
0!= 1= 0 
1!= 1= 0 
2!= 2= 0 [Prime factor:2]
3!= 3*2!  = 0   [Prime factor: 2^1*3^1]
4!= 4*3!  = 0   [Prime factor: 2^3*3^1]
5!= 5*4!  = 1   [Prime factor: 2^3*3^1*5^1]
6!= 720   = 1   [Prime factor: 2^4*3^2*5^1]
7!= 5040  = 1   [Prime factor: 2^4*3^2*5^1*7^1]
8!= 40320 = 1   [Prime factor: 2^7*3^2*5^1*7^1]
9!= 362880= 1   [Prime factor: 2^7*3^4*5^1*7^1]
10!= 3628800 =2 [Prime factor: 2^8*3^4*5^2*7^1]
*/

// Pattern: As 10=2*5 , hence count number of pairs of (2*5) since, count(2) will always be greater, hence,
// Number of 5 as prime factor in that number
// Trailing 0s in n! = Count of 5s in prime factors of n!
//                   = floor(n/5) + floor(n/25) + floor(n/125) + ....
#include <bits/stdc++.h>
using namespace std;
int trailingZeroes(int N)
{
    int count = 0;
    for (int i = 5; N / i >= 1; i = i * 5)
    {
        count += (N / i);
    }
    return count;
}
int main()
{
    int N;
    cin >> N;
    cout << trailingZeroes(N) << endl;
}