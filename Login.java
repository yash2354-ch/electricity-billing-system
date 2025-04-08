package Billingsystem;
import java.awt.Color;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
 JButton login,cancel,signup;
 JTextField username,password;
 Choice logginin;
	Login(){//constructor
		super("Login page");//this is for heading.
		getContentPane().setBackground(Color.WHITE);//access allover frame
		setLayout(null);
		JLabel lblusername = new JLabel("Username");//this is for writing something on the frame00
		lblusername.setBounds(300,20,100,20);//set layout
		add(lblusername);
	    username = new JTextField();// creating a text box 
		username.setBounds(400,20,150,20);
		add(username);
		JLabel lblpassword = new JLabel("Password");//this is for writing something on the frame
		lblpassword.setBounds(300,60,100,20);//set layout
		add(lblpassword);
		password = new JTextField();// creating a text box 
		password.setBounds(400,60,150,20);
		add( password);
		JLabel loggininas = new JLabel("Loggin in as");//this is for writing something on the frame
		loggininas.setBounds(300,100,100,20);//set layout
		add(loggininas);
		logginin=new Choice();//creating dropdown box.
	    logginin.add("Admin");
		logginin.add("Customer");
		logginin.setBounds(400,100,150,20);
		add(logginin);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("login.png"));//getting image from system
		Image i2 = i1.getImage().getScaledInstance(16, 16,Image.SCALE_DEFAULT);//scaled image size
	    login = new JButton("Login",new ImageIcon(i2));//creating button
		login.setBounds(330,160,100,20);
		login.addActionListener(this);
		add(login);
		ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("cancel.jpg"));//getting image from system
		Image i4 = i3.getImage().getScaledInstance(16, 14,Image.SCALE_DEFAULT);//scaled image size
		
	    cancel = new JButton("Cancel",new ImageIcon(i4));//creating button
		cancel.setBounds(450,160,100,20);
		cancel.addActionListener(this);
		add(cancel);
		ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("signup.png"));//getting image from system
		Image i6 = i5.getImage().getScaledInstance(16, 17,Image.SCALE_DEFAULT);//scaled image size
		
	    signup = new JButton("Signup",new ImageIcon(i6));//creating button
		signup.setBounds(380,200,100,20);
		signup.addActionListener(this);
		add(signup);
		ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("second.jpg"));//getting image from system
		Image i8 = i7.getImage().getScaledInstance(250, 250,Image.SCALE_DEFAULT);//scaled image size
		ImageIcon i9 = new ImageIcon(i8);
		JLabel image = new JLabel(i9);
		image.setBounds(0, 0, 250, 250);
		add(image);
		
		setSize(640,300);
		setLocation(400,200);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()== login) {
			String susername = username.getText();
			String spassword = password.getText();
			String suser = logginin.getSelectedItem();
			
			try {
				Conn c = new Conn();
				String query = "select* from login where username='"+susername+"' and password = '"+spassword+"'and user = '"+suser+"'";
			    ResultSet rs = c.s.executeQuery(query);
			    
			    if(rs.next()) {
			    	String meter = rs.getString("meter_no");
			    	setVisible(false);
			    	new Project(suser,meter);
			    }else {
			    	JOptionPane.showMessageDialog(null, "invalid Login");
			    	username.setText("");
			    	password.setText("");
			    }
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}else if(ae.getSource()==cancel) {
			setVisible(false);
		}else if(ae.getSource()==signup) {
			setVisible(false);
			new Signup();
		}
		
	}
	public static void main(String args[]) {
		new Login();
	}
}
