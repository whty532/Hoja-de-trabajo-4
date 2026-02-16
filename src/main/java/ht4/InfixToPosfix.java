package ht4;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InfixToPosfix {

    public static String infixToPostfix(String infix, Stack<Character> opStack) {
        List<String> tokens = tokenize(infix);
        StringBuilder out = new StringBuilder();

        for (String tok : tokens) {
            if (isNumber(tok)) {
                out.append(tok).append(" ");
            } else if (tok.equals("(")) {
                opStack.push('(');
            } else if (tok.equals(")")) {
                while (!opStack.isEmpty() && opStack.peek() != '(') {
                    out.append(opStack.pop()).append(" ");
                }
                // sacar '('
                if (!opStack.isEmpty() && opStack.peek() == '(') opStack.pop();
            } else { // operador
                char op = tok.charAt(0);
                while (!opStack.isEmpty() && opStack.peek() != '('
                        && precedence(opStack.peek()) >= precedence(op)) {
                    out.append(opStack.pop()).append(" ");
                }
                opStack.push(op);
            }
        }

        while (!opStack.isEmpty()) {
            char top = opStack.pop();
            if (top != '(') out.append(top).append(" ");
        }

        return out.toString().trim();
    }

    public static int evalPostfix(String postfix, Stack<Integer> values) {
        String[] parts = postfix.trim().split("\\s+");
        for (String p : parts) {
            if (isNumber(p)) {
                values.push(Integer.valueOf(p));
            } else {
                Integer b = values.pop();
                Integer a = values.pop();
                if (a == null || b == null) return 0;

                char op = p.charAt(0);
                int r = apply(a, b, op);
                values.push(r);
            }
        }
        Integer res = values.pop();
        return res == null ? 0 : res;
    }

    private static int apply(int a, int b, char op) {
        if (op == '+') return a + b;
        if (op == '-') return a - b;
        if (op == '*') return a * b;
        if (op == '/') return a / b;   // asume b != 0
        if (op == '^') {
            int r = 1;
            for (int i = 0; i < b; i++) r *= a;
            return r;
        }
        return 0;
    }

    private static int precedence(char op) {
        if (op == '^') return 3;
        if (op == '*' || op == '/') return 2;
        if (op == '+' || op == '-') return 1;
        return 0;
    }

    private static boolean isNumber(String s) {
        if (s == null || s.isEmpty()) return false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    // Tokeniza multi-dígito, ignora espacios: "(10+20)*9" -> ["(", "10", "+", "20", ")", "*", "9"]
    private static List<String> tokenize(String s) {
        List<String> tokens = new ArrayList<>();
        int i = 0;

        while (i < s.length()) {
            char c = s.charAt(i);

            if (Character.isWhitespace(c)) {
                i++;
            } else if (Character.isDigit(c)) {
                StringBuilder num = new StringBuilder();
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num.append(s.charAt(i));
                    i++;
                }
                tokens.add(num.toString());
            } else if (c == '(' || c == ')' || isOperator(c)) {
                tokens.add(String.valueOf(c));
                i++;
            } else {
                // carácter raro, lo saltamos
                i++;
            }
        }

        return tokens;
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }
}
