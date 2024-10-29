package CafeProject.cafe.project;

public class Review {
	
	private String[] reviews = {
			"Great service!",
			"My latte was cold :((",
			"Cozy environment <3",
			"Best cafe ever!!!!"
	}; 
	
	public void Reviews() {
		System.out.println("Reviews from customers:");
		for (String review : reviews) {
			System.out.println(review);
		}
	}
	
    public String[] getReviews() {
        return reviews;
    }
}