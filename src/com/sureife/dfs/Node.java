package com.sureife.dfs;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by sureife on 04/07/2017.
 */
public class Node {
    private int id;

    private LinkedList<Node> children = new LinkedList<>();

    public Node(int id){
        this.id = id;
    }

    public Node(int id,List<Node> children){
        this(id);

        loopAndSet(children);
    }

    private void loopAndSet(List<Node> children) {
        for(Node child:children){
            this.children.add(child);
        }
    }

    public int getId() {
        return id;
    }

    public LinkedList<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children.clear();
        loopAndSet(children);
    }
}
