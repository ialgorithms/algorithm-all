package net.ijiangtao.tech.algorithms.algorithmall.datastructure.stack.impl;

import java.math.BigDecimal;

public class ResizingArrayStackTests {
    public  static void main(String[] args){

        ResizingArrayStack<BigDecimal> resizingArrayStack=new ResizingArrayStack<>();

        System.out.println("resizingArrayStack : size="+resizingArrayStack.size()+",isEmpty="+resizingArrayStack.isEmpty());

        resizingArrayStack.push(new BigDecimal(100.001));
        resizingArrayStack.push(new BigDecimal(202.022));
        System.out.println("resizingArrayStack : size="+resizingArrayStack.size()+",isEmpty="+resizingArrayStack.isEmpty());

        System.out.println("poped="+resizingArrayStack.pop());
        System.out.println("resizingArrayStack : size="+resizingArrayStack.size()+",isEmpty="+resizingArrayStack.isEmpty());

    }
}
