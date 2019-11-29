public class Gold extends Account {

	
	public Gold (Customer customer, int accountNumber, float balance, int transaction) {
		super (customer, accountNumber, balance, transaction);
}

	public void setMonthlyEnd(float monthlyEnd) {
		this.monthlyEnd = monthlyEnd;
	}
	
	public float getMonthlyEnd() {
		return (balance * 1.05f);
	}
	
}