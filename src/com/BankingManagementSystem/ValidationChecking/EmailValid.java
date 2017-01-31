package com.BankingManagementSystem.ValidationChecking;
import java.util.ArrayList;

import com.BankingManagementSystem.FileHandling.*;
import com.BankingManagementSystem.frameDesign.*;
import com.BankingManagementSystem.Pojo.*;

public class EmailValid {
	//int accNo;
	//ArrayList<CustomerDetails> userlist = CustomerDetailsFile.readDataFromFile();
	//userlist.get(accNo).getCemailid();
	
	public static void main(String[] args) {
		
		String[] to={"mishraabhishek.mishra021@gmail.com","masteramit9234@gmail.com"};
		
		
		if(EmailSender.sendMail("imduke021@gmail.com", "951357951357","hii amit..mission accomplised",to))
		{
			System.out.println("email sent");
		}
		else
			System.out.println("error occured");
	}
	

}
