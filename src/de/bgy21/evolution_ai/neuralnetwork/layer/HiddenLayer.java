package de.bgy21.evolution_ai.neuralnetwork.layer;

import de.bgy21.evolution_ai.activation_functions.ActivationFunction;
import de.bgy21.evolution_ai.neuralnetwork.neurons.HiddenNeuron;
import de.bgy21.evolution_ai.neuralnetwork.neurons.InputNeuron;

import java.util.ArrayList;

public class HiddenLayer extends Layer<HiddenNeuron> {

    public HiddenLayer(ArrayList<HiddenNeuron> neurons) {
        super(neurons);
    }

    @Override
    public HiddenLayer copy() {
        ArrayList<HiddenNeuron> neurons = new ArrayList<>();
        for (HiddenNeuron neuron: this.neurons) {
            neurons.add(neuron.copy());
        }
        return new HiddenLayer(neurons);
    }
}
