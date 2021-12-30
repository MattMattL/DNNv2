package deepnnet2.activations;

public abstract class ActivationBase
{
	public ActivationBase()
	{

	}

	public abstract double f(double x);
	public abstract double dfdx(double x);
}
