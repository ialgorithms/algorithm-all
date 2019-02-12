package net.ijiangtao.tech.algorithms.algorithmall.datastructure.stack.impl;

import java.math.BigDecimal;

public class IterableResizingArrayStackTests {
    public static void main(String[] args) {

        IterableResizingArrayStack<Float> resizingArrayStack = new IterableResizingArrayStack<>();

        System.out.println("resizingArrayStack : size=" + resizingArrayStack.size() + ",isEmpty=" + resizingArrayStack.isEmpty());

        resizingArrayStack.push(new Float(100.001));
        resizingArrayStack.push(new Float(202.022));
        System.out.println("resizingArrayStack : size=" + resizingArrayStack.size() + ",isEmpty=" + resizingArrayStack.isEmpty());

        System.out.println("resizingArrayStack all items:");
        for (Float f:resizingArrayStack) {
            System.out.println(f);
        }

        System.out.println("poped=" + resizingArrayStack.pop());
        System.out.println("resizingArrayStack : size=" + resizingArrayStack.size() + ",isEmpty=" + resizingArrayStack.isEmpty());

    }
}
