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
    public void testChecker(){

        Assert.assertFalse(LegalParenthesesChecker.check("1}"));
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
