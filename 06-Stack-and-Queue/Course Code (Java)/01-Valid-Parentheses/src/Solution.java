import java.util.Stack;

// 20. Valid Parentheses
// https://leetcode.com/problems/valid-parentheses/description/
// 括号匹配问题
// 时间复杂: O(n)
// 空间复杂: O(n)
public class Solution {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<Character>(); //引入一个栈，使进入和出去的元素倒个顺序
        for( int i = 0 ; i < s.length() ; i ++ ){
            if( s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')  //如果是左括号，就直接入栈
                stack.push(s.charAt(i));
            else{  //都是右括号了

                if( stack.size() == 0 )   //栈已经空了
                    return false;

                Character c = stack.pop();  //取出栈顶的左括号

                Character match;
                if( s.charAt(i) == ')' )  //字符串的下一个元素是右括号
                    match = '(';          //右字符没法和栈中的左括号比较，手动的转换成对应的左括号字符 才能和栈中左括号比较
                else if( s.charAt(i) == ']' )
                    match = '[';
                else{
                    assert s.charAt(i) == '}';
                    match = '{';
                }

                if(c != match)   // 栈中取出来的字符 ！= 预期的左侧字符
                    return false;
            }
        }

        if( stack.size() != 0 ) //循环已经结束，表示已经没有括号了，那栈也应该刚好匹配完
            return false;

        return true;
    }

    private static void printBool(boolean b){
        System.out.println(b ? "True" : "False");
    }

    public static void main(String[] args) {

        printBool((new Solution()).isValid("()"));
        printBool((new Solution()).isValid("()[]{}"));
        printBool((new Solution()).isValid("(]"));
        printBool((new Solution()).isValid("([)]"));
    }
}
