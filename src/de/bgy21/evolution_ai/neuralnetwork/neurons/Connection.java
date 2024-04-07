package de.bgy21.evolution_ai.neuralnetwork.neurons;

public class Connection {
    private Neuron neuron;
    private double weight;

    public Connection(Neuron neuron, double weight) {
        this.neuron = neuron;
        this.weight = weight;
    }

    public double getValue() {
        return neuron.getValue() * weight;
    }
}
