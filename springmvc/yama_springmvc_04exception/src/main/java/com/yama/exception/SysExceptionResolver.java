package com.yama.exception;

import com.yama.exception.SysException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 异常处理器
 * springmvc异常处理机制
 *      当在服务层，dao层等类中出现异常时，一般不进行处理，而是将异常层层抛出，然后在表现层，前端控制器通过调用异常管理器组件进行处理
 *      目的是为了给用户提供一个比较友好的异常页面，而不是把后台的异常语句不经处理直接给用户
 * springmvc异常处理步骤
 *      自定义异常类--用于保存异常信息
 *      编写异常处理器，需要实现异常处理接口
 *      配置异常处理器--处理异常跳转到一个友好界面
 */
public class SysExceptionResolver implements HandlerExceptionResolver{

    /**
     * 处理异常业务逻辑
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @return
     */
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        // 获取到异常对象
        SysException e = null;
        if(ex instanceof SysException){
            e = (SysException)ex;
        }else{
            e = new SysException("系统正在维护....");
        }
        // 创建ModelAndView对象
        ModelAndView mv = new ModelAndView();
        mv.addObject("errorMsg",e.getMessage());//获取自定义异常类中提示信息
        mv.setViewName("error");
        return mv;
    }

}














