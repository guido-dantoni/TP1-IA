package acciones;

import caperucita.CaperucitaEstadoAgente;
import caperucita.CaperucitaPerception;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class IrArriba extends SearchAction {

	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		
			CaperucitaEstadoAgente caperucitaEstado = (CaperucitaEstadoAgente) s;
			Recolectar r = new Recolectar();

		    int x = caperucitaEstado.getFilaPosicion();
	        int y = caperucitaEstado.getColumnaPosicion();


	        int[][] ambiente = caperucitaEstado.getWorld();
	        
	        while(ambiente[x-1][y] != CaperucitaPerception.ARBOL_PERCEPTION){
	        	if(ambiente[x][y] == CaperucitaPerception.FOOD_PERCEPTION){
	        		r.execute(caperucitaEstado);
	        	}
	        	caperucitaEstado.setPosicionActual(x-1,y);
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
		/*CaperucitaEstadoAgente caperucitaEstado = (CaperucitaEstadoAgente) ast;
		EnviromentState estadoAmbiente = (EnviromentState) est;

	    int x = estadoAmbiente.getFilaPosicion();
        int y = estadoAmbiente.getColumnaPosicion();


        int[][] ambiente = caperucitaEstado.getWorldPosicion();
        
        while(ambiente[x-1][y] != CaperucitaPerception.ARBOL_PERCEPTION){
        	if(ambiente[x][y] == CaperucitaPerception.FOOD_PERCEPTION){
        		caperucitaEstado.recolectar(x,y);
        	}
        	caperucitaEstado.setPosicionActual(x-1,y);
        	estadoAmbiente.setPositionCaperucita(new int[] {x-1, y});
        }*/
		return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
