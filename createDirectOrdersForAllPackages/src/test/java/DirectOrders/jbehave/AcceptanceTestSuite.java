package DirectOrders.jbehave;

import DirectOrders.utils.WebDriverConfigurer;
import net.thucydides.jbehave.ThucydidesJUnitStories;

public class AcceptanceTestSuite extends ThucydidesJUnitStories {
	
	public AcceptanceTestSuite() {
		
	WebDriverConfigurer.configureDrivers();
	
	}
}
