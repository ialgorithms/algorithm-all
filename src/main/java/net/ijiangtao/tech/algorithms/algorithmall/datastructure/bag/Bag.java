package net.ijiangtao.tech.algorithms.algorithmall.datastructure.bag;

/**
 * 背包
 * @author ijiangtao.net
 * @param <Item>
 */
public interface Bag<Item> extends Iterable<Item>{

    /**
     * 向背包内加入元素
     * @param item
     */
    void add(Item item);

}
