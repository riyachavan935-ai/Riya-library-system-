// LibrarySwingApp.java - MAIN FILE - Java Swing - 350+ lines - Bada Code
// By Riya Chavan 3121 - Library Management System - Alag Topic
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class LibrarySwingApp extends JFrame {
    JTextField titleField, authorField, studentField;
    DefaultTableModel tableModel;
    JLabel outputLabel;
    JTable table;
    LibraryService service;
    int counter=1005;

    public LibrarySwingApp() {
        service = new LibraryService();
        setTitle("Library Management - Java + Java Swing - Riya 3121 - BIG WEBSITE");
        setSize(1200, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(113,63,18));
        header.setPreferredSize(new Dimension(100,60));
        JLabel logo = new JLabel("  📚 Library Management System - Java Swing - BADI WEBSITE - Riya 3121");
        logo.setForeground(new Color(254,240,138));
        logo.setFont(new Font("Arial", Font.BOLD, 17));
        header.add(logo, BorderLayout.WEST);
        add(header, BorderLayout.NORTH);

        JPanel left = new JPanel();
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
        left.setBorder(BorderFactory.createTitledBorder("Add / Issue / Return - Output Yaha Ayega"));
        left.setPreferredSize(new Dimension(400,600));
        left.setBackground(Color.WHITE);
        titleField = new JTextField("Data Structures");
        authorField = new JTextField("Mark Weiss");
        studentField = new JTextField("Riya Chavan 3121");
        left.add(new JLabel("Book Title:")); left.add(titleField);
        left.add(new JLabel("Author:")); left.add(authorField);
        left.add(new JLabel("Student:")); left.add(studentField);

        JButton addBtn = new JButton("➕ ADD BOOK - BADA OUTPUT AAYEGA");
        addBtn.setBackground(new Color(113,63,18)); addBtn.setForeground(Color.WHITE);
        JButton issueBtn = new JButton("📕 ISSUE BOOK");
        issueBtn.setBackground(new Color(22,163,74)); issueBtn.setForeground(Color.WHITE);
        JButton returnBtn = new JButton("📗 RETURN BOOK");
        returnBtn.setBackground(new Color(37,99,235)); returnBtn.setForeground(Color.WHITE);

        left.add(Box.createVerticalStrut(10)); left.add(addBtn); left.add(issueBtn); left.add(returnBtn);
        outputLabel = new JLabel("<html>BADA OUTPUT Yaha ayega...<br>Add dabao...</html>");
        outputLabel.setOpaque(true); outputLabel.setBackground(new Color(254,252,232));
        outputLabel.setBorder(BorderFactory.createTitledBorder("✅ BADA OUTPUT PANEL - Java Swing"));
        outputLabel.setPreferredSize(new Dimension(350,250));
        left.add(Box.createVerticalStrut(10)); left.add(outputLabel);

        JPanel right = new JPanel(new BorderLayout());
        right.setBorder(BorderFactory.createTitledBorder("📋 Library Stock - JTable - Big Website"));
        String[] cols = {"Book ID", "Title", "Author", "Status", "Issued To"};
        tableModel = new DefaultTableModel(cols,0);
        table = new JTable(tableModel); table.setRowHeight(28);
        right.add(new JScrollPane(table), BorderLayout.CENTER);
        add(left, BorderLayout.WEST); add(right, BorderLayout.CENTER);

        for(Book b: service.getAllBooks()){
            tableModel.addRow(new Object[]{b.getBookId(), b.getTitle(), b.getAuthor(), b.getStatus(), b.getIssuedTo()});
        }

        addBtn.addActionListener(e->{
            String t=titleField.getText(); String a=authorField.getText();
            if(t.isEmpty()){JOptionPane.showMessageDialog(this,"Title likho!");return;}
            String id="BK"+counter++;
            Book b=new Book(id,t,a,"CS"); service.addBook(b);
            tableModel.addRow(new Object[]{id,t,a,"Available","-"});
            outputLabel.setText("<html><b style='color:green'>✅ BADA OUTPUT AAYA - BOOK ADDED!</b><br><br><b>"+id+"</b><br>Title: "+t+"<br>Author: "+a+"<br>Status: Available<br><br>Total Books: "+tableModel.getRowCount()+"<br>Java Swing: JFrame, JTable, JButton Used<br>Console: System.out.println OUTPUT</html>");
            System.out.println("========================================");
            System.out.println("BADA OUTPUT - BOOK ADDED: "+id+" | "+t+" by "+a);
            System.out.println("Status: Available | By Riya 3121");
            System.out.println("Java Swing Components: JFrame, JTable, JLabel");
            System.out.println("Files: Book.java, LibraryService.java, LibrarySwingApp.java");
            System.out.println("========================================");
            JOptionPane.showMessageDialog(this,"✅ BADA OUTPUT AAYA!\n\nID: "+id+"\nTitle: "+t+"\n\nOutput: Table me + Label me + Console me!");
        });

        issueBtn.addActionListener(e->{
            int r=table.getSelectedRow(); if(r==-1) r=tableModel.getRowCount()-1;
            String id=(String)tableModel.getValueAt(r,0);
            String s=studentField.getText();
            tableModel.setValueAt("Issued",r,3); tableModel.setValueAt(s,r,4);
            outputLabel.setText("<html><b style='color:orange'>📕 BOOK ISSUED - BADA OUTPUT!</b><br><br>"+id+"<br>To: "+s+"<br>Status: Issued</html>");
            System.out.println("BADA OUTPUT - BOOK ISSUED: "+id+" to "+s);
        });

        returnBtn.addActionListener(e->{
            int r=table.getSelectedRow(); if(r==-1){JOptionPane.showMessageDialog(this,"Select karo!");return;}
            String id=(String)tableModel.getValueAt(r,0);
            tableModel.setValueAt("Available",r,3); tableModel.setValueAt("-",r,4);
            outputLabel.setText("<html><b style='color:blue'>📗 BOOK RETURNED - BADA OUTPUT!</b><br><br>"+id+"<br>Available Again</html>");
            System.out.println("BADA OUTPUT - BOOK RETURNED: "+id);
        });

        setVisible(true);
    }
    public static void main(String[] args){
        System.out.println("Library Management - Java + Java Swing - BADI WEBSITE - Riya 3121");
        SwingUtilities.invokeLater(()->new LibrarySwingApp());
    }
          }
