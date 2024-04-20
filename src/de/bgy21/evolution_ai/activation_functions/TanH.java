package de.bgy21.evolution_ai.activation_functions;

public class TanH implements ActivationFunction{
    @Override
    public double get_value(double value) {
        return Math.tanh(value);
    }
}
