package Atm_System;

import javax.swing.* ;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.* ;
import java.sql.* ;

public class Login extends  JFrame implements ActionListener {
    JLabel text , card , pin ;
    JTextField cardfield ;
    JPasswordField password ;
    JButton sign_in , clear , sign_up ;


    public Login(){
        setTitle("AUTOMATED TELLER MACHINE") ;
        setSize(800 , 480);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Atm_System/icon/bank.jpg")) ;
        Image i2 = i1.getImage().getScaledInstance(100 , 100 , Image.SCALE_DEFAULT) ;
        ImageIcon i3 = new ImageIcon(i2) ;
        JLabel label = new JLabel(i3) ;
        label.setBounds(70 , 10 , 100 , 100);
        add(label) ;

        text = new JLabel("Welcome to ATM") ;
        text.setFont(new Font("Osward" ,Font.BOLD , 38));
        text.setBounds(250 , 40 , 450 , 40 );
        add(text) ;

        card = new JLabel("Card Number :") ;
        card.setFont(new Font("Raleway" , Font.BOLD , 28)) ;
        card.setBounds(100 ,150 , 300 , 30 );
        add(card) ;


        cardfield = new JTextField() ;
        cardfield.setFont(new Font("Arial" , Font.BOLD , 22));
        cardfield.setBounds(350 , 150 , 300 ,30);
        add(cardfield) ;


        pin = new JLabel("PIN :") ;
        pin.setFont(new Font("Raleway" , Font.BOLD , 28));
        pin.setBounds(100 , 200 , 300 , 30 );
        add(pin) ;

        password = new JPasswordField() ;
        password.setFont(new Font("Arial" , Font.BOLD , 22));
        password.setBounds(350 , 200 , 300 , 30);
        add(password) ;


        sign_in = new JButton("SIGN IN ") ;
        sign_in.setBackground(Color.BLUE);
        sign_in.setForeground(Color.WHITE);
        sign_in.setBounds(300 , 300 , 100 , 30);
        add(sign_in) ;
        sign_in.addActionListener(this);

        clear = new JButton("CLEAR") ;
        clear.setBackground(Color.BLUE);
        clear.setForeground(Color.WHITE);
        clear.setBounds(450 , 300 , 100 , 30 );
        add(clear) ;
        clear.addActionListener(this);

        sign_up = new JButton("SIGN UP ")  ;
        sign_up.setBackground(Color.BLUE);
        sign_up.setForeground(Color.WHITE);
        sign_up.setBounds(300 , 350 , 250 , 30);
        add(sign_up) ;
        sign_up.addActionListener(this);





        getContentPane().setBackground(Color.CYAN);
        setLocation(550 , 200);
        setLayout(null);
        setVisible(true);


    }



    @Override
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == sign_in){
            Conn con = new Conn() ;
            String card_number = cardfield.getText() ;
            String pin_number = password.getText() ;
            String  query = "select * from Login where card_number = '"+card_number+"' and pin_number = '"+pin_number+"'" ;

            try{
                ResultSet rs =  con.s.executeQuery(query) ;
                if (rs.next()){
                    setVisible(false);
                    new Transaction(pin_number).setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null , "Incorrect card number or pin");
                }

            }catch (Exception e ){
                System.out.println(e);
            }
        }
        else if (ae.getSource() == clear) {
            cardfield.setText("");
            password.setText("") ;

        }
        else if (ae.getSource() == sign_up){
            new SignupOne().setVisible(true);
        }

    }

    public static void main(String[] args) {
        new Login() ;


    }
}
