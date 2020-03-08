package code.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	@Before("execution(* code.services.CustomerServiceImpl.getCustomers())")
	public void beforeGetCustomersAdvice() {
		System.out.println("\n=====>>> Executing @Before advice on getCustomers()");
	}
	
	@After("execution(* code.services.CustomerServiceImpl.getCustomers())")
	public void afterGetCustomersAdvice() {
		System.out.println("\n=====>>> Executing @@After advice on getCustomers()");
	}
}










