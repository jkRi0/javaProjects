package finalsproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
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
import javax.swing.JTextField;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt. * ;
import java.util.TimeZone;

public class AccountManagement extends JFrame {

  private static final long serialVersionUID = 1L;
  private JPanel contentPane;
  private JButton btnMenu;
  private JLabel lblDate;
  private JButton btnAccount;
  private JTextField txtNumber;
  private JTextField txtAge;
  private JTextField txtName;
  private JTextField txtGuardian;
  private JLabel lblRegisterForm;
  private JTextField txtEmail;
  private JLabel timeLabel;
  private JComboBox < String > comboBoxGender;
  private JComboBox < String > comboBoxSection;
  private JComboBox < String > comboBoxYear;
  private JComboBox < String > comboBoxDept;
  private JComboBox < String > comboBoxLoc;
  private JLabel lblclick;
  private Component lblme;
  private JButton btnSave;
private JButton btnOnlinePayment;

  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {

      public void run() {
        try {
          AccountManagement frame = new AccountManagement();
          frame.setVisible(true);
        } catch(Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  public AccountManagement() throws UnsupportedLookAndFeelException {

    UIManager.setLookAndFeel(new NimbusLookAndFeel());

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
          AccountManagement.this.dispose();
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
    btnMenu.addMouseListener(new MouseAdapter() {@Override
      public void mouseEntered(MouseEvent e) {
        btnMenu.setBackground(new Color(149, 179, 242));
      }@Override
      public void mouseExited(MouseEvent e) {
        btnMenu.setBackground(new Color(89, 119, 222));
      }
    });
    btnMenu.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dispose();
        MainMenu.main(null);

      }
    });
    btnMenu.setBounds(0, 0, 194, 44);
    btnMenu.setBorder(null);
    btnMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnMenu.setFont(new Font("Dialog", Font.BOLD, 18));
    btnMenu.setForeground(new Color(0, 0, 0));
    btnMenu.setBackground(new Color(89, 119, 222));
    btnMenu.setFocusPainted(false);
    PSideMenu.add(btnMenu);

    btnAccount = new JButton("Register Form");
    btnAccount.setEnabled(false);
    btnAccount.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {

}
    });

    btnAccount.setForeground(Color.BLACK);
    btnAccount.setFont(new Font("Dialog", Font.BOLD, 18));
    btnAccount.setFocusPainted(false);

    btnAccount.setBorder(null);
    btnAccount.setBackground(new Color(89, 119, 222));
    btnAccount.setBounds(0, 55, 194, 44);
    PSideMenu.add(btnAccount);
    
    btnOnlinePayment = new JButton("Online Payment ");
    btnOnlinePayment.addMouseListener(new MouseAdapter() {
    	@Override
    	public void mouseEntered(MouseEvent e) {
    		btnOnlinePayment.setBackground(new Color(149, 179, 242));
    	}
    	@Override
    	public void mouseExited(MouseEvent e) {
    		btnOnlinePayment.setBackground(new Color(89, 119, 222));
    	}
    });
    btnOnlinePayment.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		dispose();
    		OnlinePaymentSystem.main(null);
    	}
    });
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
    MenuPanel.setBackground(new Color(255, 255, 255));
    MenuPanel.setBounds(194, 43, 1006, 657);
    contentPane.add(MenuPanel);
    MenuPanel.setLayout(null);

    timeLabel = new JLabel(); 
    timeLabel.setHorizontalTextPosition(SwingConstants.LEFT);
    timeLabel.setFont(new Font("Arial", Font.BOLD, 30));
    timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
    timeLabel.setBounds(823, 44, 183, 50);
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

    txtNumber = new JTextField();
    txtNumber.addMouseListener(new MouseAdapter() {@Override
      public void mouseClicked(MouseEvent e) {
        txtNumber.selectAll();
      }
    });
    txtNumber.setFont(new Font("Arial", Font.BOLD, 15));
    txtNumber.setBorder(BorderFactory.createCompoundBorder(
    BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0)), BorderFactory.createEmptyBorder(5, 10, 5, 10)));
    txtNumber.setBounds(83, 388, 160, 34);
    txtNumber.setText("Phone Number");
    txtNumber.setEditable(false);
    MenuPanel.add(txtNumber);
    txtNumber.setColumns(10);

    txtAge = new JTextField();
    txtAge.addMouseListener(new MouseAdapter() {@Override
      public void mouseClicked(MouseEvent e) {
        txtAge.selectAll();
      }
    });
    txtAge.setFont(new Font("Arial", Font.BOLD, 15));
    txtAge.setBorder(BorderFactory.createCompoundBorder(
    BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0)), BorderFactory.createEmptyBorder(5, 10, 5, 10)));
    txtAge.setBounds(83, 264, 160, 34);
    txtAge.setText("Age");
    txtAge.setEditable(false);
    MenuPanel.add(txtAge);

    DefaultComboBoxModel < String > comboBoxModel = new DefaultComboBoxModel < >();
    comboBoxModel.addElement("Male");
    comboBoxModel.addElement("Female");
    comboBoxGender = new JComboBox < >(comboBoxModel);
    comboBoxGender.setFont(new Font("Arial", Font.BOLD, 15));
    comboBoxGender.setBounds(596, 329, 160, 32);
    comboBoxGender.setEditable(false);
    MenuPanel.add(comboBoxGender);

    String[] locOptions = {
      "Marinig",
      "Pulo",
      "Gulod",
      "Baclaran",
      "Banay-Banay",
      "Banlic",
      "Bigaa",
      "Butong",
      "Casile",
      "Diezmo",
      "Mamatid",
      "Nuigan",
      "Pittland",
      "Sala",
      "San Isidro",
      "Poblacion Uno",
      "Poblacion Dos",
      "Poblacion Tres",
    };
    DefaultComboBoxModel < String > locModel = new DefaultComboBoxModel < >(locOptions);
    comboBoxLoc = new JComboBox < >(locModel);
    comboBoxLoc.setFont(new Font("Arial", Font.BOLD, 15));
    comboBoxLoc.setBounds(596, 448, 160, 31);
    comboBoxLoc.setEditable(false);
    MenuPanel.add(comboBoxLoc);

    final ImageIcon guardian1 = new ImageIcon("C:\\Users\\admin\\Downloads\\policeman.png");
    final ImageIcon guardian2 = new ImageIcon(guardian1.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
    final JLabel lblguardian = new JLabel(guardian2);
    lblguardian.setBounds(35, 449, 38, 30);
    lblguardian.setForeground(new Color(255, 255, 204));
    lblguardian.setFont(new Font("Dialog", Font.BOLD, 25));
    MenuPanel.add(lblguardian);

    final ImageIcon dept1 = new ImageIcon("C:\\Users\\admin\\Downloads\\department.png");
    final ImageIcon dept2 = new ImageIcon(dept1.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
    final JLabel lbldept = new JLabel(dept2);
    lbldept.setBounds(548, 392, 38, 30);
    lbldept.setForeground(new Color(255, 255, 204));
    lbldept.setFont(new Font("Dialog", Font.BOLD, 25));
    MenuPanel.add(lbldept);

    final ImageIcon section1 = new ImageIcon("C:\\Users\\admin\\Downloads\\group.png");
    final ImageIcon section2 = new ImageIcon(section1.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
    final JLabel lblsection = new JLabel(section2);
    lblsection.setBounds(548, 208, 38, 30);
    lblsection.setForeground(new Color(255, 255, 204));
    lblsection.setFont(new Font("Dialog", Font.BOLD, 25));
    MenuPanel.add(lblsection);

    final ImageIcon idicon1 = new ImageIcon("C:\\Users\\admin\\Downloads\\id.png");
    final ImageIcon idicon2 = new ImageIcon(idicon1.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
    final JLabel lblname = new JLabel(idicon2);
    lblname.setBounds(35, 208, 38, 30);
    lblname.setForeground(new Color(255, 255, 204));
    lblname.setFont(new Font("Dialog", Font.BOLD, 25));
    MenuPanel.add(lblname);

    final ImageIcon closeIcon4 = new ImageIcon("C:\\Users\\admin\\Downloads\\telephone.png");
    final ImageIcon resizedIcon4 = new ImageIcon(closeIcon4.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
    final JLabel lblphone = new JLabel(resizedIcon4);
    lblphone.setBounds(35, 388, 38, 30);
    lblphone.setForeground(new Color(255, 255, 204));
    lblphone.setFont(new Font("Dialog", Font.BOLD, 25));
    MenuPanel.add(lblphone);

    final ImageIcon closeIcon5 = new ImageIcon("C:\\Users\\admin\\Downloads\\age.png");
    final ImageIcon resizedIco5 = new ImageIcon(closeIcon5.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
    final JLabel lblage = new JLabel(resizedIco5);
    lblage.setBounds(35, 264, 38, 30);
    lblage.setForeground(new Color(255, 255, 204));
    lblage.setFont(new Font("Dialog", Font.BOLD, 25));
    MenuPanel.add(lblage);

    final ImageIcon closeIcon6 = new ImageIcon("C:\\Users\\admin\\Downloads\\equality.png");
    final ImageIcon resizedIco6 = new ImageIcon(closeIcon6.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
    final JLabel lblequality = new JLabel(resizedIco6);
    lblequality.setBounds(548, 329, 38, 30);
    lblequality.setForeground(new Color(255, 255, 204));
    lblequality.setFont(new Font("Dialog", Font.BOLD, 25));
    MenuPanel.add(lblequality);

    final ImageIcon closeIcon7 = new ImageIcon("C:\\Users\\admin\\Downloads\\placeholder.png");
    final ImageIcon resizedIco7 = new ImageIcon(closeIcon7.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
    final JLabel lbllocation = new JLabel(resizedIco7);
    lbllocation.setBounds(548, 449, 38, 30);
    lbllocation.setForeground(new Color(255, 255, 204));
    lbllocation.setFont(new Font("Dialog", Font.BOLD, 25));
    MenuPanel.add(lbllocation);

    final ImageIcon email = new ImageIcon("C:\\Users\\admin\\Downloads\\gmail.png");
    final ImageIcon email1 = new ImageIcon(email.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
    final JLabel lblemail = new JLabel(email1);
    lblemail.setBounds(35, 329, 38, 30);
    lblemail.setForeground(new Color(255, 255, 204));
    lblemail.setFont(new Font("Dialog", Font.BOLD, 25));
    MenuPanel.add(lblemail);

    final ImageIcon year = new ImageIcon("C:\\Users\\admin\\Downloads\\yearlevel.png");
    final ImageIcon year1 = new ImageIcon(year.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
    final JLabel lblyear = new JLabel(year1);
    lblyear.setBounds(548, 264, 38, 30);
    lblyear.setForeground(new Color(255, 255, 204));
    lblyear.setFont(new Font("Dialog", Font.BOLD, 25));
    MenuPanel.add(lblyear);

    final ImageIcon closeIcon8 = new ImageIcon("C:\\Users\\admin\\Downloads\\edit.png");
    final ImageIcon resizedIco8 = new ImageIcon(closeIcon8.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
    final JLabel lbledit = new JLabel(resizedIco8);
    lbledit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    lbledit.addMouseListener(new MouseAdapter() {@Override
      public void mouseClicked(MouseEvent e) {
        txtNumber.setEditable(true);

      }
    });
    lbledit.setBounds(253, 388, 38, 30);
    lbledit.setForeground(new Color(255, 255, 204));
    lbledit.setFont(new Font("Dialog", Font.BOLD, 25));
    MenuPanel.add(lbledit);

    final ImageIcon saveicon1 = new ImageIcon("C:\\Users\\admin\\Downloads\\save.png");
    final ImageIcon saveicon2 = new ImageIcon(saveicon1.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
    final JLabel lblsave = new JLabel(saveicon2);
    lblsave.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    lblsave.addMouseListener(new MouseAdapter() {@Override
      public void mouseClicked(MouseEvent e) {
        txtNumber.setEditable(false);
      }
    });
    lblsave.setBounds(370, 388, 38, 30);
    lblsave.setForeground(new Color(255, 255, 204));
    lblsave.setFont(new Font("Dialog", Font.BOLD, 25));
    MenuPanel.add(lblsave);

    final ImageIcon closeIcon9 = new ImageIcon("C:\\Users\\admin\\Downloads\\delete.png");
    final ImageIcon resizedIco9 = new ImageIcon(closeIcon9.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
    final JLabel lbldelete = new JLabel(resizedIco9);
    lbldelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    lbldelete.addMouseListener(new MouseAdapter() {@Override
      public void mouseClicked(MouseEvent e) {
        txtNumber.setText("");
      }
    });
    lbldelete.setBounds(311, 388, 38, 30);
    lbldelete.setForeground(new Color(255, 255, 204));
    lbldelete.setFont(new Font("Dialog", Font.BOLD, 25));
    MenuPanel.add(lbldelete);

    final ImageIcon del1 = new ImageIcon("C:\\Users\\admin\\Downloads\\edit.png");
    final ImageIcon del2 = new ImageIcon(del1.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
    final JLabel lbledits = new JLabel(del2);
    lbledits.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    lbledits.addMouseListener(new MouseAdapter() {@Override
      public void mouseClicked(MouseEvent e) {
        txtAge.setEditable(true);
      }
    });
    lbledits.setBounds(253, 264, 38, 30);
    lbledits.setForeground(new Color(255, 255, 204));
    lbledits.setFont(new Font("Dialog", Font.BOLD, 25));
    MenuPanel.add(lbledits);

    final ImageIcon edit1 = new ImageIcon("C:\\Users\\admin\\Downloads\\delete.png");
    final ImageIcon edit2 = new ImageIcon(edit1.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
    final JLabel lbldeletes = new JLabel(edit2);
    lbldeletes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    lbldeletes.addMouseListener(new MouseAdapter() {@Override
      public void mouseClicked(MouseEvent e) {
        txtAge.setText("");
      }
    });
    lbldeletes.setBounds(311, 264, 38, 30);
    lbldeletes.setForeground(new Color(255, 255, 204));
    lbldeletes.setFont(new Font("Dialog", Font.BOLD, 25));
    MenuPanel.add(lbldeletes);

    final ImageIcon saveicon3 = new ImageIcon("C:\\Users\\admin\\Downloads\\save.png");
    final ImageIcon saveicon4 = new ImageIcon(saveicon3.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
    final JLabel lblsaves = new JLabel(saveicon4);
    lblsaves.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    lblsaves.addMouseListener(new MouseAdapter() {@Override
      public void mouseClicked(MouseEvent e) {
        txtAge.setEditable(false);
      }
    });
    lblsaves.setBounds(370, 264, 38, 30);
    lblsaves.setForeground(new Color(255, 255, 204));
    lblsaves.setFont(new Font("Dialog", Font.BOLD, 25));
    MenuPanel.add(lblsaves);

    String[] sectionOptions = {
      "1IT-A",
      "1IT-B",
      "1IT-C",
      "2IT-A",
      "2IT-B",
      "2IT-C",
      "3IT-A",
      "3IT-B",
      "3IT-C",
      "4IT-A",
      "4IT-B",
      "4IT-C",
      "1CS-A",
      "1CS-B",
      "1CS-C",
      "2CS-A",
      "2CS-B",
      "2CS-C",
      "3CS-A",
      "3CS-B",
      "3CS-C",
      "4CS-A",
      "4CS-B",
      "4CS-C",
      "1IE-A",
      "1IE-B",
      "1IE-C",
      "2IE-A",
      "2IE-B",
      "2IE-C",
      "3IE-A",
      "3IE-B",
      "3IE-C",
      "4IE-A",
      "4IE-B",
      "4IE-C"
    };
    DefaultComboBoxModel < String > sectionModel = new DefaultComboBoxModel < >(sectionOptions);
    comboBoxSection = new JComboBox < >(sectionModel);
    comboBoxSection.setFont(new Font("Arial", Font.BOLD, 15));
    comboBoxSection.setBounds(596, 206, 160, 32);
    comboBoxSection.setEditable(false);
    MenuPanel.add(comboBoxSection);

    txtName = new JTextField();
    txtName.addMouseListener(new MouseAdapter() {@Override
      public void mouseClicked(MouseEvent e) {
        txtName.selectAll();
      }
    });
    txtName.setText("Name");
    txtName.setFont(new Font("Arial", Font.BOLD, 15));
    txtName.setEditable(false);
    txtName.setBorder(BorderFactory.createCompoundBorder(

    BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0)),

    BorderFactory.createEmptyBorder(5, 10, 5, 10)

    ));
    txtName.setBounds(83, 206, 160, 32);
    MenuPanel.add(txtName);

    final ImageIcon dele2 = new ImageIcon("C:\\Users\\admin\\Downloads\\edit.png");
    final ImageIcon dele3 = new ImageIcon(dele2.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
    final JLabel lbledit2 = new JLabel(dele3);
    lbledit2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    lbledit2.addMouseListener(new MouseAdapter() {@Override
      public void mouseClicked(MouseEvent e) {
        txtName.setEditable(true);
      }
    });
    lbledit2.setBounds(253, 208, 38, 30);
    lbledit2.setForeground(new Color(255, 255, 204));
    lbledit2.setFont(new Font("Dialog", Font.BOLD, 25));
    MenuPanel.add(lbledit2);

    final ImageIcon delete2 = new ImageIcon("C:\\Users\\admin\\Downloads\\delete.png");
    final ImageIcon delete3 = new ImageIcon(delete2.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
    final JLabel lbldetele = new JLabel(delete3);
    lbldetele.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    lbldetele.addMouseListener(new MouseAdapter() {@Override
      public void mouseClicked(MouseEvent e) {
        txtName.setText("");
      }
    });
    lbldetele.setBounds(311, 208, 38, 30);
    lbldetele.setForeground(new Color(255, 255, 204));
    lbldetele.setFont(new Font("Dialog", Font.BOLD, 25));
    MenuPanel.add(lbldetele);

    final ImageIcon save = new ImageIcon("C:\\Users\\admin\\Downloads\\save.png");
    final ImageIcon save1 = new ImageIcon(save.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
    final JLabel lblsavere = new JLabel(save1);
    lblsavere.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    lblsavere.addMouseListener(new MouseAdapter() {@Override
      public void mouseClicked(MouseEvent e) {
        txtName.setEditable(false);
      }
    });
    lblsavere.setBounds(370, 208, 38, 30);
    lblsavere.setForeground(new Color(255, 255, 204));
    lblsavere.setFont(new Font("Dialog", Font.BOLD, 25));
    MenuPanel.add(lblsavere);

    String[] deptOptions = {
      "CSS",
      "CCE",
      "CHAS",
      "CEAS",
      "CBAA"
    };
    DefaultComboBoxModel < String > deptModel = new DefaultComboBoxModel < >(deptOptions);
    comboBoxDept = new JComboBox < >(deptModel);
    comboBoxDept.setFont(new Font("Arial", Font.BOLD, 15));
    comboBoxDept.setBounds(596, 389, 160, 32);
    MenuPanel.add(comboBoxDept);

    txtGuardian = new JTextField();
    txtGuardian.addMouseListener(new MouseAdapter() {@Override
      public void mouseClicked(MouseEvent e) {
        txtGuardian.selectAll();
      }
    });
    txtGuardian.setText("Guardian Name");
    txtGuardian.setFont(new Font("Arial", Font.BOLD, 15));
    txtGuardian.setEditable(false);
    txtGuardian.setBorder(BorderFactory.createCompoundBorder(

    BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0)),

    BorderFactory.createEmptyBorder(5, 10, 5, 10)

    ));
    txtGuardian.setBounds(83, 449, 160, 32);
    MenuPanel.add(txtGuardian);

    final ImageIcon dele6 = new ImageIcon("C:\\Users\\admin\\Downloads\\edit.png");
    final ImageIcon dele7 = new ImageIcon(dele6.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
    final JLabel lbledit4 = new JLabel(dele7);
    lbledit4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    lbledit4.addMouseListener(new MouseAdapter() {@Override
      public void mouseClicked(MouseEvent e) {
        txtGuardian.setEditable(true);
      }
    });
    lbledit4.setBounds(253, 449, 38, 30);
    lbledit4.setForeground(new Color(255, 255, 204));
    lbledit4.setFont(new Font("Dialog", Font.BOLD, 25));
    MenuPanel.add(lbledit4);

    final ImageIcon delete6 = new ImageIcon("C:\\Users\\admin\\Downloads\\delete.png");
    final ImageIcon delete7 = new ImageIcon(delete6.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
    final JLabel lbldetele2 = new JLabel(delete7);
    lbldetele2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    lbldetele2.addMouseListener(new MouseAdapter() {@Override
      public void mouseClicked(MouseEvent e) {
        txtGuardian.setText("");
      }
    });
    lbldetele2.setBounds(311, 448, 38, 30);
    lbldetele2.setForeground(new Color(255, 255, 204));
    lbldetele2.setFont(new Font("Dialog", Font.BOLD, 25));
    MenuPanel.add(lbldetele2);

    final ImageIcon save4 = new ImageIcon("C:\\Users\\admin\\Downloads\\save.png");
    final ImageIcon save5 = new ImageIcon(save4.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
    final JLabel lblsavere2 = new JLabel(save5);
    lblsavere2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    lblsavere2.addMouseListener(new MouseAdapter() {@Override
      public void mouseClicked(MouseEvent e) {
        txtGuardian.setEditable(false);
      }
    });
    lblsavere2.setBounds(370, 448, 38, 30);
    lblsavere2.setForeground(new Color(255, 255, 204));
    lblsavere2.setFont(new Font("Dialog", Font.BOLD, 25));
    MenuPanel.add(lblsavere2);

    btnSave = new JButton("Save");
    btnSave.addMouseListener(new MouseAdapter() {@Override
      public void mouseEntered(MouseEvent e) {
        btnSave.setBackground(new Color(129, 159, 232));
      }

      @Override
      public void mouseExited(MouseEvent e) {
        btnSave.setBackground(new Color(59, 89, 182));
      }
    });
    btnSave.setBackground(new Color(59, 89, 182));
    btnSave.setFont(new Font("Arial", Font.BOLD, 15));
    btnSave.setBounds(35, 509, 140, 41);
    MenuPanel.add(btnSave);

    lblRegisterForm = new JLabel("Student Registration Form");
    lblRegisterForm.setForeground(new Color(0, 0, 0));
    lblRegisterForm.addMouseListener(new MouseAdapter() {@Override
      public void mouseEntered(MouseEvent e) {
        lblRegisterForm.setForeground(new Color(59, 89, 182));
      }@Override
      public void mouseExited(MouseEvent e) {
        lblRegisterForm.setForeground(new Color(0, 0, 0));
      }
    });
    lblRegisterForm.setFont(new Font("Verdana", Font.BOLD, 30));
    lblRegisterForm.setBounds(160, 25, 455, 80);
    MenuPanel.add(lblRegisterForm);

    txtEmail = new JTextField();
    txtEmail.setText("Email");
    txtEmail.setFont(new Font("Arial", Font.BOLD, 15));
    txtEmail.setEditable(false);
    txtEmail.setColumns(10);
    txtEmail.setBorder(BorderFactory.createCompoundBorder(

    BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0)), 

    BorderFactory.createEmptyBorder(5, 10, 5, 10) 
    
    ));
    txtEmail.setBounds(83, 328, 160, 31);
    MenuPanel.add(txtEmail);

    final ImageIcon editer = new ImageIcon("C:\\Users\\admin\\Downloads\\edit.png");
    final ImageIcon editer1 = new ImageIcon(editer.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
    final JLabel lbledt = new JLabel(editer1);
    lbledt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    lbledt.addMouseListener(new MouseAdapter() {@Override
      public void mouseClicked(MouseEvent e) {
        txtEmail.setEditable(true);
      }
    });
    lbledt.setBounds(253, 328, 38, 30);
    lbledt.setForeground(new Color(255, 255, 204));
    lbledt.setFont(new Font("Dialog", Font.BOLD, 25));
    MenuPanel.add(lbledt);

    final ImageIcon dels = new ImageIcon("C:\\Users\\admin\\Downloads\\delete.png");
    final ImageIcon dels1 = new ImageIcon(dels.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
    final JLabel lbldlt = new JLabel(dels1);
    lbldlt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    lbldlt.addMouseListener(new MouseAdapter() {@Override
      public void mouseClicked(MouseEvent e) {
        txtEmail.setText("");
      }
    });
    lbldlt.setBounds(311, 329, 38, 30);
    lbldlt.setForeground(new Color(255, 255, 204));
    lbldlt.setFont(new Font("Dialog", Font.BOLD, 25));
    MenuPanel.add(lbldlt);

    final ImageIcon savesz = new ImageIcon("C:\\Users\\admin\\Downloads\\save.png");
    final ImageIcon savesz1 = new ImageIcon(savesz.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
    final JLabel lblsavers3 = new JLabel(savesz1);
    lblsavers3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    lblsavers3.addMouseListener(new MouseAdapter() {@Override
      public void mouseClicked(MouseEvent e) {
        txtEmail.setEditable(false);
      }
    });
    lblsavers3.setBounds(370, 329, 38, 30);
    lblsavers3.setForeground(new Color(255, 255, 204));
    lblsavers3.setFont(new Font("Dialog", Font.BOLD, 25));
    MenuPanel.add(lblsavers3);

    String[] yearOptions = {
      "1st Year",
      "2nd Year",
      "3rd Year",
      "4th Year"
    };
    DefaultComboBoxModel < String > yearModel = new DefaultComboBoxModel < >(yearOptions);
    comboBoxYear = new JComboBox < >(yearModel);
    comboBoxYear.setFont(new Font("Arial", Font.BOLD, 15));
    comboBoxYear.setBounds(596, 266, 160, 31);
    comboBoxYear.setEditable(false);
    MenuPanel.add(comboBoxYear);

    final ImageIcon save2 = new ImageIcon("C:\\Users\\admin\\Downloads\\clock.png");
    final ImageIcon save3 = new ImageIcon(save2.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
    final JLabel lblsaveres = new JLabel(save3);
    lblsaveres.setBounds(782, 44, 53, 50);
    lblsaveres.setForeground(new Color(255, 255, 204));
    lblsaveres.setFont(new Font("Dialog", Font.BOLD, 25));
    MenuPanel.add(lblsaveres);

    JPanel panelBG = new JPanel();
    panelBG.setBackground(new Color(59, 89, 182));
    panelBG.setBounds(0, 623, 1006, 34);
    MenuPanel.add(panelBG);

    JPanel panelBG2 = new JPanel();
    panelBG2.setBounds(0, 179, 1016, 7);
    MenuPanel.add(panelBG2);
    panelBG2.setBackground(new Color(59, 89, 182));
    panelBG2.setLayout(null);

    JPanel panelBG3 = new JPanel();
    panelBG3.setBackground(new Color(51, 153, 204));
    panelBG3.setBounds(0, 161, 1006, 7);
    MenuPanel.add(panelBG3);
    panelBG3.setLayout(null);

    JPanel PanelBG4 = new JPanel();
    PanelBG4.setLayout(null);
    PanelBG4.setBackground(new Color(102, 153, 153));
    PanelBG4.setBounds(0, 143, 1006, 7);
    MenuPanel.add(PanelBG4);

    final ImageIcon savev = new ImageIcon("C:\\Users\\admin\\Downloads\\warning.png");
    final ImageIcon savev1 = new ImageIcon(savev.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
    final JLabel lblsaverer = new JLabel(savev1);
    lblsaverer.addMouseListener(new MouseAdapter() {@Override
      public void mouseClicked(MouseEvent e) {
        Font customFont = new Font("Arial", Font.BOLD, 14);

        JLabel messageLabel = new JLabel("NOTICE: Input accurate and right information details!");
        messageLabel.setFont(customFont);
        messageLabel.setForeground(Color.BLACK);

        JOptionPane.showMessageDialog(null, messageLabel);
      }
    });
    lblsaverer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    lblsaverer.setBounds(823, 298, 124, 100);
    lblsaverer.setForeground(new Color(255, 255, 204));
    lblsaverer.setFont(new Font("Dialog", Font.BOLD, 25));
    MenuPanel.add(lblsaverer);

    lblclick = new JLabel("CLICK");
    lblclick.setForeground(new Color(0, 0, 0));
    lblclick.addMouseListener(new MouseAdapter() {@Override
      public void mouseEntered(MouseEvent e) {
        lblclick.setForeground(new Color(59, 89, 182));
      }@Override
      public void mouseExited(MouseEvent e) {
        lblclick.setForeground(new Color(0, 0, 0));
      }
    });
    lblclick.setFont(new Font("Verdana", Font.BOLD, 25));
    lblclick.setBounds(839, 252, 92, 34);
    MenuPanel.add(lblclick);

    lblme = new JLabel("ME");
    lblme.addMouseListener(new MouseAdapter() {@Override
      public void mouseEntered(MouseEvent e) {
        lblme.setForeground(new Color(59, 89, 182));
      }

      @Override
      public void mouseExited(MouseEvent e) {
        lblme.setForeground(new Color(0, 0, 0));

      }
    });
    lblme.setFont(new Font("Verdana", Font.BOLD, 25));
    lblme.setBounds(860, 409, 46, 30);
    MenuPanel.add(lblme);

    final ImageIcon savev2 = new ImageIcon("C:\\Users\\admin\\Downloads\\registration.png");
    final ImageIcon savev3 = new ImageIcon(savev2.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
    final JLabel lblsaverer1 = new JLabel(savev3);
    lblsaverer1.addMouseListener(new MouseAdapter() {@Override
      public void mouseClicked(MouseEvent e) {
        Font customFont = new Font("Arial", Font.BOLD, 14);

        JLabel messageLabel = new JLabel("Sign in your personal details to complete your enrollment");
        messageLabel.setFont(customFont);
        messageLabel.setForeground(Color.BLACK);

        JOptionPane.showMessageDialog(null, messageLabel);
      }
    });
    lblsaverer1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    lblsaverer1.setBounds(625, 21, 124, 100);
    lblsaverer1.setForeground(new Color(255, 255, 204));
    lblsaverer1.setFont(new Font("Dialog", Font.BOLD, 25));
    MenuPanel.add(lblsaverer1);

    JPanel panelBG2_1 = new JPanel();
    panelBG2_1.setLayout(null);
    panelBG2_1.setBackground(new Color(59, 89, 182));
    panelBG2_1.setBounds(0, 569, 1016, 7);
    MenuPanel.add(panelBG2_1);

    JPanel panelBG3_1 = new JPanel();
    panelBG3_1.setLayout(null);
    panelBG3_1.setBackground(new Color(51, 153, 204));
    panelBG3_1.setBounds(0, 587, 1006, 7);
    MenuPanel.add(panelBG3_1);

    JPanel PanelBG4_1 = new JPanel();
    PanelBG4_1.setLayout(null);
    PanelBG4_1.setBackground(new Color(102, 153, 153));
    PanelBG4_1.setBounds(0, 605, 1006, 7);
    MenuPanel.add(PanelBG4_1);

    btnSave.addActionListener(new ActionListener() {@Override
      public void actionPerformed(ActionEvent e) {
        if (isEmptyField(txtName) || isEmptyField(txtAge) || isEmptyField(txtGuardian) || isEmptyField(txtNumber) || isEmptyField(txtEmail)) {
          JOptionPane.showMessageDialog(MenuPanel, "Please fill in all fields", "Validation Error", JOptionPane.ERROR_MESSAGE);
        } else {
          saveDataToFile();
        }

      }
    });

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

  private void saveDataToFile() {
    String number = txtNumber.getText();
    String age = txtAge.getText();
    String selectedGender = (String) comboBoxGender.getSelectedItem();
    String selectedloc = (String) comboBoxLoc.getSelectedItem();
    String selectedSection = (String) comboBoxSection.getSelectedItem();
    String name = txtName.getText();
    String selecteddept = (String) comboBoxDept.getSelectedItem();
    String guardian = txtGuardian.getText();
    String email = txtEmail.getText();
    String selectedyear = (String) comboBoxYear.getSelectedItem();

    String rowData = name + "," + age + "," + selectedGender + "," + selectedloc + "," + selectedSection + "," + email + "," + selectedyear + "," + number + "," + selecteddept + "," + guardian + "\n";

    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter("students.txt", true));
      writer.write(rowData);
      writer.close();
      JOptionPane.showMessageDialog(null, "Data saved successfully.");
    } catch(IOException e) {
      JOptionPane.showMessageDialog(null, "Error saving data: " + e.getMessage());
    }
  }

  private boolean isEmptyField(JTextField textField) {
    return textField.getText().trim().isEmpty();
  }
}