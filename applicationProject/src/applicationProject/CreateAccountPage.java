package applicationProject;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.Insets;
import javax.swing.JScrollBar;

import java.io.File;
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JCheckBox;  // Import the IOException class to handle errors
public class CreateAccountPage extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JLabel lblNewLabel;
	private JLabel lblUsername;
	private JTextField txtUserName;
	private JLabel lblPassword;
	private JPasswordField passwordField;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel label;
	private JCheckBox chckbxNewCheckBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccountPage frame = new CreateAccountPage();
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
	
	//DISCLAIMER: SOME LINE OF CODES ARE NOT INCLUDED IN THE DISCUSSION, THOSE CODE ARE ONLY USE FOR ADDED FEATURES.
	
	public CreateAccountPage() {
		setTitle("Create Account");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 336);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("    Name");
		lblUsername = new JLabel("    Username");
		lblPassword = new JLabel("    Password");
		chckbxNewCheckBox = new JCheckBox("Show");
		
		//*********************************************************************************
		lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setBounds(42, 60, 257, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setBounds(42, 110, 257, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel();
		lblNewLabel_3.setBounds(42, 165, 257, 14);
		contentPane.add(lblNewLabel_3);
		
		//*********************************************************************************
		txtName = new JTextField();
		txtName.setMargin(new Insets(2, 5, 2, 2));
		txtName.addKeyListener(new KeyAdapter() {
		    public void keyReleased(KeyEvent e) {
		    	lblNewLabel.setText("");
		    	
		        JTextField textField = (JTextField) e.getSource();
		        String text = textField.getText();
		        if(text.equals("")) {
		        	lblNewLabel.setText("    Name");
		        }
		        
		        String Name=txtName.getText();
		        int theSize=Name.length();
		        if(theSize<4) {
		        	lblNewLabel_1.setText("Atleast 4 characters");
		        }
		        else {
		        	lblNewLabel_1.setText("");
		        }
		    }
		});
		  
		txtName.setOpaque(false);
		txtName.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtName.setBounds(156, 30, 257, 30);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(156, 30, 257, 30);
		contentPane.add(lblNewLabel);
		
		//*********************************************************************************
		txtUserName = new JTextField();
		txtUserName.setMargin(new Insets(2, 5, 2, 2));
		txtUserName.addKeyListener(new KeyAdapter() {
		    public void keyReleased(KeyEvent e) {
		    	lblUsername.setText("");
		    	lblNewLabel_2.setText("");
		        JTextField textField = (JTextField) e.getSource();
		        String text = textField.getText();
		        if(text.equals("")) {
		        	lblUsername.setText("    Name");
		        	
		        }
		    }
		});
		txtUserName.setOpaque(false);
		txtUserName.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtUserName.setColumns(10);
		txtUserName.setBounds(156, 81, 257, 30);
		contentPane.add(txtUserName);
		
		lblUsername.setOpaque(true);
		lblUsername.setForeground(Color.LIGHT_GRAY);
		lblUsername.setBackground(Color.WHITE);
		lblUsername.setBounds(156, 81, 257, 30);
		contentPane.add(lblUsername);
		
		//*********************************************************************************
		/*String upCaseChar="ABCDEFGHIJKLMNOPQERSUVWXYZ",
				lowCaseChar="abcdefghijklmnopqrstuvwxyz",
				symbolChar="~`! @#$%^&* ()_-+= { [}]|\\:;”‘<,>.?/",
				numberChar="0123456789";*/
		
		passwordField = new JPasswordField();
		passwordField.setMargin(new Insets(2, 5, 2, 2));
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 12));
		passwordField.addKeyListener(new KeyAdapter() {
		    public void keyReleased(KeyEvent e) {
		    	lblPassword.setText("");
		    	
		        JTextField textField = (JTextField) e.getSource();
		        String text = textField.getText();
		        if(text.equals("")) {
		        	lblPassword.setText("    Name");
		        	chckbxNewCheckBox.setVisible(false);
		        }
		        else if(!text.equals("")) {
		        	chckbxNewCheckBox.setVisible(true);
		        }
		        
		        //PASSWORD STRENGTH
		        if(text.length()>3) {
		        	lblNewLabel_3.setText("Very weak password");
		        	lblNewLabel_3.setForeground(Color.red);
		        	if(text.length()>7) {
			        	lblNewLabel_3.setText("Weak password");
			        	lblNewLabel_3.setForeground(Color.orange);
			        	if(text.length()>7) {
			        		lblNewLabel_3.setText("Weak password");
			        		lblNewLabel_3.setForeground(Color.orange);
			        		if(text.length()>11) {
			        			lblNewLabel_3.setText("Good password");
			        			lblNewLabel_3.setForeground(Color.yellow);
			        			if(text.length()>15) {
			        				lblNewLabel_3.setText("Strong password");
			        				lblNewLabel_3.setForeground(Color.green);
			        			}
			        		}
			        	}
			        }
		        }
		        else {
		        	lblNewLabel_3.setText("Atleast 4 characters");
		        	lblNewLabel_3.setForeground(Color.black);
		        }
		    }
		});
		passwordField.setOpaque(false);
		passwordField.setBounds(156, 135, 257, 30);
		contentPane.add(passwordField);
		
		lblPassword.setOpaque(true);
		lblPassword.setForeground(Color.LIGHT_GRAY);
		lblPassword.setBackground(Color.WHITE);
		lblPassword.setBounds(156, 135, 257, 30);
		contentPane.add(lblPassword);
		
		//*********************************************************************************
		JButton btnNewButton = new JButton("Create Account");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(txtName.getText().equals("")||txtUserName.getText().equals("")||passwordField.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Please fill out all the items","Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(!txtUserName.getText().contains("@")) {
					lblNewLabel_2.setText("Invalid Username!");
				}
				else if(!txtUserName.getText().contains(".com")) {
					lblNewLabel_2.setText("Invalid Username!");
				}
				else {
					String Name=txtName.getText(), UserName=txtUserName.getText(), Password=passwordField.getText(), data="" ;
					
					//CREATING THE TEXT FILE
					File accountData = new File("C:\\Users\\Public\\applicationProjectSavedAccount.txt");
					try {
						if (accountData.createNewFile()) {
							System.out.println("File created: " + accountData.getName());
						} else {
							System.out.println("File already exists, data saved!");
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
					//STORING ACCOUNT DATA
					try {
						Scanner myReader = new Scanner(accountData);
						data = data.concat("\n");
                        FileWriter writer = new FileWriter("C:\\Users\\Public\\applicationProjectSavedAccount.txt",true);
                        writer.write(data);
                        writer.close();
                        if(myReader.hasNextLine()) {
                        	data = data.concat(Name+"\r\n");
                        	data = data.concat(UserName+"\r\n");
                        	data = data.concat(Password+"\r\n");
                        	FileWriter writer1 = new FileWriter("C:\\Users\\Public\\applicationProjectSavedAccount.txt",true);
                        	writer1.write(data);
                            writer1.close();
                        }
                        
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
					MainPage transfer=new MainPage();
					transfer.setVisible(true);
					dispose();
				}
				
			}
		});
		btnNewButton.setBounds(226, 185, 131, 23);
		contentPane.add(btnNewButton);
		
		//*********************************************************************************
		btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage transfer=new LoginPage();
				transfer.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(10, 11, 89, 23);
		contentPane.add(btnNewButton_1);
		
		label = new JLabel("New label");
		label.setBounds(211, 85, 46, 14);
		contentPane.add(label);
		
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
		chckbxNewCheckBox.setBounds(415, 139, 71, 23);
		contentPane.add(chckbxNewCheckBox);
		//*********************************************************************************
		
	}
}
