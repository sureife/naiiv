package com.sureife;

import com.sureife.dfs.Graph;
import com.sureife.dfs.Node;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

	    Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);

        n1.setChildren(Arrays.asList(n2,n3));
        n2.setChildren(Arrays.asList(n4,n5));
        n3.setChildren(Arrays.asList(n1,n5));
        n4.setChildren(Arrays.asList(n2,n6));
        n5.setChildren(Arrays.asList(n2,n4,n3,n6));
        n6.setChildren(Arrays.asList(n4,n5));

        try {
            Graph graph = new Graph(Arrays.asList(n1,n2,n3,n4,n5,n6));
            graph.searchDepthFirst(1,2);
            System.out.println(graph.searchDepthFirstIterative(1,2));
            System.out.println(graph.bfs(1,6));

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
