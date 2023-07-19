/* Problem-168
Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.

For example:

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 
...
 

Example 1:

Input: columnNumber = 1
Output: "A"
Example 2:

Input: columnNumber = 28
Output: "AB"
Example 3:

Input: columnNumber = 701
Output: "ZY"
Example 4:

Input: columnNumber = 2147483647
Output: "FXSHRXW"
*/
/*
  decimal to base26
    26|701
  ---------
    26|26   Remainder: 25-> Append Ascii
  --------- Remainder: 0 -> "Append Z"
      |1    Break here! Write the string in reverse: ZY
 */
public class ExcelSheetColumnTitle168{
    public String convertToTitle(int columnNumber) {
        StringBuilder columnTitle=new StringBuilder();
        while(columnNumber>0){
            int rem= columnNumber%26;
            if(rem==0){
                columnTitle.append("Z");
                columnNumber=(columnNumber/26)-1;
            }else{
                columnTitle.append((char)(rem-1 + 'A'));
                columnNumber=columnNumber/26;
            }
        }
        return columnTitle.reverse().toString();
    }
    public static void main(String[]args) {
        ExcelSheetColumnTitle168 excelSheetColumnTitle168=new ExcelSheetColumnTitle168();
        System.out.println(excelSheetColumnTitle168.convertToTitle(701));
    }
}