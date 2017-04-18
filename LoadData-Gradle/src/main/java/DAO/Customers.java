package DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

import beans.CustomerDetails;

public class Customers {
	
	private static LineNumberReader lineNumber;
	private static BufferedReader in;

	public static List<CustomerDetails> getCustomersList(String file) throws IOException{
		List<CustomerDetails> Customers= new ArrayList<CustomerDetails>();
		lineNumber = new LineNumberReader(new FileReader(new File(file)));
		lineNumber.skip(Long.MAX_VALUE);
		int length = lineNumber.getLineNumber();
		lineNumber.close();
		in = new BufferedReader(new FileReader(file));
		
		for(int i=0;i<length+1/4;i+=4)
		{	
			CustomerDetails CustomerDetails = new CustomerDetails();
			CustomerDetails.setcustName(in.readLine());
			CustomerDetails.setdob(in.readLine());
			CustomerDetails.setgender(in.readLine());
			CustomerDetails.setCountry(in.readLine());
			Customers.add(CustomerDetails);
		}
		return Customers;
	}

}