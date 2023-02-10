package Atm_System;

import javax.swing.*;
import java.awt.*;
import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.* ;

public class PinChange extends  JFrame implements ActionListener {
    JLabel pin  , re_pin  ;
    JPasswordField pin_field ;
    JTextField  re_pin_field ;
    JButton change , back ;
    String pin_number ;
    public PinChange(String pin_number){
        this.pin_number = pin_number ;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Atm_System/icon/atm.jpg")) ;
        Image i2 = i1.getImage().getScaledInstance(900, 900 , Image.SCALE_DEFAULT) ;
        ImageIcon i3 = new ImageIcon(i2) ;
        JLabel image = new JLabel(i3) ;
        image.setBounds(0 , 0 , 900, 900);
        add(image) ;

        JLabel text = new JLabel("CHANGE YOUR PIN ") ;
        text.setFont(new Font("Raleway" , Font.BOLD , 16));
        text.setBounds(250 , 300 , 400 , 20);
        text.setForeground(Color.WHITE);
        image.add(text);

        pin = new JLabel("Enter New Pin ") ;
        pin.setFont(new Font("Raleway", Font.BOLD , 15));
        pin.setBounds(170 , 350 ,180 , 25);
        pin.setForeground(Color.WHITE);
        image.add(pin) ;

        pin_field = new JPasswordField() ;
        pin_field.setFont(new Font("Raleway", Font.BOLD , 15));
        pin_field.setBounds(330 , 350 ,180 , 25);
        image.add(pin_field) ;
        
        re_pin = new JLabel("Re-Enter New Pin ") ;
        re_pin.setFont(new Font("Raleway", Font.BOLD , 15));
        re_pin.setBounds(170 , 400 ,180 , 25);
        re_pin.setForeground(Color.WHITE);
        image.add(re_pin) ;

        re_pin_field = new JTextField() ;
        re_pin_field.setFont(new Font("Raleway", Font.BOLD , 14));
        re_pin_field.setBounds(330 , 400 ,180 , 25);
        image.add(re_pin_field) ;

        change = new JButton("Change") ;
        change.setFont(new Font("Raleway", Font.BOLD , 15));
        change.setBounds(355 , 485 , 120 , 30);
        image.add(change) ;
        change.addActionListener(this);


        back = new JButton("Back") ;
        back.setFont(new Font("Raleway", Font.BOLD , 15));
        back.setBounds(180 , 485 , 120 , 30);
        back.setBackground(Color.RED);
        image.add(back) ;
        back.addActionListener(this);




        setSize(900 , 900);
        setLocation(300 , 0);
//        setUndecorated(true);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change){
            String npin = pin_field.getText() ;
            String rpin = re_pin_field.getText() ;
            if (!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null , "Entered PIN does not match");
                return;
            }

            if (npin.equals("")){
                JOptionPane.showMessageDialog(null , "Please Enter New PIN ");
                return;
            }

            if (rpin.equals("")){
                JOptionPane.showMessageDialog(null , "Please Re-Enter PIN ");
                return;
            }

            try {
                Conn c = new Conn() ;
                String query1 = "update bank set pin_number = '"+rpin+"' where pin_number = '"+pin_number+"'" ;
                String query2 = "update Login set pin_number = '"+rpin+"' where pin_number = '"+pin_number+"'" ;
                String query3 = "update SignupThree set pin_number = '"+rpin+"' where pin_number = '"+pin_number+"'" ;

                c.s.executeUpdate(query1) ;
                c.s.executeUpdate(query2) ;
                c.s.executeUpdate(query3) ;

                JOptionPane.showMessageDialog(null ,"PIN changed successfully");
                setVisible(false);
                new Transaction(pin_number).setVisible(true);


            }catch (Exception e){
                System.out.println(e);
            }


        }else {
            setVisible(false);
            new Transaction(pin_number).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new PinChange("")    ;
    }
}
