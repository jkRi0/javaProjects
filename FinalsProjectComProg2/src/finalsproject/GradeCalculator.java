package finalsproject;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedWriter;
import javax.swing.JFileChooser;

public class GradeCalculator extends JFrame {

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
  private JTextField PrelimG;
  private JTextField MidtermG;
  private JTextField FinalsG;
  private JTextField OverallGWA;
  private JLabel lblFinalsAvg;
  private JLabel lblMidtermAvg;
  private JLabel lblPrelimAvg;
  private JLabel OverallAverage;
  private JTable table;
  private JButton AddGrades;
  private JButton addButton;
  private JButton SaveButton;
  private JButton readButton;
  private JButton clearButton;
  private JButton editButton;
  private JButton deleteButton;

  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          GradeCalculator frame = new GradeCalculator();
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
  public GradeCalculator() {
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

    JPanel panelBG5 = new JPanel();
    panelBG5.setBackground(new Color(59, 89, 182));
    panelBG5.setBounds(194, 495, 1016, 7);
    contentPane.add(panelBG5);

    JPanel panelBG6 = new JPanel();
    panelBG6.setBackground(new Color(51, 153, 204));
    panelBG6.setBounds(194, 506, 1006, 7);
    contentPane.add(panelBG6);

    JPanel PanelBG7 = new JPanel();
    PanelBG7.setLayout(null);
    PanelBG7.setBackground(new Color(102, 153, 153));
    PanelBG7.setBounds(194, 516, 1006, 7);
    contentPane.add(PanelBG7);

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

    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(510, 266, 677, 170);
    contentPane.add(scrollPane);

    table = new JTable();
    scrollPane.setViewportView(table);
    table.setBackground(new Color(255, 255, 255));
    model = new DefaultTableModel();
    final Object[] column = {
      "Name",
      "Section",
      "Prelim Average",
      "Midterm Average",
      "Finals Average",
      "Overall Average"
    };
    Object[] row = new Object[0];
    model.setColumnIdentifiers(column);
    table.setShowGrid(true);
    table.setFont(new Font("Arial", Font.PLAIN, 12));
    table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
    table.getTableHeader().setBackground(new Color(240, 240, 240));
    table.getTableHeader().setForeground(Color.BLACK);
    table.setRowHeight(20);
    table.setGridColor(Color.LIGHT_GRAY);
    table.setShowVerticalLines(false);
    table.setShowHorizontalLines(true);
    table.setModel(model);

    PrelimG = new JTextField();
    PrelimG.setEditable(false);
    PrelimG.setHorizontalAlignment(SwingConstants.CENTER);
    PrelimG.setBounds(414, 266, 86, 29);
    PrelimG.setFont(new Font("Arial", Font.PLAIN, 14));
    PrelimG.setBackground(Color.WHITE);
    PrelimG.setForeground(Color.BLACK);
    PrelimG.setBorder(new LineBorder(new Color(0, 0, 0)));
    contentPane.add(PrelimG);
    PrelimG.setColumns(10);

    MidtermG = new JTextField();
    MidtermG.setEditable(false);
    MidtermG.setHorizontalAlignment(SwingConstants.CENTER);
    MidtermG.setBounds(414, 310, 86, 29);
    MidtermG.setFont(new Font("Arial", Font.PLAIN, 14));
    MidtermG.setBackground(Color.WHITE);
    MidtermG.setForeground(Color.BLACK);
    MidtermG.setBorder(new LineBorder(new Color(0, 0, 0)));
    contentPane.add(MidtermG);
    MidtermG.setColumns(10);

    FinalsG = new JTextField();
    FinalsG.setEditable(false);
    FinalsG.setHorizontalAlignment(SwingConstants.CENTER);
    FinalsG.setBounds(414, 350, 86, 29);
    FinalsG.setFont(new Font("Arial", Font.PLAIN, 14));
    FinalsG.setBackground(Color.WHITE);
    FinalsG.setForeground(Color.BLACK);
    FinalsG.setBorder(new LineBorder(new Color(0, 0, 0)));
    contentPane.add(FinalsG);
    FinalsG.setColumns(10);

    OverallGWA = new JTextField();
    OverallGWA.setEditable(false);
    OverallGWA.setHorizontalAlignment(SwingConstants.CENTER);
    OverallGWA.setBounds(414, 390, 86, 29);
    OverallGWA.setFont(new Font("Arial", Font.PLAIN, 14));
    OverallGWA.setBackground(Color.WHITE);
    OverallGWA.setForeground(Color.BLACK);
    OverallGWA.setBorder(new LineBorder(new Color(0, 0, 0)));
    contentPane.add(OverallGWA);
    OverallGWA.setColumns(10);

    lblPrelimAvg = new JLabel("Prelims Average");
    lblPrelimAvg.setFont(new Font("Verdana", Font.BOLD, 20));
    lblPrelimAvg.setBounds(204, 266, 200, 29);
    contentPane.add(lblPrelimAvg);

    lblMidtermAvg = new JLabel("Midterm Average");
    lblMidtermAvg.setFont(new Font("Verdana", Font.BOLD, 20));
    lblMidtermAvg.setBounds(202, 306, 202, 29);
    contentPane.add(lblMidtermAvg);

    lblFinalsAvg = new JLabel("Finals Average\r\n");
    lblFinalsAvg.setFont(new Font("Verdana", Font.BOLD, 20));
    lblFinalsAvg.setBounds(204, 346, 200, 32);
    contentPane.add(lblFinalsAvg);

    OverallAverage = new JLabel("Overall Average");
    OverallAverage.setFont(new Font("Verdana", Font.BOLD, 20));
    OverallAverage.setBounds(204, 389, 200, 32);
    contentPane.add(OverallAverage);

    AddGrades = new JButton("Compute");
    AddGrades.setBackground(new Color(89, 119, 222));
    AddGrades.addMouseListener(new MouseAdapter() {@Override
      public void mouseEntered(MouseEvent e) {
        AddGrades.setBackground(new Color(129, 159, 232));
      }@Override
      public void mouseExited(MouseEvent e) {
        AddGrades.setBackground(new Color(59, 89, 182));
      }
    });
    AddGrades.setBackground(new Color(89, 119, 222));
    AddGrades.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel prelimLabel = new JLabel("Prelim Grade:");
        JTextField prelimField = new JTextField();
        JLabel midtermLabel = new JLabel("Midterm Grade:");
        JTextField midtermField = new JTextField();
        JLabel finalsLabel = new JLabel("Finals Grade:");
        JTextField finalsField = new JTextField();

        panel.add(prelimLabel);
        panel.add(prelimField);
        panel.add(midtermLabel);
        panel.add(midtermField);
        panel.add(finalsLabel);
        panel.add(finalsField);

        int option = JOptionPane.showOptionDialog(
        null, panel, "Enter Grades", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

        if (option == JOptionPane.OK_OPTION) {
          String prelimGrade = prelimField.getText();
          String midtermGrade = midtermField.getText();
          String finalsGrade = finalsField.getText();

          if (isValidGrade(prelimGrade) && isValidGrade(midtermGrade) && isValidGrade(finalsGrade)) {
            PrelimG.setText(prelimGrade);
            MidtermG.setText(midtermGrade);
            FinalsG.setText(finalsGrade);

            double prelim = Double.parseDouble(prelimGrade);
            double midterm = Double.parseDouble(midtermGrade);
            double finals = Double.parseDouble(finalsGrade);
            float overallAverage = (float)((prelim + midterm + finals) / 3);

            OverallGWA.setText(String.valueOf(overallAverage));
          } else {
            JOptionPane.showMessageDialog(null, "Invalid grade! Please enter a numerical value.");
          }
        }
      }
    });

    AddGrades.setBounds(204, 447, 143, 32);
    contentPane.add(AddGrades);

    addButton = new JButton("Add");
    addButton.setBackground(new Color(59, 89, 182));
    addButton.addMouseListener(new MouseAdapter() {@Override
      public void mouseEntered(MouseEvent e) {
        addButton.setBackground(new Color(129, 159, 232));
      }@Override
      public void mouseExited(MouseEvent e) {
        addButton.setBackground(new Color(59, 89, 182));
      }
    });
    addButton.setBounds(509, 447, 100, 30);
    contentPane.add(addButton);
    addButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        JTextField nameField = new JTextField();
        JComboBox < String > sectionField = new JComboBox < >(new String[] {
          "Section A",
          "Section B",
          "Section C"
        });
        JTextField prelimAverageField = new JTextField();
        JTextField midtermAverageField = new JTextField();
        JTextField finalsAverageField = new JTextField();

        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Section:"));
        panel.add(sectionField);
        panel.add(new JLabel("Prelim Average:"));
        panel.add(prelimAverageField);
        panel.add(new JLabel("Midterm Average:"));
        panel.add(midtermAverageField);
        panel.add(new JLabel("Finals Average:"));
        panel.add(finalsAverageField);

        int result = JOptionPane.showConfirmDialog(contentPane, panel, "Enter Student Information", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
          String name = nameField.getText();
          String section = (String) sectionField.getSelectedItem();
          double prelimAverage = Double.parseDouble(prelimAverageField.getText());
          double midtermAverage = Double.parseDouble(midtermAverageField.getText());
          double finalsAverage = Double.parseDouble(finalsAverageField.getText());
          double overallAverage = (prelimAverage + midtermAverage + finalsAverage) / 3;

          Object[] rowData = {
            name,
            section,
            prelimAverage,
            midtermAverage,
            finalsAverage,
            overallAverage
          };
          model.addRow(rowData);
        }

      }

    });

    SaveButton = new JButton("Save");
    SaveButton.setBackground(new Color(59, 89, 182));
    SaveButton.addMouseListener(new MouseAdapter() {@Override
      public void mouseEntered(MouseEvent e) {
        SaveButton.setBackground(new Color(129, 159, 232));
      }@Override
      public void mouseExited(MouseEvent e) {
        SaveButton.setBackground(new Color(59, 89, 182));
      }
    });
    SaveButton.setBounds(619, 447, 100, 30);
    contentPane.add(SaveButton);
    SaveButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();

        
        fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt"));

        int option = fileChooser.showSaveDialog(contentPane);

        if (option == JFileChooser.APPROVE_OPTION) {
          File file = fileChooser.getSelectedFile();

          
          saveTableDataToFile(file);
        }
      }
    });

    readButton = new JButton("Read");
    readButton.setBackground(new Color(59, 89, 182));
    readButton.addMouseListener(new MouseAdapter() {@Override
      public void mouseEntered(MouseEvent e) {
        readButton.setBackground(new Color(129, 159, 232));
      }@Override
      public void mouseExited(MouseEvent e) {
        readButton.setBackground(new Color(59, 89, 182));
      }
    });
    readButton.setBounds(729, 447, 100, 30);
    contentPane.add(readButton);
    readButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();


        fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt"));

        int option = fileChooser.showOpenDialog(contentPane);

        if (option == JFileChooser.APPROVE_OPTION) {
          File file = fileChooser.getSelectedFile();

          readTableDataFromFile(file);
        }
      }
    });

    clearButton = new JButton("Clear");
    clearButton.setBackground(new Color(59, 89, 182));
    clearButton.addMouseListener(new MouseAdapter() {@Override
      public void mouseEntered(MouseEvent e) {
        clearButton.setBackground(new Color(129, 159, 232));
      }@Override
      public void mouseExited(MouseEvent e) {
        clearButton.setBackground(new Color(59, 89, 182));
      }
    });
    clearButton.setBounds(867, 447, 100, 30);
    contentPane.add(clearButton);
    clearButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        clearTable();
      }
    });

    editButton = new JButton("Edit");
    editButton.setBackground(new Color(59, 89, 182));
    editButton.addMouseListener(new MouseAdapter() {@Override
      public void mouseEntered(MouseEvent e) {
        editButton.setBackground(new Color(129, 159, 232));
      }@Override
      public void mouseExited(MouseEvent e) {
        editButton.setBackground(new Color(59, 89, 182));
      }
    });
    editButton.setBounds(977, 447, 100, 30);
    contentPane.add(editButton);
    editButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {

        int selectedRow = table.getSelectedRow();

        if (selectedRow != -1) {
          JFileChooser fileChooser = new JFileChooser();
          fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt"));

          int option = fileChooser.showOpenDialog(contentPane);

          if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            editDataFromFile(selectedRow, file);
          }
        } else {
          JOptionPane.showMessageDialog(contentPane, "Please select a row to edit.");
        }
      }
    });

    deleteButton = new JButton("Delete");
    deleteButton.setBackground(new Color(59, 89, 182));
    deleteButton.addMouseListener(new MouseAdapter() {@Override
      public void mouseEntered(MouseEvent e) {
        deleteButton.setBackground(new Color(129, 159, 232));
      }@Override
      public void mouseExited(MouseEvent e) {
        deleteButton.setBackground(new Color(59, 89, 182));
      }
    });
    deleteButton.setBounds(1087, 447, 100, 30);
    contentPane.add(deleteButton);
    deleteButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {

        int selectedRow = table.getSelectedRow();

        if (selectedRow != -1) {
          int confirm = JOptionPane.showConfirmDialog(contentPane, "Are you sure you want to delete this row?", "Delete Row", JOptionPane.YES_NO_OPTION);

          if (confirm == JOptionPane.YES_OPTION) {

            model.removeRow(selectedRow);
          }
        } else {
          JOptionPane.showMessageDialog(contentPane, "Please select a row to delete.");
        }
      }
    });

    final ImageIcon closeIcon3 = new ImageIcon("C:\\Users\\admin\\Downloads\\grade.png");
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

    timeLabel = new JLabel(); 
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
    OverallGrade.setEnabled(false);
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
          GradeCalculator.this.dispose();
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

    lblAccountManagement = new JLabel("Grade Calculator");
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

    JPanel panelBG = new JPanel();
    panelBG.setBackground(new Color(59, 89, 182));
    panelBG.setFont(new Font("Verdana", Font.BOLD, 11));
    panelBG.setBounds(204, 534, 986, 155);
    contentPane.add(panelBG);

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
  private boolean isValidGrade(String grade) {
    try {
      double value = Double.parseDouble(grade);
      return true;
    } catch(NumberFormatException e) {
      return false;
    }
  }
  private void saveTableDataToFile(File file) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
      int selectedRow = table.getSelectedRow();
      if (selectedRow != -1) {
        StringBuilder rowData = new StringBuilder();
        for (int column = 0; column < table.getColumnCount(); column++) {
          Object value = table.getValueAt(selectedRow, column);
          rowData.append(value).append(",");
        }
        writer.write(rowData.toString().trim());
        writer.newLine();

        writer.flush();
        writer.close();

        JOptionPane.showMessageDialog(contentPane, "Data saved successfully!");
      } else {
        JOptionPane.showMessageDialog(contentPane, "No row selected!", "Error", JOptionPane.ERROR_MESSAGE);
      }
    } catch(IOException ex) {
      JOptionPane.showMessageDialog(contentPane, "Error occurred while saving data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
  }
  private void readTableDataFromFile(File file) {
    try {
      BufferedReader reader = new BufferedReader(new FileReader(file));
      String line;
      while ((line = reader.readLine()) != null) {
        String[] rowData = line.split(",");
        model.addRow(rowData);
      }
      reader.close();
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
  private void clearTable() {
    model.setRowCount(0);
  }
  private void editDataFromFile(int selectedRow, File file) {
    try {
      List < String > lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);

      if (selectedRow < lines.size()) {
        String line = lines.get(selectedRow);
        String[] rowData = line.split(",");

       
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        JTextField nameField = new JTextField(rowData[0]);
        JComboBox < String > sectionField = new JComboBox < >(new String[] {
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
        });
        sectionField.setSelectedItem(rowData[1]);
        JTextField prelimAverageField = new JTextField(rowData[2]);
        JTextField midtermAverageField = new JTextField(rowData[3]);
        JTextField finalsAverageField = new JTextField(rowData[4]);

        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Section:"));
        panel.add(sectionField);
        panel.add(new JLabel("Prelim Average:"));
        panel.add(prelimAverageField);
        panel.add(new JLabel("Midterm Average:"));
        panel.add(midtermAverageField);
        panel.add(new JLabel("Finals Average:"));
        panel.add(finalsAverageField);

        int result = JOptionPane.showConfirmDialog(contentPane, panel, "Edit Student Grade Standing", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
          String editedName = nameField.getText();
          String editedSection = (String) sectionField.getSelectedItem();
          double editedPrelimAverage = Double.parseDouble(prelimAverageField.getText());
          double editedMidtermAverage = Double.parseDouble(midtermAverageField.getText());
          double editedFinalsAverage = Double.parseDouble(finalsAverageField.getText());
          double editedOverallAverage = (editedPrelimAverage + editedMidtermAverage + editedFinalsAverage) / 3;

         
          String updatedRowData = String.format("%s,%s,%.2f,%.2f,%.2f,%.2f", rowData[0], rowData[1], editedPrelimAverage, editedMidtermAverage, editedFinalsAverage, editedOverallAverage);
          lines.set(selectedRow, updatedRowData);

        
          Files.write(file.toPath(), lines, StandardCharsets.UTF_8);

         
          model.setValueAt(editedName, selectedRow, 0);
          model.setValueAt(editedSection, selectedRow, 1);
          model.setValueAt(editedPrelimAverage, selectedRow, 2);
          model.setValueAt(editedMidtermAverage, selectedRow, 3);
          model.setValueAt(editedFinalsAverage, selectedRow, 4);
          model.setValueAt(editedOverallAverage, selectedRow, 5);

          JOptionPane.showMessageDialog(contentPane, "Data updated successfully.");
        }
      } else {
        JOptionPane.showMessageDialog(contentPane, "Invalid selected row index.");
      }
    } catch(IOException e) {
      e.printStackTrace();
      JOptionPane.showMessageDialog(contentPane, "Error editing data in the file.", "Error", JOptionPane.ERROR_MESSAGE);
    }
  }
}