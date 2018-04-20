package br.com.flexvision.befd.flex4.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import org.springframework.stereotype.Repository;
import br.com.flexvision.befd.flex4.dto.Serie;

@Repository
public class OtherDataDAO {

	public List<Serie> listSerieOther(){
		List<Serie> list = new ArrayList<Serie>();
		try {
			Calendar calIni = Calendar.getInstance();
			Calendar calFin = Calendar.getInstance();
			calIni.add(Calendar.HOUR_OF_DAY, -2);
			
			Connection conn = getConnection();
			PreparedStatement prep = conn.prepareStatement("exec [prc_data_sim] :ini :fin");
			prep.setTimestamp(0, new Timestamp(calIni.getTimeInMillis()));
			prep.setTimestamp(1, new Timestamp(calFin.getTimeInMillis()));
			ResultSet rs = prep.executeQuery();
			
			try {
				 while (rs.next()) {
					 System.out.println(rs.getTime("time"));
					 Calendar cal = Calendar.getInstance();
					 cal.setTimeInMillis(rs.getTime("time").getTime());
					 list.add(new Serie(cal, rs.getBigDecimal("value")));
				 }
			} catch (Exception e) {
				e.printStackTrace();
	        } finally {
	            conn.close();
	            rs.close();
	        }
		}catch (SQLException | ClassNotFoundException e) {
			// TODO: handle exception
		}
			
		return list;
	}
	
	public Connection getConnection() throws SQLException, ClassNotFoundException {
	    Connection conn = null;
	    Properties connectionProps = new Properties();
	    Class.forName("net.sourceforge.jtds.jdbc.Driver");
	    connectionProps.put("user", "userdbmir_prd");
	    connectionProps.put("password", "unicom@10");
	    conn = DriverManager.getConnection(
	    				"jdbc:jtds:sqlserver://192.168.80.17:1433/Internet30h",
	                   connectionProps);
	    System.out.println("Connected to database");
	    return conn;
	}

}
