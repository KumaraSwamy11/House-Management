package com.wipro.hms.service;

import com.wipro.hms.bean.RentalPropertyBean;
import com.wipro.hms.dao.RentalPropertyDAO;
import com.wipro.hms.util.InvalidCityException;

public class RentalPropertyService {

	protected RentalPropertyDAO rentalPropertyDAO;
      
	//RentalPropertyDAO rentalPropertyDAO;

    public RentalPropertyService() {
        this.rentalPropertyDAO = new RentalPropertyDAO();
    }
    
	public static void main(String[] args) {
		
	   
	        // Sample code to test the program
	        RentalPropertyService rentalPropertyService = new RentalPropertyService();
	        RentalPropertyBean rentalPropertyBean = new RentalPropertyBean();
	        rentalPropertyBean.setCity("Hyderabad");
	        rentalPropertyBean.setLocation("Hyd location");
	        rentalPropertyBean.setNoOfBedRooms(4);
	        rentalPropertyBean.setRentalAmount((float) 28500.00);

	        String result = rentalPropertyService.addRentalProperty(rentalPropertyBean);
	        System.out.println(result);
	    }

	    public String addRentalProperty(RentalPropertyBean bean) {
	        // Check for null values in input
	        if (bean.getCity() == null || bean.getLocation() == null) {
	            return "NULL VALUES IN INPUT";
	        }

	        // Check for invalid input conditions
	        if (bean.getCity().length() == 0 || bean.getLocation().length() == 0 || bean.getNoOfBedRooms() == 0 || bean.getRentalAmount() == 0) {
	            return "INVALID INPUT";
	        }

	        try {
	            // Validate city
	            validateCity(bean.getCity());

	            // Call DAO method to add rental property
	            int recordsInserted = rentalPropertyDAO.createRentalProperty(bean);

	            // Check if record is inserted successfully
	            if (recordsInserted > 0) {
	                return "SUCCESS";
	            } else {
	                return "FAILURE";
	            }
	        } catch (InvalidCityException e) {
	            return "INVALID CITY";
	        } catch (Exception e) {
	            e.printStackTrace();
	            return "FAILURE";
	            
	        }
	    }

	    public void validateCity(String city) throws InvalidCityException {
	       
	        if (!city.equalsIgnoreCase("Hyderabad") && !city.equalsIgnoreCase("Bengaluru")) {
	            throw new InvalidCityException();
	        }
	    

	}

}
