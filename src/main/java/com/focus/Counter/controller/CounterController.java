package com.focus.Counter.controller;

import com.focus.Counter.common.entity.RestResponse;
import com.focus.Counter.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by if on 2017/6/27.
 */
@RequestMapping("api")
@RestController
public class CounterController {

    @Autowired
    private RequestService requestService;
    @ResponseBody
    @RequestMapping("counter")
    public List counter(@RequestBody String userId , HttpServletRequest request, RestResponse rp){
        List<String> list = new ArrayList<>();
        String agent = request.getHeader("user-agent");
        list.add(userId);
        list.add(agent);
        StringTokenizer st = new StringTokenizer(agent,";");
        st.nextToken();
        String userbrowser = st.nextToken();
        list.add(userbrowser);
//        String useros = st.nextToken();

//        list.add(useros);
        list.add(System.getProperty("os.name")); //win2003竟然是win xp？
        list.add(System.getProperty("os.version"));
        list.add(System.getProperty("os.arch"));
        list.add(request.getHeader("user-agent")); //返回客户端浏览器的版本号、类型
        list.add(request.getMethod()); //：获得客户端向服务器端传送数据的方法有get、post、put等类型
        list.add(request.getRequestURI()); //：获得发出请求字符串的客户端地址
        list.add(request.getServletPath()); //：获得客户端所请求的脚本文件的文件路径
        list.add(request.getServerName()); //：获得服务器的名字
        list.add(request.getServerPort()+""); //：获得服务器的端口号
        list.add(request.getRemoteAddr()); //：获得客户端的ip地址
        list.add(request.getRemoteHost()); //：获得客户端电脑的名字，若失败，则返回客户端电脑的ip地址
        list.add(request.getProtocol()); //：
        list.add(request.getHeaderNames()+""); //：返回所有request header的名字，结果集是一个enumeration（枚举）类的实例
        list.add("Protocol: " + request.getProtocol());
        list.add("Scheme: " + request.getScheme());
        list.add("Server Name: " + request.getServerName() );
        list.add("Server Port: " + request.getServerPort());
        list.add("Protocol: " + request.getProtocol());
        list.add("Remote Addr: " + request.getRemoteAddr());
        list.add("Remote Host: " + request.getRemoteHost());
        list.add("Character Encoding: " + request.getCharacterEncoding());
        list.add("Content Length: " + request.getContentLength());
        list.add("Content Type: "+ request.getContentType());
        list.add("Auth Type: " + request.getAuthType());
        list.add("HTTP Method: " + request.getMethod());
        list.add("Path Info: " + request.getPathInfo());
        list.add("Path Trans: " + request.getPathTranslated());
        list.add("Query String: " + request.getQueryString());
        list.add("Remote User: " + request.getRemoteUser());
        list.add("Session Id: " + request.getRequestedSessionId());
        list.add("Request URI: " + request.getRequestURI());
        list.add("Servlet Path: " + request.getServletPath());
        list.add("Accept: " + request.getHeader("Accept"));
        list.add("Host: " + request.getHeader("Host"));
        list.add("Referer : " + request.getHeader("Referer"));
        list.add("Accept-Language : " + request.getHeader("Accept-Language"));
        list.add("Accept-Encoding : " + request.getHeader("Accept-Encoding"));
        list.add("User-Agent : " + request.getHeader("User-Agent"));
        list.add("Connection : " + request.getHeader("Connection"));
        list.add("Cookie : " + request.getHeader("Cookie"));


        return list;
    }
    @ResponseBody
    @GetMapping
    public String get(String userId , HttpServletRequest request,RestResponse rp){
        return "function request(method,url,data,cb_success,cb_fail){if(!url){throw new Error(\"the url argument is request, please check your code.\")}method=(method||\"POST\").toString().toUpperCase();cb_success=cb_success||function(){};cb_fail=cb_fail||function(){};var xmlObj=CreateXMLHttpRequest();xmlObj.onreadystatechange=function(){console.log(xmlObj.readyState);if(xmlObj.readyState===4){if(xmlObj.status===200||xmlObj.status===304){cb_success(xmlObj.responseText)}else{cb_fail(xmlObj.status,xmlObj.statusText)}}};xmlObj.open(method,url,true);var req=data;if(method===\"POST\"){xmlObj.setRequestHeader(\"Content-type\",\"application/json\");req=\"\";for(key in data){req+=key+\"=\"+data[key].toString()}}xmlObj.send(req)}function CreateXMLHttpRequest(){var xmlObj;if(window.ActiveXObject){try{xmlObj=new ActiveXObject(\"Msxml2.XMLHTTP\")}catch(e){try{xmlObj=new ActiveXObject(\"Microsoft.XMLHTTP\")}catch(E){throwErrorWhenInitXMLObjectError()}}}else{if(window.XMLHttpRequest){xmlObj=new XMLHttpRequest()}else{throwErrorWhenInitXMLObjectError()}}return xmlObj}function throwErrorWhenInitXMLObjectError(){throw new Error(\"you browser does not support async request.\")}request(\"POST\",\"http://" +
                request.getServerName()+":" + request.getServerPort()+"/api/counter\",{'userId':'"+userId+"'},function(data){console.log(data)});";
    }

}
