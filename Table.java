

	public class Table {
		private String name;
		private int capacity;
		private int ID;
		private int status;
		public Table(String name, int capacity,int ID,int status) {
			this.name= name;
			this.capacity=capacity;
			this.ID=ID;
		}
		public String getname() {
			return name;
		}
		public void setname(String name) {
			this.name = name;
		}

		public int getcapacity() {
			return capacity;
		}

		public void setcapacity(int capacity) {
			this.capacity = capacity;
		}
		public int getID() {
			return ID;
		}

		public void setID(int ID) {
			this.ID = ID;
		}
		public int getstatus() {
			return status;
		}
		public void setstatus(int status) {
			this.status = status;
		}

	}
