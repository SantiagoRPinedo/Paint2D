/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint2d;

import java.awt.BasicStroke;
import static java.awt.BasicStroke.CAP_BUTT;
import static java.awt.BasicStroke.CAP_ROUND;
import static java.awt.BasicStroke.JOIN_MITER;
import java.awt.Color;
import static java.awt.Color.WHITE;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.QuadCurve2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.Vector;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static paint2d.JavaDraw2DPanel.ARC2D;
import static paint2d.JavaDraw2DPanel.CUBICCURVE2D;
import static paint2d.JavaDraw2DPanel.ELLIPSE2D;
import static paint2d.JavaDraw2DPanel.LINE2D;
import static paint2d.JavaDraw2DPanel.POLYGON;
import static paint2d.JavaDraw2DPanel.QUADCURVE2D;
import static paint2d.JavaDraw2DPanel.RECTANGLE;
import static paint2d.JavaDraw2DPanel.ROUNDRECTANGLE2D;
import paint2d.MisFiguras.Corazon;
import paint2d.MisFiguras.CorazonInvertido;
import paint2d.MisFiguras.DobleT;
import paint2d.MisFiguras.Dodecagrama;
import paint2d.MisFiguras.Estrella;
import paint2d.MisFiguras.Flash;
import paint2d.MisFiguras.PezAmorfo;
import paint2d.MisFiguras.Casita;
import paint2d.MisFiguras.Cubo;
import paint2d.MisFiguras.Flecha;

/**
 *
 * @author pollu
 */
public class Paint2D extends javax.swing.JFrame implements MouseListener, MouseMotionListener{
    public static Color color = new Color(0,0,0);
    public static Graphics2D g;
    public static Shape shape;
    Shape partialShape = null;
    public int SelectF = 0; //(el rectangolo esta seleccionado por defecto)
    public boolean Area = false;
    DobleT Doblet = new DobleT();
    int lados=3;
    Dodecagrama Dodeca = new Dodecagrama();
    Estrella Estrella = new Estrella();
    //TIPOS DE SOMBRA PARA EL PINCEL
    static final int RECTANGLE = 0;
    static final int ROUNDRECTANGLE2D = 1;
    static final int ELLIPSE2D = 2;
    static final int ARC2D = 3;
    static final int LINE2D = 4;
    static final int QUADCURVE2D = 5;
    static final int CUBICCURVE2D = 6;
    static final int POLYGON = 7;
    static final int GENERAL = 8;
    static final int AREA = 9;
    static final int FREE = 10;
    static final int CORAZON = 11;
    static final int CORAZONI = 12;
    static final int DOBLET = 13;
    static final int DODECAGRAMA = 14;
    static final int ESTRELLA = 15;
    static final int PEZAMORFO = 16;
    static final int FLASH = 17;
    static final int CASA =18;
    static final int FLECHA = 19;
    static final int CUBO = 20 ;
    //SOMBRA PREDEFINIDA
    int shapeType = RECTANGLE;
    //VECTORES PARA GUARDAR PUNTOS Y LOS DIBUJOS
    private Vector shapes = new Vector();
    public Vector points = new Vector();
    public int pointIndex = 0;
    public Point p = null;
    //ICONOS DE LOS BOTONES
    ImageIcon icon1 = new ImageIcon("src/Imagenes/Cuadrado.png");
    ImageIcon icon2 = new ImageIcon("src/Imagenes/Cubica.png");
    ImageIcon icon3 = new ImageIcon("src/Imagenes/Arco.png");
    ImageIcon icon4 = new ImageIcon("src/Imagenes/Cuadrada.png");
    ImageIcon icon5 = new ImageIcon("src/Imagenes/Linea.png");
    ImageIcon icon6 = new ImageIcon("src/Imagenes/Poligono.png");
    ImageIcon icon7 = new ImageIcon("src/Imagenes/Redondeado.png");
    ImageIcon icon8 = new ImageIcon("src/Imagenes/Elipse.png");
    ImageIcon icon9 = new ImageIcon("src/Imagenes/estrella.png");
    ImageIcon icon10 = new ImageIcon("src/Imagenes/cocoro.png");
    ImageIcon icon11 = new ImageIcon("src/Imagenes/flash.png");
    ImageIcon icon12 = new ImageIcon("src/Imagenes/flecha.png");
    //SROKE (GROSOR DE FIGURAS)
        Stroke s = new BasicStroke(1);
    
