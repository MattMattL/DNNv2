package deepnnet2.activation_functions;

public class ReLU extends ActivationFunctionBase
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
}
