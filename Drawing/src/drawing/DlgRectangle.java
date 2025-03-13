package drawing;

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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import geometry.Rectangle;

public class DlgRectangle extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel pnlCenter = new JPanel();
    private JTextField txtX;
    private JTextField txtY;
    private JTextField txtWidth;
    private JTextField txtHeight;
    public boolean isOk;
    private boolean OutLineBoolean;
    private boolean FillBoolean;
    private Color outline = Color.BLACK;
    private Color fill = Color.WHITE;

    public static void main(String[] args) {
        try {
            DlgRectangle dialog = new DlgRectangle();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DlgRectangle() {
    	setTitle("Marko Popovic IM96/2020");
        Color Zelena = new Color(170, 221, 80);
        pnlCenter.setBackground(Zelena);
        setModal(true);
        setBounds(100, 100, 500, 400);
        getContentPane().setLayout(new BorderLayout());
        pnlCenter.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(pnlCenter, BorderLayout.CENTER);

        JLabel lblXCoordinate = new JLabel("X coordinate:");

        JLabel lblYCoordinate = new JLabel("Y coordinate:");

        JLabel lblWidth = new JLabel("Width:");

        JLabel lblHeight = new JLabel("Height:");

        txtX = new JTextField();
        txtX.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(((c >= '0') && (c <= '9')) || (c == KeyEvent.VK_BACK_SPACE))) {
                    e.consume();
                    getToolkit().beep();
                }
            }
        });
        txtX.setColumns(10);

        txtY = new JTextField();
        txtY.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(((c >= '0') && (c <= '9')) || (c == KeyEvent.VK_BACK_SPACE))) {
                    e.consume();
                    getToolkit().beep();
                }
            }
        });
        txtY.setColumns(10);

        txtWidth = new JTextField();
        txtWidth.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(((c >= '0') && (c <= '9')) || (c == KeyEvent.VK_BACK_SPACE))) {
                    e.consume();
                    getToolkit().beep();
                }
            }
        });
        txtWidth.setColumns(10);

        txtHeight = new JTextField();
        txtHeight.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(((c >= '0') && (c <= '9')) || (c == KeyEvent.VK_BACK_SPACE))) {
                    e.consume();
                    getToolkit().beep();
                }
            }
        });
        txtHeight.setColumns(10);

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
                    .addContainerGap()
                    .addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblXCoordinate, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblYCoordinate, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblWidth, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblHeight, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
                        .addComponent(txtHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(196, Short.MAX_VALUE))
                .addGap(143)
                .addGroup(Alignment.TRAILING, gl_pnlCenter.createSequentialGroup()
                    .addContainerGap(100, Short.MAX_VALUE)
                    .addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
                        .addComponent(btnOutline, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnFill, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
                    .addGap(100))
        );

        gl_pnlCenter.setVerticalGroup(
            gl_pnlCenter.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_pnlCenter.createSequentialGroup()
                    .addGap(40)
                    .addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblXCoordinate)
                        .addComponent(txtX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblYCoordinate)
                        .addComponent(txtY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblWidth)
                        .addComponent(txtWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblHeight)
                        .addComponent(txtHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(50)
                    .addComponent(btnOutline)
                    .addGap(18)
                    .addComponent(btnFill)
                    .addContainerGap(50, Short.MAX_VALUE))
        );
        pnlCenter.setLayout(gl_pnlCenter);

        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);
        
        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (txtX.getText().trim().isEmpty() ||
                    txtY.getText().trim().isEmpty() ||
                    txtWidth.getText().trim().isEmpty() ||
                    txtHeight.getText().trim().isEmpty()) {
                    isOk = false;
                    JOptionPane.showMessageDialog(null, "Enter all values", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    getToolkit().beep();
                } else {
                    for (Shape shape : PnlDrawing.shapesArrList) {
                        if (shape.isSelected()) {
                            shape.moveTo(Integer.parseInt(txtX.getText()), Integer.parseInt(txtY.getText()));
                            ((Rectangle) shape).setWidth(Integer.parseInt(txtWidth.getText()));
                            ((Rectangle) shape).setHeight(Integer.parseInt(txtHeight.getText()));
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
                }
            }
        });
        okButton.setActionCommand("OK");
        buttonPane.add(okButton);
        getRootPane().setDefaultButton(okButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        cancelButton.setActionCommand("Cancel");
        buttonPane.add(cancelButton);
    }

    public JTextField getTxtX() {
        return txtX;
    }

    public void setTxtX(JTextField txtX) {
        this.txtX = txtX;
    }

    public JTextField getTxtY() {
        return txtY;
    }

    public void setTxtY(JTextField txtY) {
        this.txtY = txtY;
    }

    public JTextField getTxtWidth() {
        return txtWidth;
    }

    public void setTxtWidth(JTextField txtWidth) {
        this.txtWidth = txtWidth;
    }

    public JTextField getTxtHeight() {
        return txtHeight;
    }

    public void setTxtHeight(JTextField txtHeight) {
        this.txtHeight = txtHeight;
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

    public Color getOutline() {
        return outline;
    }

    public void setOutline(Color outline) {
        this.outline = outline;
    }

    public Color getFill() {
        return fill;
    }

    public void setFill(Color fill) {
        this.fill = fill;
    }
}
