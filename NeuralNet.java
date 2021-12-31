package deepnnet2;

import deepnnet2.activations.Activations;
import deepnnet2.layers.Layer;

import java.util.ArrayList;

public class NeuralNet
{
	private final ArrayList<Layer> layers = new ArrayList<>();

	public void addLayers(Layer... layers)
	{
		for(Layer layer : layers)
			this.layers.add(layer);

		for(int i=0; i<this.layers.size(); i++)
		{
			if(this.layers.get(i).ACTIVATION == Activations.OUTPUT)
				this.layers.get(i).setNextWidth(this.layers.get((i)).getWidth());
			else
				this.layers.get(i).setNextWidth(this.layers.get((i+1)).getWidth());
		}
	}

	public double[] runFeedForward(double[] inputVector)
	{
		for(Layer layer : this.layers)
			inputVector = layer.runLayerFeedForward(inputVector);

		return inputVector;
	}

	public void runBackpropagation(double[] desiredOutput)
	{
		double[] delta;

		delta = this.layers.get(this.layers.size() - 1).runPerformanceBackprop(desiredOutput);

		for(int i=this.layers.size()-2; i>=0; i--)
		{
			delta = this.layers.get(i).runLayerBackprop(delta);
		}
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
