package com.ccg.lab.Utils;

import jakarta.annotation.Priority;
import jakarta.enterprise.context.Dependent;
import jakarta.interceptor.Interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import java.io.Serializable;
import java.util.Arrays;

@Interceptor
@CustomInterceptorBinding
@Dependent
public class Logger implements Serializable {
    @AroundInvoke
    public Object logDocument(InvocationContext context) throws Exception {
        System.out.println("%%%%%%" + Arrays.toString(context.getParameters()));
        return context.proceed();
    }
}
