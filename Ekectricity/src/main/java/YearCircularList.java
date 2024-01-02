
public class YearCircularList {
    YearNode head;
    int count = 0;

    public void addLast(int year) {
        YearNode newNode = new YearNode(year);
        if (head == null) {
            head = newNode;
            head.setNext(head);
        } else {
            YearNode temp = head;
            while (temp.getNext() != head) {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
            newNode.setNext(head);
        }
        count++;
    }

    public void addFirst(int year) {
        YearNode newNode = new YearNode(year);
        if (head == null) {
            head = newNode;
            head.setNext(head);
        } else {
            YearNode temp = head;
            while (temp.getNext() != head) {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
            newNode.setNext(head);
            head = newNode;
        }
        count++;
    }

    public YearNode searchYearNode(int year) {
        if (head == null) {
            head = new YearNode(year);
            head.setNext(head);
            return head;
        }
        YearNode current = head;
        do {
            if (current.getYear() == year) {
                return current;
            }
            current = current.getNext();
        } while (current != head);

        // If the node is not found, create a new one and link it to the circular list
        YearNode newNode = new YearNode(year);
        newNode.setNext(head);

        // Traverse the list to find the last node
        YearNode temp = head;
        while (temp.getNext() != head) {
            temp = temp.getNext();
        }

        return newNode;
    }

    public boolean contains(YearNode targetNode) {
        YearNode current = head;
        do {
            if (current.equals(targetNode)) {
                return true;
            }
            current = current.getNext();
        } while (current != head);
        return false;
    }

    public void insertSorted(int year) {
        YearNode newNode = new YearNode(year);

        if (head == null || year < head.getYear()) {
            newNode.setNext(head);
            head = newNode;
        } else {
            YearNode temp = head;
            while (temp.getNext() != null && year > temp.getNext().getYear()) {
                temp = temp.getNext();
            }
            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
        }
        count++;
    }

    public void printList() {
        if (head == null) {
            System.out.println("the list was empty");
            return;
        }

        YearNode temp = head;
        do {
            System.out.println("Year: " + temp.getYear());
            temp = temp.getNext();
        } while (temp != null && temp != head);
    }

    public boolean remove(int year) {
        if (head == null) {
            return false;
        }

        if (head.getNext() == head && year == head.getYear()) {
            head = null;
            count = 0;
            return true;
        }

        YearNode current = head;
        YearNode previous = null;

        do {
            if (year == current.getYear()) {
                if (current == head) {
                    // If the element to be removed is the head
                    YearNode temp = head;
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
        } while (current != head);

        return false;
    }

    @Override
    public String toString() {
        return "YearCircularList [head=" + head + ", count=" + count + "]";
    }

}

