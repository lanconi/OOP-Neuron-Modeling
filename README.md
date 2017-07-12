# OOP-Neuron-Modeling
Object Oriented Class Definitions for a Logical Neuron Unit<br>
This collection of classes models a fully functional Logical Neuron Unit.<br>
Class Neuron is abstract, and therefore you must instantiate one of its three concrete classes; InterNeuron, MotorNeuron, SensoryNeuron.<br>
Additionally, a faux Neuron class called InputSignal must be used to send a signal to any instantiated Neuron in the network. However, InputSignal should not receive a signal from any other Object<br>
Together, these classes provide a powerful and fully functional implementation for the groundwork of an ANN (Artificial Neural Netork).<p>
The combined data structure which allows the calculations of signals to be made on the fly, is a DAG (Directed Acyclic Graph) with doubley linked list nodes, implementated by a Map<Neuron,Double> in class Dendrite and a List<Neuron> in class Axon that see backward and forward in the DAG, respectively.<p>
The software application Neural Network Explorer, created by Lance Dooley, is a fully functional implementation of this collection of classes.<p>
Things to note: the signal sent out from any Neuron is squashed between (0.000d and 1.000), inclusive.<br>
Weights for the Dendrites of any Neuron are restricted between (-1.000d and 1.000d), inclusive.<br>

<p>

UML Class Diagram for Neuron.<br>
<img src="NeuronUML.png">
