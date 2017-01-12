package myanno;

import java.lang.reflect.Method;

/**
 * Created by catban on 16-12-11.
 */
public class ReflecrProcessor {
    public void parseMethod(final Class<?> clazz) throws Exception{
        final Object obj = clazz.getConstructor(new Class[]{}).newInstance(new Object[] {});
        final Method[] methods = clazz.getDeclaredMethods();
        for(final Method method:methods){
          Reflect reflect =  method.getAnnotation(Reflect.class);
            if (null!= reflect){
                method.invoke(obj,reflect.name());
            }
        }


    }
}
