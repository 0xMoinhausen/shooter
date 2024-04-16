package de.bgy21.evolution_ai.neuralnetwork.layer;

import de.bgy21.evolution_ai.activation_functions.ActivationFunction;
import de.bgy21.evolution_ai.neuralnetwork.neurons.HiddenNeuron;

import java.util.ArrayList;

public class HiddenLayer extends Layer<HiddenNeuron> {

    public HiddenLayer(ArrayList<HiddenNeuron> neurons) {
        super(neurons);
    }
}
