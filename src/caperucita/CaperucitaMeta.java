package caperucita;

import frsf.cidisi.faia.agent.search.GoalTest;
import frsf.cidisi.faia.state.AgentState;

public class CaperucitaMeta extends GoalTest{

	@Override
	public boolean isGoalState(AgentState agentState) {

		if(((CaperucitaEstadoAgente) agentState).isExit()){
			return true;
		}
		
		return false;

	}
}
