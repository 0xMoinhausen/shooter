package de.bgy21.evolution_ai.neuralnetwork.neurons;

public class Connection {
    private final Neuron neuron;
    private double weight;

    public Connection(Neuron neuron, double weight) {
        this.neuron = neuron;
        this.weight = weight;
    }

    public Connection(Neuron neuron) {
        this.neuron = neuron;
    }

    public double getValue() {
        return neuron.getValue() * weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
