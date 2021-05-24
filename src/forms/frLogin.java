package forms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.User;
import supports.SupportUser;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField txtPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frLogin frame = new frLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public frLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        //Data frame Labels, buttom and text field***
		setBounds(100, 100, 320, 271);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbUser = new JLabel(" Username:");
		lbUser.setBounds(60, 30, 71, 14);
		contentPane.add(lbUser);

		txtUser = new JTextField();
		txtUser.setBounds(60, 55, 86, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);

		JLabel lbPass = new JLabel(" Password:");
		lbPass.setBounds(60, 114, 71, 14);
		contentPane.add(lbPass);

		JButton btnLogIn = new JButton("LogIn");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logIn();
			}
		});
		btnLogIn.setBounds(60, 195, 89, 23);
		contentPane.add(btnLogIn);

		txtPass = new JPasswordField();
		txtPass.setBounds(60, 139, 89, 20);
		contentPane.add(txtPass);

		JButton btnSignOut = new JButton("Sign Out");            //Sign Out buttom and his method signOut()
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signOut();
			}
		});
		btnSignOut.setBounds(189, 195, 89, 23);
		contentPane.add(btnSignOut);
	}

	protected void logIn() {                                     //LogIn method and his declared variables
		String user1 = txtUser.getText();
		String pass1 = String.valueOf(txtPass.getPassword());
		User user2 = new User();
		user2.setUsername(user1);
		user2.setPassword(pass1);

		SupportUser supportUser = new SupportUser();           //Instance of the class SupportUser

		User usu = supportUser.getUser(user2);                 //Intance and get data of supportUser by the created object for father class User

		if (usu != null) {
			JOptionPane.showMessageDialog(contentPane, "WELCOME"); 
			
			this.dispose();                                //Welcome message by the class frmExecute
			
			frmExecute welcome = new frmExecute();
			welcome.setVisible(true);

		} else {
			JOptionPane.showMessageDialog(contentPane, "INVALID DATA TYPE", "ERROR", JOptionPane.ERROR_MESSAGE);      //Error Message
		}
	}

	protected void signOut() {        //Method signOut allow out with the System.exit(0) close the program
		System.exit(0);

	}
}
