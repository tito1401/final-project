public class Checking extends Account {
	
		
		public Checking (Customer customer, int accountNumber, float balance, int transaction) {
			super (customer, accountNumber, balance, transaction);
	}

		public void setMonthlyEnd (float monthlyEnd) {
			this.monthlyEnd = monthlyEnd;
		}
		
		public float getMonthlyEnd() {
			return balance * (3 * (transaction - 2 ));
		}
	
}
		
