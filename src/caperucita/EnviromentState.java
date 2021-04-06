package caperucita;


import frsf.cidisi.faia.state.EnvironmentState;
import caperucita.CaperucitaPerception;

public class EnviromentState extends EnvironmentState {
	
	private int[][] world;
    private int[] positionCaperucita;
    private int vidas;
    private int cantDulces;
    private int [] positionWolf;
    private int [] positionDulces;
    
    public EnviromentState(int[][] m) {
        world = m;
    }

    public EnviromentState() {
        world = new int[12][12];
        this.initState();
    }

    //metodo para inicializar el mundo real
	@Override
	public void initState() {
		// se inicializan todas las celdas como vacias
        for (int row = 0; row < world.length; row++) {
            for (int col = 0; col < world.length; col++) {
                world[row][col] = CaperucitaPerception.EMPTY_PERCEPTION;
            }
        }
		// se setean las posiciones de la comida, arboles, piedras y el lobo
        world[0][0] = CaperucitaPerception.FOOD_PERCEPTION;
        world[0][2] = CaperucitaPerception.FOOD_PERCEPTION;
        world[3][1] = CaperucitaPerception.ENEMY_PERCEPTION;
        world[2][1] = CaperucitaPerception.FOOD_PERCEPTION;
        world[0][3] = CaperucitaPerception.ENEMY_PERCEPTION;
        world[1][2] = CaperucitaPerception.FOOD_PERCEPTION;
        // seteamos posicion inicial de caperucita
        this.setPositionCaperucita(new int[]{1, 1});
        // seteamos cantidad de vidas de caperucita
        this.setVidas(3);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	public int[] getPositionCaperucita() {
		return positionCaperucita;
	}

	public void setPositionCaperucita(int[] positionCaperucita) {
		this.positionCaperucita = positionCaperucita;
	}

	public int getVidas() {
		return vidas;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}

	public int[][] getWorld() {
		return world;
	}

	public void setWorld(int[][] world) {
		this.world = world;
	}

	public int getCantDulces() {
		return cantDulces;
	}

	public void setCantDulces(int cantDulces) {
		this.cantDulces = cantDulces;
	}

	public int[] getPositionWolf() {
		return positionWolf;
	}

	public void setPositionWolf(int[] positionWolf) {
		this.positionWolf = positionWolf;
	}

	public int[] getPositionDulces() {
		return positionDulces;
	}

	public void setPositionDulces(int[] positionDulces) {
		this.positionDulces = positionDulces;
	}
	
	//faltan metodos para obtener la proxima celda a moverse en todas las direcciones

	
}
