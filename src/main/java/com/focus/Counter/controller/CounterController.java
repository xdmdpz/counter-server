package com.focus.Counter.controller;

import com.focus.Counter.entity.CounterRecord;
import com.focus.Counter.entity.RestResponse;
import com.focus.Counter.service.CounterRecordService;
import com.focus.Counter.utils.MD5Utils;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by if on 2017/6/27.
 */
@RequestMapping("api")
@RestController
public class CounterController {

    private static Logger logger = Logger.getLogger(CounterRecordController.class);

    @Resource
    private CounterRecordService _counterRecordService;


    /**
     *
     * 添加浏览记录
     *
     * @param record 主要用于接受UniqueKey 仅支持接受json字符串
     * @param request http请求信息
     * @param rp 封装的请求返回对象
     * @return RestResponse
     */
    @ResponseBody
    @PostMapping("counter")
    public RestResponse counter(@RequestBody CounterRecord record, HttpServletRequest request, RestResponse rp){
        if(record.getUniqueKey().equals(MD5Utils.MD5(request.getRemoteHost()))) {
            record.init(request);
            if(_counterRecordService.insert(record))
                rp.SuccessReply("记录成功");
            else
                rp.SuccessReply("记录失败");
        }else
            rp.SuccessReply("非法请求");
        return rp;
    }

    /**
     * 获得js 在js中插入UniqueKey
     * @param request http请求信息
     * @param rp 封装的请求返回对象
     * @return 压缩后的js
     */
    @ResponseBody
    @GetMapping
    public String get(HttpServletRequest request,RestResponse rp){
        String serverName = request.getServerName();
        String serverPort = request.getServerPort()+"";
        String uniqueKey = MD5Utils.MD5(request.getRemoteHost());
        String js = "function request(method,url,data,cb_success,cb_fail){if(!url){throw new Error(\"the url argument is request, please check your code.\")}method=(method||\"POST\").toString().toUpperCase();cb_success=cb_success||function(){};cb_fail=cb_fail||function(){};var xmlObj=CreateXMLHttpRequest();xmlObj.onreadystatechange=function(){console.log(xmlObj.readyState);if(xmlObj.readyState===4){if(xmlObj.status===200||xmlObj.status===304){cb_success(xmlObj.responseText)}else{cb_fail(xmlObj.status,xmlObj.statusText)}}};xmlObj.open(method,url,true);var req=JSON.stringify(data);if(method===\"POST\"){xmlObj.setRequestHeader(\"Content-type\",\"application/json\")}xmlObj.send(req)}function CreateXMLHttpRequest(){var xmlObj;if(window.ActiveXObject){try{xmlObj=new ActiveXObject(\"Msxml2.XMLHTTP\")}catch(e){try{xmlObj=new ActiveXObject(\"Microsoft.XMLHTTP\")}catch(E){throwErrorWhenInitXMLObjectError()}}}else{if(window.XMLHttpRequest){xmlObj=new XMLHttpRequest()}else{throwErrorWhenInitXMLObjectError()}}return xmlObj}function throwErrorWhenInitXMLObjectError(){throw new Error(\"you browser does not support async request.\")}request(\"POST\",\"http://";
        StringBuffer sb  =new StringBuffer();
        sb.append(js).append(serverName).append(":").append(serverPort).append("/api/counter\",{'uniqueKey':'").append(uniqueKey).append("'},function(data){console.log(data)});");

        return sb.toString();
    }
    @ResponseBody
    @RequestMapping("show")
    public List showRecord(){
        return _counterRecordService.getcounterRecordByFilters(null);
    }

}
