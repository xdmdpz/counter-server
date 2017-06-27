package com.focus.Counter.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by if on 2017/6/27.
 */
@Service
public class RequestService {
    public String getIpAddr(HttpServletRequest request)
    {
        String ip = request.getHeader("X-Real-IP");
        if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip))
        {
            return ip;
        }
        ip = request.getHeader("X-Forwarded-For");
        if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip))
        {
            // 多次反向代理后会有多个IP值，第一个为真实IP。
            int index = ip.indexOf(',');
            if (index != -1)
            {
                return ip.substring(0, index);
            }
            else
            {
                return ip;
            }
        }
        else
        {
            return request.getRemoteAddr();
        }
    }

    /**
     * 获得请求方式
     * @param request
     * @return
     */
    public String getMethod(HttpServletRequest request)
    {
        return request.getMethod();
    }
    /**
     * 获得当的访问路径
     *
     * HttpServletRequest.getRequestURL+"?"+HttpServletRequest.getQueryString
     *
     * @param request
     * @return
     */
    public String getLocation(HttpServletRequest request)
    {
        UrlPathHelper helper = new UrlPathHelper();
        StringBuffer buff = request.getRequestURL();
        String uri = request.getRequestURI();
        String origUri = helper.getOriginatingRequestUri(request);
        buff.replace(buff.length() - uri.length(), buff.length(), origUri);
        String queryString = helper.getOriginatingQueryString(request);
        if (queryString != null)
        {
            buff.append("?").append(queryString);
        }
        return buff.toString();
    }
    public  String getRemoteHost(HttpServletRequest request){
        return request.getRemoteHost();
    }
}
