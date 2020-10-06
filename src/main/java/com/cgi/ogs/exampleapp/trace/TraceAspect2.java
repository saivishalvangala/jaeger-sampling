/*******************************************************************************
 * © 2020 CGI OpenGrid360. All rights are reserved.
 ******************************************************************************/
package com.cgi.ogs.exampleapp.trace;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.opentracing.Span;
import io.opentracing.Tracer;

/**
 * The Class TraceAspect.
 *
 * this class create the spans in tracer for each request of API and enable the
 * tracing
 *
 * @author saivishal.vangala
 *
 */
@Aspect
@Component
public class TraceAspect2
{
    /** The application name. */
    private final String applicationName;

    /** The tracer. */
    @Autowired
    private Tracer tracer;

    /**
     * Instantiates a new trace aspect.
     *
     * @param applicationName
     *            the application name
     */
    public TraceAspect2(@Value("${application.name:NULL}") final String applicationName)
    {
        this.applicationName = applicationName;
    }

    /**
     * Around-creates the span for each method where @TraceIt annotation is
     * placed to trace that method functionality.
     *
     * @param joinPoint
     *            the join point
     * @return the object
     * @throws Throwable
     *             the throwable
     */
    @Around("@annotation(com.cgi.ogs.exampleapp.trace.TraceIt)")
    public Object around(final ProceedingJoinPoint joinPoint) throws Throwable
    {
        Object value = null;
        final Span span = tracer.buildSpan("example" + ":Tracer").start();
        try
        {
            span.setOperationName("example");
            span.setTag("TrcaerEnabled", 200);
            span.setTag("Method",
                    joinPoint.getSignature().getDeclaringType().getName() + "." + joinPoint.getSignature().getName());
            value = joinPoint.proceed();
        }
        catch (final Exception e)
        {
            span.setTag("Error", e.getMessage());
            throw e;
        }
        finally
        {
            span.finish();
        }
        return value;
    }

}
