package pl.java.borowiec.aop.service;

/**
 * @author Sławomir Borowiec 
 * Module name : personalBlogCore
 * Creating time :  13-04-2013 12:06:12
 
 */
public interface CarMechanicService {
	
   void checkVehicleState();
   
   String basicReport2Customer();
   
   String basicReport2RightCustomer(Customer customer);
   
   void checkEngine();
   
   void checkVehicleStart() throws SomethingWrongException;
   
   Customer notifyCustomerAboutError();
   
     
   	String getReport(String in);
   	
   	String getBillToClient(Customer customer);
   	
    String getLocalization();
    
   void getText(String str);
 
}
