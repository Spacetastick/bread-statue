//Noah Cil, JUnit Lab for CMSC 204 Spring 23 

package junitLab;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradebookTester {

	private GradeBook book1, book2;
	
	@BeforeEach
	void setUp() throws Exception {
		book1 = new GradeBook(5);
		book2 = new GradeBook(5);
		
		book1.addScore(10);
		book1.addScore(20);
		
		book2.addScore(30);
		book2.addScore(40);
		book2.addScore(50);
	}

	@AfterEach
	void tearDown() throws Exception {
		book1 = null;
		book2 = null;
	}

	@Test
	void testAddScore() {
		assertTrue("10.0 20.0 ".equals(book1.toString()));
		assertTrue("30.0 40.0 50.0 ".equals(book2.toString()));
		
		assertEquals(2, book1.getScoreSize());
		assertEquals(3, book2.getScoreSize());
	}

	@Test
	void testSum() {
		assertEquals(30, book1.sum());
		assertEquals(120, book2.sum());
	}

	@Test
	void testMinimum() {
		assertEquals(10, book1.minimum());
		assertEquals(30, book2.minimum());
	}

	@Test
	void testFinalScore() {
		assertEquals(20, book1.finalScore());
		assertEquals(90, book2.finalScore());
	}
}