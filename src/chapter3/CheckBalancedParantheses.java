package chapter3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

/**
 * Created by ananthmajumdar on 4/8/15.
 */
public class CheckBalancedParantheses {

    public int checkForBalance(String input){
        int position=0;
        int offendingChar = -1;
        int possibleOffender = 0;
        Deque myStack = new ArrayDeque();
        try{
            for( position=0;position<input.length();position++){
                if(input.charAt(position) == '('){
                    if(myStack.size()==0){
                          possibleOffender = position;
                    }
                    myStack.push('(');
                }else{
                    myStack.pop();
                }
            }
        }catch(NoSuchElementException e){
              offendingChar = position+1;
        }
        if(myStack.size()!=0){
            offendingChar = possibleOffender+1;
        }


        return offendingChar;
    }


}
