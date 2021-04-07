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
	        if (estadoCaperucita.getWorldPosition(row, col) == CaperucitaPerception.FOOD_PERCEPTION) {
	            // If the action is Eat, then the actual position has no more food.
	            estadoCaperucita.setWorldPosition(row, col, CaperucitaPerception.EMPTY_PERCEPTION);
	            CaperucitaEstadoAgente.cant_dulces++;
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
		

		        return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	

}

