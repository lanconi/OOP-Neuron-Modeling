package rsd.anatomy.nerve;

import java.io.Serializable;

import rsd.anatomy.general.Cell;
import rsd.math.ActivationFunctionEnum;
import rsd.math.ActivationFunction;


public abstract class Neuron extends Cell implements Serializable 
{
	private static final long serialVersionUID = 1002;
	
	// each Neuron will have a unique name to help the
	// program find it and access it's state and functions
	// SENS_XXX  MOTO_XXX   INTER_XXX, etc ...
	protected String neuronID;
	
	// enum, one of ...
	// UNIPOLAR, BIPOLAR, MULTIPOLAR, PSEUDOUNIPOLAR
	// this field is somewhat described by the class Dendrites
	// A Neuron "has-a" Dendrites instance
	protected MorphologyEnum morphology; 
	
	// Class  representing all of the Dendrite inputs
	// Each Dendrite can receive a signal from the axon of another Neuron,
	// and there is a weight associated with this relationship
	protected Dendrites dendrites = new Dendrites();
	
	// Axon represents the physical Axon of a Neuron and
	// it will hold references to all the Neurons it is
	// outputting a signal to
	protected Axon axon	= new Axon();	
	
	// Create ActivationFunction object
	protected ActivationFunction activationFunction = new ActivationFunction();
	
	// Each Neuron can be a combination of the various types of 
	// NetworkRole
	// LayerClassification
	// InputNeuron, HiddenNeuron, OutputNeuron
	protected  LayerClassification layerClassification = 
							LayerClassification.INPUT_OUTPUT;
	
	// this field is for sending a signal into the Neural Network from
	// a source outside of the Neural Network
	protected Double externalInputSignal 	= new Double(0.000d);
	protected Double expectedOutputSignal 	= new Double(0.000d);

	
	// Most neurons receive many input signals throughout their dendritic trees. 
	// A single neuron may have more than one set of dendrites, and may receive 
	// many thousands of input signals. Whether or not a neuron is excited into 
	// firing an impulse depends on the sum of all of the excitatory and inhibitory 
	// signals it receives. If the neuron does end up firing, the nerve impulse, 
	// or action potential, is conducted down the axon.
	
	//==========================================
	// Neuron ID ...this is unique for every Neuron
	//==========================================
	
