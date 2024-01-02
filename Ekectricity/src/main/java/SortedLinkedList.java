import java.util.Objects;

public class SortedLinkedList {
    NodeRecord first, last; // Two nodes of kind record
    int count = 0; // Start the counter at 0

    public DataRecord getFirst() {
        return (count > 0) ? first.getData() : null;
    }

    public DataRecord getLast() {
        return (count > 0) ? last.getData() : null;
    }

    public void addLast(DataRecord dataRecord) {
        NodeRecord newNode = new NodeRecord(dataRecord);
        if (last == null) {
            last = first = newNode;
        } else {
            Objects.requireNonNull(newNode);
            last.setNext(newNode);
            last = newNode;
            count++;
        }
    }

    public void addFirst(DataRecord dataRecord) {
        NodeRecord newNode = new NodeRecord(dataRecord);
        if (last == null) {
            last = first = newNode;
        } else {
            Objects.requireNonNull(newNode);
            newNode.setNext(first);
            first = newNode;
            count++;
        }
    }

    public void add(DataRecord dataRecord) {
        NodeRecord newNode = new NodeRecord(dataRecord);
        if (first == null || dataRecord.getDate().compareTo(first.getData().getDate()) <= 0) {
            addFirst(dataRecord);
        } else if (dataRecord.getDate().compareTo(last.getData().getDate()) >= 0) {
            addLast(dataRecord);
        } else {
            NodeRecord prev = null;
            NodeRecord curr = first;

            while (curr != null && dataRecord.getDate().compareTo(curr.getData().getDate()) > 0) {
                prev = curr;
                curr = curr.getNext();
            }

            Objects.requireNonNull(newNode);
            newNode.setNext(curr);
            prev.setNext(newNode);
            count++;
        }
    }

    public void printList() {
        NodeRecord curr = first;
        while (curr != null) {
            DataRecord dataRecord = curr.getData();
            System.out.println("Date: " + dataRecord.getDate() + ", Israeli Lines: " + dataRecord.getIsraeliLines()
                    + ", Gaza Power Plant: " + dataRecord.getGazaPowerPlant() + ", Egyptian Lines: "
                    + dataRecord.getEgyptianLines() + ", Total Supply: " + dataRecord.getTotalSupply() + ", Demand: "
                    + dataRecord.getDemand() + ", Power_Cuts_hours_day: " + dataRecord.getPowerCutshoursday()
                    + ", Temp: " + dataRecord.getTemp());
            curr = curr.getNext();
        }
    }

    public boolean remove(DataRecord dataRecord) {
        if (first == null) {
            return false;
        }
        if (first.equals(last)) {
            if (Objects.equals(dataRecord, first.getData())) {
                first = last = null;
                count--;
                return true;
            }
        } else {
            if (Objects.equals(dataRecord, first.getData())) {
                NodeRecord temp = first;
                first = first.getNext();
                temp.setNext(null);
                count--;
                return true;
            } else {
                NodeRecord prev = first;
                NodeRecord curr = first.getNext();

                while (curr != null) {
                    if (Objects.equals(dataRecord, curr.getData())) {
                        if (curr.equals(last)) {
                            last = prev;
                        }
                        prev.setNext(curr.getNext());
                        curr.setNext(null);
                        count--;
                        return true;
                    }
                    prev = curr;
                    curr = curr.getNext();
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("SortedLinkedList [");

        NodeRecord current = first;
        while (current != null) {
            // Append relevant information from each NodeRecord
            result.append("NodeRecord [data=").append(current.getData()).append("], ");

            current = current.getNext();
        }

        result.append("]");
        return result.toString();
    }
}

