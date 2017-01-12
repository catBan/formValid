package com.catban.common.form.constraints.impl;

import com.catban.common.form.constraints.Remote;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.reflect.ConstructorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by hgh on 17/1/6.
 *
 */
public class RemoteValidator implements ConstraintValidator<Remote,Object> {

    private Remote remote;
    private static Logger log = LoggerFactory.getLogger(RemoteValidator.class);

    public void initialize(Remote remote) {
        this.remote = remote;
    }

    public boolean isValid(Object object, ConstraintValidatorContext context) {
        if(null == object)
            return true;
        HttpServletRequest request = getRequest();
        Object[] params = getParamsOfMethod(request);
        try {
            Object o = ConstructorUtils.invokeConstructor(remote.checkClass(),null);
            Object result = getMethod().invoke(o,params);
            if (result instanceof Boolean){
                return (Boolean) result;
            }
            if(result instanceof String){
                return "true".equals(String.valueOf(result));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    private  Object[] getParamsOfMethod(HttpServletRequest request) {
        Object[] params = null;
        Method method = getMethod();
        if (null == method){
            log.error("找不到类{0}中的名为{1}，且返回类型为boolean或string，参数为request或者使用类注解RequestParam的方法！");
            throw new RuntimeException();
        }
        int length = method.getParameterTypes().length;
        params = new Object[length];
        for (int i = 0; i < length; i++) {
            if (method.getParameterTypes()[i] == HttpServletRequest.class) {
                params[i] = request;
            } else {
                String paramName = getAnnoParamsOfMethod(method).get(i);
                params[i] = request.getParameter(paramName);
            }
        }

        return params;
    }
    private Method getMethod(){
        Method[] methods = remote.checkClass().getDeclaredMethods();
        for (Method method:methods){
            Class<?> returnType = method.getReturnType();
            if(StringUtils.equals(remote.checkMethod(), method.getName()) && (returnType == Boolean.class || returnType ==boolean.class)){
               return method;
            }
        }
        return  null;
    }

    /**
     * 获取@RequestParam注解的参数名
     * */
    private Map<Integer,String> getAnnoParamsOfMethod(Method method) {
        Map<Integer,String> paramMap = new HashMap<Integer,String>();
        Annotation[][] paramAnnotations =  method.getParameterAnnotations();
        for(int i =0;i<paramAnnotations.length;i++){
            Annotation[] paramAnno = paramAnnotations[i];
            if(paramAnno.length>0){
                if(paramAnno[0] instanceof RequestParam){
                    paramMap.put(i,((RequestParam) paramAnno[0]).value());
                }
            }
        }
        return paramMap;
    }

    private HttpServletRequest getRequest(){
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    }

}
