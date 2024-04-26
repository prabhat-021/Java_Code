import java.util.Stack;

public class prefixAndPostfix {
    public static void main(String[] args) {

    }

    static String infixToPostfix(String str) {
        Stack<String> val = new Stack<>();
        Stack<Character> op = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int ascaii = (int) ch;
            if (ascaii > 48 || ascaii < 58) val.push("" + (ascaii - 48));
            else if (op.peek() == '(' || op.size() == 0 || ch == '(') op.push(ch);
            else if (ch == ')') {
                while (op.peek() != '(') {
                    String v2 = val.pop();
                    String v1 = val.pop();
                    if (op.peek() == '+') val.push(v1 + v2 + "+");
                    if (op.peek() == '-') val.push(v1 + v2 + "-");
                    if (op.peek() == '*') val.push(v1 + v2 + "*");
                    if (op.peek() == '/') val.push(v1 + v2 + "/");
                    op.pop();
                }
                op.pop();
            } else {
                {
                    if (ch == '+' || ch == '-') {
//                  work
                        String v2 = val.pop();
                        String v1 = val.pop();
                        if (op.peek() == '+') val.push(v1 + v2 + "+");
                        if (op.peek() == '-') val.push(v1 + v2 + "-");
                        if (op.peek() == '*') val.push(v1 + v2 + "*");
                        if (op.peek() == '/') val.push(v1 + v2 + "/");
                        op.pop();
//                    push
                        op.push(ch);
                    } else if (ch == '*' || ch == '/') {
                        if (op.peek() == '*' || op.peek() == '/') {
                            String v2 = val.pop();
                            String v1 = val.pop();
//                            if (op.peek() == '+') val.push(v1 + v2 + "+");
//                            if (op.peek() == '-') val.push(v1 + v2 + "-");
                            if (op.peek() == '*') val.push(v1 + v2 + "*");
                            if (op.peek() == '/') val.push(v1 + v2 + "/");
                            op.pop();
//                      push
                            op.push(ch);
                        } else op.push(ch);
                    }
                }
            }
            while (val.size() > 1) {
                String v2 = val.pop();
                String v1 = val.pop();
                if (op.peek() == '+') val.push(v1 + v2 + "+");
                if (op.peek() == '-') val.push(v1 + v2 + "-");
                if (op.peek() == '*') val.push(v1 + v2 + "*");
                if (op.peek() == '/') val.push(v1 + v2 + "/");
                op.pop();
            }
            System.out.println(val.peek());
        }
        return val.pop();
    }
}
