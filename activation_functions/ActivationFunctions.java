package deepnnet2.activation_functions;

public class ActivationFunctions
{
	// activation functions
	public static final ActivationFunctionBase SIGMOID = new Sigmoid();
	public static final ActivationFunctionBase RELU = new ReLU();

	// output options
	public static final ActivationFunctionBase SOFTMAX = new Softmax();
	public static final ActivationFunctionBase OUTPUT = new Output();
}
