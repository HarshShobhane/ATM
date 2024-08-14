package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Withdrawl extends JFrame implements ActionListener{
	JLabel image,withdrawAmntText;
	JTextField withdrawAmntTF;
	JButton withdraw,back;
	String pinNumber;
	
	Withdrawl(String pinNumber){
		
		this.pinNumber=pinNumber;
		
		setLayout(null);
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		
		//IMAGE LABEL
		image=new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		//DEPOSIT AMOUNT TEXT LABEL
		withdrawAmntText=new JLabel("Enter the amount you want to withdraw:");
		withdrawAmntText.setForeground(Color.WHITE);
		withdrawAmntText.setFont(new  Font("Calibri",Font.BOLD,16));
		withdrawAmntText.setBounds(170,300,400,20);
		image.add(withdrawAmntText);
		
		//DEPOSIT AMOUNT TEXTFIELD
		withdrawAmntTF=new JTextField();
		withdrawAmntTF.setFont(new Font("Raleway" ,Font.BOLD,22));
		withdrawAmntTF.setBounds(170,350,320,25);
        image.add(withdrawAmntTF);
        
		//DEPOSIT AMOUNT BUTTON
        withdraw=new JButton("Withdraw");
        withdraw.setBounds(355,455,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
      //BACK BUTTON
        back=new JButton("Back");
        back.setBounds(355,490,150,30);
    	back.addActionListener(this);
        image.add(back);
        		
		setSize(900, 900);
		setLocation(300,0);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new Withdrawl("");
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==withdraw) {
			String amountString=withdrawAmntTF.getText();
			Date date=new Date();
			if(amountString.equals("")){
				System.out.println("Please Enter The Amount You Want To Withdraw!");			
			}else {
				try {
					Conn conn=new Conn();
					String query="insert into bank values('"+pinNumber+"','"+date+"','Withdrawl','"+amountString+"')";
				    conn.s.executeUpdate(query);
				    JOptionPane.showMessageDialog(null, "Rs "+amountString+" Withdrawn Successfully!");
				    setVisible(false);
				    new Transations(pinNumber).setVisible(true);
				}catch(Exception e) {
					System.out.println(e);
				}		    
			}			
		}else if(ae.getSource()==back) {
			setVisible(false);
			new Transations(pinNumber).setVisible(true);			
		}	
	}
}
