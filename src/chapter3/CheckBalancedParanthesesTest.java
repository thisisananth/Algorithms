package chapter3;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ananthmajumdar on 4/8/15.
 */
public class CheckBalancedParanthesesTest {

    @Test
    public void testCheckForBalance() throws Exception {

        CheckBalancedParantheses balancedParantheses = new CheckBalancedParantheses();
       assertTrue(balancedParantheses.checkForBalance("(())(")==5);
        assertTrue(balancedParantheses.checkForBalance("()()()")==-1);
        assertTrue(balancedParantheses.checkForBalance("((())")==1);
        assertTrue(balancedParantheses.checkForBalance("((())())")==-1);
        assertTrue(balancedParantheses.checkForBalance("(())(()")==5);
        //balancedParantheses.checkForBalance("(())(");
    }
}