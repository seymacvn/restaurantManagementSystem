

	public class Item {
		private String item_name;
		private double cost;
		private int amount;
		public Item(String name, double cost, int amount) {
			this.item_name= name;
			this.cost= cost;
			this.amount= amount;
		}
		public String getitem_name() {
			return item_name;
		}

		public void setname(String item_name) {
			this.item_name = item_name;
		}

		public double getcost() {
			return cost;
		}

		public void setcost(double cost) {
			this.cost = cost;
		}

		public int getamount() {
			return amount;
		}

		public void setamount(int amount) {
			this.amount = amount;
		}
	}

