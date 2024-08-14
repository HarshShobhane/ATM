package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
	
	//long randomFormNo;
	JTextField genderTextField,
	                 mStatusTextField,
	                 panTextField,adharTextField,seniorCitizenTextField;
	JButton next;
	JRadioButton syes,sno,eyes,eno,other;
	JComboBox religionCbox,categoryCbox,occupationCbox,educationCbox,incomeCbox;
	String formno;
		
	SignupTwo(String formno){
		this.formno=formno;
		setLayout(null);
		setTitle("NEW ACCOUNT APPLICATION FORM-PAGE 2 ");
		
		//ADDITIONAL DETAILS  LABEL
		JLabel additionalDetails=new JLabel("Page 2:Additional Details");
		additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
		additionalDetails.setBounds(280,80,400,30);
		add(additionalDetails);
		
		//RELIGION LABEL
		JLabel religion=new JLabel("Religion:");
		religion.setFont(new Font("Raleway",Font.BOLD,20));
		religion.setBounds(100,140,100,30);
		add(religion);
		
		//RELIGION COMBO BOX
		String valReligion[]= {"Hindu","Muslim","Sikh","Christian","Other"};
		religionCbox=new JComboBox(valReligion);
		religionCbox.setBounds(300,140,400,30);
		religionCbox.setBackground(Color.WHITE);
		add(religionCbox);
		
		//CATEGORY LABEL
		JLabel category=new JLabel("Category:");
		category.setFont(new Font("Raleway",Font.BOLD,20));
		category.setBounds(100,190,200,30);
		add(category);
		
		//CATEGORY COMBO BOX
		String valCategory[]= {"OBC","General","SC","ST","Other"};
		categoryCbox=new JComboBox(valCategory);
		categoryCbox.setBounds(300,190,400,30);
		categoryCbox.setBackground(Color.WHITE);
		add(categoryCbox);
		
		//INCOME  LABEL
		JLabel income=new JLabel("Income:");
		income.setFont(new Font("Raleway",Font.BOLD,20));
		income.setBounds(100,240,200,30);
		add(income);
		
		//INCOME COMBO BOX
		String valIncome[]= {"Null","<1,50,000","<2,50,000","<5,00,000",">5,00,000"};
		incomeCbox=new JComboBox(valIncome);
		incomeCbox.setBounds(300,240,400,30);
		incomeCbox.setBackground(Color.WHITE);
		add(incomeCbox);
		
		//EDUCATIONAL  LABEL
		JLabel edu=new JLabel("Educational");
		edu.setFont(new Font("Raleway",Font.BOLD,20));
		edu.setBounds(100,290,200,30);
		add(edu);
				
		//Qualification  LABEL
		JLabel qualification=new JLabel("Qualification:");
		qualification.setFont(new Font("Raleway",Font.BOLD,20));
		qualification.setBounds(100,315,200,30);
		add(qualification);
		
		//EDUCATIONAL COMBO BOX
		String educationValues[]= {"Non-Graduate","Graduate","Post Graduate","Doctrate","Other"};
		educationCbox=new JComboBox(educationValues);
		educationCbox.setBounds(300,315,400,30);
		educationCbox.setBackground(Color.WHITE);
		add(educationCbox);
				
		//OCCUPATION LABEL
		JLabel occupation=new JLabel("Occupation:");
		occupation.setFont(new Font("Raleway",Font.BOLD,20));
		occupation.setBounds(100,390,200,30);
		add(occupation);
		
		//OCCUPATION COMBO BOX
		String occupationValues[]= {"Salaried","Self Emplopyed","Business","Student","Retired","Other"};
		occupationCbox=new JComboBox(occupationValues);
		occupationCbox.setBounds(300,390,400,30);
		occupationCbox.setBackground(Color.WHITE);
		add(occupationCbox);	
		
		// PAN NUMBER  LABEL
		JLabel pan=new JLabel("PAN Number:");
		pan.setFont(new Font("Raleway",Font.BOLD,20));
		pan.setBounds(100,440,200,30);
		add(pan);
		
		//PAN NUMBER TEXTFIELD
		panTextField=new JTextField();
		panTextField.setFont(new Font("Raleway",Font.BOLD,14));
		panTextField.setBounds(300,440,400,30);
		add(panTextField);
				
		// ADHAR  LABEL
		JLabel adhar=new JLabel("Adhar Number:");
		adhar.setFont(new Font("Raleway",Font.BOLD,20));
		adhar.setBounds(100,490,200,30);
		add(adhar);
		
		//ADHAR TEXTFIELD
		adharTextField=new JTextField();
		adharTextField.setFont(new Font("Raleway",Font.BOLD,14));
		adharTextField.setBounds(300,490,400,30);
		add(adharTextField);
		
		// SENIOR CITIZEN  LABEL
		JLabel seniorCitizen=new JLabel("Senior Citizen:");
		seniorCitizen.setFont(new Font("Raleway",Font.BOLD,20));
		seniorCitizen.setBounds(100,540,200,30);
		add(seniorCitizen);
		
		//SENIOR CITIZEN  RADIO BUTTON
		syes=new JRadioButton("YES");
		syes.setBounds(300,540,100,30);
		syes.setBackground(Color.WHITE);
		add(syes);
		
		sno=new JRadioButton("No");
		sno.setBounds(450,540,100,30);
		sno.setBackground(Color.WHITE);
		add(sno);
		
		ButtonGroup seniorC=new ButtonGroup();
		seniorC.add(syes);
		seniorC.add(sno);	
						
		//Existing Account  LABEL
		JLabel pinCode=new JLabel("Existing Account:");
		pinCode.setFont(new Font("Raleway",Font.BOLD,20));
		pinCode.setBounds(100,590,200,30);
		add(pinCode);	
		
		//Existing Account  RADIO BUTTON
		eyes=new JRadioButton("YES");
		eyes.setBounds(300,590,100,30);
		eyes.setBackground(Color.WHITE);
		add(eyes);
				
		eno=new JRadioButton("No");
		eno.setBounds(450,590,100,30);
		eno.setBackground(Color.WHITE);
		add(eno);
				
		ButtonGroup existingAcc=new ButtonGroup();
		existingAcc.add(syes);
		existingAcc.add(sno);
		
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
		new  SignupTwo("");
	}//main()

	@Override
	public void actionPerformed(ActionEvent ae) {
		String sReligion=(String)religionCbox.getSelectedItem();
		String sCategory=(String)categoryCbox.getSelectedItem();
		String sIncome=(String)incomeCbox.getSelectedItem();
		String sEducation=(String)educationCbox.getSelectedItem();
		String sOccupation=(String)occupationCbox.getSelectedItem();
		String seniorCitizen=null;
		if(syes.isSelected()) {
			seniorCitizen="Yes";
		}else if(sno.isSelected()) {
			seniorCitizen="No";
		}
		
		String existingAccount=null;
		if(eyes.isSelected()){
			existingAccount="Yes";
		}else if(eno.isSelected()){
			existingAccount="No";
		}
		
		String sPan=panTextField.getText();
		String sAdhar=adharTextField.getText();
		
		try {
			if(religionCbox.equals("")) {
				JOptionPane.showMessageDialog(null,"Religion is required");
			}else if(sPan.equals("")){
				JOptionPane.showMessageDialog(null,"PAN number is required");
			}else if(sAdhar.equals("")){
				JOptionPane.showMessageDialog(null,"Adhar number is required");
			}else {
				Conn c=new Conn();
				String query="INSERT INTO signuptwo VALUES('"+formno+"','"+sReligion+"','"+sCategory+"','"+sIncome+"','"+sEducation+"','"+sOccupation+"','"+sPan+"','"+sAdhar+"','"+seniorCitizen+"','"+existingAccount+"')";
			    c.s.executeUpdate(query);
			    
			    //SINGUP3 Object
			    setVisible(false);
			    new SignupThree(formno).setVisible(true);	    		    
			}
		}catch(Exception e) {
			System.out.println(e);
		}		
	}//ae
}//class
