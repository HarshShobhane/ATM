package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FastCash extends JFrame implements ActionListener {
	JLabel image,text;
	JButton deposit,withdraw;
	JButton hundred,fiveHundred,oneThousand,twoThousand,fiveThousand,tenThousand,back;
	String pinNumber;
	FastCash(String pinNumber){
		
		this.pinNumber=pinNumber;
		
		setLayout(null);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		image=new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		//LABLES
		
		text=new JLabel("SELECT WITHDRAWL AMOUNT");
		text.setBounds(235,300,700,35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Calibri",Font.BOLD,16));
		image.add(text);
		
		//BUTTONS
		
		//DEPOSIT BUTTON
		hundred=new JButton("RS 100");
		hundred.setBounds(170,418,150,30);
		hundred.addActionListener(this);
		image.add(hundred);
		
		//CASH WITHDRAWAL BUTTON
		fiveHundred=new JButton("RS 500");
		fiveHundred.setBounds(355,418,150,30);
		fiveHundred.addActionListener(this);
		image.add(fiveHundred);
		
		//FAST CASH BUTTON
		oneThousand=new JButton("RS 1000");
		oneThousand.setBounds(170,452,150,30);
		oneThousand.addActionListener(this);
		image.add(oneThousand);
		
		//MINI STATEMENT BUTTON
		twoThousand=new JButton("RS 2000");
		twoThousand.setBounds(355,452,150,30);
		twoThousand.addActionListener(this);
		image.add(twoThousand);
		
		//PIN CHANGE BUTTON
		fiveThousand=new JButton("RS 5000");
		fiveThousand.setBounds(170,487,150,30);
		fiveThousand.addActionListener(this);
		image.add(fiveThousand);
		
		//BALANCE INQUIRY BUTTON
		tenThousand=new JButton("RS 10000 ");
		tenThousand.setBounds(355,487,150,30);
		tenThousand.addActionListener(this);
		image.add(tenThousand);
		
		//EXIT  BUTTON
		back=new JButton("Back");
		back.setBounds(355,520,150,30);
		back.addActionListener(this);
		image.add(back);	
		
		//FRAME SETTINGS
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);	
	}

	public static void main(String[] args) {
		new FastCash("");
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==back){
			setVisible(false);
            new Transations(pinNumber).setVisible(true);				
		}else{
			String amount=((JButton)ae.getSource()).getText().substring(3);// Rs 500=>500
			Conn conn=new  Conn();
			try {
				String qry="select*from bank where pin = '"+pinNumber+"'";
				//Resultset rs=(Resultset)conn.s.executeQuery("select*from bank where pin = '"+pinNumber+"'");
			    ResultSet rs=conn.s.executeQuery(qry);
			    long balance=0L;
			    while(rs.next()) {
			    	if(rs.getString("transaction_type").equals("Deposit")) {
			    		balance+=Integer.parseInt(rs.getString("amount"));	    		
			    	}else {
			    		balance-=Integer.parseInt(rs.getString("amount"));		
			    	}
			    }//while
			    
			    if(ae.getSource()!=back && balance < Integer.parseInt(amount) ) {
			    	JOptionPane.showMessageDialog(null,"Insufficient Balance!");
			    	return;
			    }
			    
			    Date date=new Date();
			    String query="insert into bank values('"+pinNumber+"','"+date+"','Withdrawl','"+amount+"')";
			    conn.s.executeUpdate(query);
			    JOptionPane.showMessageDialog(null,"Rs "+amount+" Debited Successfully");
		
			    setVisible(false);
			    new  Transations(pinNumber).setVisible(true);
 			
			}catch (Exception e) {
				System.out.println(e);
				// TODO: handle exception
			}
		}		
	}
}
