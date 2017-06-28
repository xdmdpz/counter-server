package com.focus.Counter.entity;


import com.focus.Counter.utils.DateUtils;
import com.focus.Counter.utils.RequestUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Date;

public class CounterRecord implements  Serializable {
    private static final long serialVersionUID = 934073895746700367L;
    private long id;
    private String uniqueKey;
    private String serverHost;
    private String serverIp;
    private String clientHost;
    private String clientIp;
    private String os;
    private String browser;
    private String creatTime;
    private String executeTime;


    public void init(HttpServletRequest request) {
        this.serverHost = request.getHeader("Host");
        this.serverIp = request.getServerName();
        this.clientIp = RequestUtils.getIpAddr(request);
        this.clientHost = request.getRemoteHost();
        this.os = RequestUtils.getOsInfo(request);
        this.browser = RequestUtils.getBrowserInfo(request);
        this.creatTime = DateUtils.convertDateToStr(new Date());

    }

    public CounterRecord(){}
    public CounterRecord(HttpServletRequest request) {
        init(request);

    }

    public CounterRecord(long id, String uniqueKey, String serverHost, String serverIp, String clientHost, String clientIp, String os, String browser, String creatTime, String executeTime) {
        this.id = id;
        this.uniqueKey = uniqueKey;
        this.serverHost = serverHost;
        this.serverIp = serverIp;
        this.clientHost = clientHost;
        this.clientIp = clientIp;
        this.os = os;
        this.browser = browser;
        this.creatTime = creatTime;
        this.executeTime = executeTime;
    }

    public CounterRecord(String uniqueKey, String serverHost, String serverIp, String clientHost, String clientIp, String os, String browser, String creatTime, String executeTime) {
        this.uniqueKey = uniqueKey;
        this.serverHost = serverHost;
        this.serverIp = serverIp;
        this.clientHost = clientHost;
        this.clientIp = clientIp;
        this.os = os;
        this.browser = browser;
        this.creatTime = creatTime;
        this.executeTime = executeTime;
    }

    public CounterRecord(String serverHost, String serverIp, String clientHost, String clientIp, String os, String browser, String creatTime, String executeTime) {
        this.serverHost = serverHost;
        this.serverIp = serverIp;
        this.clientHost = clientHost;
        this.clientIp = clientIp;
        this.os = os;
        this.browser = browser;
        this.creatTime = creatTime;
        this.executeTime = executeTime;
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

    public String getServerHost() {
        return serverHost;
    }

    public void setServerHost(String serverHost) {
        this.serverHost = serverHost;
    }

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public String getClientHost() {
        return clientHost;
    }

    public void setClientHost(String clientHost) {
        this.clientHost = clientHost;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
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

    public String getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime;
    }

    public String getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(String executeTime) {
        this.executeTime = executeTime;
    }

    @Override
    public String toString() {
        return "CounterRecord{" +
                "id=" + id +
                ", uniqueKey='" + uniqueKey + '\'' +
                ", serverHost='" + serverHost + '\'' +
                ", serverIp='" + serverIp + '\'' +
                ", clientHost='" + clientHost + '\'' +
                ", clientIp='" + clientIp + '\'' +
                ", os='" + os + '\'' +
                ", browser='" + browser + '\'' +
                ", creatTime=" + creatTime +
                ", executeTime=" + executeTime +
                '}';
    }
}
