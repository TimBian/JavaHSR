
public class Result1 {
	public enum station {
		Nangang, Taipei, Banqiao, Taoyuan, Hsinchu, Miaoli, 
		Taichung, Tainan, Changhua, Yunlin, Chiayi, Zuoying
	}
	public enum passengerType {
		normal, child, elder, disable
	}
	public enum seat {
		none, window, aisle
	}
	
	boolean OrderSuccessfully;
	
	station depart;
	station arrive;
	
	int depar_time;
	int arrive_time;
	passengerType passengertype;
	seat seat;

	String ID;
	String carID;
	int[] quantity;
}