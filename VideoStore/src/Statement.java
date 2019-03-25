import java.util.Vector;
import java.util.List;
import java.util.ArrayList;
import java.util.Enumeration;

public class Statement 
{
	
	private String customerName;
	private List<Rental> rentals = new ArrayList<Rental>();
	double totalAmount;
	int	frequentRenterPoints;
	public Statement (String customerName) {
		this.customerName = customerName;
	}
	
	public void addRental (Rental rental) {
		rentals.add(rental);
	}
	
	public String getName () {
		return customerName;
	}
	
	public String generate () {
		clearTotals();
		String statementText = header();
		statementText += rentalLines();
		statementText += footer();
		return statementText;
	}

	private void clearTotals() {
		totalAmount = 0;
		frequentRenterPoints = 0;
	}
	
	private String header() {
		return String.format("Rental Record for %s\n", customerName);
	}

	private String rentalLines() {
		String rentalLines ="";
		for(Rental rental : rentals) {
			rentalLines += rentalLine(rental);
				
		}
		return rentalLines;
	}

	private String rentalLine(Rental rental) {
		String rentalLine = "";
		double rentalAmount = rental.determineAmount();
		frequentRenterPoints += rental.determineFrequentRenterPoints();
		totalAmount += rentalAmount;	
		rentalLine += formatRentalLine(rental, rentalAmount);
		return rentalLine;
	}

	private String formatRentalLine(Rental rental, double rentalAmount) {
		
		return String.format("\t%s\t%.1f\n", rental.getTitle(), rentalAmount);
	}

	
	
	
	
	private String footer() {
		return String.format("You owed %.1f\n"
				+ "You earned %d frequent renter points\n"
				,totalAmount,frequentRenterPoints);
	}

	public double getTotal() {
		// TODO Auto-generated method stub
		return totalAmount;
	}

	public int getFrequentRenterPoints() {
		// TODO Auto-generated method stub
		return frequentRenterPoints;
	}


	

}