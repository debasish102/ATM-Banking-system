package Atm_System;

import  java.awt.event.* ;
import javax.swing.* ;
import java.awt.* ;
import java.util.* ;
import java.sql.* ;

public class MiniStatement extends JFrame{
    String pin_number ;
    JLabel text , bank , card , mini , balance ;
    public MiniStatement(String pin_number){
        this.pin_number = pin_number ;
        setTitle("Mini Statement");

        text = new JLabel() ;
        add(text );

        bank = new JLabel("Bank of India") ;
        bank.setFont(new Font("Raleway", Font.BOLD , 15));
        bank.setBounds(150 , 20 , 100 , 20);
        bank.setForeground(Color.BLUE);
        add(bank) ;


        card = new JLabel();
        card.setBounds(20 , 80 , 300 , 20);
        add(card) ;

        mini = new JLabel() ;
        mini.setBounds(20 , 130 , 400 , 400);
        add(mini) ;

        balance = new JLabel() ;
        balance.setBounds(20 ,  400 , 300 , 20);
        add(balance) ;

        try{
            Conn c = new Conn() ;
            ResultSet rs = c.s.executeQuery("select * from login where pin_number = '"+pin_number+"'") ;
            while (rs.next()){
                card.setText("Card Number : "+ rs.getString("card_number").substring(0,4)+"XXXXXXXX"+rs.getString("card_number").substring(12));
            }

        }catch (Exception e){
            System.out.println(e);
        }


        try{
            Conn c = new Conn();
            int bal = 0 ;
            ResultSet rs = c.s.executeQuery("select * from bank where pin_number = '"+pin_number+"'") ;
            while (rs.next()){
                mini.setText(mini.getText() +"<html>"+ rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount")+"<br><br><html>");
                if (rs.getString("type").equals("Deposit")){
                    bal  += Integer.parseInt(rs.getString("amount")) ;
                }else{
                    bal  -= Integer.parseInt(rs.getString("amount")) ;
                }
            }
            balance.setText("Your current account balance is "+bal);
        }catch (Exception e){
            System.out.println(e);
        }




        setSize(400 , 600);
        setLocation(20 , 20);
//        setUndecorated(true);
        setLayout(null);
        setVisible(true);

    }

    public static void main(String[] args) {
        new MiniStatement("") ;
    }
}
