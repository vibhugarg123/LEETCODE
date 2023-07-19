/*Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.

 Example 1:

Input: n = 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
Example 2:

Input: n = 2
Output: false

IF n=4
4^2= 16
1^2+6^2= 37
3^2+7^2= 58
5^2+8^2= 89
8^2+9^2= 145
1^2+4^2+5^2= 42
4^2+2^2=20
2^2+0^2=4 (again loop)

Similar process leads to two situations-
i)  Will lead to 1
ii) Will result in infinite loop
Reduced Problem to Detect Cycle 
- Floyd Cycle Detection Algorithm, slowPtr & fastPtr
- Using hashmap, if number appears again, return false
*/
//public class HappyNumber202 {
//    private int sumofsquaresOfDigits(int n){
//        int sum=0;
//        while(n!=0){
//            int rem=n%10;
//            sum+=(rem*rem);
//            n=n/10;
//        }
//        return sum;
//    }
//    // Let executions of while loop be k. Therefore, the time complexity is O(kd) if d denotes to counts of digits of n.
//    // Space Complexity: O(1)
//    public boolean isHappy(int n) {
//        int slowPtr=n, fastPtr=n;
//        do{
//            slowPtr= sumofsquaresOfDigits(slowPtr);
//            fastPtr= sumofsquaresOfDigits(sumofsquaresOfDigits(fastPtr));
//        }while(slowPtr!=fastPtr);
//        return slowPtr==1;
//    }
//
//    public boolean isHappyUsingHashMap(n){
//        HashSet<Integer> hs = new HashSet<Integer>();
//        while(true){
//            n=sumofsquaresOfDigits(n);
//            if (n==1){
//                return true;
//            }else if (hs.contains(n)){
//                return false;
//            }
//            hs.add(n);
//        }
//    }
//    public static void main(String[]args) {
//       int n=19;
//       HappyNumber202 happyNumber202=new HappyNumber202();
//       System.out.println(happyNumber202.isHappy(n));
//    }
//}

