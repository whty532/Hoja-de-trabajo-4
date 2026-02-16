package ht4;

public class PostfixCalculator {

    public static Integer evaluate(String postfix, MyStack<Integer> stack) {
        if (postfix == null) return null;
        postfix = postfix.trim();
        if (postfix.isEmpty()) return null;

        String[] parts = postfix.split("\\s+");

        for (String p : parts) {
            if (isNumber(p)) {
                stack.push(Integer.valueOf(p));
            } else if (p.length() == 1 && isOperator(p.charAt(0))) {
                Integer b = stack.pop();
                Integer a = stack.pop();
                if (a == null || b == null) return null;

                char op = p.charAt(0);

                // errores comunes:
                if (op == '/' && b == 0) return null;
                if (op == '%' && b == 0) return null;

                int r = apply(a, b, op);
                stack.push(r);
            } else {
                // token inválido
                return null;
            }
        }

        Integer result = stack.pop();
        // si quedaron cosas extra, está mal formada
        if (!stack.isEmpty()) return null;

        return result;
    }

    private static int apply(int a, int b, char op) {
        if (op == '+') return a + b;
        if (op == '-') return a - b;
        if (op == '*') return a * b;
        if (op == '/') return a / b;
        if (op == '%') return a % b;
        if (op == '^') {
            int r = 1;
            for (int i = 0; i < b; i++) r *= a;
            return r;
        }
        return 0;
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '%' || c == '^';
    }

    private static boolean isNumber(String s) {
        if (s == null || s.isEmpty()) return false;
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) return false;
        }
        return true;
    }
}