      /**
     * Creates new form Paint2D
     */
    public Paint2D() {
        
        addMouseListener(this);
        addMouseMotionListener(this);
        
        initComponents();
        
        pnlPaint.setBackground(WHITE);
        btnRectangulo.setIcon(icon1);
        btnCubica.setIcon(icon2);
        btnArco.setIcon(icon3);
        btnCuadrada.setIcon(icon4);
        btnLinea.setIcon(icon5);
        btnPoligono.setIcon(icon6);
        btnRedondeado.setIcon(icon7);
        btnElipse.setIcon(icon8);
        btnEstrella.setIcon(icon9);
        btnCocoro.setIcon(icon10);
        btnFlash.setIcon(icon11);
        btnFlecha.setIcon(icon12);
        this.setExtendedState(MAXIMIZED_BOTH);
        
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jColorChooser1 = new javax.swing.JColorChooser();
        pnlPaint = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnNegro = new javax.swing.JButton();
        btnGris = new javax.swing.JButton();
        btnBlanco = new javax.swing.JButton();
        btnGrisecito = new javax.swing.JButton();
        btnVino = new javax.swing.JButton();
        btnVinito = new javax.swing.JButton();
        btnAzul = new javax.swing.JButton();
        btnAzulito = new javax.swing.JButton();
        btnNaranja = new javax.swing.JButton();
        btnVerde = new javax.swing.JButton();
        btnVerdecito = new javax.swing.JButton();
        btnNaranjita = new javax.swing.JButton();
        btnMorado = new javax.swing.JButton();
        btnMoradito = new javax.swing.JButton();
        btnRosa = new javax.swing.JButton();
        btnRosita = new javax.swing.JButton();
        btnAmarillo = new javax.swing.JButton();
        btnAmarillito = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        btnLienzo = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnRectangulo = new javax.swing.JButton();
        btnElipse = new javax.swing.JButton();
        btnArco = new javax.swing.JButton();
        btnCubica = new javax.swing.JButton();
        btnCuadrada = new javax.swing.JButton();
        btnLinea = new javax.swing.JButton();
        btnPoligono = new javax.swing.JButton();
        btnRedondeado = new javax.swing.JButton();
        btnEstrella = new javax.swing.JButton();
        btnCocoro = new javax.swing.JButton();
        btnFlash = new javax.swing.JButton();
        btnFlecha = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnLapiz = new javax.swing.JButton();
        btnBorrador = new javax.swing.JButton();
        spiner = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnArea = new javax.swing.JButton();
        btnPunteada = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        meArch = new javax.swing.JMenu();
        meCar1 = new javax.swing.JMenu();
        meH2D = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        SmeRec = new javax.swing.JMenuItem();
        SmeRecRed = new javax.swing.JMenuItem();
        SmeEli = new javax.swing.JMenuItem();
        SmeArc = new javax.swing.JMenuItem();
        SmeLin = new javax.swing.JMenuItem();
        SmeCur = new javax.swing.JMenuItem();
        SmePol = new javax.swing.JMenuItem();
        SmeCurC = new javax.swing.JMenuItem();
        meCar2 = new javax.swing.JMenu();
        meH2DM = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        meRecM = new javax.swing.JMenuItem();
        meRecRM = new javax.swing.JMenuItem();
        meEliM = new javax.swing.JMenuItem();
        meArcM = new javax.swing.JMenuItem();
        meLinM = new javax.swing.JMenuItem();
        meCurM = new javax.swing.JMenuItem();
        mePolM = new javax.swing.JMenuItem();
        meCurCM = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        menOBJ1 = new javax.swing.JMenuItem();
        menOBJ2 = new javax.swing.JMenuItem();
        menOBJ3 = new javax.swing.JMenuItem();
        menOBJ4 = new javax.swing.JMenuItem();
        menOBJ5 = new javax.swing.JMenuItem();
        menOBJ6 = new javax.swing.JMenuItem();
        menOBJ7 = new javax.swing.JMenuItem();
        menOBJ8 = new javax.swing.JMenuItem();
        menOBJ9 = new javax.swing.JMenuItem();
        menOBJ10 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        menObj = new javax.swing.JMenu();
        menRec = new javax.swing.JMenuItem();
        menRecRed = new javax.swing.JMenuItem();
        menElipse = new javax.swing.JMenuItem();
        menArc = new javax.swing.JMenuItem();
        menLin = new javax.swing.JMenuItem();
        menCur = new javax.swing.JMenuItem();
        menPol = new javax.swing.JMenuItem();
        menCurCu = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        btnDode = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        btnPez = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        btnCubo = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jColorChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-32686, -32770, 613, 327));

        pnlPaint.setBorder(javax.swing.BorderFactory.createTitledBorder("Area de Dibujo"));
        pnlPaint.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout pnlPaintLayout = new javax.swing.GroupLayout(pnlPaint);
        pnlPaint.setLayout(pnlPaintLayout);
        pnlPaintLayout.setHorizontalGroup(
            pnlPaintLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1358, Short.MAX_VALUE)
        );
        pnlPaintLayout.setVerticalGroup(
            pnlPaintLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 498, Short.MAX_VALUE)
        );

        getContentPane().add(pnlPaint, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 1370, 520));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Colores"));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("color de pincel");

        btnNegro.setBackground(new java.awt.Color(0, 0, 0));
        btnNegro.setBorderPainted(false);
        btnNegro.setPreferredSize(new java.awt.Dimension(25, 25));
        btnNegro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNegroActionPerformed(evt);
            }
        });

        btnGris.setBackground(new java.awt.Color(102, 102, 102));
        btnGris.setBorderPainted(false);
        btnGris.setPreferredSize(new java.awt.Dimension(25, 25));
        btnGris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrisActionPerformed(evt);
            }
        });

        btnBlanco.setBackground(new java.awt.Color(255, 255, 255));
        btnBlanco.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnBlanco.setBorderPainted(false);
        btnBlanco.setPreferredSize(new java.awt.Dimension(25, 25));
        btnBlanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBlancoActionPerformed(evt);
            }
        });

        btnGrisecito.setBackground(new java.awt.Color(204, 204, 204));
        btnGrisecito.setBorderPainted(false);
        btnGrisecito.setPreferredSize(new java.awt.Dimension(25, 25));
        btnGrisecito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrisecitoActionPerformed(evt);
            }
        });

        btnVino.setBackground(new java.awt.Color(153, 0, 0));
        btnVino.setBorderPainted(false);
        btnVino.setPreferredSize(new java.awt.Dimension(25, 25));
        btnVino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVinoActionPerformed(evt);
            }
        });

        btnVinito.setBackground(new java.awt.Color(255, 102, 102));
        btnVinito.setBorderPainted(false);
        btnVinito.setPreferredSize(new java.awt.Dimension(25, 25));
        btnVinito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVinitoActionPerformed(evt);
            }
        });

        btnAzul.setBackground(new java.awt.Color(0, 0, 153));
        btnAzul.setBorderPainted(false);
        btnAzul.setPreferredSize(new java.awt.Dimension(25, 25));
        btnAzul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAzulActionPerformed(evt);
            }
        });

        btnAzulito.setBackground(new java.awt.Color(102, 102, 255));
        btnAzulito.setBorderPainted(false);
        btnAzulito.setPreferredSize(new java.awt.Dimension(25, 25));
        btnAzulito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAzulitoActionPerformed(evt);
            }
        });

        btnNaranja.setBackground(new java.awt.Color(255, 51, 0));
        btnNaranja.setBorderPainted(false);
        btnNaranja.setPreferredSize(new java.awt.Dimension(25, 25));
        btnNaranja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNaranjaActionPerformed(evt);
            }
        });

        btnVerde.setBackground(new java.awt.Color(0, 153, 0));
        btnVerde.setBorderPainted(false);
        btnVerde.setPreferredSize(new java.awt.Dimension(25, 25));
        btnVerde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerdeActionPerformed(evt);
            }
        });

        btnVerdecito.setBackground(new java.awt.Color(153, 255, 51));
        btnVerdecito.setBorderPainted(false);
        btnVerdecito.setPreferredSize(new java.awt.Dimension(25, 25));
        btnVerdecito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerdecitoActionPerformed(evt);
            }
        });

        btnNaranjita.setBackground(new java.awt.Color(255, 153, 51));
        btnNaranjita.setBorderPainted(false);
        btnNaranjita.setPreferredSize(new java.awt.Dimension(25, 25));
        btnNaranjita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNaranjitaActionPerformed(evt);
            }
        });

        btnMorado.setBackground(new java.awt.Color(102, 0, 102));
        btnMorado.setBorderPainted(false);
        btnMorado.setPreferredSize(new java.awt.Dimension(25, 25));
        btnMorado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoradoActionPerformed(evt);
            }
        });

        btnMoradito.setBackground(new java.awt.Color(255, 153, 204));
        btnMoradito.setBorderPainted(false);
        btnMoradito.setPreferredSize(new java.awt.Dimension(25, 25));
        btnMoradito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoraditoActionPerformed(evt);
            }
        });

        btnRosa.setBackground(new java.awt.Color(255, 0, 255));
        btnRosa.setBorderPainted(false);
        btnRosa.setPreferredSize(new java.awt.Dimension(25, 25));
        btnRosa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRosaActionPerformed(evt);
            }
        });

        btnRosita.setBackground(new java.awt.Color(255, 204, 255));
        btnRosita.setBorderPainted(false);
        btnRosita.setPreferredSize(new java.awt.Dimension(25, 25));
        btnRosita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRositaActionPerformed(evt);
            }
        });

        btnAmarillo.setBackground(new java.awt.Color(204, 204, 0));
        btnAmarillo.setBorderPainted(false);
        btnAmarillo.setPreferredSize(new java.awt.Dimension(25, 25));
        btnAmarillo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAmarilloActionPerformed(evt);
            }
        });

        btnAmarillito.setBackground(new java.awt.Color(255, 255, 102));
        btnAmarillito.setBorderPainted(false);
        btnAmarillito.setPreferredSize(new java.awt.Dimension(25, 25));
        btnAmarillito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAmarillitoActionPerformed(evt);
            }
        });

        jButton29.setText("Mas");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        btnLienzo.setText("Color lienzo");
        btnLienzo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLienzoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnBlanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGrisecito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVinito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAzulito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNaranjita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVerdecito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnLienzo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(btnNegro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnGris, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnVino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnAzul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnNaranja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnVerde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(btnMorado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnRosa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnAmarillo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(btnMoradito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnRosita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnAmarillito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(800, 800, 800))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnNegro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGris, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAzul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNaranja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVerde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMorado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRosa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAmarillo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGrisecito, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBlanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVinito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAzulito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVerdecito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNaranjita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMoradito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRosita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAmarillito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLienzo)))
                .addGap(28, 28, 28))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Formas"));

        btnRectangulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRectanguloActionPerformed(evt);
            }
        });

        btnElipse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElipseActionPerformed(evt);
            }
        });

        btnArco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArcoActionPerformed(evt);
            }
        });

        btnCubica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCubicaActionPerformed(evt);
            }
        });

        btnCuadrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuadradaActionPerformed(evt);
            }
        });

        btnLinea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLineaActionPerformed(evt);
            }
        });

        btnPoligono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPoligonoActionPerformed(evt);
            }
        });

        btnRedondeado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRedondeadoActionPerformed(evt);
            }
        });

        btnEstrella.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstrellaActionPerformed(evt);
            }
        });

        btnCocoro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCocoroActionPerformed(evt);
            }
        });

        btnFlash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFlashActionPerformed(evt);
            }
        });

        btnFlecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFlechaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnRectangulo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnElipse, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnArco, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCubica, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCuadrada, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPoligono, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRedondeado, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnEstrella, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCocoro, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFlash, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFlecha, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnElipse, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(btnArco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCubica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRectangulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCuadrada, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPoligono, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRedondeado, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEstrella, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCocoro, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFlash, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFlecha, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Lapiz"));

        btnLapiz.setText("Lapiz");
        btnLapiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLapizActionPerformed(evt);
            }
        });

        btnBorrador.setText("Borrador");
        btnBorrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorradorActionPerformed(evt);
            }
        });

        spiner.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                spinerAncestorMoved(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        spiner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinerStateChanged(evt);
            }
        });

        jLabel3.setText("Grosor del Lapiz");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLapiz, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBorrador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(12, 12, 12))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spiner, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLapiz)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBorrador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(spiner))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Modo"));

        btnArea.setText("Area");
        btnArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAreaActionPerformed(evt);
            }
        });

        btnPunteada.setText("Linea punteada");
        btnPunteada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPunteadaActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnReset)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnArea)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPunteada)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPunteada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReset)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(429, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 36, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 160));

        meArch.setText("Archivo");

        meCar1.setText("Carpeta 1");

        meH2D.setText("Hello 2D");
        meH2D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meH2DActionPerformed(evt);
            }
        });
        meCar1.add(meH2D);

        jMenu1.setText("Draw Shapes");

        SmeRec.setText("Rectangulo");
        SmeRec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SmeRecActionPerformed(evt);
            }
        });
        jMenu1.add(SmeRec);

        SmeRecRed.setText("Rectangulo Redondeado");
        SmeRecRed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SmeRecRedActionPerformed(evt);
            }
        });
        jMenu1.add(SmeRecRed);

        SmeEli.setText("Elipse 2D");
        SmeEli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SmeEliActionPerformed(evt);
            }
        });
        jMenu1.add(SmeEli);

        SmeArc.setText("Arco 2D");
        SmeArc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SmeArcActionPerformed(evt);
            }
        });
        jMenu1.add(SmeArc);

        SmeLin.setText("Linea");
        SmeLin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SmeLinActionPerformed(evt);
            }
        });
        jMenu1.add(SmeLin);

        SmeCur.setText("Curva Cuadratica");
        SmeCur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SmeCurActionPerformed(evt);
            }
        });
        jMenu1.add(SmeCur);

        SmePol.setText("Poligono");
        SmePol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SmePolActionPerformed(evt);
            }
        });
        jMenu1.add(SmePol);

        SmeCurC.setText("Curva cubica");
        SmeCurC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SmeCurCActionPerformed(evt);
            }
        });
        jMenu1.add(SmeCurC);

        meCar1.add(jMenu1);

        meArch.add(meCar1);

        meCar2.setText("Carpeta 2");

        meH2DM.setText("Hellod 2D M");
        meH2DM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meH2DMActionPerformed(evt);
            }
        });
        meCar2.add(meH2DM);

        jMenu3.setText("Shapes Modificado");

        jMenu4.setText("Objetos 1");

        meRecM.setText("Rectangulo");
        meRecM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meRecMActionPerformed(evt);
            }
        });
        jMenu4.add(meRecM);

        meRecRM.setText("Rectangulo Redondeado");
        meRecRM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meRecRMActionPerformed(evt);
            }
        });
        jMenu4.add(meRecRM);

        meEliM.setText("Elipse 2D");
        meEliM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meEliMActionPerformed(evt);
            }
        });
        jMenu4.add(meEliM);

        meArcM.setText("Arco 2D");
        meArcM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meArcMActionPerformed(evt);
            }
        });
        jMenu4.add(meArcM);

        meLinM.setText("Linea");
        meLinM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meLinMActionPerformed(evt);
            }
        });
        jMenu4.add(meLinM);

        meCurM.setText("Curva Cuadratica");
        meCurM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meCurMActionPerformed(evt);
            }
        });
        jMenu4.add(meCurM);

        mePolM.setText("Poligono");
        mePolM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mePolMActionPerformed(evt);
            }
        });
        jMenu4.add(mePolM);

        meCurCM.setText("Curva Cubica");
        meCurCM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meCurCMActionPerformed(evt);
            }
        });
        jMenu4.add(meCurCM);

        jMenu3.add(jMenu4);

        jMenu5.setText("Objetos 2");

        menOBJ1.setText("Corazon");
        menOBJ1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menOBJ1ActionPerformed(evt);
            }
        });
        jMenu5.add(menOBJ1);

        menOBJ2.setText("Corazon invertido");
        menOBJ2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menOBJ2ActionPerformed(evt);
            }
        });
        jMenu5.add(menOBJ2);

        menOBJ3.setText("Doble T ");
        menOBJ3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menOBJ3ActionPerformed(evt);
            }
        });
        jMenu5.add(menOBJ3);

        menOBJ4.setText("Dodecagrama");
        menOBJ4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menOBJ4ActionPerformed(evt);
            }
        });
        jMenu5.add(menOBJ4);

        menOBJ5.setText("Estrella");
        menOBJ5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menOBJ5ActionPerformed(evt);
            }
        });
        jMenu5.add(menOBJ5);

        menOBJ6.setText("Pez Amorfo");
        menOBJ6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menOBJ6ActionPerformed(evt);
            }
        });
        jMenu5.add(menOBJ6);

        menOBJ7.setText("Flash");
        menOBJ7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menOBJ7ActionPerformed(evt);
            }
        });
        jMenu5.add(menOBJ7);

        menOBJ8.setText("Casa");
        menOBJ8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menOBJ8ActionPerformed(evt);
            }
        });
        jMenu5.add(menOBJ8);

        menOBJ9.setText("Flecha");
        menOBJ9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menOBJ9ActionPerformed(evt);
            }
        });
        jMenu5.add(menOBJ9);

        menOBJ10.setText("Cubo");
        menOBJ10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menOBJ10ActionPerformed(evt);
            }
        });
        jMenu5.add(menOBJ10);

        jMenu3.add(jMenu5);

        jMenu7.setText("Objetos 3");
        jMenu3.add(jMenu7);

        meCar2.add(jMenu3);

        meArch.add(meCar2);

        jMenuBar1.add(meArch);

        menObj.setText("Objetos");
        menObj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menObjActionPerformed(evt);
            }
        });

        menRec.setText("Rectangulo");
        menRec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menRecActionPerformed(evt);
            }
        });
        menObj.add(menRec);

        menRecRed.setText("Rectangulo Redondeado");
        menRecRed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menRecRedActionPerformed(evt);
            }
        });
        menObj.add(menRecRed);

        menElipse.setText("Elipse 2D");
        menElipse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menElipseActionPerformed(evt);
            }
        });
        menObj.add(menElipse);

        menArc.setText("Arco 2D");
        menArc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menArcActionPerformed(evt);
            }
        });
        menObj.add(menArc);

        menLin.setText("Linea");
        menLin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menLinActionPerformed(evt);
            }
        });
        menObj.add(menLin);

        menCur.setText("Curva cuadratica");
        menCur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menCurActionPerformed(evt);
            }
        });
        menObj.add(menCur);

        menPol.setText("Poligono");
        menPol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menPolActionPerformed(evt);
            }
        });
        menObj.add(menPol);

        menCurCu.setText("Curva cubica");
        menCurCu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menCurCuActionPerformed(evt);
            }
        });
        menObj.add(menCurCu);

        jMenuBar1.add(menObj);

        jMenu6.setText("Mis Objetos");
        jMenu6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu6ActionPerformed(evt);
            }
        });

        jMenuItem1.setText("Corazon");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem1);

        jMenuItem2.setText("Corazon Invertido");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem2);

        jMenuItem3.setText("Doble T");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem3);

        btnDode.setText("Dodecagrama");
        btnDode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodeActionPerformed(evt);
            }
        });
        jMenu6.add(btnDode);

        jMenuItem5.setText("Estrella");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem5);

        btnPez.setText("PezAmorfo");
        btnPez.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPezActionPerformed(evt);
            }
        });
        jMenu6.add(btnPez);

        jMenuItem7.setText("Flash");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem7);

        jMenuItem8.setText("Casa");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem8);

        jMenuItem9.setText("Flecha");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem9);

        btnCubo.setText("Cubo");
        btnCubo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuboActionPerformed(evt);
            }
        });
        jMenu6.add(btnCubo);

        jMenuBar1.add(jMenu6);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerdeActionPerformed
        color = DameColorB(btnVerde);
    }//GEN-LAST:event_btnVerdeActionPerformed

    private void btnVerdecitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerdecitoActionPerformed
        color = DameColorB(btnVerdecito);
    }//GEN-LAST:event_btnVerdecitoActionPerformed

    private void btnNaranjitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNaranjitaActionPerformed
        color = DameColorB(btnNaranjita);
    }//GEN-LAST:event_btnNaranjitaActionPerformed

    private void btnMoradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoradoActionPerformed
        color = DameColorB(btnMorado);
    }//GEN-LAST:event_btnMoradoActionPerformed

    private void btnMoraditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoraditoActionPerformed
        color = DameColorB(btnMoradito);
    }//GEN-LAST:event_btnMoraditoActionPerformed

    private void btnRosaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRosaActionPerformed
        color = DameColorB(btnRosa);
    }//GEN-LAST:event_btnRosaActionPerformed

    private void btnRositaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRositaActionPerformed
        color = DameColorB(btnRosita);
    }//GEN-LAST:event_btnRositaActionPerformed

    private void btnAmarilloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAmarilloActionPerformed
        color = DameColorB(btnAmarillo);
    }//GEN-LAST:event_btnAmarilloActionPerformed

    private void btnAmarillitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAmarillitoActionPerformed
        color = DameColorB(btnAmarillito);
    }//GEN-LAST:event_btnAmarillitoActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        colores color = new colores();
        color.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton29ActionPerformed

    private void btnNegroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNegroActionPerformed
        color = DameColorB(btnNegro);
    }//GEN-LAST:event_btnNegroActionPerformed

    private void btnBlancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBlancoActionPerformed
        color = DameColorB(btnBlanco);

    }//GEN-LAST:event_btnBlancoActionPerformed

    private void btnGrisecitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrisecitoActionPerformed
        color = DameColorB(btnGrisecito);
    }//GEN-LAST:event_btnGrisecitoActionPerformed

    private void btnGrisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrisActionPerformed
        color = DameColorB(btnGris);
    }//GEN-LAST:event_btnGrisActionPerformed

    private void btnVinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVinoActionPerformed
        color = DameColorB(btnVino);
    }//GEN-LAST:event_btnVinoActionPerformed

    private void btnVinitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVinitoActionPerformed
        color = DameColorB(btnVinito);
    }//GEN-LAST:event_btnVinitoActionPerformed

    private void btnAzulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAzulActionPerformed
        color = DameColorB(btnAzul);
    }//GEN-LAST:event_btnAzulActionPerformed

    private void btnAzulitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAzulitoActionPerformed
        color = DameColorB(btnAzulito);
    }//GEN-LAST:event_btnAzulitoActionPerformed

    private void btnNaranjaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNaranjaActionPerformed
        color = DameColorB(btnNaranja);
    }//GEN-LAST:event_btnNaranjaActionPerformed

    private void btnRectanguloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRectanguloActionPerformed
        shapeType = RECTANGLE;//RECTANGULO 
    }//GEN-LAST:event_btnRectanguloActionPerformed

    private void btnLapizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLapizActionPerformed
        pnlPaint.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        shapeType = FREE;
        
    }//GEN-LAST:event_btnLapizActionPerformed

    private void btnBorradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorradorActionPerformed
        pnlPaint.setCursor(new Cursor(Cursor.HAND_CURSOR));
        repaint();
    }//GEN-LAST:event_btnBorradorActionPerformed

    private void meH2DActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meH2DActionPerformed
        g = (Graphics2D) pnlPaint.getGraphics();
        Ellipse2D e = new Ellipse2D.Double(-100, -50, 200, 100);
        AffineTransform tr = new AffineTransform();
        tr.rotate(Math.PI / 6.0);
        shape = tr.createTransformedShape(e);
        g.setColor(color);
        g.translate(300,200);
        g.scale(2,2);
        g.drawString("Hola java 2D", 0, 0);
        g.draw(shape);
       
    }//GEN-LAST:event_meH2DActionPerformed

    private void btnLienzoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLienzoActionPerformed
        FondoL backG = new FondoL();
        backG.setVisible(true);
    }//GEN-LAST:event_btnLienzoActionPerformed
