package applicationProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	
	//DISCLAIMER: SOME LINE OF CODES ARE NOT INCLUDED IN THE DISCUSSION, THOSE CODE ARE ONLY USE FOR ADDED FEATURES.
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginPage() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 336);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		
		JLabel lblUsername = new JLabel("    Username");
		JLabel lblPassword = new JLabel("    Password");
		JCheckBox chckbxNewCheckBox = new JCheckBox("Show");
		
		
		//*********************************************************************************
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
		    public void keyReleased(KeyEvent e) {
		    	lblUsername.setText("");
		    	
		        JTextField textField = (JTextField) e.getSource();
		        String text = textField.getText();
		        if(text.equals("")) {
		        	lblUsername.setText("    Name");
		        }
		    }
		});
		textField.setOpaque(false);
		textField.setMargin(new Insets(2, 5, 2, 2));
		textField.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField.setColumns(10);
		textField.setBounds(138, 41, 257, 30);
		contentPane.add(textField);
		
		lblUsername.setOpaque(true);
		lblUsername.setForeground(Color.LIGHT_GRAY);
		lblUsername.setBackground(Color.WHITE);
		lblUsername.setBounds(138, 41, 257, 30);
		contentPane.add(lblUsername);
		
		//*********************************************************************************
		passwordField = new JPasswordField();
		passwordField.setOpaque(false);
		passwordField.addKeyListener(new KeyAdapter() {
		    public void keyReleased(KeyEvent e) {
		    	lblPassword.setText("");
		    	
		        JTextField textField = (JTextField) e.getSource();
		        String text = textField.getText();
		        if(text.equals("")) {
		        	lblPassword.setText("    Password");
		        	chckbxNewCheckBox.setVisible(false);
		        }
		        else if(!text.equals("")) {
		        	chckbxNewCheckBox.setVisible(true);
		        }
		    }
		});
		passwordField.setMargin(new Insets(2, 5, 2, 2));
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 12));
		passwordField.setBounds(138, 95, 257, 30);
		contentPane.add(passwordField);

		lblPassword.setOpaque(true);
		lblPassword.setForeground(Color.LIGHT_GRAY);
		lblPassword.setBackground(Color.WHITE);
		lblPassword.setBounds(138, 95, 257, 30);
		contentPane.add(lblPassword);
		//*********************************************************************************
		JButton btnCreateAnotherAccount = new JButton("Create Another Account");
		btnCreateAnotherAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateAccountPage transfer=new CreateAccountPage();
				transfer.setVisible(true);
				dispose();
			}
		});
		btnCreateAnotherAccount.setBounds(174, 184, 172, 23);
		contentPane.add(btnCreateAnotherAccount);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("admin")) {
					if(passwordField.getText().equals("admin")) {
						SetTranser();
					}
					else {
						JOptionPane.showMessageDialog(null,"Incorrect username or password, "
								+ "please try again","Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				else if(textField.getText().equals("") || passwordField.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Username or Password is missing, "
							+ "please try again","Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					File accountData = new File("C:\\Users\\Public\\applicationProjectSavedAccount.txt");
					
					try {
						if (accountData.createNewFile()) {
							System.out.println("File created: " + accountData.getName());
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
					Scanner myReader = null;
					try {
						myReader = new Scanner(accountData);
					} catch (FileNotFoundException e1) {
						System.out.println("Not Found!");
						e1.printStackTrace();
					}
					String temporary="",data="";
					boolean checking=false;
					//Reading the text file
					try {
						data = data.concat("\n");
						FileWriter writer = new FileWriter("C:\\Users\\Public\\applicationProjectSavedAccount.txt",true);
						writer.write(data);
						writer.close();
                    }
                        
					catch (IOException e1) {
						e1.printStackTrace();
					}
					
					while(myReader.hasNextLine()){
						temporary = myReader.nextLine();
						if(textField.getText().equals(temporary)){
							temporary = myReader.nextLine();
							if(temporary.equals(passwordField.getText())) {
								SetTranser();
								checking=true;
							}
						}
						
					}
					
					if(checking==false) {
						JOptionPane.showMessageDialog(null,"Incorrect username or password, "
								+ "please try again","Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
			public void SetTranser() {
				MainPage transfer=new MainPage();
				transfer.btnNewButton_1_2.setText("Sign out");
				transfer.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(216, 150, 89, 23);
		contentPane.add(btnNewButton);
		
		//*********************************************************************************
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox.isSelected()==true) {
					passwordField.setEchoChar((char)0);
				}
				else {
					passwordField.setEchoChar('●');
				}
			}
		});
		chckbxNewCheckBox.setVisible(false);
		chckbxNewCheckBox.setBounds(404, 99, 78, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPage transfer=new MainPage();
				transfer.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton_1.setBounds(10, 11, 89, 23);
		contentPane.add(btnNewButton_1);
		
		
	}
}
