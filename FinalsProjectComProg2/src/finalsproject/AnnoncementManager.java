package finalsproject;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import java.io.BufferedWriter;

public class AnnoncementManager extends JFrame {

  private JPanel contentPane;
  private static final long serialVersionUID = 1L;
  private JLabel lblDate;
  private JLabel timeLabel;
  private JButton AccountManagement;
  private JButton RegisteredStudentList;
  DefaultTableModel model;
  private JLabel lblAccountManagement;
  private JButton ReportGeneration1;
  private JButton OverallGrade;
  private JButton AnnouncementManagement;
  private JTextArea PostArea1;
  private JTextArea PostArea2;
  private JButton createButton;
  private JButton postButton;
  private JButton editButton;
  private JButton btnDelete;
  private JButton createButton2;
  private JButton postButton2;
  private JButton editButton2;
  private JButton btnDelete2;

  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          AnnoncementManager frame = new AnnoncementManager();
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
  public AnnoncementManager() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 1200, 700);
    setUndecorated(true);
    setLocationRelativeTo(null);
    contentPane = new JPanel();
    contentPane.setBackground(new Color(255, 255, 255));
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);

    JPanel panel = new JPanel();
    panel.setBackground(new Color(59, 89, 182));
    panel.setBounds(194, 0, 1006, 44);
    contentPane.add(panel);
    panel.setLayout(null);

    JPanel panelBG2 = new JPanel();
    panelBG2.setBounds(194, 248, 1016, 7);
    panelBG2.setBackground(new Color(59, 89, 182));
    contentPane.add(panelBG2);

    JPanel panelBG3 = new JPanel();
    panelBG3.setBackground(new Color(51, 153, 204));
    panelBG3.setBounds(194, 237, 1006, 7);
    contentPane.add(panelBG3);

    JPanel PanelBG4 = new JPanel();
    PanelBG4.setLayout(null);
    PanelBG4.setBackground(new Color(102, 153, 153));
    PanelBG4.setBounds(194, 224, 1006, 7);
    contentPane.add(PanelBG4);

    JPanel panelBG8 = new JPanel();
    panelBG8.setBackground(new Color(59, 89, 182));
    panelBG8.setBounds(194, 55, 1016, 7);
    contentPane.add(panelBG8);

    JPanel panelBG9 = new JPanel();
    panelBG9.setBackground(new Color(51, 153, 204));
    panelBG9.setBounds(194, 65, 1006, 7);
    contentPane.add(panelBG9);

    JPanel PanelBG10 = new JPanel();
    PanelBG10.setLayout(null);
    PanelBG10.setBackground(new Color(102, 153, 153));
    PanelBG10.setBounds(194, 76, 1006, 7);
    contentPane.add(PanelBG10);

    final ImageIcon closeIcon3 = new ImageIcon("C:\\Users\\admin\\Downloads\\megaphone.png");
    final ImageIcon resizedIcon3 = new ImageIcon(closeIcon3.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
    final JLabel lblProfile = new JLabel(resizedIcon3);
    lblProfile.setBounds(194, 79, 165, 158);
    contentPane.add(lblProfile);
    lblProfile.setHorizontalAlignment(SwingConstants.CENTER);

    final ImageIcon save2 = new ImageIcon("C:\\Users\\admin\\Downloads\\clock.png");
    final ImageIcon save3 = new ImageIcon(save2.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
    final JLabel lblclock = new JLabel(save3);
    lblclock.setBounds(969, 94, 53, 50);
    lblclock.setForeground(new Color(255, 255, 204));
    lblclock.setFont(new Font("Dialog", Font.BOLD, 25));
    contentPane.add(lblclock);

    timeLabel = new JLabel(); // Create a new JLabel instance
    timeLabel.setHorizontalTextPosition(SwingConstants.LEFT);
    timeLabel.setFont(new Font("Arial", Font.BOLD, 30));
    timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
    timeLabel.setBounds(1007, 94, 183, 50);
    contentPane.add(timeLabel);

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

    RegisteredStudentList = new JButton("Student Applicants");
    RegisteredStudentList.addMouseListener(new MouseAdapter() {@Override
      public void mouseEntered(MouseEvent e) {
        RegisteredStudentList.setBackground(new Color(129, 159, 232));
      }@Override
      public void mouseExited(MouseEvent e) {
        RegisteredStudentList.setBackground(new Color(89, 119, 222));
      }
    });

    RegisteredStudentList.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dispose();
        AdminControl.main(null);
      }
    });
    RegisteredStudentList.setFont(new Font("Dialog", Font.BOLD, 18));
    RegisteredStudentList.setBackground(new Color(89, 119, 222));
    RegisteredStudentList.setForeground(new Color(0, 0, 0));
    RegisteredStudentList.setBounds(0, 0, 194, 46);
    PSideMenu.add(RegisteredStudentList);

    AccountManagement = new JButton("Accounts Panel");
    AccountManagement.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dispose();
        AccountPanel.main(null);
      }
    });
    AccountManagement.addMouseListener(new MouseAdapter() {@Override
      public void mouseEntered(MouseEvent e) {
        AccountManagement.setBackground(new Color(129, 159, 232));
      }@Override
      public void mouseExited(MouseEvent e) {
        AccountManagement.setBackground(new Color(89, 119, 222));
      }
    });
    AccountManagement.setFont(new Font("Dialog", Font.BOLD, 18));
    AccountManagement.setBackground(new Color(89, 119, 222));
    AccountManagement.setBounds(0, 57, 194, 46);
    PSideMenu.add(AccountManagement);

    ReportGeneration1 = new JButton("Report Generation");
    ReportGeneration1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dispose();
        ReportGeneration.main(null);
      }
    });
    ReportGeneration1.addMouseListener(new MouseAdapter() {@Override
      public void mouseEntered(MouseEvent e) {
        ReportGeneration1.setBackground(new Color(129, 159, 232));

      }@Override
      public void mouseExited(MouseEvent e) {
        ReportGeneration1.setBackground(new Color(89, 119, 222));
      }
    });
    ReportGeneration1.setFont(new Font("Dialog", Font.BOLD, 18));
    ReportGeneration1.setBackground(new Color(89, 119, 222));
    ReportGeneration1.setBounds(0, 114, 194, 46);
    PSideMenu.add(ReportGeneration1);

    OverallGrade = new JButton("Grade Calculator");
    OverallGrade.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dispose();
        GradeCalculator.main(null);
      }
    });
    OverallGrade.addMouseListener(new MouseAdapter() {@Override
      public void mouseEntered(MouseEvent e) {
        OverallGrade.setBackground(new Color(129, 159, 232));
      }@Override
      public void mouseExited(MouseEvent e) {
        OverallGrade.setBackground(new Color(89, 119, 222));
      }
    });
    OverallGrade.setFont(new Font("Dialog", Font.BOLD, 18));
    OverallGrade.setBackground(new Color(89, 119, 222));
    OverallGrade.setBounds(0, 171, 194, 46);
    PSideMenu.add(OverallGrade);

    AnnouncementManagement = new JButton("Announce Panel");
    AnnouncementManagement.setEnabled(false);
    AnnouncementManagement.addMouseListener(new MouseAdapter() {@Override
      public void mouseEntered(MouseEvent e) {
        AnnouncementManagement.setBackground(new Color(129, 159, 232));
      }@Override
      public void mouseExited(MouseEvent e) {
        AnnouncementManagement.setBackground(new Color(89, 119, 222));
      }
    });
    AnnouncementManagement.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dispose();
        AnnoncementManager.main(null);
      }
    });
    AnnouncementManagement.setFont(new Font("Dialog", Font.BOLD, 18));
    AnnouncementManagement.setBackground(new Color(89, 119, 222));
    AnnouncementManagement.setBounds(0, 228, 194, 46);
    PSideMenu.add(AnnouncementManagement);

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
          AnnoncementManager.this.dispose();
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

    lblAccountManagement = new JLabel("Announcement Panel");
    lblAccountManagement.addMouseListener(new MouseAdapter() {@Override
      public void mouseEntered(MouseEvent e) {
        lblAccountManagement.setForeground(new Color(59, 89, 182));
      }@Override
      public void mouseExited(MouseEvent e) {
        lblAccountManagement.setForeground(new Color(0, 0, 0));
      }
    });
    lblAccountManagement.setFont(new Font("Verdana", Font.BOLD, 45));
    lblAccountManagement.setBounds(369, 123, 590, 59);
    contentPane.add(lblAccountManagement);

    PostArea1 = new JTextArea();
    PostArea1.setLineWrap(true);
    PostArea1.setEditable(false);
    PostArea1.setBackground(new Color(204, 204, 204));
    PostArea1.setBounds(204, 266, 453, 283);
    contentPane.add(PostArea1);

    createButton = new JButton("Create");
    createButton.setFont(new Font("Dialog", Font.BOLD, 18));
    createButton.setBounds(204, 560, 100, 30);
    contentPane.add(createButton);
    createButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {

        String announcement = JOptionPane.showInputDialog(contentPane, "Enter announcement:");

        if (announcement != null && !announcement.isEmpty()) {

          PostArea1.append(announcement + "\n");
        }
      }
    });

    editButton = new JButton("Edit");
    editButton.setFont(new Font("Dialog", Font.BOLD, 18));
    editButton.setBounds(447, 560, 100, 30);
    contentPane.add(editButton);
    editButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        editPost();
      }
    });

    postButton = new JButton("Post");
    postButton.setFont(new Font("Dialog", Font.BOLD, 18));
    postButton.setBounds(314, 560, 100, 30);
    contentPane.add(postButton);

    postButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();

        int choice = fileChooser.showSaveDialog(contentPane);

        if (choice == JFileChooser.APPROVE_OPTION) {

          File file = fileChooser.getSelectedFile();

          try {

            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(PostArea1.getText());

            bufferedWriter.close();
            fileWriter.close();

            JOptionPane.showMessageDialog(contentPane, "Successfully posted!");
          } catch(IOException ex) {

            JOptionPane.showMessageDialog(contentPane, "Error saving text.", "Error", JOptionPane.ERROR_MESSAGE);
          }
        }
      }
    });

    btnDelete = new JButton("Delete");
    btnDelete.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        PostArea1.setText("");
      }
    });
    btnDelete.setFont(new Font("Dialog", Font.BOLD, 18));
    btnDelete.setBounds(557, 560, 100, 30);
    contentPane.add(btnDelete);

    PostArea2 = new JTextArea();
    PostArea2.setLineWrap(true);
    PostArea2.setEditable(false);
    PostArea2.setBackground(new Color(204, 204, 204));
    PostArea2.setBounds(737, 266, 453, 283);
    contentPane.add(PostArea2);

    createButton2 = new JButton("Create");
    createButton2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {

        String announcement = JOptionPane.showInputDialog(contentPane, "Enter announcement:");

        if (announcement != null && !announcement.isEmpty()) {

          PostArea2.append(announcement + "\n");
        }
      }
    });
    createButton2.setFont(new Font("Dialog", Font.BOLD, 18));
    createButton2.setBounds(737, 560, 100, 30);
    contentPane.add(createButton2);

    postButton2 = new JButton("Post");
    postButton2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();

        int choice = fileChooser.showSaveDialog(contentPane);

        if (choice == JFileChooser.APPROVE_OPTION) {

          File file = fileChooser.getSelectedFile();

          try {

            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(PostArea2.getText());

            bufferedWriter.close();
            fileWriter.close();

            JOptionPane.showMessageDialog(contentPane, "Successfully posted!");
          } catch(IOException ex) {

            JOptionPane.showMessageDialog(contentPane, "Error saving text.", "Error", JOptionPane.ERROR_MESSAGE);
          }
        }
      }
    });
    postButton2.setFont(new Font("Dialog", Font.BOLD, 18));
    postButton2.setBounds(847, 560, 100, 30);
    contentPane.add(postButton2);

    editButton2 = new JButton("Edit");
    editButton2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        editPost2();
      }
    });
    editButton2.setFont(new Font("Dialog", Font.BOLD, 18));
    editButton2.setBounds(980, 560, 100, 30);
    contentPane.add(editButton2);

    btnDelete2 = new JButton("Delete");
    btnDelete2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        PostArea2.setText("");
      }
    });
    btnDelete2.setFont(new Font("Dialog", Font.BOLD, 18));
    btnDelete2.setBounds(1090, 560, 100, 30);
    contentPane.add(btnDelete2);

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

  private void editPost() {
    String editedText = JOptionPane.showInputDialog(contentPane, "Edit announcement:", PostArea1.getText());
    if (editedText != null && !editedText.isEmpty()) {
      PostArea1.setText(editedText);
      updateTextFile(editedText);
    }
  }

  private void updateTextFile(String text) {
    try {
      FileWriter fileWriter = new FileWriter("Post1");
      fileWriter.write(text);
      fileWriter.close();
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
  private void editPost2() {
    String editedText = JOptionPane.showInputDialog(contentPane, "Edit announcement:", PostArea2.getText());
    if (editedText != null && !editedText.isEmpty()) {
      PostArea2.setText(editedText);
      updateTextFile2(editedText);
    }
  }

  private void updateTextFile2(String text) {
    try {
      FileWriter fileWriter = new FileWriter("Post2");
      fileWriter.write(text);
      fileWriter.close();
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}