package caperucita;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;


public class CaperucitaEstadoAgente extends SearchBasedAgentState {

    private int[][] world;
    private int[] posicion;
    private int[] initialPosition;
    private int[] wolfPosition;
    public static int cantVidas=3;
    public static int cantDulces=0;
	public static final int TAM = CaperucitaEnvironmentState.TAM;

     
    public CaperucitaEstadoAgente(int[][] m, int row, int col, int lifes) {
        world = m;
        posicion = new int[] {row, col};
        initialPosition = new int[2];
        initialPosition[0] = row;
        initialPosition[1] = col;
        cantVidas=lifes;
        
    }
    
    public CaperucitaEstadoAgente() {
        world = new int[TAM][TAM];
        initialPosition = new int[2];
        this.initState();
    }

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	//metodo para clonar el estado del agente
	@Override
	public SearchBasedAgentState clone() {
		int[][] newWorld = new int [TAM][TAM];
		
		for(int fila=0; fila < world.length; fila++) {
			for(int col=0; col < world.length; col++) {
				newWorld[fila][col] = world[fila][col];
			}
		}
		 int[] newPosition = new int[2];
	        newPosition[0] = posicion[0];
	        newPosition[1] = posicion[1];

	        CaperucitaEstadoAgente newState = new CaperucitaEstadoAgente(newWorld,
	        		this.getFilaPosicion(), this.getColumnaPosicion(), CaperucitaEstadoAgente.getVidas());

	        return newState;
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
		
		//ESTO NOSE SI SERA ASI.... ********************************************************************
		
		CaperucitaEnvironmentState estadoAmbiente = new CaperucitaEnvironmentState();
		estadoAmbiente.initState();
		this.setWorld(estadoAmbiente.getWorld());
		this.setInitialPosition(estadoAmbiente.getAgentPosition());
		this.setPosicionActual(this.getInitialPosition()[0],this.getInitialPosition()[1]) ;
		this.setWolfPosition(estadoAmbiente.getWolfPosition());
		
		
	}
	
	public int[] getPosicionActual() {
		return posicion;
	}
	
	//obtener fila de la posicion
	public int getFilaPosicion() {
		return posicion[0];
	}
	
	//obtener columna de la posicion
	public int getColumnaPosicion() {
		return posicion[1];
	}
	
	public void setPosicionActual(int fila, int col) {
		this.posicion[0]=fila;
		this.posicion[1]=col;
	}
	
	//metodo para saber si la posicion actual del agente es la salida
/*	public boolean isExit() {
		// HACER
		Bosque b = new Bosque();
		int[] salida = b.getSalida();
		
		if (salida[0]== posicion[0] && salida[1]== posicion[1]) {
			return true;
		}
		return false;
	}
*/	
	public static int getVidas() {
		return cantVidas;
	}

	public static void setVidas(int vidas) {
		CaperucitaEstadoAgente.cantVidas = vidas;
	}
	
	public int[] getInitialPosition() {
		return initialPosition;
	}

	public void setInitialPosition(int[] initialPosition) {
		this.initialPosition = initialPosition;
	}

    public int[][] getWorld() {
        return world;
    }
    
    public int getWorldPosition(int row, int col) {
        return world[row][col];
    }
    
    public void setWorld(int[][] w) {
    	this.world = w;
    }
    
	public void recolectar(int x, int y) {
		
	}
    public void setWorldPosition(int row, int col, int value) {
        this.world[row][col] = value;
    }
    
	public int[] getWolfPosition() {
		return wolfPosition;
	}

	public void setWolfPosition(int[] wolfPosition) {
		this.wolfPosition = wolfPosition;
	}

}
