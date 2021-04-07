
package caperucita;

import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;

public class CaperucitaMain {
    
    public static void main(String[] args) throws PrologConnectorException {
    	CaperucitaAgente caperucita = new CaperucitaAgente();
        
        Bosque pacmanEnvironment = new Bosque();
        
        SearchBasedAgentSimulator simulator =
                new SearchBasedAgentSimulator(pacmanEnvironment, caperucita);
        
        simulator.start();
    }
}