package com.myapp.java;

import com.bumptech.glide.Glide;

import org.w3c.dom.Node;

public class Test2 {
    public String testStr;

    public Test2(String testStr) {
        this.testStr = testStr;
    }

    public Test2() {

    }

    public static void main(String[] args){
    }

    public int remove(Node node,Node removeNode){
        int index=-1;
        Node current=node;
        Node firstNode=node;
        while (current!=null){
            if (index!=-1&&firstNode.equals(current)){
                break;
            }
            index++;
            if (removeNode.equals(current)){
                if (current.preNode!=null&&current.nextNode!=null){
                    Node preNode=current.preNode;
                    Node nextNode=current.nextNode;
                    preNode.nextNode=nextNode;
                    nextNode.preNode=preNode;
                }else if (current.preNode==null&&current.nextNode!=null){
                    current.nextNode.preNode=null;
                }else if (current.preNode!=null&&current.nextNode==null){
                    current.preNode.nextNode=null;
                }else {
                    current=null;
                }

            }
            current=current.nextNode;


        }
        return index;
    }


    class Node{
        Object data;
        Node preNode;
        Node nextNode;

    }
}
