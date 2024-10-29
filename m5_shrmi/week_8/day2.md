4 of nov
formative assemtnet
bussniness understanding
data understanding


distance
distance_long
operation_mode
angle_sum
NDepDep
NDepArr
NArrDep
NArrArr
Pressure
VisibilityInMeters
isRain
isSnow
flightNumber
airline
aircraftModel
AvgSpdLast10
TaxiTime

depArr is the state of the plance, wather was not moving before the plane

distance, is an important and self explanatory variable

operation_mode is unrelated data filed, where it’s really not contributing to the final results and can ignored

angle_sum is the rotations the air plane had to rotate, with the sum meaning the all rotations it did combined

NedpDep

distance
in the distance catagroy, the highest distance is over 3400, but barely any planes are moving that long of a distance; with the distance around 1800-1900 being the highest average of distance that normally planes go through

distance_long
in distance long, there are number of entries that are for really short range of movement, just under 100; then the average is around 1400-1500, then there is a werid gap between 100 towards 500; where there is no entries are being registered

operation_mode

angle_sum
in angle_sum, there is a number of planes that had to move , some are under or around under 100 sum of rotations; they are under 0.2% registered entries
then there is the average being 525-550 with total of 10.06% of total entries in the data

NDepDep

NDepArr

NArrDep

NArrArr
the planes that were moving, when the registered entire was put in the sheet, then divvied by in the arrivals and departures

Pressure
the pressure means the number of traffic on the airport, with many planes in and out, in the set of data highest average of pressure is 30.2-30.225 in busy days; with the lowest average is 29.65-29.675 in lowest traffic, meaning the differences between the 2 times aren’t that much

VisibilityInMeters

isRain
is the state of the weather, if the plane was moving along the strip; if it was raining, this variable will be set to 1 or true

isSnow
weather it was Snowing or not, in the time the plane was on the airport stirp and moving

flightNumber
the registered flight number, for what’s that plane did in the system and it did move; it’s the normally the number code that you would see people refer to a plane crash

airline
what was the type of plane, normally known by it’s company

aircraftModel
the type of the aircarft, think of it; like the cars world, where 1 means it means the best class, but it also could be refered by codes of numbers and numbers

AvgSpdLast10
the average speed for the last 10 planes before the registered entry

TaxiTime
it the target we want to achieve, for the plane to reach it’s destination


have a look at in feature stats
write any notes about any changes to training data you made

split train data and test data
only on train data, data clean

outlier like in practical one
with m and male, when they should be one
or f and female, when they should be one row

flight nmber doesn’t really matar

3 models use