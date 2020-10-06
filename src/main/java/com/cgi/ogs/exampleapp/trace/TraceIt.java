
package com.cgi.ogs.exampleapp.trace;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The Interface TraceIt- This annotation should be placed on the methods to
 * trace those methods.
 *
 * This traceIt annotation is used to enable tracing for each method of
 * controller in API.
 *
 * @author saivishal.vangala
 *
 */
@Target(
{ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface TraceIt
{

}
