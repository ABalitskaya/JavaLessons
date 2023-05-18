import com.sun.source.tree.Tree;

import java.util.*;

public class BinaryTreeExamples {
    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree(
                10,
                new BinaryTree(
                        2,
                        new BinaryTree(1),
                        new BinaryTree(
                                6,
                                new BinaryTree(5),
                                null)
                ),
                new BinaryTree(
                        13,
                        new BinaryTree(12),
                        new BinaryTree(81)
                )
        );

//        binaryTree.insert(binaryTree, 50);
        binaryTree.insertTwo(5);

        System.out.println("Sum using recurse = " + binaryTree.sum());
        System.out.println("Sum using non-recurse = " + binaryTree.sumNonRecurse());
        System.out.println("Sum using non-recurse (wide) = " + binaryTree.sumNonRecurseWide());
    }
}

class BinaryTree {
    private int value;
    private BinaryTree left, right;

    public BinaryTree(int value, BinaryTree left, BinaryTree right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public BinaryTree(int value) {
        this.value = value;
    }

    // go to deep
    public int sum() {
        int sum = value;

        // можно добавить порядок вывода
//        System.out.println(value);

        if (right != null)
            sum += right.sum();

        if (left != null)
            sum += left.sum();

        return sum;
    }

    // go to deep
    public int sumNonRecurse() {
        Stack<BinaryTree> stack = new Stack();
        stack.push(this);

        int sum = 0;

        while (!stack.isEmpty()) {
            BinaryTree tmp = stack.pop();

            // можно добавить порядок вывода
//            System.out.println(tmp.value);

            sum += tmp.value;

            if (tmp.left != null)
                stack.push(tmp.left);

            if (tmp.right != null)
                stack.push(tmp.right);
        }

        return sum;
    }

    // go to wide
    public int sumNonRecurseWide() {
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(this);

        int sum = 0;

        while (!queue.isEmpty()) {
            BinaryTree tmp = queue.remove();

            // можно добавить порядок вывода
            System.out.println(tmp);

            sum += tmp.value;

            if (tmp.left != null)
                queue.add(tmp.left);

            if (tmp.right != null)
                queue.add(tmp.right);
        }

        return sum;
    }

    public BinaryTree insert(BinaryTree bt, int a) {


        if (bt == null)
            return new BinaryTree(a);

        if (value < a) {
            bt.left = insert(bt.left, a);
        } else if (value > a) {
            bt.right = insert(bt.right, a);
        } else {
            return bt;
        }

        return bt;
    }

    public void insertTwo(int value) {
        if (this.value == 0) {
            this.value = value;
//            return;
        }

        BinaryTree binaryTree = new BinaryTree(value);

        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(this);

        while (!queue.isEmpty()) {

            BinaryTree buy = queue.remove();

            if (buy.left == null){
                buy.left = binaryTree;
                break; // or return
            }

            else if (buy.right == null) {
                buy.right = binaryTree;
                break; // or return
            }

            else {
                queue.add(buy.left);
                queue.add(buy.right);
            }

        }
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
