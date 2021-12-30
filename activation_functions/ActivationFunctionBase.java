package deepnnet2.activation_functions;

public abstract class ActivationFunctionBase
{
	public ActivationFunctionBase()
	{

	}

	public abstract double f(double x);
	public abstract double dfdx(double x);
}
