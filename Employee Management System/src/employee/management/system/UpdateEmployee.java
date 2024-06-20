
package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;



public class UpdateEmployee extends JFrame implements ActionListener{
    
    
    
    
    JTextField tfeducation,tffname,tfaddress,tfemail,tfphone,tfsalary,tfaadhar,tfdesignation;
    JButton add,back;
    String empID;
    JLabel lblempID;
    UpdateEmployee(String empID){
        this.empID=empID;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading=new JLabel("Update Employee Details");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("SAN_SARIF",Font.BOLD, 25));
        add(heading);
        
        JLabel labelname= new JLabel("Name");
        labelname.setBounds(50,150,150,30);
        labelname.setFont(new Font("serif",Font.PLAIN, 20));
        add(labelname);
        
        JLabel lblname=new JLabel();
        lblname.setBounds(200,150,150,30);
        add(lblname);
        
        JLabel labelfname= new JLabel("Father's Name");
        labelfname.setBounds(400,150,150,30);
        labelfname.setFont(new Font("serif",Font.PLAIN, 20));
        add(labelfname);
        
        tffname=new JTextField();
        tffname.setBounds(600,150,150,30);
        add(tffname);
        
        JLabel labeldob= new JLabel("Date Of Birth");
        labeldob.setBounds(50,200,150,30);
        labeldob.setFont(new Font("serif",Font.PLAIN, 20));
        add(labeldob);
        
        JLabel lbldob=new JLabel();
        lbldob.setBounds(200,200,150,30);
        add(lbldob);
        
        JLabel labelsalary= new JLabel("Salary");
        labelsalary.setBounds(400,200,150,30);
        labelsalary.setFont(new Font("serif",Font.PLAIN, 20));
        add(labelsalary);
        
        tfsalary=new JTextField();
        tfsalary.setBounds(600,200,150,30);
        add(tfsalary);
        
        JLabel labeladdress= new JLabel("Address");
        labeladdress.setBounds(50,250,150,30);
        labeladdress.setFont(new Font("serif",Font.PLAIN, 20));
        add(labeladdress);
        
        tfaddress=new JTextField();
        tfaddress.setBounds(200,250,150,30);
        add(tfaddress);
        
        JLabel labelphone= new JLabel("Phone");
        labelphone.setBounds(400,250,150,30);
        labelphone.setFont(new Font("serif",Font.PLAIN, 20));
        add(labelphone);
        
        tfphone=new JTextField();
        tfphone.setBounds(600,250,150,30); 
        add(tfphone);
        
        JLabel labelemail= new JLabel("Email");
        labelemail.setBounds(50,300,150,30);
        labelemail.setFont(new Font("serif",Font.PLAIN, 20));
        add(labelemail);
        
        tfemail=new JTextField();
        tfemail.setBounds(200,300,150,30); 
        add(tfemail);
        
        JLabel labeleducation= new JLabel("Highest Education");
        labeleducation.setBounds(400,300,150,30);
        labeleducation.setFont(new Font("serif",Font.PLAIN, 20));
        add(labeleducation);
        
        
        tfeducation=new JTextField();
        tfeducation.setBounds(600,300,150,30);
        add(tfeducation);
        
        JLabel labeldesignation= new JLabel("Designation");
        labeldesignation.setBounds(50,350,150,30);
        labeldesignation.setFont(new Font("serif",Font.PLAIN, 20));
        add(labeldesignation);
        
        tfdesignation=new JTextField();
        tfdesignation.setBounds(200,350,150,30);
        add(tfdesignation);
        
        JLabel labelaadhar= new JLabel("Aadhar Number");
        labelaadhar.setBounds(400,350,150,30);
        labelaadhar.setFont(new Font("serif",Font.PLAIN, 20));
        add(labelaadhar);
        
        JLabel lblaadhar=new JLabel();
        lblaadhar.setBounds(600,350,150,30); 
        add(lblaadhar);
        
        JLabel labelempID= new JLabel("Employee ID");
        labelempID.setBounds(50,400,150,30);
        labelempID.setFont(new Font("serif",Font.PLAIN, 20));
        add(labelempID);
        
        lblempID= new JLabel();
        lblempID.setBounds(200,400,150,30);
        lblempID.setFont(new Font("serif",Font.PLAIN, 20));
        add(lblempID);
        
        try{
            Conn c=new Conn();
            
                    String query="select * from employee where empID='"+empID+"'";
                    ResultSet rs=c.s.executeQuery(query);
                    while(rs.next()){
                        lblname.setText(rs.getString("name"));
                        tffname.setText(rs.getString("fname"));
                        lbldob.setText(rs.getString("dob"));
                        tfaddress.setText(rs.getString("address"));
                        tfsalary.setText(rs.getString("salary"));
                        tfphone.setText(rs.getString("phone"));
                        tfemail.setText(rs.getString("email"));
                        tfeducation.setText(rs.getString("education"));
                        lblaadhar.setText(rs.getString("aadhar"));
                        lblempID.setText(rs.getString("empID"));
                        tfdesignation.setText(rs.getString("designation"));
                    }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        add=new JButton("UPDATE DETAILS");
        add.setBounds(250,550,150,40);
        add.setBackground(Color.DARK_GRAY);
        add.setForeground(Color.white);
        add.setFont(new Font("serif",Font.PLAIN, 10));
        add.addActionListener(this);
        add(add);
        
        back=new JButton("BACK");
        back.setBounds(450,550,150,40);
        back.setBackground(Color.DARK_GRAY);
        back.setForeground(Color.white);
        back.setFont(new Font("serif",Font.PLAIN, 10));
        back.addActionListener(this);
        add(back);
        
         
        
        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            
            String fname=tffname.getText();
            String salary=tfsalary.getText();
            String address=tfaddress.getText();
            String phone=tfphone.getText();
            String email=tfemail.getText();
            String education=(String) tfeducation.getText();
            String designation=tfdesignation.getText();
           
            
            try{
                Conn conn=new Conn();
                String query="update employee set fname= '"+fname+"',salary='"+salary+"',address='"+address+"',phone='"+phone+"',email='"+email+"',education='"+education+"',designation='"+designation+"'where empID='"+empID+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details Updated Sussessfully");
                setVisible(false);
                new Home();
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new Home();
        }
    }
    
    public static void main(String[] args){
        new UpdateEmployee("");
    }
    
}
