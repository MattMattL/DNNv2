package deepnnet2.activation_functions;

public class Output extends ActivationBase
{
	@Override
	public double f(double x)
	{
		return x;
	}

	@Override
	public double dfdx(double x)
	{
		return 0;
	}
}
