package rsd.anatomy.nerve;


import java.io.Serializable;

import rsd.math.ActivationFunctionEnum;

public class InputSignal extends Neuron implements Serializable 
{
	private static final long serialVersionUID = 1001;
	
	/**
	 * 
	 */
	public InputSignal() 
	{
		// assign the neuronID
		this("INPUT_1");
	}
	
	/**
	 * 
	 * @param neuronID
	 */
	public InputSignal(String neuronID) 
	{ 
		this(	neuronID,
				MorphologyEnum.NONE);
	}
	
	/**
	 * 
	 * @param neuronID
	 * @param morphology
	 */
	public InputSignal(	String neuronID,
						MorphologyEnum morphology) 
	{ 
		// assign the neuronID
		this.neuronID = neuronID;
		
		this.morphology = morphology;
		
		// default settings for InputSignal
		layerClassification = LayerClassification.EXTERNAL_INPUT;
		activationFunction.setSelection(ActivationFunctionEnum.LINEAR);
		
		externalInputSignal = new Double(1.000d);

	}
	
	/**
	 * 
	 */
	public NeuronEnum getType() 
	{
		return NeuronEnum.INPUTSIGNAL;
	}
	
	/**
	 * 
	 */
	@Override
	public void updateLayerClassification() { }
	
	
	/**
	 * 
	 * @param selection
	 */
	@Override
	public void setActivationFunctionSelection(ActivationFunctionEnum selection)
	{
		// can only set the ActivationFucntion selection
		// to ActivationFunctionEnum.LINEAR
		activationFunction.setSelection(ActivationFunctionEnum.LINEAR);
	}
	
	/**
	 * Override computeTransferFunction to return the externalInputSignal
	 * value that was designed by the user
	 */
	@Override
	public Double computeTransferFunction()
	{
		return externalInputSignal;
	}


}