package Atm_System;


import javax.swing.*;
import  java.awt.event.* ;
import java.awt.* ;
import java.sql.* ;
import java.util.Date ;

public class FastCash  extends JFrame implements ActionListener{

    JButton btn1,  btn2, btn3 , btn4 , btn5 , btn6 , back ;
    String pin_number ;
    public FastCash(String pin_number){
        this.pin_number = pin_number ;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Atm_System/icon/atm.jpg")) ;
        Image i2 = i1.getImage().getScaledInstance(900, 900 , Image.SCALE_DEFAULT) ;
        ImageIcon i3 = new ImageIcon(i2) ;
        JLabel image = new JLabel(i3) ;
        image.setBounds(0 , 0 , 900, 900);
        add(image) ;

        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT") ;
        text.setFont(new Font("Arial" , Font.BOLD , 16));
        text.setBounds(210 , 300 , 700 , 35);
        text.setForeground(Color.WHITE);
        image.add(text) ;

        btn1 = new JButton("Rs 100") ;
        btn1.setFont(new Font("Raleway" , Font.BOLD , 14) );
        btn1.setBounds(170 , 415 , 150 , 30);
        image.add(btn1) ;
        btn1.addActionListener(this);


        btn2 = new JButton("Rs 500") ;
        btn2.setFont(new Font("Raleway" , Font.BOLD , 14) );
        btn2.setBounds(355 , 415 , 150 , 30);
        image.add(btn2) ;
        btn2.addActionListener(this);



        btn3 = new JButton("Rs 1000") ;
        btn3.setFont(new Font("Raleway" , Font.BOLD , 14) );
        btn3.setBounds(170 , 450 , 150 , 30);
        image.add(btn3) ;
        btn3.addActionListener(this);


        btn4 = new JButton("Rs 2000") ;
        btn4.setFont(new Font("Raleway" , Font.BOLD , 14) );
        btn4.setBounds(355 , 450 , 150 , 30);
        image.add(btn4) ;
        btn4.addActionListener(this);

        btn5 = new JButton("Rs 5000") ;
        btn5.setFont(new Font("Raleway" , Font.BOLD , 14) );
        btn5.setBounds(170 , 485 , 150 , 30);
        image.add(btn5) ;
        btn5.addActionListener(this);


        btn6 = new JButton("Rs 10000") ;
        btn6.setFont(new Font("Raleway" , Font.BOLD , 14) );
        btn6.setBounds(355 , 485 , 150 , 30);
        image.add(btn6) ;
        btn6.addActionListener(this);

        back = new JButton("Back") ;
        back.setFont(new Font("Raleway" , Font.BOLD , 14) );
        back.setBounds(355 , 520 , 150 , 30);
        image.add(back) ;
        back.addActionListener(this);

        setSize(900 , 900);
        setLocation(300 , 0);
//        setUndecorated(true);
        setLayout(null);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == back){
            setVisible(false);
            new Deposit(pin_number).setVisible(true);

        }
        else{
            String amount = ((JButton)ae.getSource()).getText().substring(3) ;

            Conn c = new Conn() ;
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin_number = '"+pin_number+"'") ;
                int balance = 0 ;

                while(rs.next()){
                    if (rs.getString("type").equals("Deposit")){
                        balance  += Integer.parseInt(rs.getString("amount")) ;
                    }else{
                        balance  -= Integer.parseInt(rs.getString("amount")) ;
                    }
                }

                if(ae.getSource() != back && balance < Integer.parseInt(amount) ){
                    JOptionPane.showMessageDialog(null , "Insufficient balance ");
                    return;
                }

                Date date = new Date() ;
                String query = "insert into bank values('"+pin_number+"' ,'"+date+"' ,'Withdrawl','"+amount+"')" ;
                c.s.executeUpdate(query) ;
                JOptionPane.showMessageDialog(null , "Rs "+ amount +"debited successfully");
                setVisible(false);
                new Transaction(pin_number).setVisible(true);


            }catch(Exception e){
                System.out.println(e);
            }
        }


    }

    public static void main(String[] args) {
        new FastCash("") ;

    }
}

