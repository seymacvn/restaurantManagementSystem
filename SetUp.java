
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
public class SetUp {
		NumberFormat formatter = new DecimalFormat("#0.000");
		Item[] items = new Item[20];
		int i=0;
		int addItem(Item item) {
			items[i] = item;
			i++;
			return i;
		}

		Employer[] employers = new Employer[5];
		int j = 0;
	    int addEmployer(Employer employer) {
			employers[j] = employer;
			j++;		
			return j;
		}
		
		Waiter[] waiters = new Waiter[5];
		int k = 0;
		int addWaiter(Waiter waiter) {
			waiters[k] = waiter;
			k++;
			return k;
		}
		
		
		public int control(String name) {
			int b=0, c=0;
			for (int a = 0 ; a < j; a++) {
				if(name.equals(employers[a].getemployer_name())) {
					if(employers[a].getno_of_create_table()>1){
						System.out.println(employers[a].getemployer_name()+ " has already created ALLOWED_MAX_TABLES tables!");
						c=0;
						break;
					}
					else {
						employers[a].setno_of_create_table(employers[a].getno_of_create_table()+1);
						c=1;
					}
				}
				else {
					b++;
				}
			}
			if(b==j) {
				System.out.println("There is no employer named "+ name);
						c=0;
			    }
			return c;
		}

		
		Table[] tables = new Table[5];
		int l = 0;
		int addTable(Table table) {
			tables[l] = table;
			tables[l].setID(l);
			l++;
			return l;
		}
		//create table bitti
		
		public int countChar(String str, char c){
		    int count = 0;
		    for(int i=0; i < str.length(); i++) { 
		    	if(str.charAt(i) == c)
		            count++;
		    }
		    return count;
		}
		
		public int control_waiter(String name) {
			int b=0, c=0;
			for (int a = 0 ; a < j; a++) {
				if(name.equals(waiters[a].getwaiter_name())) {
					break;
				}
				else {
					b++;
				}
				}
			if(b==k) {
				System.out.println("There is no waiter named "+ name);
						c=0;
			}
			else {
				c=1;
			}
			return c;
		}
		int table_id(int no_customer) {
			int b=0 ;
			for (int a = 0 ; a < l; a++) {
					if(no_customer<=tables[a].getcapacity() && tables[a].getstatus()== 0) {
						
						tables[a].setstatus(1) ; //masay� doldurdum
						System.out.println("Table (= ID "+ tables[a].getID() +") has been taken into service");
						break;
					}
					else {
						b++;
					}
				}
			if(b==(l)) {
				System.out.println("There is no appropriate table for this order!");
				return 0;
			}
			else {
				return 1;
			}
		}
		
		int control_item(String item_item) {
			int b=0, c=0;
			for(int a=0 ; a<i ; a++) {
				if(item_item.equals(items[a].getitem_name())) {
				}
				else {
					b++;
				}
			}
			if(b==i) {
				System.out.println("There is no item named "+ item_item);
				c=0;
			}
			else {
				c=1;
			}
			return c;
		}
		
		int new_order(String item_item) {
			int c=0;
			for(int a=0 ; a<i ; a++) {
				if(item_item.equals(items[a].getitem_name())) {
					if(items[a].getamount()>0) {
						System.out.println("Item "+items[a].getitem_name() +" added into order");
						items[a].setamount(items[a].getamount()-1) ; 
						c = 1;
						return c;
					}
					else if(items[a].getamount()==0) {
						System.out.println("Sorry! No "+items[a].getitem_name()+" in the stock!");
						c = 0;
						return c;
					}
				}
			}
			return c;
		}
		
		
		Order[] orders = new Order[10];
		int m = 0;
		int addOrder(Order order) {
			orders[m] = order;
			orders[m].setno_order(orders[m].getno_order()+1);
			orders[m].setno_of_table(orders[m].getno_of_table()+1);
			//System.out.println("*** "+ orders[m].getno_order() + "--- "+ orders[m].getwaiter_name());
			orders[m].setID(m);
			m++;
			return m;
		}				
		
		void stock_status() {
			for(int a =0; a<i ; a++) {
				System.out.printf(items[a].getitem_name()+":	"+ items[a].getamount()+"\n");
			}	
		}			
		void get_table_status() {	
			Object status = null;
			String name = null;
			for(int a =0; a<l ; a++) {
				if(tables[a].getstatus()==0) {
					 status= "Free";
				}
				else if(tables[a].getstatus()==1){
					int b=tables[a].getID();
					for(int c=0 ; c < m ;c++) {
						if(b==orders[c].getID()) {
							name= orders[c].getwaiter_name();
						}
					}
					 status="Reserved (" + name +")";
				}
				System.out.printf("Table "+ tables[a].getID()+": "+ status+"\n");
			}	
		}
		int b=0;
		int control_waiter(String add_name, int add_id) {
			for(int a=0 ; a<m ; a++) {
				if(add_name.equals(orders[a].getwaiter_name()) && add_id==orders[a].getID()) {
					orders[a].setno_order(orders[a].getno_order()+1);
					orders[a].setno_of_table(orders[a].getno_of_table()+1);
					break;
					
				}
				else {
					b++;
				}
			}
			
			if(b==m) {
				System.out.println("This table is either not in service now or "+add_name+" cannot be\r\n"+
						" assigned this table!");
				return 0;
			}
			else {
				return 1;
			}
		}
		
