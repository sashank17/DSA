package DSA.DataStructures;

import java.util.ArrayList;
import java.util.List;


// A class to store a graph edge
class Edge {
    int src, dest, weight;

    // constructor for an unweighted edge
    Edge (int src, int dest) {
        this.src = src;
        this.dest = dest;
    }

    // constructor for a weighted edge
    Edge (int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}


// A class to store adjacency list nodes
class Node {
    int value, weight;

    // constructor for an unweighted node
    Node (int value) {
        this.value = value;
    }

    // // constructor for a weighted node
    Node (int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}


// A class to represent a graph object
public class Graph {
    boolean directed, weighted;

    // a list of lists to represent an adjacency list
    List<List<Node>> adjList = new ArrayList<>();

    // constructor to construct a graph
    Graph(List<Edge> edges, boolean directed, boolean weighted) {
        this.directed = directed;
        this.weighted = weighted;

        // find the maximum numbered vertex
        int n = 0;
        for (Edge edge: edges) {
            n = Integer.max(n, Integer.max(edge.src, edge.dest));
        }

        // allocate memory for the adjacency list
        for (int i = 0; i <= n; i++) {
            adjList.add(i, new ArrayList<>());
        }

        // add edges to the directed graph
        for (Edge edge: edges)
        {
            // allocate new node in adjacency list from src to dest
            if (weighted) {
                // weighted and directed
                adjList.get(edge.src).add(new Node(edge.dest, edge.weight));
                if (!directed) {
                    // weighted and undirected
                    adjList.get(edge.dest).add(new Node(edge.src, edge.weight));
                }
            }
            else {
                // unweighted and directed
                adjList.get(edge.src).add(new Node(edge.dest));
                if (!directed) {
                    // unweighted and undirected
                    adjList.get(edge.dest).add(new Node(edge.src));
                }
            }
        }
    }

    // Function to print adjacency list representation of a graph
    public static void printGraph(Graph graph)
    {
        int src = 0;
        int n = graph.adjList.size();

        while (src < n)
        {
            // print current vertex and all its neighboring vertices
            for (Node edge: graph.adjList.get(src)) {
                if (graph.weighted) {
                    System.out.printf(src + " ——> " + edge.value + " (" + edge.weight + ")\t");
                }
                else {
                    System.out.print(src + " ——> " + edge.value + "\t");
                }
            }
            System.out.println();
            src++;
        }
    }
}
