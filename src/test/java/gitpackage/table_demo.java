package gitpackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class table_demo {

	private JFrame frame;
	private JTextField id;
	private JTextField name;
	private JTextField cont;
	private JTextField course;
	private JTable table;
	DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					table_demo window = new table_demo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public table_demo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(new Color(220, 20, 60));
		frame.getContentPane().setBackground(new Color(255, 20, 147));
		frame.setBounds(100, 100, 467, 385);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 182, 193));
		panel.setBounds(10, 0, 420, 335);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lbname = new JLabel("ID");
		lbname.setBounds(10, 27, 46, 14);
		panel.add(lbname);
		
		JLabel lbName_1 = new JLabel("Name");
		lbName_1.setBounds(10, 58, 46, 14);
		panel.add(lbName_1);
		
		JLabel lbcontact = new JLabel("Contact");
		lbcontact.setBounds(10, 83, 46, 14);
		panel.add(lbcontact);
		
		JLabel lbCourse = new JLabel("Course");
		lbCourse.setBounds(10, 118, 46, 14);
		panel.add(lbCourse);
		
		id = new JTextField();
		id.setBounds(82, 24, 86, 20);
		panel.add(id);
		id.setColumns(10);
		
		name = new JTextField();
		name.setBounds(82, 55, 86, 20);
		panel.add(name);
		name.setColumns(10);
		
		cont = new JTextField();
		cont.setBounds(82, 80, 86, 20);
		panel.add(cont);
		cont.setColumns(10);
		
		course = new JTextField();
		course.setBounds(82, 115, 86, 20);
		panel.add(course);
		course.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(198, 26, 212, 255);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int i=table.getSelectedRow();
				id.setText(model.getValueAt(i,0).toString());
				name.setText(model.getValueAt(i,1).toString());
				cont.setText(model.getValueAt(i,2).toString());
				course.setText(model.getValueAt(i,3).toString());
			}
		});
		table.setBackground(new Color(0, 255, 127));
		model =new DefaultTableModel();
		Object[] column = {"ID","NAME","CONTACT","COURSE"};
		final Object[] row = new Object[4];
		model.setColumnIdentifiers(column);
		table.setModel(model);
	    scrollPane.setViewportView(table);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(id.getText().equals("")|| name.getText().equals("")|| course.getText().equals("")|| cont.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please Fill complete Information");
				}
				else
				{
					row[0]=id.getText();
					row[1]=name.getText();
					row[2]=cont.getText();
					row[3]=course.getText();
					model.addRow(row);
				
				id.setText("");
				name.setText("");
				cont.setText("");
				course.setText("");
				JOptionPane.showMessageDialog(null, "Saved Successfully");
				}
				
			}
		});
		btnAdd.setBounds(10, 167, 75, 23);
		panel.add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=table.getSelectedRow();
				if(i>=0)
				{
					model.setValueAt(id.getText(), i,0);
					model.setValueAt(name.getText(), i,1);
					model.setValueAt(cont.getText(), i,2);
					model.setValueAt(course.getText(), i,3);
					JOptionPane.showMessageDialog(null, "Updated Successfully");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please select a row first");
				}
			}
		});
		btnUpdate.setBounds(104, 167, 75, 23);
		panel.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=table.getSelectedRow() ;
				if(i>=0)
				{
					model.removeRow(i);
					JOptionPane.showMessageDialog(null,"Deleted Successfully");
					
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Please Select Row First");
				}
			}
		});
		btnDelete.setBounds(10, 213, 75, 23);
		panel.add(btnDelete);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id.setText("");
				name.setText("");
				cont.setText("");
				course.setText("");
						
			}
		});
		btnClear.setBounds(104, 213, 81, 23);
		panel.add(btnClear);
	}
}
