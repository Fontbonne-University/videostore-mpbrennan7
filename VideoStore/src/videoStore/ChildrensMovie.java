package videoStore;

public class ChildrensMovie extends Movie {

	public ChildrensMovie(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public double determineAmount(int daysRented) {
		double rentalAmount  =  0;
		
		rentalAmount += 1.5;
		if (daysRented > 3)
			rentalAmount += (daysRented - 3) * 1.5;
				
		return rentalAmount;
	}

	int determineFrequentRenterPoints(int daysRented) {
		return 1;
	}

}
