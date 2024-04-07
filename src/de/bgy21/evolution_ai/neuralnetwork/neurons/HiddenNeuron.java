package de.bgy21.evolution_ai.neuralnetwork.neurons;

import de.bgy21.evolution_ai.neuralnetwork.ActivationFunction;

import java.util.ArrayList;

public class HiddenNeuron implements Neuron {

    private ArrayList<Connection> connections;
    private ActivationFunction activationFunction;

    public HiddenNeuron(ArrayList<Connection> connections, ActivationFunction activationFunction) {
        this.connections = connections;
        this.activationFunction = activationFunction;
    }

    @Override
    public double getValue() {
        double value = 0;
        for (Connection connection: connections) {
            value += connection.getValue();
        }
        return activationFunction.get_value(value);
    }
}
