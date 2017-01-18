
package com.seyir.tcellapi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeviceSearch {

    @SerializedName("resultCode")
    @Expose
    private String resultCode;
    @SerializedName("resultDescription")
    @Expose
    private String resultDescription;
    @SerializedName("detail")
    @Expose
    private Detail detail;
    @SerializedName("creditUsage")
    @Expose
    private Integer creditUsage;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultDescription() {
        return resultDescription;
    }

    public void setResultDescription(String resultDescription) {
        this.resultDescription = resultDescription;
    }

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }

    public Integer getCreditUsage() {
        return creditUsage;
    }

    public void setCreditUsage(Integer creditUsage) {
        this.creditUsage = creditUsage;
    }

}