		int add_order(String item_item, String[] news_order, int count) {
			int c=0 , b=0;
			for(int a=0 ; a<i ; a++) {
				if(item_item.equals(items[a].getitem_name())) {
					if(items[a].getamount()>0) {
						news_order[count] = items[a].getitem_name();
						System.out.println("Item "+items[a].getitem_name() +" added into order");
						items[a].setamount(items[a].getamount()-1) ;
						c=1;
						return c;
					}
					else if(items[a].getamount()==0) {
						System.out.println("Sorry! No "+items[a].getitem_name()+" in the stock!");
						c=0;
						return c;
					}
				}
				else {
					b++;
				}
			}
			if( b== i) {
				System.out.println("There is no item named "+ item_item);
				c=0;
				return c;
			}
			else {
				return c;
			}
		}
		
		void concatt(String[] news_order, String add_name, int add_id, int no_item_add, int [] no_item_add_array) {
			for(int a = 0; a < m; a++) {
				if(orders[a].getwaiter_name().equals(add_name) && orders[a].getID()==add_id) {
					String[] result= new String[no_item_add+ orders[a].getno_item()];
					int[] result2= new int[orders[a].getno_order()];
					System.arraycopy(orders[a].getorder_item(), 0, result, 0, orders[a].getno_item()+1);
			        System.arraycopy(news_order, 0, result,orders[a].getno_item() , no_item_add);
			        System.arraycopy(orders[a].getno_item_array(), 0, result2, 0, orders[a].getno_order()-1);
			        System.arraycopy(no_item_add_array, 0, result2, orders[a].getno_order() -1, 1);
			        for(int b=0; b <( orders[a].getno_item() + no_item_add ) ; b++ ) {
			        	orders[a].getorder_item()[b] = result[b];
			        }
			        for(int b=0; b <( orders[a].getno_order()) ; b++ ) {
			        	orders[a].getno_item_array()[b] = result2[b];
			        }
			       
			        orders[a].setno_item(orders[a].getno_item() + no_item_add); 
			     }
			}
		}
		
		void get_employer_salary() {
			for( int a=0 ; a<j ; a++) {
				double salary=(( employers[a].getsalary() * employers[a].getno_of_create_table()) /10) + employers[a].getsalary();
				System.out.printf("Salary for "+ employers[a].getemployer_name()+":"+" " +salary+"\n");

			}	
		}
		
		void get_waiter_salary() {
			for( int a=0 ; a<k ; a++) {
				int number = waiter_table_no(waiters[a].getwaiter_name());
				double salary=(( waiters[a].getsalary() * number) /20) + waiters[a].getsalary();
				System.out.printf("Salary for "+ waiters[a].getwaiter_name()+":"+" "+ +salary+"\n");

			}		
		}		
		 int s=0 ,len , c=0 ;
		 int waiter_table_no(String name) {
			 c=0;
			 for(int a=0 ; a<m ; a++) {
				 if(name.equals(orders[a].getwaiter_name())){
					  c = c + orders[a].getno_order();
				 }
				 else {
					 len++;
				 }
			 }
			 if(len==m) {
				 return 0;
			 }
			 else {
				 return c;
			 }
		 }
		
		 
		 void get_order_status() {
			 for(int a =0; a < m ; a++) {
				 if(orders[a].getstatus()==1) {
				 System.out.println("Table: "+ orders[a].getID());
				 System.out.println("	"+ orders[a].getno_order() + " order(s)");
				 for(int b=0 ; b< orders[a].getno_order() ; b++) {
					 System.out.println("		"+orders[a].getno_item_array()[b] +" item(s)");
					 
				 }
			   }
				if(orders[a].getstatus() == 0) {
					 System.out.println("Table: "+ orders[a].getID());
					 System.out.println("	0 order(s)");
				 }
			 }
		 }
		int b1=0;
		int check_control( String name, int id) {
			for (int a =0 ; a<m ; a++) {
				if(id > orders[m-1].getID()) {
					System.out.println("This table is either not in service now or "+ name +" cannot be\r\n" + 
							"assigned this table!");
							return 0;
				}
				else if(orders[a].getwaiter_name().equals(name) && id != orders[a].getID()) {
					System.out.println("This table is either not in service now or "+ name +" cannot be\r\n" + 
							"assigned this table!");
							return 0;		
				}
				else if(orders[a].getwaiter_name().equals(name) && id == orders[a].getID()) {
					return 1 ;
				}
				else if((!orders[a].getwaiter_name().equals(name)) && id != orders[a].getID()){
					 b1++;
				}
			}
			if(b1==m) {
				System.out.println("There is no waiter named "+ name);
				return 0;
			}
			else {
				return 1;
			}
		}
		 
		void check_out(String name, int id) {
			double total=0;
			for(int a =0; a<m ; a++) {
				if(name.equals(orders[a].getwaiter_name()) && id== orders[a].getID()) {
					for(int b=0; b<i ; b++) {
						for(int c=0; c<orders[a].getno_item() ; c++) {
							if(items[b].getitem_name().equals(orders[a].getorder_item()[c])) {
								orders[a].setstatus(0);
						        int freq = Collections.frequency(Arrays.asList(orders[a].getorder_item()), items[b].getitem_name()); 
						        double hsp= (double) (freq*items[b].getcost());
						        System.out.println(items[b].getitem_name()+":	"+formatter.format(items[b].getcost())+" (x "+freq+") "+ formatter.format(hsp)+ " $");
						        total = total + hsp;
								break;
							}
						}
					}	
				}
			}
			System.out.println("Total:	"+formatter.format(total)+" $");
			for (int b=0 ; b<l ; b++) {
				if(id== tables[b].getID()) {
					tables[b].setstatus(0);
					
					break;
				}
			}

		}
	}








