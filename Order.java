

	public class Order {
		private String waiter_name;
		private int no_customer;
		private int ID;
		private String order_item[];
		private int no_order;
		private int no_item;
		private int no_of_table;
		private int[] no_item_array;
		private int status ; 
		
		public Order(String waiter_name, int no_customer, int ID, String[] order_item, int no_order, int no_item, int no_of_table, int[] no_item_array, int status) {
			this.waiter_name= waiter_name;
			this.no_customer=no_customer;
			this.order_item=order_item;
			this.no_item=no_item;
			this.no_item_array=no_item_array;
			this.status=status;
		}
		public String getwaiter_name() {
			return waiter_name;
		}
		public void setname(String waiter_name) {
			this.waiter_name = waiter_name;
		}

		public int getno_customer() {
			return no_customer;
		}

		public void setno_customer(int no_customer) {
			this.no_customer = no_customer;
		}
		public int getID() {
			return ID;
		}

		public void setID(int ID) {
			this.ID = ID;
		}
		public String[] getorder_item() {
			return order_item;
		}

		public void setorder_item(String[] order_item) {
			this.order_item = order_item;
		}
		public int getno_order() {
			return no_order;
		}

		public void setno_order(int no_order) {
			this.no_order = no_order;
		}
		public int getno_item() {
			return no_item;
		}

		public void setno_item(int no_item) {
			this.no_item = no_item;
		}
		public int getno_of_table() {
			return no_of_table;
		}

		public void setno_of_table(int no_of_table) {
			this.no_of_table = no_of_table;
		}
		public int[] getno_item_array() {
			return no_item_array;
		}

		public void setno_item_array(int[] no_item_array) {
			this.no_item_array = no_item_array;
		}
		public int getstatus() {
			return status;
		}

		public void setstatus(int status) {
			this.status = status;
		}
	}
