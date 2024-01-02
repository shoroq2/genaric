
public class YearNode {
    private int year;
    private MonthCircularList months;
    private YearNode next;

    public YearNode(int year) {
        this.year = year;
        this.months = new MonthCircularList();
        this.next = null;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public MonthCircularList getMonths() {
        return months;
    }

    public void setMonths(MonthCircularList months) {
        this.months = months;
    }

    public YearNode getNext() {
        return next;
    }

    public void setNext(YearNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "YearNode{" + "year=" + year + '}';
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        YearNode other = (YearNode) obj;
        return this.year == other.year;
    }


}
