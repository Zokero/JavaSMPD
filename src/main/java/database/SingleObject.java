package database;

import java.util.List;

public class SingleObject {
    private int classId;
    private String className;
    private List<Double> features;

    public SingleObject(String className, List<Double> features) {
        this.className = className;
        this.features = features;
    }

    public int getClassId() {
        return classId;
    }

    public String getClassName() {
        return className;
    }

    public int getFeaturesNumber() {
        return features.size();
    }

    public List<Double> getFeatures() {
        return features;
    }

    @Override
    public String toString() {
        return "SingleObject{" +
                "classId=" + classId +
                ", className='" + className + '\'' +
                ", features=" + features +
                '}';
    }
}


