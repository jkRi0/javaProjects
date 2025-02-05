import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.DropMode;

public class Calculator extends JFrame {

	private JPanel contentPane;
	private JButton btnCALC;
	private JButton btnDX;
	private JButton btnXMinus;
	private JButton btnConst;
	private JButton btnBC;
	private JButton btnSR;
	private JButton btnSquared;
	private JButton btnPower;
	private JButton btnLog;
	private JButton btnIn;
	private JButton btnParMin;
	private JButton btnDots;
	private JButton btnHYP;
	private JButton btnSin;
	private JButton btnCos;
	private JButton btnTan;
	private JButton btnRCL;
	private JButton btnENG;
	private JButton btnParLef;
	private JButton btnParRig;
	private JButton btnOneDot;
	private JButton btnMPLUS;
	private JTextField txtField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator frame = new Calculator();
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
	public Calculator() {
		
		setTitle("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(495, 0, 510, 582);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(119, 136, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtField = new JTextField();
		txtField.setHorizontalAlignment(SwingConstants.RIGHT);
		txtField.setFont(new Font("Tahoma", Font.PLAIN, 32));
		txtField.setBackground(new Color(255, 255, 255));
		txtField.setEditable(false);
		txtField.setBounds(59, 24, 380, 50);
		contentPane.add(txtField);
		txtField.setColumns(10);
		
		btnCALC = new JButton("CALC");
		btnCALC.setBackground(Color.DARK_GRAY);
		btnCALC.setForeground(Color.WHITE);
		btnCALC.setBounds(10, 105, 75, 30);
		contentPane.add(btnCALC);
		
		btnDX = new JButton("dx");
		btnDX.setForeground(Color.WHITE);
		btnDX.setBackground(Color.DARK_GRAY);
		btnDX.setBounds(91, 105, 75, 30);
		contentPane.add(btnDX);
		
		btnXMinus = new JButton("x-1");
		btnXMinus.setBackground(Color.DARK_GRAY);
		btnXMinus.setForeground(Color.WHITE);
		btnXMinus.setBounds(328, 105, 75, 30);
		contentPane.add(btnXMinus);
		
		btnConst = new JButton("CONST");
		btnConst.setForeground(Color.WHITE);
		btnConst.setBackground(Color.DARK_GRAY);
		btnConst.setBounds(408, 105, 75, 30);
		contentPane.add(btnConst);
		
		btnBC = new JButton("b/c");
		btnBC.setForeground(Color.WHITE);
		btnBC.setBackground(Color.DARK_GRAY);
		btnBC.setBounds(10, 146, 75, 30);
		contentPane.add(btnBC);
		
		btnSR = new JButton("√");
		btnSR.setForeground(Color.WHITE);
		btnSR.setBackground(Color.DARK_GRAY);
		btnSR.setBounds(91, 146, 75, 30);
		contentPane.add(btnSR);
		
		btnSquared = new JButton("x^2");
		btnSquared.setForeground(Color.WHITE);
		btnSquared.setBackground(Color.DARK_GRAY);
		btnSquared.setBounds(176, 146, 66, 30);
		contentPane.add(btnSquared);
		
		btnPower = new JButton("^");
		btnPower.setForeground(Color.WHITE);
		btnPower.setBackground(Color.DARK_GRAY);
		btnPower.setBounds(252, 146, 66, 30);
		contentPane.add(btnPower);
		
		btnLog = new JButton("log");
		btnLog.setForeground(Color.WHITE);
		btnLog.setBackground(Color.DARK_GRAY);
		btnLog.setBounds(328, 146, 75, 30);
		contentPane.add(btnLog);
		
		btnIn = new JButton("In");
		btnIn.setForeground(Color.WHITE);
		btnIn.setBackground(Color.DARK_GRAY);
		btnIn.setBounds(408, 146, 75, 30);
		contentPane.add(btnIn);
		
		btnParMin = new JButton("(-)");
		btnParMin.setForeground(Color.WHITE);
		btnParMin.setBackground(Color.DARK_GRAY);
		btnParMin.setBounds(10, 187, 75, 30);
		contentPane.add(btnParMin);
		
		btnDots = new JButton("'''");
		btnDots.setForeground(Color.WHITE);
		btnDots.setBackground(Color.DARK_GRAY);
		btnDots.setBounds(91, 187, 75, 30);
		contentPane.add(btnDots);
		
		btnHYP = new JButton("hyp");
		btnHYP.setForeground(Color.WHITE);
		btnHYP.setBackground(Color.DARK_GRAY);
		btnHYP.setBounds(176, 187, 66, 30);
		contentPane.add(btnHYP);
		
		btnSin = new JButton("sin");
		btnSin.setForeground(Color.WHITE);
		btnSin.setBackground(Color.DARK_GRAY);
		btnSin.setBounds(252, 187, 66, 30);
		contentPane.add(btnSin);
		
		btnCos = new JButton("cos");
		btnCos.setForeground(Color.WHITE);
		btnCos.setBackground(Color.DARK_GRAY);
		btnCos.setBounds(328, 187, 75, 30);
		contentPane.add(btnCos);
		
		btnTan = new JButton("tan");
		btnTan.setForeground(Color.WHITE);
		btnTan.setBackground(Color.DARK_GRAY);
		btnTan.setBounds(408, 187, 75, 30);
		contentPane.add(btnTan);
		
		btnRCL = new JButton("RCL");
		btnRCL.setForeground(Color.WHITE);
		btnRCL.setBackground(Color.DARK_GRAY);
		btnRCL.setBounds(10, 228, 75, 30);
		contentPane.add(btnRCL);
		
		btnENG = new JButton("ENG");
		btnENG.setForeground(Color.WHITE);
		btnENG.setBackground(Color.DARK_GRAY);
		btnENG.setBounds(91, 228, 75, 30);
		contentPane.add(btnENG);
		
		btnParLef = new JButton("(");
		btnParLef.setForeground(Color.WHITE);
		btnParLef.setBackground(Color.DARK_GRAY);
		btnParLef.setBounds(176, 228, 66, 30);
		contentPane.add(btnParLef);
		
		btnParRig = new JButton(")");
		btnParRig.setForeground(Color.WHITE);
		btnParRig.setBackground(Color.DARK_GRAY);
		btnParRig.setBounds(252, 228, 66, 30);
		contentPane.add(btnParRig);
		
		btnOneDot = new JButton("'");
		btnOneDot.setForeground(Color.WHITE);
		btnOneDot.setBackground(Color.DARK_GRAY);
		btnOneDot.setBounds(329, 228, 75, 30);
		contentPane.add(btnOneDot);
		
		btnMPLUS = new JButton("M+");
		btnMPLUS.setForeground(Color.WHITE);
		btnMPLUS.setBackground(Color.DARK_GRAY);
		btnMPLUS.setBounds(408, 228, 75, 30);
		contentPane.add(btnMPLUS);
		
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text=txtField.getText()+"0";
				txtField.setText(text);
			}
		});
		btn0.setForeground(Color.WHITE);
		btn0.setFont(new Font("Tahoma", Font.BOLD, 17));
		btn0.setBackground(Color.LIGHT_GRAY);
		btn0.setBounds(42, 466, 70,50);
		contentPane.add(btn0);
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text=txtField.getText()+"1";
				txtField.setText(text);
			}
		});
		btn1.setForeground(Color.WHITE);
		btn1.setFont(new Font("Tahoma", Font.BOLD, 17));
		btn1.setBackground(Color.LIGHT_GRAY);
		btn1.setBounds(42, 405, 70,50);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text=txtField.getText()+"2";
				txtField.setText(text);
			}
		});
		btn2.setForeground(Color.WHITE);
		btn2.setFont(new Font("Tahoma", Font.BOLD, 17));
		btn2.setBackground(Color.LIGHT_GRAY);
		btn2.setBounds(123, 405, 70,50);
		contentPane.add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text=txtField.getText()+"3";
				txtField.setText(text);
			}
		});
		btn3.setForeground(Color.WHITE);
		btn3.setFont(new Font("Tahoma", Font.BOLD, 17));
		btn3.setBackground(Color.LIGHT_GRAY);
		btn3.setBounds(203, 405, 70,50);
		contentPane.add(btn3);
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text=txtField.getText()+"4";
				txtField.setText(text);
			}
		});
		btn4.setForeground(Color.WHITE);
		btn4.setFont(new Font("Tahoma", Font.BOLD, 17));
		btn4.setBackground(Color.LIGHT_GRAY);
		btn4.setBounds(42, 344, 70, 50);
		contentPane.add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text=txtField.getText()+"5";
				txtField.setText(text);
			}
		});
		btn5.setForeground(Color.WHITE);
		btn5.setFont(new Font("Tahoma", Font.BOLD, 17));
		btn5.setBackground(Color.LIGHT_GRAY);
		btn5.setBounds(123, 344, 70,50);
		contentPane.add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text=txtField.getText()+"6";
				txtField.setText(text);
			}
		});
		btn6.setForeground(Color.WHITE);
		btn6.setFont(new Font("Tahoma", Font.BOLD, 17));
		btn6.setBackground(Color.LIGHT_GRAY);
		btn6.setBounds(203, 344, 70,50);
		contentPane.add(btn6);
		
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text=txtField.getText()+"7";
				txtField.setText(text);
			}
		});
		btn7.setForeground(Color.WHITE);
		btn7.setFont(new Font("Tahoma", Font.BOLD, 17));
		btn7.setBackground(Color.LIGHT_GRAY);
		btn7.setBounds(42, 283, 70, 50);
		contentPane.add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text=txtField.getText()+"8";
				txtField.setText(text);
			}
		});
		btn8.setForeground(Color.WHITE);
		btn8.setFont(new Font("Tahoma", Font.BOLD, 17));
		btn8.setBackground(Color.LIGHT_GRAY);
		btn8.setBounds(123, 283, 70, 50);
		contentPane.add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text=txtField.getText()+"9";
				txtField.setText(text);
			}
		});
		btn9.setForeground(Color.WHITE);
		btn9.setFont(new Font("Tahoma", Font.BOLD, 17));
		btn9.setBackground(Color.LIGHT_GRAY);
		btn9.setBounds(202, 283, 70, 50);
		contentPane.add(btn9);
		
		JButton btnDel = new JButton("DEL");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String equation=txtField.getText();			//get the string
				int deleteIndex=equation.length();			//get the length of the string
				String newText=equation.substring(0, deleteIndex-1);	//get the characters, without the last index
				txtField.setText(newText);		
			}
		});
		btnDel.setForeground(Color.WHITE);
		btnDel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnDel.setBackground(new Color(240, 128, 128));
		btnDel.setBounds(301, 283, 70, 50);
		contentPane.add(btnDel);
		
		JButton btnAC = new JButton("AC");
		btnAC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtField.setText("");
			}
		});
		btnAC.setForeground(Color.WHITE);
		btnAC.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAC.setBackground(new Color(240, 128, 128));
		btnAC.setBounds(381, 283, 70, 50);
		contentPane.add(btnAC);
		
		JButton btnX = new JButton("X");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text=txtField.getText()+"*";
				txtField.setText(text);
			}
		});
		btnX.setForeground(Color.WHITE);
		btnX.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnX.setBackground(Color.LIGHT_GRAY);
		btnX.setBounds(301, 344, 70,50);
		contentPane.add(btnX);
		
		JButton btnDivide = new JButton("÷");
		btnDivide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text=txtField.getText()+"/";
				txtField.setText(text);
			}
		});
		btnDivide.setForeground(Color.WHITE);
		btnDivide.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnDivide.setBackground(Color.LIGHT_GRAY);
		btnDivide.setBounds(381, 344, 70,50);
		contentPane.add(btnDivide);
		
		JButton btnPlus = new JButton("+");
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text=txtField.getText()+"+";
				txtField.setText(text);
			}
		});
		btnPlus.setForeground(Color.WHITE);
		btnPlus.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnPlus.setBackground(Color.LIGHT_GRAY);
		btnPlus.setBounds(301, 405, 70,50);
		contentPane.add(btnPlus);
		
		JButton btnMinus = new JButton("-");
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text=txtField.getText()+"-";
				txtField.setText(text);
			}
		});
		btnMinus.setForeground(Color.WHITE);
		btnMinus.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnMinus.setBackground(Color.LIGHT_GRAY);
		btnMinus.setBounds(381, 405, 70,50);
		contentPane.add(btnMinus);
		
		JButton btnDot = new JButton(".");
		btnDot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtField.getText().contains(".")) {	
					txtField.setText(txtField.getText() + ".");
				}
				
			}
		});
		btnDot.setForeground(Color.WHITE);
		btnDot.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnDot.setBackground(Color.LIGHT_GRAY);
		btnDot.setBounds(123, 466, 70,50);
		contentPane.add(btnDot);
		
		JButton btnEXP = new JButton("EXP");
		btnEXP.setForeground(Color.WHITE);
		btnEXP.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnEXP.setBackground(Color.LIGHT_GRAY);
		btnEXP.setBounds(203, 466, 70,50);
		contentPane.add(btnEXP);
		
		JButton btnAns = new JButton("Ans");
		btnAns.setForeground(Color.WHITE);
		btnAns.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnAns.setBackground(Color.LIGHT_GRAY);
		btnAns.setBounds(301, 466, 70,50);
		contentPane.add(btnAns);
		
		JButton btnEqual = new JButton("=");
		btnEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnEqual.setForeground(Color.WHITE);
		btnEqual.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnEqual.setBackground(Color.LIGHT_GRAY);
		btnEqual.setBounds(381, 466, 70,50);
		contentPane.add(btnEqual);
		
		
		
		
		
		
		
		
		
		
	}
}
