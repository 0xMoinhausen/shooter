package de.bgy21.evolution_ai.neuralnetwork.neurons;

public class InputNeuron implements Neuron {
    ;
    private double value;

    public InputNeuron() {}

    public InputNeuron(double value) {
        this.value = value;
    }


    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public InputNeuron copy() {
        return new InputNeuron();
    }

}
