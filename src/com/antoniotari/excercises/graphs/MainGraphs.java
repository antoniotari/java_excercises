package com.antoniotari.excercises.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainGraphs {

	List<Vertex> nodes;
	List<Edge> edges;
	
	public static void main(String[] args) {
		MainGraphs mainGraphs=new MainGraphs();
		mainGraphs.nodes = new ArrayList<Vertex>();
		mainGraphs.edges = new ArrayList<Edge>();
	    for (int i = 0; i < 11; i++) {
	      Vertex location = new Vertex("Node_" + i, "Node_" + i);
	      mainGraphs.nodes.add(location);
	    }

	    mainGraphs.addLane("Edge_0", 0, 1, 85);
	    mainGraphs.addLane("Edge_1", 0, 2, 217);
	    mainGraphs.addLane("Edge_2", 0, 4, 173);
	    mainGraphs.addLane("Edge_3", 2, 6, 186);
	    mainGraphs.addLane("Edge_4", 2, 7, 103);
	    mainGraphs.addLane("Edge_5", 3, 7, 183);
	    mainGraphs.addLane("Edge_6", 5, 8, 250);
	    mainGraphs.addLane("Edge_7", 8, 9, 84);
	    mainGraphs.addLane("Edge_8", 7, 9, 167);
	    mainGraphs.addLane("Edge_9", 4, 9, 502);
	    mainGraphs.addLane("Edge_10", 9, 10, 40);
	    mainGraphs.addLane("Edge_11", 1, 10, 600);

	    // Lets check from location Loc_1 to Loc_10
	    Graph graph = new Graph(mainGraphs.nodes, mainGraphs.edges);
	    DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
	    dijkstra.execute(mainGraphs.nodes.get(0));
	    LinkedList<Vertex> path = dijkstra.getPath(mainGraphs.nodes.get(10));
	    
	    for (Vertex vertex : path) {
	      System.out.println(vertex);
	    }
		  
	}
	
	private void addLane(String laneId, int sourceLocNo, int destLocNo,int duration) {
		    Edge lane = new Edge(laneId,nodes.get(sourceLocNo), nodes.get(destLocNo), duration);
		    edges.add(lane);
		  }
}
