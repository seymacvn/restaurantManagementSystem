

	public class Employer {
		private String employer_name;
		private int salary;
		private int no_of_create_table;
		
		public Employer(String employer_name, int salary, int no_of_create_table) {
			this.employer_name= employer_name;
			this.salary=salary;
			this.no_of_create_table=no_of_create_table;
		}
		public String getemployer_name() {
			return employer_name;
		}

		public void setemployer_name(String employer_name) {
			this.employer_name = employer_name;
		}

		public int getsalary() {
			return salary;
		}

		public void setsalary(int salary) {
			this.salary = salary;
		}
		public int getno_of_create_table() {
			return no_of_create_table;
		}

		public void setno_of_create_table(int no_of_create_table) {
			this.no_of_create_table = no_of_create_table;
		}
	}


