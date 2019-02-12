package net.ijiangtao.tech.algorithms.algorithmall.datastructure.stack.impl;

import net.ijiangtao.tech.algorithms.algorithmall.datastructure.stack.Stack;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * String定容栈:
 * 固定容量的String类型栈
 */
public class FixedCapacityStackOfStrings {

    private String[] a; // stack entries

    private int N;      // size

    public FixedCapacityStackOfStrings(int cap) {
        a = new String[cap];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(String item) {
        a[N++] = item;
    }

    public String pop() {
        return a[--N];
    }

}
