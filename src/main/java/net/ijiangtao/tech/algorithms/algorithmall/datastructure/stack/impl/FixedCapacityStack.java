package net.ijiangtao.tech.algorithms.algorithmall.datastructure.stack.impl;

import net.ijiangtao.tech.algorithms.algorithmall.datastructure.stack.Stack;

/**
 * 支持泛型的定容栈
 * @param <Item>
 */
public class FixedCapacityStack<Item> implements Stack<Item> {

    private Item[] a;

    private int N;

    public FixedCapacityStack(int cap){
        a = (Item[]) new Object[cap];
    }

    @Override
    public void push(Item item) {
        a[N++] = item;
    }

    @Override
    public Item pop() {
        return a[--N];
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }

}
