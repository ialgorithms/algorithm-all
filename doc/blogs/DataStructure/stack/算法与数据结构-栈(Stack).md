[TOC]

## 什么是栈(Stack)

下压栈(FIFO queue)，或者说栈(queue)，是一种基于先进后出策略的集合模型。

## 使用场景

只要你留心，就会发现栈这种数据结构在生活中非常常见。

你在桌子上放了一摞文件，放文件和取文件就是简单的栈操作。

你打开你的电子邮件账户，发现最新的邮件在最前面，如果这个时候有人给你发来新的邮件，你点击收信，发现新来的邮件又在你未读邮件列表的最上面，这就是入栈；你从上到下依次点开邮件阅读，这些唯未读邮件也就是一一从你的未读邮件列表移除了，这就是出栈操作。

你点开一个网页，然后再点击网页中的链接，这样一直点击下去，直到你想回退到前面的网页了，你开始点击回退按钮，前面的网页又一一出栈。同样的，编辑器的回退功能，也是入栈出栈的例子。

## Java实现

### Stack 

我们先定义栈的接口，一个完整的栈的接口，应该包含如下四个方法，即：

- 入栈
- 出栈
- 栈是否为空
- 栈中元素数量

下面是栈接口的定义：

```
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

```

### FixedCapacityStackOfStrings

首先我们实现一个最简单的栈：定容栈，即容量固定的栈，栈的元素都为字符串。

一个栈的实现需要有盛栈元素的地方，我们使用数组。

还要有标记当前栈元素数量的变量N。

```
package net.ijiangtao.tech.algorithms.algorithmall.datastructure.stack.impl;

import net.ijiangtao.tech.algorithms.algorithmall.datastructure.stack.Stack;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * String定容栈:
 * 固定容量的String类型栈
 */
public class FixedCapacityStackOfStrings {

    private String[] a; // stack entries

    private int N;      // size

    public FixedCapacityStackOfStrings(int cap) {
        a = new String[cap];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(String item) {
        a[N++] = item;
    }

    public String pop() {
        return a[--N];
    }

}

```

- 测试

```
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

```

- 测试输出
```
fixedCapacityStackOfStrings : size=0,isEmpty=true
fixedCapacityStackOfStrings : size=2,isEmpty=false
poped=Aaha
fixedCapacityStackOfStrings : size=1,isEmpty=false
```

### FixedCapacityStack

FixedCapacityStackOfStrings的缺点是只能处理String对象，接着我们是使用泛型，让我们的栈实现可以处理任意对象。

其中`Item`就是我们泛型的类型参数。

由于历史原因，Java的数组一般情况下是不支持泛型的，因此我们用强转的方式将Object类型的数组转为泛型中的数组类型。

```
package net.ijiangtao.tech.algorithms.algorithmall.datastructure.stack.impl;

import net.ijiangtao.tech.algorithms.algorithmall.datastructure.stack.Stack;

/**
 * 支持泛型的定容栈
 * @param <Item>
 */
public class FixedCapacityStack<Item> implements Stack<Item> {

    private Item[] a;

    private int N;

    public FixedCapacityStack(int cap){
        a = (Item[]) new Object[cap];
    }

    @Override
    public void push(Item item) {
        a[N++] = item;
    }

    @Override
    public Item pop() {
        return a[--N];
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }

}

```

- 测试
```
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

```

- 测试输出
```
fixedCapacityStack : size=0,isEmpty=true
fixedCapacityStack : size=2,isEmpty=false
poped=202.22
fixedCapacityStack : size=1,isEmpty=false
```
### ResizingArrayStack

FixedCapacityStack的最大缺点就是容量固定，这就要求我们在使用栈之前必须估计栈的最大容量，很不方便。

下面我们就实现容量可变的栈。

我们用一个新的数组来替换老的数组，从而实现栈的容量扩展。这里要注意如两点：

