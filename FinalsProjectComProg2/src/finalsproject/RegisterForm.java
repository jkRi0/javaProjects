package finalsproject;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing. * ;
import java.awt. * ;
import java.awt.event. * ;
import java.awt.geom.RoundRectangle2D;
import java.awt.geom.RoundRectangle2D.Double;
import java.io. * ;
import java.awt.image.BufferedImage;


public class RegisterForm extends JFrame implements ActionListener {

  private static final long serialVersionUID = 1L;
  private JTextField usernameField;
  private JPasswordField passwordField;
  private JPanel panel;
  private JButton registerButton;
  private JLabel passwordLabel;
  private JLabel usernameLabel;
  private Double shape;
  private JCheckBox showPasswordCheckBox;
  private JLabel signUpLabel;

  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          RegisterForm frame = new RegisterForm();
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
  public RegisterForm() {

    try {
      UIManager.setLookAndFeel(new NimbusLookAndFeel());
    } catch(UnsupportedLookAndFeelException e) {

      e.printStackTrace();
    }

    setTitle("Register");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(350, 468);
    setUndecorated(true);
    setLocationRelativeTo(null);
    getContentPane().setLayout(null);
    shape = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30);
    // set the JFrame's shape to the elliptical shape
    setShape(shape);

    usernameLabel = new JLabel("Username:");
    usernameLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    usernameLabel.setBounds(78, 114, 192, 20);
    passwordLabel = new JLabel("Password:");
    passwordLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    passwordLabel.setBounds(78, 177, 192, 24);
    usernameField = new JTextField(20);
    usernameField.addKeyListener(new KeyAdapter() {@Override
      public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
          passwordField.requestFocus();
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
    usernameField.setBorder(BorderFactory.createCompoundBorder(
    BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0)), 
    BorderFactory.createEmptyBorder(5, 10, 5, 10) 
    ));
    usernameField.setBounds(78, 135, 192, 33);
    passwordField = new JPasswordField(20);
    passwordField.addKeyListener(new KeyAdapter() {@Override
      public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
          usernameField.requestFocus();
        }
      }
    });
    passwordField.addFocusListener(new FocusAdapter() {@Override
      public void focusGained(FocusEvent e) {
        if (passwordField.getText().equals("Password")) {
          passwordField.setEchoChar('*');
          passwordField.setText("");
        }
        else {
          passwordField.selectAll();
        }
      }@Override
      public void focusLost(FocusEvent e) {
        if (passwordField.getText().equals("")) {
          passwordField.setText("Password");
          passwordField.setEchoChar((char) 0);
        }
      }
    });
    passwordField.setBorder(BorderFactory.createCompoundBorder(
    BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0)), 
    BorderFactory.createEmptyBorder(5, 10, 5, 10) 

    ));
    passwordField.setBounds(78, 200, 192, 33);
    registerButton = new JButton("Register");
    registerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    registerButton.setBounds(78, 262, 192, 40);
    registerButton.setForeground(Color.WHITE);
    registerButton.setBackground(new Color(59, 89, 182));
    registerButton.setFocusPainted(false);
    registerButton.setFont(new Font("Malgun Gothic", Font.BOLD, 15));
    registerButton.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
    registerButton.setOpaque(true);
    registerButton.setBorderPainted(false);

    registerButton.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        registerButton.setBackground(new Color(89, 119, 222));
      }

      public void mouseExited(java.awt.event.MouseEvent evt) {
        registerButton.setBackground(new Color(59, 89, 182));
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
          passwordField.setEchoChar((char) 0);
        } else {
          passwordField.setEchoChar('•');
        }
      }
    });

    panel = new JPanel();
    panel.setBounds(0, 0, 383, 500);
    panel.setLayout(null);
    panel.add(usernameLabel);
    panel.add(usernameField);
    panel.add(passwordLabel);
    panel.add(passwordField);
    panel.add(showPasswordCheckBox);
    JLabel label = new JLabel("");
    label.setBounds(0, 0, 0, 0);
    panel.add(label);
    panel.add(registerButton);

    getContentPane().add(panel);
    setVisible(true);

    registerButton.addActionListener(this);

    final ImageIcon closeIcon = new ImageIcon("C:\\Users\\admin\\Downloads\\exits.png");
    final ImageIcon resizedIcon = new ImageIcon(closeIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
    final JLabel lblX = new JLabel(resizedIcon);
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
          RegisterForm.this.dispose();
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
    lblX.setBounds(305, 0, 35, 36);
    panel.add(lblX);

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

    signUpLabel = new JLabel("Sign Up");
    signUpLabel.setForeground(new Color(59, 89, 182));
    signUpLabel.addMouseListener(new MouseAdapter() {@Override
      public void mouseEntered(MouseEvent e) {
        signUpLabel.setForeground(new Color(89, 119, 222));
      }@Override
      public void mouseExited(MouseEvent e) {
        signUpLabel.setForeground(new Color(59, 89, 182));
      }
    });
    signUpLabel.setFont(new Font("Ebrima", Font.BOLD, 40));
    signUpLabel.setBounds(95, 66, 153, 48);
    panel.add(signUpLabel);

    JPanel design1 = new JPanel();
    design1.setBackground(new Color(59, 89, 182));
    design1.setBounds(0, 429, 350, 40);
    panel.add(design1);

    JPanel design2 = new JPanel();
    design2.setBackground(new Color(59, 89, 182));
    design2.setBounds(0, 0, 350, 40);
    panel.add(design2);

    final ImageIcon closeIcon3 = new ImageIcon("C:\\Users\\admin\\Downloads\\signin.png");
    final ImageIcon resizedIcon3 = new ImageIcon(closeIcon3.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH));
    final JLabel lblsignin = new JLabel(resizedIcon3);
    lblsignin.addMouseListener(new MouseAdapter() {@Override
      public void mouseClicked(MouseEvent e) {
        dispose(); 
        LoginForm registerForm = new LoginForm();
        registerForm.setVisible(true);
      }
    });
    lblsignin.setHorizontalAlignment(SwingConstants.CENTER);
    lblsignin.setBounds(228, 307, 33, 33);
    panel.add(lblsignin);

    JLabel lblNoAcc = new JLabel("You have accont? Click ➤");
    lblNoAcc.setFont(new Font("Dialog", Font.BOLD, 11));
    lblNoAcc.setBounds(78, 308, 140, 14);
    panel.add(lblNoAcc);
  }@Override
  public void actionPerformed(ActionEvent e) {
    String username = usernameField.getText();
    String password = new String(passwordField.getPassword());

    if (username.isEmpty() || password.isEmpty()) {
      JOptionPane.showMessageDialog(this, "Please enter both username and password!");
      return;
    }

    try {
      BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
      String line = reader.readLine();
      boolean exists = false;

      while (line != null) {
        String[] parts = line.split(",");

        if (parts.length == 2) {
          String existingUsername = parts[0].trim();
          String existingPassword = parts[1].trim();

          if (existingUsername.equalsIgnoreCase(username)) {
            exists = true;
            JOptionPane.showMessageDialog(this, "The entered username is already taken.");
            break;
          }

          if (existingPassword.equalsIgnoreCase(password)) {
            exists = true;
            JOptionPane.showMessageDialog(this, "The entered password is already taken.");
            break;
          }
        }

        line = reader.readLine();
      }
      reader.close();

      if (!exists) {
        boolean fileIsEmpty = isFileEmpty("users.txt");

        BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true));

        if (!fileIsEmpty) {
          
          writer.newLine();
        }

        writer.write(username);
        writer.write(",");
        writer.write(password);
        writer.close();
        JOptionPane.showMessageDialog(this, "User registered successfully.");
      }
    } catch(IOException ex) {
      JOptionPane.showMessageDialog(this, "Error reading or writing to file.");
      ex.printStackTrace();
    }
  }

  private boolean isFileEmpty(String filePath) throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(filePath));
    boolean isEmpty = reader.readLine() == null;
    reader.close();
    return isEmpty;
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