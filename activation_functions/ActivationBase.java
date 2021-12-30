package deepnnet2.activation_functions;

public abstract class ActivationBase
{
	public ActivationBase()
	{

	}

	public abstract double f(double x);
	public abstract double dfdx(double x);
}
