import java.util.List;
import java.util.ArrayList;

/// 17. Letter Combinations of a Phone Number
/// https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
/* 输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
/// 时间复杂度: O(2^len(s))
/// 空间复杂度: O(len(s))
class Solution {
    //建立 数字和字母的映射
    private String letterMap[] = {
                " ",    //0
                "",     //1
                "abc",  //2
                "def",  //3
                "ghi",  //4
                "jkl",  //5
                "mno",  //6
                "pqrs", //7
                "tuv",  //8
                "wxyz"  //9
    };
    
    private ArrayList<String> res; //存储最后的结果

    public List<String> letterCombinations(String digits) {  

        res = new ArrayList<String>();
        if(digits.equals(""))  // 不能进入到findCombination
            return res;

        findCombination(digits, 0, "");  // digits键盘数字组成的字符串 ， 第几个键盘数字（从0开始） ， 拼接得到的结果，存储在字符串中
        return res;
    }

    // s中保存了此时从digits[0...index-1]翻译得到的一个字母字符串 ,index是当前正在处理的数字位置
    // 寻找和digits[index]匹配的字母, 获得digits[0...index]翻译得到的解
    private void findCombination(String digits, int index, String s){

        System.out.println(index + " : " + s);
        if(index == digits.length()){   // "234"一个数字只取一个字母，因此已经得到一个解了
            res.add(s);
            System.out.println("get " + s + " , return");
            return;
        }

        Character c = digits.charAt(index);  // 把“23“对应的数字字符类型取出来
        assert  c.compareTo('0') >= 0 &&
                c.compareTo('9') <= 0 &&
                c.compareTo('1') != 0;
        String letters = letterMap[c - '0']; // 将字符类型的数字”1“转为int型的1，作为数组下标
        for(int i = 0 ; i < letters.length() ; i ++){     // 在这里回溯 因为不知道字母到底有多长，所以只能使用回溯的方式，否则直接使用多重for循环就好了
            System.out.println("digits[" + index + "] = " + c +" , use " + letters.charAt(i));
            findCombination(digits, index+1, s + letters.charAt(i));   // 2 取一个字母，3取后面的字母，然后2 取下一个字母，3接着取后面的字母，构成回溯
        }

        System.out.println("digits[" + index + "] = " + c + " complete, return");

        return;
    }

    private static void printList(List<String> list){
        for(String s: list)
            System.out.println(s);
    }

    public static void main(String[] args) {

        printList((new Solution()).letterCombinations("234"));
    }
}
