package project6;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TownGraphManager_STUDENT_Test {

	private TownGraphManagerInterface graph;
	private String[] towns = {"Poolesville", "Clarksburg", "Frederick", "Germantown", "Gaithersburg", "Olney"};
	  
	@Before
	public void setUp() throws Exception {
		  graph = new TownGraphManager();
		  
		  for (int i = 0; i < towns.length; i++)
			  graph.addTown(towns[i]);
		  
		  graph.addRoad(towns[0], towns[1], 13, "MD109");
		  graph.addRoad(towns[1], towns[2], 14, "I270N");
		  graph.addRoad(towns[1], towns[3], 5, "I270-NC");
		  graph.addRoad(towns[3], towns[4], 6, "I270-C");
		  graph.addRoad(towns[1], towns[5], 14, "MD108");
		  graph.addRoad(towns[3], towns[5], 15, "MD118E");
		 
	}

	@After
	public void tearDown() throws Exception {
		graph = null;
	}
	
	@Test
	public void testAddRoad() {
		ArrayList<String> roads = graph.allRoads();
		assertEquals("I270-C", roads.get(0));
		assertEquals("I270-NC", roads.get(1));
		assertEquals("I270N", roads.get(2));
		assertEquals("MD108", roads.get(3));
		graph.addRoad(towns[4], towns[5], 11, "Bowie Mill");
		roads = graph.allRoads();
		assertEquals("I270-C", roads.get(1));
		assertEquals("I270-NC", roads.get(2));
		assertEquals("I270N", roads.get(3));
		assertEquals("MD108", roads.get(4));
		assertEquals("Bowie Mill", roads.get(0));
		
	}

	@Test
	public void testGetRoad() {
		assertEquals("MD109", graph.getRoad(towns[0], towns[1]));
		assertEquals("MD118E", graph.getRoad(towns[3], towns[5]));
	}

	@Test
	public void testAddTown() {
		assertEquals(false, graph.containsTown("Potomac"));
		graph.addTown("Potomac");
		assertEquals(true, graph.containsTown("Potomac"));
	}

	@Test
	public void testDisjointGraph() {
		assertEquals(false, graph.containsTown("Potomac"));
		graph.addTown("Potomac");
		ArrayList<String> path = graph.getPath(towns[4], "Potomac");
		assertFalse(path.size() > 0);
	}

	//no getTown test needed because it and containsTown are essentially the same method
	@Test
	public void testContainsTown() {
		assertEquals(true, graph.containsTown("Germantown"));
		assertEquals(false, graph.containsTown("Potomac"));
	}
	
	@Test
	public void testContainsRoadConnection() {
		assertEquals(true, graph.containsRoadConnection(towns[1], towns[3]));
		assertEquals(false, graph.containsRoadConnection(towns[0], towns[2]));
	}

	@Test
	public void testAllRoads() {
		ArrayList<String> roads = graph.allRoads();
		assertEquals("I270-C", roads.get(0));
		assertEquals("I270-NC", roads.get(1));
		assertEquals("I270N", roads.get(2));
		assertEquals("MD109", roads.get(4));
		assertEquals("MD118E", roads.get(5));
	}

	@Test
	public void testDeleteRoadConnection() {
		assertEquals(true, graph.containsRoadConnection(towns[0], towns[1]));
		graph.deleteRoadConnection(towns[0], towns[1], "MD109");
		assertEquals(false, graph.containsRoadConnection(towns[0], towns[1]));
	}

	@Test
	public void testDeleteTown() {
		assertEquals(true, graph.containsTown("Clarksburg"));
		graph.deleteTown(towns[1]);
		assertEquals(false, graph.containsTown("Clarksburg"));
	}

	@Test
	public void testAllTowns() {
		ArrayList<String> roads = graph.allTowns();
		assertEquals("Clarksburg", roads.get(0));
		assertEquals("Frederick", roads.get(1));
		assertEquals("Gaithersburg", roads.get(2));
		assertEquals("Germantown", roads.get(3));
		assertEquals("Poolesville", roads.get(5));
	}

	@Test
	public void testGetPath() {
		ArrayList<String> path = graph.getPath(towns[0],towns[4]);
		  assertNotNull(path);
		  assertTrue(path.size() > 0);
		  assertEquals("Poolesville via MD109 to Clarksburg 13 mi",path.get(0).trim());
		  assertEquals("Clarksburg via I270-NC to Germantown 5 mi",path.get(1).trim());
		  assertEquals("Germantown via I270-C to Gaithersburg 6 mi",path.get(2).trim());

	}

}
