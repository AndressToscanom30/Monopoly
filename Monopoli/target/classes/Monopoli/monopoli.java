package Monopoli;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class monopoli extends javax.swing.JFrame {
    
    private Casilla[] casillas;
    private JPanel[] casillasP;
    private Jugador[] jugadores;
    
    Tablero tablero = new Tablero();
    Dado dado = new Dado();
    Jugador jugador = new Jugador();
    
    ArrayList<Jugador> jugadoresList = new ArrayList<>();
    ArrayList<Casilla> casillasArrayList = new ArrayList<>();
    
    JPanel jpJugador1 = new JPanel();
    JPanel jpJugador2 = new JPanel();
    JPanel jpJugador3 = new JPanel();
    JPanel jpJugador4 = new JPanel();
    JPanel jpJugador5 = new JPanel();
    JPanel jpJugador6 = new JPanel();
    
    public monopoli() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        this.casillasP = new JPanel[]{
            casilla1, casilla2, casilla3, casilla4, casilla5, casilla6, casilla7, casilla8, casilla9, casilla10,
            casilla11, casilla12, casilla13, casilla14, casilla15, casilla16, casilla17, casilla18, casilla19, casilla20,
            casilla21, casilla22, casilla23, casilla24, casilla25, casilla26, casilla27, casilla28, casilla29, casilla30,
            casilla31, casilla32, casilla33, casilla34, casilla35, casilla36, casilla37, casilla38, casilla39, casilla40
        };
        
        casilla1.setLayout(new FlowLayout());
        casilla1.revalidate();
        casilla1.repaint();
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txtJugador1 = new javax.swing.JTextField();
        txtJugador2 = new javax.swing.JTextField();
        txtJugador3 = new javax.swing.JTextField();
        txtJugador4 = new javax.swing.JTextField();
        txtJugador5 = new javax.swing.JTextField();
        txtJugador6 = new javax.swing.JTextField();
        jbPlay = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        startMoney = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        contenedorTablero = new javax.swing.JPanel();
        casilla1 = new javax.swing.JPanel();
        casilla2 = new javax.swing.JPanel();
        casilla3 = new javax.swing.JPanel();
        casilla4 = new javax.swing.JPanel();
        casilla5 = new javax.swing.JPanel();
        casilla6 = new javax.swing.JPanel();
        casilla7 = new javax.swing.JPanel();
        casilla8 = new javax.swing.JPanel();
        casilla9 = new javax.swing.JPanel();
        casilla10 = new javax.swing.JPanel();
        casilla11 = new javax.swing.JPanel();
        casilla12 = new javax.swing.JPanel();
        casilla13 = new javax.swing.JPanel();
        casilla14 = new javax.swing.JPanel();
        casilla15 = new javax.swing.JPanel();
        casilla16 = new javax.swing.JPanel();
        casilla17 = new javax.swing.JPanel();
        casilla18 = new javax.swing.JPanel();
        casilla19 = new javax.swing.JPanel();
        casilla20 = new javax.swing.JPanel();
        casilla21 = new javax.swing.JPanel();
        casilla22 = new javax.swing.JPanel();
        casilla23 = new javax.swing.JPanel();
        casilla24 = new javax.swing.JPanel();
        casilla25 = new javax.swing.JPanel();
        casilla26 = new javax.swing.JPanel();
        casilla27 = new javax.swing.JPanel();
        casilla28 = new javax.swing.JPanel();
        casilla29 = new javax.swing.JPanel();
        casilla30 = new javax.swing.JPanel();
        casilla31 = new javax.swing.JPanel();
        casilla32 = new javax.swing.JPanel();
        casilla33 = new javax.swing.JPanel();
        casilla34 = new javax.swing.JPanel();
        casilla35 = new javax.swing.JPanel();
        casilla36 = new javax.swing.JPanel();
        casilla37 = new javax.swing.JPanel();
        casilla38 = new javax.swing.JPanel();
        casilla39 = new javax.swing.JPanel();
        casilla40 = new javax.swing.JPanel();
        jbTirarDado = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtInfo = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        resultadoDado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setMinimumSize(new java.awt.Dimension(1024, 691));

        jPanel1.setBackground(new java.awt.Color(245, 245, 245));

        jPanel3.setBackground(new java.awt.Color(169, 223, 191));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Jugadores", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(93, 109, 126))); // NOI18N

        txtJugador1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtJugador1.setForeground(new java.awt.Color(128, 128, 128));
        txtJugador1.setText("Nombre J1");
        txtJugador1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtJugador1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtJugador1FocusLost(evt);
            }
        });

        txtJugador2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtJugador2.setForeground(new java.awt.Color(128, 128, 128));
        txtJugador2.setText("Nombre J2");
        txtJugador2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtJugador2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtJugador2FocusLost(evt);
            }
        });

        txtJugador3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtJugador3.setForeground(new java.awt.Color(128, 128, 128));
        txtJugador3.setText("Nombre J3");
        txtJugador3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtJugador3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtJugador3FocusLost(evt);
            }
        });

        txtJugador4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtJugador4.setForeground(new java.awt.Color(128, 128, 128));
        txtJugador4.setText("Nombre J4");
        txtJugador4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtJugador4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtJugador4FocusLost(evt);
            }
        });

        txtJugador5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtJugador5.setForeground(new java.awt.Color(128, 128, 128));
        txtJugador5.setText("Nombre J5");
        txtJugador5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtJugador5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtJugador5FocusLost(evt);
            }
        });

        txtJugador6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtJugador6.setForeground(new java.awt.Color(128, 128, 128));
        txtJugador6.setText("Nombre J6");
        txtJugador6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtJugador6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtJugador6FocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtJugador6, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtJugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtJugador3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtJugador4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtJugador5, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(txtJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtJugador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtJugador3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtJugador4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtJugador5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtJugador6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jbPlay.setBackground(new java.awt.Color(169, 204, 227));
        jbPlay.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jbPlay.setText("!A JUGAR!");
        jbPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPlayActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(169, 223, 191));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Configuración juego", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(93, 109, 126))); // NOI18N

        jLabel1.setText("Dinero inicial jugadores:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(startMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(startMoney, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbPlay))
                .addContainerGap(474, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbPlay))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(391, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab1", jPanel1);

        contenedorTablero.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        contenedorTablero.setPreferredSize(new java.awt.Dimension(500, 500));

        casilla1.setBackground(new java.awt.Color(255, 255, 255));
        casilla1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        casilla1.setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout casilla1Layout = new javax.swing.GroupLayout(casilla1);
        casilla1.setLayout(casilla1Layout);
        casilla1Layout.setHorizontalGroup(
            casilla1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
        );
        casilla1Layout.setVerticalGroup(
            casilla1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
        );

        casilla2.setBackground(new java.awt.Color(255, 255, 255));
        casilla2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        casilla2.setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout casilla2Layout = new javax.swing.GroupLayout(casilla2);
        casilla2.setLayout(casilla2Layout);
        casilla2Layout.setHorizontalGroup(
            casilla2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );
        casilla2Layout.setVerticalGroup(
            casilla2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
        );

        casilla3.setBackground(new java.awt.Color(255, 255, 255));
        casilla3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        casilla3.setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout casilla3Layout = new javax.swing.GroupLayout(casilla3);
        casilla3.setLayout(casilla3Layout);
        casilla3Layout.setHorizontalGroup(
            casilla3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );
        casilla3Layout.setVerticalGroup(
            casilla3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
        );

        casilla4.setBackground(new java.awt.Color(255, 255, 255));
        casilla4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        casilla4.setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout casilla4Layout = new javax.swing.GroupLayout(casilla4);
        casilla4.setLayout(casilla4Layout);
        casilla4Layout.setHorizontalGroup(
            casilla4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );
        casilla4Layout.setVerticalGroup(
            casilla4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
        );

        casilla5.setBackground(new java.awt.Color(255, 255, 255));
        casilla5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        casilla5.setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout casilla5Layout = new javax.swing.GroupLayout(casilla5);
        casilla5.setLayout(casilla5Layout);
        casilla5Layout.setHorizontalGroup(
            casilla5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );
        casilla5Layout.setVerticalGroup(
            casilla5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
        );

        casilla6.setBackground(new java.awt.Color(255, 255, 255));
        casilla6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        casilla6.setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout casilla6Layout = new javax.swing.GroupLayout(casilla6);
        casilla6.setLayout(casilla6Layout);
        casilla6Layout.setHorizontalGroup(
            casilla6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );
        casilla6Layout.setVerticalGroup(
            casilla6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
        );

        casilla7.setBackground(new java.awt.Color(255, 255, 255));
        casilla7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        casilla7.setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout casilla7Layout = new javax.swing.GroupLayout(casilla7);
        casilla7.setLayout(casilla7Layout);
        casilla7Layout.setHorizontalGroup(
            casilla7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );
        casilla7Layout.setVerticalGroup(
            casilla7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
        );

        casilla8.setBackground(new java.awt.Color(255, 255, 255));
        casilla8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        casilla8.setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout casilla8Layout = new javax.swing.GroupLayout(casilla8);
        casilla8.setLayout(casilla8Layout);
        casilla8Layout.setHorizontalGroup(
            casilla8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );
        casilla8Layout.setVerticalGroup(
            casilla8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
        );

        casilla9.setBackground(new java.awt.Color(255, 255, 255));
        casilla9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        casilla9.setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout casilla9Layout = new javax.swing.GroupLayout(casilla9);
        casilla9.setLayout(casilla9Layout);
        casilla9Layout.setHorizontalGroup(
            casilla9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );
        casilla9Layout.setVerticalGroup(
            casilla9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
        );

        casilla10.setBackground(new java.awt.Color(255, 255, 255));
        casilla10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        casilla10.setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout casilla10Layout = new javax.swing.GroupLayout(casilla10);
        casilla10.setLayout(casilla10Layout);
        casilla10Layout.setHorizontalGroup(
            casilla10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );
        casilla10Layout.setVerticalGroup(
            casilla10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
        );

        casilla11.setBackground(new java.awt.Color(255, 255, 255));
        casilla11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        casilla11.setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout casilla11Layout = new javax.swing.GroupLayout(casilla11);
        casilla11.setLayout(casilla11Layout);
        casilla11Layout.setHorizontalGroup(
            casilla11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
        );
        casilla11Layout.setVerticalGroup(
            casilla11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
        );

        casilla12.setBackground(new java.awt.Color(255, 255, 255));
        casilla12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        casilla12.setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout casilla12Layout = new javax.swing.GroupLayout(casilla12);
        casilla12.setLayout(casilla12Layout);
        casilla12Layout.setHorizontalGroup(
            casilla12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
        );
        casilla12Layout.setVerticalGroup(
            casilla12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );

        casilla13.setBackground(new java.awt.Color(255, 255, 255));
        casilla13.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        casilla13.setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout casilla13Layout = new javax.swing.GroupLayout(casilla13);
        casilla13.setLayout(casilla13Layout);
        casilla13Layout.setHorizontalGroup(
            casilla13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
        );
        casilla13Layout.setVerticalGroup(
            casilla13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );

        casilla14.setBackground(new java.awt.Color(255, 255, 255));
        casilla14.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        casilla14.setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout casilla14Layout = new javax.swing.GroupLayout(casilla14);
        casilla14.setLayout(casilla14Layout);
        casilla14Layout.setHorizontalGroup(
            casilla14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
        );
        casilla14Layout.setVerticalGroup(
            casilla14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );

        casilla15.setBackground(new java.awt.Color(255, 255, 255));
        casilla15.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        casilla15.setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout casilla15Layout = new javax.swing.GroupLayout(casilla15);
        casilla15.setLayout(casilla15Layout);
        casilla15Layout.setHorizontalGroup(
            casilla15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
        );
        casilla15Layout.setVerticalGroup(
            casilla15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );

        casilla16.setBackground(new java.awt.Color(255, 255, 255));
        casilla16.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        casilla16.setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout casilla16Layout = new javax.swing.GroupLayout(casilla16);
        casilla16.setLayout(casilla16Layout);
        casilla16Layout.setHorizontalGroup(
            casilla16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
        );
        casilla16Layout.setVerticalGroup(
            casilla16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );

        casilla17.setBackground(new java.awt.Color(255, 255, 255));
        casilla17.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        casilla17.setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout casilla17Layout = new javax.swing.GroupLayout(casilla17);
        casilla17.setLayout(casilla17Layout);
        casilla17Layout.setHorizontalGroup(
            casilla17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
        );
        casilla17Layout.setVerticalGroup(
            casilla17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );

        casilla18.setBackground(new java.awt.Color(255, 255, 255));
        casilla18.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        casilla18.setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout casilla18Layout = new javax.swing.GroupLayout(casilla18);
        casilla18.setLayout(casilla18Layout);
        casilla18Layout.setHorizontalGroup(
            casilla18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
        );
        casilla18Layout.setVerticalGroup(
            casilla18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );

        casilla19.setBackground(new java.awt.Color(255, 255, 255));
        casilla19.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        casilla19.setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout casilla19Layout = new javax.swing.GroupLayout(casilla19);
        casilla19.setLayout(casilla19Layout);
        casilla19Layout.setHorizontalGroup(
            casilla19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
        );
        casilla19Layout.setVerticalGroup(
            casilla19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );

        casilla20.setBackground(new java.awt.Color(255, 255, 255));
        casilla20.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        casilla20.setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout casilla20Layout = new javax.swing.GroupLayout(casilla20);
        casilla20.setLayout(casilla20Layout);
        casilla20Layout.setHorizontalGroup(
            casilla20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
        );
        casilla20Layout.setVerticalGroup(
            casilla20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );

        casilla21.setBackground(new java.awt.Color(255, 255, 255));
        casilla21.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        casilla21.setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout casilla21Layout = new javax.swing.GroupLayout(casilla21);
        casilla21.setLayout(casilla21Layout);
        casilla21Layout.setHorizontalGroup(
            casilla21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        casilla21Layout.setVerticalGroup(
            casilla21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
        );

        casilla22.setBackground(new java.awt.Color(255, 255, 255));
        casilla22.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        casilla22.setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout casilla22Layout = new javax.swing.GroupLayout(casilla22);
        casilla22.setLayout(casilla22Layout);
        casilla22Layout.setHorizontalGroup(
            casilla22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );
        casilla22Layout.setVerticalGroup(
            casilla22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
        );

        casilla23.setBackground(new java.awt.Color(255, 255, 255));
        casilla23.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        casilla23.setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout casilla23Layout = new javax.swing.GroupLayout(casilla23);
        casilla23.setLayout(casilla23Layout);
        casilla23Layout.setHorizontalGroup(
            casilla23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );
        casilla23Layout.setVerticalGroup(
            casilla23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
        );

        casilla24.setBackground(new java.awt.Color(255, 255, 255));
        casilla24.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        casilla24.setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout casilla24Layout = new javax.swing.GroupLayout(casilla24);
        casilla24.setLayout(casilla24Layout);
        casilla24Layout.setHorizontalGroup(
            casilla24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );
        casilla24Layout.setVerticalGroup(
            casilla24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
        );

        casilla25.setBackground(new java.awt.Color(255, 255, 255));
        casilla25.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        casilla25.setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout casilla25Layout = new javax.swing.GroupLayout(casilla25);
        casilla25.setLayout(casilla25Layout);
        casilla25Layout.setHorizontalGroup(
            casilla25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );
        casilla25Layout.setVerticalGroup(
            casilla25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
        );

        casilla26.setBackground(new java.awt.Color(255, 255, 255));
        casilla26.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        casilla26.setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout casilla26Layout = new javax.swing.GroupLayout(casilla26);
        casilla26.setLayout(casilla26Layout);
        casilla26Layout.setHorizontalGroup(
            casilla26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );
        casilla26Layout.setVerticalGroup(
            casilla26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
        );

        casilla27.setBackground(new java.awt.Color(255, 255, 255));
        casilla27.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        casilla27.setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout casilla27Layout = new javax.swing.GroupLayout(casilla27);
        casilla27.setLayout(casilla27Layout);
        casilla27Layout.setHorizontalGroup(
            casilla27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );
        casilla27Layout.setVerticalGroup(
            casilla27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
        );

        casilla28.setBackground(new java.awt.Color(255, 255, 255));
        casilla28.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        casilla28.setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout casilla28Layout = new javax.swing.GroupLayout(casilla28);
        casilla28.setLayout(casilla28Layout);
        casilla28Layout.setHorizontalGroup(
            casilla28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );
        casilla28Layout.setVerticalGroup(
            casilla28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
        );

        casilla29.setBackground(new java.awt.Color(255, 255, 255));
        casilla29.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        casilla29.setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout casilla29Layout = new javax.swing.GroupLayout(casilla29);
        casilla29.setLayout(casilla29Layout);
        casilla29Layout.setHorizontalGroup(
            casilla29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );
        casilla29Layout.setVerticalGroup(
            casilla29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
        );

        casilla30.setBackground(new java.awt.Color(255, 255, 255));
        casilla30.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        casilla30.setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout casilla30Layout = new javax.swing.GroupLayout(casilla30);
        casilla30.setLayout(casilla30Layout);
        casilla30Layout.setHorizontalGroup(
            casilla30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );
        casilla30Layout.setVerticalGroup(
            casilla30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
        );

        casilla31.setBackground(new java.awt.Color(255, 255, 255));
        casilla31.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        casilla31.setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout casilla31Layout = new javax.swing.GroupLayout(casilla31);
        casilla31.setLayout(casilla31Layout);
        casilla31Layout.setHorizontalGroup(
            casilla31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
        );
        casilla31Layout.setVerticalGroup(
            casilla31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
        );

        casilla32.setBackground(new java.awt.Color(255, 255, 255));
        casilla32.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        casilla32.setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout casilla32Layout = new javax.swing.GroupLayout(casilla32);
        casilla32.setLayout(casilla32Layout);
        casilla32Layout.setHorizontalGroup(
            casilla32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
        );
        casilla32Layout.setVerticalGroup(
            casilla32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );

        casilla33.setBackground(new java.awt.Color(255, 255, 255));
        casilla33.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        casilla33.setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout casilla33Layout = new javax.swing.GroupLayout(casilla33);
        casilla33.setLayout(casilla33Layout);
        casilla33Layout.setHorizontalGroup(
            casilla33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
        );
        casilla33Layout.setVerticalGroup(
            casilla33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );

        casilla34.setBackground(new java.awt.Color(255, 255, 255));
        casilla34.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        casilla34.setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout casilla34Layout = new javax.swing.GroupLayout(casilla34);
        casilla34.setLayout(casilla34Layout);
        casilla34Layout.setHorizontalGroup(
            casilla34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
        );
        casilla34Layout.setVerticalGroup(
            casilla34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );

        casilla35.setBackground(new java.awt.Color(255, 255, 255));
        casilla35.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        casilla35.setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout casilla35Layout = new javax.swing.GroupLayout(casilla35);
        casilla35.setLayout(casilla35Layout);
        casilla35Layout.setHorizontalGroup(
            casilla35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
        );
        casilla35Layout.setVerticalGroup(
            casilla35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );

        casilla36.setBackground(new java.awt.Color(255, 255, 255));
        casilla36.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        casilla36.setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout casilla36Layout = new javax.swing.GroupLayout(casilla36);
        casilla36.setLayout(casilla36Layout);
        casilla36Layout.setHorizontalGroup(
            casilla36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
        );
        casilla36Layout.setVerticalGroup(
            casilla36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );

        casilla37.setBackground(new java.awt.Color(255, 255, 255));
        casilla37.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        casilla37.setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout casilla37Layout = new javax.swing.GroupLayout(casilla37);
        casilla37.setLayout(casilla37Layout);
        casilla37Layout.setHorizontalGroup(
            casilla37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
        );
        casilla37Layout.setVerticalGroup(
            casilla37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );

        casilla38.setBackground(new java.awt.Color(255, 255, 255));
        casilla38.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        casilla38.setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout casilla38Layout = new javax.swing.GroupLayout(casilla38);
        casilla38.setLayout(casilla38Layout);
        casilla38Layout.setHorizontalGroup(
            casilla38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
        );
        casilla38Layout.setVerticalGroup(
            casilla38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );

        casilla39.setBackground(new java.awt.Color(255, 255, 255));
        casilla39.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        casilla39.setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout casilla39Layout = new javax.swing.GroupLayout(casilla39);
        casilla39.setLayout(casilla39Layout);
        casilla39Layout.setHorizontalGroup(
            casilla39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
        );
        casilla39Layout.setVerticalGroup(
            casilla39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );

        casilla40.setBackground(new java.awt.Color(255, 255, 255));
        casilla40.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        casilla40.setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout casilla40Layout = new javax.swing.GroupLayout(casilla40);
        casilla40.setLayout(casilla40Layout);
        casilla40Layout.setHorizontalGroup(
            casilla40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
        );
        casilla40Layout.setVerticalGroup(
            casilla40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout contenedorTableroLayout = new javax.swing.GroupLayout(contenedorTablero);
        contenedorTablero.setLayout(contenedorTableroLayout);
        contenedorTableroLayout.setHorizontalGroup(
            contenedorTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorTableroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contenedorTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(casilla13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(contenedorTableroLayout.createSequentialGroup()
                        .addGroup(contenedorTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(casilla18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(contenedorTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(contenedorTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(casilla11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(casilla21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(casilla12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(casilla14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(casilla15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(casilla16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(casilla17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(contenedorTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(contenedorTableroLayout.createSequentialGroup()
                                .addComponent(casilla22, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(casilla23, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(casilla24, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(casilla25, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(casilla26, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(casilla27, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(casilla28, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(casilla29, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(casilla30, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(contenedorTableroLayout.createSequentialGroup()
                                .addComponent(casilla10, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contenedorTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(contenedorTableroLayout.createSequentialGroup()
                                        .addComponent(casilla9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(casilla8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(57, 57, 57)
                                        .addComponent(casilla6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(casilla5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(casilla4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(casilla3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(contenedorTableroLayout.createSequentialGroup()
                                        .addGap(102, 102, 102)
                                        .addComponent(casilla7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(210, 210, 210)
                                        .addComponent(casilla2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addComponent(casilla19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(casilla20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(contenedorTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenedorTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(casilla36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(casilla35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(casilla33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(casilla32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(casilla34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(casilla1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(casilla31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(casilla37, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(casilla38, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(casilla39, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(casilla40, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        contenedorTableroLayout.setVerticalGroup(
            contenedorTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorTableroLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(contenedorTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contenedorTableroLayout.createSequentialGroup()
                        .addComponent(casilla21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(casilla20, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(casilla19, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(casilla18, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(casilla17, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(casilla16, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(casilla15, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(casilla14, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(casilla13, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(casilla12, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(casilla11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(contenedorTableroLayout.createSequentialGroup()
                        .addGroup(contenedorTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(casilla31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(casilla23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(casilla22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(casilla25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(casilla24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(casilla27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(casilla26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(casilla28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(casilla29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(casilla30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(contenedorTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contenedorTableroLayout.createSequentialGroup()
                                .addComponent(casilla32, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(casilla33, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(casilla34, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(casilla35, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(casilla36, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(casilla37, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(casilla38, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(casilla39, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(casilla40, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contenedorTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(casilla1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(contenedorTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(casilla9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenedorTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(casilla8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(casilla5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(casilla6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(casilla3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(casilla4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(casilla2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(casilla7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(contenedorTableroLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(casilla10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );

        jbTirarDado.setBackground(new java.awt.Color(169, 204, 227));
        jbTirarDado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jbTirarDado.setText("Tirar dado");
        jbTirarDado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbTirarDadoActionPerformed(evt);
            }
        });

        txtInfo.setEditable(false);
        txtInfo.setColumns(20);
        txtInfo.setRows(5);
        txtInfo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane1.setViewportView(txtInfo);

        jButton1.setBackground(new java.awt.Color(169, 204, 227));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("Volver a configuración");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        resultadoDado.setBackground(new java.awt.Color(255, 255, 255));
        resultadoDado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        resultadoDado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        resultadoDado.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(contenedorTablero, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbTirarDado, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(resultadoDado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbTirarDado, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(resultadoDado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(contenedorTablero, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab2", jPanel2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -35, -1, 750));

        setBounds(0, 0, 1039, 716);
    }// </editor-fold>//GEN-END:initComponents

    private void jbTirarDadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbTirarDadoActionPerformed
        
        tablero.moverJugador(jugadoresList, casillasP, jbTirarDado, txtInfo, casillasArrayList, resultadoDado);
        jbTirarDado.setEnabled(false);
        
    }//GEN-LAST:event_jbTirarDadoActionPerformed

    private void txtJugador1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtJugador1FocusLost
        
        if (txtJugador1.getText().trim().equals("")) {
            txtJugador1.setText("Nombre J1");
            txtJugador1.setForeground(Color.GRAY);
        }
        
    }//GEN-LAST:event_txtJugador1FocusLost

    private void txtJugador1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtJugador1FocusGained
        
        if (txtJugador1.getText().equals("Nombre J1")) {
            txtJugador1.setText("");
            txtJugador1.setForeground(Color.BLACK);
        }
        
    }//GEN-LAST:event_txtJugador1FocusGained

    private void txtJugador2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtJugador2FocusLost
        
        if (txtJugador2.getText().trim().equals("")) {
            txtJugador2.setText("Nombre J2");
            txtJugador2.setForeground(Color.GRAY);
        }
        
    }//GEN-LAST:event_txtJugador2FocusLost

    private void txtJugador2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtJugador2FocusGained
        
        if (txtJugador2.getText().equals("Nombre J2")) {
            txtJugador2.setText("");
            txtJugador2.setForeground(Color.BLACK);
        }
        
    }//GEN-LAST:event_txtJugador2FocusGained

    private void txtJugador3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtJugador3FocusLost
        
        if (txtJugador3.getText().trim().equals("")) {
            txtJugador3.setText("Nombre J3");
            txtJugador3.setForeground(Color.GRAY);
        }
        
    }//GEN-LAST:event_txtJugador3FocusLost

    private void txtJugador3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtJugador3FocusGained
        
        if (txtJugador3.getText().equals("Nombre J3")) {
            txtJugador3.setText("");
            txtJugador3.setForeground(Color.BLACK);
        }
        
    }//GEN-LAST:event_txtJugador3FocusGained

    private void txtJugador4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtJugador4FocusLost
        
        if (txtJugador4.getText().trim().equals("")) {
            txtJugador4.setText("Nombre J4");
            txtJugador4.setForeground(Color.GRAY);
        }
        
    }//GEN-LAST:event_txtJugador4FocusLost

    private void txtJugador4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtJugador4FocusGained
        
        if (txtJugador4.getText().equals("Nombre J4")) {
            txtJugador4.setText("");
            txtJugador4.setForeground(Color.BLACK);
        }
        
    }//GEN-LAST:event_txtJugador4FocusGained

    private void txtJugador5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtJugador5FocusLost

        if (txtJugador5.getText().trim().equals("")) {
            txtJugador5.setText("Nombre J5");
            txtJugador5.setForeground(Color.GRAY);
        }

    }//GEN-LAST:event_txtJugador5FocusLost

    private void txtJugador5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtJugador5FocusGained
        
        if (txtJugador5.getText().equals("Nombre J5")) {
            txtJugador5.setText("");
            txtJugador5.setForeground(Color.BLACK);
        }
        
    }//GEN-LAST:event_txtJugador5FocusGained

    private void txtJugador6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtJugador6FocusLost
        
        if (txtJugador6.getText().trim().equals("")) {
            txtJugador6.setText("Nombre J6");
            txtJugador6.setForeground(Color.GRAY);
        }
        
    }//GEN-LAST:event_txtJugador6FocusLost

    private void txtJugador6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtJugador6FocusGained
        
        if (txtJugador6.getText().equals("Nombre J6")) {
            txtJugador6.setText("");
            txtJugador6.setForeground(Color.BLACK);
        }
        
    }//GEN-LAST:event_txtJugador6FocusGained

    private void jbPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPlayActionPerformed
        
        ArrayList<Propiedad> propiedadesJ1 = new ArrayList<>();
        ArrayList<Propiedad> propiedadesJ2 = new ArrayList<>();
        ArrayList<Propiedad> propiedadesJ3 = new ArrayList<>();
        ArrayList<Propiedad> propiedadesJ4 = new ArrayList<>();
        ArrayList<Propiedad> propiedadesJ5 = new ArrayList<>();
        ArrayList<Propiedad> propiedadesJ6 = new ArrayList<>();

        int dineroInicial;
        
        Propiedad AvenidaMediterraneo = new Propiedad("Avenida Mediterraneo", 200, 100, null);
        Propiedad AvenidaBaltica = new Propiedad("Avenida Báltica", 200, 100, null);
        Propiedad AvenidaOriente = new Propiedad("Avenida Oriente", 200, 100, null);
        Propiedad AvenidaVermont = new Propiedad("Avenida Vermont", 200, 100, null);
        Propiedad AvenidaConnecticut = new Propiedad("Avenida Connecticut", 200, 100, null);
        Propiedad PlazaSanCarlos = new Propiedad("Plaza San Carlos", 200, 100, null);
        Propiedad AvenidaEstados = new Propiedad("Avenida de los Estados", 200, 100, null);
        Propiedad AvenidaVirginia = new Propiedad("Avenida Virginia", 200, 100, null);
        Propiedad PlazaSanJames = new Propiedad("Plaza San James", 200, 100, null);
        Propiedad AvenidaTennessee = new Propiedad("Avenida Tennessee", 200, 100, null);
        Propiedad AvenidaNuevaYork = new Propiedad("Avenida Nueva York", 200, 100, null);
        Propiedad AvenidaKentucky = new Propiedad("Avenida Kentucky", 200, 100, null);
        Propiedad PlazaIndiana = new Propiedad("Plaza Indiana", 200, 100, null);
        Propiedad AvenidaIllinois = new Propiedad("Avenida Illinois", 200, 100, null);
        Propiedad AvenidaAtlantico = new Propiedad("Avenida Atlantico", 200, 100, null);
        Propiedad AvenidaVentnor = new Propiedad("Avenida Ventnor", 200, 100, null);
        Propiedad PlazaMarvin = new Propiedad("Plaza Marvin", 200, 100, null);
        Propiedad AvenidaPacifico = new Propiedad("Avenida Pacifico", 200, 100, null);
        Propiedad AvenidaCarolina = new Propiedad("Avenida Carolina del Norte", 200, 100, null);
        Propiedad AvenidaPennsylvania = new Propiedad("Avenida Pennsylvania", 200, 100, null);
        Propiedad PaseoTennessee = new Propiedad("Paseo Tiempos", 200, 100, null);
        Propiedad PaseoTacoma = new Propiedad("Paseo Tacoman", 200, 100, null);
        Propiedad PaseoRichmond = new Propiedad("Paseo Richmond", 200, 100, null);
        
        Casilla casilla1p = new Casilla(casilla1, "Salida", null);
        Casilla casilla2p = new Casilla(casilla2, AvenidaMediterraneo.getNombre(), AvenidaMediterraneo);
        Casilla casilla3p = new Casilla(casilla3, "Arca Comunal", null);
        Casilla casilla4p = new Casilla(casilla4, AvenidaBaltica.getNombre(), AvenidaBaltica);
        Casilla casilla5p = new Casilla(casilla5, "Impuesto sobre el Ingreso", null);
        Casilla casilla6p = new Casilla(casilla6, "Ferrocarril Reading", null);
        Casilla casilla7p = new Casilla(casilla7, AvenidaOriente.getNombre(), AvenidaOriente);
        Casilla casilla8p = new Casilla(casilla8, "Casualidad", null);
        Casilla casilla9p = new Casilla(casilla9, AvenidaVermont.getNombre(), AvenidaVermont);
        Casilla casilla10p = new Casilla(casilla10, AvenidaConnecticut.getNombre(), AvenidaConnecticut);
        Casilla casilla11p = new Casilla(casilla11, "Cárcel / Visita", null);
        Casilla casilla12p = new Casilla(casilla12, PlazaSanCarlos.getNombre(), PlazaSanCarlos);
        Casilla casilla13p = new Casilla(casilla13, "Compañía Eléctrica", null);
        Casilla casilla14p = new Casilla(casilla14, AvenidaEstados.getNombre(), AvenidaEstados);
        Casilla casilla15p = new Casilla(casilla15, AvenidaVirginia.getNombre(), AvenidaVirginia);
        Casilla casilla16p = new Casilla(casilla16, "Ferrocarril Pennsylvania", null);
        Casilla casilla17p = new Casilla(casilla17, PlazaSanJames.getNombre(), PlazaSanJames);
        Casilla casilla18p = new Casilla(casilla18, "Arca Comunal", null);
        Casilla casilla19p = new Casilla(casilla19, AvenidaTennessee.getNombre(), AvenidaTennessee);
        Casilla casilla20p = new Casilla(casilla20, AvenidaNuevaYork.getNombre(), AvenidaNuevaYork);
        Casilla casilla21p = new Casilla(casilla21, "Estacionamiento Gratuito", null);
        Casilla casilla22p = new Casilla(casilla22, AvenidaKentucky.getNombre(), AvenidaKentucky);
        Casilla casilla23p = new Casilla(casilla23, "Casualidad", null);
        Casilla casilla24p = new Casilla(casilla24, PlazaIndiana.getNombre(), PlazaIndiana);
        Casilla casilla25p = new Casilla(casilla25, AvenidaIllinois.getNombre(), AvenidaIllinois);
        Casilla casilla26p = new Casilla(casilla26, "Ferrocarril B&O", null);
        Casilla casilla27p = new Casilla(casilla27, AvenidaAtlantico.getNombre(), AvenidaAtlantico);
        Casilla casilla28p = new Casilla(casilla28, AvenidaVentnor.getNombre(), AvenidaVentnor);
        Casilla casilla29p = new Casilla(casilla29, "Compañía de Agua", null);
        Casilla casilla30p = new Casilla(casilla30, PlazaMarvin.getNombre(), PlazaMarvin);
        Casilla casilla31p = new Casilla(casilla31, "Ir a la Cárcel", null);
        Casilla casilla32p = new Casilla(casilla32, AvenidaPacifico.getNombre(), AvenidaPacifico);
        Casilla casilla33p = new Casilla(casilla33, AvenidaCarolina.getNombre(), AvenidaCarolina);
        Casilla casilla34p = new Casilla(casilla34, "Arca Comunal", null);
        Casilla casilla35p = new Casilla(casilla35, AvenidaPennsylvania.getNombre(), AvenidaPennsylvania);
        Casilla casilla36p = new Casilla(casilla36, "Ferrocarril Short Line", null);
        Casilla casilla37p = new Casilla(casilla37, PaseoTennessee.getNombre(), PaseoTennessee);
        Casilla casilla38p = new Casilla(casilla38, "Casualidad", null);
        Casilla casilla39p = new Casilla(casilla39, PaseoTacoma.getNombre(), PaseoTacoma);
        Casilla casilla40p = new Casilla(casilla40, PaseoRichmond.getNombre(), PaseoRichmond);
        
        casillasArrayList.add(casilla1p);
        casillasArrayList.add(casilla2p);
        casillasArrayList.add(casilla3p);
        casillasArrayList.add(casilla4p);
        casillasArrayList.add(casilla5p);
        casillasArrayList.add(casilla6p);
        casillasArrayList.add(casilla7p);
        casillasArrayList.add(casilla8p);
        casillasArrayList.add(casilla9p);
        casillasArrayList.add(casilla10p);
        casillasArrayList.add(casilla11p);
        casillasArrayList.add(casilla12p);
        casillasArrayList.add(casilla13p);
        casillasArrayList.add(casilla14p);
        casillasArrayList.add(casilla15p);
        casillasArrayList.add(casilla16p);
        casillasArrayList.add(casilla17p);
        casillasArrayList.add(casilla18p);
        casillasArrayList.add(casilla19p);
        casillasArrayList.add(casilla20p);
        casillasArrayList.add(casilla21p);
        casillasArrayList.add(casilla22p);
        casillasArrayList.add(casilla23p);
        casillasArrayList.add(casilla24p);
        casillasArrayList.add(casilla25p);
        casillasArrayList.add(casilla26p);
        casillasArrayList.add(casilla27p);
        casillasArrayList.add(casilla28p);
        casillasArrayList.add(casilla29p);
        casillasArrayList.add(casilla30p);
        casillasArrayList.add(casilla31p);
        casillasArrayList.add(casilla32p);
        casillasArrayList.add(casilla33p);
        casillasArrayList.add(casilla34p);
        casillasArrayList.add(casilla35p);
        casillasArrayList.add(casilla36p);
        casillasArrayList.add(casilla37p);
        casillasArrayList.add(casilla38p);
        casillasArrayList.add(casilla39p);
        casillasArrayList.add(casilla40p);
        
        try {
            dineroInicial = Integer.parseInt(startMoney.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido para el dinero inicial.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!txtJugador1.getText().trim().equals("") && !txtJugador1.getText().trim().equals("Nombre J1")) {
            Jugador jugador1 = new Jugador(txtJugador1.getText().trim(), dineroInicial, propiedadesJ1, jpJugador1);
            jugador1.agregarFichaAJugador(casilla1, Color.RED);
            jugadoresList.add(jugador1);
        }
        if (!txtJugador2.getText().trim().equals("") && !txtJugador2.getText().trim().equals("Nombre J2")) {
            Jugador jugador2 = new Jugador(txtJugador2.getText().trim(), dineroInicial, propiedadesJ2, jpJugador2);
            jugador2.agregarFichaAJugador(casilla1, Color.BLUE);
            jugadoresList.add(jugador2);
        }
        if (!txtJugador3.getText().trim().equals("") && !txtJugador3.getText().trim().equals("Nombre J3")) {
            Jugador jugador3 = new Jugador(txtJugador3.getText().trim(), dineroInicial, propiedadesJ3, jpJugador3);
            jugador3.agregarFichaAJugador(casilla1, Color.GREEN);
            jugadoresList.add(jugador3);
        }
        if (!txtJugador4.getText().trim().equals("") && !txtJugador4.getText().trim().equals("Nombre J4")) {
            Jugador jugador4 = new Jugador(txtJugador4.getText().trim(), dineroInicial, propiedadesJ4, jpJugador4);
            jugador4.agregarFichaAJugador(casilla1, Color.YELLOW);
            jugadoresList.add(jugador4);
        }
        if (!txtJugador5.getText().trim().equals("") && !txtJugador5.getText().trim().equals("Nombre J5")) {
            Jugador jugador5 = new Jugador(txtJugador5.getText().trim(), dineroInicial, propiedadesJ5, jpJugador5);
            jugador5.agregarFichaAJugador(casilla1, Color.ORANGE);
            jugadoresList.add(jugador5);
        }
        if (!txtJugador6.getText().trim().equals("") && !txtJugador6.getText().trim().equals("Nombre J6")) {
            Jugador jugador6 = new Jugador(txtJugador6.getText().trim(), dineroInicial, propiedadesJ6, jpJugador6);
            jugador6.agregarFichaAJugador(casilla1, Color.MAGENTA);
            jugadoresList.add(jugador6);
        }

        if (jugadoresList.size() >= 2) {
            
            tablero.setCasillas(casillasArrayList);
            tablero.imprimirJugadoresCasillas(jugadoresList, txtInfo, casillasArrayList);
            jTabbedPane1.setSelectedIndex(1);
            txtJugador1.setText("Nombre J1");
            txtJugador2.setText("Nombre J2");
            txtJugador3.setText("Nombre J3");
            txtJugador4.setText("Nombre J4");
            txtJugador5.setText("Nombre J5");
            txtJugador6.setText("Nombre J6");
            startMoney.setText("");
            
        } else {
            JOptionPane.showMessageDialog(null, "Mínimo deben ser 2 participantes para jugar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_jbPlayActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        jTabbedPane1.setSelectedIndex(0);
        tablero.reiniciarJuego(jugadoresList, casillasArrayList, txtInfo);
        
    }//GEN-LAST:event_jButton1ActionPerformed
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new monopoli().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel casilla1;
    private javax.swing.JPanel casilla10;
    private javax.swing.JPanel casilla11;
    private javax.swing.JPanel casilla12;
    private javax.swing.JPanel casilla13;
    private javax.swing.JPanel casilla14;
    private javax.swing.JPanel casilla15;
    private javax.swing.JPanel casilla16;
    private javax.swing.JPanel casilla17;
    private javax.swing.JPanel casilla18;
    private javax.swing.JPanel casilla19;
    private javax.swing.JPanel casilla2;
    private javax.swing.JPanel casilla20;
    private javax.swing.JPanel casilla21;
    private javax.swing.JPanel casilla22;
    private javax.swing.JPanel casilla23;
    private javax.swing.JPanel casilla24;
    private javax.swing.JPanel casilla25;
    private javax.swing.JPanel casilla26;
    private javax.swing.JPanel casilla27;
    private javax.swing.JPanel casilla28;
    private javax.swing.JPanel casilla29;
    private javax.swing.JPanel casilla3;
    private javax.swing.JPanel casilla30;
    private javax.swing.JPanel casilla31;
    private javax.swing.JPanel casilla32;
    private javax.swing.JPanel casilla33;
    private javax.swing.JPanel casilla34;
    private javax.swing.JPanel casilla35;
    private javax.swing.JPanel casilla36;
    private javax.swing.JPanel casilla37;
    private javax.swing.JPanel casilla38;
    private javax.swing.JPanel casilla39;
    private javax.swing.JPanel casilla4;
    private javax.swing.JPanel casilla40;
    private javax.swing.JPanel casilla5;
    private javax.swing.JPanel casilla6;
    private javax.swing.JPanel casilla7;
    private javax.swing.JPanel casilla8;
    private javax.swing.JPanel casilla9;
    private javax.swing.JPanel contenedorTablero;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbPlay;
    private javax.swing.JButton jbTirarDado;
    private javax.swing.JLabel resultadoDado;
    private javax.swing.JTextField startMoney;
    private javax.swing.JTextArea txtInfo;
    private javax.swing.JTextField txtJugador1;
    private javax.swing.JTextField txtJugador2;
    private javax.swing.JTextField txtJugador3;
    private javax.swing.JTextField txtJugador4;
    private javax.swing.JTextField txtJugador5;
    private javax.swing.JTextField txtJugador6;
    // End of variables declaration//GEN-END:variables
}