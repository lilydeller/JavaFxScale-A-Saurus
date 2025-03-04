package model;
import java.util.ArrayList;

public class Tabs {
    private ArrayList<Measure> measures;

    public Tabs() {
        this.measures = new ArrayList<>();
    }

    public Measure getMeasure(int index) {
        if (index >= 0 && index < measures.size()) {
            return measures.get(index);
        }
        return null; //  null if index is out of bounds
    }

    public void addMeasure(Measure measure) {
        if (measure != null) {
            measures.add(measure);
        }
    }

    public void removeMeasure(Measure measure) {
        measures.remove(measure);
    }
}
