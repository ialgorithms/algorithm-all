package net.ijiangtao.tech.algorithms.algorithmall.datastructure.stack.impl;

public class FixedCapacityStackTests {

    public  static void main(String[] args){
        FixedCapacityStack<Double> fixedCapacityStack=new FixedCapacityStack<>(10);
        System.out.println("fixedCapacityStack : size="+fixedCapacityStack.size()+",isEmpty="+fixedCapacityStack.isEmpty());

        fixedCapacityStack.push(new Double(10.01));
        fixedCapacityStack.push(new Double(202.22));
        System.out.println("fixedCapacityStack : size="+fixedCapacityStack.size()+",isEmpty="+fixedCapacityStack.isEmpty());

        System.out.println("poped="+fixedCapacityStack.pop());
        System.out.println("fixedCapacityStack : size="+fixedCapacityStack.size()+",isEmpty="+fixedCapacityStack.isEmpty());

    }
}
