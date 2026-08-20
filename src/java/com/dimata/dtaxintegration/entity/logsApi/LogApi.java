package com.dimata.dtaxintegration.entity.logsApi;


import com.dimata.qdep.entity.Entity;
import java.util.Date; 

public class LogApi extends Entity {

    private int oidApi = 0;
    private String apiName = "";
    private String modulName = "";
    private Date reqDate = null;
    private String status = "";
    private String message = "";

    public int getOidApi() {
        return oidApi;
    }

    public void setOidApi(int oidApi) {
        this.oidApi = oidApi;
    }
    
    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getModulName() {
        return modulName;
    }

    public void setModulName(String modulName) {
        this.modulName = modulName;
    }

    public Date getReqDate() {
        return reqDate;
    }

    public void setReqDate(Date reqDate) {
        this.reqDate = reqDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
