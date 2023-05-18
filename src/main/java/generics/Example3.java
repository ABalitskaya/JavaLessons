package generics;

import java.util.Arrays;
import java.util.Stack;

public class Example3 {
    public static void main(String[] args) {

        // classic stack
        Stack<Integer> stack = new Stack<>();
        stack.add(6);
        stack.add(5);
        stack.add(2023);

        while (!stack.isEmpty())
            System.out.println(stack.pop());

        System.out.println("----");

        // hand-make stack with generics Integer
        LinkedStack<Integer> lsi = new LinkedStack<>();
        lsi.add(6);
        lsi.add(5);
        lsi.add(2023);

        Integer q;
        while ((q = lsi.pop()) != null)
            System.out.println(q);

        System.out.println("----");

        // hand-make stack with generics String

        LinkedStack<String> lss = new LinkedStack<>();
        Arrays.stream("Hello, java! It's qa_41m".split(" ")).forEach(lss::add);

        String s;
        while ((s = lss.pop()) != null)
            System.out.println(s);
    }
}

class LinkedStack<T> {
    private Node<T> top = new Node<>();

    public void add(T item) {
        top = new Node<>(item, top);
    }

    public T pop() {
        T result = top.getItem();

        if (!top.end())
            top = top.getNext();

        return result;
    }
}

class Node<T> {
    private T item;
    private Node<T> next;

    public Node() {
        item = null;
        next = null;
    }

    public Node(T item, Node<T> next) {
        this.item = item;
        this.next = next;
    }

    public boolean end() {
        return item == null && next == null;
    }

    public T getItem() {
        return item;
    }

    public Node<T> getNext() {
        return next;
    }
}