package de.bgy21.evolution_ai.neuralnetwork;

import com.rits.cloning.Cloner;
import de.bgy21.evolution_ai.activation_functions.ActivationFunction;
import de.bgy21.evolution_ai.neuralnetwork.layer.HiddenLayer;
import de.bgy21.evolution_ai.neuralnetwork.layer.InputLayer;
import de.bgy21.evolution_ai.neuralnetwork.layer.Layer;
import de.bgy21.evolution_ai.neuralnetwork.neurons.Connection;
import de.bgy21.evolution_ai.neuralnetwork.neurons.HiddenNeuron;
import de.bgy21.evolution_ai.neuralnetwork.neurons.Neuron;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class NeuralNetwork implements Cloneable {
    public InputLayer inputLayer;
    private final ArrayList<HiddenLayer> hiddenLayers;

    public NeuralNetwork(InputLayer inputLayer) {
        this.inputLayer = inputLayer;
        this.hiddenLayers = new ArrayList<>();
    }

    public NeuralNetwork(InputLayer inputLayer, ArrayList<HiddenLayer> hiddenLayers) {
        this.inputLayer = inputLayer;
        this.hiddenLayers = hiddenLayers;
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
                connections.add(new Connection(lastLayer.getNeuron(j), weights.get(i * lastLayer.size() + j)));
            }
            HiddenNeuron neuron = new HiddenNeuron(connections, activationFunction);
            neurons.add(neuron);
        }
        hiddenLayers.add(new HiddenLayer(neurons));
    }

    public HiddenLayer lastLayer() {
        return this.hiddenLayers.get(hiddenLayers.size() - 1);
    }

    public NeuralNetwork copy() {
        InputLayer inputLayer = this.inputLayer.copy();
        ArrayList<HiddenLayer> hiddenLayers = new ArrayList<>();

        for (HiddenLayer hiddenLayer: this.hiddenLayers) {
            hiddenLayers.add(hiddenLayer.copy());
        }
        return new NeuralNetwork(inputLayer, hiddenLayers);
    }

    public NeuralNetwork clone(double mutateRate, Random random) throws CloneNotSupportedException {
        Cloner cloner = new Cloner();
        NeuralNetwork neuralNetwork = cloner.deepClone(this);

        for (HiddenLayer layer: neuralNetwork.hiddenLayers) {
            for (int i = 0; i < layer.size(); i++) {
                for (Connection connection: layer.getNeuron(i).getConnections()) {
                    if (random.nextDouble() < mutateRate ) {
                        connection.setWeight(connection.getWeight() + (random.nextDouble() - 0.5) * 0.10);
                    }
                }
            }
        }
        return neuralNetwork;
    }

    public static ArrayList<Double> randomWeights(int amount, Random random) {
        ArrayList weights = new ArrayList();
        for (int i = 0; i < amount; i++) {
            weights.add(random.nextDouble() - 0.5);
        }
        return weights;
    }
}
