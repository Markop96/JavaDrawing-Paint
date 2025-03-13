package stack;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Point;
import geometry.Circle;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;

public class StackFrm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	DefaultListModel<String> dlm = new DefaultListModel<String>();
	Stack<Circle> stack = new Stack<Circle>();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StackFrm frame = new StackFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StackFrm() {
		setTitle("Marko Popovic IM96/2020");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(92, 167, 1));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelCenter = new JPanel();
		panelCenter.setBackground(new Color(188, 255, 121));
		contentPane.add(panelCenter, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panelCenter = new GroupLayout(panelCenter);
		gl_panelCenter.setHorizontalGroup(
			gl_panelCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCenter.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panelCenter.setVerticalGroup(
			gl_panelCenter.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelCenter.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JList<String> list = new JList<String>();
		scrollPane.setViewportView(list);
		panelCenter.setLayout(gl_panelCenter);
		list.setModel(dlm);
		
		JPanel panelDown = new JPanel();
		panelDown.setBackground(new Color(188, 255, 121));
		contentPane.add(panelDown, BorderLayout.SOUTH);
		

		JButton btnAdd = new JButton("Add");
		
		btnAdd.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			StackDlg StackDlg = new StackDlg();
			StackDlg.setVisible(true);
			if(StackDlg.isOk) {
				Circle circle = new Circle(new Point(Integer.parseInt(StackDlg.getTxtXCoord().getText()),
										  			(Integer.parseInt(StackDlg.getTxtYCoord().getText()))),
													(Integer.parseInt(StackDlg.getTxtRadius().getText())));
				
				stack.push(circle);
				
				dlm.add(0, "X coordinates: " + circle.getCenter().getX() + " , Y coordinates: " + circle.getCenter().getY() + " , Radius size: "
						+ circle.getRadius());
			    StackDlg.isOk = false;
			    
			}

		}});
		btnAdd.setBackground(new Color(128, 255, 0));
		btnAdd.setForeground(new Color(0, 0, 0));
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dlm.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "There are no entered circles, the stack is empty.", "Error", JOptionPane.ERROR_MESSAGE);
		            getToolkit().beep();
		            return;
			}
				
				int selectedIndex = list.getSelectedIndex();

		        if (selectedIndex == -1) {
		            JOptionPane.showMessageDialog(null, "Please select an item to delete", "Error", JOptionPane.ERROR_MESSAGE);
		            getToolkit().beep();
		            return; 
		        }
				
				String selectedItem = dlm.getElementAt(selectedIndex).toString();
		        String[] split = selectedItem.split(" ");
		        int x = Integer.parseInt(split[2]);
		        int y = Integer.parseInt(split[6]);
		        int r = Integer.parseInt(split[10]);	
		        
		        StackDlg stackDlgDelete = new StackDlg();
		        stackDlgDelete.getTxtXCoord().setText(String.valueOf(x));
		        stackDlgDelete.getTxtYCoord().setText(String.valueOf(y));
		        stackDlgDelete.getTxtRadius().setText(String.valueOf(r));
		        stackDlgDelete.getTxtXCoord().setEditable(false);
		        stackDlgDelete.getTxtYCoord().setEditable(false);
		        stackDlgDelete.getTxtRadius().setEditable(false);
		        stackDlgDelete.setVisible(true);
		        
		        if (stackDlgDelete.isDelete()) {
		    		
		            stack.remove(selectedIndex);
		            dlm.removeElementAt(selectedIndex);
		        }
		       
		}});
		btnRemove.setForeground(new Color(255, 255, 255));
		btnRemove.setBackground(new Color(255, 0, 0));
		
		
		GroupLayout gl_panelDown = new GroupLayout(panelDown);
		gl_panelDown.setHorizontalGroup(
			gl_panelDown.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelDown.createSequentialGroup()
					.addGap(53)
					.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 310, Short.MAX_VALUE)
					.addComponent(btnRemove)
					.addGap(55))
		);
		gl_panelDown.setVerticalGroup(
			gl_panelDown.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDown.createSequentialGroup()
					.addGroup(gl_panelDown.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRemove)
						.addComponent(btnAdd))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelDown.setLayout(gl_panelDown);
	}
}
