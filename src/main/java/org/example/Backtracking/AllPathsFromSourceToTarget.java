package org.example.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {

    // Total number of vertices in the directed graph
    private final int v;

    // Stores every valid path discovered during DFS
    static List<List<Integer>> nm = new ArrayList<>();

    // Adjacency list representation of the graph
    private ArrayList<Integer>[] adjList;

    public AllPathsFromSourceToTarget(int vertices) {
        this.v = vertices;
        initAdjList(); // Prepare adjacency list structure
    }

    // Create an empty adjacency list for each vertex
    private void initAdjList() {
        adjList = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new ArrayList<>();  // Each index stores outgoing neighbours
        }
    }

    // Add a directed edge from 'u' to 'v'
    public void addEdge(int u, int v) {
        adjList[u].add(v);
    }

    // Wrapper method to compute all possible routes between two nodes
    public void storeAllPaths(int s, int d) {
        nm.clear();  // Ensure previous results do not mix with current run

        boolean[] isVisited = new boolean[v];  // Track visited nodes during DFS
        ArrayList<Integer> pathList = new ArrayList<>();

        pathList.add(s);  // Begin the exploration from source
        storeAllPathsUtil(s, d, isVisited, pathList);
    }

    // Core backtracking logic that explores routes in depth-first manner
    private void storeAllPathsUtil(Integer u, Integer d,
                                   boolean[] isVisited,
                                   List<Integer> localPathList) {

        // If the destination is reached, record the current route
        if (u.equals(d)) {
            nm.add(new ArrayList<>(localPathList)); // Copy current path
            return;
        }

        // Mark current node as visited to avoid revisiting in current path
        isVisited[u] = true;

        // Explore every neighbour linked to the current node
        for (Integer neighbour : adjList[u]) {
            if (!isVisited[neighbour]) {
                // Add neighbour and continue searching deeper
                localPathList.add(neighbour);

                storeAllPathsUtil(neighbour, d, isVisited, localPathList);

                // Backtrack: remove the recently added node
                localPathList.remove(neighbour);
            }
        }

        // Reset so that other paths starting from different branches can reuse this node
        isVisited[u] = false;
    }

    // Static helper to conveniently create a graph, add edges and fetch all paths
    public static List<List<Integer>> allPathsFromSourceToTarget(
            int vertices, int[][] a, int source, int destination) {

        AllPathsFromSourceToTarget g = new AllPathsFromSourceToTarget(vertices);

        // Load all edges from the given matrix
        for (int[] i : a) {
            g.addEdge(i[0], i[1]);
        }

        // Trigger DFS-based path discovery
        g.storeAllPaths(source, destination);

        return nm;
    }
}
