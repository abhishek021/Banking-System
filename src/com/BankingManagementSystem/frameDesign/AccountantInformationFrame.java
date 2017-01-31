package com.BankingManagementSystem.frameDesign;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import com.BankingManagementSystem.FileHandling.AccountantDetailsFile;
import com.BankingManagementSystem.FileHandling.CustomerDetailsFile;
import com.BankingManagementSystem.Pojo.AccountantDetails;
import com.BankingManagementSystem.Pojo.CustomerDetails;



public class AccountantInformationFrame extends JFrame
{
	private JPanel contentPane;
	private JTextField txtTotalAcc;
	private JTextField textField;
	
	ArrayList<AccountantDetails> acct = new ArrayList<AccountantDetails>();
	ArrayList<AccountantDetails> accttemp = new ArrayList<AccountantDetails>();
	public AccountantInformationFrame()
	{
		formopen();
	}
	
	
	private void formopen()
	{
		
		//ManagerLoginPage obj =new ManagerLoginPage();
		
		setResizable(false);
		setTitle("ACCOUNTANT INFORMATION");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                //int result = JOptionPane.showConfirmDialog(frame, "Are you sure?");
               // if( result==JOptionPane.OK_OPTION){
                    // NOW we change it to dispose on close..
            	 	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            	 	setVisible(false);
            	 	dispose();
                	new Managerframe(obj.loginIndex);
                }
        }
        );
        */
		setBounds(100, 100, 598, 457);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Lucida Handwriting", Font.BOLD, 16));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTotalAccountant = new JLabel("TOTAL ACCOUNTANTS : ");
		lblTotalAccountant.setForeground(new Color(128, 0, 128));
		lblTotalAccountant.setFont(new Font("Lucida Handwriting", Font.BOLD, 16));
		lblTotalAccountant.setBounds(30, 137, 230, 34);
		contentPane.add(lblTotalAccountant);
		
		txtTotalAcc = new JTextField();
		txtTotalAcc.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtTotalAcc.setFont(new Font("Consolas", Font.BOLD, 22));
		txtTotalAcc.setEditable(false);
		txtTotalAcc.setBounds(283, 138, 255, 34);
		contentPane.add(txtTotalAcc);
		txtTotalAcc.setColumns(10);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 22));
		textField.setToolTipText("ENTER ACCOUNTANT'S USER ID");
		textField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField.setBounds(283, 216, 255, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblViewAccountant = new JLabel("ACCOUNTANT ID : ");
		lblViewAccountant.setForeground(new Color(128, 0, 128));
		lblViewAccountant.setFont(new Font("Lucida Handwriting", Font.BOLD, 16));
		lblViewAccountant.setBounds(73, 221, 193, 29);
		contentPane.add(lblViewAccountant);
		
		JButton btnNewButton = new JButton("SHOW DETAILS");
		btnNewButton.setToolTipText("SHOW ACCOUNTANT'S DETAILS");
		btnNewButton.setFont(new Font("Lucida Handwriting", Font.BOLD, 24));
		btnNewButton.setBackground(new Color(0, 0, 128));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(300, 296, 245, 54);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("ACCOUNTANT DETAILS");
		lblNewLabel.setForeground(new Color(34, 139, 34));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblNewLabel.setBounds(67, 24, 481, 46);
		contentPane.add(lblNewLabel);
		
		acct = AccountantDetailsFile.readDataFromFile();
		Integer total = acct.size();
		txtTotalAcc.setText(total.toString());
		
		btnNewButton.addActionListener((e)->
		{
			int index = searchId(textField.getText().trim());
			accttemp.add(acct.get(index));
			
			new AllDetailsAccountant(accttemp);
		});
		
		setVisible(true);
	}
	public int searchId(String strId)
	{
		ArrayList<AccountantDetails> aList;
		int f = -1;
		try
		{
			aList=AccountantDetailsFile.readDataFromFile();
			
			for(int p=0; p<aList.size(); p++)
			{
				if(strId.equals(aList.get(p).getAccountantId()))
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
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 AccountantInformationFrame frame = new AccountantInformationFrame();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
}
}
