package caperucita;

import frsf.cidisi.faia.state.EnvironmentState;

/**
 * This class represents the real world state.
 */
public class CaperucitaEnvironmentState extends EnvironmentState {

    private int[][] world;
    private int[] agentPosition;
    private int[] wolfPosition;
    private int cantVidas;
    private int cantDulces;

    public CaperucitaEnvironmentState(int[][] m) {
        world = m;
    }

    public CaperucitaEnvironmentState() {
        world = new int[4][4];
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
        world[0][0] = CaperucitaPerception.FOOD_PERCEPTION;
        world[0][2] = CaperucitaPerception.FOOD_PERCEPTION;
        world[3][1] = CaperucitaPerception.ENEMY_PERCEPTION;
        world[2][1] = CaperucitaPerception.FOOD_PERCEPTION;
        world[0][3] = CaperucitaPerception.ENEMY_PERCEPTION;
        world[1][2] = CaperucitaPerception.FOOD_PERCEPTION;

        this.setAgentPosition(new int[]{1, 1});
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

    // The following methods are Pacman-specific:

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
    
    
}
