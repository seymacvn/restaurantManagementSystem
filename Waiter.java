

	public class Waiter {
		private String waiter_name;
		private int salary;
		private int no_of_table;
		public Waiter(String waiter_name, int salary, int no_of_table) {
			this.waiter_name= waiter_name;
			this.salary=salary;
			this.no_of_table= no_of_table;
		}
		public String getwaiter_name() {
			return waiter_name;
		}

		public void setwaiter_name(String waiter_name) {
			this.waiter_name = waiter_name;
		}

		public int getsalary() {
			return salary;
		}

		public void setsalary(int salary) {
			this.salary = salary;
		}
		public int getno_of_table() {
			return no_of_table;
		}

		public void setno_of_table(int no_of_table) {
			this.no_of_table = no_of_table;
		}
	}

