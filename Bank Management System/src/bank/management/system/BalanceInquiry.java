package bank.management.system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BalanceInquiry extends JFrame implements ActionListener{
	
	JLabel image,currentBalanceLabel;
	JButton back;
	String pinNumber;
	
	BalanceInquiry(String pinNumber ){
		this.pinNumber=pinNumber;
		
		setLayout(null);
		
		//ATM IMAGE
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);	
		image=new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		//BACK BUTTON
		back=new JButton("Back");
		back.setBounds(355,520,150,30);
		back.addActionListener(this);
		image.add(back);
		
		Conn conn=new  Conn();
		 long balance=0L;
		try {
			String qry="select*from bank where pin = '"+pinNumber+"'";
		    ResultSet rs=conn.s.executeQuery(qry);	   
		    while(rs.next()) {
		    	if(rs.getString("transaction_type").equals("Deposit")) {
		    		balance+=Integer.parseInt(rs.getString("amount"));	    		
		    	}else {
		    		balance-=Integer.parseInt(rs.getString("amount"));		
		    	}
		    }
		}catch (Exception e) {
		System.out.println(e);
		}
		
		//CURRENT BALANCE LABEL
		currentBalanceLabel=new JLabel("Your Current Balance Is Rs "+balance);
		currentBalanceLabel.setForeground(Color.WHITE);
		currentBalanceLabel.setBounds(170,300,400,30);
		image.add(currentBalanceLabel);
		
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);					
	}//Constructor

	public static void main(String[] args) {
		new BalanceInquiry("");
	}//main()

	@Override
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new Transations(pinNumber).setVisible(true);		
	}
}//class
