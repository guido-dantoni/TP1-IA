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
        int visitedCells=0;

        boolean flag =false;
        int[][] ambiente = caperucitaEstado.getWorld();
        
        while(ambiente[x][y-1] != CaperucitaPerception.ARBOL_PERCEPTION && y-1>0){
        	/*if(ambiente[x][y] == CaperucitaPerception.FOOD_PERCEPTION){
        		caperucitaEstado.setWorldPosition(x, y, CaperucitaPerception.EMPTY_PERCEPTION);
	            CaperucitaEstadoAgente.cantDulces++;
        	}*/
        	if(ambiente[x][y] == CaperucitaPerception.ENEMY_PERCEPTION) {
        		int[] i = {x,y};
        		caperucitaEstado.setWolfPosition(i);
        	
        	}
        	caperucitaEstado.setPosicionActual(x,y-1);
        	visitedCells++;
        	y--;
        	flag=true;
        }
        
        caperucitaEstado.increaseVisitedCellsCount(visitedCells);
        if(flag) {
    		return caperucitaEstado;

        }else {
        	return null;
        }
		
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
        int visitedCells=0;

        boolean flag=false; 
        //desplazamiento de caperucita
        int[][] ambiente = estadoAmbiente.getWorld();
        
        while(ambiente[x][y-1] != CaperucitaPerception.ARBOL_PERCEPTION && y-1>0){
        	if(ambiente[x][y] == CaperucitaPerception.FOOD_PERCEPTION){
        		estadoAmbiente.setWorld(x, y, CaperucitaPerception.EMPTY_PERCEPTION);
	            estadoAmbiente.setCantDulces(estadoAmbiente.getCantDulces()-1);
        		caperucitaEstado.setWorldPosition(x, y, CaperucitaPerception.EMPTY_PERCEPTION);
	            CaperucitaEstadoAgente.cantDulces++;
        	}
        	
        	if(ambiente[x][y] == CaperucitaPerception.ENEMY_PERCEPTION) {
        		int[] i = {x,y};
        		estadoAmbiente.setWolfPosition(i);
        		//caperucitaEstado.setWolfPosition(i);
        		estadoAmbiente.setCantVidas(estadoAmbiente.getCantVidas()-1);
        		estadoAmbiente.setAgentPosition(caperucitaEstado.getInitialPosition());
        		caperucitaEstado.setPosicionActual(caperucitaEstado.getInitialPosition()[0], caperucitaEstado.getInitialPosition()[1]);
        		CaperucitaEstadoAgente.cantVidas--;
        		caperucitaEstado.increaseVisitedCellsCount(50);
            	return estadoAmbiente;
        	}
        	visitedCells++;
        	estadoAmbiente.setAgentPosition(new int[] {x, y-1});
        	caperucitaEstado.setPosicionActual(x,y-1);
        	y--;
        	flag=true;
        }
        caperucitaEstado.increaseVisitedCellsCount(visitedCells);
        
        if(flag) {
        	return estadoAmbiente;
        }else {
        	return null;
        }
            
       
		
		
	}
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "irIzquierda";
	}

}
