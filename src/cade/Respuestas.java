package cade;

import com.itextpdf.text.BaseColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;

public class Respuestas extends JFrame implements ActionListener {

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    Statement s;

    public JButton b1 = new JButton("Consultar");
    public JButton b2 = new JButton("Listar");
    public JButton b7 = new JButton("Generar-PDF");
    public JButton b8 = new JButton("Regresar a Preguntas");
    public JLabel log = new JLabel("CADE-PRO ");

    public JTextField tf1 = new JTextField();
    public JTextField tf2 = new JTextField();
    public JTextField tf3 = new JTextField();
    public JTextField tf4 = new JTextField();
    public JTextField tf5 = new JTextField();
    public JTextField tf6 = new JTextField();
    public JTextField tf7 = new JTextField();
    public JTextField tf8 = new JTextField();
    public JTextField tf9 = new JTextField();
    public JTextField tf10 = new JTextField();
    public JTextField tf11 = new JTextField();
    public JTextField tf12 = new JTextField();
    public JTextField tf13 = new JTextField();
    public JTextField tf14 = new JTextField();
    public JTextField tf15 = new JTextField();

    public JTextArea ta = new JTextArea();

    public JButton bCSe = new JButton("Cerrar Sesion");
    public JLabel lLogo = new JLabel("LOGO");
    public JPanel p1 = new JPanel();

    public JTable tb1 = new JTable();
    public JScrollPane sp = new JScrollPane(tb1);

    public JLabel logo = new JLabel("CADE-PRO ");
    public JLabel lbIma = new JLabel();
    public ImageIcon fondo;

    public Respuestas() {

        add(p1);
        p1.setLayout(null);

        fondo = new ImageIcon("..\\Cade\\imagenes\\fondo.jpg");
        p1.add(lbIma);
        lbIma.setIcon(fondo);
        lbIma.setSize(1400, 800);
        lbIma.setLocation(0, 0);
        lbIma.setVisible(true);

        log.setFont(new Font("Arial Black", 0, 36));
        log.setForeground(Color.WHITE);
        log.setBounds(30, 5, 300, 100);

        lbIma.add(log);

        b2.setBounds(100, 90, 130, 40);
        b2.addActionListener(this);
        b2.setActionCommand("Listar");
        b2.setFont(new Font("Arial Black", 0, 13));
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.ORANGE);

