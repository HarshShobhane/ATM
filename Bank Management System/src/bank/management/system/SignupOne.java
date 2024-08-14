package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.*;

import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener{
	
	long randomFormNo;
	JTextField nameTextField,fNameTextField,dobTextField,genderTextField,emailTextField,
	                 mStatusTextField,adrsTextField,cityNameTextField,stateNameTextField,
	                 pinCodeTextField;
	JButton next;
	JRadioButton male,female,married,unmarried,other;
	JDateChooser dateChooser;
	
	SignupOne(){
		
		setLayout(null);
		
		Random r=new Random();
		randomFormNo=Math.abs((r.nextLong()%9000L)+1000L);
		
		//FORM NUMBER LABEL
		JLabel formno=new JLabel("APPLICATION FORM NO:"+randomFormNo);
		formno.setFont(new Font("Raleway",Font.BOLD,38));
		formno.setBounds(140,20,600,40);
		add(formno);
		
		//PERSONAL DETAILS  LABEL
		JLabel personalDetails=new JLabel("Page 1:Personal Details");
		personalDetails.setFont(new Font("Raleway",Font.BOLD,22));
		personalDetails.setBounds(280,80,400,30);
		add(personalDetails);
		
		//NAME LABEL
		JLabel name=new JLabel("Name:");
		name.setFont(new Font("Raleway",Font.BOLD,20));
		name.setBounds(100,140,100,30);
		add(name);
		
		//NAME TEXTFIELD
		nameTextField=new JTextField();
		nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
		nameTextField.setBounds(300,140,400,30);
		add(nameTextField);
			
		//FATHER'S NAME LABEL
		JLabel fname=new JLabel("Father's Name:");
		fname.setFont(new Font("Raleway",Font.BOLD,20));
		fname.setBounds(100,190,200,30);
		add(fname);
		
		//FATHER'S NAME TEXTFIELD
		fNameTextField=new JTextField();
		fNameTextField.setFont(new Font("Raleway",Font.BOLD,14));
		fNameTextField.setBounds(300,190,400,30);
		add(fNameTextField);
		
		//DOB  LABEL
		JLabel dob=new JLabel("Date Of Birth:");
		dob.setFont(new Font("Raleway",Font.BOLD,20));
		dob.setBounds(100,240,200,30);
		add(dob);
		
		//DOB TEXTFIELD
		dateChooser=new JDateChooser();
		dateChooser.setBounds(300,240,400,30);
		dateChooser.setForeground(new Color(105,105,105));
		add(dateChooser);
		
		//GENDER  LABEL
		JLabel gender=new JLabel("Gender:");
		gender.setFont(new Font("Raleway",Font.BOLD,20));
		gender.setBounds(100,290,200,30);
		add(gender);
		
		//JRadioButton TEXTFIELD
		male=new JRadioButton("Male");
		male.setBounds(300,290,60,30);
		male.setBackground(Color.WHITE);
		add(male);
		
		female=new JRadioButton("Female");
		female.setBounds(450,290,120,30);
		female.setBackground(Color.WHITE);
		add(female);
		
		ButtonGroup buttonGroup=new ButtonGroup();
		buttonGroup.add(male);
		buttonGroup.add(female);
			
		//EMAIL  LABEL
		JLabel email=new JLabel("Email:");
		email.setFont(new Font("Raleway",Font.BOLD,20));
		email.setBounds(100,340,200,30);
		add(email);
		
		//EMAIL TEXTFIELD
		emailTextField=new JTextField();
		emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
		emailTextField.setBounds(300,340,400,30);
		add(emailTextField);
				
		//MARITAL STATUS  LABEL
		JLabel mStatus=new JLabel("Marital Status:");
		mStatus.setFont(new Font("Raleway",Font.BOLD,20));
		mStatus.setBounds(100,390,200,30);
		add(mStatus);
		
		//MARITAL STATUS  TEXTFIELD
		married=new JRadioButton("Married");
		married.setBounds(300,390,100,30);
		married.setBackground(Color.WHITE);
		add(married);
		
		unmarried=new JRadioButton("Unmarried");
		unmarried.setBounds(450,390,100,30);
		unmarried.setBackground(Color.WHITE);
		add(unmarried);
		
		other=new JRadioButton("Other");
		other.setBounds(630,390,100,30);
		other.setBackground(Color.WHITE);
		add(other);
				
		ButtonGroup maritalGroup=new ButtonGroup();
		maritalGroup.add(married);
		maritalGroup.add(unmarried);
		maritalGroup.add(other);		
		
		// ADDRESS  LABEL
		JLabel adrs=new JLabel("Address:");
		adrs.setFont(new Font("Raleway",Font.BOLD,20));
		adrs.setBounds(100,440,200,30);
		add(adrs);
		
		//ADDRESS TEXTFIELD
		adrsTextField=new JTextField();
		adrsTextField.setFont(new Font("Raleway",Font.BOLD,14));
		adrsTextField.setBounds(300,440,400,30);
		add(adrsTextField);
				
		// CITY  LABEL
		JLabel city=new JLabel("City:");
		city.setFont(new Font("Raleway",Font.BOLD,20));
		city.setBounds(100,490,200,30);
		add(city);
		
		//CITY TEXTFIELD
		cityNameTextField=new JTextField();
		cityNameTextField.setFont(new Font("Raleway",Font.BOLD,14));
		cityNameTextField.setBounds(300,490,400,30);
		add(cityNameTextField);
		
		// STATE  LABEL
		JLabel state=new JLabel("State:");
		state.setFont(new Font("Raleway",Font.BOLD,20));
		state.setBounds(100,540,200,30);
		add(state);
		
		//STATE TEXTFIELD
		stateNameTextField=new JTextField();
		stateNameTextField.setFont(new Font("Raleway",Font.BOLD,14));
		stateNameTextField.setBounds(300,540,400,30);
		add(stateNameTextField);
						
		// PIN CODE  LABEL
		JLabel pinCode=new JLabel("Pin Code:");
		pinCode.setFont(new Font("Raleway",Font.BOLD,20));
		pinCode.setBounds(100,590,200,30);
		add(pinCode);	
		
		//PIN TEXTFIELD
		pinCodeTextField=new JTextField();
		pinCodeTextField.setFont(new Font("Raleway",Font.BOLD,14));
		pinCodeTextField.setBounds(300,590,400,30);
		add(pinCodeTextField);
				
		//NEXT BUTTON
		next=new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setFont(new Font("Raleway",Font.BOLD,14));
		next.setBounds(620,660,80,30);
		next.addActionListener(this);
		add(next);		
		
		//MAIN FRAME COLOR
		getContentPane().setBackground(Color.WHITE);
		
		//MAIN FRAME
		setSize(850,800);
		setLocation(350,10);
		setVisible(true);
	}

	public static void main(String[] args) {
		new  SignupOne();
	}//main()

	@Override
	public void actionPerformed(ActionEvent ae) {
		String formno=""+randomFormNo;//long
		String name=nameTextField.getText();
		String fname=nameTextField.getText();
		String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
		String gender=null;
		if(male.isSelected()) {
			gender="Male";
		}else if(female.isSelected()) {
			gender="Female";
		}
		
		String email=emailTextField.getText();
		
		String marital=null;
		if(married.isSelected()){
			marital="Married";
		}else if(unmarried.isSelected()){
			marital="Unmarried";
		}else if(other.isSelected()) {
			marital="Other";
		}
		
		String address=adrsTextField.getText();
		String city=cityNameTextField.getText();
		String state=stateNameTextField.getText();
		String pin=pinCodeTextField.getText();
		
		try {
			if(name.equals("")) {
				JOptionPane.showMessageDialog(null,"Name is required");
			}else if(fname.equals("")){
				JOptionPane.showMessageDialog(null,"Father name  is required");			
			}else if(dob.equals("")){
				JOptionPane.showMessageDialog(null,"Date of birth is required");			
			}else {
				Conn c=new Conn();
				String query="INSERT INTO signup VALUES('"+randomFormNo+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
			    c.s.executeUpdate(query);
			    
			    setVisible(false);
			    new SignupTwo(formno).setVisible(true);
			}
		}catch(Exception e) {
			System.out.println(e);
		}		
	}//ae
}//class
