package finalsproject;

import java.awt.geom.RoundRectangle2D;
import java.awt.geom.RoundRectangle2D.Double;
import java.awt.image.BufferedImage;
import javax.swing. * ;
import java.awt. * ;
import java.awt.event. * ;
import java.io. * ;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class LoginForm extends JFrame implements ActionListener {

  private static final long serialVersionUID = 1L;
  private JTextField usernameField;
  private JPasswordField pwdPassword;
  private JButton loginButton;
  private JCheckBox showPasswordCheckBox;
  private Double shape;
  private JLabel SignInLabel;
  private String username1;
  private String user = "admin";
  private String pass = "admin123";

  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          LoginForm frame = new LoginForm();
          frame.setVisible(true);
        } catch(Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  public LoginForm() {

    try {
      UIManager.setLookAndFeel(new NimbusLookAndFeel());
    } catch(UnsupportedLookAndFeelException e) {

      e.printStackTrace();
    }

    setTitle("Login");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(350, 468);
    setUndecorated(true);
    setLocationRelativeTo(null);
    getContentPane().setLayout(null);
    shape = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30);
    setShape(shape);

    JLabel usernameLabel = new JLabel("Username:");
    usernameLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    usernameLabel.setBounds(78, 114, 192, 20);
    JLabel passwordLabel = new JLabel("Password:");
    passwordLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    passwordLabel.setBounds(78, 177, 192, 24);
    usernameField = new JTextField(20);
    usernameField.addKeyListener(new KeyAdapter() {@Override
      public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
          pwdPassword.requestFocus();
        }
      }
    });
    usernameField.addFocusListener(new FocusAdapter() {@Override
      public void focusGained(FocusEvent e) {
        if (usernameField.getText().equals("Username")) {
          usernameField.setText("");
        }
        else {
          usernameField.selectAll();
        }
      }@Override
      public void focusLost(FocusEvent e) {
        if (usernameField.getText().equals("")) {
          usernameField.setText("Username");
        } else {
          String username = usernameField.getText();
          if (username.matches(".*[&%$@!>.].*")) {
            JOptionPane.showMessageDialog(usernameField, "Username should not contain &, %, $, @, !, >, or .", "Invalid Username", JOptionPane.ERROR_MESSAGE);
            usernameField.requestFocus();
          }
        }
      }
    });

    usernameField.setText("Username");
    usernameField.setBorder(BorderFactory.createCompoundBorder(
    BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0)), 
    BorderFactory.createEmptyBorder(5, 10, 5, 10) 
    ));

    usernameField.setBounds(78, 135, 192, 33);
    pwdPassword = new JPasswordField(20);
    pwdPassword.addKeyListener(new KeyAdapter() {@Override
      public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
          usernameField.requestFocus();
        }
      }
    });
    pwdPassword.addFocusListener(new FocusAdapter() {@Override
      public void focusGained(FocusEvent e) {
        if (pwdPassword.getText().equals("Password")) {
          pwdPassword.setEchoChar('•');
          pwdPassword.setText("");
        }
        else {
          pwdPassword.selectAll();
        }
      }@Override
      public void focusLost(FocusEvent e) {
        if (pwdPassword.getText().equals("")) {
          pwdPassword.setText("Password");
          pwdPassword.setEchoChar((char) 0);
        }
      }
    });
    pwdPassword.setText("");
    pwdPassword.setBorder(BorderFactory.createCompoundBorder(
    BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0)), 
    BorderFactory.createEmptyBorder(5, 10, 5, 10) 

    ));

    pwdPassword.setBounds(78, 200, 192, 33);
    loginButton = new JButton("Login");
    loginButton.setBorder(new LineBorder(new Color(0, 0, 0)));
    loginButton.addActionListener(this);
    loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    loginButton.setBounds(78, 262, 192, 40);
    loginButton.setForeground(Color.WHITE);
    loginButton.setBackground(new Color(59, 89, 182));
    loginButton.setFocusPainted(false);
    loginButton.setFont(new Font("Malgun Gothic", Font.BOLD, 15));
    loginButton.setOpaque(true);
    loginButton.setBorderPainted(false);
    Border customBorder = BorderFactory.createLineBorder(new Color(89, 119, 222), 2);

    loginButton.setBorder(customBorder);

    loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        loginButton.setBackground(new Color(89, 119, 222));
      }

      public void mouseExited(java.awt.event.MouseEvent evt) {
        loginButton.setBackground(new Color(59, 89, 182));
      }
    });

    showPasswordCheckBox = new JCheckBox("Show Password");
    showPasswordCheckBox.setFont(new Font("Dialog", Font.PLAIN, 11));
    showPasswordCheckBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    showPasswordCheckBox.setBounds(78, 240, 150, 20);
    showPasswordCheckBox.setFocusPainted(false);

    ImageIcon checkboxIcon = new ImageIcon("C:\\Users\\admin\\Downloads\\eye.png");
    Image resizedIcon4 = checkboxIcon.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
    ImageIcon smallIcon = new ImageIcon(resizedIcon4);

    UIDefaults defaults = UIManager.getLookAndFeelDefaults();
    defaults.put("CheckBox.foreground", Color.BLACK);
    defaults.put("CheckBox.font", new Font("Dialog", Font.PLAIN, 11));
    defaults.put("CheckBox.icon", smallIcon);

    showPasswordCheckBox.setUI(new javax.swing.plaf.metal.MetalCheckBoxUI());

    showPasswordCheckBox.addActionListener(new ActionListener() {@Override
      public void actionPerformed(ActionEvent e) {
        if (showPasswordCheckBox.isSelected()) {
          pwdPassword.setEchoChar((char) 0);
        } else {
          pwdPassword.setEchoChar('*');
        }
      }
    });

    JPanel panel = new JPanel();
    panel.setBounds(0, 0, 383, 500);
    panel.setLayout(null);
    panel.add(usernameLabel);
    panel.add(usernameField);
    panel.add(passwordLabel);
    panel.add(pwdPassword);
    panel.add(showPasswordCheckBox);
    panel.add(loginButton);

    getContentPane().add(panel);
    setVisible(true);

    final ImageIcon closeIcon = new ImageIcon("C:\\Users\\admin\\Downloads\\exits.png");
    final ImageIcon resizedIcon = new ImageIcon(closeIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));

    SignInLabel = new JLabel("Sign In");
    SignInLabel.setForeground(new Color(59, 89, 182));
    SignInLabel.addMouseListener(new MouseAdapter() {@Override
      public void mouseEntered(MouseEvent e) {
        SignInLabel.setForeground(new Color(89, 119, 222));
      }@Override
      public void mouseExited(MouseEvent e) {
        SignInLabel.setForeground(new Color(59, 89, 182));
      }
    });
    SignInLabel.setFont(new Font("Ebrima", Font.BOLD, 40));
    SignInLabel.setBounds(106, 65, 144, 48);
    panel.add(SignInLabel);

    final ImageIcon closeIcon1 = new ImageIcon("C:\\Users\\admin\\Downloads\\userist.png");
    final ImageIcon resizedIcon1 = new ImageIcon(closeIcon1.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
    final JLabel lbluserist = new JLabel(resizedIcon1);
    lbluserist.setHorizontalAlignment(SwingConstants.CENTER);
    lbluserist.setBounds(41, 135, 33, 33);
    panel.add(lbluserist);

    final ImageIcon closeIcon2 = new ImageIcon("C:\\Users\\admin\\Downloads\\padlocked.png");
    final ImageIcon resizedIcon2 = new ImageIcon(closeIcon2.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
    final JLabel lblpadlock = new JLabel(resizedIcon2);
    lblpadlock.setHorizontalAlignment(SwingConstants.CENTER);
    lblpadlock.setBounds(41, 200, 33, 33);
    panel.add(lblpadlock);

    JPanel design1 = new JPanel();
    design1.setBackground(new Color(59, 89, 182));
    design1.setBounds(0, 429, 350, 40);
    panel.add(design1);

    JPanel design2 = new JPanel();
    design2.setBackground(new Color(59, 89, 182));
    design2.setBounds(0, 0, 350, 40);
    panel.add(design2);
    design2.setLayout(null);
    final JLabel lblX_1 = new JLabel(resizedIcon);
    lblX_1.setBounds(305, 0, 35, 36);
    design2.add(lblX_1);
    lblX_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    lblX_1.addMouseListener(new MouseAdapter() {

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

        JLabel messageLabel = new JLabel("Are you sure you want to exit the application?");
        messageLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JPanel customPanel = new JPanel();
        customPanel.setBackground(new Color(89, 119, 222));
        customPanel.setLayout(new BorderLayout());
        customPanel.add(new JLabel(customIcon), BorderLayout.WEST);
        customPanel.add(messageLabel, BorderLayout.CENTER);

        UIManager.put("OptionPane.okButtonText", "Yes");
        UIManager.put("OptionPane.cancelButtonText", "No");

        int choice = JOptionPane.showOptionDialog(

        customPanel, "Are you sure you want to exit the application?", "⚠ Confirmation ⚠", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

        if (choice == JOptionPane.YES_OPTION) {
          LoginForm.this.dispose();
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
              lblX_1.setIcon(resizedIcon);
            } else {
              lblX_1.setIcon(getFadedIcon(resizedIcon, opacity));
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
            lblX_1.setIcon(getFadedIcon(resizedIcon, opacity));
          }
        });
        fadeTimer.start();
      }
    });

    lblX_1.setHorizontalAlignment(SwingConstants.CENTER);

    final ImageIcon closeIcon3 = new ImageIcon("C:\\Users\\admin\\Downloads\\signup.png");
    final ImageIcon resizedIcon3 = new ImageIcon(closeIcon3.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH));
    final JLabel lblsignup = new JLabel(resizedIcon3);
    lblsignup.addMouseListener(new MouseAdapter() {@Override
      public void mouseClicked(MouseEvent e) {
        dispose();
        RegisterForm registerForm = new RegisterForm();
        registerForm.setVisible(true);
      }
    });
    lblsignup.setHorizontalAlignment(SwingConstants.CENTER);
    lblsignup.setBounds(228, 307, 33, 33);
    panel.add(lblsignup);

    JLabel lblNoAcc = new JLabel("No account yet? Click ➤");
    lblNoAcc.setFont(new Font("Dialog", Font.BOLD, 11));
    lblNoAcc.setBounds(78, 308, 137, 14);
    panel.add(lblNoAcc);

  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String username = usernameField.getText();
    String password = new String(pwdPassword.getPassword());
    
    if(username.equals(user) && password.equals(pass)) {   
    	JOptionPane.showMessageDialog(this, "Login successful!");
      	AdminControl frame = new AdminControl();
      	frame.setVisible(true);
      	dispose();     
      }
    else {
  
    if (username.isEmpty() || password.isEmpty()) {
      JOptionPane.showMessageDialog(this, "Please enter both username and password!");
      return;
    }

    try {
      BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
      String line = reader.readLine();
      boolean found = false;

      while (line != null) {
        String[] parts = line.split(",");
        if (parts[0].equals(username) && parts[1].equals(password)) {
          found = true;
          break;
        }
        line = reader.readLine();
      }
      reader.close();

      if (found) {

        JOptionPane.showMessageDialog(this, "Login successful!");
        dispose();
        username1 = username;
        try {
          MainMenu mainMenu = new MainMenu(username);
        } catch(UnsupportedLookAndFeelException e1) {
          // TODO Auto-generated catch block
          e1.printStackTrace();
        }
        

      } else {
        JOptionPane.showMessageDialog(this, "Invalid username or password.");
      }
      
    } catch(IOException ex) {
      JOptionPane.showMessageDialog(this, "Error reading file.");

     }
    }
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
}
	    
        

  
	        
	    
	
	


