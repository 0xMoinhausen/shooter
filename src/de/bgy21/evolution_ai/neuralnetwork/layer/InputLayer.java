package de.bgy21.evolution_ai.neuralnetwork.layer;

import de.bgy21.evolution_ai.neuralnetwork.neurons.InputNeuron;
import de.bgy21.evolution_ai.neuralnetwork.neurons.Neuron;

import java.util.ArrayList;

public class InputLayer extends Layer<InputNeuron>{

    public InputLayer(int size) {
        super (new ArrayList<>());
        for (int i = 0; i < size; i++) {
            this.neurons.add(new InputNeuron());
        }
    }

    public InputLayer(ArrayList<InputNeuron> neurons) {
        super(neurons);
    }

    @Override
    public InputLayer copy() {
        ArrayList<InputNeuron> neurons = new ArrayList<>();
        for (InputNeuron neuron: this.neurons) {
            neurons.add(neuron.copy());
        }
        return new InputLayer(neurons);
    }
}
