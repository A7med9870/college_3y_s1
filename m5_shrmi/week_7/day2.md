clustering algorithms
organised data into a number of distinct groups (clusters) according to the similarity of their members sand their differences from other clusters
take a new data poitn and assign it to one of the lcusters (or, possibly, to none of them)

distance
clustering is usally based on the distance betweeen data points
for numeric data, Eucildenan distance is often used

more than one mean
what if wwe suspect that our data set is actually a number of data sets mixed together,
each one has mean value of its own
but we dont know whcih data point belongs to which set
clustering algorithms separtate out the data and calculate the means

aim
target is to minimise the total distance between the data points and the means to which they are assigned:

k-means clustering
the k means algorithm is a well known method for clustering data by calculating the mean of each cluster
you must decide how many clusters you want (the value k)
the algorithm choses the data subsets and calculates the means to minimise the total distance from all data to their mean

