package caperucita;


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
        	world[0][i]= CaperucitaPerception.ARBOL_PERCEPTION;
        	world[i][0]=CaperucitaPerception.ARBOL_PERCEPTION;
        	world[i][1]=CaperucitaPerception.ARBOL_PERCEPTION;
        	world[i][2]=CaperucitaPerception.ARBOL_PERCEPTION;
        	world[i][12]=CaperucitaPerception.ARBOL_PERCEPTION;
        	world[i][13]=CaperucitaPerception.ARBOL_PERCEPTION;
        	world[13][i]=CaperucitaPerception.ARBOL_PERCEPTION;
        }
        world[12][7] = CaperucitaPerception.SALIDA;
        world[13][7] = CaperucitaPerception.SALIDA;
        world[9][4] = CaperucitaPerception.ENEMY_PERCEPTION;
        world[1][3] = CaperucitaPerception.FOOD_PERCEPTION;
        world[1][9] = CaperucitaPerception.FOOD_PERCEPTION;
        world[7][4] = CaperucitaPerception.FOOD_PERCEPTION;
        
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
        this.setWolfPosition(new int[] {9,4});

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
		
		int vector[]  = new int[TAM];
		int i=0;
	
			while(world[row-1][col] != CaperucitaPerception.ARBOL_PERCEPTION && world.length<TAM) {
				vector[i]=world[row-1][col];
				row--;
			}
			return vector;
			
	}

	public int[] getLeftRow(int row, int col) {
		
		int vector[]  = new int[TAM];
		int i=0;
	
			while(world[row][col-1] != CaperucitaPerception.ARBOL_PERCEPTION && world.length<TAM) {
				vector[i]=world[row][col-1];
				col--;
			}
			return vector;
	}

	public int[] getRightRow(int row, int col) {
		int vector[]  = new int[TAM];
		int i=0;
	
			while(world[row][col+1] != CaperucitaPerception.ARBOL_PERCEPTION && world.length<TAM) {
				vector[i]=world[row][col+1];
				col++;
			}
			return vector;
	}

	public int[] getBottomCol(int row, int col) {
		
		int vector[]  = new int[TAM];
		int i=0;
	
			while(world[row+1][col] != CaperucitaPerception.ARBOL_PERCEPTION && world.length<TAM) {
				vector[i]=world[row+1][col];
				row++;
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

}
