package net.ijiangtao.tech.algorithms.algorithmall.datastructure.stack.impl;

import net.ijiangtao.tech.algorithms.algorithmall.datastructure.stack.Stack;

/**
 * 容量可变的栈
 *
 * @param <Item>
 */
public class ResizingArrayStack<Item> implements Stack<Item> {

    private Item[] a = (Item[]) new Object[1];

    private int N = 0;

    /**
     * 改变栈的容量大小
     *
     * @param max
     */
    private void resize(int max) {
        // Move stack to a new array of size max.
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    @Override
    public void push(Item item) {
        //如果栈满，则将其容量增大一倍
        if (N == a.length) {
            resize(2 * a.length);
        }
        a[N++] = item;
    }

    @Override
    public Item pop() {
        Item item = a[--N];
        // 防止对象游离(loitering)
        a[N] = null;
        //如果栈中已用的容量只占总容量的1/4，则将栈容量缩小一半
        if (N > 0 && N == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
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
