package com.sureife.dfs;

import java.util.*;

/**
 * Created by sureife on 04/07/2017.
 */
public class Graph {
    HashMap<Integer,Node> lookup = new HashMap<>();

    public Graph(List<Node> nodes) throws Exception {
        for(Node node : nodes){
            if(lookup.containsKey(node.getId())){
                throw new Exception("Node already Exists");
            }
            lookup.put(node.getId(),node);
        }
    }

    private Node getNode(int id){
        Node node = null;

        if(lookup.containsKey(id)){
            node = lookup.get(id);
        }

        return node;
    }


    // start at root,select arbitrary node as root
    // explores as far as possible along each branch before backtracking.

    /**
     * Picks a random node as source
     * @param destination  node
     * @return Path to goal, or null if path to goal is not found
     */
    public void searchDepthFirst(int destination){


        // Convert Node to a List
        Integer[] nodesArray = new Integer[]{};
        nodesArray = lookup.keySet().toArray(nodesArray);
        List<Integer> nodes = Arrays.asList(nodesArray);

        // Get Random Source Node
        Random randomizer = new Random();
        int source = nodes.get(randomizer.nextInt(nodes.size()));

        // SEARCH
        searchDepthFirst(source,destination);
    }

    public void searchDepthFirst(int source,int destination){
        Stack<Integer> open = new Stack<>();
        HashSet<Integer> visited = new HashSet<>();

        System.out.println("\nRecursive DFS + Backtracking(COMPLETE-If its there we will find it)");
        searchDepthFirst(source,destination,open,visited);
    }

    /**
     *
     * @param source node
     * @param destination  node
     * @param open
     * @param visited
     * @return Path to goal, or null if path to goal is not found
     */
    private void searchDepthFirst(int source,int destination,Stack<Integer> open, HashSet<Integer> visited){


        if(lookup.containsKey(source) && lookup.containsKey(destination)){
            if(!visited.contains(source)){
                // add start node
                open.add(source);

                // visit start node
                visited.add(source);
                System.out.println("Visit Node " + source);
            }

            if(source == destination){
                return;
            }else{
                List<Integer> unvisitedChildren = getUnvisitedChildren(source,visited);

                if(unvisitedChildren != null && unvisitedChildren.size() > 0){
                    searchDepthFirst(unvisitedChildren.get(0),destination,open,visited);
                }else if(!open.isEmpty()){
                    open.pop();
                    searchDepthFirst(open.peek(),destination,open,visited);
                }
            }
        }else{
            throw new IllegalArgumentException("Source/Destination is not a valid node");
        }
    }

    public boolean searchDepthFirstIterative(int source,int destination){
        HashSet<Integer> visited = new HashSet<>();

        if(lookup.containsKey(source) && lookup.containsKey(destination)){
            Stack<Integer> open = new Stack<>();

            open.push(source);

            System.out.println("\nIterative DFS - NOT COMPLETE/NO BACKTRACKING(NO CYCLES BUT IT CAN GET STUCK WHEN THERE ARENT ANY NODES TO VISIT)");

            while(!open.isEmpty()){
                int v = open.pop();
                System.out.println("Visit Node " + v);
                visited.add(v);
                if(v == destination){
                    return true;
                }
                for (int child:getUnvisitedChildren(v,visited)) {
                    open.push(child);
                }
            }
        }
        return false;
    }

    public boolean bfs(int source,int destination){
        HashSet<Integer> visited =  new HashSet<>();

        LinkedList<Integer> open =  new LinkedList<>(); // Use as Queue

        open.add(source);

        System.out.println("Breadth First Search");

        while(!open.isEmpty()){
            int v = open.removeLast();

            System.out.println("Visit Node " + v);
            visited.add(v);

            if(v == destination){
                return true;
            }
            for (int child:getUnvisitedChildren(v,visited)) {
                open.addFirst(child);
            }
        }
        return false;
    }

    private List<Integer> getUnvisitedChildren(int node,HashSet<Integer> visited){
        Node n = getNode(node);

        List<Node> children = n.getChildren();
        List<Integer> unvisitedChildren = new ArrayList<>();

        for(Node child:children){
            if (!visited.contains(child.getId())) unvisitedChildren.add(child.getId());
        }

        return unvisitedChildren;
    }


}
