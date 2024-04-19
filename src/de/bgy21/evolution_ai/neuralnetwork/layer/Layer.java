package de.bgy21.evolution_ai.neuralnetwork.layer;


import de.bgy21.evolution_ai.neuralnetwork.neurons.Neuron;

import java.util.ArrayList;

public abstract class Layer<T extends Neuron> {

    public Layer(ArrayList<T> neurons) {
        this.neurons = neurons;
    }

    private ArrayList<T> neurons;

    public T getNeuron(int index) {
        return neurons.get(index);
    }

    public int size() {
        return neurons.size();
    }
}
