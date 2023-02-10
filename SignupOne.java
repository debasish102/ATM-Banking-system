package Atm_System;

import javax.swing.* ;
import  java.awt.event.ActionListener ;
import  java.awt.event.ActionEvent ;
import  java.awt.* ;
import java.util.*;
import com.toedter.calendar.JDateChooser ;

public class SignupOne extends JFrame implements ActionListener {
//    long random ;
    JLabel form_no , name , father,dob , gender , email , status ,  address , city , state , pincode  ;
    JTextField name_field , father_field ,email_field , address_field , city_field , state_field , pincode_field ;
    JButton next ;
    JDateChooser dateChooser ;
    JRadioButton male , female , married , unmarried , other;

    Random ran = new Random() ;
    long first4 = (ran.nextLong() %  9000L) + 1000L ;
    String first = "" + Math.abs(first4) ;


    public SignupOne(){
        setTitle("NEW ACCOUNT APPLICATION FORM");
        getContentPane().setBackground(Color.CYAN);


        form_no = new JLabel("APPLICATION FORM NO. "+first) ;
        form_no.setFont(new Font("Osward" , Font.BOLD , 35));
        form_no.setBounds(100 , 40 , 600 , 40 );
        add(form_no) ;

        JLabel personal = new JLabel("Page 1 : Personal Details :") ;
        personal.setFont(new Font("Raleway" , Font.BOLD , 18));
        personal.setBounds(200 , 90 , 500 , 30 );
        add(personal) ;

        name = new JLabel("Name :") ;
        name.setFont(new Font("Raleway" , Font.BOLD , 20));
        name.setBounds(90 , 150 , 150 , 30 );
        add(name) ;

        name_field = new JTextField() ;
        name_field.setFont(new Font("Arial" ,Font.BOLD , 17));
        name_field.setBounds(300  , 150 , 350 , 30 );
        add(name_field) ;


        father = new JLabel("Father's Name :") ;
        father.setFont(new Font("Raleway" , Font.BOLD , 20));
        father.setBounds(90 , 200 , 250 , 30 );
        add(father) ;

        father_field = new JTextField() ;
        father_field.setFont(new Font("Arial" ,Font.BOLD , 17));
        father_field.setBounds(300  , 200 , 350 , 30 );
        add(father_field) ;

        dob = new JLabel("Date of Birth :") ;
        dob.setFont(new Font("Raleway" , Font.BOLD , 20));
        dob.setBounds(90 , 250 , 250 , 30 );
        add(dob) ;

        dateChooser = new JDateChooser() ;
        dateChooser.setBounds(300 , 250 ,350 , 30 );
        add(dateChooser) ;


        gender = new JLabel("Gender :") ;
        gender.setFont(new Font("Raleway" , Font.BOLD , 20));
        gender.setBounds(90 , 300 , 250 , 30 );
        add(gender) ;

        male = new JRadioButton("Male") ;
        male.setBounds(300 , 300 , 60 , 30 );
        add(male)  ;

        female = new JRadioButton("Female") ;
        female.setBounds(400 , 300 , 90 , 30 );
        add(female)  ;

        ButtonGroup gendergroup = new ButtonGroup() ;
        gendergroup.add(male);
        gendergroup.add(female);

        email = new JLabel("Email :") ;
        email.setFont(new Font("Raleway" , Font.BOLD , 20));
        email.setBounds(90 , 350 , 250 , 30 );
        add(email) ;
        
        email_field = new JTextField() ;
        email_field.setFont(new Font("Arial" ,Font.BOLD , 17));
        email_field.setBounds(300  , 350 , 350 , 30 );
        add(email_field) ;

        status = new JLabel("Maritial Status :") ;
        status.setFont(new Font("Raleway" , Font.BOLD , 20));
        status.setBounds(90 , 400 , 250 , 30 );
        add(status) ;

        married = new JRadioButton("Married") ;
        married.setBounds(300 , 400 , 90 , 30 );
        add(married) ;

        unmarried = new JRadioButton("Unmarried") ;
        unmarried.setBounds(400 , 400 , 90 , 30 );
        add(unmarried) ;

        other = new JRadioButton("Other") ;
        other.setBounds(500 , 400 , 90 , 30 );
        add(other) ;

        ButtonGroup statusGroup = new ButtonGroup() ;
        statusGroup.add(unmarried);
        statusGroup.add(married);
        statusGroup.add(other);

        address = new JLabel("Address :") ;
        address.setFont(new Font("Raleway" , Font.BOLD , 20));
        address.setBounds(90 , 450 , 250 , 30 );
        add(address) ;

        address_field = new JTextField() ;
        address_field.setFont(new Font("Arial" ,Font.BOLD , 17));
        address_field.setBounds(300  , 450 , 350 , 30 );
        add(address_field) ;

        city = new JLabel("City :") ;
        city.setFont(new Font("Raleway" , Font.BOLD , 20));
        city.setBounds(90 , 500 , 250 , 30 );
        add(city) ;

        city_field = new JTextField() ;
        city_field.setFont(new Font("Arial" ,Font.BOLD , 17));
        city_field.setBounds(300  , 500 , 350 , 30 );
        add(city_field) ;

        state = new JLabel("State :") ;
        state.setFont(new Font("Raleway" , Font.BOLD , 20));
        state.setBounds(90 , 550 , 250 , 30 );
        add(state) ;

        state_field = new JTextField() ;
        state_field.setFont(new Font("Arial" ,Font.BOLD , 17));
        state_field.setBounds(300  , 550 , 350 , 30 );
        add(state_field) ;

        pincode = new JLabel("Pincode :") ;
        pincode.setFont(new Font("Raleway" , Font.BOLD , 20));
        pincode.setBounds(90 , 600 , 250 , 30 );
        add(pincode) ;

        pincode_field = new JTextField() ;
        pincode_field.setFont(new Font("Arial" ,Font.BOLD , 17));
        pincode_field.setBounds(300  , 600 , 350 , 30 );
        add(pincode_field) ;


        //Button
        next  = new JButton("Next") ;
        next.setFont(new Font("Raleway" , Font.BOLD , 17));
        next.setBackground(Color.BLUE);
        next.setForeground(Color.WHITE);
        next.setBounds(600 , 650 , 100 , 30);
        add(next) ;
        next.addActionListener(this);


        setSize(850 , 800);
        setLocation(500 , 120);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == next){
            String form_no =  first ;
            String name = name_field.getText() ;
            String  father_name = father_field.getText() ;
            String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText() ;
            String gender = null ;
            if (male.isSelected()){
                gender = "Male" ;
            }
            else{
                gender = "Female" ;
            }

            String email = email_field.getText() ;
            String  status = null ;
            if (married.isSelected()){
                status = "Married " ;
            }else if(unmarried.isSelected()) {
                status = "Unmarried" ;
            }else{
                status = "Other" ;
            }

            String address = address_field.getText() ;
            String city = city_field.getText();
            String state = state_field.getText() ;
            String pincode  = pincode_field.getText();

            try{
                if(name.equals("")){
                    JOptionPane.showMessageDialog(null , "Name is required");
                }
                else if(father_name.equals("")){
                    JOptionPane.showMessageDialog(null , " Father name is required");
                }
                else if(dob.equals("")){
                    JOptionPane.showMessageDialog(null , "Date of Birth is required");
                }
//                else if(gender.equals("")){
//                    JOptionPane.showMessageDialog(null , "Gender is required");
//                }
                else if(email.equals("")){
                    JOptionPane.showMessageDialog(null , "Date of Birth is required");
                }
//                else if(status.equals("")){
//                    JOptionPane.showMessageDialog(null , "Maritial Status is required");
//                }
                else if(address.equals("")){
                    JOptionPane.showMessageDialog(null , "Address is required");
                }
                else if(city.equals("")){
                    JOptionPane.showMessageDialog(null , "City  is required");
                }
                else if (state.equals("")){
                    JOptionPane.showMessageDialog(null , "State is required");
                }
                else if(pincode.equals("")){
                    JOptionPane.showMessageDialog(null , "Pincode is required");
                }
                else {
                    Conn c = new Conn() ;
                    String query = "insert into SignupOne values('"+form_no+"', '"+name+"', '"+father_name+"', '"+dob+"', '"+email+"', '"+status+"', '"+address+"', '"+city+"', '"+pincode+"', '"+state+"')" ;
                    c.s.executeUpdate(query) ;
//                    JOptionPane.showMessageDialog(null , "Table updated");

                    setVisible(false);
                    new SignupTwo(first).setVisible(true); ;

                }

            }catch(Exception e){
                System.out.println(e);

            }

        }
    }


    public static void main(String[] args) {
        new SignupOne() ;

    }
}
