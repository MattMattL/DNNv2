package deepnnet2.layers;

import deepnnet2.activation_functions.ActivationFunctionBase;
import deepnnet2.activation_functions.ActivationFunctions;

public class Layer
{
	public final int WIDTH;
	public int NEXT_WIDTH = 0;
	public final ActivationFunctionBase ACTIVATION_FUNCTION;

	private double[][] weights;
	private double[] outputVector;

	public Layer(int width, ActivationFunctionBase activationFunction)
	{
		this.WIDTH = width;
		this.ACTIVATION_FUNCTION = activationFunction;
	}

	public void setNextWidth(int nextWidth)
	{
		this.NEXT_WIDTH = nextWidth;

		this.weights = new double[this.WIDTH][this.NEXT_WIDTH];
		this.outputVector = new double[this.NEXT_WIDTH];

		for(int i=0; i<WIDTH; i++)
			for(int j=0; j<NEXT_WIDTH; j++)
				this.weights[i][j] = 0;
	}

	public double[] runLayerFeedForward(double[] inputVector)
	{
		if(this.ACTIVATION_FUNCTION != ActivationFunctions.OUTPUT)
		{
			for(int j=0; j<NEXT_WIDTH; j++)
			{
				double weightedSum = 0;

				for(int i=0; i<WIDTH; i++)
				{
					weightedSum += this.weights[i][j] * inputVector[i];
				}

				this.outputVector[j] = this.ACTIVATION_FUNCTION.f(weightedSum);
			}
		}
		else
		{
			System.arraycopy(inputVector, 0, this.outputVector, 0, NEXT_WIDTH);
		}

		return outputVector;
	}

	public double[] runLayerBackpropagation(double[] delta)
	{
		return null;
	}
}
