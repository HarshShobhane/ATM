package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.*;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniStatement extends JFrame implements ActionListener {

    JLabel bankName, cardNum, miniStatement, balance;
    String pinNumber;
    JButton printButton;

    MiniStatement(String pinNumber) {
        this.pinNumber = pinNumber;

        setTitle("Mini Statement");
        setLayout(null);

        // Labels
        miniStatement = new JLabel();
        miniStatement.setBounds(20, 140, 400, 200);
        add(miniStatement);
        
    	//BANK icon
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/sunshine.png"));
		Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon i3=new ImageIcon(i2);
		JLabel label=new JLabel(i3);
		label.setBounds(350,10,100,100);
		add(label);

        bankName = new JLabel("Sunshine Bank");
        bankName.setFont(new Font("Calibri", Font.BOLD, 25));
        bankName.setBounds(325,80, 200, 30);//350,30,200,30
        add(bankName);

        cardNum = new JLabel();
        cardNum.setBounds(20,150, 300, 20);
        add(cardNum);

        balance = new JLabel();
        balance.setBounds(20, 400, 300, 20);
        add(balance);

        printButton = new JButton("Print to PDF");
        printButton.setBounds(20, 450, 150, 30);
        printButton.addActionListener(this);
        add(printButton);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin = '" + pinNumber + "'");
            while (rs.next()) {
                cardNum.setText("Card Number: " + rs.getString("card_number").substring(0, 4) + "-XXXX-XXXX-" + rs.getString("card_number").substring(12));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            Conn conn = new Conn();
            long bal = 0L;
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '" + pinNumber + "'");
            StringBuilder statement = new StringBuilder("<html>");
            while (rs.next()) {
                statement.append(rs.getString("date")).append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                         .append(rs.getString("transaction_type")).append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                         .append(rs.getString("amount")).append("<br><br>");
                if (rs.getString("transaction_type").equals("Deposit")) {
                    bal += Long.parseLong(rs.getString("amount"));
                } else {
                    bal -= Long.parseLong(rs.getString("amount"));
                }
            }
            statement.append("</html>");
            miniStatement.setText(statement.toString());
            balance.setText("Your Current Account Balance Is Rs  " + bal);
        } catch (Exception e) {
            System.out.println(e);
        }

        setSize(900, 900);//400,600
        setLocation(20,20);//20,20
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MiniStatement("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == printButton) {
            printToPDF();
        }
    }

    private void printToPDF() {
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        printerJob.setPrintable(new MiniStatementPrintable(this.getContentPane()));
        boolean doPrint = printerJob.printDialog();
        if (doPrint) {
            try {
                printerJob.print();
            } catch (PrinterException e) {
                System.out.println(e);
            }
        }
    }
}
