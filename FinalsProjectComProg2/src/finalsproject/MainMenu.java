package finalsproject;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.io.File;

public class MainMenu extends JFrame {

  private static final long serialVersionUID = 1L;
  private JPanel contentPane;
  private JButton btnMenu;
  static String username;
  private JLabel lblDate;
  private JButton btnAccount;
  private JLabel timeLabel;
  private JTextArea PostText1;
  private JTextArea PostText2;
private JButton btnOnlinePayment;


  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          MainMenu frame = new MainMenu(username);
          frame.setVisible(true);
        } catch(Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  public MainMenu(String username) throws UnsupportedLookAndFeelException {

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

    MainMenu.username = username;

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
          MainMenu.this.dispose();
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
    btnMenu.setBounds(0, 0, 194, 44);
    PSideMenu.add(btnMenu);
    btnMenu.setBorder(null);
    btnMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    getRootPane().setDefaultButton(btnMenu);
    btnMenu.setFont(new Font("Dialog", Font.BOLD, 18));
    btnMenu.setForeground(new Color(0, 0, 0));
    btnMenu.setBackground(new Color(89, 119, 222));
    btnMenu.setEnabled(false);
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
    btnAccount.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
          dispose();
          AccountManagement.main(null);
        }
      });
    btnAccount.setBorder(null);
    btnAccount.setBackground(new Color(89, 119, 222));
    btnAccount.setBounds(0, 55, 194, 44);
    PSideMenu.add(btnAccount);
    
    btnOnlinePayment = new JButton("Online Payment\r\n");
    btnOnlinePayment.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		dispose();
    		OnlinePaymentSystem.main(null);
    	}
    });
    
    btnOnlinePayment.addMouseListener(new MouseAdapter() {@Override
        public void mouseEntered(MouseEvent e) {
    	    btnOnlinePayment.setBackground(new Color(149, 179, 242));
        }@Override
        public void mouseExited(MouseEvent e) {
        	btnOnlinePayment.setBackground(new Color(89, 119, 222));
        }
      });

    btnOnlinePayment.setForeground(Color.BLACK);
    btnOnlinePayment.setFont(new Font("Dialog", Font.BOLD, 18));
    btnOnlinePayment.setFocusPainted(false);
    btnOnlinePayment.setBorder(null);
    btnOnlinePayment.setBackground(new Color(89, 119, 222));
    btnOnlinePayment.setBounds(0, 110, 194, 44);
    PSideMenu.add(btnOnlinePayment);
    
    JPanel MenuPanel = new JPanel();
    MenuPanel.setBackground(new Color(153, 204, 204));
    MenuPanel.setBounds(194, 43, 1006, 657);
    contentPane.add(MenuPanel);
    MenuPanel.setLayout(null);

    timeLabel = new JLabel(); // Create a new JLabel instance
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

    final ImageIcon closeIcon1 = new ImageIcon("C:\\Users\\admin\\Downloads\\users.png");
    final ImageIcon resizedIcon1 = new ImageIcon(closeIcon1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
    final JLabel lblProfile = new JLabel(resizedIcon1);
    lblProfile.setBounds(10, 11, 140, 121);
    MenuPanel.add(lblProfile);
    lblProfile.setHorizontalAlignment(SwingConstants.CENTER);

    JLabel lblWelcome = new JLabel("Welcome, " + username);
    lblWelcome.setBounds(160, 48, 379, 41);
    MenuPanel.add(lblWelcome);
    lblWelcome.setForeground(new Color(0, 0, 0));
    lblWelcome.setFont(new Font("Dialog", Font.BOLD, 30));

    final ImageIcon save2 = new ImageIcon("C:\\Users\\admin\\Downloads\\clock.png");
    final ImageIcon save3 = new ImageIcon(save2.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
    final JLabel lblsaveres = new JLabel(save3);
    lblsaveres.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    lblsaveres.setBounds(782, 11, 53, 50);
    lblsaveres.setForeground(new Color(255, 255, 204));
    lblsaveres.setFont(new Font("Dialog", Font.BOLD, 25));
    MenuPanel.add(lblsaveres);
    
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(12, 134, 986, 518);
    MenuPanel.add(scrollPane);
    
    JPanel panel_1 = new JPanel();
    scrollPane.setViewportView(panel_1);
    panel_1.setBackground(new Color(102, 153, 153));
    panel_1.setLayout(null);
    
    JScrollPane scrollPane_1 = new JScrollPane();
    scrollPane_1.setBounds(9, 22, 366, 222);
    panel_1.add(scrollPane_1);
    
    PostText1 = new JTextArea();
    PostText1.setForeground(new Color(255, 255, 255));
    PostText1.setBackground(new Color(0, 102, 102));
    PostText1.setLineWrap(true);
    scrollPane_1.setViewportView(PostText1);
    PostText1.setFont(new Font("Verdana", Font.PLAIN, 15));
    PostText1.setEditable(false);
    
    JScrollPane scrollPane_2 = new JScrollPane();
    scrollPane_2.setBounds(11, 276, 366, 222);
    panel_1.add(scrollPane_2);
    
    PostText2 = new JTextArea();
    PostText2.setForeground(new Color(255, 255, 255));
    PostText2.setBackground(new Color(0, 102, 102));
    PostText2.setLineWrap(true);
    PostText2.setFont(new Font("Verdana", Font.PLAIN, 15));
    scrollPane_2.setViewportView(PostText2);
    PostText2.setEditable(false);
    
    JPanel PanelD = new JPanel();
    PanelD.setBackground(new Color(0, 102, 102));
    PanelD.setBounds(385, 24, 589, 100);
    panel_1.add(PanelD);
    PanelD.setLayout(null);
    
    JLabel lblEnrollNow = new JLabel("ENROLL NOW!");
    lblEnrollNow.setForeground(new Color(255, 255, 255));
    lblEnrollNow.setFont(new Font("Verdana", Font.BOLD, 45));
    lblEnrollNow.setHorizontalAlignment(SwingConstants.CENTER);
    lblEnrollNow.setBounds(10, 11, 569, 78);
    PanelD.add(lblEnrollNow);
    
    JPanel PanelD1 = new JPanel();
    PanelD1.setLayout(null);
    PanelD1.setBackground(new Color(0, 102, 102));
    PanelD1.setBounds(385, 135, 589, 363);
    panel_1.add(PanelD1);
    
    JLabel lblAvailable = new JLabel("Available Courses:");
    lblAvailable.setForeground(new Color(255, 255, 255));
    lblAvailable.setFont(new Font("Verdana", Font.BOLD, 25));
    lblAvailable.setHorizontalAlignment(SwingConstants.LEFT);
    lblAvailable.setBounds(10, 11, 268, 46);
    PanelD1.add(lblAvailable);
    
    JLabel lblBSIT = new JLabel("• Bachelor of Science and Information Technology");
    lblBSIT.setHorizontalAlignment(SwingConstants.LEFT);
    lblBSIT.setForeground(Color.WHITE);
    lblBSIT.setFont(new Font("Verdana", Font.BOLD, 10));
    lblBSIT.setBounds(10, 54, 304, 32);
    PanelD1.add(lblBSIT);
    
    JLabel lblBachelorOf = new JLabel("• Bachelor of Science in Computer Science");
    lblBachelorOf.setHorizontalAlignment(SwingConstants.LEFT);
    lblBachelorOf.setForeground(Color.WHITE);
    lblBachelorOf.setFont(new Font("Verdana", Font.BOLD, 10));
    lblBachelorOf.setBounds(10, 97, 304, 32);
    PanelD1.add(lblBachelorOf);
    
    JLabel lblBachelorOf_2 = new JLabel("• Bachelor of Science in Industrial Engineering");
    lblBachelorOf_2.setHorizontalAlignment(SwingConstants.LEFT);
    lblBachelorOf_2.setForeground(Color.WHITE);
    lblBachelorOf_2.setFont(new Font("Verdana", Font.BOLD, 10));
    lblBachelorOf_2.setBounds(10, 140, 304, 32);
    PanelD1.add(lblBachelorOf_2);
    
    final ImageIcon savet = new ImageIcon("C:\\Users\\admin\\Downloads\\IE.png");
    final ImageIcon savet1 = new ImageIcon(savet.getImage().getScaledInstance(304, 157, Image.SCALE_SMOOTH));
    final JLabel lblsaveret = new JLabel(savet1);
    lblsaveret.setForeground(new Color(255, 255, 204));
    lblsaveret.setFont(new Font("Dialog", Font.BOLD, 25));
    lblsaveret.setBounds(10, 195, 304, 157);
    PanelD1.add(lblsaveret);
    
    final ImageIcon savet2 = new ImageIcon("C:\\Users\\admin\\Downloads\\IT.jpg");
    final ImageIcon savet3 = new ImageIcon(savet2.getImage().getScaledInstance(304, 157, Image.SCALE_SMOOTH));
    final JLabel lblsaveret1 = new JLabel(savet3);
    lblsaveret1.setForeground(new Color(255, 255, 204));
    lblsaveret1.setFont(new Font("Dialog", Font.BOLD, 25));
    lblsaveret1.setBounds(324, 195, 255, 157);
    PanelD1.add(lblsaveret1);
    
   
	try {
        File file = new File("Post1"); 
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            PostText1.append(line + "\n");
        }
        reader.close();
    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error reading file", "Error", JOptionPane.ERROR_MESSAGE);
    }
	
	try {
        File file = new File("Post2"); 
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            PostText2.append(line + "\n");
        }
        reader.close();
    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error reading file", "Error", JOptionPane.ERROR_MESSAGE);
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
  private void updateDateLabel() {
    SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy");
    String currentDate = dateFormat.format(new Date());
    lblDate.setText("" + currentDate);
  }
}