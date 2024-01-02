
public class NodeDays {
    private int day;
    private DataRecord data;
    private NodeDays next;

    public NodeDays(int day) {
        this.day = day;
        this.data = new DataRecord();
        this.next = null;
    }
    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day = day;
    }
    public DataRecord getData() {
        return data;
    }
    public void setData(DataRecord data) {
        this.data = data;
    }
    public NodeDays getNext() {
        return next;
    }
    public void setNext(NodeDays next) {
        this.next = next;
    }
    @Override
    public String toString() {
        return "NodeDays [day=" + day + ", data=" + data + ", next=" + next + "]";
    }

}


