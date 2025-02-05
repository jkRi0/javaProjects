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
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JScrollPane;
import java.io.FileWriter;

public class AdminControl extends JFrame {
	
	private JPanel contentPane;
	  private JTable table;
	  DefaultTableModel model;
	  private JButton readButton;
	  private JButton editButton;
	  private JButton deleteButton;
	  private JButton createButton;
	  private JButton clearButton;
	  private JLabel lblDate;
	  private JButton AccountManagement;
	  private JLabel timeLabel;
	  private JLabel lblStudentApplicants;
	  private JButton ReportGeneration1;
	  private JButton OverallGrade;
	  private JButton AnnouncementManagement;
	
	private static final long serialVersionUID = 1L;	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminControl frame = new AdminControl();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public AdminControl() {
		
		
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

		    final ImageIcon closeIcon3 = new ImageIcon("C:\\Users\\admin\\Downloads\\studprofile.png");
		    final ImageIcon resizedIcon3 = new ImageIcon(closeIcon3.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
		    final JLabel lblProfile = new JLabel(resizedIcon3);
		    lblProfile.setBounds(194, 79, 165, 158);
		    contentPane.add(lblProfile);
		    lblProfile.setHorizontalAlignment(SwingConstants.CENTER);

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

		    JButton RegisteredStudentList = new JButton("Student Applicants");
		    RegisteredStudentList.setFont(new Font("Dialog", Font.BOLD, 18));
		    RegisteredStudentList.setBackground(new Color(89, 119, 222));
		    RegisteredStudentList.setForeground(new Color(0, 0, 0));
		    RegisteredStudentList.setBounds(0, 0, 194, 46);
		    RegisteredStudentList.setEnabled(false);
		    PSideMenu.add(RegisteredStudentList);

		    AccountManagement = new JButton("Accounts Panel");
		    AccountManagement.setFont(new Font("Dialog", Font.BOLD, 18));
		    AccountManagement.addMouseListener(new MouseAdapter() {@Override
		      public void mouseEntered(MouseEvent e) {
		        AccountManagement.setBackground(new Color(129, 159, 232));
		      }@Override
		      public void mouseExited(MouseEvent e) {
		        AccountManagement.setBackground(new Color(89, 119, 222));
		      }
		    });
		    AccountManagement.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		        dispose();
		        AccountPanel.main(null);
		      }
		    });
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

		    JScrollPane scrollPane = new JScrollPane();
		    scrollPane.setBounds(194, 266, 1006, 170);
		    contentPane.add(scrollPane);

		    table = new JTable();
		    scrollPane.setViewportView(table);
		    table.setBackground(new Color(255, 255, 255));
		    model = new DefaultTableModel();
		    final Object[] column = {
		      "Name",
		      "Age",
		      "Gender",
		      "Location",
		      "Section",
		      "Email",
		      "Year Level",
		      "Number",
		      "Department",
		      "Guardian"
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

		    clearButton = new JButton("Clear Table");
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
		        int rowCount = model.getRowCount();
		        for (int i = rowCount - 1; i >= 0; i--) {
		          model.removeRow(i);
		        }
		      }
		    });
		    clearButton.setBounds(744, 447, 125, 37);
		    contentPane.add(clearButton);

		    readButton = new JButton("Read");
		    readButton.addMouseListener(new MouseAdapter() {@Override
		      public void mouseEntered(MouseEvent e) {
		        readButton.setBackground(new Color(129, 159, 232));
		      }@Override
		      public void mouseExited(MouseEvent e) {
		        readButton.setBackground(new Color(59, 89, 182));
		      }
		    });
		    readButton.setFont(new Font("Arial", Font.BOLD, 15));
		    readButton.setBackground(new Color(59, 89, 182));
		    readButton.addActionListener(new ActionListener() {@Override
		      public void actionPerformed(ActionEvent e) {
		        try {
		          File file = new File("students.txt");
		          BufferedReader reader = new BufferedReader(new FileReader(file));
		          String line;
		          boolean allDuplicates = true;
		          while ((line = reader.readLine()) != null) {
		        	  String[] studentData = line.split(",");
		            
		        	  boolean isDuplicate = false;
		        	  for (int i = 0; i < model.getRowCount(); i++) {
		        		  String[] rowData = new String[model.getColumnCount()];
		        		  for (int j = 0; j < model.getColumnCount(); j++) {
		        			  rowData[j] = (String) model.getValueAt(i, j);
		        		  }
		        		  if (Arrays.equals(studentData, rowData)) {
		        			  isDuplicate = true;
		        			  break;
		        		  }
		        	  }
		        	  if (!isDuplicate) {
		        		  model.addRow(studentData);
		        		  allDuplicates = false;
		        	  }
		          }

		          reader.close();
		          if (allDuplicates) {
		            JOptionPane.showMessageDialog(contentPane, "All data is already in the JTable.", "Validation Error", JOptionPane.ERROR_MESSAGE);
		          }
		        } catch(IOException ex) {
		          ex.printStackTrace();
		        }

		      }
		    });
		    readButton.setBounds(339, 447, 125, 37);
		    contentPane.add(readButton);

		    editButton = new JButton("Update");
		    editButton.addMouseListener(new MouseAdapter() {@Override
		      public void mouseEntered(MouseEvent e) {
		        editButton.setBackground(new Color(129, 159, 232));
		      }@Override
		      public void mouseExited(MouseEvent e) {
		        editButton.setBackground(new Color(59, 89, 182));
		      }
		    });
		    editButton.setFont(new Font("Arial", Font.BOLD, 15));
		    editButton.setBackground(new Color(59, 89, 182));
		    editButton.addActionListener(new ActionListener() {@Override
		      public void actionPerformed(ActionEvent e) {
		        int selectedRow = table.getSelectedRow();
		        if (selectedRow == -1) {
		          JOptionPane.showMessageDialog(contentPane, "Please select a row to edit.", "Error", JOptionPane.ERROR_MESSAGE);
		        } else {
		          Object[] rowData = new Object[model.getColumnCount()];
		          for (int i = 0; i < model.getColumnCount(); i++) {
		            rowData[i] = model.getValueAt(selectedRow, i);
		          }

		          
		          JPanel editPanel = new JPanel(new GridLayout(model.getColumnCount(), 2));
		          JTextField[] textFields = new JTextField[model.getColumnCount()];
		          for (int i = 0; i < model.getColumnCount(); i++) {
		            editPanel.add(new JLabel(column[i] + ":"));
		            textFields[i] = new JTextField(rowData[i].toString());
		            editPanel.add(textFields[i]);
		          }

		          int result = JOptionPane.showConfirmDialog(contentPane, editPanel, "Edit Student Information", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		          if (result == JOptionPane.OK_OPTION) {
		            for (int i = 0; i < model.getColumnCount(); i++) {
		              model.setValueAt(textFields[i].getText(), selectedRow, i);
		            }
		          }
		          try {
		            File file = new File("students.txt");
		            BufferedReader reader = new BufferedReader(new FileReader(file));
		            StringBuilder fileContent = new StringBuilder();
		            String line;
		            while ((line = reader.readLine()) != null) {
		              fileContent.append(line).append("\n");
		            }
		            reader.close();

		            FileWriter writer = new FileWriter(file);
		            for (int i = 0; i < model.getRowCount(); i++) {
		              for (int j = 0; j < model.getColumnCount(); j++) {
		                writer.write(model.getValueAt(i, j).toString());
		                if (j < model.getColumnCount() - 1) {
		                  writer.write(",");
		                }
		              }
		              writer.write("\n");
		            }
		            writer.close();

		            JOptionPane.showMessageDialog(contentPane, "Data updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
		          } catch(IOException ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(contentPane, "Error updating data.", "Error", JOptionPane.ERROR_MESSAGE);
		          }
		        }
		      }
		    });
		    editButton.setBounds(474, 447, 125, 37);
		    contentPane.add(editButton);

		    deleteButton = new JButton("Delete");
		    deleteButton.addMouseListener(new MouseAdapter() {@Override
		      public void mouseEntered(MouseEvent e) {
		        deleteButton.setBackground(new Color(129, 159, 232));
		      }@Override
		      public void mouseExited(MouseEvent e) {
		        deleteButton.setBackground(new Color(59, 89, 182));
		      }
		    });
		    deleteButton.setFont(new Font("Arial", Font.BOLD, 15));
		    deleteButton.setBackground(new Color(59, 89, 182));
		    deleteButton.addActionListener(new ActionListener() {@Override
		      public void actionPerformed(ActionEvent e) {
		        int selectedRow = table.getSelectedRow();
		        if (selectedRow == -1) {
		          JOptionPane.showMessageDialog(contentPane, "Please select a row to delete.", "Error", JOptionPane.ERROR_MESSAGE);
		        } else {
		          int confirm = JOptionPane.showConfirmDialog(contentPane, "Are you sure you want to delete this row?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
		          if (confirm == JOptionPane.YES_OPTION) {
		            model.removeRow(selectedRow);
		          }
		        }
		      }
		    });
		    deleteButton.setBounds(609, 447, 125, 37);
		    contentPane.add(deleteButton);

		    createButton = new JButton("Create");
		    createButton.addMouseListener(new MouseAdapter() {@Override
		      public void mouseEntered(MouseEvent e) {
		        createButton.setBackground(new Color(129, 159, 232));
		      }@Override
		      public void mouseExited(MouseEvent e) {
		        createButton.setBackground(new Color(59, 89, 182));
		      }
		    });
		    createButton.setFont(new Font("Arial", Font.BOLD, 15));
		    createButton.setBackground(new Color(59, 89, 182));
		    createButton.addActionListener(new ActionListener() {@Override
		      public void actionPerformed(ActionEvent e) {
		        int selectedRow = table.getSelectedRow();
		        if (selectedRow == -1) {
		          JOptionPane.showMessageDialog(contentPane, "Please select a row to create.", "Error", JOptionPane.ERROR_MESSAGE);
		        } else {
		          try {
		            JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		            fileChooser.setDialogTitle("Save File");
		            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		            fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files (*.txt)", "txt"));

		            int userSelection = fileChooser.showSaveDialog(contentPane);

		            if (userSelection == JFileChooser.APPROVE_OPTION) {
		              File fileToSave = fileChooser.getSelectedFile();
		              String rowString = "";
		              for (int i = 0; i < model.getColumnCount(); i++) {
		                rowString += model.getValueAt(selectedRow, i);
		                if (i < model.getColumnCount() - 1) {
		                  rowString += ",";
		                }
		              }
		              FileWriter writer = new FileWriter(fileToSave, true); 
		              writer.append("\n" + rowString); 
		              writer.close();
		              JOptionPane.showMessageDialog(contentPane, "Data added to the file successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
		            }
		          } catch(IOException ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(contentPane, "Error adding data to the file.", "Error", JOptionPane.ERROR_MESSAGE);
		          }
		        }
		      }
		    });
		    createButton.setBounds(204, 447, 125, 37);
		    contentPane.add(createButton);

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
		          AdminControl.this.dispose();
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

		    lblStudentApplicants = new JLabel("Student Applicants List");
		    lblStudentApplicants.addMouseListener(new MouseAdapter() {@Override
		      public void mouseEntered(MouseEvent e) {
		        lblStudentApplicants.setForeground(new Color(59, 89, 182));
		      }@Override
		      public void mouseExited(MouseEvent e) {
		        lblStudentApplicants.setForeground(new Color(0, 0, 0));
		      }
		    });
		    lblStudentApplicants.setFont(new Font("Verdana", Font.BOLD, 45));
		    lblStudentApplicants.setBounds(369, 123, 590, 59);
		    contentPane.add(lblStudentApplicants);

		    try {
		      ImageIcon closeIcon1 = new ImageIcon("C:\\Users\\admin\\Downloads\\darker.png");
		      Image image = closeIcon1.getImage().getScaledInstance(986, 155, Image.SCALE_SMOOTH);
		      ImageIcon resizedIcon1 = new ImageIcon(image);
		      JLabel lblSchoolBG = new JLabel(resizedIcon1);
		      lblSchoolBG.setOpaque(true);
		      lblSchoolBG.setBounds(204, 534, 986, 155);
		      contentPane.add(lblSchoolBG);

		    } catch(Exception e) {
		      e.printStackTrace();
		    }

		    try {
		      File file = new File("students.txt");
		      BufferedReader br = new BufferedReader(new FileReader(file));
		      String line;
		      while ((line = br.readLine()) != null) {
		        Object[] rowData = line.split(",");
		        model.addRow(rowData);
		      }
		      br.close();
		    } catch(IOException ex) {
		      JOptionPane.showMessageDialog(null, "Error reading data from file.", "Error", JOptionPane.ERROR_MESSAGE);
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
