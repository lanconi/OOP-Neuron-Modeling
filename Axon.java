package rsd.anatomy.nerve;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

public class Axon implements Serializable
{
	private static final long serialVersionUID = 1003;

	private List<Neuron> outputList = new ArrayList<>();
	
	public Axon()
	{
		
	}
	
	public void connect(Neuron n )
	{
		outputList.add(n);
	}
	
	public void disconnect(Neuron n)
	{
		outputList.remove(n);
	}
	
	public void disconnectAll()
	{
		outputList.clear();
	}
	
	public List<Neuron> getConnections()
	{
		return outputList;
	}
	
	public boolean isConnectedTo(Neuron n) 
	{
		//return outputMap.get(n);
		return outputList.contains(n);
	}
	
	public int getCount()
	{
		return outputList.size();
	}

	public Double getOutput(Double d)
	{
		// Piece-Wise Linear Function
		// maps input to output from 0 to 1.
		// Input less than 0, output = 0
		// Input more than 1, output = 1
		if( d < 0.0d )
			return 0.0d;
		else if ( d > 1.0 )
			return 1.0d;
		else
			return d;
	}
	
}
