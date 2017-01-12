package com.catban.common.form.constraints;

import com.catban.common.form.constraints.impl.RemoteValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by hgh on 17/1/6.
 *  请求服务端验证de注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint( validatedBy = {RemoteValidator.class})
public @interface Remote {

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    String message();

    /**
     * 验证方法所在的类
     * */
    Class<?>  checkClass();

    /**
     * 远程验证的方法名
     * */
    String checkMethod();

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        Remote[] value();
    }


}
