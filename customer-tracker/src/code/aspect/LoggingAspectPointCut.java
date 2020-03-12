package code.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspectPointCut {

	@Pointcut("execution(* getCustomers(..))") //any getCustomers at any class
	private void beforeAny() {}
	
	@Before("beforeAny()") //any getCustomers at any class
	public void beforeGetCustomersAdvice(JoinPoint joinPoint) {
		System.out.println("@Before PointCut " + 
							joinPoint.getSignature().getDeclaringType().getName() +"."+ joinPoint.getSignature().getName());
	}
}










