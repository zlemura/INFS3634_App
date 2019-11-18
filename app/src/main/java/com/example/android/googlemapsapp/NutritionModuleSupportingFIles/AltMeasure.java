package com.example.android.googlemapsapp.NutritionModuleSupportingFIles;

import java.util.HashMap;
import java.util.Map;

public class AltMeasure {

    private Double servingWeight;
    private String measure;
    private Object seq;
    private Integer qty;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Double getServingWeight() {
        return servingWeight;
    }

    public void setServingWeight(Double servingWeight) {
        this.servingWeight = servingWeight;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public Object getSeq() {
        return seq;
    }

    public void setSeq(Object seq) {
        this.seq = seq;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
