import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.metal.MetalCheckBoxIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.JCheckBox;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTable;
import java.awt.Insets;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class page1 extends JFrame {
	private JPanel contentPane;
	
	
	int defaultFontSize=30;
	int x=2;
	int y=2;
	int width=2;
	int height=2;
	String pathDir="inventory.txt";
	
	
	//PRICES VARIABLE
	int p65=65;
	int p55=55;
	int p50=50;
	int p45=45;
	int p40=40;
	int p35=35;
	int p32=32;
	int p30=30;
	int p25=25;
	int p20=20;
	int p15=15;
	
	
	

	JCheckBox chckbxNewCheckBox;
	private JTextField txtTotalPrice;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					page1 frame = new page1();
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
	public page1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1050);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 69, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	    
		
		
		
		
		JTextArea txtArea = new JTextArea();
		txtArea.setMargin(new Insets(2, 10, 2, 2));
		txtArea.setFont(new Font("Segoe UI", Font.BOLD, 30));
		txtArea.setEditable(false);
		contentPane.add(txtArea);
		
		JScrollPane pane1=new JScrollPane(txtArea);
		pane1.setBounds(853, 11, 671, 675);
		contentPane.add(pane1);
		
		
		
		JButton btnRecord = new JButton("RECORDS");
		btnRecord.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRecord.setBounds(1534, 959, 360, 40);
		contentPane.add(btnRecord);
		
		
		
		
		
		File accountData = new File(pathDir);
		Scanner myReader = null;
		String temporary="";
		
		int productInventoryCount=19, count=0;
		String[] stockProductsLeft=new String[productInventoryCount];
		String[] stockProducts=new String[productInventoryCount];
		
		try {
			myReader = new Scanner(accountData);
		} catch (FileNotFoundException e1) {
			System.out.println("Not Found!");
			e1.printStackTrace();
		}
		asd:
		while(myReader.hasNextLine()){
			temporary = myReader.nextLine();
			
			if(temporary.equals(" ")) {
				continue asd;
			}
			
			
			//FOR PRODUCTS
			String temp2="";
			for(int count1=0;count1<temporary.indexOf(' ');count1++) {
				temp2+=temporary.charAt(count1);
			}
			stockProducts[count]=temp2;
			
			
			
			//FOR STOCKS
			
			//two characters at the end of the string
			//System.out.println(Character.toString(temporary.charAt(temporary.length()-2))+Character.toString(temporary.charAt(temporary.length()-1)));
			
			String temp1=temporary.substring(temporary.indexOf(" "));
			stockProductsLeft[count]=temp1;
			count++;
			
		}
		
		
		
		
		
		
		
		JTable table_1=new JTable();
		
		//FOR ROW
		Object[][] bruh=new Object[productInventoryCount][2];
		
		for(int count1=0;count1<productInventoryCount;count1++) {
			
			bruh[count1][0]=stockProducts[count1];
			bruh[count1][1]=stockProductsLeft[count1];
		}
		
		//FOR COLUMN
		String[] column= {"products","STOCKS"};
		table_1.setModel(new DefaultTableModel(bruh,column));
		
		table_1.getColumnModel().getColumn(1).setPreferredWidth(10);
		table_1.getColumnModel().getColumn(1).setMinWidth(10);
		table_1.setSelectionBackground(Color.red);
		table_1.setGridColor(Color.red);
		table_1.setSelectionForeground(Color.white);
		table_1.setFont(new Font("Tahoma", Font.PLAIN,20));
		table_1.getTableHeader().setFont(new Font("Arial", Font.BOLD, 20));
		table_1.setRowHeight(40);
		
		table_1.setForeground(Color.BLACK);
		table_1.setBackground(Color.WHITE);
		table_1.setAutoCreateRowSorter(true);
		table_1.setBounds(1660, 619, -182, -181);
		
		
		
		JScrollPane pane=new JScrollPane(table_1);
		pane.setForeground(Color.red);
		pane.setBackground(Color.white);
		pane.setBounds(1534,0,370,788);
		contentPane.add(pane);
		
		
		
		
		
		
		
		
		JSpinner spinner_19_3_2 = new JSpinner();
		spinner_19_3_2.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		spinner_19_3_2.setVisible(false);
		spinner_19_3_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		spinner_19_3_2.setBounds(789, 416, 54, 40);
		contentPane.add(spinner_19_3_2);
		
		JSpinner spinner_19_3_1 = new JSpinner();
		spinner_19_3_1.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		spinner_19_3_1.setVisible(false);
		spinner_19_3_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		spinner_19_3_1.setBounds(789, 377, 54, 40);
		contentPane.add(spinner_19_3_1);
		
		JLabel lblNewLabel_15 = new JLabel("₱15");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_15.setBounds(726, 377, 65, 40);
		contentPane.add(lblNewLabel_15);
		
		JLabel lblNewLabel_15_1 = new JLabel("₱35");
		lblNewLabel_15_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_15_1.setBounds(726, 423, 65, 33);
		contentPane.add(lblNewLabel_15_1);
		
		JCheckBox chckbxWater = new JCheckBox("Water");
		chckbxWater.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxWater.isSelected()==true) {
					chckbxWater.setOpaque(true);
					spinner_19_3_1.setVisible(true);
					
					txtArea.append(chckbxWater.getText()+"   "+p15+"\n");
				}
				else {
					chckbxWater.setOpaque(false);
					spinner_19_3_1.setVisible(false);
					spinner_19_3_1.setValue(1);
					
					if(txtArea.getText().contains(chckbxWater.getText())) {
						String temp1=txtArea.getText();			//get the string
						String temp2=chckbxWater.getText();
						String temp3=temp1.replaceAll(temp2+"   15\n", "");
						txtArea.setText(temp3);
					}
				}
			}
		});
		chckbxWater.setOpaque(false);
		chckbxWater.setFont(new Font("Tahoma", Font.PLAIN, 30));
		chckbxWater.setBackground(new Color(154, 205, 50));
		chckbxWater.setBounds(522, 377, 198, 40);
		contentPane.add(chckbxWater);
		
		JCheckBox chckbxDelmonte = new JCheckBox("Delmonte");
		chckbxDelmonte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxDelmonte.isSelected()==true) {
					chckbxDelmonte.setOpaque(true);
					spinner_19_3_2.setVisible(true);
					
					txtArea.append(chckbxDelmonte.getText()+"   "+p35+"\n");
				}
				else {
					chckbxDelmonte.setOpaque(false);
					spinner_19_3_2.setVisible(false);
					spinner_19_3_2.setValue(1);
					
					if(txtArea.getText().contains(chckbxDelmonte.getText())) {
						String temp1=txtArea.getText();			//get the string
						String temp2=chckbxDelmonte.getText();
						String temp3=temp1.replaceAll(temp2+"   35\n", "");
						txtArea.setText(temp3);
					}
				}
			}
		});
		chckbxDelmonte.setOpaque(false);
		chckbxDelmonte.setFont(new Font("Tahoma", Font.PLAIN, 30));
		chckbxDelmonte.setBackground(new Color(154, 205, 50));
		chckbxDelmonte.setBounds(522, 416, 198, 40);
		contentPane.add(chckbxDelmonte);
		
		JSpinner spinner_19_2 = new JSpinner();
		spinner_19_2.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		spinner_19_2.setVisible(false);
		spinner_19_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		spinner_19_2.setBounds(789, 52, 54, 40);
		contentPane.add(spinner_19_2);
		
		JSpinner spinner_19_1 = new JSpinner();
		spinner_19_1.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		spinner_19_1.setVisible(false);
		spinner_19_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		spinner_19_1.setBounds(789, 95, 54, 40);
		contentPane.add(spinner_19_1);
		
		
		
		
		
		
		
		
		
		
		JSpinner spinner_19 = new JSpinner();
		spinner_19.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		spinner_19.setVisible(false);
		spinner_19.setFont(new Font("Tahoma", Font.PLAIN, 30));
		spinner_19.setBounds(789, 138, 54, 40);
		contentPane.add(spinner_19);
		
		JSpinner spinner_19_2_1 = new JSpinner();
		spinner_19_2_1.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		spinner_19_2_1.setVisible(false);
		spinner_19_2_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		spinner_19_2_1.setBounds(789, 235, 54, 40);
		contentPane.add(spinner_19_2_1);
		
		JSpinner spinner_19_1_1 = new JSpinner();
		spinner_19_1_1.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		spinner_19_1_1.setVisible(false);
		spinner_19_1_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		spinner_19_1_1.setBounds(789, 278, 54, 40);
		contentPane.add(spinner_19_1_1);
		
		JSpinner spinner_19_3 = new JSpinner();
		spinner_19_3.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		spinner_19_3.setVisible(false);
		spinner_19_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		spinner_19_3.setBounds(789, 321, 54, 40);
		contentPane.add(spinner_19_3);
		
		
		
		

		
		
		
		
		
		
		
		JLabel lblNewLabel_12 = new JLabel("SIOMAI");
		lblNewLabel_12.setFont(new Font("MV Boli", Font.BOLD, 30));
		lblNewLabel_12.setBounds(522, 2, 153, 49);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_12_1 = new JLabel("MISMO");
		lblNewLabel_12_1.setFont(new Font("MV Boli", Font.BOLD, 30));
		lblNewLabel_12_1.setBounds(522, 185, 153, 49);
		contentPane.add(lblNewLabel_12_1);
		
		JLabel lblNewLabel_13 = new JLabel("₱32");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_13.setBounds(726, 52, 65, 40);
		contentPane.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("₱32");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_14.setBounds(726, 95, 65, 40);
		contentPane.add(lblNewLabel_14);
		
		JLabel lblNewLabel_14_1 = new JLabel("₱32");
		lblNewLabel_14_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_14_1.setBounds(726, 138, 65, 40);
		contentPane.add(lblNewLabel_14_1);
		
		JLabel lblNewLabel_13_1 = new JLabel("₱20");
		lblNewLabel_13_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_13_1.setBounds(726, 235, 65, 40);
		contentPane.add(lblNewLabel_13_1);
		
		JLabel lblNewLabel_14_1_1 = new JLabel("₱20");
		lblNewLabel_14_1_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_14_1_1.setBounds(726, 321, 65, 40);
		contentPane.add(lblNewLabel_14_1_1);
		
		JLabel lblNewLabel_14_2 = new JLabel("₱20");
		lblNewLabel_14_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_14_2.setBounds(726, 278, 65, 40);
		contentPane.add(lblNewLabel_14_2);
		
		
		
		
		JCheckBox chckbxNewCheckBox_10 = new JCheckBox("Pork");
		chckbxNewCheckBox_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_10.isSelected()==true) {
					chckbxNewCheckBox_10.setOpaque(true);
					spinner_19_2.setVisible(true);
					
					txtArea.append(chckbxNewCheckBox_10.getText()+"_Siomai   "+p32+"\n");
				}
				else {
					chckbxNewCheckBox_10.setOpaque(false);
					spinner_19_2.setVisible(false);
					spinner_19_2.setValue(1);
					
					if(txtArea.getText().contains(chckbxNewCheckBox_10.getText())) {
						String temp1=txtArea.getText();			//get the string
						String temp2=chckbxNewCheckBox_10.getText();
						String temp3=temp1.replaceAll(temp2+"_Siomai   32\n", "");
						txtArea.setText(temp3);
					}
				}
			}
		});
		chckbxNewCheckBox_10.setOpaque(false);
		chckbxNewCheckBox_10.setFont(new Font("Tahoma", Font.PLAIN, 25));
		chckbxNewCheckBox_10.setBackground(new Color(154, 205, 50));
		chckbxNewCheckBox_10.setBounds(576, 52, 144, 40);
		contentPane.add(chckbxNewCheckBox_10);
		
		JCheckBox chckbxNewCheckBox_11 = new JCheckBox("Beef");
		chckbxNewCheckBox_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_11.isSelected()==true) {
					chckbxNewCheckBox_11.setOpaque(true);
					spinner_19_1.setVisible(true);
					
					txtArea.append(chckbxNewCheckBox_11.getText()+"_Siomai   "+p32+"\n");
				}
				else {
					chckbxNewCheckBox_11.setOpaque(false);
					spinner_19_1.setVisible(false);
					spinner_19_1.setValue(1);
					
					if(txtArea.getText().contains(chckbxNewCheckBox_11.getText())) {
						String temp1=txtArea.getText();			//get the string
						String temp2=chckbxNewCheckBox_11.getText();
						String temp3=temp1.replaceAll(temp2+"_Siomai   32\n", "");
						txtArea.setText(temp3);
					}
				}
			}
		});
		chckbxNewCheckBox_11.setOpaque(false);
		chckbxNewCheckBox_11.setFont(new Font("Tahoma", Font.PLAIN, 25));
		chckbxNewCheckBox_11.setBackground(new Color(154, 205, 50));
		chckbxNewCheckBox_11.setBounds(576, 95, 144, 40);
		contentPane.add(chckbxNewCheckBox_11);
		
		JCheckBox chckbxNewCheckBox_12 = new JCheckBox("Chicken");
		chckbxNewCheckBox_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_12.isSelected()==true) {
					chckbxNewCheckBox_12.setOpaque(true);
					spinner_19.setVisible(true);
					
					txtArea.append(chckbxNewCheckBox_12.getText()+"_Siomai   "+p32+"\n");
				}
				else {
					chckbxNewCheckBox_12.setOpaque(false);
					spinner_19.setVisible(false);
					spinner_19.setValue(1);
					
					if(txtArea.getText().contains(chckbxNewCheckBox_12.getText())) {
						String temp1=txtArea.getText();			//get the string
						String temp2=chckbxNewCheckBox_12.getText();
						String temp3=temp1.replaceAll(temp2+"_Siomai   32\n", "");
						txtArea.setText(temp3);
					}
				}
			}
		});
		chckbxNewCheckBox_12.setOpaque(false);
		chckbxNewCheckBox_12.setFont(new Font("Tahoma", Font.PLAIN, 25));
		chckbxNewCheckBox_12.setBackground(new Color(154, 205, 50));
		chckbxNewCheckBox_12.setBounds(576, 138, 144, 40);
		contentPane.add(chckbxNewCheckBox_12);
		
		
		
		
		
		
		
		JCheckBox chckbxNewCheckBox_10_1 = new JCheckBox("Royal");
		chckbxNewCheckBox_10_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_10_1.isSelected()==true) {
					chckbxNewCheckBox_10_1.setOpaque(true);
					spinner_19_2_1.setVisible(true);
					
					txtArea.append(chckbxNewCheckBox_10_1.getText()+"_Mismo   "+p20+"\n");
				}
				else {
					chckbxNewCheckBox_10_1.setOpaque(false);
					spinner_19_2_1.setVisible(false);
					spinner_19_2_1.setValue(1);
					
					if(txtArea.getText().contains(chckbxNewCheckBox_10_1.getText())) {
						String temp1=txtArea.getText();			//get the string
						String temp2=chckbxNewCheckBox_10_1.getText();
						String temp3=temp1.replaceAll(temp2+"_Mismo   20\n", "");
						txtArea.setText(temp3);
					}
				}
			}
		});
		chckbxNewCheckBox_10_1.setOpaque(false);
		chckbxNewCheckBox_10_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		chckbxNewCheckBox_10_1.setBackground(new Color(154, 205, 50));
		chckbxNewCheckBox_10_1.setBounds(576, 235, 144, 40);
		contentPane.add(chckbxNewCheckBox_10_1);
		
		JCheckBox chckbxNewCheckBox_11_1 = new JCheckBox("Coke");
		chckbxNewCheckBox_11_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_11_1.isSelected()==true) {
					chckbxNewCheckBox_11_1.setOpaque(true);
					spinner_19_1_1.setVisible(true);
					
					txtArea.append(chckbxNewCheckBox_11_1.getText()+"_Mismo   "+p20+"\n");
				}
				else {
					chckbxNewCheckBox_11_1.setOpaque(false);
					spinner_19_1_1.setVisible(false);
					spinner_19_1_1.setValue(1);
					
					if(txtArea.getText().contains(chckbxNewCheckBox_11_1.getText())) {
						String temp1=txtArea.getText();			//get the string
						String temp2=chckbxNewCheckBox_11_1.getText();
						String temp3=temp1.replaceAll(temp2+"_Mismo   20\n", "");
						txtArea.setText(temp3);
					}
				}
			}
		});
		chckbxNewCheckBox_11_1.setOpaque(false);
		chckbxNewCheckBox_11_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		chckbxNewCheckBox_11_1.setBackground(new Color(154, 205, 50));
		chckbxNewCheckBox_11_1.setBounds(576, 278, 144, 40);
		contentPane.add(chckbxNewCheckBox_11_1);
		
		JCheckBox chckbxNewCheckBox_12_1 = new JCheckBox("Sprite");
		chckbxNewCheckBox_12_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_12_1.isSelected()==true) {
					chckbxNewCheckBox_12_1.setOpaque(true);
					spinner_19_3.setVisible(true);
					
					txtArea.append(chckbxNewCheckBox_12_1.getText()+"_Mismo   "+p20+"\n");
				}
				else {
					chckbxNewCheckBox_12_1.setOpaque(false);
					spinner_19_3.setVisible(false);
					spinner_19_3.setValue(1);
					
					if(txtArea.getText().contains(chckbxNewCheckBox_12_1.getText())) {
						String temp1=txtArea.getText();			//get the string
						String temp2=chckbxNewCheckBox_12_1.getText();
						String temp3=temp1.replaceAll(temp2+"_Mismo   20\n", "");
						txtArea.setText(temp3);
					}
				}
			}
		});
		chckbxNewCheckBox_12_1.setOpaque(false);
		chckbxNewCheckBox_12_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		chckbxNewCheckBox_12_1.setBackground(new Color(154, 205, 50));
		chckbxNewCheckBox_12_1.setBounds(576, 321, 144, 40);
		contentPane.add(chckbxNewCheckBox_12_1);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		JSpinner spinner = new JSpinner();
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				int price=p65*(int)spinner.getValue();
				
				System.out.println(price);
			}
		});
		spinner.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		spinner.setVisible(false);
		spinner.setToolTipText("ORDER QUANTITY");
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 30));
		spinner.setBounds(434, 0, 54, 49);
		contentPane.add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		spinner_1.setVisible(false);
		spinner_1.setToolTipText("ORDER QUANTITY");
		spinner_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		spinner_1.setBounds(434, 52, 54, 49);
		contentPane.add(spinner_1);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		spinner_2.setVisible(false);
		spinner_2.setToolTipText("ORDER QUANTITY");
		spinner_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		spinner_2.setBounds(434, 104, 54, 49);
		contentPane.add(spinner_2);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		spinner_3.setVisible(false);
		spinner_3.setToolTipText("ORDER QUANTITY");
		spinner_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		spinner_3.setBounds(434, 156, 54, 49);
		contentPane.add(spinner_3);
		
		JSpinner spinner_4 = new JSpinner();
		spinner_4.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		spinner_4.setVisible(false);
		spinner_4.setToolTipText("ORDER QUANTITY");
		spinner_4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		spinner_4.setBounds(434, 208, 54, 49);
		contentPane.add(spinner_4);
		
		JSpinner spinner_5 = new JSpinner();
		spinner_5.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		spinner_5.setVisible(false);
		spinner_5.setToolTipText("ORDER QUANTITY");
		spinner_5.setFont(new Font("Tahoma", Font.PLAIN, 30));
		spinner_5.setBounds(434, 260, 54, 49);
		contentPane.add(spinner_5);
		
		JSpinner spinner_6 = new JSpinner();
		spinner_6.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		spinner_6.setVisible(false);
		spinner_6.setToolTipText("ORDER QUANTITY");
		spinner_6.setFont(new Font("Tahoma", Font.PLAIN, 30));
		spinner_6.setBounds(434, 312, 54, 49);
		contentPane.add(spinner_6);
		
		JSpinner spinner_7 = new JSpinner();
		spinner_7.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		spinner_7.setVisible(false);
		spinner_7.setToolTipText("ORDER QUANTITY");
		spinner_7.setFont(new Font("Tahoma", Font.PLAIN, 30));
		spinner_7.setBounds(434, 364, 54, 49);
		contentPane.add(spinner_7);
		
		JSpinner spinner_8 = new JSpinner();
		spinner_8.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		spinner_8.setVisible(false);
		spinner_8.setToolTipText("ORDER QUANTITY");
		spinner_8.setFont(new Font("Tahoma", Font.PLAIN, 30));
		spinner_8.setBounds(434, 416, 54, 49);
		contentPane.add(spinner_8);
		
		JSpinner spinner_9 = new JSpinner();
		spinner_9.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		spinner_9.setVisible(false);
		spinner_9.setToolTipText("ORDER QUANTITY");
		spinner_9.setFont(new Font("Tahoma", Font.PLAIN, 30));
		spinner_9.setBounds(635, 536, 54, 49);
		contentPane.add(spinner_9);
		
		JSpinner spinner_10 = new JSpinner();
		spinner_10.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		spinner_10.setVisible(false);
		spinner_10.setToolTipText("ORDER QUANTITY");
		spinner_10.setFont(new Font("Tahoma", Font.PLAIN, 30));
		spinner_10.setBounds(635, 484, 54, 49);
		contentPane.add(spinner_10);
		
		JSpinner spinner_11 = new JSpinner();
		spinner_11.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		spinner_11.setVisible(false);
		spinner_11.setToolTipText("ORDER QUANTITY");
		spinner_11.setFont(new Font("Tahoma", Font.PLAIN, 30));
		spinner_11.setBounds(635, 588, 54, 49);
		contentPane.add(spinner_11);
		
		JSpinner spinner_12 = new JSpinner();
		spinner_12.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		spinner_12.setVisible(false);
		spinner_12.setToolTipText("ORDER QUANTITY");
		spinner_12.setFont(new Font("Tahoma", Font.PLAIN, 30));
		spinner_12.setBounds(635, 640, 54, 49);
		contentPane.add(spinner_12);
		
		JSpinner spinner_13 = new JSpinner();
		spinner_13.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		spinner_13.setVisible(false);
		spinner_13.setToolTipText("ORDER QUANTITY");
		spinner_13.setFont(new Font("Tahoma", Font.PLAIN, 30));
		spinner_13.setBounds(635, 692, 54, 49);
		contentPane.add(spinner_13);
		
		JSpinner spinner_14 = new JSpinner();
		spinner_14.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		spinner_14.setVisible(false);
		spinner_14.setToolTipText("ORDER QUANTITY");
		spinner_14.setFont(new Font("Tahoma", Font.PLAIN, 30));
		spinner_14.setBounds(635, 744, 54, 49);
		contentPane.add(spinner_14);
		
		JSpinner spinner_15 = new JSpinner();
		spinner_15.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		spinner_15.setVisible(false);
		spinner_15.setToolTipText("ORDER QUANTITY");
		spinner_15.setFont(new Font("Tahoma", Font.PLAIN, 30));
		spinner_15.setBounds(635, 796, 54, 49);
		contentPane.add(spinner_15);
		
		JSpinner spinner_16 = new JSpinner();
		spinner_16.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		spinner_16.setVisible(false);
		spinner_16.setToolTipText("ORDER QUANTITY");
		spinner_16.setFont(new Font("Tahoma", Font.PLAIN, 30));
		spinner_16.setBounds(635, 848, 54, 49);
		contentPane.add(spinner_16);
		
		JSpinner spinner_17 = new JSpinner();
		spinner_17.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		spinner_17.setVisible(false);
		spinner_17.setToolTipText("ORDER QUANTITY");
		spinner_17.setFont(new Font("Tahoma", Font.PLAIN, 30));
		spinner_17.setBounds(635, 900, 54, 49);
		contentPane.add(spinner_17);
		
		JSpinner spinner_18 = new JSpinner();
		spinner_18.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		spinner_18.setVisible(false);
		spinner_18.setToolTipText("ORDER QUANTITY");
		spinner_18.setFont(new Font("Tahoma", Font.PLAIN, 30));
		spinner_18.setBounds(635, 951, 54, 49);
		contentPane.add(spinner_18);
		
		
		
		
		
		
		
		
		//FOR NOT BUY 1 TAKE 1
		JCheckBox chckbxNewCheckBox_10_1_1 = new JCheckBox("");
		chckbxNewCheckBox_10_1_1.setEnabled(false);
		chckbxNewCheckBox_10_1_1.setBackground(new Color(0, 128, 0));
		chckbxNewCheckBox_10_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_10_1_1.isSelected()==true) {
					chckbxNewCheckBox_10_1_1.setOpaque(true);
				}
				else {
					chckbxNewCheckBox_10_1_1.setOpaque(false);
				}
			}
		});
		chckbxNewCheckBox_10_1_1.setOpaque(false);
		chckbxNewCheckBox_10_1_1.setBounds(593, 603, 21, 23);
		contentPane.add(chckbxNewCheckBox_10_1_1);
		
		JCheckBox chckbxNewCheckBox_10_1_2 = new JCheckBox("");
		chckbxNewCheckBox_10_1_2.setEnabled(false);
		chckbxNewCheckBox_10_1_2.setBackground(new Color(0, 128, 0));
		chckbxNewCheckBox_10_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_10_1_2.isSelected()==true) {
					chckbxNewCheckBox_10_1_2.setOpaque(true);
				}
				else {
					chckbxNewCheckBox_10_1_2.setOpaque(false);
				}
			}
		});
		chckbxNewCheckBox_10_1_2.setOpaque(false);
		chckbxNewCheckBox_10_1_2.setBounds(593, 655, 21, 23);
		contentPane.add(chckbxNewCheckBox_10_1_2);
		
		JCheckBox chckbxNewCheckBox_10_1_3 = new JCheckBox("");
		chckbxNewCheckBox_10_1_3.setEnabled(false);
		chckbxNewCheckBox_10_1_3.setBackground(new Color(0, 128, 0));
		chckbxNewCheckBox_10_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_10_1_3.isSelected()==true) {
					chckbxNewCheckBox_10_1_3.setOpaque(true);
				}
				else {
					chckbxNewCheckBox_10_1_3.setOpaque(false);
				}
			}
		});
		chckbxNewCheckBox_10_1_3.setOpaque(false);
		chckbxNewCheckBox_10_1_3.setBounds(593, 704, 21, 23);
		contentPane.add(chckbxNewCheckBox_10_1_3);
		
		JCheckBox chckbxNewCheckBox_10_1_4 = new JCheckBox("");
		chckbxNewCheckBox_10_1_4.setEnabled(false);
		chckbxNewCheckBox_10_1_4.setBackground(new Color(0, 128, 0));
		chckbxNewCheckBox_10_1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_10_1_4.isSelected()==true) {
					chckbxNewCheckBox_10_1_4.setOpaque(true);
				}
				else {
					chckbxNewCheckBox_10_1_4.setOpaque(false);
				}
			}
		});
		chckbxNewCheckBox_10_1_4.setOpaque(false);
		chckbxNewCheckBox_10_1_4.setBounds(593, 757, 21, 23);
		contentPane.add(chckbxNewCheckBox_10_1_4);
		
		JCheckBox chckbxNewCheckBox_10_1_5 = new JCheckBox("");
		chckbxNewCheckBox_10_1_5.setEnabled(false);
		chckbxNewCheckBox_10_1_5.setBackground(new Color(0, 128, 0));
		chckbxNewCheckBox_10_1_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_10_1_5.isSelected()==true) {
					chckbxNewCheckBox_10_1_5.setOpaque(true);
				}
				else {
					chckbxNewCheckBox_10_1_5.setOpaque(false);
				}
			}
		});
		chckbxNewCheckBox_10_1_5.setOpaque(false);
		chckbxNewCheckBox_10_1_5.setBounds(593, 811, 21, 23);
		contentPane.add(chckbxNewCheckBox_10_1_5);
		
		JCheckBox chckbxNewCheckBox_10_1_6 = new JCheckBox("");
		chckbxNewCheckBox_10_1_6.setEnabled(false);
		chckbxNewCheckBox_10_1_6.setBackground(new Color(0, 128, 0));
		chckbxNewCheckBox_10_1_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_10_1_6.isSelected()==true) {
					chckbxNewCheckBox_10_1_6.setOpaque(true);
				}
				else {
					chckbxNewCheckBox_10_1_6.setOpaque(false);
				}
			}
		});
		chckbxNewCheckBox_10_1_6.setOpaque(false);
		chckbxNewCheckBox_10_1_6.setBounds(593, 862, 21, 23);
		contentPane.add(chckbxNewCheckBox_10_1_6);
		
		JCheckBox chckbxNewCheckBox_10_1_7 = new JCheckBox("");
		chckbxNewCheckBox_10_1_7.setEnabled(false);
		chckbxNewCheckBox_10_1_7.setBackground(new Color(0, 128, 0));
		chckbxNewCheckBox_10_1_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_10_1_7.isSelected()==true) {
					chckbxNewCheckBox_10_1_7.setOpaque(true);
				}
				else {
					chckbxNewCheckBox_10_1_7.setOpaque(false);
				}
			}
		});
		chckbxNewCheckBox_10_1_7.setOpaque(false);
		chckbxNewCheckBox_10_1_7.setBounds(593, 912, 21, 23);
		contentPane.add(chckbxNewCheckBox_10_1_7);
		
		
		
		
		
		
		
		
		
		
		chckbxNewCheckBox = new JCheckBox("c1    Sisilog");
		chckbxNewCheckBox.setBackground(new Color(154, 205, 50));
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox.isSelected()==true) {
					chckbxNewCheckBox.setOpaque(true);
					spinner.setVisible(true);
					
					txtArea.append(chckbxNewCheckBox.getText()+"   "+p65+"\n");
				}
				else {
					chckbxNewCheckBox.setOpaque(false);
					spinner.setVisible(false);
					spinner.setValue(1);
					
					if(txtArea.getText().contains(chckbxNewCheckBox.getText())) {
						String temp1=txtArea.getText();			//get the string
						String temp2=chckbxNewCheckBox.getText();
						String temp3=temp1.replaceAll(temp2+"   65\n", "");
						txtArea.setText(temp3);
					}
				}
			}
		});
		chckbxNewCheckBox.setOpaque(false);
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 30));
		chckbxNewCheckBox.setBounds(6, 0, 299, 49);
		contentPane.add(chckbxNewCheckBox);
		
		
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("c2    Shanghai Silog");
		chckbxNewCheckBox_1.setBackground(new Color(154, 205, 50));
		chckbxNewCheckBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_1.isSelected()==true) {
					chckbxNewCheckBox_1.setOpaque(true);
					spinner_1.setVisible(true);
					
					txtArea.append(chckbxNewCheckBox_1.getText()+"   "+p45+"\n");
				}
				else {
					chckbxNewCheckBox_1.setOpaque(false);
					spinner_1.setVisible(false);
					spinner_1.setValue(1);
					
					if(txtArea.getText().contains(chckbxNewCheckBox_1.getText())) {
						String temp1=txtArea.getText();			//get the string
						String temp2=chckbxNewCheckBox_1.getText();
						String temp3=temp1.replaceAll(temp2+"   45\n", "");
						txtArea.setText(temp3);
					}
				}
			}
		});
		chckbxNewCheckBox_1.setOpaque(false);
		chckbxNewCheckBox_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		chckbxNewCheckBox_1.setBounds(6, 52, 299, 49);
		contentPane.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("c3    Hotsilog");
		chckbxNewCheckBox_2.setBackground(new Color(154, 205, 50));
		chckbxNewCheckBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_2.isSelected()==true) {
					chckbxNewCheckBox_2.setOpaque(true);
					spinner_2.setVisible(true);
					
					txtArea.append(chckbxNewCheckBox_2.getText()+"   "+p45+"\n");
				}
				else {
					chckbxNewCheckBox_2.setOpaque(false);
					spinner_2.setVisible(false);
					spinner_2.setValue(1);
					
					if(txtArea.getText().contains(chckbxNewCheckBox_2.getText())) {
						String temp1=txtArea.getText();			//get the string
						String temp2=chckbxNewCheckBox_2.getText();
						String temp3=temp1.replaceAll(temp2+"   45\n", "");
						txtArea.setText(temp3);
					}
				}
			}
		});
		chckbxNewCheckBox_2.setOpaque(false);
		chckbxNewCheckBox_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		chckbxNewCheckBox_2.setBounds(6, 104, 299, 49);
		contentPane.add(chckbxNewCheckBox_2);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("c4    Spamsilog");
		chckbxNewCheckBox_3.setBackground(new Color(154, 205, 50));
		chckbxNewCheckBox_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_3.isSelected()==true) {
					chckbxNewCheckBox_3.setOpaque(true);
					spinner_3.setVisible(true);
					
					txtArea.append(chckbxNewCheckBox_3.getText()+"   "+p65+"\n");
				}
				else {
					chckbxNewCheckBox_3.setOpaque(false);
					spinner_3.setVisible(false);
					spinner_3.setValue(1);
					
					if(txtArea.getText().contains(chckbxNewCheckBox_3.getText())) {
						String temp1=txtArea.getText();			//get the string
						String temp2=chckbxNewCheckBox_3.getText();
						String temp3=temp1.replaceAll(temp2+"   65\n", "");
						txtArea.setText(temp3);
					}
				}
			}
		});
		chckbxNewCheckBox_3.setOpaque(false);
		chckbxNewCheckBox_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		chckbxNewCheckBox_3.setBounds(6, 156, 299, 49);
		contentPane.add(chckbxNewCheckBox_3);
		
		JCheckBox chckbxNewCheckBox_4 = new JCheckBox("c5    Hamsilog");
		chckbxNewCheckBox_4.setBackground(new Color(154, 205, 50));
		chckbxNewCheckBox_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_4.isSelected()==true) {
					chckbxNewCheckBox_4.setOpaque(true);
					spinner_4.setVisible(true);
					
					txtArea.append(chckbxNewCheckBox_4.getText()+"   "+p55+"\n");
				}
				else {
					chckbxNewCheckBox_4.setOpaque(false);
					spinner_4.setVisible(false);
					spinner_4.setValue(1);
					
					if(txtArea.getText().contains(chckbxNewCheckBox_4.getText())) {
						String temp1=txtArea.getText();			//get the string
						String temp2=chckbxNewCheckBox_4.getText();
						String temp3=temp1.replaceAll(temp2+"   55\n", "");
						txtArea.setText(temp3);
					}
				}
			}
		});
		chckbxNewCheckBox_4.setOpaque(false);
		chckbxNewCheckBox_4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		chckbxNewCheckBox_4.setBounds(6, 208, 299, 49);
		contentPane.add(chckbxNewCheckBox_4);
		
		JCheckBox chckbxNewCheckBox_5 = new JCheckBox("c6    Burgersilog");
		chckbxNewCheckBox_5.setBackground(new Color(154, 205, 50));
		chckbxNewCheckBox_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_5.isSelected()==true) {
					chckbxNewCheckBox_5.setOpaque(true);
					spinner_5.setVisible(true);
					
					txtArea.append(chckbxNewCheckBox_5.getText()+"   "+p45+"\n");
				}
				else {
					chckbxNewCheckBox_5.setOpaque(false);
					spinner_5.setVisible(false);
					spinner_5.setValue(1);
					
					if(txtArea.getText().contains(chckbxNewCheckBox_5.getText())) {
						String temp1=txtArea.getText();			//get the string
						String temp2=chckbxNewCheckBox_5.getText();
						String temp3=temp1.replaceAll(temp2+"   45\n", "");
						txtArea.setText(temp3);
					}
				}
			}
		});
		chckbxNewCheckBox_5.setOpaque(false);
		chckbxNewCheckBox_5.setFont(new Font("Tahoma", Font.PLAIN, 30));
		chckbxNewCheckBox_5.setBounds(6, 260, 299, 49);
		contentPane.add(chckbxNewCheckBox_5);
		
		JCheckBox chckbxNewCheckBox_6 = new JCheckBox("c7    Embusilog");
		chckbxNewCheckBox_6.setBackground(new Color(154, 205, 50));
		chckbxNewCheckBox_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_6.isSelected()==true) {
					chckbxNewCheckBox_6.setOpaque(true);
					spinner_6.setVisible(true);
					
					txtArea.append(chckbxNewCheckBox_6.getText()+"   "+p45+"\n");
				}
				else {
					chckbxNewCheckBox_6.setOpaque(false);
					spinner_6.setVisible(false);
					spinner_6.setValue(1);
					
					if(txtArea.getText().contains(chckbxNewCheckBox_6.getText())) {
						String temp1=txtArea.getText();			//get the string
						String temp2=chckbxNewCheckBox_6.getText();
						String temp3=temp1.replaceAll(temp2+"   45\n", "");
						txtArea.setText(temp3);
					}
				}
			}
		});
		chckbxNewCheckBox_6.setOpaque(false);
		chckbxNewCheckBox_6.setFont(new Font("Tahoma", Font.PLAIN, 30));
		chckbxNewCheckBox_6.setBounds(6, 312, 299, 49);
		contentPane.add(chckbxNewCheckBox_6);
		
		JCheckBox chckbxNewCheckBox_7 = new JCheckBox("c8    Longsilog");
		chckbxNewCheckBox_7.setBackground(new Color(154, 205, 50));
		chckbxNewCheckBox_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_7.isSelected()==true) {
					chckbxNewCheckBox_7.setOpaque(true);
					spinner_7.setVisible(true);
					
					txtArea.append(chckbxNewCheckBox_7.getText()+"   "+p45+"\n");
				}
				else {
					chckbxNewCheckBox_7.setOpaque(false);
					spinner_7.setVisible(false);
					spinner_7.setValue(1);
					
					if(txtArea.getText().contains(chckbxNewCheckBox_7.getText())) {
						String temp1=txtArea.getText();			//get the string
						String temp2=chckbxNewCheckBox_7.getText();
						String temp3=temp1.replaceAll(temp2+"   45\n", "");
						txtArea.setText(temp3);
					}
				}
			}
		});
		chckbxNewCheckBox_7.setOpaque(false);
		chckbxNewCheckBox_7.setFont(new Font("Tahoma", Font.PLAIN, 30));
		chckbxNewCheckBox_7.setBounds(6, 364, 299, 49);
		contentPane.add(chckbxNewCheckBox_7);
		
		JCheckBox chckbxNewCheckBox_8 = new JCheckBox("c9    Tapsilog");
		chckbxNewCheckBox_8.setBackground(new Color(154, 205, 50));
		chckbxNewCheckBox_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_8.isSelected()==true) {
					chckbxNewCheckBox_8.setOpaque(true);
					spinner_8.setVisible(true);
					
					txtArea.append(chckbxNewCheckBox_8.getText()+"   "+p65+"\n");
				}
				else {
					chckbxNewCheckBox_8.setOpaque(false);
					spinner_8.setVisible(false);
					spinner_8.setValue(1);
					
					if(txtArea.getText().contains(chckbxNewCheckBox_8.getText())) {
						String temp1=txtArea.getText();			//get the string
						String temp2=chckbxNewCheckBox_8.getText();
						String temp3=temp1.replaceAll(temp2+"   65\n", "");
						txtArea.setText(temp3);
					}
				}
			}
		});
		chckbxNewCheckBox_8.setOpaque(false);
		chckbxNewCheckBox_8.setFont(new Font("Tahoma", Font.PLAIN, 30));
		chckbxNewCheckBox_8.setBounds(6, 416, 299, 49);
		contentPane.add(chckbxNewCheckBox_8);
		
		JLabel lblNewLabel = new JLabel("₱65");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(327, 0, 95, 49);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("₱45");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(327, 52, 95, 49);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("₱45");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(327, 104, 95, 49);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("₱65");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_3.setBounds(327, 156, 95, 49);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("₱55");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_4.setBounds(327, 208, 95, 49);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("₱45");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_5.setBounds(327, 260, 95, 49);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("₱45");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_6.setBounds(327, 312, 95, 49);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("₱45");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_7.setBounds(327, 364, 95, 49);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("₱65");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_8.setBounds(327, 416, 95, 49);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setBackground(new Color(240, 230, 140));
		lblNewLabel_9.setOpaque(true);
		lblNewLabel_9.setBounds(0, 0, 488, 465);
		contentPane.add(lblNewLabel_9);
		
		
		
		
		
		
		
		
		
		
		
		JCheckBox chckbxNewCheckBox_1_1 = new JCheckBox("s2    Fried Siomai");
		chckbxNewCheckBox_1_1.setBackground(new Color(154, 205, 50));
		chckbxNewCheckBox_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_1_1.isSelected()==true) {
					chckbxNewCheckBox_1_1.setOpaque(true);
					spinner_9.setVisible(true);
					
					txtArea.append(chckbxNewCheckBox_1_1.getText()+"   "+p45+"\n");
				}
				else {
					chckbxNewCheckBox_1_1.setOpaque(false);
					spinner_9.setVisible(false);
					spinner_9.setValue(1);
					
					if(txtArea.getText().contains(chckbxNewCheckBox_1_1.getText())) {
						String temp1=txtArea.getText();			//get the string
						String temp2=chckbxNewCheckBox_1_1.getText();
						String temp3=temp1.replaceAll(temp2+"   45\n", "");
						txtArea.setText(temp3);
					}
				}
			}
		});
		chckbxNewCheckBox_1_1.setOpaque(false);
		chckbxNewCheckBox_1_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		chckbxNewCheckBox_1_1.setBounds(6, 536, 501, 49);
		contentPane.add(chckbxNewCheckBox_1_1);
		
		JCheckBox chckbxNewCheckBox_9 = new JCheckBox("s1    Steam Siomai");
		chckbxNewCheckBox_9.setBackground(new Color(154, 205, 50));
		chckbxNewCheckBox_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_9.isSelected()==true) {
					chckbxNewCheckBox_9.setOpaque(true);
					spinner_10.setVisible(true);
					
					txtArea.append(chckbxNewCheckBox_9.getText()+"   "+p45+"\n");
				}
				else {
					chckbxNewCheckBox_9.setOpaque(false);
					spinner_10.setVisible(false);
					spinner_10.setValue(1);
					
					if(txtArea.getText().contains(chckbxNewCheckBox_9.getText())) {
						String temp1=txtArea.getText();			//get the string
						String temp2=chckbxNewCheckBox_9.getText();
						String temp3=temp1.replaceAll(temp2+"   45\n", "");
						txtArea.setText(temp3);
					}
				}
			}
		});
		chckbxNewCheckBox_9.setOpaque(false); 
		chckbxNewCheckBox_9.setFont(new Font("Tahoma", Font.PLAIN, 30));
		chckbxNewCheckBox_9.setBounds(6, 484, 501, 49);
		contentPane.add(chckbxNewCheckBox_9);
		
		JCheckBox chckbxNewCheckBox_2_1 = new JCheckBox("b1    Regular Burger");
		chckbxNewCheckBox_2_1.setBackground(new Color(154, 205, 50));
		chckbxNewCheckBox_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_2_1.isSelected()==true) {
					chckbxNewCheckBox_2_1.setOpaque(true);
					chckbxNewCheckBox_10_1_1.setEnabled(true);
					spinner_11.setVisible(true);
					
					txtArea.append(chckbxNewCheckBox_2_1.getText()+"   "+p40+"\n");
				}
				else {
					chckbxNewCheckBox_2_1.setOpaque(false);
					chckbxNewCheckBox_10_1_1.setEnabled(false);
					chckbxNewCheckBox_10_1_1.setSelected(false);
					chckbxNewCheckBox_10_1_1.setOpaque(false);
					spinner_11.setVisible(false);
					spinner_11.setValue(1);
					
					if(txtArea.getText().contains(chckbxNewCheckBox_2_1.getText())) {
						String temp1=txtArea.getText();			//get the string
						String temp2=chckbxNewCheckBox_2_1.getText();
						String temp3=temp1.replaceAll(temp2+"   40\n", "");
						txtArea.setText(temp3);
					}
				}
			}
		});
		chckbxNewCheckBox_2_1.setOpaque(false);
		chckbxNewCheckBox_2_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		chckbxNewCheckBox_2_1.setBounds(6, 588, 501, 49);
		contentPane.add(chckbxNewCheckBox_2_1);
		
		JCheckBox chckbxNewCheckBox_3_1 = new JCheckBox("b2    Burger with Cheese");
		chckbxNewCheckBox_3_1.setBackground(new Color(154, 205, 50));
		chckbxNewCheckBox_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_3_1.isSelected()==true) {
					chckbxNewCheckBox_3_1.setOpaque(true);
					chckbxNewCheckBox_10_1_2.setEnabled(true);
					spinner_12.setVisible(true);
					
					txtArea.append(chckbxNewCheckBox_3_1.getText()+"   "+p50+"\n");
				}
				else {
					chckbxNewCheckBox_3_1.setOpaque(false);
					chckbxNewCheckBox_10_1_2.setEnabled(false);
					chckbxNewCheckBox_10_1_2.setSelected(false);
					chckbxNewCheckBox_10_1_2.setOpaque(false);
					spinner_12.setVisible(false);
					spinner_12.setValue(1);
					
					if(txtArea.getText().contains(chckbxNewCheckBox_3_1.getText())) {
						String temp1=txtArea.getText();			//get the string
						String temp2=chckbxNewCheckBox_3_1.getText();
						String temp3=temp1.replaceAll(temp2+"   50\n", "");
						txtArea.setText(temp3);
					}
				}
			}
		});
		chckbxNewCheckBox_3_1.setOpaque(false);
		chckbxNewCheckBox_3_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		chckbxNewCheckBox_3_1.setBounds(6, 640, 501, 49);
		contentPane.add(chckbxNewCheckBox_3_1);
		
		JCheckBox chckbxNewCheckBox_4_1 = new JCheckBox("b3    Burger with Bheese & Egg");
		chckbxNewCheckBox_4_1.setBackground(new Color(154, 205, 50));
		chckbxNewCheckBox_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_4_1.isSelected()==true) {
					chckbxNewCheckBox_4_1.setOpaque(true);
					chckbxNewCheckBox_10_1_3.setEnabled(true);
					spinner_13.setVisible(true);
					
					txtArea.append(chckbxNewCheckBox_4_1.getText()+"   "+p55+"\n");
				}
				else {
					chckbxNewCheckBox_4_1.setOpaque(false);
					chckbxNewCheckBox_10_1_3.setEnabled(false);
					chckbxNewCheckBox_10_1_3.setSelected(false);
					chckbxNewCheckBox_10_1_3.setOpaque(false);
					spinner_13.setVisible(false);
					spinner_13.setValue(1);
					
					if(txtArea.getText().contains(chckbxNewCheckBox_4_1.getText())) {
						String temp1=txtArea.getText();			//get the string
						String temp2=chckbxNewCheckBox_4_1.getText();
						String temp3=temp1.replaceAll(temp2+"   55\n", "");
						txtArea.setText(temp3);
					}
				}
			}
		});
		chckbxNewCheckBox_4_1.setOpaque(false);
		chckbxNewCheckBox_4_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		chckbxNewCheckBox_4_1.setBounds(6, 692, 501, 49);
		contentPane.add(chckbxNewCheckBox_4_1);
		
		JCheckBox chckbxNewCheckBox_5_1 = new JCheckBox("b4    Ham with Cheese & Egg");
		chckbxNewCheckBox_5_1.setBackground(new Color(154, 205, 50));
		chckbxNewCheckBox_5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_5_1.isSelected()==true) {
					chckbxNewCheckBox_5_1.setOpaque(true);
					chckbxNewCheckBox_10_1_4.setEnabled(true);
					spinner_14.setVisible(true);

					txtArea.append(chckbxNewCheckBox_5_1.getText()+"   "+p55+"\n");
				}
				else {
					chckbxNewCheckBox_5_1.setOpaque(false);
					chckbxNewCheckBox_10_1_4.setEnabled(false);
					chckbxNewCheckBox_10_1_4.setSelected(false);
					chckbxNewCheckBox_10_1_4.setOpaque(false);
					spinner_14.setVisible(false);
					spinner_14.setValue(1);
					
					if(txtArea.getText().contains(chckbxNewCheckBox_5_1.getText())) {
						String temp1=txtArea.getText();			//get the string
						String temp2=chckbxNewCheckBox_5_1.getText();
						String temp3=temp1.replaceAll(temp2+"   55\n", "");
						txtArea.setText(temp3);
					}
				}
			}
		});
		chckbxNewCheckBox_5_1.setOpaque(false);
		chckbxNewCheckBox_5_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		chckbxNewCheckBox_5_1.setBounds(6, 744, 501, 49);
		contentPane.add(chckbxNewCheckBox_5_1);
		
		JCheckBox chckbxNewCheckBox_6_1 = new JCheckBox("b5    Double Patty with Cheese");
		chckbxNewCheckBox_6_1.setBackground(new Color(154, 205, 50));
		chckbxNewCheckBox_6_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_6_1.isSelected()==true) {
					chckbxNewCheckBox_6_1.setOpaque(true);
					chckbxNewCheckBox_10_1_5.setEnabled(true);
					spinner_15.setVisible(true);
					
					txtArea.append(chckbxNewCheckBox_6_1.getText()+"   "+p65+"\n");
				}
				else {
					chckbxNewCheckBox_6_1.setOpaque(false);
					chckbxNewCheckBox_10_1_5.setEnabled(false);
					chckbxNewCheckBox_10_1_5.setSelected(false);
					chckbxNewCheckBox_10_1_5.setOpaque(false);
					spinner_15.setVisible(false);
					spinner_15.setValue(1);
					
					if(txtArea.getText().contains(chckbxNewCheckBox_6_1.getText())) {
						String temp1=txtArea.getText();			//get the string
						String temp2=chckbxNewCheckBox_6_1.getText();
						String temp3=temp1.replaceAll(temp2+"   65\n", "");
						txtArea.setText(temp3);
					}
				}
			}
		});
		chckbxNewCheckBox_6_1.setOpaque(false);
		chckbxNewCheckBox_6_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		chckbxNewCheckBox_6_1.setBounds(6, 796, 501, 49);
		contentPane.add(chckbxNewCheckBox_6_1);
		
		JCheckBox chckbxNewCheckBox_7_1 = new JCheckBox("h1    Hotdog Sandwich");
		chckbxNewCheckBox_7_1.setBackground(new Color(154, 205, 50));
		chckbxNewCheckBox_7_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_7_1.isSelected()==true) {
					chckbxNewCheckBox_7_1.setOpaque(true);
					chckbxNewCheckBox_10_1_6.setEnabled(true);
					spinner_16.setVisible(true);
					
					txtArea.append(chckbxNewCheckBox_7_1.getText()+"   "+p20+"\n");
				}
				else {
					chckbxNewCheckBox_7_1.setOpaque(false);
					chckbxNewCheckBox_10_1_6.setEnabled(false);
					chckbxNewCheckBox_10_1_6.setSelected(false);
					chckbxNewCheckBox_10_1_6.setOpaque(false);
					spinner_16.setVisible(false);
					spinner_16.setValue(1);
					
					if(txtArea.getText().contains(chckbxNewCheckBox_7_1.getText())) {
						String temp1=txtArea.getText();			//get the string
						String temp2=chckbxNewCheckBox_7_1.getText();
						String temp3=temp1.replaceAll(temp2+"   20\n", "");
						txtArea.setText(temp3);
					}
				}
			}
		});
		chckbxNewCheckBox_7_1.setOpaque(false);
		chckbxNewCheckBox_7_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		chckbxNewCheckBox_7_1.setBounds(6, 848, 501, 49);
		contentPane.add(chckbxNewCheckBox_7_1);
		
		JCheckBox chckbxNewCheckBox_8_1 = new JCheckBox("h2    hotdog sandwich w/ cheese");
		chckbxNewCheckBox_8_1.setBackground(new Color(154, 205, 50));
		chckbxNewCheckBox_8_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_8_1.isSelected()==true) {
					chckbxNewCheckBox_8_1.setOpaque(true);
					chckbxNewCheckBox_10_1_7.setEnabled(true);
					spinner_17.setVisible(true);
					
					txtArea.append(chckbxNewCheckBox_8_1.getText()+"   "+p30+"\n");
				}
				else {
					chckbxNewCheckBox_8_1.setOpaque(false);
					chckbxNewCheckBox_10_1_7.setEnabled(false);
					chckbxNewCheckBox_10_1_7.setSelected(false);
					chckbxNewCheckBox_10_1_7.setOpaque(false);
					spinner_17.setVisible(false);
					spinner_17.setValue(1);
					
					if(txtArea.getText().contains(chckbxNewCheckBox_8_1.getText())) {
						String temp1=txtArea.getText();			//get the string
						String temp2=chckbxNewCheckBox_8_1.getText();
						String temp3=temp1.replaceAll(temp2+"   30\n", "");
						txtArea.setText(temp3);
					}
				}
			}
		});
		chckbxNewCheckBox_8_1.setOpaque(false);
		chckbxNewCheckBox_8_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		chckbxNewCheckBox_8_1.setBounds(6, 900, 501, 49);
		contentPane.add(chckbxNewCheckBox_8_1);

		JCheckBox chckbxNewCheckBox_8_1_1 = new JCheckBox("f1     Fries");
		chckbxNewCheckBox_8_1_1.setBackground(new Color(154, 205, 50));
		chckbxNewCheckBox_8_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_8_1_1.isSelected()==true) {
					chckbxNewCheckBox_8_1_1.setOpaque(true);
					spinner_18.setVisible(true);
					
					txtArea.append(chckbxNewCheckBox_8_1_1.getText()+"   "+p25+"\n");
				}
				else {
					chckbxNewCheckBox_8_1_1.setOpaque(false);
					spinner_18.setVisible(false);
					spinner_18.setValue(1);
					
					if(txtArea.getText().contains(chckbxNewCheckBox_8_1_1.getText())) {
						String temp1=txtArea.getText();			//get the string
						String temp2=chckbxNewCheckBox_8_1_1.getText();
						String temp3=temp1.replaceAll(temp2+"   25\n", "");
						txtArea.setText(temp3);
					}
				}
			}
		});
		chckbxNewCheckBox_8_1_1.setOpaque(false);
		chckbxNewCheckBox_8_1_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		chckbxNewCheckBox_8_1_1.setBounds(6, 951, 501, 49);
		contentPane.add(chckbxNewCheckBox_8_1_1);
		
		JLabel lblNewLabel_8_1 = new JLabel("₱30");
		lblNewLabel_8_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_8_1.setBounds(513, 900, 74, 49);
		contentPane.add(lblNewLabel_8_1);
		
		JLabel lblNewLabel_7_1 = new JLabel("₱20");
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_7_1.setBounds(513, 848, 74, 49);
		contentPane.add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_6_1 = new JLabel("₱65");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_6_1.setBounds(513, 796, 74, 49);
		contentPane.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("₱55");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_5_1.setBounds(513, 744, 74, 49);
		contentPane.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("₱55");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_4_1.setBounds(513, 692, 74, 49);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("₱50");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_3_1.setBounds(513, 640, 74, 49);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("₱40");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_2_1.setBounds(513, 588, 74, 49);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("₱45");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1_1.setBounds(513, 536, 74, 49);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_10 = new JLabel("₱45");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_10.setBounds(513, 484, 74, 49);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_8_1_1 = new JLabel("₱25");
		lblNewLabel_8_1_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_8_1_1.setBounds(513, 951, 74, 49);
		contentPane.add(lblNewLabel_8_1_1);
		
		JLabel lblNewLabel_9_1 = new JLabel("");
		lblNewLabel_9_1.setOpaque(true);
		lblNewLabel_9_1.setBackground(new Color(240, 230, 140));
		lblNewLabel_9_1.setBounds(0, 484, 689, 516);
		contentPane.add(lblNewLabel_9_1);
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setBackground(new Color(240, 230, 140));
		lblNewLabel_11.setOpaque(true);
		lblNewLabel_11.setBounds(513, 0, 330, 465);
		contentPane.add(lblNewLabel_11);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String oldContent="",replaced="",data="";
				Scanner myReader = null;
				try {
					myReader = new Scanner(accountData);
				} catch (FileNotFoundException e1) {
					System.out.println("Not Found!");
					e1.printStackTrace();
				}
				
				if (table_1.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(contentPane, "Please select a product to edit.", "Error", JOptionPane.ERROR_MESSAGE);
			    }
				else {
					
					
					while(myReader.hasNextLine()){
						oldContent = myReader.nextLine();
						
						//System.out.println(Character.toString(temporary.charAt(temporary.length()-2))+Character.toString(temporary.charAt(temporary.length()-1)));
						//if contains the value with the selected row
						if(oldContent.contains((CharSequence) table_1.getValueAt(table_1.getSelectedRow(), 0))) {
							
							/*
							if(temporary.charAt(temporary.length()-1)=='0'){
								String temp1="0"+Character.toString(temporary.charAt(temporary.length()-2));
								stockProductsLeft[count]=temp1;
							}
							else {
								String temp1=Character.toString(temporary.charAt(temporary.length()-2))+Character.toString(temporary.charAt(temporary.length()-1));
								stockProductsLeft[count]=temp1;
							}
							
							 
							String temp1=Character.toString(oldContent.charAt(oldContent.length()-2))+Character.toString(oldContent.charAt(oldContent.length()-1));*/
							String temp1=oldContent.substring(oldContent.indexOf(" ")+1);
							
							int temp2=Integer.parseInt(temp1);
							temp2++;
							
							String temp3=Integer.toString(temp2);
							
							table_1.setValueAt(" "+temp3, table_1.getSelectedRow(), 1);
							
							replaced=oldContent.replaceAll(temp1, temp3);
							
							String oldContent1="";
							File fileToBeModified = new File(pathDir);
							BufferedReader reader = null;
							FileWriter writer = null;
							try
							{
								reader = new BufferedReader(new FileReader(fileToBeModified));
			             
								//Reading all the lines of input text file into oldContent
								String line = reader.readLine();
								while (line != null) 
								{
									oldContent1 = oldContent1 + line + System.lineSeparator();
									line = reader.readLine();
								}
			             
								
								//Replacing oldString with newString in the oldContent
								String newContent = oldContent1.replaceAll(oldContent,replaced);
			             
								//Rewriting the input text file with newContent
								writer = new FileWriter(fileToBeModified);
								writer.write(newContent);
							}
							catch (IOException e1)
							{
								e1.printStackTrace();
							}
							finally
							{
								try
								{
									//Closing the resources
									reader.close();
									writer.close();
								} 
								catch (IOException e1) 
								{
									e1.printStackTrace();
								}
							}
						}
						
					}
					
					
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(1534, 798, 360, 40);
		contentPane.add(btnNewButton);
		
		JButton btnReduce = new JButton("REDUCE");
		btnReduce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String oldContent="",replaced="",data="";
				Scanner myReader = null;
				try {
					myReader = new Scanner(accountData);
				} catch (FileNotFoundException e1) {
					System.out.println("Not Found!");
					e1.printStackTrace();
				}
				
				if (table_1.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(contentPane, "Please select a product to edit.", "Error", JOptionPane.ERROR_MESSAGE);
			    }
				else {
					
					
					while(myReader.hasNextLine()){
						oldContent = myReader.nextLine();
						
						//if contains the value with the selected row
						if(oldContent.contains((CharSequence) table_1.getValueAt(table_1.getSelectedRow(), 0))) {
							String temp1=oldContent.substring(oldContent.indexOf(" ")+1);
							
							int temp2=Integer.parseInt(temp1);
							temp2--;
							
							String temp3=Integer.toString(temp2);
							
							table_1.setValueAt(" "+temp2, table_1.getSelectedRow(), 1);
							
							replaced=oldContent.replaceAll(temp1, temp3);
							
							
							String oldContent1="";
							File fileToBeModified = new File(pathDir);
							BufferedReader reader = null;
							FileWriter writer = null;
							try
							{
								reader = new BufferedReader(new FileReader(fileToBeModified));
			             
								//Reading all the lines of input text file into oldContent
								String line = reader.readLine();
								while (line != null) 
								{
									oldContent1 = oldContent1 + line + System.lineSeparator();
									line = reader.readLine();
								}
			             
								
								//Replacing oldString with newString in the oldContent
								String newContent = oldContent1.replaceAll(oldContent,replaced);
			             
								//Rewriting the input text file with newContent
								writer = new FileWriter(fileToBeModified);
								writer.write(newContent);
							}
							catch (IOException e1)
							{
								e1.printStackTrace();
							}
							finally
							{
								try
								{
									//Closing the resources
									reader.close();
									writer.close();
								} 
								catch (IOException e1) 
								{
									e1.printStackTrace();
								}
							}
						}
						
					}
					
					
				}
				
			}
		});
		btnReduce.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReduce.setBounds(1534, 848, 360, 40);
		contentPane.add(btnReduce);
		
		JButton btnSaveOrder = new JButton("SAVE ORDER");
		btnSaveOrder.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSaveOrder.setBounds(1009, 799, 360, 40);
		contentPane.add(btnSaveOrder);
		
		JButton btnClearSelectedOrder = new JButton("CLEAR SELECTED ORDER");
		btnClearSelectedOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				page1 restart=new page1();
				restart.setVisible(true);
				dispose();
			}
		});
		btnClearSelectedOrder.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnClearSelectedOrder.setBounds(1009, 848, 360, 40);
		contentPane.add(btnClearSelectedOrder);
		
		txtTotalPrice = new JTextField();
		txtTotalPrice.setFont(new Font("Segoe UI", Font.BOLD, 30));
		txtTotalPrice.setText("TOTAL PRICE:  ");
		txtTotalPrice.setBounds(853, 692, 671, 96);
		contentPane.add(txtTotalPrice);
		txtTotalPrice.setColumns(10);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}

