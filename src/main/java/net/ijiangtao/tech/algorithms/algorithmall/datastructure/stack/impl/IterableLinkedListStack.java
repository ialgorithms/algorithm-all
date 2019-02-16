package net.ijiangtao.tech.algorithms.algorithmall.datastructure.stack.impl;

import net.ijiangtao.tech.algorithms.algorithmall.datastructure.stack.Stack;

import java.util.Iterator;

/**
 * 链表实现可迭代的栈
 * @param <Item>
 * @author ijiangtao.net
 */
public class IterableLinkedListStack<Item> implements Stack<Item>,Iterable<Item> {
    /** 栈顶元素 */
    private Node first;

    /** 栈元素数量 */
    private int N;

    /** 通过内部类定义链表节点 */
    private class Node{
        Item item;
        Node next;
    }

    /**
     * 向栈顶增加元素，即在链表的头插入节点
     * @param item
     */
    @Override
    public void push(Item item) {

        Node oldFirst=first;

        first=new Node();
        first.item=item;
        first.next=oldFirst;

        N++;
    }

    /**
     * 从栈顶移除元素，即移除链表的头部节点
     * @return
     */
    @Override
    public Item pop() {
        Item item=first.item;
        first=first.next;
        N--;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return N==0;
    }

    @Override
    public int size() {
        return N;
    }


    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    /**
     * 支持迭代方法，实现在内部类里
     */
    private class ListIterator implements Iterator<Item> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            //或者 N!=0
            return current !=null;
        }

        @Override
        public Item next() {
           Item item=current.item;
           current=current.next;
           return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {

        //测试
        Stack<String> stack=new IterableLinkedListStack<>();
        stack.push("aa");
        stack.push("bbb");
        stack.push("abc");

        for (String s:(IterableLinkedListStack<String>)stack) {
            System.out.println(s);
        }

        System.out.println("stack.size="+stack.size());
        System.out.println("stack.pop="+stack.pop());
        System.out.println("stack.size="+stack.size());
        System.out.println("stack.isEmpty="+stack.isEmpty());

        System.out.println("stack.pop="+stack.pop());
        System.out.println("stack.pop="+stack.pop());
        System.out.println("stack.size="+stack.size());
        System.out.println("stack.isEmpty="+stack.isEmpty());

        //测试输出
        /**
         * abc
         * bbb
         * aa
         * stack.size=3
         * stack.pop=abc
         * stack.size=2
         * stack.isEmpty=false
         * stack.pop=bbb
         * stack.pop=aa
         * stack.size=0
         * stack.isEmpty=true
         */
    }

}
