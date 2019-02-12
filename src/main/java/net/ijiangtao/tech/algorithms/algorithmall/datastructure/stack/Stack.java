package net.ijiangtao.tech.algorithms.algorithmall.datastructure.stack;

public interface Stack<Item> {

    /**
     * add an item
     *
     * @param item
     */
    void push(Item item);

    /**
     * remove the most recently added item
     *
     * @return
     */
    Item pop();

    /**
     * is the stack empty?
     *
     * @return
     */
    boolean isEmpty();

    /**
     * number of items in the stac
     */
    int size();

}
