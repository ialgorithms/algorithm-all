package net.ijiangtao.tech.algorithms.algorithmall.algorithm.stack.evaluation;

import net.ijiangtao.tech.algorithms.algorithmall.datastructure.stack.Stack;
import net.ijiangtao.tech.algorithms.algorithmall.datastructure.stack.impl.IterableResizingArrayStack;

public class DijkstrasTwoStackAlgorithmForExpressionEvaluation {

    public Double cal(String expression) {

        String[] expressionArr = expression.split(" ");

        Stack<String> ops = new IterableResizingArrayStack<String>();
        Stack<Double> vals = new IterableResizingArrayStack<Double>();

        for (String s : expressionArr) {
            // Read token, push if operator.
            if (s.equals("(")) {
                ;
            } else if (s.equals("+")) {
                ops.push(s);
            } else if (s.equals("-")) {
                ops.push(s);
            } else if (s.equals("*")) {
                ops.push(s);
            } else if (s.equals("/")) {
                ops.push(s);
            } else if (s.equals("sqrt")) {
                ops.push(s);
            } else if (s.equals(")")) {
                // Pop, evaluate, and push result if token is ")"
                String op = ops.pop();
                double v = vals.pop();

                if (op.equals("+")) {
                    v = vals.pop() + v;
                } else if (op.equals("-")) {
                    v = vals.pop() - v;
                } else if (op.equals("*")) {
                    v = vals.pop() * v;
                } else if (op.equals("/")) {
                    v = vals.pop() / v;
                } else if (op.equals("sqrt")) {
                    v = Math.sqrt(v);
                }

                vals.push(v);
            }
            // Token not operator or paren: push double value.
            else {
                vals.push(Double.parseDouble(s));
            }
        }

        return vals.pop();
    }

}
