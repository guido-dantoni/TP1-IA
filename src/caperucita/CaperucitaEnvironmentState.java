package caperucita;

import java.awt.List;
import java.util.ArrayList;

import frsf.cidisi.faia.state.EnvironmentState;

/**
 * This class represents the real world state.
 */
public class CaperucitaEnvironmentState extends EnvironmentState {

    private int[][] world;
    private int[] agentPosition;
 //   private int agentEnergy;

    public CaperucitaEnvironmentState(int[][] m) {
        world = m;
    }

    public CaperucitaEnvironmentState() {
        world = new int[12][12];
        this.initState();
    }

    /**
     * This method is used to setup the initial real world.
     */
    @Override
    public void initState() {

        // Sets all cells as empty
        for (int row = 0; row < world.length; row++) {
            for (int col = 0; col < world.length; col++) {
                world[row][col] = CaperucitaPerception.EMPTY_PERCEPTION;
            }
        }

        
        /* Sets some cells with foods and enemies. */
        for(int i=0; i<14; i++) {
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
        
        

        this.setAgentPosition(new int[]{5, 11});
//        this.setAgentEnergy(50);
    }

    /**
     * String representation of the real world state.
     */
    @Override
    public String toString() {
        String str = "";

        str = str + "[ \n";
        for (int row = 0; row < world.length; row++) {
            str = str + "[ ";
            for (int col = 0; col < world.length; col++) {
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
/*
    public int getAgentEnergy() {
        return agentEnergy;
    }

    public void setAgentEnergy(int agentEnergy) {
        this.agentEnergy = agentEnergy;
    }

    public int getTopCell(int row, int col) {
        if (row == 0) {
            return world[3][col];
        }
        return world[row - 1][col];
    }

    public int getLeftCell(int row, int col) {
        if (col == 0) {
            return world[row][3];
        }
        return world[row][col - 1];
    }

    public int getRightCell(int row, int col) {
        if (col == 3) {
            return world[row][0];
        }
        return world[row][col + 1];
    }

    public int getBottomCell(int row, int col) {
        if (row == 3) {
            return world[0][col];
        }
        return world[row + 1][col];
    }
*/

	public int[] getTopCol(int row, int col) {
		
		int vector[]  = new int[14];
		int i=0;
	
			while(world[row-1][col] != CaperucitaPerception.ARBOL_PERCEPTION) {
				vector[i]=world[row-1][col];
				row--;
			}
			return vector;
			
	}

	public int[] getLeftRow(int row, int col) {
		
		int vector[]  = new int[14];
		int i=0;
	
			while(world[row][col-1] != CaperucitaPerception.ARBOL_PERCEPTION) {
				vector[i]=world[row][col-1];
				col--;
			}
			return vector;
	}

	public int[] getRightRow(int row, int col) {
		int vector[]  = new int[14];
		int i=0;
	
			while(world[row][col+1] != CaperucitaPerception.ARBOL_PERCEPTION) {
				vector[i]=world[row][col+1];
				col++;
			}
			return vector;
	}

	public int[] getBottomCol(int row, int col) {
		
		int vector[]  = new int[14];
		int i=0;
	
			while(world[row+1][col] != CaperucitaPerception.ARBOL_PERCEPTION) {
				vector[i]=world[row+1][col];
				row++;
			}
			return vector;
	}
}