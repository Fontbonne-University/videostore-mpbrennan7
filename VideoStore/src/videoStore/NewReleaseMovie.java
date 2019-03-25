package videoStore;

public class NewReleaseMovie extends Movie {
	public NewReleaseMovie(String title) {
		super(title);
	}

	public double determineAmount(int daysRented) {
		return daysRented * 3;
	}

	int determineFrequentRenterPoints(int daysRented) {
		if (daysRented>1)
			return 2;
		return 1;
	}
}
