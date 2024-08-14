package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Transations extends JFrame implements ActionListener {
	JLabel image,text;
	JButton deposit,withdraw,fastCash,miniStmnt,pinChange,balanceInqry,exit;
	String pinNumber;
	Transations(String pinNumber){
		
		this.pinNumber=pinNumber;
		
		setLayout(null);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		image=new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		//LABEL	
		text=new JLabel("Please select your Transaction");
		text.setBounds(235,300,700,35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Calibri",Font.BOLD,16));
		image.add(text);
		
		//BUTTONS
		
		//DEPOSIT BUTTON
		deposit=new JButton("Deposit");
		deposit.setBounds(170,418,150,30);
		deposit.addActionListener(this);
		image.add(deposit);
		
		//CASH WITHDRAWAL BUTTON
		withdraw=new JButton("Cash Withdrwal");
		withdraw.setBounds(355,418,150,30);
		withdraw.addActionListener(this);
		image.add(withdraw);
		
		//FAST CASH BUTTON
        fastCash=new JButton("Fast Cash");
        fastCash.setBounds(170,452,150,30);
        fastCash.addActionListener(this);
		image.add(fastCash);
		
		//MINI STATEMENT BUTTON
		miniStmnt=new JButton("Mini Statement ");
		miniStmnt.setBounds(355,452,150,30);
		miniStmnt.addActionListener(this);
		image.add(miniStmnt);
		
		//PIN CHANGE BUTTON
        pinChange=new JButton("Pin Change");
        pinChange.setBounds(170,487,150,30);
        pinChange.addActionListener(this);
		image.add(pinChange);
		
		//BALANCE INQUIRY BUTTON
		balanceInqry=new JButton("Balance Inquiry ");
		balanceInqry.setBounds(355,487,150,30);
		balanceInqry.addActionListener(this);
		image.add(balanceInqry);
		
		//EXIT  BUTTON
		exit=new JButton("Exit");
		exit.setBounds(355,520,150,30);
		exit.addActionListener(this);
		image.add(exit);	
		
		//FRAME SETTINGS
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);	
	}

	public static void main(String[] args) {
		new Transations("");

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==exit){
			System.exit(0);		
		}else if(ae.getSource()==deposit){
			setVisible(false);
			new Deposit(pinNumber).setVisible(true);		
		}else if(ae.getSource()==withdraw){
			setVisible(false);
            new Withdrawl(pinNumber).setVisible(true);
		}else if(ae.getSource()==fastCash) {
			setVisible(false);
            new FastCash(pinNumber).setVisible(true);
		}else if(ae.getSource()==pinChange) {
			setVisible(false);
            new PinChange(pinNumber).setVisible(true);
		}else if(ae.getSource()==balanceInqry) {
			setVisible(false);
            new BalanceInquiry(pinNumber).setVisible(true);
		}else if(ae.getSource()==miniStmnt) {
			//setVisible(false);
			new MiniStatement(pinNumber).setVisible(true);
		}	
	}
}
