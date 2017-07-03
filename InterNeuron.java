package rsd.anatomy.nerve;

import java.io.Serializable;

public class InterNeuron extends Neuron implements Serializable 
{
	private static final long serialVersionUID = 1001;
	
	public InterNeuron() 
	{
		// assign the neuronID
		this("INTER_1");
	}
	
	public InterNeuron(String neuronID) 
	{ 
		this(	neuronID,
				MorphologyEnum.MULTIPOLAR);
	}
	
	public InterNeuron(	String neuronID,
						MorphologyEnum morphology) 
	{ 
		// assign the neuronID
		this.neuronID = neuronID;
		
		// default
		this.morphology = morphology;
	}
	
	public NeuronEnum getType() 
	{
		return NeuronEnum.INTERNEURON;
	}

	
}
