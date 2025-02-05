package finalsproject;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
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
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import javax.swing.JTextPane;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;

public class ReportGeneration extends JFrame {

  private JPanel contentPane;
  private static final long serialVersionUID = 1L;
  private JLabel lblDate;
  private JLabel timeLabel;
  private JButton AccountManagement;
  private JButton RegisteredStudentList;
  DefaultTableModel model;
  private JButton clearButton;
  private JLabel lblAccountManagement;
  private JButton ReportGeneration;
  private JButton OverallGrade;
  private JButton AnnouncementManagement;
  private JTextArea textArea;
  private JButton appendButton;
  private JLabel lblConsole;
  private JButton btnTransactionReport;
  private JButton btnPrintEnrolledStudents;

  /**
	 * Launch the application.
	 */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          ReportGeneration frame = new ReportGeneration();
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
  public ReportGeneration() {
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

    final ImageIcon closeIcon3 = new ImageIcon("C:\\Users\\admin\\Downloads\\report.png");
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

    ReportGeneration = new JButton("Report Generation");
    ReportGeneration.setEnabled(false);
    ReportGeneration.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {

}
    });
    ReportGeneration.addMouseListener(new MouseAdapter() {@Override
      public void mouseEntered(MouseEvent e) {
        ReportGeneration.setBackground(new Color(129, 159, 232));

      }@Override
      public void mouseExited(MouseEvent e) {
        ReportGeneration.setBackground(new Color(89, 119, 222));
      }
    });
    ReportGeneration.setFont(new Font("Dialog", Font.BOLD, 18));
    ReportGeneration.setBackground(new Color(89, 119, 222));
    ReportGeneration.setBounds(0, 114, 194, 46);
    PSideMenu.add(ReportGeneration);

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
          ReportGeneration.this.dispose();
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

    lblAccountManagement = new JLabel("Report Generation");
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
    
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(204, 266, 708, 423);
    contentPane.add(scrollPane);
    
    textArea = new JTextArea();
    textArea.setLineWrap(true);
    textArea.setEditable(false);
    scrollPane.setViewportView(textArea);
    textArea.setBackground(new Color(153, 204, 204));
    
    appendButton = new JButton("Generate Report");
    appendButton.addMouseListener(new MouseAdapter() {@Override
        public void mouseEntered(MouseEvent e) {
    	    appendButton.setBackground(new Color(129, 159, 232));
        }@Override
        public void mouseExited(MouseEvent e) {
        	appendButton.setBackground(new Color(59, 89, 182));
        }
      });
    appendButton.setFont(new Font("Arial", Font.BOLD, 15));
    appendButton.setBackground(new Color(59, 89, 182));
    appendButton.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		 try {
    	            String filePath = "students.txt";
    	            FileReader fileReader = new FileReader(filePath);
    	            BufferedReader bufferedReader = new BufferedReader(fileReader);
    	            StringBuilder data = new StringBuilder();
    	            String line;
    	            int numberOfLines = 0;
    	            List<String> enrolledStudents = new ArrayList<>();
    	            boolean dateRowPresent = false; 
    	            
    	            while ((line = bufferedReader.readLine()) != null) {
    	                data.append(line).append("\n");
    	                numberOfLines++;
    	                enrolledStudents.add(line);
    	                if (line.contains("Date:")) {
    	                    dateRowPresent = true;
    	                }
    	            }

    	            bufferedReader.close();
    	            String newData = data.toString();
    	            textArea.setText(newData); 

    	            StringBuilder message = new StringBuilder("Number of Students Enrolled: ").append(numberOfLines);

    	            if (!enrolledStudents.isEmpty()) {
    	                message.append("\n\nNames of Students Enrolled:\n");
    	                for (String student : enrolledStudents) {
    	                    String[] parts = student.split(",");
    	                    if (parts.length > 0) {
    	                        message.append(parts[0]).append("\n");
    	                    }
    	                }
    	            }

    	           
    	            if (dateRowPresent) {
    	                JOptionPane.showMessageDialog(null, "All data are shown on the Console.");
    	            } else {
    	                JTextArea messageArea = new JTextArea(message.toString());
    	                JScrollPane scrollPane = new JScrollPane(messageArea);
    	                scrollPane.setPreferredSize(new Dimension(400, 300));
    	                JOptionPane.showMessageDialog(null, scrollPane);
    	            }
    	        } catch (IOException ex) {
    	            ex.printStackTrace();
    	            JOptionPane.showMessageDialog(null, "Error reading the file.");
    	        }
    	    } 
    	});
    	
    appendButton.setBounds(935, 339, 255, 37);
    contentPane.add(appendButton);
    
    clearButton = new JButton("Clear Report");
    clearButton.addMouseListener(new MouseAdapter() {@Override
        public void mouseEntered(MouseEvent e) {
    	    clearButton.setBackground(new Color(129, 159, 232));
        }@Override
        public void mouseExited(MouseEvent e) {
        	clearButton.setBackground(new Color(59, 89, 182));
        }
      });
    clearButton.setFont(new Font("Arial", Font.BOLD, 15));
    clearButton.setBackground(new Color(59, 89, 182));
    clearButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            textArea.setText("");
        }
    });
    clearButton.setBounds(935, 387, 255, 37);
    contentPane.add(clearButton);
    
    lblConsole = new JLabel("C O N S O L E");
    lblConsole.addMouseListener(new MouseAdapter() {@Override
        public void mouseEntered(MouseEvent e) {
    	lblConsole.setForeground(new Color(0, 255, 0));
        }@Override
        public void mouseExited(MouseEvent e) {
        	lblConsole.setForeground(new Color(0, 0, 0));
        }
      });
    lblConsole.setFont(new Font("Verdana", Font.BOLD, 35));
    lblConsole.setHorizontalAlignment(SwingConstants.CENTER);
    lblConsole.setBounds(922, 266, 268, 62);
    contentPane.add(lblConsole);
    
    btnTransactionReport = new JButton("Print Transaction Report");
    btnTransactionReport.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		String filePath = "Transaction.txt"; 

            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                StringBuilder textContent = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    textContent.append(line).append("\n");
                }

                JTextPane textPane = new JTextPane();
                textPane.setContentType("text/plain");
                textPane.setText(textContent.toString());
                textPane.setSize(textPane.getPreferredSize());

                
                BufferedImage image = new BufferedImage(
                        textPane.getWidth(), textPane.getHeight(), BufferedImage.TYPE_INT_RGB);
                Graphics2D graphics = image.createGraphics();
                textPane.print(graphics);
                graphics.dispose();

                
                String imagePath = "Transaction.png"; 
                ImageIO.write(image, "png", new File(imagePath));

                JOptionPane.showMessageDialog(null, "Image Saved Successfully!");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    });
    btnTransactionReport.setFont(new Font("Arial", Font.BOLD, 15));
    btnTransactionReport.setBackground(new Color(59, 89, 182));
    btnTransactionReport.setBounds(935, 435, 255, 37);
    contentPane.add(btnTransactionReport);
    
    btnPrintEnrolledStudents = new JButton("Print Enrolled Students");
    btnPrintEnrolledStudents.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		String filePath = "students.txt"; 

            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                StringBuilder textContent = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    textContent.append(line).append("\n");
                }

                JTextPane textPane = new JTextPane();
                textPane.setContentType("text/plain");
                textPane.setText(textContent.toString());
                textPane.setSize(textPane.getPreferredSize());

                
                BufferedImage image = new BufferedImage(
                        textPane.getWidth(), textPane.getHeight(), BufferedImage.TYPE_INT_RGB);
                Graphics2D graphics = image.createGraphics();
                textPane.print(graphics);
                graphics.dispose();

                
                String imagePath = "EnrolledStudents.png"; 
                ImageIO.write(image, "png", new File(imagePath));

                JOptionPane.showMessageDialog(null, "Image Saved Successfully!");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    });
    btnPrintEnrolledStudents.setFont(new Font("Arial", Font.BOLD, 15));
    btnPrintEnrolledStudents.setBackground(new Color(59, 89, 182));
    btnPrintEnrolledStudents.setBounds(935, 483, 255, 37);
    contentPane.add(btnPrintEnrolledStudents);

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