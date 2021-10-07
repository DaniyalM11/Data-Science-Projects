package cs570;

import java.util.*;

public class IDLList<E>{
        
       private Node<E> head = null;
       private Node<E> tail = null;
       private int size = 0;
        
        
        private static class Node<E>{
                private E data;
                private Node<E> next;
                private Node<E> prev;
                
                private Node(E elem) {
                       data = elem;
                }
                
                private Node(E elem, Node<E> next, Node<E> prev) {
                       data = elem;
                       this.next = next;
                       this.prev = prev;
                }
        }
        
        private ArrayList<Node<E>> indices;
        
        public IDLList () {
                head = null;
                tail = null;
                indices = null;
                indices = new ArrayList<Node<E>>();
        }
        
        
        
        public boolean add(int index, E elem) {
                
                    
                if(index < 0 || index > size) {
                           System.out.println("Error! The index: " + index + " is out of bounds");
                           return false;
                    }
                    else {
                           Node<E> current = head;
                           int currentIndex = 0;
                           while(current != null) {
                                  current = current.next;
                                  if(++currentIndex + 1 == index) {
                                         
                                         System.out.println("adding after node: " + current.data);
                                         Node<E> nodeToAdd = new Node<E>(elem);
                                         nodeToAdd.next = current.next;
                                         nodeToAdd.prev = current;
                                         current.next = nodeToAdd;
                                         current = nodeToAdd;
                                         indices.add(index, nodeToAdd);
                                         break;
                                  }
                           }
                    }
                	size++;
                    return true;
        }
         
        public boolean add(E elem) {
        	if(head == null) {
               head = new Node<E>(elem);
               head.prev = null;
               tail = head; 
               tail.next = null;
               indices.add(0,head);
                  
        	} else {
                Node<E> nodeToAdd = new Node<E>(elem);
                nodeToAdd.next = head;
                nodeToAdd.prev = null;
                head.prev = nodeToAdd;
                head = nodeToAdd;
                indices.add(0,head);
                     }
                     
                size++;
                return true;
         }
              
              public boolean append(E elem) {

                     if(tail == null) {
                           tail = new Node<E>(elem);
                           tail.next = null;
                           head = tail; 
                           head.prev = null;
                           indices.add(size,tail);
                     } else {
                           Node<E> nodeToAdd = new Node<E>(elem);
                           nodeToAdd.prev = tail;
                           nodeToAdd.next = null;
                           tail.next = nodeToAdd;
                           tail = nodeToAdd;
                           indices.add(size,tail);
                     }
                     size++;
                     return true;
              }
              
              public E get(int index) {
            	  System.out.println(indices.get(index).data); 
            	  return indices.get(index).data;
              }
              
              public E getHead() {
            	  System.out.println(indices.get(0).data);
            	  return indices.get(0).data;
              }
              
              public E getLast() {
            	  System.out.println(indices.get(size-1).data);
            	  return indices.get(size-1).data;
              }
              
              public int size() {
            	  System.out.println(size);
            	  return size;
              }
              
              public E remove() {

            	  Node<E>temp = head;
            	  if(head != null) {
            		  head = head.next;
            		  head.prev = null;
            		  size--;
            		  indices.remove(0);
            		  return temp.data;
              	  }
            	  else {
            		  return null;
            	  }
              }
              
              public E removeLast() {

            	  Node<E>tailtemp = tail;
            	  if(tail != null) {
            		  tail = tail.prev;
            		  tail.next = null;
            		  size--;
            		  indices.remove(size);
            		  return tailtemp.data;
              	  }
            	  else {
            		  return null;
            	  }
              }
              
              public E removeAt(int index) {
            	  if(index < 0 || index > size) {
            		  System.out.println("Error! The index: " + index + " is out of bounds");
            		  return null;
            	  }
            	  else {
            		  Node<E>current = head;
            		  int currentIndex = 0;
            		  while(current != null) {
            			  current = current.next;
            			  if(++currentIndex + 1 == index) {
            				  System.out.println("removing: " + current.data);
            				  current.prev.next = current.next;
            				  current.next.prev = current.prev;
            				  break;
            			  }
            		  }
            	  }
            	  ;
            	  size--;
            	 
            	  return indices.remove(index).data;
              }
              
              public String toString() {
            	  String tmp = "";
            	  Node<E>nodeRef = head;
            	  while (nodeRef!=null) {
            		  tmp= tmp + nodeRef.data;
            		  if(nodeRef.next != null)
            			  tmp = tmp + ", ";
            		  nodeRef = nodeRef.next;
            	  }
            	  return tmp;
              }
              //method printList for testing
              public void printList() {
                     Node<E> current = head;
                     while(current != null) {
                           System.out.println("node: " + current.data);
                           current = current.next;
                     }
                     for(IDLList.Node<E> E : indices) {
                    	 System.out.println("Element: " + E.data);
                     }
              }
              

         //main for testing     
        public static void main(String[] args) {
             System.out.println("Hello world");
              IDLList<String> test = new IDLList<String>();
              test.add("F");
              test.add("E");
              test.add("D");
              test.add("C");
              test.add("B");
              test.add("A");
              test.add(4,"G");
              
              test.printList();
              test.size();
              test.get(3);
              test.getHead();
              test.getLast();
//              test.remove();
              test.getHead();
              test.size();
//              test.remove();              
              test.getLast();
              test.size();
//            test.printList();
//              test.removeLast();
//              test.removeLast();
              test.getLast();
              test.size();
              test.printList();
            test.removeAt(1);
//              test.remove();
              test.printList();
              test.size();
              System.out.println(test);
        }      
}