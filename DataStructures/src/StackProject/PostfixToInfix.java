//Michael Gawronski
package StackProject;
import java.util.Scanner;
public class PostfixToInfix {
public static void main(String[] Args){
   Scanner input = new Scanner(System.in);
   System.out.println("Please enter a postfix expression");
   String userInput = input.nextLine();
    System.out.println("Infix: " + convert(userInput));
}

    /**
     * converts Postfix expressions into Infix
     * using ArrayStack
     *
     * @param postfix userInput String
     * @return converted String
     */
    public static String convert(String postfix){
        ArrayStack<String> Stack = new ArrayStack<>();
    StringBuilder temp = new StringBuilder();
    int postfixLength = postfix.length();
    char[] charArray = new char[postfixLength];
    postfix.getChars(0,postfixLength,charArray,0);
char c;
char firstOp;
char secondOp;
    for(int i=0;i<charArray.length;i++) {
        c = charArray[i];
        if (Character.isLetterOrDigit(c)) {
            Stack.push(String.valueOf(c));
        } else if (Stack.getStackLength() < 2) {
            System.out.println("input not sufficient values in the expression");
        } else {
            secondOp = Stack.pop().charAt(0);
            temp.append(Stack.pop());
            temp.append(charArray[i]);
            temp.append(secondOp);
            Stack.push("(" + temp.toString() + ")");
            //clears temp stringBuilder
            temp.delete(0,temp.length());
        }
    }
       if(Stack.getStackLength()==1){
           return Stack.pop();
       }
       return "The user input has too many values";
}



}
