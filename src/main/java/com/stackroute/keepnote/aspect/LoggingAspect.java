package com.stackroute.keepnote.aspect;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/* Annotate this class with @Aspect and @Component */

@Aspect
@Component
public class LoggingAspect {
	private Log log = LogFactory.getLog(getClass());

	/*
	 * Write loggers for each of the methods of controller, any particular method
	 * will have all the four aspectJ annotation
	 * (@Before, @After, @AfterReturning, @AfterThrowing).
	 */
//	@Before("execution(com.stackroute.keepnote.controller.NoteController.*)")
//	public void logBefore(){
//		log.info("@Before:"+new Date());
//	}
//	
//	@After("execution(com.stackroute.keepnote.controller.*)")
//	public void logAfter(){
//		log.info("@After:"+new Date());
//	}
//	
//	@AfterThrowing(pointcut = "execution(com.stackroute.keepnote.controller.*)",
//			throwing="exception")
//	public void logAfterThrowing(Exception exception){
//		log.info("@AfterReturning:"+new Date());
//		//log.info("Exception caught:"+ exception.getMessage());
//	}
//	
//	@AfterReturning(pointcut = "execution(com.stackroute.keepnote.controller.*)",
//			returning="val")
//	public void logAfterReturning(Object val){
//		log.info("Method return value:"+ val);
//		//log.info("@AfterReturning:"+new Date());
//	}
//	
	@Before("execution(* com.stackroute.keepnote.controller.NoteController.*(..))")
	public void beforNoteAdvice(JoinPoint joinPoint) {
		log.info("before Note Advice called "+ joinPoint.getSignature().getName());
	}
	
	@After("execution(* com.stackroute.keepnote.controller.NoteController.*(..))")
	public void afterNoteLog(JoinPoint joinPoint) {
		log.info("calling after "+ joinPoint.getSignature().getName());
	}
	
	@AfterReturning("execution(* com.stackroute.keepnote.controller.NoteController.*(..))")
	public void afterReturningNote(JoinPoint joinPoint) {
		log.info("calling after returning "+ joinPoint.getSignature().getName());
	}
	
	@AfterThrowing("execution(* com.stackroute.keepnote.controller.NoteController.*(..))")
	public void AfterThrowingNote(JoinPoint joinPoint) {
		log.info("calling after throwing note "+ joinPoint.getSignature().getName());
	}
	
	@Before("execution(* com.stackroute.keepnote.controller.UserController.*(..))")
	public void beforUserAdvice(JoinPoint joinPoint) {
		log.info("before Note Advice called "+ joinPoint.getSignature().getName());
	}
	
	@After("execution(* com.stackroute.keepnote.controller.UserController.*(..))")
	public void afterUserLog1(JoinPoint joinPoint) {
		log.info("calling after "+ joinPoint.getSignature().getName());
	}
	
	@AfterReturning("execution(* com.stackroute.keepnote.controller.UserController.*(..))")
	public void afterReturningUser(JoinPoint joinPoint) {
		log.info("calling after returning "+ joinPoint.getSignature().getName());
	}
	
	@AfterThrowing("execution(* com.stackroute.keepnote.controller.UserController.*(..))")
	public void AfterThrowingUser(JoinPoint joinPoint) {
		log.info("calling after throwing note "+ joinPoint.getSignature().getName());
	}
	
	@Before("execution(* com.stackroute.keepnote.controller.ReminderController.*(..))")
	public void beforReminderAdvice(JoinPoint joinPoint) {
		log.info("before Note Advice called "+ joinPoint.getSignature().getName());
	}
	
	@After("execution(* com.stackroute.keepnote.controller.ReminderController.*(..))")
	public void afterReminderLog(JoinPoint joinPoint) {
		log.info("calling after "+ joinPoint.getSignature().getName());
	}
	
	@AfterReturning("execution(* com.stackroute.keepnote.controller.ReminderController.*(..))")
	public void afterReturningReminder(JoinPoint joinPoint) {
		log.info("calling after returning "+ joinPoint.getSignature().getName());
	}
	
	@AfterThrowing("execution(* com.stackroute.keepnote.controller.ReminderController.*(..))")
	public void AfterThrowingReminder(JoinPoint joinPoint) {
		log.info("calling after throwing note "+ joinPoint.getSignature().getName());
	}
	
	@Before("execution(* com.stackroute.keepnote.controller.CategoryController.*(..))")
	public void beforCategoryAdvice(JoinPoint joinPoint) {
		log.info("before Note Advice called "+ joinPoint.getSignature().getName());
	}
	
	@After("execution(* com.stackroute.keepnote.controller.CategoryController.*(..))")
	public void afterCategoryLog(JoinPoint joinPoint) {
		log.info("calling after "+ joinPoint.getSignature().getName());
	}
	
	@AfterReturning("execution(* com.stackroute.keepnote.controller.CategoryController.*(..))")
	public void afterReturningCategory(JoinPoint joinPoint) {
		log.info("calling after returning "+ joinPoint.getSignature().getName());
	}
	
	@AfterThrowing("execution(* com.stackroute.keepnote.controller.CategoryController.*(..))")
	public void AfterThrowingCategory(JoinPoint joinPoint) {
		log.info("calling after throwing note "+ joinPoint.getSignature().getName());
	}
	
	@Before("execution(* com.stackroute.keepnote.controller.UserAuthenticationController.*(..))")
	public void beforUserAuthAdvice(JoinPoint joinPoint) {
		log.info("before Note Advice called "+ joinPoint.getSignature().getName());
	}
	
	@After("execution(* com.stackroute.keepnote.controller.UserAuthenticationController.*(..))")
	public void afterUserAuthLog(JoinPoint joinPoint) {
		log.info("calling after "+ joinPoint.getSignature().getName());
	}
	
	@AfterReturning("execution(* com.stackroute.keepnote.controller.UserAuthenticationController.*(..))")
	public void afterReturningUserAuth(JoinPoint joinPoint) {
		log.info("calling after returning "+ joinPoint.getSignature().getName());
	}
	
	@AfterThrowing("execution(* com.stackroute.keepnote.controller.UserAuthenticationController.*(..))")
	public void AfterThrowingUserAuth(JoinPoint joinPoint) {
		log.info("calling after throwing note "+ joinPoint.getSignature().getName());
	}
}