        b1.setBounds(280, 90, 130, 40);
        b1.addActionListener(this);
        b1.setActionCommand("Consultar");
        b1.setFont(new Font("Arial Black", 0, 13));
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.ORANGE);

        b7.setBounds(700, 600, 130, 40);
        b7.addActionListener(this);
        b7.setActionCommand("Generar-PDF");
        b7.setFont(new Font("Arial Black", 0, 13));
        b7.setForeground(Color.WHITE);
        b7.setBackground(Color.ORANGE);

        b8.setBounds(1100, 600, 200, 40);
        b8.addActionListener(this);
        b8.setActionCommand("Regresar a Preguntas");
        b8.setFont(new Font("Arial Black", 0, 13));
        b8.setForeground(Color.WHITE);
        b8.setBackground(Color.RED);

        lbIma.add(b1);
        lbIma.add(b2);
        lbIma.add(b7);
        lbIma.add(b8);

        tf1.setBounds(450, 100, 100, 25);
        tf2.setBounds(600, 100, 100, 25);
        tf3.setBounds(750, 100, 100, 25);

        tf4.setBounds(1000, 30, 80, 25);
        tf5.setBounds(1000, 70, 80, 25);
        tf6.setBounds(1000, 110, 80, 25);
        tf7.setBounds(1000, 150, 80, 25);
        tf8.setBounds(1000, 190, 80, 25);
        tf9.setBounds(1000, 230, 80, 25);
        tf10.setBounds(1000, 270, 80, 25);
        tf11.setBounds(1000, 310, 80, 25);
        tf12.setBounds(1000, 350, 80, 25);

        ta.setBounds(1000, 390, 315, 190);

        tf13.setBounds(1200, 80, 100, 25);
        tf14.setBounds(1200, 180, 100, 25);
        tf15.setBounds(1200, 280, 100, 25);

        lbIma.add(tf1);
        lbIma.add(tf2);
        lbIma.add(tf3);

        lbIma.add(tf4);
        lbIma.add(tf5);
        lbIma.add(tf6);
        lbIma.add(tf7);
        lbIma.add(tf8);
        lbIma.add(tf9);
        lbIma.add(tf10);
        lbIma.add(tf11);
        lbIma.add(tf12);

        lbIma.add(ta);

        lbIma.add(tf13);
        lbIma.add(tf14);
        lbIma.add(tf15);

        tb1.setForeground(Color.BLACK);
        tb1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tb1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {

                int seleccion = tb1.rowAtPoint(evt.getPoint());

                /* seleccion devolvera -1 si se ha clicado fuera de la fila pero dentro de la tabla, si no devolvera el indice de la fila en la que se ha clicado. */
                tf1.setText((String.valueOf(tb1.getValueAt(seleccion, 0))));
                tf2.setText((String.valueOf(tb1.getValueAt(seleccion, 1))));
                tf3.setText((String.valueOf(tb1.getValueAt(seleccion, 2))));
                tf4.setText((String.valueOf(tb1.getValueAt(seleccion, 3))));
                tf5.setText((String.valueOf(tb1.getValueAt(seleccion, 4))));
                tf6.setText((String.valueOf(tb1.getValueAt(seleccion, 5))));
                tf7.setText((String.valueOf(tb1.getValueAt(seleccion, 6))));
                tf8.setText((String.valueOf(tb1.getValueAt(seleccion, 7))));
                tf9.setText((String.valueOf(tb1.getValueAt(seleccion, 8))));
                tf10.setText((String.valueOf(tb1.getValueAt(seleccion, 9))));
                tf11.setText((String.valueOf(tb1.getValueAt(seleccion, 10))));
                tf12.setText((String.valueOf(tb1.getValueAt(seleccion, 11))));


            }
        });

        lbIma.add(sp);
        sp.setBounds(60, 150, 800, 410);

        add(p1);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String p = e.getActionCommand();

        if (p.equals("Consultar")) {

            try {
                conn = Conexion.getConnnection();
                ps = conn.prepareStatement("SELECT no_cuenta,nombres,apellidos,resp1,resp2,resp3,resp4,resp5,resp6,resp7,resp8,resp9,comentarios,materia_tutor,fecha,area from evaluacion WHERE no_cuenta = ?");

                ps.setString(1, tf1.getText());

                rs = ps.executeQuery();

                if (rs.next()) {
                    tf1.setText(rs.getString("no_cuenta"));
                    tf2.setText(rs.getString("nombres"));
                    tf3.setText(rs.getString("apellidos"));
                    tf4.setText(rs.getString("resp1"));
                    tf5.setText(rs.getString("resp2"));
                    tf6.setText(rs.getString("resp3"));
                    tf7.setText(rs.getString("resp4"));
                    tf8.setText(rs.getString("resp5"));
                    tf9.setText(rs.getString("resp6"));
                    tf10.setText(rs.getString("resp7"));
                    tf11.setText(rs.getString("resp8"));
                    tf12.setText(rs.getString("resp9"));
                    ta.setText(rs.getString("comentarios"));
                    tf13.setText(rs.getString("materia_tutor"));
                    tf14.setText(rs.getString("fecha"));
                    tf15.setText(rs.getString("area"));

                } else {
                    JOptionPane.showMessageDialog(null, "No se encontro ningun alumno con esa cuenta");
                }

            } catch (Exception ex) {
                System.out.println(ex);
            }

        } else if (p.equals("Listar")) {

            try {
                //Para establecer el modelo al JTable
                DefaultTableModel modelo = new DefaultTableModel();
                this.tb1.setModel(modelo);
                //Para conectarnos a nuestra base de datos
                String url = "jdbc:oracle:thin:@localhost:1521:XE";
                // Establecemos los valores de cadena de conexión, usuario y contraseña
                conn = DriverManager.getConnection(url, "system", "system");
                //Para ejecutar la consulta
                s = conn.createStatement();
                //Ejecutamos la consulta y los datos lo almacenamos en un ResultSet
                rs = s.executeQuery("select no_cuenta,nombres,apellidos,resp1,resp2,resp3,resp4,resp5,resp6,resp7,resp8,resp9 from evaluacion");
                //Obteniendo la informacion de las columnas que estan siendo consultadas
                ResultSetMetaData rsMd = rs.getMetaData();
                //La cantidad de columnas que tiene la consulta
                int cantidadColumnas = rsMd.getColumnCount();
                //Establecer como cabezeras el nombre de las colimnas
                for (int i = 1; i <= cantidadColumnas; i++) {
                    modelo.addColumn(rsMd.getColumnLabel(i));
                }
                //Creando las filas para el JTable
                while (rs.next()) {
                    Object[] fila = new Object[cantidadColumnas];
                    for (int i = 0; i < cantidadColumnas; i++) {
                        fila[i] = rs.getObject(i + 1);
                    }
                    modelo.addRow(fila);
                }
                rs.close();
                conn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (p.equals("Generar-PDF")) {
            Document documento = new Document();

            try {
                String ruta = System.getProperty("user.home");
                PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Evaluacion.pdf"));
                
                Paragraph parrafo = new Paragraph();
                parrafo.setAlignment(Paragraph.ALIGN_CENTER);
                parrafo.add("Formato de Evaluacion © \n\n");
                parrafo.setFont(FontFactory.getFont("Arial", 8, Font.BOLD, BaseColor.DARK_GRAY));
                parrafo.add("EVALUACION DE ALUMNOS \n\n");
                
                documento.open();
                documento.add(parrafo);

                PdfPTable tabla = new PdfPTable(12);
                tabla.setWidthPercentage(100);
                tabla.addCell("no_cuenta");
                tabla.addCell("nombres");
                tabla.addCell("apellidos");
                tabla.addCell("resp1");
                tabla.addCell("resp2");
                tabla.addCell("resp3");
                tabla.addCell("resp4");
                tabla.addCell("resp5");
                tabla.addCell("resp6");
                tabla.addCell("resp7");
                tabla.addCell("resp8");
                tabla.addCell("resp9");

                try {
                    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "system");
                    PreparedStatement pst = conn.prepareStatement("select * from evaluacion");

                    ResultSet rs = pst.executeQuery();

                    if (rs.next()) {

                        do {
                            tabla.addCell(rs.getString(1));
                            tabla.addCell(rs.getString(2));
                            tabla.addCell(rs.getString(3));
                            tabla.addCell(rs.getString(4));
                            tabla.addCell(rs.getString(5));
                            tabla.addCell(rs.getString(6));
                            tabla.addCell(rs.getString(7));
                            tabla.addCell(rs.getString(8));
                            tabla.addCell(rs.getString(9));
                            tabla.addCell(rs.getString(10));
                            tabla.addCell(rs.getString(11));
                            tabla.addCell(rs.getString(12));

                        } while (rs.next());
                        documento.add(tabla);
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                documento.close();
                JOptionPane.showMessageDialog(null, "Reporte creado.");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (p.equals("Regresar a Preguntas")) {

            new Evaluacion();
            this.dispose();

        }

    }

}
