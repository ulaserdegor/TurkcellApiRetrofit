
package com.seyir.tcellapi.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Detail {

    @SerializedName("msisdn")
    @Expose
    private String msisdn;
    @SerializedName("deviceInfo")
    @Expose
    private List<DeviceInfo> deviceInfo = null;

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public List<DeviceInfo> getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(List<DeviceInfo> deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

}
