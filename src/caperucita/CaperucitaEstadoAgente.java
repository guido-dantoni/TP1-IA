package caperucita;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

public class CaperucitaEstadoAgente extends SearchBasedAgentState {

    private int[][] world;
    private int[] posicion;
    private int[] initialPosition;
    public static int vidas=3;
     
	
    public CaperucitaEstadoAgente(int[][] m, int row, int col) {
        world = m;
        posicion = new int[] {row, col};
        initialPosition = new int[2];
        initialPosition[0] = row;
        initialPosition[1] = col;
        
    }
    
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public SearchBasedAgentState clone() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateState(Perception p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initState() {
		// TODO Auto-generated method stub
		
	}
	
	public int[] getPosicionActual() {
		return posicion;
	}
	
	public void setPosicionActual(int fila, int col) {
		this.posicion[0]=fila;
		this.posicion[1]=col;
	}
	
	//metodo para saber si la posicion actual del agente es la salida
	public boolean isExit() {
		// HACER
		Bosque b = new Bosque();
		int[] salida = b.getSalida();
		
		if (salida[0]== posicion[0] && salida[1]== posicion[1]) {
			return true;
		}
		return false;
	}

}
