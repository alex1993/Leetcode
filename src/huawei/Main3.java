package huawei;

import java.util.*;

/**
 * Script Created by daidai on 2017/6/28.
 */
public class Main3 {

    public static void main(String[] args) {
        Stack<String> operator = new Stack<>();
        Stack<List<String>> operand = new Stack<>();
        operand.push(new ArrayList<>());

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == ' ') {
                    continue;
                }
                if (chars[i] == '(') {
                    int spaceIndex = s.indexOf(' ', i + 1);
                    String op = s.substring(i + 1, spaceIndex);
                    operator.push(op);
                    i = spaceIndex;
                    operand.push(new ArrayList<>());
                    continue;
                }
                if (chars[i] == '"') {
                    int quoteIndex = s.indexOf('"', i + 1);
                    String num = s.substring(i + 1, quoteIndex);
                    operand.peek().add(num);
                    i = quoteIndex;
                    continue;
                }
                while (i < chars.length && chars[i] == ')') {
                    String op = operator.pop();
                    switch (op) {
                        case "quote":
                            String quoteRes = operand.pop().get(0);
                            operand.peek().add(quoteRes);
                            break;
                        case "combine":
                            StringBuilder sb = new StringBuilder();
                            List<String> nums = operand.pop();
                            for (String num : nums) {
                                sb.append(num);
                            }
                            operand.peek().add(sb.toString());
                            break;
                        case "search":
                            List<String> pop = operand.pop();
                            String search = pop.get(0);
                            String pattern = pop.get(1);
                            int index = search.indexOf(pattern);
                            String searchRes = index < 0 ? "" : search.substring(index);
                            operand.peek().add(searchRes);
                            break;
                        case "reverse":
                            String revRes = new StringBuilder(operand.pop().get(0)).reverse().toString();
                            operand.peek().add(revRes);
                    }
                    i++;
                }
            }
            System.out.println("\"" + operand.pop().get(0) + "\"");
            operand.clear();
            operator.clear();
            operand.push(new ArrayList<>());
        }
    }
}
