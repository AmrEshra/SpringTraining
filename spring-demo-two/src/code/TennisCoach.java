package code;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("happyFortuneService")
	private FortuneService fortuneService;
	
//	public TennisCoach(FortuneService theFortuneService) {
//		fortuneService = theFortuneService;
//		System.out.println("Constructor");
//	}
		
//	@PostConstruct
//	public void postConstruct() {
//		System.out.println("@PostConstruct");
//	}

//	@PreDestroy
//	public void preDestroy() {
//		System.out.println("@PreDestroy");
//	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
