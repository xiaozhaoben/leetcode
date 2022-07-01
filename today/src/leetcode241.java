import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * 241. 为运算表达式设计优先级
 * */
public class leetcode241 {

//    static List<Integer> ans = new ArrayList<>();
//
//    public static List<Integer> diffWaysToCompute(String expression) {
//        List<Character> symbol = new ArrayList<>();
//        List<Integer> num = new ArrayList<>();
//        StringBuilder a = new StringBuilder();
//        for (int i = 0; i < expression.length(); i++){
//            if (expression.charAt(i) < '0'){
//                symbol.add(expression.charAt(i));
//                num.add(Integer.valueOf(a.toString()));
//                a = new StringBuilder();
//            }else {
//                a.append(expression.charAt(i));
//            }
//        }
//        num.add(Integer.valueOf(a.toString()));
//        dfs(symbol, num);
//        return ans;
//    }
//
//    public static void dfs(List<Character> symbol, List<Integer> num){
//        if (symbol.size() == 0){
//            System.out.println(num.get(0));
//            ans.add(num.get(0));
//        }
//        int length = symbol.size();
//        for (int i = 0; i < length; i++){
//            int a = num.get(i), b = num.get(i + 1);
//            char s = symbol.get(i);
//            System.out.println(a + " " + s +  " " + b);
//            num.set(i, function(a, symbol.get(i), b));
//            num.remove(i + 1);
//            symbol.remove(i);
//            dfs(symbol, num);
//            num.add(i + 1, b);
//            num.set(i, a);
//            symbol.add(i, s);
//        }
//    }
//
//    public static int function(int a, char symbol, int b){
//        switch (symbol){
//            case '-' :
//                return a - b;
//            case '+' :
//                return a + b;
//            case '*' :
//                return a * b;
//            case '/' :
//                return a / b;
//            default:
//                System.out.println("未知符号");
//        }
//        return 0;
//    }
//
//    public static void main(String[] args) {
//        System.out.println(diffWaysToCompute("2*3-4*5"));
//    }
    //正确解法
    class Solution {
        //添加一个 map
        HashMap<String,List<Integer>> map = new HashMap<>();
        public List<Integer> diffWaysToCompute(String input) {
            if (input.length() == 0) {
                return new ArrayList<>();
            }
            //如果已经有当前解了，直接返回
            if(map.containsKey(input)){
                return map.get(input);
            }
            List<Integer> result = new ArrayList<>();
            int num = 0;
            int index = 0;
            while (index < input.length() && !isOperation(input.charAt(index))) {
                num = num * 10 + input.charAt(index) - '0';
                index++;
            }
            if (index == input.length()) {
                result.add(num);
                //存到 map
                map.put(input, result);
                return result;
            }
            for (int i = 0; i < input.length(); i++) {
                if (isOperation(input.charAt(i))) {
                    List<Integer> result1 = diffWaysToCompute(input.substring(0, i));
                    List<Integer> result2 = diffWaysToCompute(input.substring(i + 1));
                    for (int j = 0; j < result1.size(); j++) {
                        for (int k = 0; k < result2.size(); k++) {
                            char op = input.charAt(i);
                            result.add(caculate(result1.get(j), op, result2.get(k)));
                        }
                    }
                }
            }
            //存到 map
            map.put(input, result);
            return result;
        }

        private int caculate(int num1, char c, int num2) {
            switch (c) {
                case '+':
                    return num1 + num2;
                case '-':
                    return num1 - num2;
                case '*':
                    return num1 * num2;
            }
            return -1;
        }

        private boolean isOperation(char c) {
            return c == '+' || c == '-' || c == '*';
        }
    }

}
