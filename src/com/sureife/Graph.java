//package com.sureife;
//
//import java.util.*;
//
///**
// * Created by sureife on 03/07/2017.
// */
//public class Graph {
//    // map node id to node
//    private Map<Integer,Node> nodeLookup = new HashMap<Integer,Node>();
//
//    private Node getNode(int id){
//        Node node = null;
//
//        if(nodeLookup.containsKey(id)){
//            node = nodeLookup.get(id);
//        }
//
//        return node;
//    }
//
//    /**
//     * Add a New Edge to the Graph
//     * @param source Node Id
//     * @param destination Node Id
//     */
//    public void addEdge(int source,int destination){
//        Node s = getNode(source);
//        Node d = getNode(destination);
//
//        s.addNewAdjacentNode(d);
//    }
//
//    /**
//     * Check if a Path Exists from
//     * @param source  ID
//     * @param destination ID
//     * @return
//     */
//    public boolean hasPathDFS(int source,int destination){
//        Node s = getNode(source);
//        Node d = getNode(destination);
//
//        HashSet<Integer> visited = new HashSet<>();
//        return hasPathDFS(s,d,visited);
//    }
//
//    private boolean hasPathDFS(Node source,Node destination,HashSet<Integer> visited){
//        if(visited.contains(source.getId())) return false;
//
//        visited.add(source.getId());
//
//        if(source == destination){
//            return true;
//        }
//
//        for(Node child: source.getAdjacent()){
//            if(hasPathDFS(child,destination,visited)){
//                return true;
//            }
//        }
//    }
//
////    DFS Find path between two nodes in a graph
////    Go Deep Before Going Broad
//
////    BFS says Go Level by Level Out
////    Broad To Neigbors before going deep
//    public static class Node{
//        private int payload;
//
//        private int id;
//
//        private LinkedList<Node> adjacent = new LinkedList<Node>()
//
//        Node(int payload){
//            this.payload = payload;
//        }
//
//        void addNewAdjacentNode(Node destination){
//            adjacent.add(destination);
//        }
//
//        public int getId() {
//            return id;
//        }
//
//        LinkedList<Node> getAdjacent(){
//            return adjacent;
//        }
//    }
//}
