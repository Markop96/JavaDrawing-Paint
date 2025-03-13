package sort;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;


public class SortDlg extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton okButton;
	private JButton cancelButton;
	private JTextField txtXCoord;
	private JTextField txtYCoord;
	private JTextField txtRadius;
	protected boolean isOk;
	private boolean delete;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		try {
			SortDlg dialog = new SortDlg();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SortDlg() {
		setModal(true);
		setBounds(100, 100, 250, 300);
		setResizable(false);
		setTitle("Marko Popovic IM96/2020");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(209, 255, 153));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("X coordinate:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblYCoordinate = new JLabel("Y coordinate:");
		lblYCoordinate.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblWidth = new JLabel("Radius:");
		lblWidth.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtXCoord = new JTextField();
		txtXCoord.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtXCoord.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
			char Char = e.getKeyChar();
			if (!(((Char>='0') && (Char <= '9')) || (Char == KeyEvent.VK_BACK_SPACE))){
			e.consume();
			getToolkit().beep();
			}
			}
		});
		txtXCoord.setColumns(10);
		
		txtYCoord = new JTextField(); 
		txtYCoord.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtYCoord.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char Char = e.getKeyChar();
				
				if (!(((Char>='0') && (Char<= '9')) || (Char== KeyEvent.VK_BACK_SPACE))){
				e.consume();
				getToolkit().beep();
				}
			}
		});
		txtYCoord.setColumns(10);
		
		txtRadius = new JTextField();
		txtRadius.setHorizontalAlignment(SwingConstants.CENTER);
		txtRadius.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char Char = e.getKeyChar();
				if (!(((Char>='0') && (Char <= '9')) || (Char == KeyEvent.VK_BACK_SPACE))){
				e.consume();
				getToolkit().beep();
				}
			}
		});
		txtRadius.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addContainerGap(131, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblYCoordinate, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblWidth, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(txtRadius)
						.addComponent(txtYCoord)
						.addComponent(txtXCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(97))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(46)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(txtXCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblYCoordinate)
						.addComponent(txtYCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWidth)
						.addComponent(txtRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(96, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(92, 167, 1));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Ok");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							if(txtXCoord.getText().trim().isEmpty() ||
									txtYCoord.getText().trim().isEmpty() || txtRadius.getText().trim().isEmpty()) {
									isOk = false;
									getToolkit().beep();
									JOptionPane. showMessageDialog(null, "Fill in all the blanks", "Error",
									JOptionPane. ERROR_MESSAGE);
							}
							else if(txtXCoord.getText().trim().equals("0")|| txtYCoord.getText().trim().equals("0")||txtRadius.getText().trim().equals("0")){
								isOk=false;
								getToolkit().beep();
								JOptionPane.showMessageDialog(null, "Values cannot be zero!", "Error",JOptionPane.ERROR_MESSAGE);
							}
							else {
										isOk = true;
										setDelete(true);
										dispose();
						}
					}
				});
				okButton.setBackground(new Color(128, 255, 0));
				okButton.setActionCommand("OK");
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						
						
					}
				});
				cancelButton.setForeground(new Color(255, 255, 255));
				cancelButton.setBackground(new Color(255, 0, 0));
				cancelButton.setActionCommand("Cancel");
			}
			
			GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
			gl_buttonPane.setHorizontalGroup(
				gl_buttonPane.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addContainerGap(264, Short.MAX_VALUE)
						.addComponent(okButton, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(cancelButton)
						.addGap(45))
			);
			gl_buttonPane.setVerticalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_buttonPane.createParallelGroup(Alignment.LEADING)
							.addComponent(okButton)
							.addComponent(cancelButton))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			buttonPane.setLayout(gl_buttonPane);
		}
	}

	public JTextField getTxtXCoord() {
		return txtXCoord;
	}

	public void setTxtXCoord(JTextField txtXCoord) {
		this.txtXCoord = txtXCoord;
	}

	public JTextField getTxtYCoord() {
		return txtYCoord;
	}

	public void setTxtYCoord(JTextField txtYCoord) {
		this.txtYCoord = txtYCoord;
	}

	public JTextField getTxtRadius() {
		return txtRadius;
	}

	public void setTxtRadius(JTextField txtRadius) {
		this.txtRadius = txtRadius;
	}

	public boolean isDelete() {
		return delete;
	}

	public void setDelete(boolean delete) {
		this.delete = delete;
	}


	
}
