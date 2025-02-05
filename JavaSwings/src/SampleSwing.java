
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;


public class SampleSwing extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDisplay;
	
	String operations;
	String answer;
	Double firstnum;
	Double secondnum;
	Double result;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;
	private JButton btnMinus;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn1;
	private JButton btn2;
    private String enterNum;
	private JButton btn3;
	private JButton btnClear;
	private JButton btnBackSpace;
	private JButton btn0;
	private JButton btnDot;
	private JButton btnEquals;
	private JButton btnDivide;
	private JButton btnPlusMinus;
	private JButton btnTimes;
	private JButton btnPlus;
	private JLabel lblInputs;
	private JLabel lblBG;
	private JLabel lblTitle;
	

	
	
	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SampleSwing frame = new SampleSwing();
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
	public SampleSwing() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\admin\\Downloads\\logo na talaga.png"));
		setTitle("Calculator Application");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        addWindowListener(new java.awt.event.WindowAdapter() {
        	
        	
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
            	 try {
                     UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                 } catch (Exception e) {
                     e.printStackTrace();
                 }
            	 int confirm = JOptionPane.showOptionDialog(
            			 SampleSwing.this,
                         "Are you sure you want to exit the program?",
                         "Confirm Exit",
                         JOptionPane.YES_NO_OPTION,
                         JOptionPane.PLAIN_MESSAGE,
                         null, new Object[]{"Yes", "No"},
                         "Yes");

                 if (confirm == JOptionPane.YES_OPTION) {
                     System.exit(0);
               
                }
            }
                  
        });
		setBounds(100, 100, 320, 440);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(135, 206, 235));
		contentPane.setBackground(new Color(72, 209, 204));
		contentPane.setAutoscrolls(true);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtDisplay = new JTextField();
		txtDisplay.setForeground(Color.WHITE);
		txtDisplay.setBackground(Color.BLACK);
		txtDisplay.setEditable(false);
		txtDisplay.setFont(new Font("Dialog", Font.BOLD, 25));
		txtDisplay.setBounds(10, 26, 284, 55);
		txtDisplay.setHorizontalAlignment(JTextField.RIGHT);
		contentPane.add(txtDisplay);
		txtDisplay.setColumns(10);
		
		btnBackSpace = new JButton("⌫")	;
		btnBackSpace.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBackSpace.setBackground(new Color(0, 139, 139));
		btnBackSpace.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnBackSpace.setBackground(new Color(64, 224, 208));
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnBackSpace.setBackground(new Color(0, 139, 139));
		    }
		});
		btnBackSpace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String backspace = null;
				
				if(txtDisplay.getText().length()> 0 ) {
				 StringBuilder strB = new StringBuilder(txtDisplay.getText());
				 strB.deleteCharAt(txtDisplay.getText().length() - 1);
				 backspace = strB.toString();
				 txtDisplay.setText(backspace);
				}
					
			}
		});
		btnBackSpace.setFont(new Font("Dialog", Font.BOLD, 17));
		btnBackSpace.setBounds(10, 92, 71, 35);
		contentPane.add(btnBackSpace);
		
		btnClear = new JButton("C");
		btnClear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClear.setBackground(new Color(0, 139, 139));
		btnClear.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnClear.setBackground(new Color(64, 224, 208));
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnClear.setBackground(new Color(0, 139, 139));
		    }
		});
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDisplay.setText(null);
				lblInputs.setText(null);
			}
		});
		btnClear.setFont(new Font("Dialog", Font.BOLD, 20));
		btnClear.setBounds(111, 91, 85, 35);
		contentPane.add(btnClear);
		
		btnPlus = new JButton("+");
		btnPlus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPlus.setBackground(new Color(0, 139, 139));
		btnPlus.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnPlus.setBackground(new Color(64, 224, 208));
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnPlus.setBackground(new Color(0, 139, 139));
		    }
		});
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if (!txtDisplay.getText().equals("")) {
		            firstnum = Double.parseDouble(txtDisplay.getText());
		            txtDisplay.setText("");
		        }
		        operations = "+";
			}
		});
		btnPlus.setFont(new Font("Dialog", Font.BOLD, 20));
		btnPlus.setBounds(223, 92, 71, 35);
		
		contentPane.add(btnPlus);
		
	    btn7 = new JButton("7");
	    btn7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    btn7.setBackground(new Color(0, 139, 139));
	    btn7.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btn7.setBackground(new Color(64, 224, 208));
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btn7.setBackground(new Color(0, 139, 139));
		    }
		});
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enterNum = txtDisplay.getText() + btn7.getText();
			    txtDisplay.setText(enterNum);
			}
		});
		btn7.setFont(new Font("Dialog", Font.BOLD, 20));
		btn7.setBounds(10, 138, 55, 55);
		contentPane.add(btn7);
		
	    btn8 = new JButton("8");
	    btn8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    btn8.setBackground(new Color(0, 139, 139));
	    btn8.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btn8.setBackground(new Color(64, 224, 208));
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btn8.setBackground(new Color(0, 139, 139));
		    }
		});
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enterNum = txtDisplay.getText() + btn8.getText();
				txtDisplay.setText(enterNum);
			}
		});
		btn8.setFont(new Font("Dialog", Font.BOLD, 20));
		btn8.setBounds(85, 138, 55, 55);
		contentPane.add(btn8);
		
		btn9 = new JButton("9");
		btn9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn9.setBackground(new Color(0, 139, 139));
		btn9.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	btn9.setBackground(new Color(64, 224, 208));
			    }
			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	btn9.setBackground(new Color(0, 139, 139));
			    }
			});
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enterNum = txtDisplay.getText() + btn9.getText();
				txtDisplay.setText(enterNum);
			
			}
		});
		btn9.setFont(new Font("Dialog", Font.BOLD, 20));
		btn9.setBounds(163, 138, 55, 55);
		contentPane.add(btn9);
		
	    btnMinus = new JButton("-");
	    btnMinus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    btnMinus.setBackground(new Color(0, 139, 139));
	    btnMinus.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnMinus.setBackground(new Color(64, 224, 208));
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnMinus.setBackground(new Color(0, 139, 139));
		    }
		});
	    btnMinus.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	
	    		if(!txtDisplay.getText().equals("")) {
	                firstnum = Double.parseDouble(txtDisplay.getText());
	                txtDisplay.setText("");
	            }
	            operations = "-";

	    	}
	    });
	    btnMinus.setFont(new Font("Dialog", Font.BOLD, 20));
	    btnMinus.setBounds(239, 137, 55, 55);
		contentPane.add(btnMinus);
		
		btn4 = new JButton("4");
		btn4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn4.setBackground(new Color(0, 139, 139));
		btn4.setFont(new Font("Dialog", Font.BOLD, 20));
		btn4.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btn4.setBackground(new Color(64, 224, 208));
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btn4.setBackground(new Color(0, 139, 139));
		    }
		});
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enterNum = txtDisplay.getText() + btn4.getText();
				txtDisplay.setText(enterNum);
			
			}
		});
		btn4.setBounds(10, 204, 55, 55);
		contentPane.add(btn4);
		
	    btn5 = new JButton("5");
	    btn5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    btn5.setBackground(new Color(0, 139, 139));
	    btn5.setFont(new Font("Dialog", Font.BOLD, 20));
	    btn5.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btn5.setBackground(new Color(64, 224, 208));
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btn5.setBackground(new Color(0, 139, 139));
		    }
		});
	    btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enterNum = txtDisplay.getText() + btn5.getText();
				txtDisplay.setText(enterNum);
			}
		});
	    btn5.setBounds(85, 204, 55, 55);
		contentPane.add(btn5);
		
		btn6 = new JButton("6");
		btn6.setBackground(new Color(0, 139, 139));
		btn6.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btn6.setBackground(new Color(64, 224, 208));
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btn6.setBackground(new Color(0, 139, 139));
		    }
		});
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enterNum = txtDisplay.getText() + btn6.getText();
				txtDisplay.setText(enterNum);
			}
			
		});
		btn6.setFont(new Font("Dialog", Font.BOLD, 20));
		btn6.setBounds(163, 204, 55, 55);
		contentPane.add(btn6);
		btn6.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		btnTimes = new JButton("X");
		btnTimes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTimes.setBackground(new Color(0, 139, 139));
		btnTimes.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnTimes.setBackground(new Color(64, 224, 208));
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnTimes.setBackground(new Color(0, 139, 139));
		    }
		});
		btnTimes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtDisplay.getText().equals("")) {
		            firstnum = Double.parseDouble(txtDisplay.getText());
		            txtDisplay.setText("");
		        }
		        operations = "*";
			}
		});
		btnTimes.setFont(new Font("Dialog", Font.BOLD, 20));
		btnTimes.setBounds(239, 203, 55, 55);
		contentPane.add(btnTimes);
		
		btn1 = new JButton("1");
		btn1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn1.setBackground(new Color(0, 139, 139));
		btn1.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btn1.setBackground(new Color(64, 224, 208));
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btn1.setBackground(new Color(0, 139, 139));
		    }
		});
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enterNum = txtDisplay.getText() + btn1.getText();
				txtDisplay.setText(enterNum);
			}
			
		});
		btn1.setFont(new Font("Dialog", Font.BOLD, 20));
		btn1.setBounds(10, 273, 55, 55);
		contentPane.add(btn1);
		
		btn2 = new JButton("2");
		btn2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn2.setBackground(new Color(0, 139, 139));
		btn2.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btn2.setBackground(new Color(64, 224, 208));
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btn2.setBackground(new Color(0, 139, 139));
		    }
		});
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enterNum = txtDisplay.getText() + btn2.getText();
				txtDisplay.setText(enterNum);
			}
		});
		btn2.setFont(new Font("Dialog", Font.BOLD, 20));
		btn2.setBounds(85, 273, 55, 55);
		contentPane.add(btn2);
		
		btn3 = new JButton("3");
		btn3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn3.setBackground(new Color(0, 139, 139));
		btn3.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btn3.setBackground(new Color(64, 224, 208));
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btn3.setBackground(new Color(0, 139, 139));
		    }
		});
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enterNum = txtDisplay.getText() + btn3.getText();
				txtDisplay.setText(enterNum);
			}
		});
		btn3.setFont(new Font("Dialog", Font.BOLD, 20));
		btn3.setBounds(163, 273, 55, 55);
		contentPane.add(btn3);
		
		btnDivide = new JButton("÷");
		btnDivide.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDivide.setBackground(new Color(0, 139, 139));
		btnDivide.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnDivide.setBackground(new Color(64, 224, 208));
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnDivide.setBackground(new Color(0, 139, 139));
		    }
		});
		btnDivide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(!txtDisplay.getText().equals("")) {
			            firstnum = Double.parseDouble(txtDisplay.getText());
			            txtDisplay.setText("");
			        }
			        operations = "/";
			}
		});
		btnDivide.setFont(new Font("Dialog", Font.BOLD, 20));
		btnDivide.setBounds(239, 273, 55, 55);
		contentPane.add(btnDivide);
		
		btn0 = new JButton("0");
		btn0.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn0.setBackground(new Color(0, 139, 139));
		btn0.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btn0.setBackground(new Color(64, 224, 208));
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btn0.setBackground(new Color(0, 139, 139));
		    }
		});
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				enterNum = txtDisplay.getText() + btn0.getText();
				txtDisplay.setText(enterNum);
			}
		});
		btn0.setFont(new Font("Dialog", Font.BOLD, 20));
		btn0.setBounds(85, 339, 55, 55);
		contentPane.add(btn0);
		
		btnDot = new JButton(".");
		btnDot.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDot.setBackground(new Color(0, 139, 139));
		btnDot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				if(! txtDisplay.getText().contains(".")) {	
					txtDisplay.setText(txtDisplay.getText() + btnDot.getText());
				 
				}	
			}
		});
		btnDot.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        btnDot.setBackground(new Color(64, 224, 208));
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btnDot.setBackground(new Color(0, 139, 139));
		    }
		});
		btnDot.setFont(new Font("Dialog", Font.BOLD, 20));
		btnDot.setBounds(163, 339, 55, 55);
		contentPane.add(btnDot);
		
		btnPlusMinus = new JButton("+/-");
		btnPlusMinus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPlusMinus.setBackground(new Color(0, 139, 139));
		btnPlusMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double ops = Double.parseDouble(String.valueOf(txtDisplay.getText()));
				ops = ops * (-1);
				txtDisplay.setText(String.valueOf(ops));	 
				
			}
		});
		btnPlusMinus.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnPlusMinus.setBackground(new Color(64, 224, 208));
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnPlusMinus.setBackground(new Color(0, 139, 139));
		    }
		});
		btnPlusMinus.setFont(new Font("Dialog", Font.BOLD, 20));
		btnPlusMinus.setBounds(10, 339, 55, 55);
		contentPane.add(btnPlusMinus);
		
		btnEquals = new JButton("=");
		btnEquals.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEquals.setBackground(new Color(0, 139, 139));
		btnEquals.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnEquals.setBackground(new Color(64, 224, 208));
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnEquals.setBackground(new Color(0, 139, 139));
		    }
		});
		btnEquals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				secondnum = Double.parseDouble(txtDisplay.getText());
				if(operations == "+")
				{
					result = firstnum + secondnum;
					answer = Double.toString(result);
					double newResult=Double.parseDouble(answer);
					if(newResult%1==0) {
						int intResult=(int)newResult;
						txtDisplay.setText(Integer.toString(intResult));
					}
					else {
						txtDisplay.setText(answer);
					}
					
				}
				
				else if(operations == "-")
				{
					result = firstnum - secondnum;
					answer = Double.toString(result);
					double newResult=Double.parseDouble(answer);
					if(newResult%1==0) {
						int intResult=(int)newResult;
						txtDisplay.setText(String.valueOf(intResult));
					}
					else {
						txtDisplay.setText(answer);
					}
				}
				
				else if(operations == "*")
				{
					result = firstnum * secondnum;
					answer = Double.toString(result);
					double newResult=Double.parseDouble(answer);
					if(newResult%1==0) {
						int intResult=(int)newResult;
						txtDisplay.setText(String.valueOf(intResult));
					}
					else {
						txtDisplay.setText(answer);
					}
				}
				
				else if(operations == "/")
				{
					result = firstnum / secondnum;
					answer = Double.toString(result);
					double newResult=Double.parseDouble(answer);
					if(newResult%1==0) {
						int intResult=(int)newResult;
						txtDisplay.setText(String.valueOf(intResult));
					}
					else {
						txtDisplay.setText(answer);
					}
				}
				
				String firststring;
				String secondstring;
				if (firstnum % 1 == 0 && secondnum % 1 == 0) {
				    // if both numbers are integers, display them without decimal points
				    firststring = String.format("%.0f", firstnum);
				    secondstring = String.format("%.0f", secondnum);
				} else {
				    // otherwise, display them with decimal points
				    firststring = Double.toString(firstnum);
				    secondstring = Double.toString(secondnum);
				}

				lblInputs.setText(firststring + " " + operations + " " + secondstring + " = "); 
				
				if(e.getSource() == btnPlus) {
			            operations = "+";
			        } else if(e.getSource() == btnMinus) {
			            operations = "-";
			        } else if(e.getSource() == btnTimes) {
			            operations = "*";
			        } else if(e.getSource() == btnDivide) {
			            operations = "/";
			        }
			  }
			
		});
		btnEquals.setFont(new Font("Dialog", Font.BOLD, 20));
		btnEquals.setBounds(239, 335, 55, 55);
		contentPane.add(btnEquals);
		
		lblInputs = new JLabel("");
		lblInputs.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInputs.setHorizontalAlignment(JTextField.RIGHT);
		lblInputs.setBounds(10, 8, 284, 14);
		contentPane.add(lblInputs);
		
		lblTitle = new JLabel("");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTitle.setIcon(new ImageIcon("C:\\Users\\admin\\Downloads\\titleCA.png"));
		lblTitle.setBounds(10, 8, 50, 14);
		contentPane.add(lblTitle);
		
		lblBG = new JLabel("");
		lblBG.setHorizontalAlignment(SwingConstants.CENTER);
		lblBG.setHorizontalTextPosition(SwingConstants.CENTER);
		lblBG.setIcon(new ImageIcon("C:\\Users\\admin\\Downloads\\TRr.png"));
		lblBG.setBounds(-23, 0, 350, 414);
		contentPane.add(lblBG);
		
		
	}
}
