package rsd.anatomy.nerve;

import java.io.Serializable;
import java.util.*;

public class Dendrites implements Serializable
{
	private static final long serialVersionUID = 1002;
	
	// Map used to correlate the weight for each dendrite input
	// to the output signal of a presynapitic Neuron
	// key presynapitic Neuron			can be null - yes	
	// value Double , weight			can be null - yes
	private Map<Neuron,Double> dendriteInputMap = new HashMap<>();
	
	public Dendrites()
	{
		
	}
	
	public void connect(Neuron n, Double d)
	{
		//System.out.println("Dendrites connect d: " + d);
		dendriteInputMap.put(n, d);
	}
	
	public void disconnect(Neuron n)
	{
		dendriteInputMap.remove(n);
	}
	
	public void disconnectAll()
	{
		dendriteInputMap.clear();
	}
	
	
	public int getCount()
	{
		return dendriteInputMap.size();
	}
	
	public Set<Neuron> getConnections()
	{
		java.util.Set<Neuron> keySet = 
					dendriteInputMap.keySet();
		return keySet;
	}
	
	/**
	 * 
	 * @param neuron
	 * @return
	 */
	public Double getWeight(Neuron neuron)
	{
		return dendriteInputMap.get(neuron);
	}
	
	/**
	 * 
	 * @param neuron
	 * @param d
	 */
	public void setWeight(Neuron neuron, Double d)
	{
		dendriteInputMap.put(neuron, d);
	}
	
	public double computeNetInput()
	{
		double sum = 0d;
		
		Set<Neuron> set = dendriteInputMap.keySet();
		Iterator<Neuron> iterator = set.iterator();
		
		// loop through the dendriteInputMap and calculate the
		// summation of the product of incoming signals and weights
		while( iterator.hasNext() )
		{
			Neuron neuron = iterator.next();
			if( neuron == null )
				continue;
			
			// get the output signal from the the sending neuron
			Double neuronOutput = neuron.computeTransferFunction();			
			
			// get the weight associated with
			// the Dendrite for this Neuron from the map
			Double weight = dendriteInputMap.get(neuron);
			
			if( weight == null )
				continue;
			
			// compute the product of the output from
			// the input Neuron and the weight of the
			// Dendrite
			Double product = neuronOutput * weight;
			sum += product;
		}
		return sum;
	} // end computeNetInput
	

}
