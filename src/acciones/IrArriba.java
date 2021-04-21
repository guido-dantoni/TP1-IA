package acciones;

import java.util.Arrays;

import caperucita.CaperucitaEnvironmentState;
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

		    int x = caperucitaEstado.getFilaPosicion();
	        int y = caperucitaEstado.getColumnaPosicion();


	        int[][] ambiente = caperucitaEstado.getWorld();
	        
	        while(ambiente[x-1][y] != CaperucitaPerception.ARBOL_PERCEPTION){
	        	if(ambiente[x][y] == CaperucitaPerception.FOOD_PERCEPTION){
	        		caperucitaEstado.setWorldPosition(x, y, CaperucitaPerception.EMPTY_PERCEPTION);
		            CaperucitaEstadoAgente.cantDulces++;
	        	}
	        	if(ambiente[x][y] == CaperucitaPerception.ENEMY_PERCEPTION) {
	        		int[] i = {x,y};
	        		caperucitaEstado.setWolfPosition(i);
	        		return null;
	        	}
	        	caperucitaEstado.setPosicionActual(x-1,y);
	        }
	        
	        
			return caperucitaEstado;
	
	}

	@Override
	public Double getCost() {
		
		return 1.0;
	}

	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {
		CaperucitaEstadoAgente caperucitaEstado = (CaperucitaEstadoAgente) ast;
		CaperucitaEnvironmentState estadoAmbiente = (CaperucitaEnvironmentState) est;
		
		int[] pos = estadoAmbiente.getAgentPosition();
	    int x = pos[0];
        int y = pos[1];
        
        //desplazamiento de caperucita

        int[][] ambiente = estadoAmbiente.getWorld();
        
        while(ambiente[x+1][y] != CaperucitaPerception.ARBOL_PERCEPTION){
        	estadoAmbiente.setAgentPosition(new int[] {x-1, y});
        }
        

        
		return estadoAmbiente;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