	/**
	 * 
	 * @param neuronID
	 */
	public void setNeuronID(String neuronID) {
		this.neuronID = neuronID;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getNeuronID( ) {
		return neuronID;
	}
	
	// defined in sublcass
	public abstract NeuronEnum getType();
	
	//==========================================
	// Layer Classification
	//==========================================
	
	/**
	 * 
	 */
	public void updateLayerClassification()
	{
		boolean bInputs = false;
		boolean bOutputs = false;
		
		// does this Neuron have any Neurons connected to its Dendrites
		if( dendrites.getCount() > 0 )
			bInputs = true;
		
		// does this Neuron have any Neurons connected to its Axon
		if( axon.getCount() > 0 )
			bOutputs = true;
		
		if( bInputs & bOutputs ) {
			layerClassification = LayerClassification.HIDDEN;
			return;
		} else if( bInputs == false & bOutputs == true ) {
			layerClassification = LayerClassification.INPUT;
			return;
		}  else if( bInputs == true & bOutputs == false ) {
			layerClassification = LayerClassification.OUTPUT;
			return;
		}  else if( bInputs == false & bOutputs == false ) {
			layerClassification = LayerClassification.INPUT_OUTPUT;
			return;
		}
		

	} // end updateLayerClassification
	
	/**
	 * 
	 * @return
	 */
	public LayerClassification getLayerClassification()
	{
		return layerClassification;
	}
	
	//==========================================
	// Morphology
	// this section is unused for now
	// possibly remove it later
	//==========================================
	
	/**
	 * 
	 * @return MorphologyEnum
	 */
	public MorphologyEnum getMorphology()
	{
		return morphology;
	}
	
	public void setMorphology(MorphologyEnum morphology)
	{
		this.morphology = morphology;
	}
	
	//==========================================
	// Inputs
	//==========================================

	/**
	 * 
	 * @param neuron
	 */
	public void connectInput( Neuron neuron )
	{
		connectInput(neuron, new Double(1d));
	}
	
	/**
	 * 
	 * @param neuron
	 * @param d
	 */
	public void connectInput( Neuron neuron, Double d )
	{
		dendrites.connect(neuron, 1d);
		updateLayerClassification();
	}
	
	/**
	 * 
	 * @param neuron
	 */
	public void disconnectInput( Neuron neuron )
	{
		//System.out.println(neuronID + " disconnectInput " + neuron.getNeuronID() 
		//						+ " success");
		dendrites.disconnect(neuron);
		updateLayerClassification();
	}
	
	/**
	 * 
	 * @return
	 */
	public java.util.Set<Neuron> getInputs()
	{		
		return dendrites.getConnections();
	}
	
	/**
	 * 
	 * @param dendrites
	 */
	public void setDendrites(Dendrites dendrites)
	{
		this.dendrites = dendrites;
	}
	
	/**
	 * 
	 * @return
	 */
	public Dendrites getDendrites()
	{
		return dendrites;
	}
	
	/**
	 * 
	 * @param neuron
	 * @return
	 */
	public Double getInputWeight(Neuron neuron)
	{
		return dendrites.getWeight(neuron);
	}
	
	/**
	 * 
	 * @param neuron
	 * @param d
	 */
	public void setInputWeight(Neuron neuron, Double d)
	{
		dendrites.setWeight(neuron, d);
	}
	
	
	//==========================================
	// External Input Signal
	//==========================================
	
	/**
	 * 
	 * @param d
	 */
	public void setExternalInputSignal(Double d)
	{
		externalInputSignal = d;
	}
	
	/**
	 * 
	 * @return
	 */
	public Double getExternalInputSignal()
	{
		return externalInputSignal;
	}
	
	//==========================================
	// Outputs
	//==========================================
	
	/**
	 * 
	 * @param neuron
	 */
	public void connectOutput(Neuron neuron )
	{
		//axon.connect(neuron, 1d);
		axon.connect(neuron);
		updateLayerClassification();
	}
	
	/**
	 * 
	 * @param neuron
	 */
	public void disconnectOutput(Neuron neuron )
	{
		//System.out.println(neuronID + " disconnectOutput " + neuron.getNeuronID() );
		axon.disconnect(neuron);
		updateLayerClassification();		
		//System.out.println(neuronID + " disconnectOutput " + neuron.getNeuronID() + " success");

	}
	
	/**
	 * 
	 */
	public void disconnectAllInputs()
	{
		dendrites.disconnectAll();
	}
	
	/**
	 * 
	 */
	public void disconnectAllOutputs()
	{
		axon.disconnectAll();
	}
	
	/**
	 * isOutputConnected
	 * returns true if this Neuron has an output
	 * connected to the input parameter
	 * @param neuron
	 */
	public boolean isOutputConnectedTo(Neuron neuron)
	{
		//  one of this Neuron's outputs
		
		return axon.isConnectedTo(neuron);
		/*
		Double d = axon.isFound(neuron);
		
		if( d == null )
			return false;
		else
			return true;
		*/
	}
	
	/**
	 * 
	 * @return Axon
	 */
	public Axon getAxon()
	{
		return axon;
	}
	
	/**
	 * 
	 * @param axon
	 */
	public void setAxon(Axon axon)
	{
		this.axon = axon;
	}
	
	/**
	 * 
	 * @return Set<Neuron>
	 */
	//public java.util.Set<Neuron> getOutputs()
	public java.util.List<Neuron> getOutputs()
	{		
		//return axon.getConnections();
		return axon.getConnections();
	}
	
	/**
	 * Computes the Transfer Function for a Neuron
	 * @return Double
	 */
	public Double computeTransferFunction()
	{
		Double niD = computeNetInput();
		Double afD = computeActivationFunction(niD);		
		Double ofD = computeOutputFunction(afD);
		return ofD.doubleValue();
	}
	
	//==========================================
	// Net Input Function
	//==========================================
	
	/**
	 * 
	 * @return Double
	 */
	public Double computeNetInput()
	{
		//System.out.println("Neuron.computeNetInput ..." );
		// loop through all the 
		return dendrites.computeNetInput();
	}
	
	//==========================================
	// Activation Function
	//==========================================
	
	/**
	 * 
	 * @param double
	 * @return double
	 */
	public double computeActivationFunction(double d)
	{
		//System.out.println("computeActivationFunction ... " + d );
		return activationFunction.compute(d);
	}
	
	/**
	 * 
	 * @param selection
	 */
	public void setActivationFunctionSelection(ActivationFunctionEnum selection)
	{
		activationFunction.setSelection(selection);
	}
	
	/**
	 * 
	 * @return ActivationFunctionEnum
	 */
	public ActivationFunctionEnum getActivationFunctionSelection()
	{
		return activationFunction.getSelection();
	}
	
	public void setActivationFunctionThreshold(double d)
	{
		//System.out.println("setActivationFunctionThreshold: " + d);
		activationFunction.setThreshold(d);
	}
	
	public double getActivationFunctionThreshold()
	{
		return activationFunction.getThreshold();
	}
	
	//==========================================
	// Output Function
	//==========================================
	
	/**
	 * 
	 * @return double
	 */
	public double computeOutputFunction(double d)
	{
		return axon.getOutput(d);
	}
	
	public void setExpectedOutputSignal(double d)
	{
		expectedOutputSignal = d;
	}
	
	public double getExpectedOutputSignal()
	{
		return expectedOutputSignal;
	}
	
} // end Neuron
