package tourism.backstage.controller;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tourism.backstage.entity.SysLog;
import tourism.backstage.service.SysLogService;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * 用于记录日志的工具类，他里面提供了公共的代码
 * 注意：
 * 如果使用注解配置AOP就使用环绕通知
 * 其他的通知有执行顺序的问题（不建议使用）
 *
 * @author 孙启新
 * @Aspect ：表示当前类是一个切面类
 */
@Component
@Aspect
public class LogAop {
    /**
     * 开始时间
     */
    private Date visitTime;
    /**
     * 访问的类
     */
    private Class clazz;
    /**
     * 访问的方法
     */
    private Method method;
    /**
     * 访问的方法名称
     */
    private String methodName;
    /**
     * 方法执行时间
     */
    private Long time;
    /**
     * URL
     */
    private String url;
    /**
     * IP地址
     */
    private String ip;
    /**
     * 用户名
     */
    private String username;

    /**
     * 配置切入点表达式
     */
    @Pointcut("execution(* tourism.backstage.controller.*.*(..))")
    public void pt1() {
    }

    /**
     * 获取request域对象
     */
    private HttpServletRequest request;

    @Autowired
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    /**
     * 获取SysLogServiced对象
     */
    private SysLogService sysLogService;

    @Autowired
    public void setSysLogService(SysLogService sysLogService) {
        this.sysLogService = sysLogService;
    }

    /**
     * 配置环绕通知获取数据
     *
     * @param pjp
     * @return
     */
    @Around("pt1()")
    public Object aroundPrintLog(ProceedingJoinPoint pjp) {
        Object proceed = null;
        try {
            //得到方法执行所需的参数
            Object[] args = pjp.getArgs();

            //1、前置通知,获取开始时间，执行的类，访问的方法
            //1.1、当前时间就是方法开始执行的事件
            visitTime = new Date();
            //1.2、当前访问的类
            clazz = pjp.getTarget().getClass();
            //1.3、获取执行方法的method对象
            methodName = pjp.getSignature().getName();
            // 有参数，就找出所有方法遍历，找到当前执行的那个方法
            Method[] methods = clazz.getMethods();
            for (Method method1 : methods) {
                if (method1.getName() == methodName) {
                    method = method1;
                }
            }


            //调用业务层方法（切入点方法）
            proceed = pjp.proceed(args);

            //2、后置通知，获取访问时长，获取URL，IP地址
            time = System.currentTimeMillis() - visitTime.getTime();

            //获取URL
            if (clazz != null && method != null && clazz != LogAop.class) {
                //1.获取类上的@RequestMapping("/orders")
                RequestMapping classAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
                if (classAnnotation != null) {
                    String[] classValue = classAnnotation.value();
                    //2.获取方法上的@GetMapping(xxx)或者PostMapping(xxx)
                    GetMapping methodAnnotationGet = method.getAnnotation(GetMapping.class);
                    PostMapping methodAnnotationPost = method.getAnnotation(PostMapping.class);
                    if (methodAnnotationGet != null) {
                        String[] methodValueGet = methodAnnotationGet.value();
                        url = classValue[0] + "/" + methodValueGet[0];
                    }
                    if (methodAnnotationPost != null) {
                        String[] methodValuePost = methodAnnotationPost.value();
                        url = classValue[0] + "/" + methodValuePost[0];
                    }
                }
            }

            //获取IP地址
            ip = request.getRemoteAddr();

            //获取当前操作的用户
            //1、从上下文获取当前登录的用户,可以通过securityContext获取，也可以从request.getSession中获取
            SecurityContext context = SecurityContextHolder.getContext();
            /*User user = (User) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");*/

            //Spring security里的User类
            User user = (User) context.getAuthentication().getPrincipal();
            username = user.getUsername();

            return proceed;
        } catch (Throwable throwable) {
            //异常通知
            throwable.printStackTrace();
            throw new RuntimeException(throwable);
        } finally {
            //最终通知,将日志信息封装到SysLog类中,对日志的操作不保存到数据库
            if ("findAllSysLog".equals(methodName) || "deleteSysLogById".equals(methodName)) {

            }else {
                SysLog sysLog = new SysLog();
                sysLog.setIp(ip);
                sysLog.setExecutionTime(time);
                sysLog.setMethod("[类] " + clazz.getName().substring(18) + " [方法] " + methodName);
                sysLog.setVisitTime(visitTime);
                sysLog.setUrl(url);
                sysLog.setUsername(username);

                //将日志信息保存到数据库
                sysLogService.saveSyslog(sysLog);
            }
        }
    }
}
