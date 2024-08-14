package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class SignupThree extends JFrame implements ActionListener{
	
	JLabel l1,accType,card,dummyCardNo,pin,dummyPinNo,services;
	JRadioButton r1,r2,r3,r4;
	JCheckBox c1,c2,c3,c4,c5,c6,c7;
	JButton submit,cancel;
	String formno;
	
	SignupThree(String formno){
		this.formno=formno;
		
		setLayout(null);
		
		//ACCOUNT DETAILS LABEL
		l1=new JLabel("Page 3:Account Details");
		l1.setFont(new Font("Raleway",Font.BOLD,22));
		l1.setBounds(280,40,400,40);
		add(l1);
		
		//ACCOUNT TYPE LABEL
		accType=new JLabel("Account Type");
		accType.setFont(new Font("Raleway",Font.BOLD,22));
		accType.setBounds(100,140,200,40);
		add(accType);
		
		//ACCOUNT TYPE RADIO BUTTON
		r1=new JRadioButton("Savings Account");
		r1.setFont(new Font("Raleway",Font.BOLD,16));
		r1.setBackground(Color.WHITE);
		r1.setBounds(100,180,250,20);
		add(r1);
		
		r2=new JRadioButton("Fixed Deposit Account");
		r2.setFont(new Font("Raleway",Font.BOLD,16));
		r2.setBackground(Color.WHITE);
		r2.setBounds(350,180,250,20);
		add(r2);
		
		r3=new JRadioButton("Current Account");
		r3.setFont(new Font("Raleway",Font.BOLD,16));
		r3.setBackground(Color.WHITE);
		r3.setBounds(350,220,250,20);
		add(r3);
		
		r4=new JRadioButton("Reccuring Deposit Account");
		r4.setFont(new Font("Raleway",Font.BOLD,16));
		r4.setBackground(Color.WHITE);
		r4.setBounds(100,220,250,20);
		add(r4);
		
		ButtonGroup groupAccount=new ButtonGroup();
		groupAccount.add(r1);
		groupAccount.add(r2);
		groupAccount.add(r3);
		groupAccount.add(r4);
		
		//CARD DETAILS LABEL
		card=new JLabel("Card Number");
		card.setFont(new Font("Raleway",Font.BOLD,22));
		card.setBounds(100,300,200,30);
		add(card);
		
		//DUMMY CARD NUMBER LABEL
		dummyCardNo=new JLabel("XXXX-XXXX-XXXX-4158");
		dummyCardNo.setFont(new Font("Raleway",Font.BOLD,22));
		dummyCardNo.setBounds(330,300,300,30);
		add(dummyCardNo);
		
		//PIN DETAILS LABEL
		pin=new JLabel("PIN:");
		pin.setFont(new Font("Raleway",Font.BOLD,22));
		pin.setBounds(100,370,200,30);
		add(pin);
		
		//DUMMY PIN NUMBER LABEL
		dummyPinNo=new JLabel("XXXX");
		dummyPinNo.setFont(new Font("Raleway",Font.BOLD,22));
		dummyPinNo.setBounds(330,370,300,30);
		add(dummyPinNo);
		
		//SERVICES REQUIRED LABEL
		services=new JLabel("Services Required:");
		services.setFont(new Font("Raleway",Font.BOLD,22));
		services.setBounds(100,440,300,30);
		add(services);
		
		//SERVICES CHECKBOXES
		c1=new JCheckBox("ATM CARD");
		c1.setBackground(Color.WHITE);
		c1.setFont(new Font("Raleway",Font.BOLD,16));
		c1.setBounds(100,500,200,30);
		add(c1);
		
		c2=new JCheckBox("Internet Banking");
		c2.setBackground(Color.WHITE);
		c2.setFont(new Font("Raleway",Font.BOLD,16));
		c2.setBounds(350,500,200,30);
		add(c2);
		
		c3=new JCheckBox("Mobile Banking");
		c3.setBackground(Color.WHITE);
		c3.setFont(new Font("Raleway",Font.BOLD,16));
		c3.setBounds(100,550,200,30);
		add(c3);
		
		c4=new JCheckBox("Email and SMS Alerts");
		c4.setBackground(Color.WHITE);
		c4.setFont(new Font("Raleway",Font.BOLD,16));
		c4.setBounds(350,550,200,30);
		add(c4);
		
		c5=new JCheckBox("Cheque Book");
		c5.setBackground(Color.WHITE);
		c5.setFont(new Font("Raleway",Font.BOLD,16));
		c5.setBounds(100,600,200,30);
		add(c5);
		
		c6=new JCheckBox("Estatement");
		c6.setBackground(Color.WHITE);
		c6.setFont(new Font("Raleway",Font.BOLD,16));
		c6.setBounds(350,600,200,30);
		add(c6);
		
		c7=new JCheckBox("I hereby declare that above provided details are correct to the best of my knowledge");
		c7.setBackground(Color.WHITE);
		c7.setFont(new Font("Raleway",Font.BOLD,12));
		c7.setBounds(100,680,600,30);
		add(c7);
		
		//SUMBIT BUTTON
		submit=new JButton("Submit");
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.setFont(new Font("Raleway",Font.BOLD,14));
		submit.setBounds(250,720,100,30);
		submit.addActionListener(this);
		add(submit);
		
		//CANCEL BUTTON
		cancel=new JButton("Cancel");
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.setFont(new Font("Raleway",Font.BOLD,14));
		cancel.setBounds(420,720,100,30);
		cancel.addActionListener(this);
		add(cancel);
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(850,820);
		setLocation(350,0);
		setVisible(true);				
	}

	public static void main(String[] args) {
	     new SignupThree("");

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==submit) {
			String accountType=null;
			if(r1.isSelected()) {
				accountType="Savings Account";
			}else if(r2.isSelected()){
				accountType="Fixed Deposit Account";
			}else if(r3.isSelected()) {
				accountType="Current Account";
			}else if(r4.isSelected()) {
				accountType="Reccuring Deposit Accoount";
			}
			
			Random r=new Random();
			String cardNum=""+Math.abs((r.nextLong()%90000000L)+6040184500000000L);
	
			String pinNum=""+Math.abs((r.nextLong()%9000L)+1000L);
			String facility="";
			if(c1.isSelected()){
				facility =facility +"ATM Card,";
			}if(c2.isSelected()) {
				facility =facility +" Internet Banking,";
			}if(c3.isSelected()) {
				facility =facility +" Mobile Banking,";
			}if(c4.isSelected()) {
				facility =facility +" Email and SMS Alerts,";
			}if(c5.isSelected()) {
				facility =facility +" Cheque Book,";
			}if(c6.isSelected()) {
				facility =facility +" E-Statement,";
			}
			
			try {
				if(accountType.equals("")){
					JOptionPane.showMessageDialog(null, "Account Type Is  Required");
				}else {
					Conn conn=new Conn();
					String query1="insert into signupthree values('"+formno+"','"+accountType+"','"+cardNum+"','"+pinNum+"','"+facility +"')"; 
				    conn.s.executeUpdate(query1);
					String query2="insert into login values('"+formno+"','"+cardNum+"','"+pinNum+"')"; 
					conn.s.executeUpdate(query2);
				    
				    JOptionPane.showMessageDialog(null, "Card Number: "+cardNum+"\n Pin:"+pinNum);			    
				}
				
				//Logic to open a deposit amount interface as soon as a user creates an account
				setVisible(false);
				new Deposit(pinNum).setVisible(true);
				
			}catch(Exception e) {
				System.out.println(e);
			}				
		}else if(ae.getSource()==cancel) {
			//It will open login page
			setVisible(false);
			new Login().setVisible(true);			
		}			
	}
}
