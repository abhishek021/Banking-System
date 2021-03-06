package com.BankingManagementSystem.frameDesign;




import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.BankingManagementSystem.FileHandling.AccountantDetailsFile;

import com.BankingManagementSystem.Pojo.AccountantDetails;


import javax.swing.UIManager;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;

import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JCheckBox;



@SuppressWarnings("serial")
class LoginAccountant extends JFrame
{
	private JPanel AdminPage;
	private Panel LoginPage;
	private JLabel lblPassword,lbUserId;
	private JTextField textUserId;
	private JPasswordField txtPassword;
	private JButton btnLogIn;
	private JCheckBox chckbxShowPassword;
	private JLabel lblLogIn;
	private JLabel lblAccountant;
	
	int loginIndex;
	
	public LoginAccountant() 
	{
		formOpen();
		
	}
	
	

	private void formOpen() 
	{
		
		
		try
		{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} 
		catch (Throwable e) 
		{
			e.printStackTrace();
		}
		
		
		//setIconImage(Toolkit.getDefaultToolkit().getImage(AdminLoginPage.class.getResource("/resources/1485472416_Banking_00019_A.png")));
		setTitle("ACCOUNTANT LOGIN");
		setIconImage(Toolkit.getDefaultToolkit().getImage(start.class.getResource("/resources/operator.png")));
		addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
            	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            	setVisible(false);
            	dispose();
                    
                }
        }
        );
		setBounds(00, 00, 1378, 780);
		AdminPage = new JPanel();
		AdminPage.setBackground(new Color(244, 164, 96));
		AdminPage.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(AdminPage);
		AdminPage.setLayout(null);
		
		/*lblBankingManagementSystem = new JLabel("BANKING MANAGEMENT SYSTEM");
		lblBankingManagementSystem.setLabelFor(this);
		lblBankingManagementSystem.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblBankingManagementSystem.setForeground(new Color(219, 112, 147));
		lblBankingManagementSystem.setFont(new Font("Adobe Caslon Pro Bold", Font.BOLD, 48));
		lblBankingManagementSystem.setBounds(248, 21, 854, 52);
		AdminPage.add(lblBankingManagementSystem);*/
		
		LoginPage = new Panel();
		LoginPage.setBackground(new Color(240, 230, 140));
		LoginPage.setForeground(new Color(255, 127, 80));
		LoginPage.setBounds(341, 275, 660, 400);
		AdminPage.add(LoginPage);
		LoginPage.setLayout(null);
		
		lblLogIn = new JLabel("-----LOG IN------------------------------------------------------------------");
		lblLogIn.setBounds(3, 5, 654, 27);
		lblLogIn.setForeground(new Color(128, 0, 128));
		lblLogIn.setFont(new Font("Script MT Bold", Font.BOLD, 22));
		LoginPage.add(lblLogIn);
		
		lbUserId = new JLabel("USER ID");
		lbUserId.setForeground(new Color(220, 20, 60));
		lbUserId.setFont(new Font("Tekton Pro Cond", Font.BOLD, 28));
		lbUserId.setBounds(119, 89, 94, 51);
		LoginPage.add(lbUserId);
		
		lblPassword = new JLabel("PASSWORD");
		lblPassword.setForeground(new Color(220, 20, 60));
		lblPassword.setFont(new Font("Tekton Pro Cond", Font.BOLD, 28));
		lblPassword.setBounds(85, 177, 128, 51);
		LoginPage.add(lblPassword);
		
		textUserId = new JTextField();
		textUserId.setFont(new Font("Times New Roman", Font.BOLD, 28));
		textUserId.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textUserId.setBounds(237, 89, 360, 40);
		LoginPage.add(textUserId);
		textUserId.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.BOLD, 28));
		txtPassword.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtPassword.setBounds(237, 177, 360, 40);
		LoginPage.add(txtPassword);
		txtPassword.setEchoChar('*');
		
		btnLogIn = new JButton("LOG IN");
		btnLogIn.setBorderPainted(false);
		btnLogIn.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnLogIn.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnLogIn.setForeground(new Color(255, 140, 0));
		btnLogIn.setBackground(new Color(176, 224, 230));
		btnLogIn.setBounds(451, 251, 146, 51);
		LoginPage.add(btnLogIn);
		
		btnLogIn.addActionListener((e)->
		{
			
			loginCheck();
		});

		chckbxShowPassword = new JCheckBox("Show Password");
		chckbxShowPassword.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		chckbxShowPassword.setBackground(new Color(240, 230, 140));
		chckbxShowPassword.setBounds(237, 236, 128, 23);
		LoginPage.add(chckbxShowPassword);
		chckbxShowPassword.addActionListener((e) ->
		{
			if(chckbxShowPassword.isSelected())
				txtPassword.setEchoChar((char)0);
			else
				txtPassword.setEchoChar('*');
		}
				);
		
		
		lblAccountant = new JLabel("ACCOUNTANT");
		lblAccountant.setForeground(new Color(85, 107, 47));
		lblAccountant.setFont(new Font("Trajan Pro 3", Font.BOLD, 48));
		lblAccountant.setBounds(480, 21, 854, 52);
		AdminPage.add(lblAccountant);
		this.setVisible(true);
	}
	/*public void loginCheck1()
	{
		ArrayList<AccountantDetails> userlist = AccountantDetailsFile.readDataFromFile();
		AccountantDetails obj = new AccountantDetails();
		obj.setAccountantId("debabrata");
		obj.setAccountantName("debabrata");
		obj.setAccountantPassword("debabrata");
		userlist.add(obj);
		AccountantDetailsFile.writeDatatoFile(userlist);
	}*/
	public void loginCheck()
	{
		
		loginIndex = searchId(textUserId.getText().trim());
		
		
		
        if(loginIndex >= 0)
        {
        	
       	 ArrayList<AccountantDetails> userlist = AccountantDetailsFile.readDataFromFile();
       	 
       	 if((txtPassword.getText().trim()).equals(userlist.get(loginIndex).getAccountantPassword()))
       	 {
       		
       		 SwingUtilities.invokeLater(new Runnable()
             {
                 public void run()
                 {
                     new AccountantFrame(loginIndex);
                     setvisible();
                 }
             });
       	 }
       	 else 
       		 JOptionPane.showMessageDialog(this, "Invalid password");
        }
        else
        {
           JOptionPane.showMessageDialog(this, "Invalid Id");
        }
	}
	public void setvisible()
	{
		this.dispose();
	}
	public int searchId(String strId)
	{
		ArrayList<AccountantDetails> cList;
		int f = -1;
		try
		{
			cList=AccountantDetailsFile.readDataFromFile();
			
			for(int p=0; p<cList.size(); p++)
			{
				if(strId.equals(cList.get(p).getAccountantId()))
				{
				   f = p;
				   break;
				}	
			}
			 
			return(f);
		}catch(Exception e)
		{
			System.out.println(e);
			return(-2);
		}
 	}
}


/*public class AccountantLoginPage 
{

	public static void main(String[] args)
	{


		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					LoginAccountant accountant = new LoginAccountant();
					accountant.setVisible(true);
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
		
	}

}*/
