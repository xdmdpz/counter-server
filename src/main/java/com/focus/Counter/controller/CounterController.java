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
     *
     * @param uniqueKey 进接受通过get获取到js的请求
     * @param request http请求信息
     * @param rp 封装的请求返回对象
     * @return RestResponse
     */
    @ResponseBody
    @PostMapping("counter")
    public RestResponse counter(String uniqueKey, HttpServletRequest request, RestResponse rp){
        if(uniqueKey.equals(MD5Utils.MD5(request.getRemoteHost()))) {
            CounterRecord record = new CounterRecord(request);
            record.setUniqueKey(uniqueKey);
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
     * @return 压缩后的js
     */
    @ResponseBody
    @GetMapping
    public String get(HttpServletRequest request){
        String serverName = request.getServerName();
        String serverPort = request.getServerPort()+"";
        String uniqueKey = MD5Utils.MD5(request.getRemoteHost());
        StringBuffer sb  =new StringBuffer();
        sb.append("$.ajax({type:\"POST\",url:\"http://").append(serverName).append(":").append(serverPort).append("/api/counter").append("\",data:{uniqueKey:'").append(uniqueKey).append("'},dataType:\"json\",success:function(data){console.log(data);}})");

        return sb.toString();
    }

}
