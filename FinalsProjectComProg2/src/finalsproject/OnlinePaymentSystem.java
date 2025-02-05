package finalsproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class OnlinePaymentSystem extends JFrame {

  private static final long serialVersionUID = 1L;
  private JPanel contentPane;
  private JButton btnMenu;
  private JLabel lblDate;
  private JButton btnAccount;
  private JLabel timeLabel;
  private JButton btnOnlinePayment;
  private JLabel blRegisterForm;
  private JTextField txtFullName;
  private JTextField txtGcash;
  private JTextField txtPayment;
  private JTextField txtCourse;
  private JButton btnInput;
  private JTextArea txtOPS;
private JButton btnDone;
private JLabel lblgcashdetails;
private JLabel lblsafe;

  /**
	 * Launch the application.
	 */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          OnlinePaymentSystem frame = new OnlinePaymentSystem();
          frame.setVisible(true);
        } catch(Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
	 * Create the frame.
	 */
  public OnlinePaymentSystem() {
    try {
      UIManager.setLookAndFeel(new NimbusLookAndFeel());
    } catch(UnsupportedLookAndFeelException e) {

      e.printStackTrace();
    }

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 1200, 700);
    setUndecorated(true);
    setLocationRelativeTo(null);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);

    JPanel panel = new JPanel();
    panel.setBackground(new Color(59, 89, 182));
    panel.setBounds(194, 0, 1006, 44);
    contentPane.add(panel);
    panel.setLayout(null);

    Timer timer = new Timer(1000, new ActionListener() {@Override
      public void actionPerformed(ActionEvent e) {
        updateDateLabel();
      }
    });
    timer.start();

    final ImageIcon closeIcon = new ImageIcon("C:\\Users\\admin\\Downloads\\exit.png");
    final ImageIcon resizedIcon = new ImageIcon(closeIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
    final JLabel lblX = new JLabel(resizedIcon);
    lblX.setBounds(963, 0, 43, 41);
    panel.add(lblX);
    lblX.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    lblX.addMouseListener(new MouseAdapter() {

      private Timer timer;
      private float opacity = 1.0f;
      private boolean fadingOut = false;
      private Timer fadeTimer;

      @Override
      public void mouseClicked(MouseEvent e) {
        Object[] options = {
          "Yes, close it",
          "No, keep it open"
        };

        ImageIcon customIcon = new ImageIcon("C:\\Users\\admin\\Downloads\\button.png");

        JLabel messageLabel = new JLabel("Are you sure to Sign out your Account?");
        messageLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JPanel customPanel = new JPanel();
        customPanel.setBackground(new Color(89, 119, 222));
        customPanel.setLayout(new BorderLayout());
        customPanel.add(new JLabel(customIcon), BorderLayout.WEST);
        customPanel.add(messageLabel, BorderLayout.CENTER);

        UIManager.put("OptionPane.okButtonText", "Yes");
        UIManager.put("OptionPane.cancelButtonText", "No");

        int choice = JOptionPane.showOptionDialog(

        customPanel, "Are you sure to Sign out your Account?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

        if (choice == JOptionPane.YES_OPTION) {
          OnlinePaymentSystem.this.dispose();
          LoginForm loginForm = new LoginForm();
          loginForm.setVisible(true);
        }
      }

      @Override
      public void mouseEntered(MouseEvent e) {
        if (fadeTimer != null && fadeTimer.isRunning()) {
          fadeTimer.stop();
        }
        fadingOut = false;
        fadeTimer = new Timer(10, new ActionListener() {@Override
          public void actionPerformed(ActionEvent e) {
            opacity -= 0.06f;
            if (opacity <= 0.0f) {
              opacity = 0.0f;
              ((Timer) e.getSource()).stop();
              lblX.setIcon(resizedIcon);
            } else {
              lblX.setIcon(getFadedIcon(resizedIcon, opacity));
            }
          }
        });
        fadeTimer.start();
      }@Override
      public void mouseExited(MouseEvent e) {
        if (fadeTimer != null && fadeTimer.isRunning()) {
          fadeTimer.stop();
        }
        fadingOut = true;
        fadeTimer = new Timer(10, new ActionListener() {@Override
          public void actionPerformed(ActionEvent e) {
            opacity += 0.06f;
            if (opacity >= 1.0f) {
              opacity = 1.0f;
              ((Timer) e.getSource()).stop();
            }
            lblX.setIcon(getFadedIcon(resizedIcon, opacity));
          }
        });
        fadeTimer.start();
      }
    });

    lblX.setHorizontalAlignment(SwingConstants.CENTER);

    final ImageIcon closeIcon2 = new ImageIcon("C:\\Users\\admin\\Downloads\\calendars.png");
    final ImageIcon resizedIcon2 = new ImageIcon(closeIcon2.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
    lblDate = new JLabel();
    lblDate.setBounds(46, 0, 224, 44);
    panel.add(lblDate);
    lblDate.setForeground(new Color(255, 255, 204));
    lblDate.setFont(new Font("Dialog", Font.BOLD, 25));
    final JLabel lbldate = new JLabel(resizedIcon2);
    lbldate.setBounds(0, 0, 43, 41);
    panel.add(lbldate);
    lbldate.setHorizontalAlignment(SwingConstants.CENTER);

    updateDateLabel();

    JPanel PSideMenu = new JPanel();
    PSideMenu.setBackground(new Color(89, 119, 222));
    PSideMenu.setBounds(0, 0, 194, 700);
    contentPane.add(PSideMenu);
    PSideMenu.setLayout(null);

    btnMenu = new JButton("Main Menu");
    btnMenu.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dispose();
        MainMenu.main(null);
      }
    });
    btnMenu.addMouseListener(new MouseAdapter() {@Override
      public void mouseEntered(MouseEvent e) {
        btnMenu.setBackground(new Color(149, 179, 242));
      }@Override
      public void mouseExited(MouseEvent e) {
        btnMenu.setBackground(new Color(89, 119, 222));
      }
    });
    btnMenu.setBounds(0, 0, 194, 44);
    PSideMenu.add(btnMenu);
    btnMenu.setBorder(null);
    btnMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnMenu.setFont(new Font("Dialog", Font.BOLD, 18));
    btnMenu.setForeground(new Color(0, 0, 0));
    btnMenu.setBackground(new Color(89, 119, 222));
    btnMenu.setFocusPainted(false);

    btnAccount = new JButton("Register Form");
    btnAccount.addMouseListener(new MouseAdapter() {@Override
      public void mouseEntered(MouseEvent e) {
        btnAccount.setBackground(new Color(149, 179, 242));
      }@Override
      public void mouseExited(MouseEvent e) {
        btnAccount.setBackground(new Color(89, 119, 222));
      }
    });
    btnAccount.setForeground(Color.BLACK);
    btnAccount.setFont(new Font("Dialog", Font.BOLD, 18));
    btnAccount.setFocusPainted(false);

    btnAccount.setBorder(null);
    btnAccount.setBackground(new Color(89, 119, 222));
    btnAccount.setBounds(0, 55, 194, 44);
    PSideMenu.add(btnAccount);

    btnOnlinePayment = new JButton("Online Payment");
    btnOnlinePayment.setBackground(new Color(89, 119, 222));
    btnOnlinePayment.addMouseListener(new MouseAdapter() {@Override
      public void mouseEntered(MouseEvent e) {
        btnOnlinePayment.setBackground(new Color(149, 179, 242));
      }@Override
      public void mouseExited(MouseEvent e) {
        btnOnlinePayment.setBackground(new Color(89, 119, 222));
      }
    });
    btnOnlinePayment.setEnabled(false);
    btnOnlinePayment.setForeground(Color.BLACK);
    btnOnlinePayment.setFont(new Font("Dialog", Font.BOLD, 18));
    btnOnlinePayment.setFocusPainted(false);
    btnOnlinePayment.setBorder(null);
    btnOnlinePayment.setBackground(new Color(89, 119, 222));
    btnOnlinePayment.setBounds(0, 110, 194, 44);
    PSideMenu.add(btnOnlinePayment);

    btnAccount.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {
        dispose();
        AccountManagement.main(null);
      }
    });

    final JPanel MenuPanel = new JPanel();
    MenuPanel.setBackground(new Color(153, 204, 204));
    MenuPanel.setBounds(194, 43, 1006, 657);
    contentPane.add(MenuPanel);
    MenuPanel.setLayout(null);
    
    final ImageIcon closeIcon1 = new ImageIcon("C:\\Users\\admin\\Downloads\\Cashless.png");
    final ImageIcon resizedIcon1 = new ImageIcon(closeIcon1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
    final JLabel lblProfile = new JLabel(resizedIcon1);
    lblProfile.setBounds(10, 11, 140, 121);
    MenuPanel.add(lblProfile);
    lblProfile.setHorizontalAlignment(SwingConstants.CENTER);

    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(12, 134, 986, 518);
    MenuPanel.add(scrollPane);

    JPanel panel_1 = new JPanel();
    scrollPane.setViewportView(panel_1);
    panel_1.setBackground(new Color(102, 153, 153));
    panel_1.setLayout(null);

    txtFullName = new JTextField();
    txtFullName.setEditable(false);
    txtFullName.setHorizontalAlignment(SwingConstants.CENTER);
    txtFullName.setBounds(10, 41, 276, 26);
    panel_1.add(txtFullName);
    txtFullName.setColumns(10);

    JLabel lblName = new JLabel("FULL NAME");
    lblName.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
    lblName.setHorizontalAlignment(SwingConstants.CENTER);
    lblName.setBounds(10, 16, 276, 26);
    panel_1.add(lblName);

    JLabel lblGcashNumber = new JLabel("GCASH NUMBER");
    lblGcashNumber.setHorizontalAlignment(SwingConstants.CENTER);
    lblGcashNumber.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
    lblGcashNumber.setBounds(10, 78, 276, 26);
    panel_1.add(lblGcashNumber);

    txtGcash = new JTextField();
    txtGcash.setHorizontalAlignment(SwingConstants.CENTER);
    txtGcash.setEditable(false);
    txtGcash.setColumns(10);
    txtGcash.setBounds(10, 106, 276, 26);
    panel_1.add(txtGcash);

    JLabel lblAmount = new JLabel("PAYMENT AMOUNT");
    lblAmount.setHorizontalAlignment(SwingConstants.CENTER);
    lblAmount.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
    lblAmount.setBounds(10, 143, 276, 26);
    panel_1.add(lblAmount);

    txtPayment = new JTextField();
    txtPayment.setHorizontalAlignment(SwingConstants.CENTER);
    txtPayment.setEditable(false);
    txtPayment.setColumns(10);
    txtPayment.setBounds(10, 170, 276, 26);
    panel_1.add(txtPayment);

    JLabel lblCourse = new JLabel("COURSE");
    lblCourse.setHorizontalAlignment(SwingConstants.CENTER);
    lblCourse.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
    lblCourse.setBounds(10, 207, 276, 26);
    panel_1.add(lblCourse);

    String[] courseOptions = {
      "BSIT ₱15,000",
      "BSCS ₱20,000",
      "BSIE ₱25,000"
    };
    DefaultComboBoxModel < String > courseModel = new DefaultComboBoxModel < >(courseOptions);
    final JComboBox < String > courseComboBox = new JComboBox < >(courseModel);
    courseComboBox.setBounds(10, 233, 276, 26);
    panel_1.add(courseComboBox);

    txtCourse = new JTextField();
    txtCourse.setHorizontalAlignment(SwingConstants.CENTER);
    txtCourse.setEditable(false);
    txtCourse.setColumns(10);
    txtCourse.setBounds(10, 233, 276, 26);
    panel_1.add(txtCourse);

    txtOPS = new JTextArea();
    txtOPS.setEditable(false);
    txtOPS.setBounds(296, 11, 438, 482);
    panel_1.add(txtOPS);

    btnInput = new JButton("Input");
    btnInput.setFont(new Font("Trebuchet MS", Font.BOLD, 19));
    btnInput.setBounds(62, 312, 161, 45);
    btnInput.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String fullName = JOptionPane.showInputDialog(MenuPanel, "Enter full name:");
        String gcashNumber = JOptionPane.showInputDialog(MenuPanel, "Enter GCASH number:");
        String paymentAmount = JOptionPane.showInputDialog(MenuPanel, "Enter payment amount:");
        
        if (fullName == null || fullName.isEmpty() || gcashNumber == null || gcashNumber.isEmpty() ||
                paymentAmount == null || paymentAmount.isEmpty()) {
            JOptionPane.showMessageDialog(MenuPanel, "Please fill up all fields", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String selectedCourse = (String) courseComboBox.getSelectedItem();
        String course = selectedCourse.substring(0, selectedCourse.indexOf(' '));
        String tuitionFee = selectedCourse.substring(selectedCourse.indexOf('₱') + 1);

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String paymentDate = dateFormat.format(date);

        txtFullName.setText(fullName);
        txtGcash.setText(gcashNumber);
        txtPayment.setText(paymentAmount);
        txtCourse.setText(course);

        String receipt = "Receipt\n\n";
        receipt += "Full Name: " + fullName + "\n";
        receipt += "Payment Date: " + paymentDate + "\n";
        receipt += "GCASH Number: " + gcashNumber + "\n";
        receipt += "Payment Amount: " + paymentAmount + "\n";
        receipt += "Course: " + course + "\n";
        receipt += "Tuition Fee: " + tuitionFee + "\n";
        txtOPS.setText(receipt);
        txtOPS.setLineWrap(true);
        txtOPS.setWrapStyleWord(true);
        
        saveTransactionData(fullName, gcashNumber, paymentAmount, paymentDate, course, tuitionFee);
      }
    });
    panel_1.add(btnInput);
    
    btnDone = new JButton("Done");
    btnDone.setFont(new Font("Trebuchet MS", Font.BOLD, 19));
    btnDone.setBounds(62, 400, 161, 45);
    btnDone.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    	    
    	    txtOPS.setText("");
    	    txtFullName.setText("");
    	    txtGcash.setText("");
    	    txtPayment.setText("");
    	    txtCourse.setText("");
    	  }
    	});
    panel_1.add(btnDone);
    
    final ImageIcon closeIcon3 = new ImageIcon("C:\\Users\\admin\\Downloads\\Gcash2.jpg");
    final ImageIcon resizedIcon3 = new ImageIcon(closeIcon3.getImage().getScaledInstance(230, 121, Image.SCALE_SMOOTH));
    final JLabel lblProfile2 = new JLabel(resizedIcon3);
    lblProfile2.setBounds(744, 194, 230, 121);
    panel_1.add(lblProfile2);
    lblProfile2.setHorizontalAlignment(SwingConstants.CENTER);
    
    lblgcashdetails = new JLabel("<html><center>Pay your<br>Tuition Fee <br>With<br>GCash</center></html>");
    lblgcashdetails.setForeground(new Color(0, 0, 0));
    lblgcashdetails.setFont(new Font("Verdana", Font.BOLD, 30));
    lblgcashdetails.setHorizontalAlignment(SwingConstants.CENTER);
    lblgcashdetails.setBounds(744, 24, 230, 159);
    panel_1.add(lblgcashdetails);
    
    lblsafe = new JLabel("<html><center>Safe<br>And<br>Secured<br>Transaction</center></html>");
    lblsafe.setForeground(new Color(0, 0, 0));
    lblsafe.setFont(new Font("Verdana", Font.BOLD, 30));
    lblsafe.setHorizontalAlignment(SwingConstants.CENTER);
    lblsafe.setBounds(744, 334, 230, 159);
    panel_1.add(lblsafe);

    blRegisterForm = new JLabel("Online Payment System");
    blRegisterForm.setForeground(new Color(0, 0, 0));
    blRegisterForm.addMouseListener(new MouseAdapter() {@Override
      public void mouseEntered(MouseEvent e) {
        blRegisterForm.setForeground(new Color(59, 89, 182));
      }@Override
      public void mouseExited(MouseEvent e) {
        blRegisterForm.setForeground(new Color(0, 0, 0));
      }
    });
    blRegisterForm.setFont(new Font("Verdana", Font.BOLD, 30));
    blRegisterForm.setBounds(160, 25, 455, 80);
    MenuPanel.add(blRegisterForm);

    timeLabel = new JLabel();
    timeLabel.setHorizontalTextPosition(SwingConstants.LEFT);
    timeLabel.setFont(new Font("Arial", Font.BOLD, 30));
    timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
    timeLabel.setBounds(823, 11, 183, 50);
    MenuPanel.add(timeLabel);

    Timer timers = new Timer(1000, new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        String timeString = sdf.format(now);
        timeLabel.setText(timeString);
      }
    });
    timers.setInitialDelay(0);
    timers.start();

    setVisible(true);

    final ImageIcon save2 = new ImageIcon("C:\\Users\\admin\\Downloads\\clock.png");
    final ImageIcon save3 = new ImageIcon(save2.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
    final JLabel lblsaveres = new JLabel(save3);
    lblsaveres.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    lblsaveres.setBounds(782, 11, 53, 50);
    lblsaveres.setForeground(new Color(255, 255, 204));
    lblsaveres.setFont(new Font("Dialog", Font.BOLD, 25));
    MenuPanel.add(lblsaveres);

  }

  private ImageIcon getFadedIcon(ImageIcon icon, float opacity) {
    opacity = Math.max(0.0f, Math.min(1.0f, opacity));
    Image image = icon.getImage();
    Image fadedImage = createFadedImage(image, opacity);
    return new ImageIcon(fadedImage);
  }

  private Image createFadedImage(Image image, float opacity) {
    int width = image.getWidth(null);
    int height = image.getHeight(null);
    BufferedImage fadedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2d = fadedImage.createGraphics();
    g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
    g2d.drawImage(image, 0, 0, null);
    g2d.dispose();
    return fadedImage;
  }
  private void updateDateLabel() {
    SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy");
    String currentDate = dateFormat.format(new Date());
    lblDate.setText("" + currentDate);
  }
  private void saveTransactionData(String fullName, String gcashNumber, String paymentAmount, String paymentDate, String course, String tuitionFee) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("transaction.txt", true))) {
      writer.write("Full Name: " + fullName);
      writer.newLine();
      writer.write("GCASH Number: " + gcashNumber);
      writer.newLine();
      writer.write("Payment Amount: " + paymentAmount);
      writer.newLine();
      writer.write("Payment Date: " + paymentDate);
      writer.newLine();
      writer.write("Course: " + course);
      writer.newLine();
      writer.write("Tuition Fee: " + tuitionFee);
      writer.newLine();
      writer.newLine();
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}