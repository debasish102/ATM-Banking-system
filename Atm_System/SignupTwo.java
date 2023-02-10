package Atm_System;

import javax.swing.* ;
import  java.awt.event.ActionListener ;
import  java.awt.event.ActionEvent ;
import  java.awt.* ;
import java.sql.* ;
import java.util.*;
import com.toedter.calendar.JDateChooser ;

public class SignupTwo extends JFrame implements ActionListener {

    JLabel form, religion, catagory , income , qualification , occupation ,  aadhar_no , existing_ac, pan_no , senior_citzen  ;
    JTextField  catagory_field , income_field , aadhar_no_field , pan_no_field , state_field , pincode_field ;
    JButton next ;
    JComboBox religion_opt , catagory_opt , income_opt , qualification_opt ,occupation_opt ; ;
    JDateChooser dateChooser ;
    JRadioButton sno , syes , eno , eyes ;
    String form_no ;


    public SignupTwo(String form_id){
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2 ");
        getContentPane().setBackground(Color.CYAN);


        form_no = form_id ;
        form = new JLabel("APPLICATION FORM NO. "+form_no) ;
        form.setFont(new Font("Osward" , Font.BOLD , 35));
        form.setBounds(100 , 40 , 600 , 40 );
        add(form) ;

        JLabel additional = new JLabel("Page 2 : Additional Details :") ;
        additional.setFont(new Font("Raleway" , Font.BOLD , 18));
        additional.setBounds(200 , 90 , 500 , 30 );
        add(additional) ;

        religion = new JLabel("Religion :") ;
        religion.setFont(new Font("Raleway" , Font.BOLD , 20));
        religion.setBounds(90 , 150 , 150 , 30 );
        add(religion) ;



        String valreligion[] = {"Hindu", "Muslim" , "Christian" , "Sikh" , "Buddhist", "Jain", "Other"} ;
        religion_opt = new JComboBox(valreligion) ;
        religion_opt.setFont(new Font("Arial" ,Font.BOLD , 15));
        religion_opt.setBounds(300 , 150 , 350 , 30);
        add(religion_opt) ;


        catagory = new JLabel("Catagory :") ;
        catagory.setFont(new Font("Raleway" , Font.BOLD , 20));
        catagory.setBounds(90 , 200 , 250 , 30 );
        add(catagory) ;


        String valCatagory[] = {"General" , "OBC" , "SC" , "ST", "Others"} ;
        catagory_opt = new JComboBox(valCatagory) ;
        catagory_opt.setFont(new Font("Arial" ,Font.BOLD , 15));
        catagory_opt.setBounds(300 , 200 , 350 , 30);
        add(catagory_opt) ;



        income = new JLabel("Income :") ;
        income.setFont(new Font("Raleway" , Font.BOLD , 20));
        income.setBounds(90 , 250 , 250 , 30 );
        add(income) ;



        String valIncome[] = {"Less than 10000" , "Less than 2 Lakh" , "Less than 3 Lakh" , "Less than 5 Lakh", "More than 10 Lakh" , "Other"} ;
        income_opt = new JComboBox(valIncome) ;
        income_opt.setFont(new Font("Arial" ,Font.BOLD , 15));
        income_opt.setBounds(300 , 250 , 350 , 30);
        add(income_opt) ;


//        educational = new JLabel("Educational :") ;
//        educational.setFont(new Font("Raleway" , Font.BOLD , 20));
//        educational.setBounds(90 , 300 , 250 , 30 );
//        add(educational) ;


        qualification = new JLabel("Qualification :") ;
        qualification.setFont(new Font("Raleway" , Font.BOLD , 20));
        qualification.setBounds(90 , 300 , 250 , 30 );
        add(qualification) ;

        String valqualification[] = {"Non Graduate" , "Graduate" , "Post Graduate" , "Matriculate", "Others"} ;
        qualification_opt = new JComboBox(valqualification) ;
        qualification_opt.setFont(new Font("Arial" ,Font.BOLD , 15));
        qualification_opt.setBounds(300 , 300 , 350 , 30);
        add(qualification_opt) ;

//        email_field = new JTextField() ;
//        email_field.setFont(new Font("Arial" ,Font.BOLD , 17));
//        email_field.setBounds(300  , 350 , 350 , 30 );
//        add(email_field) ;



        occupation = new JLabel("Occupation :") ;
        occupation.setFont(new Font("Raleway" , Font.BOLD , 20));
        occupation.setBounds(90 , 350 , 250 , 30 );
        add(occupation) ;


        String valoccupation[] = {"Salaried" , "Self-Employed" , "Business" , "Student","Retired", "Others"} ;
        occupation_opt = new JComboBox(valoccupation) ;
        occupation_opt.setFont(new Font("Arial" ,Font.BOLD , 15));
        occupation_opt.setBounds(300 , 350 , 350 , 30);
        add(occupation_opt) ;



        aadhar_no = new JLabel("Aadhar Number :") ;
        aadhar_no.setFont(new Font("Raleway" , Font.BOLD , 20));
        aadhar_no.setBounds(90 , 400 , 250 , 30 );
        add(aadhar_no) ;

        aadhar_no_field = new JTextField() ;
        aadhar_no_field.setFont(new Font("Arial" ,Font.BOLD , 17));
        aadhar_no_field.setBounds(300  , 400 , 350 , 30 );
        add(aadhar_no_field) ;

        pan_no = new JLabel("Pan Number :") ;
        pan_no.setFont(new Font("Raleway" , Font.BOLD , 20));
        pan_no.setBounds(90 , 450 , 250 , 30 );
        add(pan_no) ;

        pan_no_field = new JTextField() ;
        pan_no_field.setFont(new Font("Arial" ,Font.BOLD , 17));
        pan_no_field.setBounds(300  , 450 , 350 , 30 );
        add(pan_no_field) ;

        senior_citzen = new JLabel("Senior Citizen :") ;
        senior_citzen.setFont(new Font("Raleway" , Font.BOLD , 20));
        senior_citzen.setBounds(90 , 500 , 250 , 30 );
        add(senior_citzen) ;



        sno = new JRadioButton("No") ;
        sno.setFont(new Font("Raleway" , Font.BOLD , 15));
        sno.setBounds(400, 500 , 60 , 30 );
        add(sno) ;

        syes = new JRadioButton("Yes") ;
        syes.setFont(new Font("Raleway" , Font.BOLD , 15));
        syes.setBounds(300, 500 , 60 , 30 );
        add(syes) ;

        ButtonGroup  seniorGroup = new ButtonGroup() ;
        seniorGroup.add(syes);
        seniorGroup.add(sno);


        existing_ac = new JLabel("Existing Account :") ;
        existing_ac.setFont(new Font("Raleway" , Font.BOLD , 20));
        existing_ac.setBounds(90 , 550 , 250 , 30 );
        add(existing_ac) ;



        eno = new JRadioButton("No") ;
        eno.setFont(new Font("Raleway" , Font.BOLD , 15));
        eno.setBounds(400, 550 , 60 , 30 );
        add(eno) ;

        eyes = new JRadioButton("Yes") ;
        eyes.setFont(new Font("Raleway" , Font.BOLD , 15));
        eyes.setBounds(300, 550 , 60 , 30 );
        add(eyes) ;

        ButtonGroup  existingGroup = new ButtonGroup() ;
        existingGroup.add(syes);
        existingGroup.add(sno);



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
//            String form_no  = null ;
            String religion = (String)religion_opt.getSelectedItem();
            String catagory = (String)catagory_opt.getSelectedItem();
            String income = (String) income_opt.getSelectedItem() ;
            String qualification = (String) qualification_opt.getSelectedItem() ;
            String occupation = (String) occupation_opt.getSelectedItem() ;
            String aadhar_no = aadhar_no_field.getText() ;
            String pan_no = pan_no_field.getText() ;


            String senior_cititzen = null ;
            if (syes.isSelected()){
                senior_cititzen = "Yes" ;
            }
            else{
                senior_cititzen = "No" ;
            }

            String  existing_ac = null ;
            if (eno.isSelected()){
                existing_ac = "No" ;
            }else{
                existing_ac = "Yes" ;
            }



            try{
                if(aadhar_no.equals("")){
                    JOptionPane.showMessageDialog(null , "Aadhar Number is required");
                }
                else if(pan_no.equals("")){
                    JOptionPane.showMessageDialog(null , " Pan Number name is required");
                }

                else {
                    Conn c = new Conn() ;
                    String query = "insert into SignupTwo values('"+form_no+"','"+religion+"', '"+catagory+"', '"+income+"', '"+qualification+"', '"+occupation+"', '"+aadhar_no+"', '"+pan_no+"', '"+senior_cititzen+"', '"+existing_ac+"')" ;
                    c.s.executeUpdate(query) ;
                    JOptionPane.showMessageDialog(null , "Table updated");
                    setVisible(false);

                    // SignupThree object
                    new SignupThree(form_no).setVisible(true); ;

                }

            }catch(Exception e){
                System.out.println(e);

            }

        }
    }

    public static void main(String[] args) {
        new SignupTwo(" ") ;
    }
}
