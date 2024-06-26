package de.bgy21.evolution_ai.neuralnetwork.neurons;

import de.bgy21.evolution_ai.activation_functions.ActivationFunction;

import java.util.ArrayList;

public class HiddenNeuron implements Neuron {

    private final ArrayList<Connection> connections;
    private final ActivationFunction activationFunction;

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

    @Override
    public HiddenNeuron copy() {
        ArrayList<Connection> connections= new ArrayList<>();
        for (Connection connection: this.connections) {
            connections.add(connection.copy());
        }
        return new HiddenNeuron(connections, activationFunction);
    }

    public ArrayList<Connection> getConnections() {
        return connections;
    }
}
