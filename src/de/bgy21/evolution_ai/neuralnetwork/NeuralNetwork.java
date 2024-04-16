package de.bgy21.evolution_ai.neuralnetwork;

import de.bgy21.evolution_ai.activation_functions.ActivationFunction;
import de.bgy21.evolution_ai.neuralnetwork.layer.HiddenLayer;
import de.bgy21.evolution_ai.neuralnetwork.layer.InputLayer;
import de.bgy21.evolution_ai.neuralnetwork.layer.Layer;
import de.bgy21.evolution_ai.neuralnetwork.neurons.Connection;
import de.bgy21.evolution_ai.neuralnetwork.neurons.HiddenNeuron;
import de.bgy21.evolution_ai.neuralnetwork.neurons.Neuron;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class NeuralNetwork {
    public InputLayer inputLayer;
    private ArrayList<HiddenLayer> hiddenLayers;

    public NeuralNetwork(InputLayer inputLayer) {
        this.inputLayer = inputLayer;
    }

    public void add_hidden_layer(int size, ArrayList<Double> weights, ActivationFunction activationFunction) {
        Layer lastLayer;
        if (hiddenLayers.isEmpty()) {
            lastLayer = inputLayer;
        } else {
            lastLayer = hiddenLayers.get(hiddenLayers.size() - 1);
        }
        if (weights.size() != size * lastLayer.size()) {
            throw new RuntimeException("LOL That is bad! The code sucks!!:)");
        }
        ArrayList<HiddenNeuron> neurons = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            ArrayList<Connection> connections = new ArrayList<>(size * lastLayer.size());
            for (int j = 0; j < lastLayer.size(); j++) {
                connections.add(new Connection(lastLayer.getNeuron(j), weights.get(i * size + j)));
            }
            HiddenNeuron neuron = new HiddenNeuron(connections, activationFunction);
            neurons.add(neuron);
        }
        hiddenLayers.add(new HiddenLayer(neurons));
    }
}
