import java.util.Stack;

/**
 * Created by muldoon on 21/01/17.
 */
public class BalanceChecker {

    public static void main(String[] args){
        String test_good = "()(){}{}{()}";
        String test_bad = "((({}{}))()";

        System.out.println(checkBalance(test_good));
        System.out.println(checkBalance(test_bad));
    }

    public static boolean checkBalance(String e){
        Stack<Character> openDelimiterStack = new Stack<Character>();
        boolean isBalanced = true;
        //int index = 0;
        char nextChar = ' ';
        //char charCount = e.charAt(index);
        for(int index = 0; index < e.length(); index++){
            nextChar = e.charAt(index);
            switch (nextChar){
                case '(':
                case '[':
                case '{':
                    openDelimiterStack.push(nextChar);
                    break;
                case ')':
                case ']':
                case '}':
                    if(openDelimiterStack.empty()){
                        isBalanced = false;
                    }else{
                        char openDelimiter = openDelimiterStack.pop();
                        isBalanced = isPaired(openDelimiter, nextChar);
                    }
                    break;
                    default:
                        break;
            }
        }
        if(!openDelimiterStack.empty())
            isBalanced = false;
        return isBalanced;
    }

    private static boolean isPaired(char open, char close){
        return (open == '(' && close == ')') ||
                (open == '[' && close == ']') ||
                (open == '{' && close == '}');
    }
}
