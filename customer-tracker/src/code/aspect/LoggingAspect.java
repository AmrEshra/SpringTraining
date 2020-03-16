package code.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import code.orm.Customer;

@Aspect
@Component
@Order(2)
public class LoggingAspect {

	@Before("execution(* code.services.CustomerServiceImpl.getCustomers())")
//	@Before("execution(* getCustomers(..))") //any getCustomers at any class
//	@Before("execution(* get* ())") //any get at any class
	public void beforeGetCustomersAdvice(JoinPoint joinPoint) {	
		System.out.println("@Before " + joinPoint.getSignature());
	}
	
	@AfterReturning
//	("execution(* code.services.CustomerServiceImpl.getCustomers())")
	(pointcut = "execution(* code.services.CustomerServiceImpl.getCustomers())", returning="result")
	public void afterReturningGetCustomersAdvice(JoinPoint joinPoint, List<Customer> result) {
		System.out.println("@AfterReturning " + joinPoint.getSignature());
		
		// you can change the data as you like after returning it
		System.out.println("@AfterReturning " + result);
	}
	
	@After("execution(* code.services.CustomerServiceImpl.getCustomers())")
	public void afterGetCustomersAdvice(JoinPoint joinPoint) {
		System.out.println("@After " + joinPoint.getSignature());
	}
}










