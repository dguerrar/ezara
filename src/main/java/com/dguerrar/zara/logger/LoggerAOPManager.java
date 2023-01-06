package com.dguerrar.zara.logger;

import com.dguerrar.zara.generic.GenericModule;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;


@Aspect
@Component
public class LoggerAOPManager extends GenericModule {


    @Around("execution(* com.dguerrar.zara.controllers..*(..)))")
    public Object logMethodExecutionControllers(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

        Object result = proceedingJoinPoint.proceed();

        log.info("Execution of "
                + methodSignature.getDeclaringType().getSimpleName() // Class Name
                + "." + methodSignature.getName() + " " // Method Name
                +    methodSignature.getParameterNames());

        return result;
    }

    @Around("execution(* com.dguerrar.zara.managers..*(..)))")
    public Object logMethodExecutionTimeManagers(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

        final StopWatch stopWatch = new StopWatch();

        //calculate method execution time
        stopWatch.start();
        Object result = proceedingJoinPoint.proceed();
        stopWatch.stop();

        //Log method execution time
        log.info("Execution time of "
                + methodSignature.getDeclaringType().getSimpleName() // Class Name
                + "." + methodSignature.getName() + " " // Method Name
                + ":: " + stopWatch.getTotalTimeMillis() + " ms");

        return result;
    }

    @Override
    protected Class<?> getLogClass() {
        return LoggerAOPManager.class;
    }
}
