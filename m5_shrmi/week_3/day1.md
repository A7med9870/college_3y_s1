Machine learning methodology
Errors
Bias and variance

what are we trying to achieve
take a sample of data
use it to build a model a capable of making inferences about new data
compare several different models to find the best one
test how well that single best model , best model performs on data that was not used to build it
we want a model that can generalize well

ML method
split off a test set before you do anything else
use validation data to compare various approaches from the following:
    clean and pre-process the data training data (record what you did so you can do the same to the test data)
    train various different types and configs of models
train the best configuration on all the training data
test the one model on the test data - report these results

leave test data, but keep the results saved


errors and accuracy
data mining models are estimates of some aspect of the real world
they make inferences from data which are best considered as educated guesses
predicting the future or identifying an object cannot be done with perfect accuracy

what is an error
in classification tasks, labeling an input pattern as belonging to the wrong class
in a regression task, the distance between the predicted output and 'reality'
they are not mistake, or coding errors and, to an extent, are not to be fixed
Reality has natural variation and samples are limited

samples and populations
however your data is collected, it is most likely to be a sample
there will be many other data points in the population that you can't measure
natural variance in the data means your sample will be different form others that might just be ---

modelling the sample
any model built from a ample will be a model of that sample. not the full population
another model from another sample might be different
there are great many possible different samples
so there are a great many different possible models

train, validate, test
we separate

sources of errors
natural noises or unexplained variation
effects of having only a sample
the ability of the model you have chosen to model the data

bias/ variance
across all the possible models, there are two sources of errors
bias- difference between the average prediction and correct value
variance - variability across all the models from the different possible samples


bias variance trade-off
a model that is simpler than the target function will have higher bias but lower variance
extreme example: always predict g(x) = 0
bias is high (average of 0 - f(X))
variance is zero - always same answer regardless of data

bias variance trade-off
a model that is more complex than the true model will have high variance but low bias
extreme ex: interpolate every training point
bias is very low (on training
variance is very high as each model trained on different subset of data will join dots

sources of bias
model bias is the bias due to a model being unable to cap the desired function
eg alinear model of x2 (that small up left 2) will have model bias
estimation bias is the bias due to a difference between the estimated values of the model parameters and their unbiased values
for ex, OLS gives an unbiased estimate of the simple linear regression parameters

adding bias
other estimators

bias is the difference between in and out
variance is like avg

sources of variance
two models trained on 2 different subsets of the training data may differ
also , 2 different neural networks trained on the SAME data may differ due to random starting weight
also 2models of different complexity may differ
finally, 2 models trained with different algorithms or hyper parameters may differ

Ensembles
rather than build a single model, build a set of them
    train on different subset s of data
    or use different parameters when learning
    or even mix different methods
then when making predictions, make one for every models and take an advantage
