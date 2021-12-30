package deepnnet2;

import deepnnet2.activation_functions.ActivationFunctionBase;
import deepnnet2.activation_functions.ActivationFunctions;
import deepnnet2.layers.Layer;

import java.util.ArrayList;

public class NeuralNet
{
	private final ArrayList<Layer> layers = new ArrayList<>();

	public NeuralNet NeuralNet()
	{
		return this;
	}

	public NeuralNet addLayer(int width, ActivationFunctionBase activationFunction)
	{
		this.layers.add(new Layer(width, activationFunction));

		if(this.layers.size() > 1)
			this.layers.get(this.layers.size() - 2).setNextWidth(width);

		if(activationFunction == ActivationFunctions.OUTPUT)
			this.layers.get(this.layers.size() - 1).setNextWidth(width);

		return this;
	}

	public double[] runFeedForward(double[] inputVector)
	{
		for(Layer layer : this.layers)
			inputVector = layer.runLayerFeedForward(inputVector);

		return inputVector;
	}

	public void runBackpropagation(double[] desiredOutputVector)
	{

	}

	public int size()
	{
		return this.layers.size();
	}

	public Layer getLayer(int index)
	{
		return this.layers.get(index);
	}
}
