public class Regular extends Account {

	
	public Regular (Customer customer, int accountNumber, float balance, int transaction) {
		super (customer, accountNumber, balance, transaction);
}

	public void setMonthlyEnd(float monthlyEnd) {
		this.monthlyEnd = monthlyEnd;
}
	
	public float getMonthlyEnd() {
		return (balance * 1.06f) - 10;
	}
	
	
	public String toString() {
		String output = super.toString();
		
		return output;
	}
}
	