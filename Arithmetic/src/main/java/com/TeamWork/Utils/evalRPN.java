package com.TeamWork.Utils;

import java.util.Stack;

public class evalRPN {


    public static ProperFraction evaluateExpr(Stack<Object> stack) {

        ProperFraction res = new ProperFraction();

        if (!stack.empty()) {
            res = (ProperFraction) stack.pop();
        }

        while (!stack.empty() && !( (String) stack.peek() == ")")) {

            String sign = (String) stack.pop();

            if (sign == "+") {
                res = Caculate.caculate((ProperFraction) stack.pop(),res,"+");
            } else {
                res = Caculate.caculate((ProperFraction) stack.pop(), res, "-");
            }
        }
        return res;
    }

    /**
     * 利用栈直接计算四则运算结果
     * @param s
     * @return answer
     */
    public static ProperFraction calculate(String s) {

        ProperFraction operand = new ProperFraction();
        int it = 0;
        int tag = 0;
        int n = 0;
        Stack<Object> stack = new Stack<Object>();
        for (int i = s.length() - 1; i >= 0; i--) {

            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {

                // Forming the operand - in reverse order.
                it = (int) Math.pow(10, n) * (int) (ch - '0') + it;
                n += 1;

            } else if (ch != ' ') {
                if (tag == 1){
                    operand.setDenominator(it);
                    tag = 0;
                    if (n != 0) {
                        stack.push(operand);
                        n = 0;
                        operand = new ProperFraction();

                    }
                }
                if (ch =='/'){
                    if (tag == 0){
                        operand.setMolecular(it);
                        tag = 1;
                    }
                }

                if (ch == '(') {

                    ProperFraction res = evaluateExpr(stack);
                    stack.pop();

                    // Append the evaluated result to the stack.
                    // This result could be of a sub-expression within the parenthesis.
                    stack.push(res);

                } else {
                    // For other non-digits just push onto the stack.
                    stack.push(operand);
                }
            }
        }

        //Push the last operand to stack, if any.
        if (n != 0) {
            stack.push(operand);
        }

        // Evaluate any left overs in the stack.
        return evaluateExpr(stack);
    }



}
