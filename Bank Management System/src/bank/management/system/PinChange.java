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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PinChange extends JFrame implements ActionListener{
	
	JLabel image,pinChangeLabel,pinTextLabel,reEnterNewPinLabel;
	JPasswordField pinTextField,reEnterNewPinTextField;
	JButton pinChangeButton,back;
	String pinNumber;
	
	PinChange(String pinNumber){
		this.pinNumber=pinNumber;
		setLayout(null);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		
		image=new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		//PIN CHANGE LABEL
		pinChangeLabel=new JLabel("CHANGE YOUR PIN");
		pinChangeLabel.setForeground(Color.WHITE);
		pinChangeLabel.setFont(new Font("Raleway",Font.BOLD,16));
		pinChangeLabel.setBounds(250,280,500,20);
		image.add(pinChangeLabel);
		
		//NEW PIN LABEL
		pinTextLabel=new JLabel("New PIN : ");
		pinTextLabel.setForeground(Color.WHITE);
		pinTextLabel.setFont(new Font("Raleway",Font.BOLD,16));
		pinTextLabel.setBounds(165,320,180,25);
		image.add(pinTextLabel);
		
		//RE-ENTER NEW PIN LABEL
		reEnterNewPinLabel=new JLabel("Re-Enter New PIN : ");
		reEnterNewPinLabel.setForeground(Color.WHITE);
		reEnterNewPinLabel.setFont(new Font("Raleway",Font.BOLD,16));
		reEnterNewPinLabel.setBounds(165,360,180,25);
		image.add(reEnterNewPinLabel);
		
		//ENTER PIN TEXTFIELD
		pinTextField=new JPasswordField();
		pinTextField.setFont(new Font("Raleway", Font.BOLD, 25));
		pinTextField.setBounds(330,320,180,25);
		image.add(pinTextField);
		
		//RE-ENTER PIN TEXTFIELD
		reEnterNewPinTextField=new JPasswordField();
		reEnterNewPinTextField.setFont(new Font("Raleway", Font.BOLD, 25));
		reEnterNewPinTextField.setBounds(330,360,180,25);
		image.add(reEnterNewPinTextField);
		
		//PIN CHANGE BUTTON
		pinChangeButton=new JButton("CHANGE");
		pinChangeButton.setBounds(355,485,150,30);
		pinChangeButton.addActionListener(this);
		image.add(pinChangeButton);
		
		//BACK BUTTON
		back=new JButton("BACK");
		back.setBounds(355,520,150,30);
		back.addActionListener(this);
		image.add(back);	
		
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new PinChange("").setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		
	  if(ae.getSource()==pinChangeButton) {
		    try {
					String newPin=pinTextField.getText();
					String reEnteredPin=reEnterNewPinTextField.getText();
					
					if(!newPin.equals(reEnteredPin)) {
						JOptionPane.showMessageDialog(null, "Entered PIN doesnt match");
						return;
					}
					
					if(newPin.equals("")) {
						JOptionPane.showMessageDialog(null, "Please Enter PIN");
						return;
					}
					
					if(reEnteredPin.equals("")) {
						JOptionPane.showMessageDialog(null, "Please Enter New PIN");
						return;
					}
					
					Conn conn=new Conn();
					String query1="update bank set pin ='"+reEnteredPin+"' where pin = '"+pinNumber+"'";
					String query2="update login set pin ='"+reEnteredPin+"' where pin = '"+pinNumber+"'";
					String query3="update signupthree set pin_number ='"+reEnteredPin+"' where pin_number = '"+pinNumber+"'";
					
					conn.s.executeUpdate(query1);
					conn.s.executeUpdate(query2);
					conn.s.executeUpdate(query3);
					JOptionPane.showMessageDialog(null, "Your PIN has been changed successfully!");
					setVisible(false);
					new Transations(reEnteredPin).setVisible(true);
					
			}catch (Exception e) {
				System.out.println(e);
			  }
		}else {
			setVisible(false);
			new Transations(pinNumber).setVisible(true);		
		}	
	}
}
