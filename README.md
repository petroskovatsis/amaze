# Amaze
This is the mini project (assignment) regarding the implementation of a solution to search for a path in a 2D array.
The solution must find a route to link the start and goal point in a 2D array. The points are not know beforehand.
There might also be blocking points that the solution must avoid.
For the best approach, the Breadth First Search and Depth First Search algorithms have been implemented.
Find bellow the instructions on how to build, test and run the solution. Cheers!

### Test
```
mvn test
```

### Build

* Build with maven
```
mvn clean install
```

### Run

* Command line
```
java -jar target/amaze-<VERSION>.jar <ALGORITHM> <PATH_TO_MAZE>
```

* You may use either BFS or DFS algorithm to traverse the array.

* Example (Using windows... Shit Happens)
```
java -jar .\target\amaze-1.0-SNAPSHOT.jar BFS .\resources\maze0.txt
```
