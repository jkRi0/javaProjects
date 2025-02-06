import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class JTestingArea extends JFrame {
    private JTextArea transactionTextArea;
    private JTextField[] ticketFields;
    private JCheckBox[] eventCheckBoxes;
    private JButton bookTicketsButton;
    private JButton clearButton;
    private JPanel seatSelectionPanel;
    private int[][] availableSeats = { { 100, 80, 80 }, { 120, 100, 100 }, { 90, 70, 70 } };
    private int[][] selectedSeats;
    private double[] eventPrices = { 50.0, 60.0, 40.0 };

    public JTestingArea() {
        setTitle("Ticket Booking System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel mainPanel = new JPanel(new BorderLayout());

        // Event selection panel
        JPanel eventPanel = new JPanel(new GridLayout(3, 1));
        eventPanel.setBorder(BorderFactory.createTitledBorder("Events"));

        eventCheckBoxes = new JCheckBox[3];
        for (int i = 0; i < eventCheckBoxes.length; i++) {
            final int index = i;
            eventCheckBoxes[i] = new JCheckBox("Event " + (i + 1));
            eventCheckBoxes[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    updateSeatSelection(index);
                }
            });
            eventPanel.add(eventCheckBoxes[i]);
        }

        // Ticket input panel
        JPanel ticketPanel = new JPanel(new GridLayout(3, 2));
        ticketPanel.setBorder(BorderFactory.createTitledBorder("Ticket Selection"));

        JLabel[] ticketLabels = new JLabel[3];
        ticketFields = new JTextField[3];
        for (int i = 0; i < ticketLabels.length; i++) {
            ticketLabels[i] = new JLabel("Event " + (i + 1) + " Tickets:");
            ticketFields[i] = new JTextField(5);
            ticketPanel.add(ticketLabels[i]);
            ticketPanel.add(ticketFields[i]);
        }

        // Button panel
        JPanel buttonPanel = new JPanel();
        bookTicketsButton = new JButton("Book Tickets");
        clearButton = new JButton("Clear");
        bookTicketsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookTickets();
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearSelection();
            }
        });
        buttonPanel.add(bookTicketsButton);
        buttonPanel.add(clearButton);

        // Transaction text area
        transactionTextArea = new JTextArea(10, 20);
        transactionTextArea.setEditable(false);

        // Main layout
        mainPanel.add(eventPanel, BorderLayout.WEST);
        mainPanel.add(ticketPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        mainPanel.add(transactionTextArea, BorderLayout.EAST);

        getContentPane().add(mainPanel);
        pack();
    }

    private void updateSeatSelection(int eventIndex) {
        seatSelectionPanel = new JPanel(new GridLayout(3, 3));
        seatSelectionPanel.setBorder(BorderFactory.createTitledBorder("Seat Selection"));

        selectedSeats = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                final int row = i;
                final int col = j;
                JButton seatButton = new JButton("Seat " + (i + 1) + "-" + (j + 1) + " $" + availableSeats[eventIndex][i]);
                seatButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (selectedSeats[row][col] == 0) {
                            selectedSeats[row][col] = availableSeats[eventIndex][col];
                            seatButton.setEnabled(false);
                        } else {
                            selectedSeats[row][col] = 0;
                            seatButton.setEnabled(true);
                        }
                    }
                });
                seatSelectionPanel.add(seatButton);
            }
        }

        getContentPane().add(seatSelectionPanel, BorderLayout.EAST);
        pack();
    }

    private void bookTickets() {
        double totalCost = 0.0;
        StringBuilder transactionDetails = new StringBuilder();

        for (int i = 0; i < eventCheckBoxes.length; i++) {
            if (eventCheckBoxes[i].isSelected()) {
                int tickets = Integer.parseInt(ticketFields[i].getText());
                double eventCost = eventPrices[i] * tickets;
                totalCost += eventCost;
                transactionDetails.append("Event ").append(i + 1).append(": ").append(tickets).append(" tickets - $").append(eventCost).append("\n");
            }
        }

        transactionDetails.append("Total Cost: $").append(totalCost);
        transactionTextArea.setText(transactionDetails.toString());
        JOptionPane.showMessageDialog(this, "Total Cost: $" + totalCost, "Booking Confirmation", JOptionPane.INFORMATION_MESSAGE);
    }

    private void clearSelection() {
        for (JCheckBox checkBox : eventCheckBoxes) {
            checkBox.setSelected(false);
        }
        for (JTextField field : ticketFields) {
            field.setText("");
        }
        transactionTextArea.setText("");
        if (seatSelectionPanel != null) {
            getContentPane().remove(seatSelectionPanel);
            seatSelectionPanel = null;
            pack();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JTestingArea().setVisible(true);
            }
        });
    }
}