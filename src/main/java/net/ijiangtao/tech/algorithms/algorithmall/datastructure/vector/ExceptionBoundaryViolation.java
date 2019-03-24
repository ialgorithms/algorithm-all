package net.ijiangtao.tech.algorithms.algorithmall.datastructure.vector;

/**
 * 数组越界错误
 *
 * @author ijiangtao
 */
public class ExceptionBoundaryViolation extends RuntimeException {

    public ExceptionBoundaryViolation(String err) {
        super(err);
    }

}
