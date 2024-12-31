package com.example.selenium4java17;

public class LinkedListExample {
    Node head;

     static class Node {
        int data;
        Node next;

        Node(int i){
            this.data = i;
            this.next = null;
        }

        public static LinkedListExample insert(LinkedListExample ll, int i){
            Node newNode = new Node(i);
            if(ll.head == null){
                ll.head = newNode;
            }else{
                Node last = ll.head;
                while(last.next != null){
                    last = last.next;
                }
                last.next = newNode;
            }
          return null;
        }

        public static void printAll(LinkedListExample ll){
            Node last = ll.head;
            while (last != null) {
                System.out.println(last.data);
                last = last.next;
            }
        }

    }


        public static void main(String[] args) {
            LinkedListExample ll = new LinkedListExample();
            Node.insert(ll, 10);
            Node.insert(ll, 20);
            Node.printAll(ll);
        }

}
