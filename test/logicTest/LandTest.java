package logicTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import logic.Land;

public class LandTest {
	@Test
	public void constructorTest() {
		Land land = new Land("HOME", 100);
		assertEquals(land.getName(), "HOME");
		assertEquals(land.getPrice(), 100);
	}
}
