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

public class Deposit extends JFrame implements ActionListener{
	JLabel image,depositAmntText;
	JTextField depositAmntTF;
	JButton deposit,back;
	String pinNumber;
	
	Deposit(String pinNumber){
		
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
		depositAmntText=new JLabel("Enter the amount you want to deposit:");
		depositAmntText.setForeground(Color.WHITE);
		depositAmntText.setFont(new  Font("Calibri",Font.BOLD,16));
		depositAmntText.setBounds(170,300,400,20);
		image.add(depositAmntText);
		
		//DEPOSIT AMOUNT TEXTFIELD
		depositAmntTF=new JTextField();
		depositAmntTF.setFont(new Font("Raleway" ,Font.BOLD,22));
		depositAmntTF.setBounds(170,350,320,25);
        image.add(depositAmntTF);
        
		//DEPOSIT AMOUNT BUTTON
        deposit=new JButton("Deposit");
        deposit.setBounds(355,455,150,30);
    	deposit.addActionListener(this);
        image.add(deposit);
        
      //BACK BUTTON
        back=new JButton("Back");
        back.setBounds(355,490,150,30);
    	back.addActionListener(this);
        image.add(back);
        
		setSize(900, 900);
		setLocation(300,0);
		setVisible(true);		
	}//CONSTRUCTOR

	public static void main(String[] args) {
		new Deposit("");
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==deposit) {
			String amountString=depositAmntTF.getText();
			Date date=new Date();
			if(amountString.equals("")){
				System.out.println("Please Enter The Amount You Want To Deposit!");			
			}else {
				try {
					Conn conn=new Conn();
					String query="insert into bank values('"+pinNumber+"','"+date+"','Deposit','"+amountString+"')";
				    conn.s.executeUpdate(query);
				    JOptionPane.showMessageDialog(null, "Rs "+amountString+" Deposited Successfully!");
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
