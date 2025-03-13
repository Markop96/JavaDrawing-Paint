package drawing;

import geometry.Donut;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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

public class DlgDonut extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel pnlCenter = new JPanel();
	private JTextField xCoord;
	private JTextField yCoord;
	private JTextField rValue;
	private JTextField irValue;
	public boolean isOk;
	private Color outline = Color.BLACK;
	private Color fill = Color.WHITE;
	public boolean OutLineBoolean;
	public boolean FillBoolean;

	public static void main(String[] args) {
		try {
			DlgDonut dialog = new DlgDonut();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DlgDonut() {
		setTitle("Marko Popovic IM96/2020");
		Color Zelena = new Color(170, 221, 80);
		pnlCenter.setBackground(Zelena);
		setModal(true);
		setBounds(100, 100, 500, 400);
		getContentPane().setLayout(new BorderLayout());
		pnlCenter.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlCenter, BorderLayout.CENTER);
		xCoord = new JTextField();
		xCoord.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(((c >= '0') && (c <= '9')) || (c == KeyEvent.VK_BACK_SPACE))) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		xCoord.setColumns(10);
		yCoord = new JTextField();
		yCoord.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(((c >= '0') && (c <= '9')) || (c == KeyEvent.VK_BACK_SPACE))) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		yCoord.setColumns(10);
		rValue = new JTextField();
		rValue.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(((c >= '0') && (c <= '9')) || (c == KeyEvent.VK_BACK_SPACE))) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		rValue.setColumns(10);
		irValue = new JTextField();
		irValue.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(((c >= '0') && (c <= '9')) || (c == KeyEvent.VK_BACK_SPACE))) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		irValue.setColumns(10);
		JLabel lblNewLabel = new JLabel("X coordinate:");
		JLabel lblNewLabel_1 = new JLabel("Y coordinate:");
		JLabel lblNewLabel_2 = new JLabel("Outer Radius:");
		JLabel lblNewLabel_3 = new JLabel("Inner Radius:");
		
		JButton btnOutline = new JButton("Outline color");
		btnOutline.setBackground(new Color(255, 185, 255));
		btnOutline.setForeground(Color.MAGENTA);
		btnOutline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outline = JColorChooser.showDialog(null, "Choose outline color", outline);
				OutLineBoolean = true;
			}
		});

		JButton btnFill = new JButton("Fill color");
		btnFill.setBackground(new Color(255, 185, 255));
		btnFill.setForeground(Color.MAGENTA);
		btnFill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fill = JColorChooser.showDialog(null, "Choose fill color", fill);
				FillBoolean = true;
			}
		});

		GroupLayout gl_pnlCenter = new GroupLayout(pnlCenter);
		gl_pnlCenter.setHorizontalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addGap(120)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_3))
					.addGap(18)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnFill, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnOutline, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(xCoord, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
						.addComponent(yCoord)
						.addComponent(rValue)
						.addComponent(irValue))
					.addContainerGap(143, Short.MAX_VALUE))
		);
		gl_pnlCenter.setVerticalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(xCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(18)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(yCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(18)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(rValue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addGap(18)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(irValue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3))
					.addGap(30)
					.addComponent(btnOutline)
					.addGap(18)
					.addComponent(btnFill)
					.addContainerGap(52, Short.MAX_VALUE))
		);
		pnlCenter.setLayout(gl_pnlCenter);
		{
			JPanel pnlBtn = new JPanel();
			pnlBtn.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(pnlBtn, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (xCoord.getText().trim().isEmpty() || yCoord.getText().trim().isEmpty()
								|| rValue.getText().trim().isEmpty() || irValue.getText().trim().isEmpty()) {
							isOk = false;
							JOptionPane.showMessageDialog(null, "You need to fill in all blank spaces", "Error",
									JOptionPane.ERROR_MESSAGE);
							getToolkit().beep();
						} else {
							if (Integer.parseInt(rValue.getText()) > (Integer.parseInt(irValue.getText()))) {
								for (Shape shape : PnlDrawing.shapesArrList) {
									if (shape.isSelected()) {
										shape.moveTo(Integer.parseInt(xCoord.getText()),
												Integer.parseInt(yCoord.getText()));
										try {
											((Donut) shape).setRadius(Integer.parseInt(rValue.getText()));
										} catch (NumberFormatException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										} catch (Exception e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
										((Donut) shape).setInnerRadius(Integer.parseInt(irValue.getText()));
										if (isOutLineBoolean() == true) {
											shape.setOutline(outline);
											setOutLineBoolean(false);
										}
										if (isFillBoolean() == true) {
											shape.setFill(fill);
											setFillBoolean(false);
										}
									}
								}
								isOk = true;
								dispose();
							} else {
								isOk = false;
								JOptionPane.showMessageDialog(null, "Inner radius must be smaller than outer radius.",
										"Error", JOptionPane.ERROR_MESSAGE);
							}

						}
					}
				});
				okButton.setActionCommand("OK");
				okButton.setBackground(Color.green);
				pnlBtn.add(okButton);
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
				pnlBtn.add(cancelButton);
			}
		}
	}

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

	public JTextField getxCoord() {
		return xCoord;
	}

	public void setxCoord(JTextField xCoord) {
		this.xCoord = xCoord;
	}

	public JTextField getyCoord() {
		return yCoord;
	}

	public void setyCoord(JTextField yCoord) {
		this.yCoord = yCoord;
	}

	public JTextField getrValue() {
		return rValue;
	}

	public void setrValue(JTextField rValue) {
		this.rValue = rValue;
	}

	public JTextField getIrValue() {
		return irValue;
	}

	public void setIrValue(JTextField irValue) {
		this.irValue = irValue;
	}

	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}
}
