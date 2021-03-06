package caperucita;


import java.util.Arrays;

import frsf.cidisi.faia.state.EnvironmentState;

/**
 * This class represents the real world state.
 */
public class CaperucitaEnvironmentState extends EnvironmentState {


    private int[][] world;
    private int[] agentPosition;
    private int[] wolfPosition;
    private int [] positionDulces;
    public static int cantVidas=3;
    public static int cantDulces=3;
    public static final int TAM=14;


    public CaperucitaEnvironmentState(int[][] m, int[] agent, int[] wolf, int[] dulces) {
        world = m;
        positionDulces=dulces;
        agentPosition= agent;
        wolfPosition =wolf;
    }

    public CaperucitaEnvironmentState() {
        world = new int[TAM][TAM];
        positionDulces=new int [2];
        agentPosition= new int [2];
        wolfPosition = new int [2];
        this.initState();
    }

    /**
     * This method is used to setup the initial real world.
     */
    @Override
    public void initState() {

        // Sets all cells as empty
        for (int row = 0; row < TAM; row++) {
            for (int col = 0; col < TAM; col++) {
                world[row][col] = CaperucitaPerception.EMPTY_PERCEPTION;
            }
        }

        
        /* Sets some cells with foods and enemies. */
        for(int i=0; i<TAM; i++) {
        	world[0][i]= CaperucitaPerception.ARBOL_PERCEPTION; //fila 0
        	world[i][0]=CaperucitaPerception.ARBOL_PERCEPTION; //col 0
        	world[i][1]=CaperucitaPerception.ARBOL_PERCEPTION; //col 1
        	world[i][2]=CaperucitaPerception.ARBOL_PERCEPTION; // col 2
        	world[i][12]=CaperucitaPerception.ARBOL_PERCEPTION; // col 12
        	world[i][13]=CaperucitaPerception.ARBOL_PERCEPTION; //col 13
        	world[13][i]=CaperucitaPerception.ARBOL_PERCEPTION; // fila 13
        }
      //Ambiente 1 **************************************************************************************
        /*
        world[12][7] = CaperucitaPerception.SALIDA;
        world[13][7] = CaperucitaPerception.SALIDA;
        world[9][4] = CaperucitaPerception.ENEMY_PERCEPTION;
        world[1][3] = CaperucitaPerception.FOOD_PERCEPTION;
        world[1][9] = CaperucitaPerception.FOOD_PERCEPTION;
        world[7][4] = CaperucitaPerception.FOOD_PERCEPTION;
        world[5][11] = CaperucitaPerception.FOOD_PERCEPTION;
        
        world[11][7]=CaperucitaPerception.ARBOL_PERCEPTION;
        world[1][5]=CaperucitaPerception.ARBOL_PERCEPTION;
        world[5][5]=CaperucitaPerception.ARBOL_PERCEPTION;
        world[4][4]=CaperucitaPerception.ARBOL_PERCEPTION;
        world[6][6]=CaperucitaPerception.ARBOL_PERCEPTION;
        world[5][9]=CaperucitaPerception.ARBOL_PERCEPTION;
        world[4][8]=CaperucitaPerception.ARBOL_PERCEPTION;
        world[7][5]=CaperucitaPerception.ARBOL_PERCEPTION;
        world[6][4]=CaperucitaPerception.ARBOL_PERCEPTION;
        world[7][9]=CaperucitaPerception.ARBOL_PERCEPTION;
        world[11][10]=CaperucitaPerception.ARBOL_PERCEPTION;
        world[12][6]=CaperucitaPerception.ARBOL_PERCEPTION;
                
        
        this.setAgentPosition(new int[]{5, 10});
        this.setWolfPosition(new int[] {9,4});*/
       
       //AMBIENTE ALTERNATIVO**********************************************************************************
         
        world[4][11] = CaperucitaPerception.SALIDA;
        world[4][12] = CaperucitaPerception.SALIDA;
        world[4][13] = CaperucitaPerception.SALIDA;
        world[3][9] = CaperucitaPerception.ENEMY_PERCEPTION;
        world[1][9] = CaperucitaPerception.FOOD_PERCEPTION;
        world[2][11] = CaperucitaPerception.FOOD_PERCEPTION;
        world[9][9] = CaperucitaPerception.FOOD_PERCEPTION;
        
        
        
        world[2][7]=CaperucitaPerception.ARBOL_PERCEPTION;
        world[3][6]=CaperucitaPerception.ARBOL_PERCEPTION;
        world[4][5]=CaperucitaPerception.ARBOL_PERCEPTION;
        world[4][6]=CaperucitaPerception.ARBOL_PERCEPTION;
        world[4][6]=CaperucitaPerception.ARBOL_PERCEPTION;   
        world[4][10]=CaperucitaPerception.ARBOL_PERCEPTION;
        world[5][10]=CaperucitaPerception.ARBOL_PERCEPTION;
        world[5][11]=CaperucitaPerception.ARBOL_PERCEPTION;
        world[6][7]=CaperucitaPerception.ARBOL_PERCEPTION;
        world[6][8]=CaperucitaPerception.ARBOL_PERCEPTION;
        world[7][6]=CaperucitaPerception.ARBOL_PERCEPTION;
        world[8][4]=CaperucitaPerception.ARBOL_PERCEPTION;
        world[9][4]=CaperucitaPerception.ARBOL_PERCEPTION;
        world[9][10]=CaperucitaPerception.ARBOL_PERCEPTION;
        world[9][11]=CaperucitaPerception.ARBOL_PERCEPTION;
        world[12][6]=CaperucitaPerception.ARBOL_PERCEPTION;
        world[10][5]=CaperucitaPerception.ARBOL_PERCEPTION;
        world[11][6]=CaperucitaPerception.ARBOL_PERCEPTION;
        world[11][9]=CaperucitaPerception.ARBOL_PERCEPTION;
        world[11][10]=CaperucitaPerception.ARBOL_PERCEPTION;
        world[12][6]=CaperucitaPerception.ARBOL_PERCEPTION;
        world[12][9]=CaperucitaPerception.ARBOL_PERCEPTION;
        world[12][10]=CaperucitaPerception.ARBOL_PERCEPTION;
        world[13][6]=CaperucitaPerception.ARBOL_PERCEPTION;
        
        
        this.setAgentPosition(new int[]{5, 9});
        this.setWolfPosition(new int[] {3,9});
        

    }

