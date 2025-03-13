package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Line;
import geometry.Point;
import geometry.Shape;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgLine extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel pnlCenter = new JPanel();
	private JTextField sxValue;
	private JTextField syValue;
	private JTextField exValue;
	private JTextField eyValue;
	private Color outline = Color.BLACK;
	private boolean OutLineBoolean;
	private boolean FillBoolean;

	public boolean isOutLineBoolean() {
		return OutLineBoolean;
	}

	public void setOutLineBoolean(boolean outLineBoolean) {
		OutLineBoolean = outLineBoolean;
	}

	public boolean isFillBoolean() {
		return FillBoolean;
	}

	public void setFillBoolean(boolean fillBoolean) {
		FillBoolean = fillBoolean;
	}

	public static void main(String[] args) {
		try {
			DlgLine dialog = new DlgLine();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public JTextField getSxValue() {
		return sxValue;
	}

	public void setSxValue(JTextField sxValue) {
		this.sxValue = sxValue;
	}

	public JTextField getSyValue() {
		return syValue;
	}

	public void setSyValue(JTextField syValue) {
		this.syValue = syValue;
	}

	public JTextField getExValue() {
		return exValue;
	}

	public void setExValue(JTextField exValue) {
		this.exValue = exValue;
	}

	public JTextField getEyValue() {
		return eyValue;
	}

	public void setEyValue(JTextField eyValue) {
		this.eyValue = eyValue;
	}

	public DlgLine() {
		setTitle("Marko Popovic IM96/2020");
		Color Zelena = new Color(170, 221, 80);
		pnlCenter.setBackground(Zelena);
		Color Boja = new Color(255, 185, 255);
		setModal(true);
		setBounds(100, 100, 500, 300);
		getContentPane().setLayout(new BorderLayout());
		pnlCenter.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlCenter, BorderLayout.CENTER);
		sxValue = new JTextField();
		sxValue.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(((c >= '0') && (c <= '9')) || (c == KeyEvent.VK_BACK_SPACE))) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		sxValue.setColumns(10);
		syValue = new JTextField();
		syValue.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(((c >= '0') && (c <= '9')) || (c == KeyEvent.VK_BACK_SPACE))) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		syValue.setColumns(10);
		exValue = new JTextField();
		exValue.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(((c >= '0') && (c <= '9')) || (c == KeyEvent.VK_BACK_SPACE))) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		exValue.setColumns(10);
		eyValue = new JTextField();
		eyValue.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(((c >= '0') && (c <= '9')) || (c == KeyEvent.VK_BACK_SPACE))) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		eyValue.setColumns(10);
		JLabel lblNewLabel = new JLabel("X start coordinate:");
		JLabel lblNewLabel_1 = new JLabel("Y start coordinate:");
		JLabel lblNewLabel_2 = new JLabel("X end coordinate:");
		JLabel lblNewLabel_3 = new JLabel("Y end coordinate:");

		JButton btnNewButton = new JButton("Outline color");
		btnNewButton.setBackground(Boja);
		btnNewButton.setForeground(Color.MAGENTA);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outline = JColorChooser.showDialog(null, "Choose color", Color.BLACK);
				OutLineBoolean = true;
			}
		});
		GroupLayout gl_contentPanel = new GroupLayout(pnlCenter);
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(59)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel)
								.addComponent(lblNewLabel_1).addComponent(lblNewLabel_2).addComponent(lblNewLabel_3))
						.addGap(60)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(sxValue, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 183,
										Short.MAX_VALUE)
								.addComponent(syValue, Alignment.LEADING).addComponent(exValue, Alignment.LEADING)
								.addComponent(eyValue, Alignment.LEADING))
						.addContainerGap(76, Short.MAX_VALUE)));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(22)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(sxValue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel))
						.addGap(18)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(syValue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1))
						.addGap(18)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(exValue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2))
						.addGap(18)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(eyValue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3))
						.addGap(18).addComponent(btnNewButton).addContainerGap(21, Short.MAX_VALUE)));
		pnlCenter.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setBackground(Color.green);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (getSxValue().getText().trim().isEmpty() || getSyValue().getText().trim().isEmpty()
								|| getExValue().getText().trim().isEmpty() || getEyValue().getText().trim().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Enter in all values", "Error",
									JOptionPane.INFORMATION_MESSAGE);
							dispose();
						} else {
							for (Shape shape : PnlDrawing.shapesArrList) {
								if (shape.isSelected()) {
									((Line) shape).setStartPoint(new Point(Integer.parseInt(sxValue.getText()),
											Integer.parseInt(syValue.getText())));
									((Line) shape).setEndPoint(new Point(Integer.parseInt(exValue.getText()),
											Integer.parseInt(eyValue.getText())));
									if (OutLineBoolean == true) {
										shape.setOutline(outline);
										OutLineBoolean = false;
									}
								}
							}
						}
						dispose();
						return;
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setBackground(Color.red);
				cancelButton.setForeground(Color.white);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}