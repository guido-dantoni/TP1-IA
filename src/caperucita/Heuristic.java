package caperucita;


import frsf.cidisi.faia.solver.search.IEstimatedCostFunction;
import frsf.cidisi.faia.solver.search.NTree;

public class Heuristic implements IEstimatedCostFunction{

	@Override
	public double getEstimatedCost(NTree node) {
        CaperucitaEstadoAgente estadoAgente = (CaperucitaEstadoAgente) node.getAgentState();
        
        return (estadoAgente.getDistanciaSalida());
    
	}

}
