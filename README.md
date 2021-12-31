# DeepNNet v2

## About DNNv2
Modulable deep neural networks and pre-processing layers. DNNv2 is written in Java for possible future contribution to [OpenSteve].

[OpenSteve]: https://github.com/MattMattL/OpenSteve

## Current Progress

- TensorFlow-style layer initialisation for fully connected layers:
``` Java
NeuralNet nnet = new NeuralNet();

nnet.addLayers(
        Layer.newLayer(9, Activations.SIGMOID),
        Layer.newLayer(7, Activations.RELU),
        Layer.newLayer(4, Activations.OUTPUT)
);
```
- Backpropagation algorithm with O(depth), O(width^2)
