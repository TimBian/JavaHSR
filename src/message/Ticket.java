package message;

import java.io.Serializable;


/**
 * After checking the SearchOrder in the database, we should create an object of OrderResult, and
 * returnif to Client.
 * 
 * Information:
 * 1.carID;
 * 2.userID;
 * 3.depart station;
 * 4.arrive station;
 * 5.depart_time;
 * 6.arrive_time;
 * 7.passenger_type;
 * 8.carriage;
 * 9.early_discount(65,75...or none)
 * 10.compartment
 * 11.location
 *
 */
public class Ticket implements Serializable{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private String carID;
		private String userID;
		private String depart;
		private String arrive;
		private String depart_time;  //include day and hour, minute
		private String arrive_time;  //include day and hour, minute
		private String passenger_type;
		private String carriage;
		private String early_discount;  //65,75...or none
		private String compartment;
		private String location;
		private String price;
 
		
		
		
		public Ticket() {
			carID = userID = depart = arrive = depart_time = arrive_time = passenger_type = 
					carriage = early_discount = compartment = location = price = "invalid";

		}
		
		
		//for testing
		public Ticket(int x) {
			this.carID = "0205";
			this.userID = "shaopoo";
			this.depart = "NTU";
			this.arrive = "HELL";
			this.arrive_time = "1995-02-03,18:03";
			this.depart_time = "1997-10-03,14:15";
			this.passenger_type = "STUDENT";
			this.carriage = "STANDER";
			this.early_discount = "none";
			this.compartment = "1";
			this.location = "A1";
			this.price = "1240";
			
		}
		
		//for testing2
		public Ticket(int x, int y) {
			this.carID = "0305";
			this.userID = "isaiah";
			this.depart = "NTU";
			this.arrive = "HAVEN";
			this.arrive_time = "1993-12-03,18:03";
			this.depart_time = "1997-04-03,14:15";
			this.passenger_type = "STUDENT";
			this.carriage = "STANDER";
			this.early_discount = "none";
			this.compartment = "1";
			this.location = "A1";
			this.price = "1240";
			
		}
		
		
		
		
		public Ticket(String carID, String userID, String depart, String arrive, 
				String depart_time, String arrive_time, String passenger_type, String carriage,
				String early_discount, String compartment, String location, String price)
		{
			this.carID = carID;
			this.userID = userID;
			this.depart = depart;
			this.arrive = arrive;
			this.arrive_time = arrive_time;
			this.depart_time = depart_time;
			this.passenger_type = passenger_type;
			this.carriage = carriage;
			this.early_discount = early_discount;
			this.compartment = compartment;
			this.location = location;
			this.price = price;
		}
		
		public String getCarID() {
			return this.carID;
		}
		public String getUserID() {
			return this.userID;
		}
		public String getDepart(){
			return this.depart;
		}
		public String getArrive() {
			return this.arrive;
		}
		public String getDepartTime() {
			return this.depart_time;
		}
		public String getArriveTime() {
			return this.arrive_time;
		}
		public String getPassengerType() {
			return this.passenger_type;
		}
		public String getCarriage() {
			return this.carriage;
		}
		public String getEarlyDiscount() {
			return this.early_discount;
		}
		public String getCompartment() {
			return this.compartment;
		}
		public String getLocation() {
			return this.location;
		}
		
		public String getPrice() {
			return this.price;
		}
		
	}
	
