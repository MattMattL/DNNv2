package deepnnet2.activations;

public class Activations
{
	// activation functions
	public static final ActivationBase SIGMOID = new Sigmoid();
	public static final ActivationBase RELU = new ReLU();

	// output options
	public static final ActivationBase SOFTMAX = new Softmax();
	public static final ActivationBase OUTPUT = new Output();
}
