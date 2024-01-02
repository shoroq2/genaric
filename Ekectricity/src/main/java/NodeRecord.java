
public class NodeRecord {
    private DataRecord data;
    private NodeRecord next;
    public NodeRecord(DataRecord data) {
        this.data = data;
        this.next = null;
    }
    public DataRecord getData() {
        return data;
    }
    public void setData(DataRecord data) {
        this.data = data;
    }
    public NodeRecord getNext() {
        return next;
    }
    public void setNext(NodeRecord next) {
        this.next = next;
    }
    @Override
    public String toString() {
        return "NodeRecord [data=" + data + ", next=" + next + "]";
    }

}
