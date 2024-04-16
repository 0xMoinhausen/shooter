package de.bgy21.evolution_ai.activation_functions;

public class Sigmoid implements ActivationFunction{
    @Override
    public double get_value(double value) {
        return 1 / (1 +Math.pow(Math.E, -value));
    }
}
