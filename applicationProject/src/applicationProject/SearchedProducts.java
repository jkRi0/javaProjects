package applicationProject;

import java.util.Arrays;
import java.util.Scanner;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JSpinner;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class SearchedProducts extends JFrame {

	private JPanel contentPane;
	JButton btnNewButton_1_2;
	int count;
	JTextArea txt1;
	JLabel lblNewLabel_1;
	JTextArea textArea;
	JTextField textField;
	JTextArea txtRecProd;
	JTextArea txtNumRecProd;
	JLabel lblNewLabel_3;
	int height=0,count1;
	
	MainPage mainData=new MainPage();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchedProducts frame = new SearchedProducts();
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
	public SearchedProducts() {
		String productNumber[]=new String[mainData.products.length-1];
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 528, 612);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
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
		        	for(int count=0; count<mainData.products.length; count++) {
		        		theProduct=mainData.products[count];
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
		
		
		
		JLabel lblNewLabel = new JLabel("SHOP LOGO");
		lblNewLabel.setBounds(24, 19, 82, 14);
		contentPane.add(lblNewLabel);
		
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
		
		JButton btnNewButton_2 = new JButton("Orders");
		btnNewButton_2.setBounds(209, 95, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1_1 = new JButton("Chart");
		btnNewButton_1_1.setBounds(308, 95, 89, 23);
		contentPane.add(btnNewButton_1_1);
		
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
		
		//*********************************************************************************
		
		JButton btnNewButton_5 = new JButton(">");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int add=0;
				String page=lblNewLabel_1.getText(), previewPage="", allPage="" ,previewSpecs="";
				
				for(int count3=0; count3<page.length(); count3++) {
					//STRING PARTITION
					if(count3<page.indexOf('/')) {
						previewPage+=page.charAt(count3);
					}
					else if(count3>page.indexOf('/')){
						allPage+=page.charAt(count3);
					}
				}
				add=Integer.parseInt(previewPage);
				if(add<Integer.parseInt(allPage)) {
					add+=1;
				}
				lblNewLabel_1.setText(Integer.toString(add)+"/"+allPage);
				
				//FOR PRINTING THE PRODUCT SPECIFICATION
				int count4=-1;
				Scanner key=new Scanner(txtRecProd.getText());
				while(key.hasNextLine()){
					count4++;
					previewSpecs = key.nextLine();
					if(Integer.toString(count4).equals(previewPage)) {
						lblNewLabel_3.setText(previewSpecs);
						
						//Reading the text file for the very first product to show its specification
						String temporary="",data="";
						File productSpecs=new File("src/applicationProject/productSpecs.txt");
						Scanner myReader = null;
						
						txt1.setText("");
						try {
							myReader = new Scanner(productSpecs);
						} catch (FileNotFoundException e1) {
							e1.printStackTrace();
						}
						//find the informations in the text file
						while(myReader.hasNextLine()) {
							temporary=myReader.nextLine();
							//if the productString was on the text file
							if(temporary.equals(previewSpecs)) {
								while(myReader.hasNextLine()) {
									data=myReader.nextLine();
									
									//stop the scan
									if(data.equals("*****")) {
										break;
									}
							
									//append the informations before the stop
									txt1.append(data+"\n");
							
								}
							}
						}
					}
				}
			}
		});
		btnNewButton_5.setBounds(298, 539, 48, 23);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_5_1 = new JButton("<");
		btnNewButton_5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int minus=0;
				String page=lblNewLabel_1.getText(), previewPage="", allPage="", previewSpecs="";
				for(int count3=0; count3<page.length(); count3++) {
					if(count3<page.indexOf('/')) {
						previewPage+=page.charAt(count3);
					}
					else if(count3>page.indexOf('/')){
						allPage+=page.charAt(count3);
					}
				}
				minus=Integer.parseInt(previewPage);
				if(minus>1) {
					minus-=1;
				}
				lblNewLabel_1.setText(Integer.toString(minus)+"/"+allPage);
				
				//FOR PRINTING THE PRODUCT SPECIFICATION
				int count4=1;
				Scanner key=new Scanner(txtRecProd.getText());
				while(key.hasNextLine()){
					count4++;
					previewSpecs = key.nextLine();
					if(Integer.toString(count4).equals(previewPage)) {
						lblNewLabel_3.setText(previewSpecs);
						
						//Reading the text file for the very first product to show its specification
						String temporary="",data="";
						File productSpecs=new File("src/applicationProject/productSpecs.txt");
						Scanner myReader = null;
						
						txt1.setText("");
						try {
							myReader = new Scanner(productSpecs);
						} catch (FileNotFoundException e1) {
							e1.printStackTrace();
						}
						//find the informations in the text file
						while(myReader.hasNextLine()) {
							temporary=myReader.nextLine();
							//if the productString was on the text file
							if(temporary.equals(previewSpecs)) {
								while(myReader.hasNextLine()) {
									data=myReader.nextLine();
									
									//stop the scan
									if(data.equals("*****")) {
										break;
									}
							
									//append the informations before the stop
									txt1.append(data+"\n");
							
								}
							}
						}
					}
				}
			}
		});
		btnNewButton_5_1.setBounds(173, 539, 48, 23);
		contentPane.add(btnNewButton_5_1);
		//*********************************************************************************
		
		
		lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblNewLabel_1.setBounds(221, 539, 77, 23);
		contentPane.add(lblNewLabel_1);
		
		txt1 = new JTextArea();
		txt1.setEditable(false);
		txt1.setBounds(209, 160, 287, 356);
		contentPane.add(txt1);
		
		
        JScrollPane scroll = new JScrollPane(txt1);  
        scroll.setBounds(txt1.getBounds());
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);  
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        contentPane.add(scroll);  
        
        txtRecProd = new JTextArea();
        txtRecProd.setVisible(false);
        txtRecProd.setBounds(24, 539, 18, 23);
        contentPane.add(txtRecProd);
        
        txtNumRecProd = new JTextArea();
        txtNumRecProd.setVisible(false);
        txtNumRecProd.setBounds(52, 538, 18, 24);
        contentPane.add(txtNumRecProd);
        
        JLabel lblNewLabel_2 = new JLabel("LAPTOP PICTURE");
        lblNewLabel_2.setBackground(Color.WHITE);
        lblNewLabel_2.setOpaque(true);
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setBounds(10, 140, 189, 156);
        contentPane.add(lblNewLabel_2);
        
        lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setHorizontalTextPosition(SwingConstants.CENTER);
        lblNewLabel_3.setBounds(10, 321, 189, 23);
        contentPane.add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("SPECIFICATION");
        lblNewLabel_4.setBounds(209, 140, 102, 21);
        contentPane.add(lblNewLabel_4);
	


		
	}
}
