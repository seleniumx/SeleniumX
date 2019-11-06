package org.seleniumx.annotations;

import org.openqa.selenium.Platform;
import org.seleniumx.util.Set;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface ServerSettings {

    Platform PLATFORM() default Platform.LINUX;

    Set.BROWSER BROWSER() default Set.BROWSER.CHROME;

    String VERSION() default "1.0";

    String SERVER_URL() default "http://localhost";

    String SERVER_PORT() default "4444";

    String BASE_URL() default "https://www.seleniumx.com/";

    int IMPLICIT_WAIT() default 0;
}
