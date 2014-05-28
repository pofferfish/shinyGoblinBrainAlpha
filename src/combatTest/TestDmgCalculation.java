/**
 * 
 */
package combatTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import combat.DmgCalculation;

import characters.Creature.TypeOfDamage;

/**
 * @author Pofferfish
 *
 */
public class TestDmgCalculation {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link combat.DmgCalculation#damageCalculator(int, int, int, int, characters.Creature.TypeOfDamage)}.
	 */
	@Test
	public void testDamageCalculator() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link combat.DmgCalculation#physicalVsArmour(int, int)}.
	 */
	@Test
	public void testPhysicalVsArmour() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link combat.DmgCalculation#calculatArmorTen(int)}.
	 */
	@Test
	public void testCalculatArmorTen() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link combat.DmgCalculation#calculatArmorThirty(int)}.
	 */
	@Test
	public void testCalculatArmorThirty() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link combat.DmgCalculation#calculatArmorSixty(int)}.
	 */
	@Test
	public void testCalculatArmorSixty() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link combat.DmgCalculation#calculatArmorHundredTwenty(int)}.
	 */
	@Test
	public void testCalculatArmorHundredTwenty() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link combat.DmgCalculation#calculatArmorTwoHundredTwenty(int)}.
	 */
	@Test
	public void testCalculatArmorTwoHundredTwenty() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link combat.DmgCalculation#calculatArmorTreHundredTwenty(int)}.
	 */
	@Test
	public void testCalculatArmorTreHundredTwenty() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link combat.DmgCalculation#calculatArmorFiveHundred(int)}.
	 */
	@Test
	public void testCalculatArmorFiveHundred() {
		int temp[] = DmgCalculation.damageCalculator(100, 100, 500, 10, TypeOfDamage.MAGICDMG);
		System.out.println("" + temp[0]);
		assertTrue(temp[0] == 25);
	}

	/**
	 * Test method for {@link combat.DmgCalculation#magicVsMagicRes(int, int)}.
	 */
	@Test
	public void testMagicVsMagicRes() {
		fail("Not yet implemented");
	}

}
