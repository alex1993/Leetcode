package jvm;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;

/**
 * Script Created by daidai on 2017/8/2.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(METHOD)
public @interface RequiredRoles {
    String[] value();
}
