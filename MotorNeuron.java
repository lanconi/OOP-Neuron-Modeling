package rsd.anatomy.nerve;

import java.io.Serializable;

public class MotorNeuron extends Neuron implements Serializable 
{
	private static final long serialVersionUID = 1001;

	public MotorNeuron() 
	{ 		
		// assign the neuronID
		this("MOTOR_1");
	}
	
	public MotorNeuron(String neuronID) 
	{ 
		this(	neuronID,
				MorphologyEnum.MULTIPOLAR);
	}
	
	public MotorNeuron(	String neuronID,
						MorphologyEnum morphology) 
	{ 
		// assign the neuronID
		this.neuronID = neuronID;
		
		// default
		this.morphology = morphology;
	}
	
	public NeuronEnum getType() 
	{
		return NeuronEnum.MOTORNEURON;
	}
	
}
