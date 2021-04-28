package caperucita;

import frsf.cidisi.faia.agent.search.GoalTest;
import frsf.cidisi.faia.state.AgentState;

public class CaperucitaMeta extends GoalTest{

	@Override
	public boolean isGoalState(AgentState agentState) {

		int fila = ((CaperucitaEstadoAgente) agentState).getFilaPosicion();
		int col = ((CaperucitaEstadoAgente) agentState).getColumnaPosicion() ;
		if(((CaperucitaEstadoAgente) agentState).getWorldPosition(fila, col)==CaperucitaPerception.SALIDA &&
				CaperucitaEstadoAgente.getVidas() >= 1){
			
			return true;
		}
		
		return false;

	}
}
