package forms;

import java.awt.BorderLayout; 
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import connection.ConectDB;
import java.sql.*;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Users extends JFrame {
	
	private static final long serialVersionUID = 0;
	ConectDB cnt = new ConectDB();  
	Connection cc = cnt.getConnection(); 
	
	private JPanel contentPane;
	private JTextField textUser;
	private JTextField textPass; 
	private Connection con;
	
	public Users() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 443, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbUser = new JLabel("User");
		lbUser.setBounds(102, 49, 73, 20);
		contentPane.add(lbUser);
		
		textUser = new JTextField();
		textUser.setBounds(89, 80, 138, 20);
		contentPane.add(textUser);
		textUser.setColumns(10);
		
		JLabel lbPass = new JLabel("Password");
		lbPass.setBounds(102, 141, 46, 14);
		contentPane.add(lbPass);
		
		textPass = new JTextField();
		textPass.setBounds(89, 166, 138, 20);
		contentPane.add(textPass);
		textPass.setColumns(10);
		
		JButton btmLogIn = new JButton("LogIn");
		btmLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				ConectDB cont =new ConectDB(); 
				con = cont.getConnection(); 
				String query = "SELECT * FROM Users where Id = ?, Username = ?, Password = ?"; 
				try {
					PreparedStatement stm =  con.prepareStatement(query); 
					stm.setString(1, textUser.getText()); 
					stm.setString(2, textPass.getText()); 
					ResultSet rs= stm.executeQuery(); 
					int i=0;
					String _user = "";
					String _pass = "";
					while(rs.next()) {
						_user = rs.getString("Username"); 
						_pass = rs.getString("Password"); 
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace(); 
				}
			}
		});
		btmLogIn.setBounds(89, 209, 89, 23);
		contentPane.add(btmLogIn);
	} 

    } 
	
