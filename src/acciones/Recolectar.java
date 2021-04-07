package acciones;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import caperucita.*;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;


public class Recolectar extends SearchAction {

	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		  CaperucitaEstadoAgente estadoCaperucita = (CaperucitaEstadoAgente) s;

	        int row = estadoCaperucita.getFilaPosicion();
	        int col = estadoCaperucita.getColumnaPosicion();

	        /* The 'Eat' action can be selected only if there is food in the current
	         * position. Otherwise return 'null'. */
	        if (estadoCaperucita.getWorld()[row][col] == CaperucitaPerception.FOOD_PERCEPTION) {
	            // If the action is Eat, then the actual position has no more food.
	            estadoCaperucita.setWorldPosition(row, col, CaperucitaPerception.EMPTY_PERCEPTION);
	            return estadoCaperucita;
	        }
	        
	        return null;
	}

	@Override
	public Double getCost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {
		 public EnvironmentState execute(AgentState ast, EnvironmentState est) {
		        CaperucitaEnvironmentState environmentState = (CaperucitaEnvironmentState) est;
		        CaperucitaEstadoAgente estadoCaperucita = ((CaperucitaEstadoAgente) ast);

		        int row = environmentState.getAgentPosition()[0];
		        int col = environmentState.getAgentPosition()[1];

		        if (environmentState.getWorld()[row][col] == CaperucitaPerception.FOOD_PERCEPTION) {
		            // Update the real world
		            environmentState.setWorld(row, col, CaperucitaPerception.EMPTY_PERCEPTION);

		            // Update the pacman state
		            estadoCaperucita.setWorldPosition(row, col, CaperucitaPerception.EMPTY_PERCEPTION);
		            
		            return environmentState;
		        }

		        return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	

}

