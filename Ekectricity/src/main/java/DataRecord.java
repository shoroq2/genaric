
import java.time.LocalDate;

public class DataRecord {
    private LocalDate Date;
    private Double israeliLines;
    private Double gazaPowerPlant;
    private Double egyptianLines;
    private Double totalSupply;
    private Double demand;
    private Double PowerCutshoursday;
    private Double Temp;

    public DataRecord(LocalDate date, Double israeliLines, Double gazaPowerPlant, Double egyptianLines,
                      Double totalSupply, Double demand, Double powerCutshoursday, Double temp) {
        Date = date;
        this.israeliLines = israeliLines;
        this.gazaPowerPlant = gazaPowerPlant;
        this.egyptianLines = egyptianLines;
        this.totalSupply = totalSupply;
        this.demand = demand;
        PowerCutshoursday = powerCutshoursday;
        Temp = temp;
    }

    public DataRecord() {

    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }

    public Double getIsraeliLines() {
        return israeliLines;
    }

    public void setIsraeliLines(Double israeliLines) {
        this.israeliLines = israeliLines;
    }

    public Double getGazaPowerPlant() {
        return gazaPowerPlant;
    }

    public void setGazaPowerPlant(Double gazaPowerPlant) {
        this.gazaPowerPlant = gazaPowerPlant;
    }

    public Double getEgyptianLines() {
        return egyptianLines;
    }

    public void setEgyptianLines(Double egyptianLines) {
        this.egyptianLines = egyptianLines;
    }

    public Double getTotalSupply() {
        return totalSupply;
    }

    public void setTotalSupply(Double totalSupply) {
        this.totalSupply = totalSupply;
    }

    public Double getDemand() {
        return demand;
    }

    public void setDemand(Double demand) {
        this.demand = demand;
    }

    public Double getPowerCutshoursday() {
        return PowerCutshoursday;
    }

    public void setPowerCutshoursday(Double powerCutshoursday) {
        PowerCutshoursday = powerCutshoursday;
    }

    public Double getTemp() {
        return Temp;
    }

    public void setTemp(Double temp) {
        Temp = temp;
    }

    public int compareTo(LocalDate date2) {
        return this.Date.compareTo(date2);
    }

    @Override
    public String toString() {
        return "DailyRecord{" + "date=" + Date + ", israeliLines=" + israeliLines + ", gazaPowerPlant=" + gazaPowerPlant
                + ", egyptianLines=" + egyptianLines + ", totalSupply=" + totalSupply + ", demand=" + demand
                + ", powerCutsHours=" + PowerCutshoursday + ", temp=" + Temp + '}';
    }

}

    