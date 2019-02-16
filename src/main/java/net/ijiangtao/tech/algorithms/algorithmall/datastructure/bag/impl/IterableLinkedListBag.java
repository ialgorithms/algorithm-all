package net.ijiangtao.tech.algorithms.algorithmall.datastructure.bag.impl;

import net.ijiangtao.tech.algorithms.algorithmall.datastructure.bag.Bag;

import java.util.Iterator;

public class IterableLinkedListBag<Item> implements Bag<Item> {

    private Node first;

    private class Node{
        Item item;
        Node next;
    }

    @Override
    public void add(Item item) {
        Node oldFirst=first;

        first=new Node();
        first.item=item;
        first.next=oldFirst;

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
        Bag<String> bag=new IterableLinkedListBag<>();
        bag.add("aa");
        bag.add("bbb");
        bag.add("abc");

        for (String s:bag) {
            System.out.println(s);
        }

        //测试输出
        /**
         * abc
         * bbb
         * aa
         */
    }


}
