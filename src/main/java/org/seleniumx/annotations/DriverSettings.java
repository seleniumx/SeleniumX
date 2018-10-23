package org.seleniumx.annotations;

import org.seleniumx.start.DriverSet;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DriverSettings {
    DriverSet.OS OS() default DriverSet.OS.MAC;

    DriverSet.WINDOW_SIZE WINDOW_SIZE() default DriverSet.WINDOW_SIZE.MAXIMIZE;

    String BASE_URL() default "";

    int IMPLICIT_WAIT() default 0;
}
