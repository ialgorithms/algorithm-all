package net.ijiangtao.tech.algorithms.algorithmall.algorithm.stack.evaluation;

import net.ijiangtao.tech.algorithms.algorithmall.algorithm.stack.checker.LegalParenthesesChecker;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LegalParenthesesCheckerTests {

    @Test
    public void test(){

       String[] strings={};
        swap(strings,0,1);

        int a=Integer.MAX_VALUE+2;
        int b=Integer.MAX_VALUE+1;
        System.out.println(compare(a,b));
    }

    public static <T> void swap(T[] array,int i,int j){
        T temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }


    public boolean compare(int a,int b){
        return (a-b)>0;
       //return Integer.compare(a,b)>0;
    }

    @Test
    public void testChecker(){

        Assert.assertTrue(LegalParenthesesChecker.check("{2((1))rr}"));
        Assert.assertFalse(LegalParenthesesChecker.check("[1}"));
        Assert.assertFalse(LegalParenthesesChecker.check("[]["));
        Assert.assertFalse(LegalParenthesesChecker.check(")("));
        Assert.assertFalse(LegalParenthesesChecker.check("[1]}"));
        Assert.assertFalse(LegalParenthesesChecker.check("(((1+1)+2)+3"));
        Assert.assertFalse(LegalParenthesesChecker.check("<((1+1)+2)+3"));

        Assert.assertTrue(LegalParenthesesChecker.check(""));
        Assert.assertTrue(LegalParenthesesChecker.check(" "));
        Assert.assertTrue(LegalParenthesesChecker.check("1"));
        Assert.assertTrue(LegalParenthesesChecker.check("[]"));
        Assert.assertTrue(LegalParenthesesChecker.check("[1]"));
        Assert.assertTrue(LegalParenthesesChecker.check("{(『((<1+1>)+【2】)+』3)}"));
    }

}
