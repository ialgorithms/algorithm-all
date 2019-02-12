package net.ijiangtao.tech.algorithms.algorithmall.datastructure.stack.impl;

public class FixedCapacityStackOfStringsTests {

    public  static void main(String[] args){

        FixedCapacityStackOfStrings fixedCapacityStackOfStrings=new FixedCapacityStackOfStrings(10);
        System.out.println("fixedCapacityStackOfStrings : size="+fixedCapacityStackOfStrings.size()+",isEmpty="+fixedCapacityStackOfStrings.isEmpty());

        fixedCapacityStackOfStrings.push("A");
        fixedCapacityStackOfStrings.push("Aaha");
        System.out.println("fixedCapacityStackOfStrings : size="+fixedCapacityStackOfStrings.size()+",isEmpty="+fixedCapacityStackOfStrings.isEmpty());

        System.out.println("poped="+fixedCapacityStackOfStrings.pop());
        System.out.println("fixedCapacityStackOfStrings : size="+fixedCapacityStackOfStrings.size()+",isEmpty="+fixedCapacityStackOfStrings.isEmpty());

    }
}
