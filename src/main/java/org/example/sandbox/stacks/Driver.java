package org.example.sandbox.stacks;

public class Driver {

    public static void main(String[] args) {
        Stack<Integer> stack = new ArrayListStack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element is: " + stack.peek());

        System.out.println("Popped element is: " + stack.pop());

        System.out.println("Top element is: " + stack.peek());

        System.out.println("Is stack empty? " + stack.empty());

        System.out.println("Position of element 10: " + stack.search(10));

        System.out.println("Top element is: " + stack.peek());

        System.out.println(stack);

        stack.pop();
        stack.pop();

        System.out.println("Is stack empty? " + stack.empty());

        System.out.println(stack);
    }
}
