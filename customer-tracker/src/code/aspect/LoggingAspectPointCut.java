package code.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspectPointCut {

	@Pointcut("execution(* getCustomers(..))")
	private void beforeAnyGetCustomers() {}
	
	@Pointcut("execution(* code.services.CustomerServiceImpl.getCustomers())")
	private void beforeServiceGetCustomers() {}
	
	@Before("beforeAnyGetCustomers() && !beforeServiceGetCustomers()")
	public void beforeGetCustomersAdvice(JoinPoint joinPoint) {
		System.out.println("@Before PointCut" + 
							joinPoint.getSignature().getDeclaringType().getName() +"."+ joinPoint.getSignature().getName());
	}
}