    /**
     * String representation of the real world state.
     */
    @Override
    public String toString() {
        String str = "";

        str = str + "[ \n";
        for (int row = 0; row < TAM; row++) {
            str = str + "[ ";
            for (int col = 0; col < TAM; col++) {
                str = str + world[row][col] + " ";
            }
            str = str + " ]\n";
        }
        str = str + " ]";

        return str;
    }

    // The following methods are Caperucita-specific:

    public int[][] getWorld() {
        return world;
    }

    public void setWorld(int[][] world) {
        this.world = world;
    }

    public void setWorld(int row, int col, int value) {
        this.world[row][col] = value;
    }

    public int[] getAgentPosition() {
        return agentPosition;
    }

    public void setAgentPosition(int[] agentPosition) {
        this.agentPosition = agentPosition;
    }


	public int[] getTopCol(int row, int col) {
		
		int vector[]  = new int[row];
		int j=0;
		
		
		for (int i=row-1; i>=0; i--) {
			vector[j] = world[i][col];
			j++;
		}
			return vector;
	}

	public int[] getLeftRow(int row, int col) {
		
		int vector[]  = new int[col];
		int j=0;
		
		
		for (int i=col-1; i>=0; i--) {
			vector[j] = world[row][j];
			j++;
		}
			return vector;
	
	}

	public int[] getRightRow(int row, int col) {
		int vector[]  = new int[TAM - col-1];
		int j=0;
		
		
		for (int i=col+1 ;i<TAM ;i++) {
			vector[j] = world[row][i];
			j++;
		}
			return vector;
	
	}

	public int[] getBottomCol(int row, int col) {
		
		int vector[]  = new int[TAM -row-1];
		int j=0;
		
		
		for (int i=row+1; i<TAM; i++) {
			vector[j] = world[i][col];
			j++;
		}
			return vector;
	
	}


	public int[] getWolfPosition() {
		return wolfPosition;
	}

	public void setWolfPosition(int[] wolfPosition) {
		this.wolfPosition = wolfPosition;
	}

	public int getCantVidas() {
		return cantVidas;
	}

	public void setCantVidas(int cantVidas) {
		this.cantVidas = cantVidas;
	}

	public int getCantDulces() {
		return cantDulces;
	}

	public void setCantDulces(int cantDulces) {
		this.cantDulces = cantDulces;
	}
    
	public int[] getPositionDulces() {
		return positionDulces;
	}

	public void setPositionDulces(int[] positionDulces) {
		this.positionDulces = positionDulces;
	}

	public void newWolfPosition() {
		
		int posViejaLobo[]= new int[2];
		posViejaLobo = this.getWolfPosition();
		        
        //desplazamiento aleatorio del lobo en posicion vacia o donde esta caperucita
        int[][] ambiente = this.getWorld();
        int filaLobo=0;
        int columnaLobo=0;
        
        while(!(ambiente[filaLobo][columnaLobo] == CaperucitaPerception.EMPTY_PERCEPTION)){
        	
	        filaLobo = (int) (Math.random() * CaperucitaEnvironmentState.TAM -1);
	        columnaLobo = (int) (Math.random() * CaperucitaEnvironmentState.TAM -1);
        }
        
        //actualizo el vector de posicion del lobo
        this.setWolfPosition(new int []{filaLobo, columnaLobo}); 
        
        //actualizo el mundo del estado del ambiente con la posicion del lobo
        this.setWorld(this.getWolfPosition()[0], this.getWolfPosition()[1], CaperucitaPerception.ENEMY_PERCEPTION);
        this.setWorld(posViejaLobo[0], posViejaLobo[1 ], CaperucitaPerception.EMPTY_PERCEPTION);		
	}

}
