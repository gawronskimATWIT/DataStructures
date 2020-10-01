package stackpackage;

import java.util.Scanner;

public class InfixToPostfix {
    public static boolean checkValidity (String s) {
        ArrayStack <Character> parStack = new ArrayStack <>();
        Character ch, last;
        boolean isBalanced = true;
        for (int idx = 0; isBalanced && idx < s.length(); idx ++) {
            ch = s.charAt(idx);
            if (isOpenDelimiter (ch))
                parStack.push (ch);
            else if (isClosedDelimiter (ch)){
                if (parStack.isEmpty())
                    return false;
                else
                    isBalanced = isPaired (parStack.pop(), ch);
            }
        }

        if (!parStack.isEmpty())
            isBalanced = false;
        return isBalanced;
    }

    public static boolean isOpenDelimiter (char ch) {
        return (ch == '(' || ch == '[' || ch == '{');
    }

    public static boolean isClosedDelimiter (char ch){
        return (ch == ')' || ch == ']' || ch == '}');
    }

    private static boolean isPaired (char open, char close) {
        return (open == '(' && close == ')' ||
                open == '[' && close == ']' ||
                open == '{' && close == '}' );
    }

    public static String convert (String infix) {
        ArrayStack <Character> opStack = new ArrayStack <>();
        StringBuilder postfix = new StringBuilder();
        Character nextCharacter;
        Character topOperator;
        int len = infix.length();
        char[] symbols = new char[len];
        infix.getChars (0, len, symbols, 0);
        for (int idx = 0; idx < len; idx ++) {
            nextCharacter = symbols[idx];
            if (Character.isLetterOrDigit(nextCharacter))
                postfix.append(nextCharacter);
            else if (nextCharacter == '(' || nextCharacter == '^')
                opStack.push (nextCharacter);
            else if (nextCharacter == '+' || nextCharacter == '-' ||
                    nextCharacter == '*' || nextCharacter == '/') {
                while (!opStack.isEmpty() &&
                        precedence (nextCharacter) <= precedence (opStack.peek()))
                    postfix.append (opStack.pop());
                opStack.push (nextCharacter);
            }
            else if (nextCharacter == ')') {
                while (opStack.peek() != '(')
                    postfix.append (opStack.pop());
                opStack.pop();
            }
        }

        while (!opStack.isEmpty()){
            topOperator = opStack.pop();
            postfix.append(topOperator);
        }

        return postfix.toString();
    }

    public static int precedence (char op) {
        switch (op) {
            case '(':
                return 0;
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                throw new IllegalArgumentException();
        }
    }
    public static double evalPostfix (String postfix){
        ArrayStack<Double> operands = new ArrayStack<>();
        for(int i = 0; i < postfix.length(); i++){
             char c = postfix.charAt(i);
             if(Character.isDigit(c)) {
                 operands.push(Double.valueOf(c)-'0');
             }
             else{
             double x = operands.pop();
             double y = operands.pop();
             switch (c){
                 case '+':
                  operands.push(x+y);
                  break;
                 case '-':
                     operands.push(y-x);
                     break;
                 case'/':
                     operands.push(y/x);
                     break;
                 case'*':
                     operands.push(y*x);
                     break;
             }}
             }
        //final element after everything is evaluated.
            return operands.pop();
        }


    public static double eval (String infix){
        convert(infix);

        return evalPostfix(infix);
    }

    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
      //  System.out.println ("Enter an algebraic postfix expression");
        //String exp = in.nextLine();
//        System.out.println("Answer: " + evalPostfix(exp));




        System.out.println ("Enter an algebraic infix expression");
        String exp = in.nextLine();
        if (!checkValidity (exp))
          System.out.println ("The expression is not balanced");
        else
        System.out.println ("The expression is balanced");

        System.out.println(eval(exp));
        //String postfix = convert (exp);
        //System.out.println ("Postfix form:     " + postfix);

    }
}