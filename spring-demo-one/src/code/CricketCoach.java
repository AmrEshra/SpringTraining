package code;

import org.springframework.beans.factory.annotation.Autowired;

public class CricketCoach implements Coach {
	
	@Autowired
	private FortuneService fortuneService;
	
	public FortuneService getFortuneService() {
		return fortuneService;
	}

	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	public CricketCoach() {
	}
	
	@Override
	public String getDailyWorkout() {
		return "Fast bowling for 15 minutes";
	}

	public CricketCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}








