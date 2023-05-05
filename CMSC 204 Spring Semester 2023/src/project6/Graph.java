package project6;

/*
 * Create a Graph class that implements the GraphInterface given to you. For Graph<V,E>, V is the vertex type (a Town), E is the edge type (a Road).
 * You will need to decide how to store the graph: use an adjacent matrix or an adjacency list.
 */
public class Graph implements GraphInterface<Town, Road> {

	/*
	 * Within the Graph interface is a method shortestPath, which finds the shortest path from a given source Town toa destination Town.
	 * Since there is a unique shorterst path from every vertex to the source, there is a back-pointer to the previous vertex. The method
	 * shortestPath calls dijkstraShortestPath which finds the shortest path form the source to every other vertex in the graph.
	 * You will be coding the Dijkstra's Shortest Path algorithm. You will then be able to find the connections between two towns through the roads that connect them.
	 * 
	 * You may use the adjacency matrix approach found in the text book, or you may use a set of Towns and a set of Roads. The ShortestPath algorithm typiclaly
	 * uses a weighted graph which means that the edges have a weight, and this is used to determine the shortest path. For this implementation, each weight wwill
	 * be the distance of the road in miles.
	 */
	
}
