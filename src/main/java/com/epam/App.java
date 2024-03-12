package com.epam;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SingleLinkedList list = new SingleLinkedList();
        list.add(10);
        list.insert(1,20);
        list.addElementAtLast(40);
        list.addElementAtFirst(0);
        list.insert(1,100);
        list.insert(3,300);
        list.remove(0);
        list.update(2,99999);
        list.print();

        DoubleLinkedList linkedList = new DoubleLinkedList();
        linkedList.add(10);
        linkedList.insert(1,20);
        linkedList.addElementAtLast(30);
        linkedList.addElementAtFirst(0);
        linkedList.insert(1,100);
        linkedList.insert(3,300);
        linkedList.remove(0);
        linkedList.update(2,99999);
        linkedList.print();
        linkedList.removeElementAtLast(20);
        linkedList.print();
    }
}
