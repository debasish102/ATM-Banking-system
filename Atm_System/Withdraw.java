
package Atm_System;
import java.awt.*;
import  java.awt.event.* ;
import java.util.Date;
import java.sql.* ;
import  javax.swing.* ;


public class Withdraw extends JFrame implements  ActionListener{

    JTextField withdraw_field ;
    JButton withdraw_btn  , back_btn;
    String pin_number ;

    public Withdraw(String pin_number){
        this.pin_number = pin_number ;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Atm_System/icon/atm.jpg")) ;
        Image i2 = i1.getImage().getScaledInstance(900, 900 , Image.SCALE_DEFAULT) ;
        ImageIcon i3 = new ImageIcon(i2) ;
        JLabel image = new JLabel(i3) ;
        image.setBounds(0 , 0 , 900, 900);
        add(image) ;

        JLabel text = new JLabel("Enter the amount you want to withdraw : ") ;
        text.setFont(new Font("Raleway" , Font.BOLD , 16));
        text.setBounds(170 , 300 , 400 , 20);
        text.setForeground(Color.WHITE);
        image.add(text);

        withdraw_field = new JTextField() ;
        withdraw_field.setFont(new Font("Raleway" , Font.BOLD , 22));
        withdraw_field.setBounds(170 , 380 , 320 , 25);
        image.add(withdraw_field) ;

        withdraw_btn = new JButton("Withdraw") ;
        withdraw_btn.setFont(new Font("Raleway" , Font.BOLD , 18));
        withdraw_btn.setBounds(355, 485 , 150 , 30);
        image.add(withdraw_btn) ;
        withdraw_btn.addActionListener(this);

        back_btn = new JButton("Back") ;
        back_btn.setFont(new Font("Raleway" , Font.BOLD , 18));
        back_btn.setBounds(155, 485 , 150 , 30);
        back_btn.setForeground(Color.RED);
        image.add(back_btn) ;
        back_btn.addActionListener(this);





        setSize(900 , 900);
        setLocation(300 , 0);
//        setUndecorated(true);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == withdraw_btn){
            String amount = withdraw_field.getText() ;
            Date date = new Date() ;
            if (amount.equals("")){
                JOptionPane.showMessageDialog(null , "Please enter the amount you want to withdraw");
            }else {
                try{
                    Conn con = new Conn() ;
                    String query = "insert into bank values('"+pin_number+"' ,'"+date+"' ,'Withdraw','"+amount+"')" ;
                    con.s.executeUpdate(query) ;
                    JOptionPane.showMessageDialog(null , "Rs "+amount+" withdraw Successfully");
                    setVisible(false);
                    new Transaction(pin_number).setVisible(true);

                }catch (Exception ee){
                    System.out.println(ee);
                }

            }


        }
        else if (e.getSource() == back_btn){
            setVisible(false);
            new Transaction(pin_number).setVisible(true);
        }

    }

    public static void main(String[] args) {
        new Withdraw("") ;
    }
}

