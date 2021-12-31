package deepnnet2.activations;

public class ReLU extends ActivationBase
{
	@Override
	public double f(double x)
	{
		return Math.max(0, x);
	}

	@Override
	public double dfdx(double x)
	{
		if(x < 0)
			return 0;
		else if(x > 0)
			return 1;
		else
			return 0.5;
	}

	@Override
	public double performance(double desired, double x)
	{
		return 0;
	}
}
