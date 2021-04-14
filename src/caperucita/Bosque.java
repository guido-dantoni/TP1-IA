package caperucita;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;




public class Bosque extends Environment{

	private int[] salida ;	
	
	
    public Bosque() {
        // Create the environment state
        this.environmentState = new CaperucitaEnvironmentState();
    }
    
    @Override
    public CaperucitaEnvironmentState getEnvironmentState() {
        return (CaperucitaEnvironmentState) super.getEnvironmentState();
    }
    
	@Override
	public Perception getPercept() {
        // Create a new perception to return
        CaperucitaPerception perception = new CaperucitaPerception();
        
        // Get the actual position of the agent to be able to create the
        // perception
        int row = this.getEnvironmentState().getAgentPosition()[0];
        int col = this.getEnvironmentState().getAgentPosition()[1];

        // Set the perception sensors
        perception.setTopSensor(this.getTopCol(row, col));
        perception.setLeftSensor(this.getLeftRow(row, col));
        perception.setRightSensor(this.getRightRow(row, col));
        perception.setBottomSensor(this.getBottomCol(row, col));

        // Return the perception
        return perception;
	}
    @Override
    public boolean agentFailed(Action actionReturned) {

    	CaperucitaEnvironmentState caperucitaEnvironmentState =
                this.getEnvironmentState();

        int vidas = caperucitaEnvironmentState.getCantVidas();

        // FIXME: The caperucita agent always has the same life
        // If the agent has no life, he failed
        if (vidas <= 0) {
            return true;
        }
        return false;
    }

	public int[] getSalida() {
		return salida;
	}

	public int[] getTopCol(int row, int col) {
        return ((CaperucitaEnvironmentState) this.environmentState)
                .getTopCol(row, col);
	}

	public int[] getLeftRow(int row, int col) {
        return ((CaperucitaEnvironmentState) this.environmentState)
                .getLeftRow(row, col);
	}

	public int[] getRightRow(int row, int col) {
        return ((CaperucitaEnvironmentState) this.environmentState)
                .getRightRow(row, col);
	}

	public int[] getBottomCol(int row, int col) {
        return ((CaperucitaEnvironmentState) this.environmentState)
                .getBottomCol(row, col);
	}
}
