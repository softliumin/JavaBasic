package cc.sharper.superReflect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by liumin3 on 2016/1/4.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Signature
{
    Class<?> type();
    String method();
    Class<?>[] args();
}
