package net.ijiangtao.tech.algorithms.algorithmall.algorithm.stack.checker;

import net.ijiangtao.tech.algorithms.algorithmall.datastructure.stack.Stack;
import net.ijiangtao.tech.algorithms.algorithmall.datastructure.stack.impl.IterableResizingArrayStack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 括号必须成对出现，且左括号必须在右括号之前出现，此程序基于栈结构，用于检测常用括号是否为成对出现，并表达式输出是否合法。
 */
public class LegalParenthesesChecker {

    private static final String BRACKET="<>()（）〈〉‹›﹛﹜『』〖〗[]《》﹝﹞〔〕{}「」【】︵︶︷︸︿﹀︹︺︽︾﹁﹂﹃﹄︻︼";

    public static boolean check(String expression) {

        //如果传入的表达式为空则不需要进行括号成对判断
        if (null == expression || expression.length() < 1) {
            return true;
        }

        //将传入的表达式拆分为char数组
        char[] expressionsChars = expression.toCharArray();

        //将所有需要判断的括号拆分为char数组并进行sort，其中index为偶数的永远是左半个括号，index为奇数的是右半个括号
        char[] brackets = BRACKET.toCharArray();
        //使用binarySearch之前，需要sort数组
        Arrays.sort(brackets);

        //用于保存栈容器和括号之间的对应关系
        Map<Character, Stack> map = new HashMap<>();

        //遍历表达式的每个字符
        for (char c : expressionsChars) {
            //判断该字符是否为括号
            int index = Arrays.binarySearch(brackets, c);
            //负数，不是括号，不需要处理
            if (index < 0) {
                continue;
            }
            //偶数，是左括号，则放入栈中
            if (index % 2 == 0) {
                //取出map中该左括号对应的栈容器
                Stack<Character> stack = map.get(c);
                //如果该左括号对应的key是第一次存入map，则创建一个栈容器
                if (null == stack) {
                    stack = new IterableResizingArrayStack<>();
                }
                stack.push(c);
                map.put(c, stack);
            } else {
                //奇数，是右括号，则先找到该右括号对应的左括号
                char left = brackets[index - 1];
                //取出左括号对应的栈容器中的值
                Stack<Character> stack = map.get(left);
                //如果该右括号没有对应的左括号与之匹配，则表示此表达式中的括号不成对，不合法
                if (null == stack || stack.size() < 1) {
                    return false;
                } else {
                    stack.pop();
                    continue;
                }

            }

        }

        //如果map中还有左侧括号，表示左侧括号比右侧多，则返回false
        for (char k : map.keySet()) {
            if(!map.get(k).isEmpty()){
                return false;
            }
        }

        return true;
    }
}
