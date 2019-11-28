
import java.io.*;
import java.util.ArrayList;
import java.util.Locale;

public class Main {
	public static void main(String [] args) throws IOException {
    	Locale.setDefault(Locale.US);
    	FileInputStream fstream = new FileInputStream("setup.dat");
    	BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
    	FileInputStream stream = new FileInputStream("commands.dat");
    	BufferedReader as = new BufferedReader(new InputStreamReader(stream));
    	SetUp seyma = new SetUp();
    	int i=0, u=0, emplyr=0, wtr=0;
    	String strLine;
    	while ((strLine = br.readLine()) != null)   {
                //System.out.println("---" +strLine);
                String[] parts = strLine.split(" ");
                if(parts[0].equals("add_item")) {
                    String[] items = parts[1].split(";");
                    String item_name= items[0];
                    double cost = Double.parseDouble(items[1]);
                    int amount = Integer.parseInt(items[2]);
                    Item item1= new Item(item_name,cost,amount);
                    seyma.addItem(item1);
                    i++;
                }
                else if(parts[0].equals("add_employer")) {
                	if(emplyr < 5) {
                    String[] employerss = parts[1].split(";");
                    String employer_name= employerss[0];
                    int salary = Integer.parseInt(employerss[1]);
                    int no_of_create_table=0;
                    Employer employer1= new Employer(employer_name, salary, no_of_create_table);
                    seyma.addEmployer(employer1);
                    emplyr++;
                	}
                	else if(emplyr >= 5) {
                		System.out.println("You can create Max 5 employers.MAX_EMPLOYER"); 
                	}
                }
                else if(parts[0].equals("add_waiter")) {
                	if ( wtr< 5) {
                    String[] waiters = parts[1].split(";");
                    String waiter_name= waiters[0];
                    int salary = Integer.parseInt(waiters[1]);
                    int no_of_table= 0;
                    Waiter waiter1= new Waiter(waiter_name,salary,no_of_table);
                    seyma.addWaiter(waiter1);
                    wtr++;
                	}
                	else if(wtr>=5) {
                		System.out.println("You can create Max 5 waiters.MAX_WAÝTER");
                	}
                }
            }
       
    	String line;
    	int ide=0;
    	while ((line = as.readLine()) != null)   {
                String[] commands = line.split(" ");
                int id=0;
             
                if(commands[0].equals("create_table")) {
                	u++;
            		System.out.println("***********************************\r\n" + 
            				"PROGRESSING COMMAND: create_table");
                	String[] create = commands[1].split(";");
                    String wtr_name= create[0];
                    int capacity = Integer.parseInt(create[1]);
                    int ID=id;
                    int status=0; // 0 boï¿½ 1 dolu masa
                    if(seyma.control(wtr_name)!=0) {
                    	String name = create[0];
                        Table table1= new Table(name,capacity,ID,status);
                        seyma.addTable(table1);
                        id++;
                        //System.out.println("---");
                        System.out.println("A new table has successfully been added");
                    }
                }
                else if (commands[0].equals("new_order")){
            		System.out.println("***********************************\r\n" + 
            				"PROGRESSING COMMAND: new_order");
            		String[] orders = commands[1].split(";");
            		String orderss = orders[0];
            		if(seyma.control_waiter(orderss)==1) {
                        String waiter_name= orders[0];
                        int no_customer=Integer.parseInt(orders[1]);
                        String[] no = orders[2].split(":");
                        int no_item=0;
                        for (int b=0 ; b <= seyma.countChar(orders[2], ':') ; b++) {
                        	String[] number = no[b].split("-");
                        	no_item=no_item +Integer.parseInt(number[1]);
                        }
                        if(no_item >10) {
                        	System.out.println("Not allowed to service max. number of items, MAX_ITEMS");
                        }
                        else if(seyma.table_id(no_customer) != 0) {
                        int[] no_item_array = new int[5];
                        int ID= ide;
                        int no_order=0;
                        int no_of_table=0;
                        int b=0 , a=0, n=0;
                        ArrayList<String> new_order = new ArrayList<String>();
                        String[] itemss = orders[2].split(":");
                        for (b=0 ; b <= seyma.countChar(orders[2], ':') ; b++) {
                        	String[] itemsss = itemss[b].split("-");
                        	int c=Integer.parseInt(itemsss[1]);
                        	for(a=0 ; a<c ; a++) {
                        		new_order.add(itemsss[0]);
                        	} 
                           }
                        String[] order_item_f= new String[20];
                        for(a=0; a<new_order.size(); a++) {
                        	order_item_f[a] = new_order.get(a);
                        }
                        String[] order_item= new String[20];
                        
                        int count= 0;
                        for( n=0 ; n<new_order.size() ; n++) {
                        	String item_item= order_item_f[n];
                        	if(seyma.control_item(item_item)==1) {
                        		if(seyma.new_order(item_item) == 1) {
                            		order_item[count] = item_item;
                            		count++;
                        		}
                        		}
                        	}
                        no_item=count;
                        no_item_array[0]= no_item;
                        int status= 1;
                        Order order1= new Order(waiter_name,no_customer,ID,order_item,no_order,no_item, no_of_table, no_item_array, status);
                        seyma.addOrder(order1);
                        
                        
                        }
            		}
                }
                
                
                else if (commands[0].equals("add_order")){
                	System.out.println("***********************************\r\n" + 
                			"PROGRESSING COMMAND: add_order");
            		String[] add = commands[1].split(";");
            		String add_name =add[0];
            		int add_id=Integer.parseInt(add[1]);
                    ArrayList<String> add_orderr = new ArrayList<String>();
            		String[] non = add[2].split(":");
                    int no_item_add=0;
            		for (int b=0 ; b <= seyma.countChar(add[2], ':') ; b++) {
                    	String[] number_add = non[b].split("-");
                    	no_item_add=no_item_add +Integer.parseInt(number_add[1]);
                    	int c=Integer.parseInt(number_add[1]);
                    	for(int a=0 ; a<c ; a++) {
                    		add_orderr.add(number_add[0]);
                    	} 
                    	String[] order_ite= new String[add_orderr.size()];
                    	for(int a=0; a<add_orderr.size(); a++) {
                    	order_ite[a] = add_orderr.get(a);
                    }
            		}
       
                    if(no_item_add >10) {
                    	System.out.println("Not allowed to service max. number of items, MAX_ITEMS");
                    }
                    else {
                    	if(seyma.control_waiter(add_name, add_id) == 1) {
                    		int a=0, n=0;
                            ArrayList<String> add_order = new ArrayList<String>();
                            String[] add_item = add[2].split(":");
                            for (int b1=0 ; b1 <= seyma.countChar(add[2], ':') ; b1++) {
                            	String[] add_items = add_item[b1].split("-");
                            	int c=Integer.parseInt(add_items[1]);
                            	for(a=0 ; a<c ; a++) {
                            		add_order.add(add_items[0]);
                            	} 
                               }
                            String[] order_itemm= new String[add_order.size()];
                            for(a=0; a<add_order.size(); a++) {
                            	order_itemm[a] = add_order.get(a);
                            }
                            String[] news_order = new String[add_order.size()];
                        	int count=0;
                            for( n=0 ; n<add_order.size() ; n++) {
                            	String item_itemm= order_itemm[n];
                            		if(seyma.add_order(item_itemm, news_order, count) == 1) {
                                		count++;

                            		}
                            }
                            int[] no_item_add_array = new int[1];
                            no_item_add= count;
                        	no_item_add_array[0] = no_item_add;
                            seyma.concatt(news_order, add_name, add_id, no_item_add, no_item_add_array);
                    	}
                    }
                }
                
                
                else if (commands[0].equals("stock_status")){
                	System.out.println("***********************************\r\n" + 
                			"PROGRESSING COMMAND: stock_status");
                			seyma.stock_status();
                }
                else if (commands[0].equals("get_table_status")){
                	System.out.println("***********************************\r\n" + 
                			"PROGRESSING COMMAND: get_table_status");
                			seyma.get_table_status();
                } 
                else if (commands[0].equals("get_employer_salary")){
                	System.out.println("***********************************\r\n" + 
                			"PROGRESSING COMMAND: get_employer_salary");
                			seyma.get_employer_salary();
                }
        		else if (commands[0].equals("get_waiter_salary")){
        			System.out.println("***********************************\r\n" + 
        					"PROGRESSING COMMAND: get_waiter_salary");        			
        					seyma.get_waiter_salary();
        			
        		}
                
                else if (commands[0].equals("get_order_status")){
                	System.out.println("***********************************\r\n" + 
                			"PROGRESSING COMMAND: get_order_status");                	
                			seyma.get_order_status();
                	
                }
                
                else if (commands[0].contentEquals("check_out")) {
                	System.out.println("***********************************\r\n" + 
                			"PROGRESSING COMMAND: check_out"); 
                	String[] check = commands[1].split(";");
            		String waiter_check = check[0];
            		int id_check= Integer.parseInt(check[1]);
            		if (seyma.check_control(waiter_check, id_check) == 1) {
            			seyma.check_out(waiter_check, id_check);
            		
            		}
               }
    	  }
    }
}
