package acciones;

import java.util.Arrays;

import caperucita.CaperucitaEnvironmentState;
import caperucita.CaperucitaEstadoAgente;
import caperucita.CaperucitaPerception;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class IrIzquierda extends SearchAction {

	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		
		CaperucitaEstadoAgente caperucitaEstado = (CaperucitaEstadoAgente) s;

		    int x = caperucitaEstado.getFilaPosicion();
	        int y = caperucitaEstado.getColumnaPosicion();


	        int[][] ambiente = caperucitaEstado.getWorld();
	        	        
		        while(ambiente[x][y-1] != CaperucitaPerception.ARBOL_PERCEPTION){
		        	if(ambiente[x][y] == CaperucitaPerception.FOOD_PERCEPTION){
		        		caperucitaEstado.setWorldPosition(x, y, CaperucitaPerception.EMPTY_PERCEPTION);
			            CaperucitaEstadoAgente.cantDulces++;
		        	}
		        	if(ambiente[x][y] == CaperucitaPerception.ENEMY_PERCEPTION) {
		        		int[] i = {x,y};
		        		caperucitaEstado.setWolfPosition(i);
		        		return null;
		        	}
		        	caperucitaEstado.setPosicionActual(x,y-1);
		        }
	        
	        return caperucitaEstado;
	        
	 }

	@Override
	public Double getCost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {
		CaperucitaEstadoAgente caperucitaEstado = (CaperucitaEstadoAgente) ast;
		CaperucitaEnvironmentState estadoAmbiente = (CaperucitaEnvironmentState) est;
		
		int[] pos = estadoAmbiente.getAgentPosition();
	    int x = pos[0];
        int y = pos[1];


        int[][] ambiente = estadoAmbiente.getWorld();
        
        while(ambiente[x+1][y] != CaperucitaPerception.ARBOL_PERCEPTION){
        	estadoAmbiente.setAgentPosition(new int[] {x, y-1});
        }
        
        int filaLobo=0;
        int columnaLobo=0;
        
        while(ambiente[filaLobo][columnaLobo] == CaperucitaPerception.ARBOL_PERCEPTION ||
        		ambiente[filaLobo][columnaLobo] == CaperucitaPerception.FOOD_PERCEPTION ||
        		ambiente[filaLobo][columnaLobo] == CaperucitaPerception.SALIDA) {
        	
	        filaLobo = (int) (Math.random() * CaperucitaEnvironmentState.TAM -1);
	        columnaLobo = (int) (Math.random() * CaperucitaEnvironmentState.TAM -1);
        }
        
        estadoAmbiente.setWorld(estadoAmbiente.getWolfPosition()[0], estadoAmbiente.getWolfPosition()[1], CaperucitaPerception.EMPTY_PERCEPTION);
        estadoAmbiente.setWolfPosition(new int []{filaLobo, columnaLobo});
        
        if(Arrays.equals(estadoAmbiente.getWolfPosition(),caperucitaEstado.getPosicionActual())) {
        	
        	CaperucitaEstadoAgente.cantVidas--;
        	caperucitaEstado.setPosicionActual(caperucitaEstado.getInitialPosition()[0], caperucitaEstado.getInitialPosition()[1]);
        }
        
		return estadoAmbiente;
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
