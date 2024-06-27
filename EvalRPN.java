
import java.util.*;

//RPN- REVERSE POLISH NOTATION OR POSTFIX EXPRESSION

class Solution {
    public int evalRPN(String[] tokens) {
        //creating an empty stack
        Stack <Integer> stack = new Stack<Integer>();
     /*   
        // Iterating ArrayList using Iterator
        Iterator it = numbers.iterator();

        // Holds true till there is single element
        // remaining in the list
        while (it.hasNext())

            // Print the elements of ArrayList
            System.out.print(it.next() + " ");
    */

        for (String token : tokens) {
            if (isDigit(token) ||  (token.length() > 1 && token.charAt(0) == '-' && isDigit(token.substring(1)))){
                int val = Integer.parseInt(token);
                stack.push(val);
            }else{
                int pop1 = stack.pop();
                int pop2 = stack.pop();

                int result = 0;
                switch (token){
                    case "+":
                    result = pop2 + pop1;
                    break;
                    case "-":
                        result = pop2 - pop1;
                        break;
                    case "*":
                        result = pop2 * pop1;
                        break;
                    case "/":
                        result = pop2 / pop1;
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator");
                }
                stack.push(result);
            }
        } return stack.pop();
    }
    
    private boolean isDigit(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

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