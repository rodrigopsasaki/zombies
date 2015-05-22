package zombies.relogo

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;
import repast.simphony.relogo.Stop;
import repast.simphony.relogo.Utility;
import repast.simphony.relogo.UtilityG;
import repast.simphony.relogo.schedule.Go;
import repast.simphony.relogo.schedule.Setup;
import zombies.ReLogoObserver;

class UserObserver extends ReLogoObserver{

	@Setup
	def setup (){
		clearAll ()
		setDefaultShape ( Human , " person ")
		createHumans ( numHumans ){
			setxy ( randomXcor () , randomYcor ())
		}
		setDefaultShape ( Zombie , " zombie ")
		createZombies ( numZombies ){
			setxy ( randomXcor () , randomYcor ())
			size = 2
		}
	}

	@Go
	def go (){
		ask ( zombies ()){ step () }
		ask ( humans ()){ step () }
	}

	def remainingHumans (){
		count ( humans ())
	}
	
}