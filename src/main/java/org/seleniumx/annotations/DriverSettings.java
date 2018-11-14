package org.seleniumx.annotations;

import org.seleniumx.util.Set;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface DriverSettings {

    Set.OS OS() default Set.OS.LINUX;

    Set.WINDOW_SIZE WINDOW_SIZE() default Set.WINDOW_SIZE.DEFAULT;

    String BASE_URL() default "https://www.seleniumx.com/";

    int IMPLICIT_WAIT() default 0;
}