/*

	JButton btnNewButton = new JButton("+");
		btnNewButton.setBounds(655, 130, 53, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("-");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int y1=chckbxNewCheckBox.getY();
				int y2=chckbxNewCheckBox_1.getY();
				int y3=chckbxNewCheckBox_2.getY();
				int y4=chckbxNewCheckBox_3.getY();
				int y5=chckbxNewCheckBox_4.getY();
				int y6=chckbxNewCheckBox_5.getY();
				int y7=chckbxNewCheckBox_6.getY();
				int y8=chckbxNewCheckBox_7.getY();
				int y9=chckbxNewCheckBox_8.getY();
				
				int width1=chckbxNewCheckBox.getWidth();
				int width2=chckbxNewCheckBox_1.getWidth();
				int width3=chckbxNewCheckBox_2.getWidth();
				int width4=chckbxNewCheckBox_3.getWidth();
				int width5=chckbxNewCheckBox_4.getWidth();
				int width6=chckbxNewCheckBox_5.getWidth();
				int width7=chckbxNewCheckBox_6.getWidth();
				int width8=chckbxNewCheckBox_7.getWidth();
				int width9=chckbxNewCheckBox_8.getWidth();
				
				int height1=chckbxNewCheckBox.getHeight();
				int height2=chckbxNewCheckBox_1.getHeight();
				int height3=chckbxNewCheckBox_2.getHeight();
				int height4=chckbxNewCheckBox_3.getHeight();
				int height5=chckbxNewCheckBox_4.getHeight();
				int height6=chckbxNewCheckBox_5.getHeight();
				int height7=chckbxNewCheckBox_6.getHeight();
				int height8=chckbxNewCheckBox_7.getHeight();
				int height9=chckbxNewCheckBox_8.getHeight();
				
				y2-=y;
				y3-=y+y;
				y4-=y+y+y;
				y5-=y+y+y+y;
				y6-=y+y+y+y+y;
				y7-=y+y+y+y+y+y;
				y8-=y+y+y+y+y+y+y;
				y9-=y+y+y+y+y+y+y+y;
				
				width1-=width;
				width2-=width;
				width3-=width;
				width4-=width;
				width5-=width;
				width6-=width;
				width7-=width;
				width8-=width;
				width9-=width;
				width9-=width;
				
				height1-=height;
				height2-=height;
				height3-=height;
				height4-=height;
				height5-=height;
				height6-=height;
				height7-=height;
				height8-=height;
				height9-=height;
				
				chckbxNewCheckBox_1.setLocation(6, y2);
				chckbxNewCheckBox_2.setLocation(6, y3);
				chckbxNewCheckBox_3.setLocation(6, y4);
				chckbxNewCheckBox_4.setLocation(6, y5);
				chckbxNewCheckBox_5.setLocation(6, y6);
				chckbxNewCheckBox_6.setLocation(6, y7);
				chckbxNewCheckBox_7.setLocation(6, y8);
				chckbxNewCheckBox_8.setLocation(6, y9);
				
				chckbxNewCheckBox.setSize(width1, height1);
				chckbxNewCheckBox_1.setSize(width2, height2);
				chckbxNewCheckBox_2.setSize(width3, height3);
				chckbxNewCheckBox_3.setSize(width4, height4);
				chckbxNewCheckBox_4.setSize(width5, height5);
				chckbxNewCheckBox_5.setSize(width6, height6);
				chckbxNewCheckBox_6.setSize(width7, height7);
				chckbxNewCheckBox_7.setSize(width8, height8);
				chckbxNewCheckBox_8.setSize(width9, height9);
				
				defaultFontSize--;
				chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, defaultFontSize));
				chckbxNewCheckBox_1.setFont(new Font("Tahoma", Font.PLAIN, defaultFontSize));
				chckbxNewCheckBox_2.setFont(new Font("Tahoma", Font.PLAIN, defaultFontSize));
				chckbxNewCheckBox_3.setFont(new Font("Tahoma", Font.PLAIN, defaultFontSize));
				chckbxNewCheckBox_4.setFont(new Font("Tahoma", Font.PLAIN, defaultFontSize));
				chckbxNewCheckBox_5.setFont(new Font("Tahoma", Font.PLAIN, defaultFontSize));
				chckbxNewCheckBox_6.setFont(new Font("Tahoma", Font.PLAIN, defaultFontSize));
				chckbxNewCheckBox_7.setFont(new Font("Tahoma", Font.PLAIN, defaultFontSize));
				chckbxNewCheckBox_8.setFont(new Font("Tahoma", Font.PLAIN, defaultFontSize));
				
				
				
				
				

				int x1=lblNewLabel.getX();
				int x2=lblNewLabel_1.getX();
				int x3=lblNewLabel_2.getX();
				int x4=lblNewLabel_3.getX();
				int x5=lblNewLabel_4.getX();
				int x6=lblNewLabel_5.getX();
				int x7=lblNewLabel_6.getX();
				int x8=lblNewLabel_7.getX();
				int x9=lblNewLabel_8.getX();
				int x10=lblNewLabel_9.getX();
				
				int y11=lblNewLabel.getY();
				int y21=lblNewLabel_1.getY();
				int y31=lblNewLabel_2.getY();
				int y41=lblNewLabel_3.getY();
				int y51=lblNewLabel_4.getY();
				int y61=lblNewLabel_5.getY();
				int y71=lblNewLabel_6.getY();
				int y81=lblNewLabel_7.getY();
				int y91=lblNewLabel_8.getY();
				int y101=lblNewLabel_9.getY();
				
				int width11=lblNewLabel.getWidth();
				int width21=lblNewLabel_1.getWidth();
				int width31=lblNewLabel_2.getWidth();
				int width41=lblNewLabel_3.getWidth();
				int width51=lblNewLabel_4.getWidth();
				int width61=lblNewLabel_5.getWidth();
				int width71=lblNewLabel_6.getWidth();
				int width81=lblNewLabel_7.getWidth();
				int width91=lblNewLabel_8.getWidth();
				int width101=lblNewLabel_9.getWidth();
				
				int height11=lblNewLabel.getHeight();
				int height21=lblNewLabel_1.getHeight();
				int height31=lblNewLabel_2.getHeight();
				int height41=lblNewLabel_3.getHeight();
				int height51=lblNewLabel_4.getHeight();
				int height61=lblNewLabel_5.getHeight();
				int height71=lblNewLabel_6.getHeight();
				int height81=lblNewLabel_7.getHeight();
				int height91=lblNewLabel_8.getHeight();
				int height101=lblNewLabel_9.getHeight();
				
				y21-=y;
				y31-=y+y;
				y41-=y+y+y;
				y51-=y+y+y+y;
				y61-=y+y+y+y+y;
				y71-=y+y+y+y+y+y;
				y81-=y+y+y+y+y+y+y;
				y91-=y+y+y+y+y+y+y+y;
				y101-=y+y+y+y+y+y+y+y;
				
				width11-=width;
				width21-=width;
				width31-=width;
				width41-=width;
				width51-=width;
				width61-=width;
				width71-=width;
				width81-=width;
				width91-=width;
				width101-=width;
				
				height11-=height;
				height21-=height;
				height31-=height;
				height41-=height;
				height51-=height;
				height61-=height;
				height71-=height;
				height81-=height;
				height91-=height;
				height101-=height;
				
				x++;
				x1-=x;
				x2-=x;
				x3-=x;
				x4-=x;
				x5-=x;
				x6-=x;
				x7-=x;
				x8-=x;
				x9-=x;
				x10-=x;
				
				lblNewLabel.setLocation(x1, y11);
				lblNewLabel_1.setLocation(x2, y21);
				lblNewLabel_2.setLocation(x3, y31);
				lblNewLabel_3.setLocation(x4, y41);
				lblNewLabel_4.setLocation(x5, y51);
				lblNewLabel_5.setLocation(x6, y61);
				lblNewLabel_6.setLocation(x7, y71);
				lblNewLabel_7.setLocation(x8, y81);
				lblNewLabel_8.setLocation(x9, y91);
				lblNewLabel_9.setLocation(6, y101);
				
				lblNewLabel.setSize(width11, height11);
				lblNewLabel_1.setSize(width21, height21);
				lblNewLabel_2.setSize(width31, height31);
				lblNewLabel_3.setSize(width41, height41);
				lblNewLabel_4.setSize(width51, height51);
				lblNewLabel_5.setSize(width61, height61);
				lblNewLabel_6.setSize(width71, height71);
				lblNewLabel_7.setSize(width81, height81);
				lblNewLabel_8.setSize(width91, height91);
				lblNewLabel_9.setSize(width101, height101);
				
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, defaultFontSize));
				lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, defaultFontSize));
				lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, defaultFontSize));
				lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, defaultFontSize));
				lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, defaultFontSize));
				lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, defaultFontSize));
				lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, defaultFontSize));
				lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, defaultFontSize));
				lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, defaultFontSize));
				lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, defaultFontSize));
				
				//******************************************************************************************************************************************************************
			}
		});
		btnNewButton_1.setBounds(655, 156, 53, 23);
		contentPane.add(btnNewButton_1);
















				chckbxNewCheckBox
				chckbxNewCheckBox_1
				chckbxNewCheckBox_2
				chckbxNewCheckBox_3
				chckbxNewCheckBox_4
				chckbxNewCheckBox_5
				chckbxNewCheckBox_6
				chckbxNewCheckBox_7
				chckbxNewCheckBox_8
				
				
				_1.setLocation(6, y21);
				_2.setLocation(6, y31);
				_3.setLocation(6, y41);
				_4.setLocation(6, y51);
				_5.setLocation(6, y61);
				_6.setLocation(6, y71);
				_7.setLocation(6, y81);
				_8.setLocation(6, y91);
				
				.setSize(width11, height11);
				_1.setSize(width21, height21);
				.setSize(width31, height31);
				.setSize(width41, height41);
				.setSize(width51, height51);
				.setSize(width61, height61);
				.setSize(width71, height71);
				.setSize(width81, height81);
				.setSize(width91, height91);
				
				defaultFontSize--;
				.setFont(new Font("Tahoma", Font.PLAIN, defaultFontSize));
				_1.setFont(new Font("Tahoma", Font.PLAIN, defaultFontSize));
				_2.setFont(new Font("Tahoma", Font.PLAIN, defaultFontSize));
				_3.setFont(new Font("Tahoma", Font.PLAIN, defaultFontSize));
				_4.setFont(new Font("Tahoma", Font.PLAIN, defaultFontSize));
				_5.setFont(new Font("Tahoma", Font.PLAIN, defaultFontSize));
				_6.setFont(new Font("Tahoma", Font.PLAIN, defaultFontSize));
				_7.setFont(new Font("Tahoma", Font.PLAIN, defaultFontSize));
				_8.setFont(new Font("Tahoma", Font.PLAIN, defaultFontSize));

*/