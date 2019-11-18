
package com.example.android.googlemapsapp.MapsResources;

import java.util.HashMap;
import java.util.Map;

public class Metadata {

    private Boolean isRawFood;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Boolean getIsRawFood() {
        return isRawFood;
    }

    public void setIsRawFood(Boolean isRawFood) {
        this.isRawFood = isRawFood;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