//**************************SHAPES EN LA BARRA DE MENU *******************//
    
    
    
    private void menRecRedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menRecRedActionPerformed
        shapeType = ROUNDRECTANGLE2D;//RECTANGULO REDONDEADO
    }//GEN-LAST:event_menRecRedActionPerformed

    private void menCurCuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menCurCuActionPerformed
        shapeType = CUBICCURVE2D;//CUBICA
    }//GEN-LAST:event_menCurCuActionPerformed

    private void menRecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menRecActionPerformed
        shapeType = RECTANGLE;//RECTANGULO 
    }//GEN-LAST:event_menRecActionPerformed

    private void menObjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menObjActionPerformed
        
    }//GEN-LAST:event_menObjActionPerformed

    private void menElipseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menElipseActionPerformed
        shapeType = ELLIPSE2D;//ELIPSE
    }//GEN-LAST:event_menElipseActionPerformed

    private void menArcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menArcActionPerformed
        shapeType = ARC2D;//ARCO
    }//GEN-LAST:event_menArcActionPerformed

    private void menLinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menLinActionPerformed
        shapeType = LINE2D;//LINEA
    }//GEN-LAST:event_menLinActionPerformed

    private void menCurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menCurActionPerformed
        shapeType = QUADCURVE2D;//CUADRATICA
    }//GEN-LAST:event_menCurActionPerformed

    private void menPolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menPolActionPerformed
        shapeType = POLYGON;//POLIGONO
    }//GEN-LAST:event_menPolActionPerformed

    private void spinerAncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_spinerAncestorMoved
         
    }//GEN-LAST:event_spinerAncestorMoved

    private void spinerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinerStateChanged
        int val = (int) spiner.getValue();
        s = new BasicStroke(val);
    }//GEN-LAST:event_spinerStateChanged
    
    
    
    private void meH2DMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meH2DMActionPerformed
        g = (Graphics2D) pnlPaint.getGraphics();
        Ellipse2D e = new Ellipse2D.Double(-100, -50, 200, 100);
        
        AffineTransform tr = new AffineTransform();
        
        tr.rotate(Math.PI / 6.0);
        
        shape = tr.createTransformedShape(e);
        
        g.setColor(color);
        g.translate(300,200);
        g.scale(2,2);
        g.drawString("Hola Soy Santiago", -40, 0);
        g.draw(shape);
        for (int i = 0; i < 100; i++) {
            tr.rotate(Math.PI / 180);
            shape = tr.createTransformedShape(shape);
            g.setColor(color);
            g.draw(shape);
        }
        g.drawRect(100, -12,300,40);
        g.drawString("CALSE DE GRAFICACION 2021",110,10);
        
        e = new Ellipse2D.Double(-100, -50, 20, 10);
        shape = tr.createTransformedShape(e);
        g.translate(270, 60);
        for (int i = 0; i < 100; i++) {
            tr.rotate(Math.PI / 180);
            shape = tr.createTransformedShape(shape);
            g.setColor(Color.PINK);
            g.draw(shape);
        }
        for (int i = 0; i < 100; i++) {
            tr.rotate(Math.PI / 180);
            e = new Ellipse2D.Double(100-i,i , i+10, i);
            shape = tr.createTransformedShape(e);
            g.setColor(Color.BLUE);
            g.draw(shape);
        }
        
    }//GEN-LAST:event_meH2DMActionPerformed


