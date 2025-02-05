import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class OrderingSystem extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderingSystem frame = new OrderingSystem();
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
	public OrderingSystem() {
		setTitle("PIZZA ORDERING SYSTEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 553);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//FLAVORS PART
		JLabel lblFlavors = new JLabel("SELECT FLAVOR");
		lblFlavors.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFlavors.setBounds(27, 37, 97, 14);
		contentPane.add(lblFlavors);
		
		JLabel lblPricing1 = new JLabel();
		lblPricing1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPricing1.setText("90.00");
		lblPricing1.setBounds(157, 184, 65, 18);
		contentPane.add(lblPricing1);
		
		JLabel lblPricing2 = new JLabel();
		lblPricing2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPricing2.setText("110.00");
		lblPricing2.setBounds(157, 207, 65, 18);
		contentPane.add(lblPricing2);
		
		JLabel lblPricing3 = new JLabel();
		lblPricing3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPricing3.setText("130.00");
		lblPricing3.setBounds(157, 236, 65, 18);
		contentPane.add(lblPricing3);
		
		//START OF PRIZE CHANGING ON-CLICK
		JRadioButton rdbtnFlavor1 = new JRadioButton("HAWAIIAN");
		rdbtnFlavor1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnFlavor1.setSelected(true);
		rdbtnFlavor1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnFlavor1.isSelected()==true) {
					lblPricing1.setText("90.00");
					lblPricing2.setText("110.00");
					lblPricing3.setText("130.00");
				}
				
			}
		});
		buttonGroup.add(rdbtnFlavor1);
		rdbtnFlavor1.setBounds(32, 58, 134, 23);
		contentPane.add(rdbtnFlavor1);
		
		JRadioButton rdbtnFlavor2 = new JRadioButton("HAM AND CHEESE");
		rdbtnFlavor2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnFlavor2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblPricing1.setText("110.00");
				lblPricing2.setText("130.00");
				lblPricing3.setText("150.00");
			}
		});
		buttonGroup.add(rdbtnFlavor2);
		rdbtnFlavor2.setBounds(32, 84, 134, 23);
		contentPane.add(rdbtnFlavor2);
		
		JRadioButton rdbtnFlavor3 = new JRadioButton("PEPPERONI");
		rdbtnFlavor3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnFlavor3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblPricing1.setText("130.00");
				lblPricing2.setText("150.00");
				lblPricing3.setText("170.00");
			}
		});
		buttonGroup.add(rdbtnFlavor3);
		rdbtnFlavor3.setBounds(32, 110, 134, 23);
		contentPane.add(rdbtnFlavor3);
		//END OF PRIZE CHANGING ON-CLICK
		
		//SIZE PART
		JLabel lblSizes = new JLabel("SELECT SIZE");
		lblSizes.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSizes.setBounds(27, 161, 88, 14);
		contentPane.add(lblSizes);
		
		JRadioButton rdbtnSize1 = new JRadioButton("SMALL-SIZED");
		rdbtnSize1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		buttonGroup_1.add(rdbtnSize1);
		rdbtnSize1.setBounds(32, 182, 119, 23);
		contentPane.add(rdbtnSize1);
		rdbtnSize1.setSelected(true);
		
		JRadioButton rdbtnSize2 = new JRadioButton("MEDIUM-SIZED");
		rdbtnSize2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		buttonGroup_1.add(rdbtnSize2);
		rdbtnSize2.setBounds(32, 208, 119, 23);
		contentPane.add(rdbtnSize2);
		
		JRadioButton rdbtnSize3 = new JRadioButton("LARGE-SIZED");
		rdbtnSize3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		buttonGroup_1.add(rdbtnSize3);
		rdbtnSize3.setBounds(32, 234, 119, 23);
		contentPane.add(rdbtnSize3);
		
		
		//ADD-ONS PART
		JLabel lblAddOns = new JLabel("SELECT ADD-ONS");
		lblAddOns.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAddOns.setBounds(27, 287, 114, 14);
		contentPane.add(lblAddOns);
		
		JCheckBox chckbxAddon1 = new JCheckBox("PEPPER");
		chckbxAddon1.setBounds(32, 316, 97, 23);
		contentPane.add(chckbxAddon1);
		
		JCheckBox chckbxAddon2 = new JCheckBox("ONIONS");
		chckbxAddon2.setBounds(32, 342, 97, 23);
		contentPane.add(chckbxAddon2);
		
		JCheckBox chckbxAddon3 = new JCheckBox("BLACK OLIVES");
		chckbxAddon3.setBounds(32, 368, 97, 23);
		contentPane.add(chckbxAddon3);
		
		JCheckBox chckbxAddon4 = new JCheckBox("GREEN PEPPERS");
		chckbxAddon4.setBounds(32, 394, 97, 23);
		contentPane.add(chckbxAddon4);
		
		JCheckBox chckbxAddons5 = new JCheckBox("EXTRA CHEESE");
		chckbxAddons5.setBounds(32, 420, 97, 23);
		contentPane.add(chckbxAddons5);
		
		JLabel lblSummary = new JLabel("ORDER SUMMARY");
		lblSummary.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSummary.setBounds(232, 37, 134, 14);
		contentPane.add(lblSummary);
		
		
		//THE SUMMARY PANEL
		JTextPane txtpnSummaryPanel = new JTextPane();
		txtpnSummaryPanel.setForeground(Color.GRAY);
		txtpnSummaryPanel.setFont(new Font("Palatino Linotype", Font.PLAIN, 11));
		txtpnSummaryPanel.setBounds(232, 60, 294, 331);
		contentPane.add(txtpnSummaryPanel);
		
		//CREATING THE ORDER FUNCTION FOR SUMMARY
		JButton btnNewButton = new JButton("CREATE ORDER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String flavor="",size="",addons="",tempAO="";
				double total=0;
				//START OF FLAVOR AND SIZE SELECTION
				if(rdbtnFlavor1.isSelected()==true) {
					flavor="HAWAIIAN";
					if(rdbtnSize1.isSelected()==true) {
						size="SMALL-SIZED";
						total=90;
					}
					else if(rdbtnSize2.isSelected()==true) {
						size="MEDIUM-SIZED";
						total=110;
					}
					else if(rdbtnSize3.isSelected()==true) {
						size="LARGE-SIZED";
						total=130;
					}
				}
				else if(rdbtnFlavor2.isSelected()==true) {
					flavor="HAM AND CHEESE";
					if(rdbtnSize1.isSelected()==true) {
						size="SMALL-SIZED";
						total=110;
					}
					else if(rdbtnSize2.isSelected()==true) {
						size="MEDIUM-SIZED";
						total=130;
					}
					else if(rdbtnSize3.isSelected()==true) {
						size="b3";
						total=150;
					}
				}
				else if(rdbtnFlavor3.isSelected()==true) {
					flavor="PEPPERONI";
					if(rdbtnSize1.isSelected()==true) {
						size="SMALL-SIZED";
						total=130;
					}
					else if(rdbtnSize2.isSelected()==true) {
						size="MEDIUM-SIZED";
						total=150;
					}
					else if(rdbtnSize3.isSelected()==true) {
						size="LARGE-SIZED";
						total=170;
					}
				}
				//END OF FLAVOR AND THEIR SIZE SELECTION
				
				//START OF ADD-ONS SELECTIONS
				if(chckbxAddon1.isSelected()==true) {
					total=total+5;
					tempAO="\n	PEPPER";
					addons=addons+tempAO;
				}
				
				if(chckbxAddon2.isSelected()==true) {
					total=total+10;
					tempAO="\n	ONIONS";
					addons=addons+tempAO;
				}

				if(chckbxAddon3.isSelected()==true) {
					total=total+15;
					tempAO="\n	BLACK OLIVES";
					addons=addons+tempAO;
				}
				
				if(chckbxAddon4.isSelected()==true) {
					total=total+20;
					tempAO="\n	GREEN PEPPERS";
					addons=addons+tempAO;
				}

				if(chckbxAddons5.isSelected()==true) {
					total=total+25;
					tempAO="\n	EXTRA CHEESE";
					addons=addons+tempAO;
				}
				//END OF ADD-ONS SELECTION
				
				//PRINT THE SUMMARY
				txtpnSummaryPanel.setText("PIZZA FLAVOR  :  "+flavor+
										"\n\nPIZZA SIZE  :  "+size+
										"\n\nADD ONS  :  "+addons+
									"\n\n\nTOTAL PRICE  :  "+total+" pesos");
			}
		});
		btnNewButton.setBounds(27, 463, 186, 23);
		contentPane.add(btnNewButton);
		
		//START OF SELECTION BORDERS
			JLabel lblFlavorBorder = new JLabel("");
			lblFlavorBorder.setBounds(27, 56, 186, 80);
			lblFlavorBorder.setBorder(new LineBorder(new Color(0, 0, 0), 1));
			contentPane.add(lblFlavorBorder);
	
			JLabel lblSizeBorder = new JLabel("");
			lblSizeBorder.setBorder(new LineBorder(new Color(0, 0, 0), 1));
			lblSizeBorder.setBounds(27, 181, 186, 80);
			contentPane.add(lblSizeBorder);
	
			JLabel lblAddOnsBorder = new JLabel("");
			lblAddOnsBorder.setBorder(new LineBorder(new Color(0, 0, 0), 1));
			lblAddOnsBorder.setBounds(27, 308, 186, 144);
			contentPane.add(lblAddOnsBorder);
			//EXIT BUTTON
			JButton btnNewButton_1 = new JButton("EXIT");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			btnNewButton_1.setBackground(new Color(255, 228, 181));
			btnNewButton_1.setBounds(437, 463, 89, 23);
			contentPane.add(btnNewButton_1);
		//END OF SELECTION BORDERS
	}
}
