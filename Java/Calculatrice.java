//Chelsea Florquin 05/05/2025
package tpEnumeration;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class calculatrice extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private String nombreAffiche ;
    boolean on=false;
    double valeur1,valeur2;
    Operations operation;
    boolean operationOn=false;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    calculatrice frame = new calculatrice();
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
    public calculatrice() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(10, 11, 416, 52);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel lblAffichage = new JLabel("");
        lblAffichage.setOpaque(true);
        lblAffichage.setBackground(Color.WHITE);
        lblAffichage.setHorizontalAlignment(SwingConstants.RIGHT);
        lblAffichage.setBounds(0, 0, 416, 52);
        panel.add(lblAffichage);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(10, 74, 416, 178);
        contentPane.add(panel_1);
        panel_1.setLayout(new GridLayout(6, 4, 0, 0));
        
        JRadioButton eRBOn = new JRadioButton("On");
        eRBOn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nombreAffiche="0";
                lblAffichage.setText(nombreAffiche);
                on=true;
                
            }
        });
        buttonGroup.add(eRBOn);
        panel_1.add(eRBOn);
        
        JRadioButton eRBOff = new JRadioButton("Off");
        eRBOff.setSelected(true);
        eRBOff.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                on=false;
                lblAffichage.setText("");
            }
        });
        buttonGroup.add(eRBOff);
        panel_1.add(eRBOff);
        
        JButton btnC = new JButton("c");
        btnC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblAffichage.setText("0");
            }
        });
        panel_1.add(btnC);
        
        JButton btnArriere = new JButton("<---");
        btnArriere.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(on) {                
                        String str = lblAffichage.getText();
                        String substring = str.substring(0, str.length() - 1);
                        lblAffichage.setText(substring);
                        
                        nombreAffiche = lblAffichage.getText();
                        if(nombreAffiche ==""){
                            lblAffichage.setText("0");
                        }
                }
            }
        
        });
        panel_1.add(btnArriere);
        
        JButton btn1divX = new JButton("1/x");
        btn1divX.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(on) {
                        nombreAffiche = lblAffichage.getText();
                        Double nombre=Double.parseDouble(nombreAffiche);
                        nombre=1/nombre;
                        nombreAffiche=String.valueOf(nombre);
                        lblAffichage.setText(nombreAffiche);
                }
            }
        });
        panel_1.add(btn1divX);
        
        JButton btnPuiss = new JButton("x^2");
        btnPuiss.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(on) {
                    nombreAffiche = lblAffichage.getText();
                    Double nombre=Double.parseDouble(nombreAffiche);
                    nombre= nombre * nombre;
                    nombreAffiche=String.valueOf(nombre);
                    lblAffichage.setText(nombreAffiche);
                }
            }
        });
        panel_1.add(btnPuiss);
        
        JButton btnRacx = new JButton("rac(x)");
        btnRacx.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(on) {
                    nombreAffiche = lblAffichage.getText();
                    Double nombre=Double.parseDouble(nombreAffiche);
                    nombre=Math.sqrt(nombre);
                    nombreAffiche=String.valueOf(nombre);
                    lblAffichage.setText(nombreAffiche);
                }
            }
        });
        panel_1.add(btnRacx);
        
        JButton btndiv = new JButton("/");
        btndiv.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(on) {
                    valeur1=Double.parseDouble(lblAffichage.getText());
                    operation=Operations.DIVIS;
                    operationOn=true;
                }
            }
        });
        panel_1.add(btndiv);
        
        JButton btn7 = new JButton("7");
        btn7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(on) {
                    String number="7";
                    if(lblAffichage.getText().equals("0")||operationOn) {
                        nombreAffiche = number;
                        operationOn=false;
                    }
                    else {
                        nombreAffiche=lblAffichage.getText()+number;}
                        lblAffichage.setText(nombreAffiche);
                }
            }
        });
        panel_1.add(btn7);
        
        JButton btn8 = new JButton("8");
        btn8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    if(on) {
                        String number="8";
                        if(lblAffichage.getText().equals("0")||operationOn) {
                            nombreAffiche = number;
                            operationOn=false;
                        }
                        else {
                            nombreAffiche=lblAffichage.getText()+number;}
                            lblAffichage.setText(nombreAffiche);
                    }
            }
        });
        panel_1.add(btn8);
        
        JButton btn9 = new JButton("9");
        btn9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(on) {
                    String number="9";
                    if(lblAffichage.getText().equals("0")||operationOn) {
                        nombreAffiche = number;
                        operationOn=false;
                    }
                    else {
                        nombreAffiche=lblAffichage.getText()+number;}
                        lblAffichage.setText(nombreAffiche);
                }
            }
        });
        panel_1.add(btn9);
        
        JButton btnMulti = new JButton("X");
        btnMulti.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(on) {
                    valeur1=Double.parseDouble(lblAffichage.getText());
                    operation=Operations.FOIS;
                    operationOn=true;
                }
            }
        });
        panel_1.add(btnMulti);
        
        JButton btn4 = new JButton("4");
        btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(on) {
                    String number="4";
                    if(lblAffichage.getText().equals("0")||operationOn) {
                        nombreAffiche = number;
                        operationOn=false;
                    }
                    else {
                        nombreAffiche=lblAffichage.getText()+number;}
                        lblAffichage.setText(nombreAffiche);
                }
            }
        });
        panel_1.add(btn4);
        
        JButton btn5 = new JButton("5");
        btn5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(on) {
                    String number="5";
                    if(lblAffichage.getText().equals("0")||operationOn) {
                        nombreAffiche = number;
                        operationOn=false;
                    }
                    else {
                        nombreAffiche=lblAffichage.getText()+number;}
                        lblAffichage.setText(nombreAffiche);
                }
            }
        });
        panel_1.add(btn5);
        
        JButton btn6 = new JButton("6");
        btn6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(on) {
                    String number="6";
                    if(lblAffichage.getText().equals("0")||operationOn) {
                        nombreAffiche = number;
                        operationOn=false;
                    }
                    else {
                        nombreAffiche=lblAffichage.getText()+number;}
                        lblAffichage.setText(nombreAffiche);
                }
            }
        });
        panel_1.add(btn6);
        
        JButton btnMoins = new JButton("-");
        btnMoins.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(on) {
                    valeur1=Double.parseDouble(lblAffichage.getText());
                    operation=Operations.MOINS;
                    operationOn=true;
                }
            }
        });
        panel_1.add(btnMoins);
        
        JButton btn1 = new JButton("1");
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(on) {
                    String number="1";
                    if(lblAffichage.getText().equals("0")||operationOn) {
                        nombreAffiche = number;
                        operationOn=false;
                    }
                    else {
                        nombreAffiche=lblAffichage.getText()+number;}
                        lblAffichage.setText(nombreAffiche);
                }
            }
        });
        panel_1.add(btn1);
        
        JButton btn2 = new JButton("2");
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(on) {
                    String number="2";
                    if(lblAffichage.getText().equals("0")||operationOn) {
                        nombreAffiche = number;
                        operationOn=false;
                    }
                    else {
                        nombreAffiche=lblAffichage.getText()+number;}
                        lblAffichage.setText(nombreAffiche);
                }
            }
        });
        panel_1.add(btn2);
        
        JButton btn3 = new JButton("3");
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(on) {
                    String number="3";
                    if(lblAffichage.getText().equals("0")||operationOn) {
                        nombreAffiche = number;
                        operationOn=false;
                    }
                    else {
                        nombreAffiche=lblAffichage.getText()+number;}
                        lblAffichage.setText(nombreAffiche);
                }
            }
        });
        panel_1.add(btn3);
        
        JButton btnPlus = new JButton("+");
        btnPlus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(on) {
                    valeur1=Double.parseDouble(lblAffichage.getText());
                    operation=Operations.PLUS;
                    operationOn=true;
                }
            }
        });
        panel_1.add(btnPlus);
        
        JButton btnNegation = new JButton("+/-");
        btnNegation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String affichage = lblAffichage.getText();
                if (!affichage.startsWith("-")) {
                    affichage = "-" + affichage;
                } else {
                    affichage = affichage.substring(1);
                }
                lblAffichage.setText(affichage);
            }
        });
        panel_1.add(btnNegation);
        
        JButton btn0 = new JButton("0");
        btn0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(on) {
                    String number="0";
                    if(lblAffichage.getText().equals("0")||operationOn) {
                        nombreAffiche = number;
                        operationOn=false;
                    }
                    else {
                        nombreAffiche=lblAffichage.getText()+number;}
                        lblAffichage.setText(nombreAffiche);
                }
            }
        });
        panel_1.add(btn0);
        
        JButton btnVirgule = new JButton(",");
        btnVirgule.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    String affichage = lblAffichage.getText();
                    boolean virgule=affichage.contains(".");
                    if(!virgule) {
                        String number=".";
                        nombreAffiche=lblAffichage.getText()+number;
                    }
                        lblAffichage.setText(nombreAffiche);
            }
        });
        panel_1.add(btnVirgule);
        
        JButton btnEgale = new JButton("=");
        btnEgale.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(on) {
                    valeur2=Double.parseDouble(lblAffichage.getText());
                    if(null==operation)nombreAffiche=String.valueOf("opération inconnus");
                    else switch(operation) {
                    case PLUS:
                        nombreAffiche=String.valueOf(valeur1+valeur2);
                        break;
                    case MOINS:
                        nombreAffiche=String.valueOf(valeur1-valeur2);
                        break;
                    case FOIS:
                        nombreAffiche=String.valueOf(valeur1*valeur2);
                        break;
                    case DIVIS:
                        nombreAffiche=String.valueOf(valeur1/valeur2);
                        break;}
                }
                lblAffichage.setText(nombreAffiche);
            }
        }
    );
    panel_1.add(btnEgale);
}
}
