package applicationProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class MainPage extends JFrame {
	
	private JPanel contentPane;
	JTextField textField;
	JButton btnNewButton_1_2;
	JTextArea textArea;
	int height=0,count1;
	
	
	
	//TO ADD A PRODUCT, YOU MUST ADD THE PRODUCT NAME ON THE "products" ARRAY
	//NEXT, ADD THE SPECIFICATION IN THE TEXT FILE NAMED productSpecs
	//located in this project folder src/applicationProject/productSpecs
	
	String products[]= {"Apple Macbook Air M1 2020","Huawei Matebook D 15",
			"Huawei MateBook D14 2021","ASUS Vivobook 16X M1603a","DELL Latitude 7000 E7470",
			"Infinix INBook X1 Pro","Lenovo IdeaPad 3 15ITL05","Lenovo Lenovo IdeaPad 3 15ITL05",
			"Acer Aspire 5 A514-54","Lenovo ThinkPad X240","Acer Nitro 5 15-inch AN515-58-50YE",
			"Apple MacBook Pro 13 Inch 2017","DELL Latitude E6430",
			"Lenovo Legion 5i Pro","MSI Modern 14","zebra eyyy"
	};
	
	
	/*
	 
	 */
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
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
	
	
	
	
	
	public MainPage() {
		String productNumber[]=new String[products.length-1];
		
		
		setTitle("Laptop Shop");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 528, 336);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		
		
		JLabel lblUsername = new JLabel("    Search");
		JButton btnNewButton_4 = new JButton("Search");
		JButton btnNewButton_3 = new JButton();
		
		textArea = new JTextArea();
		textArea.setBounds(116, 41, 257, 16);
		textArea.setVisible(false);
		textArea.setEditable(false);
		contentPane.add(textArea);
		
		//*********************************************************************************
		
		
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textArea.getText().equals("")) {
					SearchedProducts transfer=new SearchedProducts();
					
					//transfer product names and numbers in SearchedProduct Page
					for(int count2=0; count2<count1; count2++) {
		        		productNumber[count2]=Integer.toString(count2);
		        	}
					transfer.txtNumRecProd.setText(Arrays.toString(productNumber));
					transfer.txtRecProd.setText(textArea.getText());
					transfer.lblNewLabel_1.setText("1/"+Integer.toString(count1));
					
					//the first specification product in SearchedProduct Page
					String productString=textArea.getText();
					Scanner scan=new Scanner(productString);
					productString=scan.nextLine();
						
					
					//Reading the text file for the very first product to show its specification
					String temporary="",data="";
					File productSpecs=new File("src/applicationProject/productSpecs.txt");
					Scanner myReader = null;
					try {
						myReader = new Scanner(productSpecs);
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
					//find the informations in the text file
					while(myReader.hasNextLine()) {
						temporary=myReader.nextLine();
						//if the productString was on the text file
						if(temporary.equals(productString)) {
							while(myReader.hasNextLine()) {
								data=myReader.nextLine();
								
								//stop the scan
								if(data.equals("*****")) {
									break;
								}
								
								//append the informations before the stop
								transfer.txt1.append(data+"\n");
							}
						}
					}
					transfer.lblNewLabel_3.setText(productString);
					transfer.setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton_4.setBounds(373, 11, 89, 30);
		contentPane.add(btnNewButton_4);
		btnNewButton_4.setVisible(false);
		
		
		
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				lblUsername.setText("    Search");
				btnNewButton_3.setText("");
				btnNewButton_4.setVisible(false);
				textArea.setVisible(false);
				textArea.setText("");
			}
		});
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.setOpaque(false);
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setBounds(336, 11, 48, 30);
		contentPane.add(btnNewButton_3);
		//*********************************************************************************
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
		    public void keyReleased(KeyEvent e) {
		    	//SearchedProducts SP=new SearchedProducts();
		    	
		    	
		    	lblUsername.setText("");
		        JTextField textField = (JTextField) e.getSource();
		        String text = textField.getText(),theProduct;
		        
		        //when is the time to show and hide elements
		        if(text.equals("")) {
		        	lblUsername.setText("    Search");
		        	btnNewButton_3.setText("");
		        	btnNewButton_4.setVisible(false);
		        	textArea.setVisible(false);
		        	
		        }
		        else {
		        	
		        	btnNewButton_3.setText("X");
		        	btnNewButton_4.setVisible(true);
		        	textArea.setVisible(true);
		        	textArea.setText("");
		        	count1=0;
		        	
		        	
		        	//RECOMMENDED THE EXISTING PRODUCTS
		        	for(int count=0; count<products.length; count++) {
		        		theProduct=products[count];
		        		//to prepare the "textArea's" text and bounds for another set of recommended search
		        		if(count==0) {
		        			textArea.setBounds(116, 41, 257, 16);
		        			height=0;
		        			
		        		}
		        		
		        		//lower case the text and product text for universal input of text
		        		String txtLowCase=text.toLowerCase(), productLowCase=theProduct.toLowerCase();
		        		
		        		//if text length less than product length to prevent out of bound
		        		if(text.length()<=theProduct.length()) {
		        			if(txtLowCase.charAt(text.length()-1)==productLowCase.charAt(text.length()-1) //end of string
		        					&& productLowCase.contains(txtLowCase)) //start of string
		        			{	
		        				//then now show the existing products
		        				height+=16;
		        				textArea.setBounds(116, 41, 257, height);
		        				textArea.append(theProduct+"\n");
		        				count1++;
		        				
		        			}
		        		}
		        	}
		        }
		       
		    }
		});
		
		
		textField.setOpaque(false);
		textField.setMargin(new Insets(2, 5, 2, 2));
		textField.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField.setColumns(10);
		textField.setBounds(116, 11, 257, 30);
		contentPane.add(textField);
		
		lblUsername.setOpaque(true);
		lblUsername.setForeground(Color.LIGHT_GRAY);
		lblUsername.setBackground(Color.WHITE);
		lblUsername.setBounds(116, 11, 257, 30);
		contentPane.add(lblUsername);
		
		
		
		
		
		//*********************************************************************************
		
		JButton btnNewButton = new JButton("Main menu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu transfer=new MainMenu();
				transfer.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(97, 95, 102, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("HOME");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPage transfer=new MainPage();
				transfer.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(10, 95, 77, 23);
		contentPane.add(btnNewButton_1);
		//*********************************************************************************
		JButton btnNewButton_1_1 = new JButton("Chart");
		btnNewButton_1_1.setBounds(308, 95, 89, 23);
		contentPane.add(btnNewButton_1_1);
		//*********************************************************************************
		btnNewButton_1_2 = new JButton("Login");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//must set all text connected to account into none
				
				if(btnNewButton_1_2.getText().equals("Sign out")) {
					JOptionPane.showConfirmDialog(null,"Are you sure you want to sign out?"
							,"Confirmation", JOptionPane.YES_NO_OPTION);
				}
				else {
					LoginPage transfer=new LoginPage();
					transfer.setVisible(true);
					dispose();
				}
				btnNewButton_1_2.setText("Login");
			}
		});
		btnNewButton_1_2.setBounds(407, 95, 89, 23);
		contentPane.add(btnNewButton_1_2);
		
		JLabel lblNewLabel = new JLabel("SHOP LOGO");
		lblNewLabel.setBounds(24, 19, 82, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("LAPTOP eSHOP");
		lblNewLabel_1.setFont(new Font("SimSun", Font.BOLD, 42));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(83, 182, 346, 86);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_2 = new JButton("Orders");
		btnNewButton_2.setBounds(209, 95, 89, 23);
		contentPane.add(btnNewButton_2);
		
		
	}
}
