package code.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

//	@Before("execution(* code.services.CustomerServiceImpl.getCustomers())")
	@Before("execution(* getCustomers(..))") //any getCustomers at any class
//	@Before("execution(* get* ())") //any get at any class
	public void beforeGetCustomersAdvice(JoinPoint joinPoint) {
		System.out.println("@Before " + 
							joinPoint.getSignature().getDeclaringType().getName() +"."+ joinPoint.getSignature().getName());
	}
	
	@After("execution(* code.services.CustomerServiceImpl.getCustomers())")
	public void afterGetCustomersAdvice(JoinPoint joinPoint) {
		System.out.println("@After " + 
				joinPoint.getSignature().getDeclaringType().getName() +"."+ joinPoint.getSignature().getName());
	}
	
	/*
	 * @Around ("execution(* code.services.CustomerServiceImpl.getCustomers())")
	 * public void aroundGetCustomersAdvice() {
	 * System.out.println("\n=====>>> Executing @@After advice on getCustomers()");
	 * }
	 */
}










