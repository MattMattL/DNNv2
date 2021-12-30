# DeepNNet v2

## About DNNv2
A modulable deep neural networks and pre-processing layers. This is written in Java for possible future use for [OpenSteve].

[OpenSteve]: https://github.com/MattMattL/OpenSteve

## Current Progress

- TensorFlow-style layer initialisations:
``` Java
NeuralNet nnet = new NeuralNet();

nnet.addLayers(
        Layer.newLayer(9, Activations.SIGMOID),
        Layer.newLayer(7, Activations.RELU),
        Layer.newLayer(4, Activations.OUTPUT)
);
```