- 当进行入栈操作的时候，如果栈满，则将其容量增大一倍，保证接下来可以多次入栈。因为频繁扩展容量也是很耗费内存的。
- 当进行出栈操作的时候，如果发现只用了栈容量的四分之一，则将栈的容量缩小一半。因为数组如果空着不用，会白白耗费内存。

另外特别注意的是，出栈以后要将指定位置的元素赋值为null，以防止对象游离。

Java的垃圾回收策略是回收所有无法被访问的对象的内存，如果出栈以后，不将指定位置的元素赋值为null，那么保存这样一个不需要的对象的引用，就称为对象的游离。

通过赋值已经出栈的位置为null，我们覆盖了无效的引用，好让GC回收这部分内存。


```
package net.ijiangtao.tech.algorithms.algorithmall.datastructure.stack.impl;

import net.ijiangtao.tech.algorithms.algorithmall.datastructure.stack.Stack;

/**
 * 容量可变的栈
 *
 * @param <Item>
 */
public class ResizingArrayStack<Item> implements Stack<Item> {

    private Item[] a = (Item[]) new Object[1];

    private int N = 0;

    /**
     * 改变栈的容量大小
     *
     * @param max
     */
    private void resize(int max) {
        // Move stack to a new array of size max.
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    @Override
    public void push(Item item) {
        //如果栈满，则将其容量增大一倍
        if (N == a.length) {
            resize(2 * a.length);
        }
        a[N++] = item;
    }

    @Override
    public Item pop() {
        Item item = a[--N];
        // 防止对象游离(loitering)
        a[N] = null;
        //如果栈中已用的容量只占总容量的1/4，则将栈容量缩小一半
        if (N > 0 && N == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }
}

```

- 测试
```
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

```

- 测试输出
```
resizingArrayStack : size=0,isEmpty=true
resizingArrayStack : size=2,isEmpty=false
poped=202.02199999999999135980033315718173980712890625
resizingArrayStack : size=1,isEmpty=false
```

### IterableResizingArrayStack

下面我们将为我们的栈实现增加迭代器的特性。

事实上，`foreach`不仅仅是`for`的简写形式语法糖这么简单，如下`foreach`和`while`循环是等效的：

```
for(String s:collection){
    s ...
}
```
```
while(collection.hasNext()){
    collection.next();
    ...
}
```

从上面例子可以看出，迭代器其实就是一个实现了`hasNext()`和`next()`方法的对象。

如果一个类可迭代，那么第一步就要声明实现Iterable接口。

然后我们通过一个内部类来实现Iterator的`hasNext()`和`next()`方法从而支持迭代操作。


```
package net.ijiangtao.tech.algorithms.algorithmall.datastructure.stack.impl;

import net.ijiangtao.tech.algorithms.algorithmall.datastructure.stack.Stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 可迭代的可变长的基于数组存储的栈实现
 *
 * @param <Item>
 */
public class IterableResizingArrayStack<Item> implements Stack<Item>, Iterable<Item> {

    private Item[] a = (Item[]) new Object[1];

    private int N = 0;

    /**
     * 改变栈的容量大小
     *
     * @param max
     */
    private void resize(int max) {
        // Move stack to a new array of size max.
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    @Override
    public void push(Item item) {
        //如果栈满，则将其容量增大一倍
        if (N == a.length) {
            resize(2 * a.length);
        }
        a[N++] = item;
    }

    @Override
    public Item pop() {
        Item item = a[--N];
        // 防止对象游离(loitering)
        a[N] = null;
        //如果栈中已用的容量只占总容量的1/4，则将栈容量缩小一半
        if (N > 0 && N == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    //支持迭代方法，实现在内部类里
    private class ReverseArrayIterator implements Iterator<Item> {
        // Support LIFO iteration.
        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            if(i<=0){
                throw new NoSuchElementException();
            }

            return a[--i];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}

```

