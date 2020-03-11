package code.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	@Before("execution(* code.services.CustomerServiceImpl.getCustomers())")
//	@Before("execution(* getCustomers())") any getCustomers at any class
//	@Before("execution(* get * ())") any get at any class
	public void beforeGetCustomersAdvice() {
		System.out.println("\n=====>>> Executing @Before advice on getCustomers()");
	}
	
	@After("execution(* code.services.CustomerServiceImpl.getCustomers())")
	public void afterGetCustomersAdvice() {
		System.out.println("\n=====>>> Executing @@After advice on getCustomers()");
	}
	
	/*
	 * @Around ("execution(* code.services.CustomerServiceImpl.getCustomers())")
	 * public void aroundGetCustomersAdvice() {
	 * System.out.println("\n=====>>> Executing @@After advice on getCustomers()");
	 * }
	 */
}










