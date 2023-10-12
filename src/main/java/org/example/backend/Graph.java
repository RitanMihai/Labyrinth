package org.example.backend;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private Integer nrNodes;
    private List<Edge>[] graph;

    public Graph(Integer nrNodes) {
        this.nrNodes = nrNodes;
        this.graph = new List[this.nrNodes];

        for (int i = 0; i < nrNodes; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    public Graph(List<List<Integer>> matrix) {
        /* TODO: Built graph from matrix */
    }
    public void addNode(String node){

    }

    public void addEdge(Edge edge){
        int position = edge.getStart().getPosition();
        this.graph[position].add(edge);
    }

    public void AddEdgeBetweenNodes(){
        /* TODO */
    }

    public List<Edge>[] getGraph() {
        return this.graph;
    }
}