//*********************SECCION PARA LAS SHPES NORMALES **************//
    
    
    private void SmeCurCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SmeCurCActionPerformed
        shapeType = CUBICCURVE2D;//CUBICA
    }//GEN-LAST:event_SmeCurCActionPerformed

    private void SmeRecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SmeRecActionPerformed
        shapeType = RECTANGLE;//RECTANGULO 
    }//GEN-LAST:event_SmeRecActionPerformed

    private void SmeRecRedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SmeRecRedActionPerformed
        shapeType = ROUNDRECTANGLE2D;//RECTANGULO REDONDEADO
    }//GEN-LAST:event_SmeRecRedActionPerformed

    private void SmeEliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SmeEliActionPerformed
        shapeType = ELLIPSE2D;//ELIPSE
    }//GEN-LAST:event_SmeEliActionPerformed

    private void SmeArcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SmeArcActionPerformed
        shapeType = ARC2D;//ARCO
    }//GEN-LAST:event_SmeArcActionPerformed

    private void SmeLinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SmeLinActionPerformed
        shapeType = LINE2D;//LINEA
    }//GEN-LAST:event_SmeLinActionPerformed

    private void SmeCurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SmeCurActionPerformed
        shapeType = QUADCURVE2D;//CUADRATICA
    }//GEN-LAST:event_SmeCurActionPerformed



