package com.focus.Counter.entity;


import com.focus.Counter.utils.RequestUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class CounterRecord {

    private long id;
    private String uniqueKey;
    private String serverhost;
    private String serverip;
    private String clienthost;
    private String clientip;
    private String os;
    private String browser;
    private Date creattime;
    private Date executetime;


    public void init(HttpServletRequest request) {
        this.serverhost = request.getHeader("Host");
        this.serverip = request.getServerName();
        this.clientip = RequestUtils.getIpAddr(request);
        this.clienthost = request.getRemoteHost();
        this.os = RequestUtils.getOsInfo(request);
        this.browser = RequestUtils.getBrowserInfo(request);
        this.creattime = new Date();

    }

    public CounterRecord(HttpServletRequest request) {
        init(request);

    }

    public CounterRecord(long id, String uniqueKey, String serverhost, String serverip, String clienthost, String clientip, String os, String browser, Date creattime, Date executetime) {
        this.id = id;
        this.uniqueKey = uniqueKey;
        this.serverhost = serverhost;
        this.serverip = serverip;
        this.clienthost = clienthost;
        this.clientip = clientip;
        this.os = os;
        this.browser = browser;
        this.creattime = creattime;
        this.executetime = executetime;
    }

    public CounterRecord(String uniqueKey, String serverhost, String serverip, String clienthost, String clientip, String os, String browser, Date creattime, Date executetime) {
        this.uniqueKey = uniqueKey;
        this.serverhost = serverhost;
        this.serverip = serverip;
        this.clienthost = clienthost;
        this.clientip = clientip;
        this.os = os;
        this.browser = browser;
        this.creattime = creattime;
        this.executetime = executetime;
    }

    public CounterRecord(String serverhost, String serverip, String clienthost, String clientip, String os, String browser, Date creattime, Date executetime) {
        this.serverhost = serverhost;
        this.serverip = serverip;
        this.clienthost = clienthost;
        this.clientip = clientip;
        this.os = os;
        this.browser = browser;
        this.creattime = creattime;
        this.executetime = executetime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getUniqueKey() {
        return uniqueKey;
    }

    public void setUniqueKey(String uniqueKey) {
        this.uniqueKey = uniqueKey;
    }

    public String getServerhost() {
        return serverhost;
    }

    public void setServerhost(String serverhost) {
        this.serverhost = serverhost;
    }


    public String getServerip() {
        return serverip;
    }

    public void setServerip(String serverip) {
        this.serverip = serverip;
    }


    public String getClienthost() {
        return clienthost;
    }

    public void setClienthost(String clienthost) {
        this.clienthost = clienthost;
    }


    public String getClientip() {
        return clientip;
    }

    public void setClientip(String clientip) {
        this.clientip = clientip;
    }


    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }


    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }


    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }


    public Date getExecutetime() {
        return executetime;
    }

    public void setExecutetime(Date executetime) {
        this.executetime = executetime;
    }



    @Override
    public String toString() {
        return "CounterRecord{" +
                "id=" + id +
                ", uniqueKey='" + uniqueKey + '\'' +
                ", serverhost='" + serverhost + '\'' +
                ", serverip='" + serverip + '\'' +
                ", clienthost='" + clienthost + '\'' +
                ", clientip='" + clientip + '\'' +
                ", os='" + os + '\'' +
                ", browser='" + browser + '\'' +
                ", creattime=" + creattime +
                ", executetime=" + executetime +
                '}';
    }
}
