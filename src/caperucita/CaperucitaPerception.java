package caperucita;
import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;


public class CaperucitaPerception extends Perception{
	
	 public static int ARBOL_PERCEPTION = 1;
	 public static int EMPTY_PERCEPTION = 0;
	 public static int FOOD_PERCEPTION = 2;
	 public static int ENEMY_PERCEPTION = 3;
	 public static int SALIDA = 4;
	 
	 private int[] leftSensor;
	 private int[] topSensor;
	 private int[] rightSensor;
	 private int[] bottomSensor;
	 /*private int lifes;

	 public CaperucitaPerception() {
		 lifes = 3;
	 }
	 */
	 public CaperucitaPerception(Agent agent, Environment environment) {
	        super(agent, environment);
	 }
	 
	public CaperucitaPerception() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initPerception(Agent agent, Environment environment) {
		Bosque caperucitaBosque = (Bosque) environment;
        CaperucitaEnvironmentState estadoAmbiente = (CaperucitaEnvironmentState) caperucitaBosque.getEnvironmentState();

        int row = estadoAmbiente.getAgentPosition()[0];
        int col = estadoAmbiente.getAgentPosition()[1];
        int[][] ambiente = estadoAmbiente.getWorld();

        this.setTopSensor(caperucitaBosque.getTopCol(row, col));
        this.setLeftSensor(caperucitaBosque.getLeftRow(row, col));
        this.setRightSensor(caperucitaBosque.getRightRow(row, col));
        this.setBottomSensor(caperucitaBosque.getBottomCol(row, col));
        
        //desplazamiento aleatorio del lobo en posicion vacia o donde esta caperucita
        int filaLobo=0;
        int columnaLobo=0;
        
        while(!(ambiente[filaLobo][columnaLobo] == CaperucitaPerception.EMPTY_PERCEPTION)){
        	
	        filaLobo = (int) (Math.random() * CaperucitaEnvironmentState.TAM -1);
	        columnaLobo = (int) (Math.random() * CaperucitaEnvironmentState.TAM -1);
        }
        
        estadoAmbiente.setWorld(estadoAmbiente.getWolfPosition()[0], estadoAmbiente.getWolfPosition()[1], CaperucitaPerception.EMPTY_PERCEPTION);
        estadoAmbiente.setWolfPosition(new int []{filaLobo, columnaLobo});
        
		
	}

	public int[] getLeftSensor() {
		return leftSensor;
	}

	public void setLeftSensor(int[] leftSensor) {
		this.leftSensor = leftSensor;
	}

	public int[] getTopSensor() {
		return topSensor;
	}

	public void setTopSensor(int[] topSensor) {
		this.topSensor = topSensor;
	}

	public int[] getRightSensor() {
		return rightSensor;
	}

	public void setRightSensor(int[] rightSensor) {
		this.rightSensor = rightSensor;
	}

	public int[] getBottomSensor() {
		return bottomSensor;
	}

	public void setBottomSensor(int[] bottomSensor) {
		this.bottomSensor = bottomSensor;
	}
	
   
    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();

        str.append("Left Sensor: " + this.leftSensor);
        str.append("; ");
        str.append("Up Sensor: " + this.topSensor);
        str.append("; ");
        str.append("Right Sensor: " + this.rightSensor);
        str.append("; ");
        str.append("Down Sensor: " + this.bottomSensor);

        return str.toString();
    }

}
