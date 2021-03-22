package com.example.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 枯萎花一朵
 * 创建时间：2018年12月26日,上午11:47:36
 * @Title: LoginInterceptor.java
 * @Package com.aaa.interceptor
 * @Description:登录拦截
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public void afterCompletion(HttpServletRequest arg0,
                                HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
                           Object arg2, ModelAndView arg3) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp,
                             Object obj) throws Exception {
        // TODO Auto-generated method stub
        System.out.println("在方法前调用");
        req.getSession().setAttribute("user", "users");
        Object user = req.getSession().getAttribute("user");
        if (user == null) {
            resp.sendRedirect("/dept/login");
            return false;
        }
        //false 不通过
        //true 通过
        return true;

    }

}
