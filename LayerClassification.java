package rsd.anatomy.nerve;

/**
 * LayerClassification
 * Denotes the layer of a given Neuron
 * 
 * Neurons that receive stimuli from outside the network are called input neurons; 
 * neurons whose outputs are externally used are called output neurons; 
 * neurons that receive stimuli from other neurons and whose outputs are s
 * timuli for other neurons in the network are called hidden neurons
 * 
 * Imperial College Press, “Slawomir Koziel”
 * Simulation-Driven Design Optimization and Modeling for Microwave Engineering,
 * ISBN-13: 978-1848169166

 * @author lancedooley
 *
 */
public enum LayerClassification {
	INPUT,
	HIDDEN,
	OUTPUT,
	INPUT_OUTPUT,
	EXTERNAL_INPUT
}
