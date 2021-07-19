package com.myapp.java;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Test5 {
    public static void main(String[] args) {

    }

    public static boolean check(Node node) {

        Node firstNode = node.next.next;
        Node lowNode = node.next;
        while (firstNode == lowNode) {

            if (firstNode.next == null || firstNode.next.next == null) {
                return false;
            }
            firstNode = firstNode.next.next;
            lowNode = lowNode.next;
        }
        return true;
    }

}

class Node {
    Object data;
    Node next;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(data, node.data) &&
                Objects.equals(next, node.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, next);
    }
}
