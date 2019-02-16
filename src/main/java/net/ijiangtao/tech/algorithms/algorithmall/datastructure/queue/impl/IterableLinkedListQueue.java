package net.ijiangtao.tech.algorithms.algorithmall.datastructure.queue.impl;

import net.ijiangtao.tech.algorithms.algorithmall.datastructure.queue.Queue;

import java.util.Iterator;

/**
 * 队列
 * @author ijiangtao.net
 * @param <Item>
 */
public class IterableLinkedListQueue<Item> implements Queue<Item>,Iterable<Item>{

    /** 队头，最初入队的节点 */
    private Node first;

    /**队尾，最晚入队的节点*/
    private Node last;

    /** 队列中元素的数量 */
    private int N;

    private class Node{
        Item item;
        Node next;
    }

    @Override
    public boolean isEmpty() {
        //或N==0
        return first==null;
    }

    @Override
    public int size() {
        return N;
    }

    /**
     * 入队，即向队尾增加一个元素
     * @param item
     */
    @Override
    public void enqueue(Item item) {
        Node oldLast=last;

        last=new Node();
        last.item=item;
        last.next=null;

        if (isEmpty()){
            first=last;
        }else {
            oldLast.next=last;
        }

        N++;
    }

    /**
     * 出队，即移除队头元素
     * @return
     */
    @Override
    public Item dequeue() {
        Item item=first.item;
        first=first.next;

        if (isEmpty()){
            last=null;
        }

        N--;

        return item;
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
        Queue<String> queue=new IterableLinkedListQueue<>();
        queue.enqueue("aa");
        queue.enqueue("bbb");
        queue.enqueue("abc");

        for (String s:(IterableLinkedListQueue<String>)queue) {
            System.out.println(s);
        }

        System.out.println("queue.size="+queue.size());
        System.out.println("queue.dequeue="+queue.dequeue());
        System.out.println("queue.size="+queue.size());
        System.out.println("queue.isEmpty="+queue.isEmpty());

        System.out.println("queue.dequeue="+queue.dequeue());
        System.out.println("queue.dequeue="+queue.dequeue());
        System.out.println("queue.size="+queue.size());
        System.out.println("queue.isEmpty="+queue.isEmpty());

        //测试输出
        /**
         * aa
         * bbb
         * abc
         * queue.size=3
         * queue.dequeue=aa
         * queue.size=2
         * queue.isEmpty=false
         * queue.dequeue=bbb
         * queue.dequeue=abc
         * queue.size=0
         * queue.isEmpty=true
         */
    }
}