//*****************SECCION DE OPCIONES PARA SHAPES MODIFICADO****************//
    
    
    
    private void SmePolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SmePolActionPerformed
        shapeType = POLYGON;//POLIGONO
    }//GEN-LAST:event_SmePolActionPerformed

    private void meEliMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meEliMActionPerformed
        shapeType = ELLIPSE2D;//ELIPSE
    }//GEN-LAST:event_meEliMActionPerformed

    private void menOBJ2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menOBJ2ActionPerformed
        shapeType = CORAZONI;
    }//GEN-LAST:event_menOBJ2ActionPerformed

    private void menOBJ3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menOBJ3ActionPerformed
        shapeType = DOBLET;
    }//GEN-LAST:event_menOBJ3ActionPerformed

    private void meRecMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meRecMActionPerformed
        shapeType = RECTANGLE;//RECTANGULO 
    }//GEN-LAST:event_meRecMActionPerformed

    private void meRecRMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meRecRMActionPerformed
        shapeType = ROUNDRECTANGLE2D;//RECTANGULO REDONDEADO
    }//GEN-LAST:event_meRecRMActionPerformed

    private void meArcMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meArcMActionPerformed
        shapeType = ARC2D;//ARCO
    }//GEN-LAST:event_meArcMActionPerformed

    private void meLinMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meLinMActionPerformed
        shapeType = LINE2D;//LINEA
    }//GEN-LAST:event_meLinMActionPerformed

    private void meCurMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meCurMActionPerformed
        shapeType = QUADCURVE2D;//CUADRATICA
    }//GEN-LAST:event_meCurMActionPerformed

    private void mePolMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mePolMActionPerformed
        shapeType = POLYGON;//POLIGONO
    }//GEN-LAST:event_mePolMActionPerformed

    private void meCurCMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meCurCMActionPerformed
        shapeType = CUBICCURVE2D;//CUBICA
    }//GEN-LAST:event_meCurCMActionPerformed
