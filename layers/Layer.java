package deepnnet2.layers;

import deepnnet2.activations.ActivationBase;
import deepnnet2.activations.Activations;

import java.util.Random;

public class Layer
{
	private int WIDTH = 0;
	private int NEXT_WIDTH = 0;
	public ActivationBase ACTIVATION = null;

	private double[][] weights;
	private double[] inputVector;
	private double[] outputVector;

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

		this.weights = new double[WIDTH][NEXT_WIDTH];
		this.outputVector = new double[NEXT_WIDTH];

		Random random = new Random(1010);

		for(int i = 0; i<WIDTH; i++)
			for(int j=0; j<NEXT_WIDTH; j++)
				this.weights[i][j] = random.nextDouble() * 2 - 1;

		return this;
	}

	public Layer setActivation(ActivationBase function)
	{
		if(this.ACTIVATION == null)
			this.ACTIVATION = function;

		return this;
	}

	public double[] runLayerFeedForward(double[] inputVector)
	{
		this.inputVector = inputVector;

		if(this.ACTIVATION != Activations.OUTPUT)
		{
			for(int j=0; j<NEXT_WIDTH; j++)
			{
				double weightedSum = 0;

				for(int i=0; i<WIDTH; i++)
					weightedSum += this.weights[i][j] * inputVector[i];

				this.outputVector[j] = this.ACTIVATION.f(weightedSum);
			}
		}
		else
		{
			System.arraycopy(inputVector, 0, this.outputVector, 0, this.WIDTH);
		}

		double[] outputCopy = new double[NEXT_WIDTH];
		System.arraycopy(this.outputVector, 0, outputCopy, 0, NEXT_WIDTH);

		return outputCopy;
	}

	public double[] runPerformanceBackprop(double[] desiredOutput)
	{
		double[] delta = new double[NEXT_WIDTH];

		for(int i=0; i<WIDTH; i++)
			delta[i] = this.ACTIVATION.performance(desiredOutput[i], this.outputVector[i]);

		return delta;
	}

	public double[] runLayerBackprop(double[] delta)
	{
		double[] nextDelta = new double[WIDTH];

		for(int i=0; i<WIDTH; i++)
		{
			for(int j=0; j<NEXT_WIDTH; j++)
			{
				nextDelta[i] += delta[j] * this.weights[i][j] * this.ACTIVATION.dfdx(this.outputVector[j]);
			}
		}

		for(int i=0; i<WIDTH; i++)
		{
			for(int j=0; j<NEXT_WIDTH; j++)
			{
				this.weights[i][j] -= delta[j] * this.inputVector[i];
			}
		}

		return nextDelta;
	}
}
