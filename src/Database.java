 
 
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement; 
 
public class Database { 
  private Connection con = null; 
  private Statement stat = null; 
  private ResultSet rs = null;
  private PreparedStatement pst = null; 
  
  /////////////////////////////////////////////////////
  
  private String insertBooking = "INSERT INTO `booking`"
	  		+ "(`code`, `uid`, `date`, `ticketsType`, `ticketsCount`, `start`, `end`, `seats`, `payDeadline`, `payment`) "
	  		+ "VALUES (?,'?','?','?',?,'?','?','?','?',?)";
  
  private String insertEearlyDiscount = "INSERT INTO `earlyDiscount`"
  		+ "(`TrainNo`, `Day`, `discount`, `tickets`) "
  		+ "VALUES ('?','?',?,?)"; 
  
  private String insertSeat = "INSERT INTO `seat`(`TrainNo`, `Carriage`, `data`) "
  		+ "VALUES ('?',?,'?')"; 
  
  private String insertStation = "INSERT INTO `station`(`StationID`, `Zh_tw`, `En`, `StationAddress`) "
  		+ "VALUES ('?','?','?','?')";
  
  private String insertTimeTable = "INSERT INTO `timeTable`(`TrainNo`, `Direction`, "
  		+ "`StartingStationName`, `EndingStationName`, `Nangang`, `Taipei`, `Banciao`, "
  		+ "`Taoyuan`, `Hsinchu`, `Miaoli`, `Taichung`, `Changhua`, `Yunlin`, `Chiayi`, "
  		+ "`Tainan`, `Zuoying`, `Monday`, `Tuesday`, `Wednesday`, `Thursday`, `Friday`, "
  		+ "`Saturday`, `Sunday`) VALUES ('?',?,'?','?','?','?','?','?','?','?','?','?'"
  		+ ",'?','?','?','?',?,?,?,?,?,?,?)";
  
  private String insertUniversityDiscount = "INSERT INTO `universityDiscount`(`TrainNo`, "
  		+ "`Monday`, `Tuesday`, `Wednesday`, `Thursday`, `Friday`, `Saturday`, `Sunday`) "
  		+ "VALUES ('?',?,?,?,?,?,?,?)";
 
  /////////////////////////////////////////////////////

  private String selectSQL = "select * from User "; 
  
  public Database() 
  { 
    try { 
      Class.forName("com.mysql.cj.jdbc.Driver"); 
      con = DriverManager.getConnection( 
      "jdbc:mysql://db4free.net:3306/javahsr?useUnicode=true&useSSL=false", 
      "dwaydwaydway","dwaydwaydway"); 
    } 
    catch(ClassNotFoundException e) 
    { 
      System.out.println("DriverClassNotFound :"+e.toString()); 
    }
    catch(SQLException x) { 
      System.out.println("Exception :"+x.toString()); 
    } 
  } 

  /////////////////////////////////////////////////////

  public void insertBooking(String code, String uid, String date, String ticketsType,
		  String ticketsCount, String start, String end, String seats, 
		  String payDeadline, String payment) 
  { 
    try 
    { 
      pst = con.prepareStatement(insertBooking); 
      pst.setString(1, code); 
      pst.setString(2, uid); 
      pst.setString(3, date); 
      pst.setString(4, ticketsType); 
      pst.setString(5, ticketsCount); 
      pst.setString(6, start); 
      pst.setString(7, end); 
      pst.setString(8, seats); 
      pst.setString(9, payDeadline); 
      pst.setString(10, payment); 
      pst.executeUpdate(); 
    } 
    catch(SQLException e) 
    { 
      System.out.println("InsertDB Exception :" + e.toString()); 
    } 
    finally 
    { 
      Close(); 
    } 
  } 
  
  public void insertEearlyDiscount(String TrainNo, String Day, 
		  String discount, String tickets) 
  { 
    try 
    { 
      pst = con.prepareStatement(insertEearlyDiscount); 
      pst.setString(1, TrainNo); 
      pst.setString(2, Day); 
      pst.setString(3, discount); 
      pst.setString(4, tickets); 
      pst.executeUpdate(); 
    } 
    catch(SQLException e) 
    { 
      System.out.println("InsertDB Exception :" + e.toString()); 
    } 
    finally 
    { 
      Close(); 
    } 
  } 
  
  public void insertSeat(String TrainNo, String Carriage, String data) 
  { 
    try 
    { 
      pst = con.prepareStatement(insertSeat); 
      pst.setString(1, TrainNo); 
      pst.setString(2, Carriage); 
      pst.setString(3, data); 
      pst.executeUpdate(); 
    } 
    catch(SQLException e) 
    { 
      System.out.println("InsertDB Exception :" + e.toString()); 
    } 
    finally 
    { 
      Close(); 
    } 
  } 
  
