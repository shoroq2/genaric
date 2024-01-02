
public class MonthNode {
    private int month;
    private SortedLinkedList Records;
    private MonthNode next;

    public MonthNode(int month) {
        this.month = month;
        this.Records = new SortedLinkedList();
        this.next = null;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public SortedLinkedList getRecords() {
        return Records;
    }

    public void setRecords(SortedLinkedList records) {
        Records = records;
    }

    public MonthNode getNext() {
        return next;
    }

    public void setNext(MonthNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "MonthNode [month=" + month + ", Records=" + Records + ", next=" + next + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MonthNode other = (MonthNode) obj;
        return this.month == other.month;
    }
}

