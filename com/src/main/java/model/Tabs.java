package model;

import java.util.ArrayList;
import java.util.List;

public class Tabs {
    private List<Measure> measures;

    public Tabs() {
        this.measures = new ArrayList<>();
    }

    public void addMeasure(Measure measure) {
        measures.add(measure);
    }

    public List<Measure> getMeasures() {
        return measures;
    }
}
