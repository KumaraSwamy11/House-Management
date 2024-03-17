package com.wipro.hms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.wipro.hms.bean.RentalPropertyBean;
import com.wipro.hms.util.DBUtil;

public class RentalPropertyDAO {
	
	private static final String SEQUENCE_NAME= "RENTAL_SEQ";
	 
	
	  public String generatePropertyId(String city) {
		  
		  int sequenceValue = getNextSequenceValue(SEQUENCE_NAME);
		  
		  return city.substring(0, Math.min(city.length(), 3)).toUpperCase() + sequenceValue;
		  
	  }
	  
	  public int createRentalProperty(RentalPropertyBean bean) {
	        Connection con = null;
	        
	        PreparedStatement preparedStatement = null;

	        try {
	            // Generate propertyId using the city
	            String propertyId = generatePropertyId(bean.getCity());
	            bean.setPropertyId(propertyId);

	            // Establish database connection
	            con = DBUtil.getDBConnection();

	            // Insert into rental_tbl
	            String sql = "INSERT INTO RENTAL_TBL (PROPERTYID, RENTALAMOUNT, NOOFBEDROOMS, LOCATION, CITY) VALUES (?, ?, ?, ?, ?)";
	            preparedStatement = con.prepareStatement(sql);
	            preparedStatement.setString(1, bean.getPropertyId());
	            preparedStatement.setFloat(2, bean.getRentalAmount());
	            preparedStatement.setInt(3, bean.getNoOfBedRooms());
	            preparedStatement.setString(4, bean.getLocation());
	            preparedStatement.setString(5, bean.getCity());

	            // Execute the update
	            int recordsInserted = preparedStatement.executeUpdate();

	            return recordsInserted;
	        } catch (SQLException | ClassNotFoundException e) {
	            // Handle exceptions
	            e.printStackTrace();
	            return -1;
	        } finally {
	            // Close resources
	            try {
	                if (preparedStatement != null) preparedStatement.close();
	                if (con != null) con.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
  

	private int getNextSequenceValue(String sequenceName) {
		
		return 1000;
	}

}
