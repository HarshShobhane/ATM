package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{
	
	JButton login,clear,signup;
	JTextField cardTextField;
	JPasswordField pinTextField; 
	
	Login(){
		setTitle("ATM"); //Jframe 		
		setLayout(null);
		
		//BANK icon
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
		Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel label=new JLabel(i3);
		label.setBounds(70,10,100,100);
		add(label);
		
		JLabel text=new JLabel("Welcome To ATM");
		text.setFont(new Font("Osward",Font.BOLD,38));
		text.setBounds(200,40,400,40);
		add(text);
		
		//CARD NUMBER
		JLabel cardno=new JLabel("Card Number:");
		cardno.setFont(new Font("Raleway",Font.BOLD,24));
		cardno.setBounds(120,150,200,30);
		add(cardno);
		
		//CARD NUMBER TEXTFIELD
		cardTextField = new JTextField();
		cardTextField.setBounds(300,150,230,30);
		cardTextField.setFont(new Font("Arial",Font.BOLD,14));
		add(cardTextField);
		
		JLabel pin=new JLabel("Pin:");
		pin.setFont(new Font("Raleway",Font.BOLD,24));
		pin.setBounds(120,220,250,30);
		add(pin);
		
		//PIN TEXTFIELD
		pinTextField = new JPasswordField();
		pinTextField.setBounds(300,220,230,30);
		pinTextField.setFont(new Font("Arial",Font.BOLD,14));
		add(pinTextField);
		
		//SIGN IN BUTTON
		login=new JButton("SIGN IN");
		login.setBounds(300,300,100,30);
		login.setBackground(Color.BLACK);
		login.setForeground(Color.WHITE);
		login.addActionListener(this);
		add(login);
		
		//CLEAR BUTTON
		clear=new JButton("CLEAR");
		clear.setBounds(430,300,100,30);
		clear.setBackground(Color.BLACK);
		clear.setForeground(Color.WHITE);
		clear.addActionListener(this);
		add(clear);
		
		//SIGN UP BUTTON
		signup=new JButton("SIGN UP");
		signup.setBounds(300,350,230,30);
		signup.setBackground(Color.BLACK);
		signup.setForeground(Color.WHITE);
		signup.addActionListener(this);
		add(signup);		
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(800,480);
		setVisible(true);
		setLocation(350,200);	
	}
	
	public static void main(String[] args) {
		new Login();
	}//main()

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==clear) {
			cardTextField.setText("");
			pinTextField.setText("");		
		} else if(ae.getSource()==login) {
			Conn conn=new Conn();
			String cardNumber=cardTextField.getText();
			String pinNumber=pinTextField.getText();
			String query="select*from login where card_number = '"+cardNumber+"' and pin ='"+pinNumber+"'";
			try {
				ResultSet rs=conn.s.executeQuery(query);
				if(rs.next()) {
					setVisible(false);
					new Transations(pinNumber).setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null,"Incorrect Credentials");
				}				
			}catch(Exception e) {
				System.out.println(e);
			}
		}else if(ae.getSource()==signup) {
			setVisible(false);
			new SignupOne().setVisible(true);
		}		
	}
}//class