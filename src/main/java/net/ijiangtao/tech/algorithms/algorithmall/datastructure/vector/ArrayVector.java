package net.ijiangtao.tech.algorithms.algorithmall.datastructure.vector;

/**
 * 基于数组实现的向量
 *
 * @author ijaingtao
 */
public class ArrayVector {

    /**
     * 数组的容量
     */
    private int N = 6;


    /**
     * 向量的实际规模
     */
    private int n = 0;

    /**
     * 对象数组
     */
    private Object[] A;

    /**
     * 构造函数。
     * <p>
     * 初始化数组容量和实际大小。
     */
    public ArrayVector() {
        A = new Object[N];
        n = 0;
    }

    /**
     * 返回向量中元素数目
     */
    public int getSize() {
        return n;
    }

    /**
     * 判断向量是否为空
     */
    public boolean isEmpty() {
        return (0 == n) ? true : false;
    }

    /**
     * 取秩为r的元素
     */
    public Object getAtRank(int r) throws ExceptionBoundaryViolation {
        if (0 > r || r >= n) {
            throw new ExceptionBoundaryViolation("秩越界");
        }
        return A[r];
    }

    /**
     * 将秩为r的元素替换为obj，返回旧的值。
     */
    public Object replaceAtRank(int r, Object obj) throws ExceptionBoundaryViolation {
        if (0 > r || r >= n) {
            throw new ExceptionBoundaryViolation("秩越界");
        }
        Object replaced = A[r];
        A[r] = obj;
        return replaced;
    }

    /**
     * 插入obj，作为秩为r的元素；返回该元素
     */
    public Object insertAtRank(int r, Object obj) throws ExceptionBoundaryViolation {

        if (0 > r || r > n) {
            throw new ExceptionBoundaryViolation("秩越界");
        }

        //空间溢出的处理
        if (N <= n) {
            //开辟一个容量加倍的数组
            N  *=  2;
            Object  B[]  =  new  Object[N];

            //A[]中内容复制至B[]
            System.arraycopy(A,0,B,0,A.length);
            //for (int i=0; i<n; i++){
            //    B[i] = A[i];
            // }

            //用B替换A（原A[]将被自动回收）
            A  =  B;
        }
        //后续元素顺次后移
        for (int i = n; i > r; i--) {
            A[i] = A[i - 1];
        }

        //插入
        A[r] = obj;
        //更新当前规模
        n++;
        return obj;
    }

    //删除秩为r的元素
    public Object removeAtRank(int r) throws ExceptionBoundaryViolation {
        if (0 > r || r >= n) {
            throw new ExceptionBoundaryViolation("秩越界");
        }

        Object deleted = A[r];

        for (int i = r; i < n; i++) {
            A[i] = A[i + 1];//后续元素顺次前移
        }

        n--;//更新当前规模

        return deleted;
    }

}
