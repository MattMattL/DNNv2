package deepnnet2.activation_functions;

public class Sigmoid extends ActivationBase
{
	@Override
	public double f(double x)
	{
		return 1.0 / (1 + Math.exp(-x));
	}

	@Override
	public double dfdx(double x)
	{
		return x * (1 - x);
	}
}
