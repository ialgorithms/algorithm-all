package net.ijiangtao.tech.algorithms.algorithmall.datastructure.queue;

/**
 * 队列
 * @author ijiangtao.net
 * @param <Item>
 */
public interface Queue<Item> {

    /**
     * 队列是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 队列大小
     * @return
     */
    int size();

    /**
     * 入队
     * @param item
     */
    public void enqueue(Item item);

    /**
     * 出队
     * @return
     */
    public Item dequeue();

}
