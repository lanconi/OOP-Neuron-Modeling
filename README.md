# OOP-Neuron-Modeling
Object Oriented Class Definitions for a Logical Neuron Unit<br>
This collection of classes models a fully functional Logical Neuron Unit.<br>
Class Neuron is abstract, and therefore you must instantiate one of its three concrete classes; InterNeuron, MotorNeuron, SensoryNeuron.<br>
Additionally, a faux Neuron class called InputSignal must be used to send a signal to any instantiated object in the network. However, InputSignal cannot receive a signal from any other Object<br>
Together, these classes provide a powerful and fully functional implementation for the groundwork of an ANN (Artificial Neural Netork).<br>
The combined data structure which allows the calculations of signals to be made on the fly, is a DAG (Directed Acyclic Graph) doubley linked list, implementated by a Map in class Dendrite and a List in class Axon that see backward and forward in the DAG, respectively.<br>
The software application Neural Network Explorer, created by Lance Dooley, is a fully functional implementation of theis collection of classes.<br>
Things to note, without modification, the signal sent out from any Neuron can only be between (0.000d and 1.000), inclusive.
Weights for the Dendrites of any Neuron are restricted between (-1.000d and 1.000d), inclusive.