//**********************PARA LOS BOTONES******************************//
    
    
    private void btnElipseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElipseActionPerformed
        shapeType = ELLIPSE2D;//ELIPSE
    }//GEN-LAST:event_btnElipseActionPerformed

    private void btnArcoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArcoActionPerformed
       shapeType = ARC2D;//ARCO
    }//GEN-LAST:event_btnArcoActionPerformed

    private void btnCubicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCubicaActionPerformed
        shapeType = CUBICCURVE2D;//CUBICA
    }//GEN-LAST:event_btnCubicaActionPerformed

    private void btnCuadradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuadradaActionPerformed
        shapeType = QUADCURVE2D;//CUADRATICA
    }//GEN-LAST:event_btnCuadradaActionPerformed

    private void btnLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLineaActionPerformed
        shapeType = LINE2D;//LINEA
    }//GEN-LAST:event_btnLineaActionPerformed

    private void btnPoligonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPoligonoActionPerformed
        shapeType = POLYGON;//POLIGONO
    }//GEN-LAST:event_btnPoligonoActionPerformed

    private void btnRedondeadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRedondeadoActionPerformed
        shapeType = ROUNDRECTANGLE2D;//RECTANGULO REDONDEADO
    }//GEN-LAST:event_btnRedondeadoActionPerformed

    private void btnAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAreaActionPerformed
        JOptionPane.showMessageDialog(rootPane, "Comience a dibujar y las figuras tendran rellleno");
        pnlPaint.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Area = true;
    }//GEN-LAST:event_btnAreaActionPerformed

    private void menOBJ1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menOBJ1ActionPerformed
        shapeType = CORAZON;
    }//GEN-LAST:event_menOBJ1ActionPerformed

    private void menOBJ4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menOBJ4ActionPerformed
        shapeType = DODECAGRAMA;
    }//GEN-LAST:event_menOBJ4ActionPerformed

    private void btnPunteadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPunteadaActionPerformed
        int v =(int) spiner.getValue();
        float val[] = {10};
        s = new BasicStroke (v,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND,10,val,0);
    }//GEN-LAST:event_btnPunteadaActionPerformed

    private void menOBJ5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menOBJ5ActionPerformed
        shapeType = ESTRELLA;
    }//GEN-LAST:event_menOBJ5ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        shapeType= CORAZON;
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        shapeType = CORAZONI;
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        shapeType = DOBLET;
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void btnDodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodeActionPerformed
        shapeType = DODECAGRAMA;
    }//GEN-LAST:event_btnDodeActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        shapeType = ESTRELLA;
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenu6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu6ActionPerformed
        shapeType = PEZAMORFO; 
    }//GEN-LAST:event_jMenu6ActionPerformed

    private void menOBJ6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menOBJ6ActionPerformed
        shapeType = PEZAMORFO;
    }//GEN-LAST:event_menOBJ6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        shapeType = FLASH ;
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void menOBJ7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menOBJ7ActionPerformed
        shapeType = FLASH;
    }//GEN-LAST:event_menOBJ7ActionPerformed

    private void btnPezActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPezActionPerformed
       shapeType= PEZAMORFO;
    }//GEN-LAST:event_btnPezActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        shapeType = CASA;
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void menOBJ8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menOBJ8ActionPerformed
        shapeType = CASA;
    }//GEN-LAST:event_menOBJ8ActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        Area = false;
        int val = (int) spiner.getValue();
        s = new BasicStroke(val);
    }//GEN-LAST:event_btnResetActionPerformed

    private void menOBJ9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menOBJ9ActionPerformed
        shapeType = FLECHA;
    }//GEN-LAST:event_menOBJ9ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        shapeType = FLECHA;
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void btnCuboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuboActionPerformed
        shapeType = CUBO;
    }//GEN-LAST:event_btnCuboActionPerformed

    private void menOBJ10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menOBJ10ActionPerformed
        shapeType = CUBO;
    }//GEN-LAST:event_menOBJ10ActionPerformed

    private void btnEstrellaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstrellaActionPerformed
        shapeType = ESTRELLA;
    }//GEN-LAST:event_btnEstrellaActionPerformed

    private void btnCocoroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCocoroActionPerformed
        shapeType = CORAZON;
    }//GEN-LAST:event_btnCocoroActionPerformed

    private void btnFlashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFlashActionPerformed
       shapeType = FLASH;
    }//GEN-LAST:event_btnFlashActionPerformed

    private void btnFlechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFlechaActionPerformed
        shapeType = FLECHA;
    }//GEN-LAST:event_btnFlechaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Paint2D.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Paint2D.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Paint2D.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Paint2D.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Paint2D().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem SmeArc;
    private javax.swing.JMenuItem SmeCur;
    private javax.swing.JMenuItem SmeCurC;
    private javax.swing.JMenuItem SmeEli;
    private javax.swing.JMenuItem SmeLin;
    private javax.swing.JMenuItem SmePol;
    private javax.swing.JMenuItem SmeRec;
    private javax.swing.JMenuItem SmeRecRed;
    private javax.swing.JButton btnAmarillito;
    private javax.swing.JButton btnAmarillo;
    private javax.swing.JButton btnArco;
    private javax.swing.JButton btnArea;
    private javax.swing.JButton btnAzul;
    private javax.swing.JButton btnAzulito;
    private javax.swing.JButton btnBlanco;
    private javax.swing.JButton btnBorrador;
    private javax.swing.JButton btnCocoro;
    private javax.swing.JButton btnCuadrada;
    private javax.swing.JButton btnCubica;
    private javax.swing.JMenuItem btnCubo;
    private javax.swing.JMenuItem btnDode;
    private javax.swing.JButton btnElipse;
    private javax.swing.JButton btnEstrella;
    private javax.swing.JButton btnFlash;
    private javax.swing.JButton btnFlecha;
    private javax.swing.JButton btnGris;
    private javax.swing.JButton btnGrisecito;
    private javax.swing.JButton btnLapiz;
    private javax.swing.JButton btnLienzo;
    private javax.swing.JButton btnLinea;
    private javax.swing.JButton btnMoradito;
    private javax.swing.JButton btnMorado;
    private javax.swing.JButton btnNaranja;
    private javax.swing.JButton btnNaranjita;
    private javax.swing.JButton btnNegro;
    private javax.swing.JMenuItem btnPez;
    private javax.swing.JButton btnPoligono;
    private javax.swing.JButton btnPunteada;
    private javax.swing.JButton btnRectangulo;
    private javax.swing.JButton btnRedondeado;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnRosa;
    private javax.swing.JButton btnRosita;
    private javax.swing.JButton btnVerde;
    private javax.swing.JButton btnVerdecito;
    private javax.swing.JButton btnVinito;
    private javax.swing.JButton btnVino;
    private javax.swing.JButton jButton29;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JMenuItem meArcM;
    private javax.swing.JMenu meArch;
    private javax.swing.JMenu meCar1;
    private javax.swing.JMenu meCar2;
    private javax.swing.JMenuItem meCurCM;
    private javax.swing.JMenuItem meCurM;
    private javax.swing.JMenuItem meEliM;
    private javax.swing.JMenuItem meH2D;
    private javax.swing.JMenuItem meH2DM;
    private javax.swing.JMenuItem meLinM;
    private javax.swing.JMenuItem mePolM;
    private javax.swing.JMenuItem meRecM;
    private javax.swing.JMenuItem meRecRM;
    private javax.swing.JMenuItem menArc;
    private javax.swing.JMenuItem menCur;
    private javax.swing.JMenuItem menCurCu;
    private javax.swing.JMenuItem menElipse;
    private javax.swing.JMenuItem menLin;
    private javax.swing.JMenuItem menOBJ1;
    private javax.swing.JMenuItem menOBJ10;
    private javax.swing.JMenuItem menOBJ2;
    private javax.swing.JMenuItem menOBJ3;
    private javax.swing.JMenuItem menOBJ4;
    private javax.swing.JMenuItem menOBJ5;
    private javax.swing.JMenuItem menOBJ6;
    private javax.swing.JMenuItem menOBJ7;
    private javax.swing.JMenuItem menOBJ8;
    private javax.swing.JMenuItem menOBJ9;
    private javax.swing.JMenu menObj;
    private javax.swing.JMenuItem menPol;
    private javax.swing.JMenuItem menRec;
    private javax.swing.JMenuItem menRecRed;
    public static javax.swing.JPanel pnlPaint;
    private javax.swing.JSpinner spiner;
    // End of variables declaration//GEN-END:variables
    
    public static Color DameColorB (JButton boton) {
        Color col;
        col = boton.getBackground();
        return col;
    }
    public void paintComponent() {
    pnlPaint.paintComponents(g);
    Graphics2D g2 = (Graphics2D)g;
    for (int i = 0; i < shapes.size(); i++) {
      Shape s = (Shape)shapes.get(i);
      g2.draw(s);
    }
  }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
       
    }
    @Override
     public void mousePressed(MouseEvent ev) {
        points.add(ev.getPoint());
        pointIndex++;
        p = null;
    }
    @Override
    public void mouseDragged(MouseEvent ev) {
        g = (Graphics2D) pnlPaint.getGraphics();
        g.setStroke(s);
        g.translate(-9,-175);
        g.setXORMode(Color.white);
        g.setColor(color);
        Point p1 = (Point)points.get(pointIndex-1);
        switch (shapeType) {
          case RECTANGLE:
            if (p != null)g.drawRect(p1.x, p1.y, p.x-p1.x, p.y-p1.y);
            p = ev.getPoint();
            g.drawRect(p1.x, p1.y, p.x-p1.x, p.y-p1.y);
            break;
          case ROUNDRECTANGLE2D:
            if (p != null) g.drawRoundRect(p1.x, p1.y, p.x-p1.x, p.y-p1.y,10,10);
            p = ev.getPoint();
            g.drawRoundRect(p1.x, p1.y, p.x-p1.x, p.y-p1.y,10,10);
            break;
          case ELLIPSE2D:
            if (p != null) g.drawOval(p1.x, p1.y, p.x-p1.x, p.y-p1.y);
            p = ev.getPoint();
            g.drawOval(p1.x, p1.y, p.x-p1.x, p.y-p1.y);
            break;
          case ARC2D:
            if (p != null) g.drawArc(p1.x, p1.y, p.x-p1.x, p.y-p1.y, 30, 120);
            p = ev.getPoint();
            g.drawArc(p1.x, p1.y, p.x-p1.x, p.y-p1.y, 30, 120);
            break;
          case LINE2D:
          case POLYGON:
            if (p != null) {
                    g.drawLine(p1.x, p1.y, p.x, p.y);
                }
                p = ev.getPoint();
                g.drawLine(p1.x, p1.y, p.x, p.y);
            break;
          case QUADCURVE2D:
            if (pointIndex == 1) {
              if (p != null) g.drawLine(p1.x, p1.y, p1.x, p1.y);
              p = ev.getPoint();
              g.drawLine(p1.x, p1.y, p1.x, p1.y);
            } else {
              Point p2 = (Point)points.get(pointIndex-2);
              if (p != null) g.draw(partialShape);
              p = ev.getPoint();
              partialShape = new QuadCurve2D.Float(p2.x, p2.y, p1.x, p1.y, p.x, p.y);
              g.draw(partialShape);
            }
            break;
          case CUBICCURVE2D:
            if (pointIndex == 1) {
              if (p != null) g.drawLine(p1.x, p1.y, p1.x, p1.y);
              p = ev.getPoint();
              g.drawLine(p1.x, p1.y, p1.x, p1.y);
            } else if (pointIndex == 2) {
              Point p2 = (Point)points.get(pointIndex-2);
              if (p != null); //g.draw(partialShape);
              p = ev.getPoint();
              partialShape = new QuadCurve2D.Float(p2.x, p2.y, p1.x, p1.y, p.x, p.y);
              //g.draw(partialShape);
            } else {
              Point p2 = (Point)points.get(pointIndex-2);
              Point p3 = (Point)points.get(pointIndex-3);
              if (p != null) g.draw(partialShape);
              p = ev.getPoint();
              partialShape = new CubicCurve2D.Float(p3.x, p3.y, p2.x, p2.y, p1.x, p1.y, p.x, p.y);
              g.draw(partialShape);
            }
            break;
            case FREE:
                    g.setPaintMode();
                    g.translate(0,-45);
                    if (p != null) g.drawLine(p.x, p.y, p.x, p.y);
                        p = ev.getPoint();
                        //g.drawLine(p.x, p.y, p.x, p.y);
            break;
            case CORAZON:
                if (p != null) {
                    g.draw(new Corazon(p1.x, p1.y, p.x - p1.x, p.y - p1.y));
                }
                p = ev.getPoint();
                g.draw(new Corazon(p1.x, p1.y, p.x - p1.x, p.y - p1.y));
            break;
            case CORAZONI :
                if (p != null) {
                    g.draw(new CorazonInvertido(p1.x, p1.y, p.x - p1.x, p.y - p1.y));
                }
                p = ev.getPoint();
                g.draw(new CorazonInvertido(p1.x, p1.y, p.x - p1.x, p.y - p1.y));
            break;
            case DOBLET:
            
                if (p != null) {
                        g.draw(Doblet.dibujar(p1.x, p1.y, p.x - p1.x, p.y - p1.y, lados));
                    }
                    p = ev.getPoint();
                    g.draw(Doblet.dibujar(p1.x, p1.y, p.x - p1.x, p.y - p1.y, lados));
            break;
            case DODECAGRAMA:
                g.translate(200,150);
                if (p != null) {
                    g.draw(Dodeca.crear(p1.x, p1.y, p.x - p1.x, p.y - p1.y, lados));
                }
                p = ev.getPoint();
                g.draw(Dodeca.crear(p1.x, p1.y, p.x - p1.x, p.y - p1.y, lados));
                
            break;
            case ESTRELLA:
                g.translate(250,300);
                if (p != null) {
                    g.draw(Estrella.nueva(p1.x, p1.y, p.x - p1.x, p.y - p1.y, lados));
                }
                p = ev.getPoint();
                g.draw(Estrella.nueva(p1.x, p1.y, p.x - p1.x, p.y - p1.y, lados));
                
            break;
            case PEZAMORFO:
                
                if (p != null) {
                    g.draw(new PezAmorfo(p1.x, p1.y, p.x - p1.x, p.y - p1.y));
                }
                p = ev.getPoint();
                g.draw(new PezAmorfo(p1.x, p1.y, p.x - p1.x, p.y - p1.y));
                
            break;
            case FLASH:
                if (p != null) {
                    g.draw(new Flash(p1.x,p1.y,p.x - p1.x, p.y - p1.y));
                }
                p= ev.getPoint();
                g.draw(new Flash (p1.x,p1.y,p.x - p1.x, p.y - p1.y));
            break;
            case CASA:
                if (p != null) {
                    g.draw(new Casita(p1.x, p1.y, p.x - p1.x, p.y - p1.y));
                }
                p = ev.getPoint();
                g.draw(new Casita(p1.x, p1.y, p.x - p1.x, p.y - p1.y));
                break;
            case FLECHA:
                if (p != null) {
                    g.draw(new Flecha(p1.x, p1.y, p.x - p1.x, p.y - p1.y));
                }
                p = ev.getPoint();
                g.draw(new Flecha(p1.x, p1.y, p.x - p1.x, p.y - p1.y));
                break;
            case CUBO:
                if (p != null) {
                    g.draw(new Cubo(p1.x, p1.y, p.x - p1.x, p.y - p1.y));
                }
                p = ev.getPoint();
                g.draw(new Cubo(p1.x, p1.y, p.x - p1.x, p.y - p1.y));
                break;
        }
      }
    @Override
    public void mouseReleased(MouseEvent ev) {
        g = (Graphics2D) pnlPaint.getGraphics();
        g.setStroke(s);
        g.setColor(color);
        g.translate(-9,-175);
        Point p1 = (Point)(points.get(pointIndex-1));
        p = ev.getPoint();
        Shape s = null;
        switch (shapeType) {
          case RECTANGLE:
            s = new Rectangle(p1.x, p1.y, p.x-p1.x, p.y-p1.y);
            if (Area == true){
                g.fill((Shape) s);
            }
            g.draw(s);
            break;
          case ROUNDRECTANGLE2D:
            s = new RoundRectangle2D.Float(p1.x, p1.y, p.x-p1.x, p.y-p1.y, 10, 10);
            if (Area == true){
                g.fill((Shape) s);
            }
            g.draw(s);
            break;
          case ELLIPSE2D:
            s = new Ellipse2D.Float(p1.x, p1.y, p.x-p1.x, p.y-p1.y);
            if (Area == true){
                g.fill((Shape) s);
            }
            g.draw(s);
            break;
          case ARC2D:
            s = new Arc2D.Float(p1.x, p1.y, p.x-p1.x, p.y-p1.y, 30, 120, Arc2D.OPEN);
            if (Area == true){
                g.fill((Shape) s);
            }
            g.draw(s);
            break;
          case LINE2D:
            s = new Line2D.Float(p1.x, p1.y, p.x, p.y);
            if (Area == true){
                g.fill((Shape) s);
            }
            g.draw(s);
            break;
          case QUADCURVE2D:
            if (pointIndex > 1) {
              Point p2 = (Point)points.get(0);
              s = new QuadCurve2D.Float(p2.x, p2.y, p1.x, p1.y, p.x, p.y);
              if (Area == true){
                g.fill((Shape) s);
            }
              g.draw(s);
            }
            break;
          case CUBICCURVE2D:
            if (pointIndex > 2) {
              Point p2 = (Point)points.get(pointIndex-2);
              Point p3 = (Point)points.get(pointIndex-3);
              s = new CubicCurve2D.Float(p3.x, p3.y, p2.x, p2.y, p1.x, p1.y, p.x, p.y);
              if (Area == true){               
                g.fill((Shape) s);
              }
              g.draw(s);
            }
            break;
          case POLYGON:
            if (ev.isShiftDown()) {
                    s = new Polygon();
                    for (int i = 0; i < pointIndex; i++) {
                        ((Polygon) s).addPoint(((Point) points.get(i)).x, ((Point) points.get(i)).y);
                    }
                    ((Polygon) s).addPoint(p.x, p.y);
            }
            if (Area == true){
                g.fill((Shape) s);
            }
            g.draw(s);
          break; 
          case FREE:
                    g.translate(0,-45);
                    s = new Line2D.Float(p.x, p.y, p.x, p.y);
                    g.draw(s);
            break;
          case CORAZON:
              s = new Corazon(p1.x, p1.y, p.x - p1.x, p.y - p1.y);
              if (Area == true){
                g.fill((Shape) s);
              }
              g.draw(s);
          break;
          case CORAZONI : 
              s = new CorazonInvertido(p1.x, p1.y, p.x - p1.x, p.y - p1.y);
              if (Area == true){
                g.fill((Shape) s);
              }
              g.draw(s);
            break;
          case DOBLET :
              s = Doblet.dibujar(p1.x, p1.y, p.x - p1.x, p.y - p1.y, lados);
              if (Area == true){
                g.fill((Shape) s);
              }
              g.draw(s);
          break;
          case DODECAGRAMA :
              g.translate(200,150);
              s = Dodeca.crear(p1.x, p1.y, p.x - p1.x, p.y - p1.y, lados);
              if (Area == true){
                g.fill((Shape) s);
              }
              g.draw(s);
          break;
          case ESTRELLA : 
              g.translate(250,300);
              s = Estrella.nueva(p1.x, p1.y, p.x - p1.x, p.y - p1.y, lados);
              if (Area == true){
                g.fill((Shape) s);
              }
              g.draw(s);
          break;
          case PEZAMORFO:
              s = new PezAmorfo(p1.x, p1.y, p.x - p1.x, p.y - p1.y);
              if (Area == true){
                g.fill((Shape) s);
              }
              g.draw(s);
          break;
          case FLASH:
              s = new Flash(p1.x, p1.y, p.x - p1.x, p.y - p1.y);
              if (Area == true){
                g.fill((Shape) s);
              }
              g.draw(s);
          break;
          case CASA:
              s = new Casita(p1.x, p1.y, p.x - p1.x, p.y - p1.y);
              g.draw(s);
              break;
          case FLECHA :
              s = new Flecha(p1.x, p1.y, p.x - p1.x, p.y - p1.y);
              if (Area == true){
                g.fill((Shape) s);
              }
              g.draw(s);
              break;
          case CUBO:
              s = new Cubo(p1.x, p1.y, p.x - p1.x, p.y - p1.y);
              g.draw(s);
              break;
        }
        if (s != null) {  
          shapes.add(s);
          points.clear();
          pointIndex = 0;
          p = null;
          //repaint();
          //paintComponent();
        } 
    }
}
