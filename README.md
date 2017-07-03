# OOP-Neuron-Modeling
Object Oriented Class Definitions for a Logical Neuron Unit<br>
This collection of classes models a fully functional Logical Neuron Unit.<br>
Class Neuron is abstract, and therefore you must instantiate one of its three concrete classes; InterNeuron, MotorNeuron, SensoryNeuron.<br>
Additionally, a faux Neuron class called InputSignal must be used to send a signal to the network.<br>
Together, these classes provide a powerful and fully functional implementation for the groundwork of an ANN (Artificial Neural Netork).<br>
The cumulative data structure which allows the calculations of signals to be made on the fly, is a DAG (Directed Acyclic Graph) double linked list, implementated by Maps that see forward and backward in the DAG.<br>
The software application Neural Network Explorer, created by Lance Dooley, is a fully functional implementation of theis collection of classes.
