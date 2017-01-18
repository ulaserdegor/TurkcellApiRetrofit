
package com.seyir.tcellapi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InDate {

    @SerializedName("timestamp")
    @Expose
    private Double timestamp;
    @SerializedName("localTime")
    @Expose
    private String localTime;

    public Double getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Double timestamp) {
        this.timestamp = timestamp;
    }

    public String getLocalTime() {
        return localTime;
    }

    public void setLocalTime(String localTime) {
        this.localTime = localTime;
    }

}
