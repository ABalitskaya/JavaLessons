import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class MainGraph {
    public static void main(String[] args) {
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0,1));
        edges.add(new Edge(1,2));
        edges.add(new Edge(2,5));
        edges.add(new Edge(2,3));
        edges.add(new Edge(2,4));
        edges.add(new Edge(3,1));
        edges.add(new Edge(4,3));
        edges.add(new Edge(5,4));
        edges.add(new Edge(6,3));
        edges.add(new Edge(6,4));
//        edges.add(new Edge(50,100));


        Graph graph = new Graph(edges);
//        graph.printByList();
        graph.printByMatrix();
    }
}

class Graph {

    List<List<Integer>> internalList = new ArrayList<>();
    int[][] matrix;

    public Graph(List<Edge> edges) {
//        TreeSet<Integer> set = new TreeSet<>();
//        for (Edge e : edges) {
//            set.add(e.getSource());
//            set.add(e.getDestination());
//        }
//
//        int x = set.last();

        int x = 0;
        for (Edge e : edges)
            x = Integer.max(x, Integer.max(e.getSource(), e.getDestination()));

        for (int i = 0; i <= x; i++)
            internalList.add(i, new ArrayList<>());

        for (Edge e : edges)
            internalList.get(e.getSource()).add(e.getDestination());

        System.out.println(internalList);
    }

    public void printByList() {
        System.out.println("printing by list: ");
//        int from = 0;
//        int w = internalList.size();
//
//        while (from < w) {
//            for (Integer q : internalList.get(from))
//                System.out.print("(" + from + " -> " + q + ") ");
//            System.out.println();
//
//            from++;
//        }

        for (int i = 0; i < internalList.size(); i++) {
            for (int j = 0; j < internalList.get(i).size(); j++) {
                System.out.print("(" + i + " -> " + internalList.get(i).get(j) + ") ");
            }
            System.out.println();
        }
    }

    public void printByMatrix() {
        List<Integer> order = new ArrayList<>();
        for (int i = 0; i < internalList.size(); i++) {
            if (internalList.get(i).size() != 0)
                order.add(i);
        }

        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < internalList.size(); i++) {
            values.addAll(internalList.get(i));
        }

        System.out.println(order);
        System.out.println(values);

        TreeSet<Integer> set = new TreeSet<>();
        set.addAll(order);
        set.addAll(values);

        System.out.println(set);

        matrix = new int[set.size()][set.size()];

        for (int i = 0; i < internalList.size(); i++) {
            for (int j = 0; j < internalList.get(i).size(); j++) {
                matrix[getIndex(set, i)][getIndex(set, internalList.get(i).get(j))] = 1;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    public int getIndex(TreeSet<Integer> set, Integer value) {
        int result = 0;
        for (Integer element : set) {
            if (element.equals(value))
                return result;
            result++;
        }

        return -1;
    }
}

class Edge {
    private final int source;
    private final int destination;

    public Edge(int source, int destination) {
        this.source = source;
        this.destination = destination;
    }

    public int getSource() {
        return source;
    }

    public int getDestination() {
        return destination;
    }
}