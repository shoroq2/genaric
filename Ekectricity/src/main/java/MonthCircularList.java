
public class MonthCircularList {
    MonthNode head;
    int count = 0;

    public void addLast(int month) {
        MonthNode newNode = new MonthNode(month);
        if (head == null) {
            head = newNode;
            head.setNext(head);
        } else {
            MonthNode temp = head;
            while (temp.getNext() != head) {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
            newNode.setNext(head);
        }
        count++;
    }

    public void addFirst(int month) {
        MonthNode newNode = new MonthNode(month);
        if (head == null) {
            head = newNode;
            head.setNext(head);
        } else {
            MonthNode temp = head;
            while (temp.getNext() != head) {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
            newNode.setNext(head);
            head = newNode;
        }
        count++;
    }

    public void insertSorted(int month) {
        MonthNode newNode = new MonthNode(month);

        if (head == null || month < head.getMonth()) {
            newNode.setNext(head);
            head = newNode;
        } else {
            MonthNode temp = head;
            while (temp.getNext() != null && month > temp.getNext().getMonth()) {
                temp = temp.getNext();
            }
            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
        }
        count++;
    }

    public void printList() { // print method
        if (head == null) {
            System.out.println("the list was empty");
            return;
        }

        MonthNode temp = head;
        do {
            System.out.println("Month: " + temp.getMonth());
            temp = temp.getNext();
        } while (temp != head);
    }

    public boolean remove(int month) {
        if (head == null) {
            return false;
        }

        if (head.getNext() == head && month == head.getMonth()) {
            head = null;
            count = 0;
            return true;
        }

        MonthNode current = head;
        MonthNode previous = null;

        do {
            if (month == current.getMonth()) {
                if (current == head) {
                    // If the element to be removed is the head
                    MonthNode temp = head;
                    while (temp.getNext() != head) {
                        temp = temp.getNext();
                    }
                    head = head.getNext();
                    temp.setNext(head);
                } else {
                    previous.setNext(current.getNext());
                }
                count--;
                return true;
            }
            previous = current;
            current = current.getNext();
        } while (current != head && current != null);

        return false;
    }
    public MonthNode searchMonthNode(int month) {
        if (head == null) {
            head = new MonthNode(month);
            return head;
        }
        MonthNode current = head;
        do {
            if (current != null && current.getMonth() == month) {
                // Found the node with the given month
                return current;
            }
            current = current.getNext();
        } while (current != head && current != null);
        MonthNode newNode = new MonthNode(month);
        newNode.setNext(head);
        MonthNode temp = head;
        while (temp != null && temp.getNext() != head) {
            temp = temp.getNext();
        }
        if (temp != null) {
            temp.setNext(newNode);
        }
        return newNode;
    }


    public boolean contains(MonthNode targetNode) {
        MonthNode current = head;
        do {
            if (current.equals(targetNode)) {
                return true;
            }
            current = current.getNext();
        } while (current != head);
        return false;
    }

    @Override
    public String toString() {
        return "MonthCircularList [head=" + head + ", count=" + count + "]";
    }


}

    