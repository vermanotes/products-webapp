package org.productapp.interceptor.tagcloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

public class TagCloudInterceptor extends HandlerInterceptorAdapter {

    private Logger logger = LoggerFactory.getLogger(TagCloudInterceptor.class);

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {


        if (request.getHeader("Accept").contains(MediaType.TEXT_HTML_VALUE)) {
            List<String> productList = Arrays.asList("Cars", "Bikes", "Quad Bikes");
            modelAndView.addObject("tagCloud", productList);
            logger.debug("TAG CLOUD INTERCEPTOR ADDED: " + productList.toString());
        }
    }

}
