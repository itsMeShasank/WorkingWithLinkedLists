package com.epam;

public class SingleLinkedList {
    private ListNode head;

    public SingleLinkedList() {
        this.head = null;
    }

    public static class ListNode {
        private int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void print() {
        if (head == null) {
            throw new LinkedListException("No elements found");
        }
        System.out.print("[");
        while (head != null) {
            if(head.next == null) {
                System.out.print(head.data+"");
                break;
            }
            System.out.print(head.data+", ");
            head = head.next;
        }
        System.out.println("]");
    }
    public ListNode addElementAtFirst(int data) {
        if (head != null) {
            ListNode firstElement = new ListNode(data);
            firstElement.next = head;
            head = firstElement;
        } else {
            head = newNodeCreation(data);
        }
        return head;
    }

    public ListNode add(int data) {
        return addElementAtLast(data);
    }
    public ListNode addElementAtLast(int data) {
        ListNode node = new ListNode(data);
        if (head != null) {
            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        } else {
            head = node;
        }

        return head;
    }

    public void update(int position,int data) {
        if (head == null) {
            throw new LinkedListException("No list found created earlier.");
        }
        if(position <= 0) {
            throw new LinkedListException("Please provide a proper position.");
        }
        else if(position == 1) {
            head.data = data;
        } else if (position > size()) {
            throw new LinkedListException("List size is less than the position you specified.");
        } else {
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
                count+=1;
            }
            if(!isChanged) {
                throw new LinkedListException("No element found with that data");
            }
        }
    }
    public void remove(int data) {
        if (head == null) {
            throw new LinkedListException("No list found created earlier.");
        }
        if (head.data == data) {
            head = head.next;
        } else {
            boolean isRemoved = false;
            ListNode previous = head;
            ListNode current = head.next;
            while (current != null) {
                if (current.data == data) {
                    previous.next = current.next;
                    isRemoved = true;
                    break;
                }
                current = current.next;
                previous = previous.next;
            }
            if(!isRemoved) {
                System.out.println("No element found.");
            }
        }
    }

    public int size() {
        int length = 0;
        if(head != null) {
            length = getListLength();
        }
        return length;
    }
    public void insert(int position, int data) {
        if (head == null) {
            throw new LinkedListException("List not created.");
        }

        if (position < 0) {
            throw new LinkedListException("Please provide a proper position.");
        }

        int length = getListLength();

        if (position == 1) {
            head = addElementAtFirst(data);
        } else if (position == length + 1) {
            head = addElementAtLast(data);
        } else if (position > length + 1) {
            throw new LinkedListException("List size is less than the position you specified.");
        } else {
            ListNode newNode = newNodeCreation(data);
            ListNode previous = head;
            ListNode current = head.next;
            int count = 1;
            while (count < position - 1) {
                previous = current;
                current = current.next;
                count++;
            }
            previous.next = newNode;
            newNode.next = current;
        }
    }
    private int getListLength() {
        int count = 0;
        ListNode node = head;
        while (node != null) {
            count += 1;
            node = node.next;
        }
        return count;
    }
    private ListNode newNodeCreation(int data) {
        return new ListNode(data);
    }
}
