
package com.seyir.tcellapi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseSuccess {

    @SerializedName("ticket_id")
    @Expose
    private String ticketId;
    @SerializedName("inDate")
    @Expose
    private InDate inDate;
    @SerializedName("resultCode")
    @Expose
    private String resultCode;
    @SerializedName("resultDescription")
    @Expose
    private String resultDescription;


    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public InDate getInDate() {
        return inDate;
    }

    public void setInDate(InDate inDate) {
        this.inDate = inDate;
    }

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

}
