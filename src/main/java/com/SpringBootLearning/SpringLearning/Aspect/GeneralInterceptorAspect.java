package com.SpringBootLearning.SpringLearning.Aspect;


import com.SpringBootLearning.SpringLearning.Entity.Book;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;


@Aspect
@Slf4j
@Component
public class GeneralInterceptorAspect {


    //first * mens any return type
    //second * mens any class inside this package
    //third * mens any method
    //third (.) mens any zero arg method
    //third (. .) mens any zero or more arg method
    //@Pointcut("execution(* com.SpringBootLearning.SpringLearning.Controler.*.*(..))")
   // @Pointcut("within(com.SpringBootLearning.SpringLearning.Controler.*)")       // It will check within the Controller
    @Pointcut("this(com.SpringBootLearning.SpringLearning.Controler.BooksControler)")   // It will check only BooksControler controller
    public void loggingPointCut(){}

    @Before("loggingPointCut()")            // It will execute before api method execution
    public void beforeCall(JoinPoint joinPoint){
        log.info("Before beforeCall method called ::"+joinPoint.getSignature());
        // o/t : Before beforeCall method called ::List com.SpringBootLearning.SpringLearning.Controler.BooksControler.getBookList()
    }

    @After("loggingPointCut()")            // It will execute after api method execution
    public void afterCall(JoinPoint joinPoint){
        log.info("Before afterCall method called ::"+joinPoint.getSignature());
    }

    @AfterReturning(value = "execution(* com.SpringBootLearning.SpringLearning.Controler.*.*(..))", returning = "books")
    public void afterReturningMethodCall(JoinPoint joinPoint , java.util.List<Book> books){
        log.info("afterReturningMethodCall method called ::"+books);
        // O/T : afterReturningMethodCall method called ::[Book{id=1, title='Java', author='Raju'}, Book{id=2, title='C++', author='Rahul kumar'}, Book{id=3, title='JavaScript', author='Rockey Kumar'}, Book{id=4, title='Python', author='Raja'}]
    }

    //Similler we can use Afterthrowing


    @Around("loggingPointCut()")            // It will execute before/after api method execution
    public Object aroudMethodCalled(ProceedingJoinPoint joinPoint) throws Throwable{
        log.info("aroudMethodCalled before method called ::"+joinPoint.getSignature());  // O/T : aroudMethodCalled before method called ::List com.SpringBootLearning.SpringLearning.Controler.BooksControler.getBookList()  (It will execute before returning )
        Object object = joinPoint.proceed();
        log.info("aroudMethodCalled after method called ::"+object);   // O/T : aroudMethodCalled after method called ::[Book{id=1, title='Java', author='Raju'}, Book{id=2, title='C++', author='Rahul kumar'}, Book{id=3, title='JavaScript', author='Rockey Kumar'}, Book{id=4, title='Python', author='Raja'}] (It will call after returning )
        return object;
    }

}


