  public void insertStation(String StationID, String Zh_tw, String En, String StationAddress) 
  { 
    try 
    { 
      pst = con.prepareStatement(insertStation); 
      pst.setString(1, StationID); 
      pst.setString(2, Zh_tw); 
      pst.setString(3, En); 
      pst.setString(4, StationAddress); 
      pst.executeUpdate(); 
    } 
    catch(SQLException e) 
    { 
      System.out.println("InsertDB Exception :" + e.toString()); 
    } 
    finally 
    { 
      Close(); 
    } 
  } 
  
  public void insertUniversityDiscount(String TrainNo, String Monday, String Tuesday, 
		  String Wednesday, String Thursday, String Friday, String Saturday, String Sunday) 
  { 
    try 
    { 
      pst = con.prepareStatement(insertUniversityDiscount); 
      pst.setString(1, TrainNo); 
      pst.setString(2, Monday);
      pst.setString(3, Tuesday); 
      pst.setString(4, Wednesday); 
      pst.setString(5, Thursday); 
      pst.setString(6, Friday); 
      pst.setString(7, Saturday); 
      pst.setString(8, Sunday); 
      pst.executeUpdate(); 
    } 
    catch(SQLException e) 
    { 
      System.out.println("InsertDB Exception :" + e.toString()); 
    } 
    finally 
    { 
      Close(); 
    } 
  } 
  
  public void insertTimeTable(String TrainNo, String Direction, String StartingStationName, 
		  String EndingStationName, String Nangang, String Taipei, String Banciao, 
		  String Taoyuan, String Hsinchu, String Miaoli, String Taichung, String Changhua,
		  String Yunlin, String Chiayi, String Tainan, String Zuoying, String Monday, 
		  String Tuesday, String Wednesday, String Thursday, String Friday, 
		  String Saturday, String Sunday) 
  { 
    try 
    { 
      pst = con.prepareStatement(insertTimeTable); 
      String temp[] = new String[23];
      temp[0] = TrainNo;
      temp[1] = Direction;
      temp[2] = StartingStationName;
      temp[3] = EndingStationName;
      temp[4] = Nangang;
      temp[5] = Taipei;
      temp[6] = Banciao;
      temp[7] = Taoyuan;
      temp[8] = Hsinchu;
      temp[9] = Miaoli;
      temp[10] = Taichung;
      temp[11] = Changhua;
      temp[12] = Yunlin;
      temp[13] = Chiayi;
      temp[14] = Tainan;
      temp[15] = Zuoying;
      temp[16] = Monday;
      temp[17] = Tuesday;
      temp[18] = Wednesday;
      temp[19] = Thursday;
      temp[20] = Friday;
      temp[21] = Saturday;
      temp[22] = Sunday;

      for(int i = 0; i < 23; i++) {
    	  if(temp[i] == null)
    		  pst.setNull(i+1, java.sql.Types.TIME);
    	  else
    		  pst.setString(i+1, temp[i]);
      }
      
      pst.executeUpdate(); 
    } 
    catch(SQLException e) 
    { 
      System.out.println("InsertDB Exception :" + e.toString()); 
    } 
    finally 
    { 
      Close(); 
    } 
  } 
  
  /////////////////////////////////////////////////////

  public void SelectTable() 
  { 
    try 
    { 
      stat = con.createStatement(); 
      rs = stat.executeQuery(selectSQL); 
      System.out.println("ID\t\tName\t\tPASSWORD"); 
      while(rs.next()) 
      { 
        System.out.println(rs.getInt("id")+"\t\t"+ 
            rs.getString("name")+"\t\t"+rs.getString("passwd")); 
      } 
    } 
    catch(SQLException e) 
    { 
      System.out.println("DropDB Exception :" + e.toString()); 
    } 
    finally 
    { 
      Close(); 
    } 
  } 
  
  //����ϥΧ���Ʈw��,�O�o�n�����Ҧ�Object 
  //�_�h�b����Timeout��,�i��|��Connection poor�����p 
  private void Close() 
  { 
    try 
    { 
      if(rs!=null) 
      { 
        rs.close(); 
        rs = null; 
      } 
      if(stat!=null) 
      { 
        stat.close(); 
        stat = null; 
      } 
      if(pst!=null) 
      { 
        pst.close(); 
        pst = null; 
      } 
    } 
    catch(SQLException e) 
    { 
      System.out.println("Close Exception :" + e.toString()); 
    } 
  } 
  
  /////////////////////////////////////////////////////////////////////
  
  public Messenger selectCar(Messenger msg) {
	  
	  return null;
  }
 
  public static void main(String[] args) 
  { 
    //���ݬݬO�_���` 
    Database test = new Database(); 

  
  } 
}