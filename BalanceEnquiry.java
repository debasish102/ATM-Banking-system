package Atm_System;

import  java.awt.event.* ;
import javax.swing.* ;
import java.awt.* ;
import java.sql.* ;

public class BalanceEnquiry extends JFrame  implements ActionListener{

    JButton back_btn ;
    String pin_number ;

    public BalanceEnquiry(String pin_number){
        this.pin_number = pin_number ;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Atm_System/icon/atm.jpg")) ;
        Image i2 = i1.getImage().getScaledInstance(900, 900 , Image.SCALE_DEFAULT) ;
        ImageIcon i3 = new ImageIcon(i2) ;
        JLabel image = new JLabel(i3) ;
        image.setBounds(0 , 0 , 900 , 900);
        add(image) ;

        back_btn = new JButton("Back") ;
        back_btn.setFont(new Font("Raleway" , Font.BOLD , 15));
        back_btn.setBounds(355, 520 , 150 , 30);
        back_btn.setForeground(Color.RED);
        add(back_btn) ;
        back_btn.addActionListener(this);


        Conn c = new Conn() ;
        int balance = 0;
        try {
            ResultSet rs = c.s.executeQuery("select * from bank where pin_number = '" + pin_number + "'");

            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch (Exception e) {
            System.out.println(e);
        }

        JLabel text = new JLabel("Your current account balance is "+balance) ;
        text.setFont(new Font("Raleway" , Font.BOLD , 15));
        text.setBounds(170 , 300 , 400 , 30);
        text.setForeground(Color.WHITE);
        image.add(text) ;


        setSize(900 , 900 );
        setLocation(300 , 0);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back_btn){
            setVisible(false);
            new Transaction(pin_number).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new BalanceEnquiry("") ;
    }


}
