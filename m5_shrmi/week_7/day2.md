clustering algorithms
organised data into a number of distinct groups (clusters) according to the similarity of their members sand their differences from other clusters
take a new data point and assign it to one of the clusters (or, possibly, to none of them)

distance
clustering is usually based on the distance between data points
for numeric data, Euclidean distance is often used

more than one mean
what if we suspect that our data set is actually a number of data sets mixed together,
each one has mean value of its own
but we don't know which data point belongs to which set
clustering algorithms separate out the data and calculate the means

aim
target is to minimize the total distance between the data points and the means to which they are assigned:

k-means clustering
the k means algorithm is a well known method for clustering data by calculating the mean of each cluster
you must decide how many clusters you want (the value k)
the algorithm choses the data subsets and calculates the means to minimise the total distance from all data to their mean

how k means works
you tell it how many clusters you want it to find
it picks k different points from the data and assumes they are the centers of the clusters
it then calculates which of these clusters all the other points fall into by measuring their distance
then, it cal the avg of all the points i each cluster and that is the new center for each
repeat from 2 until no points swap clusters

DBSCAN clustering
density-based spaitial clustering of applications with nosie
based on “neighbourhoods”; points with many other points earby are dee,ed to be in one cluster
two parameters
-minPoints (nighbour req to be a core point)
-epsilon (distance to decide if points are neighbors)

K means disadv
only mesauseres the mean for each cluster tell you nothing of it’s shape

hierarchical clustering 
mini spanning tree
looks for clusters withinin clusters
cluster 1 (root) is the whole data set
that splits into a small number of subsets
each subset splits into 0 or more subsets etc

histogram
a historgram is a gui represetntiaion of req counts
for discrete var, simply count how often each possible value appears
for continuous vars, split the rnage into sub -ranges (bins) and count how many values …

practicial 4
the one in week 7
first the pdf with iris
thne
motorclaims

homework
untis

![[screenshot-20241022-114114.png]]
7 videos and summary points