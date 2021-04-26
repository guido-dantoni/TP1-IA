package caperucita;

import java.util.Arrays;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;


public class CaperucitaEstadoAgente extends SearchBasedAgentState {

    private int[][] world;
    private int[] posicionActual;
    private int[] initialPosition;
    private int[] wolfPosition;
    public static int cantVidas=3;
    public static int cantDulces=0;
    private int celdasVisitadas;
	public static final int TAM = CaperucitaEnvironmentState.TAM;

     
    public CaperucitaEstadoAgente(int[][] m, int row, int col, int lifes, int[] lobo) {
        world = m;
        posicionActual = new int[] {row, col};
        initialPosition = new int[2];
        initialPosition[0] = row;
        initialPosition[1] = col;
        cantVidas=lifes;
        celdasVisitadas=0;
        wolfPosition = lobo;
        
    }
    
    public CaperucitaEstadoAgente() {
        world = new int[TAM][TAM];
        initialPosition = new int[2];
        posicionActual = new int[2];
        wolfPosition= new int[2];
        this.initState();
    }

	@Override
	public boolean equals(Object obj) {
		
		boolean fila = ((CaperucitaEstadoAgente) obj).getFilaPosicion() == this.getFilaPosicion();
		boolean col = ((CaperucitaEstadoAgente) obj).getColumnaPosicion() == this.getColumnaPosicion();
		boolean vidas = ((CaperucitaEstadoAgente) obj).getVidas() == this.getVidas();
		boolean comida = ((CaperucitaEstadoAgente) obj).getCantDulces() == this.getCantDulces();
		//boolean filaLobo = ((CaperucitaEstadoAgente) obj).getWolfPosition()[0]==this.getWolfPosition()[0];
		//boolean colLobo = ((CaperucitaEstadoAgente) obj).getWolfPosition()[1]==this.getWolfPosition()[1];
		
		return (fila && col && vidas && comida /*&& filaLobo && colLobo*/);
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
	        newPosition[0] = posicionActual[0];
	        newPosition[1] = posicionActual[1];

	        CaperucitaEstadoAgente newState = new CaperucitaEstadoAgente(newWorld,
	        		this.getFilaPosicion(), this.getColumnaPosicion(), CaperucitaEstadoAgente.getVidas(), this.getWolfPosition());

	        return newState;
	}

	@Override
	public void updateState(Perception p) {
		CaperucitaPerception caperucitaPerception = (CaperucitaPerception) p;
		CaperucitaEstadoAgente caperucitaEstado = new CaperucitaEstadoAgente();
		CaperucitaEnvironmentState estadoAmbiente = new CaperucitaEnvironmentState();
		
		wolfPosition=this.getWolfPosition();
		
        //si el lobo cae en l posicion de caperucita se la morfa y capeucita arranca en la pos inicial
        if(Arrays.equals(estadoAmbiente.getWolfPosition(),caperucitaEstado.getPosicionActual())) {
        	
        	CaperucitaEstadoAgente.cantVidas--;        
        	caperucitaEstado.setPosicionActual(caperucitaEstado.getInitialPosition()[0], caperucitaEstado.getInitialPosition()[1]);
      
        }
		
	}

	@Override
	public String toString() {
        String str = "";

        str = str + " position=\"(" + getFilaPosicion()  + "," + "" + getColumnaPosicion() + ")\"";
       

        str = str + "world=\"[ \n";
        for (int row = 0; row < world.length; row++) {
            str = str + "[ ";
            for (int col = 0; col < world.length; col++) {
                if (world[row][col] == -1) {
                    str = str + "* ";
                } else {
                    str = str + world[row][col] + " ";
                }
            }
            str = str + " ]\n";
        }
        str = str + " ]\"";

        return str;
	}

	@Override
	public void initState() {
		
		
		
		CaperucitaEnvironmentState estadoAmbiente = new CaperucitaEnvironmentState();
		estadoAmbiente.initState();
		this.setWorld(estadoAmbiente.getWorld());
		this.setInitialPosition(estadoAmbiente.getAgentPosition());
		this.setPosicionActual(estadoAmbiente.getAgentPosition()[0],estadoAmbiente.getAgentPosition()[1]) ;
		this.setWolfPosition(estadoAmbiente.getWolfPosition());
		
	}
	
	public int[] getPosicionActual() {
		return posicionActual;
	}
	
	//obtener fila de la posicion
	public int getFilaPosicion() {
		return posicionActual[0];
	}
	
	//obtener columna de la posicion
	public int getColumnaPosicion() {
		return posicionActual[1];
	}
	
	public void setPosicionActual(int fila, int col) {
		this.posicionActual[0]=fila;
		this.posicionActual[1]=col;
	}
	
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
	
	public static int getCantDulces() {
		
		return cantDulces;
	}

	public double getVisitedCellsCount() {

		return celdasVisitadas;
	}

	//a cada celda le ponemos de costo 1, como se mueve de a varias celdas, las incremento en "a" cantidades de celdas
    public void increaseVisitedCellsCount(int a) {
        this.celdasVisitadas = +a;
    }

    //retorna la distancia de la posicion del agente a la salida
	public double getDistanciaSalida() {
		
		Bosque b = new Bosque();
		int difFila = b.getSalida()[0] - this.getFilaPosicion();
		int difColumna = b.getSalida()[0] - this.getColumnaPosicion();
				
		
		return (Math.abs(difFila) + Math.abs(difColumna));
	}

}
