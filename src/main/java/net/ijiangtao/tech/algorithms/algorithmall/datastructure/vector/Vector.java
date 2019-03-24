package net.ijiangtao.tech.algorithms.algorithmall.datastructure.vector;

public interface Vector {

    /**
     * 返回向量中元素数目
     * @return
     */
    public int getSize();

    /**
     * 判断向量是否为空
     * @return
     */
    public boolean isEmpty();

    /**
     * 取秩为r的元素
     * @param r
     * @return
     * @throws ExceptionBoundaryViolation
     */
    public Object getAtRank(int r) throws ExceptionBoundaryViolation;

    /**
     * 将秩为r的元素替换为obj
     * @param r
     * @param obj
     * @return
     * @throws ExceptionBoundaryViolation
     */
    public Object replaceAtRank(int r, Object obj) throws ExceptionBoundaryViolation;

    /**
     * 插入obj，作为秩为r的元素；返回该元素
     * @param r
     * @param obj
     * @return
     * @throws ExceptionBoundaryViolation
     */
    public Object insertAtRank(int r, Object obj) throws ExceptionBoundaryViolation;

    /**
     * 删除秩为r的元素
     * @param r
     * @return
     * @throws ExceptionBoundaryViolation
     */
    public Object removeAtRank(int r) throws ExceptionBoundaryViolation;


}
