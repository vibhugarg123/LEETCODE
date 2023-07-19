// [171] Given a string columnTitle that represents the column title as appear in an Excel sheet, return its corresponding column number.

// For example:

// A -> 1
// B -> 2
// C -> 3
// ...
// Z -> 26
// AA -> 27
// AB -> 28

//Approach: [Right to Left] Similar to binary to decimal number, here base=26
// F X S H R X W
// 6 5 4 3 2 1 0
// 26^0 * W = 23
// 26^1 * X = 624
// 26^2 * R = 12168
// 26^3 * H = 140608
// 26^4 * S = 8682544
// 26^5 * X = 285153024
// 26^6 * F = 1853494656
// Add = 23 + 624 + 12168 + 140608 + 8682544 + 285153024 + 1853494656= 2147483647

//Approach: [Left to Right] Similar to digit to decimal number
// 15   = (1   * 10)+5
// 155  = (15  * 10)+5
// 1559 = (155 * 10)+9
// number=(sum from previous * base) + new digit
// ADD- prev=0;
// 0  * 26 + 1=1
// 1  * 26 + 4=30
// 30 * 26 + 4=784

#include <bits/stdc++.h>
using namespace std;
int titleToNumber(string columnTitle)
{
    int columnNumber = 0;
    for (int i = columnTitle.size() - 1; i >= 0; i--)
    {
        columnNumber += pow(26, columnTitle.size() - 1 - i) * (columnTitle[i] - 65 + 1);
    }
    return columnNumber;
}
int main()
{
    string s;
    cin >> s;
    cout << titleToNumber(s) << endl;
}