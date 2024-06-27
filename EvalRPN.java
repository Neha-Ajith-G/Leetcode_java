
import java.util.*;

//RPN- REVERSE POLISH NOTATION OR POSTFIX EXPRESSION

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < tokens.length; i++){
            String s = tokens[i];
            if(isNumber(s)){
                stack.push(Integer.valueOf(s));
            }
            else{
                int opp2 = stack.pop();
                int opp1 = stack.pop();
                stack.push(operate(opp1, opp2, s));
            }
        }
        return stack.pop();
    }

    private Boolean isNumber(String s){
        if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
            return false;
        }
        else{
            return true;
        }
    }

    private int operate(int opp1, int opp2, String operation){
            if(operation.equals("+")){
                return opp1 + opp2;
            }
            else if(operation.equals("-")){
                return opp1 - opp2;
            }
            else if(operation.equals("*")){
                return opp1 * opp2;
            }
            else{
                return opp1 / opp2;
            }
    }
}
    
     /*   
        // Iterating ArrayList using Iterator
        Iterator it = numbers.iterator();

        // Holds true till there is single element
        // remaining in the list
        while (it.hasNext())

            // Print the elements of ArrayList
            System.out.print(it.next() + " ");
    */

       
class EvalRPN{
    public static void main(String args[]){
        String [] t1 = {"2","1","+","3","*"};
        String [] t2 = {"4","13","5","/","+"};
        String [] t3 = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        Solution a = new Solution();
        System.out.println("Eval... t1:"+ a.evalRPN(t1)) ;
        System.out.println("Eval... t2:"+ a.evalRPN(t2)) ;
        System.out.println("Eval... t3:"+ a.evalRPN(t3));

    }
}