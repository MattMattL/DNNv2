package deepnnet2.layers;

import deepnnet2.activations.ActivationBase;
import deepnnet2.activations.Activations;

public class Layer
{
	public int WIDTH = 0;
	public int NEXT_WIDTH = 0;
	public ActivationBase ACTIVATION_FUNCTION = null;

	private double[][] weights;
	private double[] outputVector;

	@Deprecated
	public Layer(int width, ActivationBase activationFunction)
	{
		this.WIDTH = width;
		this.ACTIVATION_FUNCTION = activationFunction;
	}

	public Layer()
	{

	}

	public static Layer newLayer()
	{
		return new Layer();
	}

	public static Layer newLayer(int width, ActivationBase activation)
	{
		return new Layer().setWidth(width).setActivation(activation);
	}

	public int getWidth()
	{
		return this.WIDTH;
	}

	public int getNextWidth()
	{
		return this.NEXT_WIDTH;
	}

	public Layer setWidth(int width)
	{
		if(this.WIDTH < 1)
			this.WIDTH = width;

		return this;
	}

	public Layer setNextWidth(int nextWidth)
	{
		if(this.NEXT_WIDTH > 0)
			return this;

		this.NEXT_WIDTH = nextWidth;

		this.weights = new double[this.WIDTH][this.NEXT_WIDTH];
		this.outputVector = new double[this.NEXT_WIDTH];

		for(int i=0; i<WIDTH; i++)
			for(int j=0; j<NEXT_WIDTH; j++)
				this.weights[i][j] = 0;

		return this;
	}

	public Layer setActivation(ActivationBase function)
	{
		if(this.ACTIVATION_FUNCTION == null)
			this.ACTIVATION_FUNCTION = function;

		return this;
	}

	public double[] runLayerFeedForward(double[] inputVector)
	{
		if(this.ACTIVATION_FUNCTION != Activations.OUTPUT)
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
