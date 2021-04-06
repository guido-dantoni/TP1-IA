package caperucita;
import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class CaperucitaPerception extends Perception{
	
	 public static int ARBOL_PERCEPTION = 1;
	 public static int EMPTY_PERCEPTION = 0;
	 public static int FOOD_PERCEPTION = 2;
	 public static int ENEMY_PERCEPTION = 3;
	 
	 private int leftSensor;
	 private int topSensor;
	 private int rightSensor;
	 private int bottomSensor;
	 private int lifes;

	 public CaperucitaPerception() {
		 lifes = 3;
	 }
	 
	 /*public PacmanPerception(Agent agent, Environment environment) {
	        super(agent, environment);
	 }*/
	 
	@Override
	public void initPerception(Agent agent, Environment environment) {
		// TODO Auto-generated method stub
		
	}

}
