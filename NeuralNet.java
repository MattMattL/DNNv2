package deepnnet2;

import deepnnet2.activation_functions.ActivationBase;
import deepnnet2.activation_functions.Activations;
import deepnnet2.layers.Layer;

import java.util.ArrayList;

public class NeuralNet
{
	private final ArrayList<Layer> layers = new ArrayList<>();

	@Deprecated
	public NeuralNet NeuralNet()
	{
		return this;
	}

	public void addLayers(Layer... layers)
	{
		for(Layer layer : layers)
			this.layers.add(layer);

		for(int i=0; i<this.layers.size(); i++)
		{
			if(this.layers.get(i).ACTIVATION_FUNCTION == Activations.OUTPUT)
				this.layers.get(i).setNextWidth(this.layers.get((i)).getWidth());
			else
				this.layers.get(i).setNextWidth(this.layers.get((i+1)).getWidth());
		}
	}


	@Deprecated
	public NeuralNet addLayer(int width, ActivationBase activationFunction)
	{
		this.layers.add(new Layer(width, activationFunction));

		if(this.layers.size() > 1)
			this.layers.get(this.layers.size() - 2).setNextWidth(width);

		if(activationFunction == Activations.OUTPUT)
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
