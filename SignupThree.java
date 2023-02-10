package Atm_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.* ;
import java.sql.* ;

public class SignupThree extends JFrame implements ActionListener {
    String form_no ;
    JLabel acc_type  , card , card_no  , pin ,pin_no, service ;
    JButton submit , cancel ;
    JRadioButton savingAc , fixedDep , currentAc , recDep ;
    JCheckBox c1 , c2 , c3 , c4 , c5 , c6  , c7 ;


    public SignupThree(String form_no){
        this.form_no  = form_no ;

        setTitle("Account Details");
        getContentPane().setBackground(Color.CYAN);

        JLabel form = new JLabel("Page 3 : Account Details ") ;
        form.setFont(new Font("Raleway", Font.BOLD , 25));
        form.setBounds(250 , 40 , 600 , 40);
        add(form) ;

        acc_type = new JLabel("Account Type :") ;
        acc_type.setFont(new Font("Raleway", Font.BOLD , 23));
        acc_type.setBounds(100 , 140 , 200 , 30);
        add(acc_type) ;

        savingAc = new JRadioButton("Saving Account") ;
        savingAc.setFont(new Font("Raleway", Font.BOLD , 16));
        savingAc.setBounds(120 , 180 , 150 , 30 );
        savingAc.setBackground(Color.CYAN);
        add(savingAc) ;


        fixedDep = new JRadioButton("Fixed Deposit Account") ;
        fixedDep.setFont(new Font("Raleway", Font.BOLD , 16));
        fixedDep.setBounds(400 , 180 , 200 , 30 );
        fixedDep.setBackground(Color.CYAN);
        add(fixedDep) ;

        currentAc = new JRadioButton("Current Account") ;
        currentAc.setFont(new Font("Raleway", Font.BOLD , 16));
        currentAc.setBounds(120 , 220 , 150 , 30 );
        currentAc.setBackground(Color.CYAN);
        add(currentAc) ;

        recDep = new JRadioButton("Recurring Deposit Account") ;
        recDep.setFont(new Font("Raleway", Font.BOLD , 16));
        recDep.setBounds(400 , 220 , 250 , 30 );
        recDep.setBackground(Color.CYAN);
        add(recDep) ;

        ButtonGroup accGroup = new ButtonGroup() ;
        accGroup.add(savingAc) ;
        accGroup.add(fixedDep) ;
        accGroup.add(currentAc) ;
        accGroup.add(savingAc) ;

        card = new JLabel("Card Number :") ;
        card.setFont(new Font("Raleway", Font.BOLD , 23));
        card.setBounds(100 , 280 , 200 , 30);
        add(card) ;

        JLabel info1 = new JLabel("Your 16 digit card number") ;
        info1.setFont(new Font("Raleway" , Font.BOLD , 12));
        info1.setBounds(100 , 310 , 300 , 20);
        add(info1) ;


        card_no = new JLabel("XXXX-XXXX-XXXX-5412") ;
        card_no.setFont(new Font("Raleway", Font.BOLD , 23));
        card_no.setBounds(350 , 280 , 300 , 30);
        add(card_no) ;


        pin = new JLabel("PIN :") ;
        pin.setFont(new Font("Raleway", Font.BOLD , 23));
        pin.setBounds(100 , 350 , 200 , 30);
        add(pin) ;

        JLabel info2 = new JLabel("Your 4 digit password") ;
        info2.setFont(new Font("Raleway" , Font.BOLD , 12));
        info2.setBounds(100 , 380 , 300 , 20);
        add(info2) ;


        pin_no = new JLabel("XXXX") ;
        pin_no.setFont(new Font("Raleway", Font.BOLD , 23));
        pin_no.setBounds(350 , 350 , 300 , 30);
        add(pin_no) ;

        service = new JLabel("Services Required :") ;
        service.setFont(new Font("Raleway", Font.BOLD , 23));
        service.setBounds(100 , 440 , 250 , 30);
        add(service) ;

        c1 = new JCheckBox("ATM card") ;
        c1.setFont(new Font("Raleway" , Font.BOLD , 15));
        c1.setBounds(100 , 480 , 150 , 30 );
        c1.setBackground(Color.CYAN);
        add(c1) ;

        c2 = new JCheckBox("Internet Banking") ;
        c2.setFont(new Font("Raleway" , Font.BOLD , 15));
        c2.setBounds(380 , 480 , 150 , 30 );
        c2.setBackground(Color.CYAN);
        add(c2) ;


        c3 = new JCheckBox("Mobile Banking") ;
        c3.setFont(new Font("Raleway" , Font.BOLD , 15));
        c3.setBounds(100 , 520 , 150 , 30 );
        c3.setBackground(Color.CYAN);
        add(c3) ;


        c4 = new JCheckBox("Email & SMS Alerts") ;
        c4.setFont(new Font("Raleway" , Font.BOLD , 15));
        c4.setBounds(380 , 520 , 200 , 30 );
        c4.setBackground(Color.CYAN);
        add(c4) ;

        c5 = new JCheckBox("Cheque Book") ;
        c5.setFont(new Font("Raleway" , Font.BOLD , 15));
        c5.setBounds(100 , 560 , 150 , 30 );
        c5.setBackground(Color.CYAN);
        add(c5) ;

        c6 = new JCheckBox("E-Statement") ;
        c6.setFont(new Font("Raleway" , Font.BOLD , 15));
        c6.setBounds(380 , 560 , 150 , 30 );
        c6.setBackground(Color.CYAN);
        add(c6) ;

        c7 = new JCheckBox("I hereby declares that the above entered details are correct ") ;
        c7.setFont(new Font("Raleway" , Font.BOLD , 13));
        c7.setBounds(100 , 660 , 500 , 30 );
        c7.setBackground(Color.CYAN);
        add(c7) ;

        cancel = new JButton("Cancel") ;
        cancel.setFont(new Font("Arial" , Font.BOLD  , 15));
        cancel.setBounds(250 , 720 , 100 , 30);
        cancel.setBackground(Color.RED);
        cancel.setForeground(Color.WHITE);
        add(cancel) ;
        cancel.addActionListener(this);
        
        submit = new JButton("Submit") ;
        submit.setFont(new Font("Arial" , Font.BOLD  , 15));
        submit.setBounds(450 , 720 , 100 , 30);
        submit.setBackground(Color.BLUE);
        cancel.setForeground(Color.WHITE);
        add(submit) ;
        submit.addActionListener(this);



        setSize(850 , 820);
        setLocation(350 , 0);
        setLayout(null);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent ae){

        if (ae.getSource() == submit){
            String accountType = null ;
            if (savingAc.isSelected()){
                accountType = "Saving Account" ;
            }else if(fixedDep.isSelected()) {
                accountType = "Fixed Deposit Account" ;
            }else if(currentAc.isSelected()) {
                accountType = "Current Account" ;
            }else {
                accountType = "Recurring Deposit Account" ;
            }

            Random random = new Random() ;
            String card_number = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L) ;
            String pin_number = "" + Math.abs((random.nextLong() % 9000L) + 1000L);

            String facility = "" ;
            if (c1.isSelected()){
                facility = facility + "ATM card" ;
            }else if(c2.isSelected()){
                facility = facility + "Internet Banking" ;
            }else if(c3.isSelected()){
                facility = facility + "Mobile Banking" ;
            }else if(c4.isSelected()){
                facility = facility + "Email & SMS Alerts" ;
            }else if(c5.isSelected()){
                facility = facility + "Cheque Book" ;
            }else {
                facility = facility + "E-Statement" ;
            }

            try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null ,"Account type is required" );
                }else {
                    Conn c = new Conn() ;
                    String query1  =  "insert into SignupThree values('"+form_no+"','"+accountType+"','"+card_number+"','"+pin_number+"','"+facility+"')" ;
                    String query2  =  "insert into Login values('"+form_no+"','"+card_number+"','"+pin_number+"')" ;
                    c.s.executeUpdate(query1) ;
                    c.s.executeUpdate(query2) ;
                    JOptionPane.showMessageDialog(null , "Card Number : "+card_number+"\n pin : "+pin_number);

                }


            }catch (Exception  e){
                System.out.println(e);
            }


        }else if (ae.getSource() == cancel){

        }

    }

    public static void main(String[] args) {

        new SignupThree("") ;

    }
}
