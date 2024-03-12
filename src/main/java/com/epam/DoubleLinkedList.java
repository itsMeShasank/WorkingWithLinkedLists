package com.epam;

public class DoubleLinkedList {
    private ListNode head;
    private ListNode end;

    public DoubleLinkedList() {
        this.head = null;
        this.end = null;
    }
    public static class ListNode {
        private int data;
        private ListNode previous;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }
    }

    public void print() {
        if(head == null) {
            throw new LinkedListException("No elements found");
        }
        ListNode traverse = head;
        System.out.print("[");
        while(traverse != null) {
            if(traverse.next == null) {
                System.out.print(traverse.data+"");
                break;
            }
            System.out.print(traverse.data+", ");
            traverse = traverse.next;
        }
        System.out.println("]");
    }
    public void printReverse() {
        if(end == null) {
            throw new LinkedListException("No elements found");
        }
        ListNode traverse = end;
        System.out.print("[");
        while(traverse != null) {
            if(traverse.previous == null) {
                System.out.print(traverse.data+"");
                break;
            }
            System.out.print(traverse.data+", ");
            traverse = traverse.previous;
        }
        System.out.println("]");
    }

    public void add(int data) {
        if(head == null || end == null) {
            newListCreation(data);
        }else {
            addElementAtLast(data);
        }
    }
    public ListNode addElementAtFirst(int data) {
        if(head == null) {
            newListCreation(data);
        }else {
            ListNode firstElement = newNodeCreation(data);
            firstElement.next = head;
            head.previous = firstElement;
            head = firstElement;
        }
        return head;
    }
    public ListNode addElementAtLast(int data) {
        if(head == null) {
            newListCreation(data);
        }else {
            ListNode node = newNodeCreation(data);
            end.next = node;
            node.previous = end;
            end = node;
        }
        return head;
    }
    public void update(int position,int data) {
        if(head == null || end == null) {
            throw new LinkedListException("No list found created earlier");
        }

        if(position <= 0) {
            throw new LinkedListException("Please provide a proper position.");
        }else if(position == 1) {
            head.data = data;
        }else if(position > size()){
            throw new LinkedListException("List size is less than the position you specified.");
        }else {
            ListNode current = head;
            boolean isChanged = false;
            int count = 1;
            while(current != null) {
                if(position == count) {
                    current.data = data;
                    isChanged = true;
                    break;
                }
                current = current.next;
                count += 1;
            }
            if(!isChanged) {
                throw new LinkedListException("No element found with that data");
            }
        }
    }
    public void remove(int data) {
        if(head == null || end == null) {
            throw new LinkedListException("No list found created earlier");
        }
        if(head.data == data) {
            head = head.next;
            head.previous = null;
        }else {
            ListNode previous = head;
            ListNode current = head.next;
            while(current != null) {
                if(current.data == data) {
                    previous.next = current.next;
                    current.next.previous = previous;
                    break;
                }
                current = current.next;
                previous = previous.next;
            }
        }
    }

    public void removeElementAtLast(int data) {
        if(end == null) {
            throw new LinkedListException("No elements found");
        }
        boolean isRemoved = false;
        ListNode current = end;
        ListNode previous = end.previous;
        if(end.data == data) {
            end = current.previous;
        }else {
            while (current != null) {
                if (current.data == data) {
                    previous.next = current.next;
                    current.next.previous = previous;
                    current.previous = null;
                    current.next = null;
                    isRemoved = true;
                    break;
                }
                current = current.previous;
                previous = previous.previous;
            }
            if (!isRemoved) {
                System.out.println("No element found.");
            }
        }
    }

    public int size() {
        int length = 0;
        if(head != null) {
           ListNode current = head;
           while(current != null) {
               current = current.next;
               length += 1;
           }
        }
        return length;
    }

    public void insert(int position,int data) {
        if (head == null) {
            throw new LinkedListException("List not created.");
        }

        if (position < 0) {
            throw new LinkedListException("Please provide a proper position.");
        }
        int length = size();
        if (position == 1) {
            head = addElementAtFirst(data);
        } else if (position == length + 1) {
            head = addElementAtLast(data);
        } else if (position > length + 1) {
            throw new LinkedListException("List size is less than the position you specified.");
        }else {
            ListNode newNode = newNodeCreation(data);
            ListNode previous = head;
            ListNode current = head.next;
            int count = 1;
            while(count < position - 1) {
                previous = current;
                current = current.next;
                count += 1;
            }
            previous.next = newNode;
            newNode.previous = previous;
            newNode.next = current;
            current.previous = newNode;
        }
    }

    private ListNode newNodeCreation(int data) {
        return new ListNode(data);
    }
    private void newListCreation(int data) {
        head = newNodeCreation(data);
        head.previous = null;
        head.next = null;
        end = head;
    }
}