- 测试
```
package net.ijiangtao.tech.algorithms.algorithmall.datastructure.stack.impl;

import java.math.BigDecimal;

public class IterableResizingArrayStackTests {
    public static void main(String[] args) {

        IterableResizingArrayStack<Float> resizingArrayStack = new IterableResizingArrayStack<>();

        System.out.println("resizingArrayStack : size=" + resizingArrayStack.size() + ",isEmpty=" + resizingArrayStack.isEmpty());

        resizingArrayStack.push(new Float(100.001));
        resizingArrayStack.push(new Float(202.022));
        System.out.println("resizingArrayStack : size=" + resizingArrayStack.size() + ",isEmpty=" + resizingArrayStack.isEmpty());

        System.out.println("resizingArrayStack all items:");
        for (Float f:resizingArrayStack) {
            System.out.println(f);
        }

        System.out.println("poped=" + resizingArrayStack.pop());
        System.out.println("resizingArrayStack : size=" + resizingArrayStack.size() + ",isEmpty=" + resizingArrayStack.isEmpty());

    }
}

```

- 测试输出
```
resizingArrayStack : size=0,isEmpty=true
resizingArrayStack : size=2,isEmpty=false
resizingArrayStack all items:
202.022
100.001
poped=202.022
resizingArrayStack : size=1,isEmpty=false
```

------------------------------------

## 应用示例

### 双栈算术表达式求值算法

Dijkstra的双栈算术表达式求值算法(Dijkstra's two-stack algorithm for expression evaluation)是由E.W.Dijkstra在上个世纪60年代发明的一个很简单的算法，用两个栈：一个用来保存运算符、一个用来保存操作数，来完成对一个表达式的运算。

其实整个算法思路很简单：

- 无视左括号
- 将操作数压入操作数栈
- 将运算符压入运算符栈
- 在遇到右括号的时候，从运算符栈中弹出一个运算符，再从操作数栈中弹出所需的操作数，并且将运算结果压入操作数栈中

```
package net.ijiangtao.tech.algorithms.algorithmall.algorithm.stack.evaluation;

import net.ijiangtao.tech.algorithms.algorithmall.datastructure.stack.Stack;
import net.ijiangtao.tech.algorithms.algorithmall.datastructure.stack.impl.IterableResizingArrayStack;

public class DijkstrasTwoStackAlgorithmForExpressionEvaluation {

    public Double cal(String expression) {

        String[] expressionArr = expression.split(" ");

        Stack<String> ops = new IterableResizingArrayStack<String>();
        Stack<Double> vals = new IterableResizingArrayStack<Double>();

        for (String s : expressionArr) {
            // Read token, push if operator.
            if (s.equals("(")) {
                ;
            } else if (s.equals("+")) {
                ops.push(s);
            } else if (s.equals("-")) {
                ops.push(s);
            } else if (s.equals("*")) {
                ops.push(s);
            } else if (s.equals("/")) {
                ops.push(s);
            } else if (s.equals("sqrt")) {
                ops.push(s);
            } else if (s.equals(")")) {
                // Pop, evaluate, and push result if token is ")"
                String op = ops.pop();
                double v = vals.pop();

                if (op.equals("+")) {
                    v = vals.pop() + v;
                } else if (op.equals("-")) {
                    v = vals.pop() - v;
                } else if (op.equals("*")) {
                    v = vals.pop() * v;
                } else if (op.equals("/")) {
                    v = vals.pop() / v;
                } else if (op.equals("sqrt")) {
                    v = Math.sqrt(v);
                }

                vals.push(v);
            }
            // Token not operator or paren: push double value.
            else {
                vals.push(Double.parseDouble(s));
            }
        }

        return vals.pop();
    }

}

```

- 测试
```
package net.ijiangtao.tech.algorithms.algorithmall.algorithm.stack.evaluation;

public class DijkstrasTwoStackAlgorithmForExpressionEvaluationTests {

    public  static void main(String[] args){
        DijkstrasTwoStackAlgorithmForExpressionEvaluation expressionEvaluation=new DijkstrasTwoStackAlgorithmForExpressionEvaluation();
        System.out.println(expressionEvaluation.cal("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )"));
    }

}
```
- 测试输出：

```
101.0
```

