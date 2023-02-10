package Atm_System;

import javax.swing.*;
import  java.awt.event.* ;
import java.awt.* ;

public class Transaction  extends JFrame implements ActionListener{

    JButton deposit , withdraw , fast_cash , mini_statement , pin_change , enquiry , exit ;
    String pin_number ;
    public Transaction(String pin_number){
        this.pin_number = pin_number ;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Atm_System/icon/atm.jpg")) ;
        Image i2 = i1.getImage().getScaledInstance(900, 900 , Image.SCALE_DEFAULT) ;
        ImageIcon i3 = new ImageIcon(i2) ;
        JLabel image = new JLabel(i3) ;
        image.setBounds(0 , 0 , 900, 900);
        add(image) ;

        JLabel text = new JLabel("SELECT YOUR TRANSACTION") ;
        text.setFont(new Font("Arial" , Font.BOLD , 16));
        text.setBounds(210 , 300 , 700 , 35);
        text.setForeground(Color.WHITE);
        image.add(text) ;

        deposit = new JButton("Deposit") ;
        deposit.setFont(new Font("Raleway" , Font.BOLD , 15) );
        deposit.setBounds(170 , 415 , 150 , 30);
        image.add(deposit) ;
        deposit.addActionListener(this);


        withdraw = new JButton("Cash Withdraw") ;
        withdraw.setFont(new Font("Raleway" , Font.BOLD , 15) );
        withdraw.setBounds(355 , 415 , 150 , 30);
        image.add(withdraw) ;
        withdraw.addActionListener(this);



        fast_cash = new JButton("Fast Cash") ;
        fast_cash.setFont(new Font("Raleway" , Font.BOLD , 15) );
        fast_cash.setBounds(170 , 450 , 150 , 30);
        image.add(fast_cash) ;
        fast_cash.addActionListener(this);


        mini_statement = new JButton("Mini statement") ;
        mini_statement.setFont(new Font("Raleway" , Font.BOLD , 15) );
        mini_statement.setBounds(355 , 450 , 150 , 30);
        image.add(mini_statement) ;
        mini_statement.addActionListener(this);

        pin_change = new JButton("Pin Change") ;
        pin_change.setFont(new Font("Raleway" , Font.BOLD , 15) );
        pin_change.setBounds(170 , 485 , 150 , 30);
        image.add(pin_change) ;
        pin_change.addActionListener(this);


        enquiry = new JButton("Balance Enquiry") ;
        enquiry.setFont(new Font("Raleway" , Font.BOLD , 14) );
        enquiry.setBounds(355 , 485 , 150 , 30);
        image.add(enquiry) ;
        enquiry.addActionListener(this);

        exit = new JButton("Exit") ;
        exit.setFont(new Font("Raleway" , Font.BOLD , 15) );
        exit.setBounds(355 , 520 , 150 , 30);
        image.add(exit) ;
        exit.addActionListener(this);

        setSize(900 , 900);
        setLocation(300 , 0);
//        setUndecorated(true);
        setLayout(null);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pin_number).setVisible(true);

        }
        else if (ae.getSource() == withdraw){
            setVisible(false);
            new Withdraw(pin_number).setVisible(true);

        }
        else if (ae.getSource() == fast_cash){
            setVisible(false);
            new FastCash(pin_number).setVisible(true);

        }
        else if (ae.getSource() == mini_statement){
//            setVisible(false);
            new MiniStatement(pin_number).setVisible(true);

        }
        else if (ae.getSource() == pin_change){
            setVisible(false);
            new PinChange(pin_number).setVisible(true);

        }
        else if (ae.getSource() == enquiry){
            setVisible(false);
            new BalanceEnquiry(pin_number).setVisible(true);
        }else {
            System.exit(0);
        }

    }

    public static void main(String[] args) {
        new Transaction("") ;

    }
}
