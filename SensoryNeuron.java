package rsd.anatomy.nerve;

import java.io.Serializable;

public class SensoryNeuron extends Neuron implements Serializable 
{
	private static final long serialVersionUID = 1001;
	
	public SensoryNeuron() 
	{ 
		// assign the neuronID
		this("SENS_1");
	}
	
	public SensoryNeuron(String neuronID) 
	{ 
		this(	neuronID,
				MorphologyEnum.MULTIPOLAR );
	}
	
	public SensoryNeuron(	String neuronID,
							MorphologyEnum morphology) 
	{ 
		// assign the neuronID
		this.neuronID = neuronID;
		
		// default
		this.morphology = morphology;
	}
	
	public NeuronEnum getType() 
	{
		return NeuronEnum.SENSORYNEURON;
	}
}
