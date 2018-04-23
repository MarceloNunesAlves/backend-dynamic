package br.com.flexvision.befd.flex4.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.flexvision.befd.flex4.dto.Metric;
import br.com.flexvision.befd.flex4.dto.Serie;

@Repository
public class OtherDataDAO {

	private Logger LOG;
	
	public List<Serie> listSerieOther(Metric m){
		SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		List<Serie> list = new ArrayList<Serie>();
		try {
			Calendar calIni = Calendar.getInstance();
			Calendar calFin = Calendar.getInstance();
			calIni.add(Calendar.HOUR_OF_DAY, -2);
			
			Connection conn = getConnection();
			PreparedStatement prep = conn.prepareStatement("exec [prc_data_sim] @dt_ini=?, @dt_fin=?, @metric=?");
			prep.setTimestamp(1, new Timestamp(calIni.getTimeInMillis()));
			prep.setTimestamp(2, new Timestamp(calFin.getTimeInMillis()));
			prep.setInt(3, m.getMet_id());
			System.out.println(m.getMet_id());
			ResultSet rs = prep.executeQuery();
			
			try {
				 while (rs.next()) {
					 Calendar cal = Calendar.getInstance();
					 cal.setTimeInMillis(sdf.parse(rs.getString("time")).getTime());
					 list.add(new Serie(cal, rs.getBigDecimal("value")));
				 }
			} catch (Exception e) {
				System.out.println(e);
	        } finally {
	            conn.close();
	            rs.close();
	        }
		}catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
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
