public class Rental
{
	
	public Rental (Movie movie, int daysRented) {
		this.movie 		= movie;
		this.daysRented = daysRented;
	}
	
	public int getDaysRented () {
		return daysRented;
	}
	
	public Movie getMovie () {
		return movie;
	}
	
	private Movie movie;
	private int daysRented;
	public String getTitle() {
		// TODO Auto-generated method stub
		return movie.getTitle();
	}

	public double determineAmount() {
		return movie.determineAmount(daysRented);
	}
	
	int determineFrequentRenterPoints() {
		return movie.determineFrequentRenterPoints(daysRented);
	}
}