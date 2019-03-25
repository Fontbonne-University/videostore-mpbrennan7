import org.junit.Before;

import junit.framework.*;






public class VideoStoreTest extends TestCase

{
	private static final double DELTA = .001;
	private Statement statement;
	private Movie newReleaseMovie1;
	private Movie newReleaseMovie2;
	Movie childrensMovie;
	Movie regular1;
	private Movie regular2;
	private Movie regular3;
	
	
	@Before
	public void setUp ()  {
		statement = new Statement ("Customer");
		newReleaseMovie1 = new Movie ("New Release 1", Movie.NEW_RELEASE);
		newReleaseMovie2 = new Movie ("New Release 2", Movie.NEW_RELEASE);
		childrensMovie = new Movie("Childrens", Movie.CHILDRENS);
		regular1 = new Movie ("Regular 1", Movie.REGULAR);
		regular2 = new Movie ("Regular 2", Movie.REGULAR);
		regular3 = new Movie ("Regular 3", Movie.REGULAR);
	}
	
	public void testSingleNewReleaseStatementTotals () {
		statement.addRental (new Rental (newReleaseMovie1, 3));		
		statement.generate();
		assertEquals(9.0,statement.getTotal(), DELTA);
		assertEquals(2,statement.getFrequentRenterPoints());
	}

	public void testDualNewReleaseStatementTotals () {
		statement.addRental (new Rental (newReleaseMovie1, 3));
		statement.addRental (new Rental (newReleaseMovie2, 3));
		
		statement.generate();
		assertEquals(18.0,statement.getTotal(), DELTA);
		assertEquals(4,statement.getFrequentRenterPoints());
	}

	public void testSingleChildrensStatementTotals () {		
		statement.addRental (new Rental (childrensMovie, 3));
		statement.generate();
		assertEquals(1.5,statement.getTotal(), DELTA);
		assertEquals(1,statement.getFrequentRenterPoints());
	}
	
	public void testMultipleRegularStatementTotals () {
		
		statement.addRental (new Rental (regular1, 1));
		statement.addRental (new Rental (regular2, 2));
		statement.addRental (new Rental (regular3, 3));
		
		
		statement.generate();
		assertEquals(7.5,statement.getTotal(), DELTA);
		assertEquals(3,statement.getFrequentRenterPoints());
	}
	
	public void testMultipleRegularStatementFormat () {
		statement.addRental (new Rental (regular1, 1));
		statement.addRental (new Rental (regular2, 2));
		statement.addRental (new Rental (regular3, 3));
		
		assertEquals ("Rental Record for Customer\n\t"
				+ "Regular 1\t2.0\n\t"
				+ "Regular 2\t2.0\n\t"
				+ "Regular 3\t3.5\n"
				+ "You owed 7.5\n"
				+ "You earned 3 frequent renter points\n", statement.generate ());
	}

	
}