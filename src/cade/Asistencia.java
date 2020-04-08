
package cade;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.BaseColor;
import java.io.FileOutputStream;


public class Asistencia extends JFrame implements ActionListener{
    
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    Statement s;

    public JButton b1 = new JButton("Consultar");
    public JButton b2 = new JButton("Listar");
    public JButton b3 = new JButton("Modificar");
    public JButton b4 = new JButton("Eliminar");
    public JButton b5 = new JButton("Limpiar");
    public JButton b6 = new JButton("Registrar");
    public JButton b7 = new JButton("Generar-PDF");
    public JButton b8 = new JButton("Regresar al menu");

    public JLabel lCuenta = new JLabel("No. Cuenta: ");
    public JLabel lNombre = new JLabel("Nombres: ");
    public JLabel lApellido = new JLabel("Apellidos: ");
    public JLabel lAsesoria = new JLabel("Asesorias Tomadas: ");
    public JLabel lFecha = new JLabel("Fecha ");
    public JLabel lTutor = new JLabel("Tutor Asignado: ");
    public JLabel lAsT = new JLabel("Asistencia tutor: ");


    public JTextField t1 = new JTextField();
    public JTextField t2 = new JTextField();
    public JTextField t3 = new JTextField();
    public JTextField t4 = new JTextField();
    public JTextField t5 = new JTextField();
    public JTextField t6 = new JTextField();
    public JTextField t7 = new JTextField();
    public JTextField t8 = new JTextField("2");

    public JLabel lLogo = new JLabel("LOGO");
    public JPanel p1 = new JPanel();

    public JTable tb1 = new JTable();
    public JScrollPane sp = new JScrollPane(tb1);

    public JLabel logo = new JLabel("CADE-PRO ");
    public JLabel lbIma = new JLabel();
    public ImageIcon fondo;

    public Asistencia() {
        
        
        add(p1);
        p1.setLayout(null);

        fondo = new ImageIcon("..\\Cade\\imagenes\\fondo.jpg");
        p1.add(lbIma);
        lbIma.setIcon(fondo);
        lbIma.setSize(1400, 800);
        lbIma.setLocation(0, 0);
        lbIma.setVisible(true);

        b1.setBounds(100, 90, 130, 40);
        b1.addActionListener(this);
        b1.setActionCommand("Consultar");
        b1.setFont(new Font("Arial Black", 0, 13));
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.ORANGE);

        b2.setBounds(300, 90, 130, 40);
        b2.addActionListener(this);
        b2.setActionCommand("Listar");
        b2.setFont(new Font("Arial Black", 0, 13));
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.ORANGE);

        b3.setBounds(500, 90, 130, 40);
        b3.addActionListener(this);
        b3.setActionCommand("Modificar");
        b3.setFont(new Font("Arial Black", 0, 13));
        b3.setForeground(Color.WHITE);
        b3.setBackground(Color.ORANGE);

        b4.setBounds(700, 90, 130, 40);
        b4.addActionListener(this);
        b4.setActionCommand("Eliminar");
        b4.setFont(new Font("Arial Black", 0, 13));
        b4.setForeground(Color.WHITE);
        b4.setBackground(Color.ORANGE);

        b5.setBounds(900, 90, 130, 40);
        b5.addActionListener(this);
        b5.setActionCommand("Limpiar");
        b5.setFont(new Font("Arial Black", 0, 13));
        b5.setForeground(Color.WHITE);
        b5.setBackground(Color.ORANGE);

        b6.setBounds(1100, 90, 130, 40);
        b6.addActionListener(this);
        b6.setActionCommand("Registrar");
        b6.setFont(new Font("Arial Black", 0, 13));
        b6.setForeground(Color.WHITE);
        b6.setBackground(Color.ORANGE);

        b7.setBounds(700, 600, 130, 40);
        b7.addActionListener(this);
        b7.setActionCommand("Generar-PDF");
        b7.setFont(new Font("Arial Black", 0, 13));
        b7.setForeground(Color.WHITE);
        b7.setBackground(Color.ORANGE);

        b8.setBounds(1100, 600, 190, 40);
        b8.addActionListener(this);
        b8.setActionCommand("Regresar al menu");
        b8.setFont(new Font("Arial Black", 0, 13));
        b8.setForeground(Color.WHITE);
        b8.setBackground(Color.RED);

        lbIma.add(b1);
        lbIma.add(b2);
        lbIma.add(b3);
        lbIma.add(b4);
        lbIma.add(b5);
        lbIma.add(b6);
        lbIma.add(b7);
        lbIma.add(b8);

        logo.setFont(new Font("Arial Black", 0, 36));
        logo.setForeground(Color.WHITE);
        logo.setBounds(30, 5, 300, 100);
        lCuenta.setBounds(100, 180, 100, 40);
        lCuenta.setForeground(Color.WHITE);
        lNombre.setBounds(100, 230, 100, 40);
        lNombre.setForeground(Color.WHITE);
        lApellido.setBounds(100, 280, 100, 40);
        lApellido.setForeground(Color.WHITE);
        lAsesoria.setBounds(100, 330, 170, 40);
        lAsesoria.setForeground(Color.WHITE);
        lFecha.setBounds(100, 380, 100, 40);
        lFecha.setForeground(Color.WHITE);
        lTutor.setBounds(100, 430, 100, 40);
        lTutor.setForeground(Color.WHITE);
        lAsT.setBounds(100, 480, 100, 40);
        lAsT.setForeground(Color.WHITE);

        lbIma.add(logo);
        lbIma.add(lCuenta);
        lbIma.add(lNombre);
        lbIma.add(lApellido);
        lbIma.add(lAsesoria);
        lbIma.add(lFecha);
        lbIma.add(lTutor);
        lbIma.add(lAsT);

        t1.setBounds(200, 185, 100, 25);
        t2.setBounds(200, 235, 170, 25);
        t3.setBounds(200, 285, 170, 25);
        t4.setBounds(230, 335, 190, 25);
        t5.setBounds(200, 385, 100, 25);
        t6.setBounds(200, 435, 170, 25);
        t7.setBounds(200, 485, 100, 25);

        lbIma.add(t1);
        lbIma.add(t2);
        lbIma.add(t3);
        lbIma.add(t4);
        lbIma.add(t5);
        lbIma.add(t6);
        lbIma.add(t7);

//        tb1.setBackground(Color.BLUE);
//        tb1.setForeground(Color.WHITE);
        tb1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tb1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {

                int seleccion = tb1.rowAtPoint(evt.getPoint());

                /* seleccion devolvera -1 si se ha clicado fuera de la fila pero dentro de la tabla, si no devolvera el indice de la fila en la que se ha clicado. */
                t1.setText((String.valueOf(tb1.getValueAt(seleccion, 0))));
                t2.setText((String.valueOf(tb1.getValueAt(seleccion, 1))));
                t3.setText((String.valueOf(tb1.getValueAt(seleccion, 2))));
                t4.setText((String.valueOf(tb1.getValueAt(seleccion, 3))));
                t5.setText((String.valueOf(tb1.getValueAt(seleccion, 4))));
                t6.setText((String.valueOf(tb1.getValueAt(seleccion, 5))));
                t7.setText((String.valueOf(tb1.getValueAt(seleccion, 6))));

            }
        });

        lbIma.add(sp);
        sp.setBounds(450, 170, 840, 400);

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
                ps = conn.prepareStatement("SELECT no_cuenta,nombres,apellidos,asesorias_tomadas,fecha,tutor_asignado,asistencia_t  FROM asistencia WHERE no_cuenta = ?");

                ps.setString(1, t1.getText());

                rs = ps.executeQuery();

                if (rs.next()) {
                    t1.setText(rs.getString("no_cuenta"));
                    t2.setText(rs.getString("nombres"));
                    t3.setText(rs.getString("apellidos"));
                    t4.setText(rs.getString("asesorias_tomadas"));
                    t5.setText(rs.getString("fecha"));
                    t6.setText(rs.getString("tutor_asignado"));
                    t7.setText(rs.getString("asistencia_t"));

                } else {
                    JOptionPane.showMessageDialog(null, "No se encontro ningun alumno con esa cuenta");
                }

            } catch (Exception ex) {
                System.out.println(ex);
            }

        } else if (p.equals("Registrar")) {

            try {
//                conn = Conexion.getConnnection();
//
//                ps = conn.prepareStatement("INSERT INTO asistencia (no_cuenta, nombres, apellidos, tipo_usuario) VALUES(?,?,?,?,?)");
//
//                ps.setString(1, t1.getText());
//                ps.setString(2, t2.getText());
//                ps.setString(3, t3.getText());
//                ps.setString(4, t4.getText());
//                ps.setString(5, t8.getText());
//
//                ps.executeUpdate();

                ps = conn.prepareStatement("INSERT INTO asistencia (no_cuenta, nombres, apellidos, asesorias_tomadas, fecha, tutor_asignado, asistencia_t) VALUES(?,?,?,?,?,?,?)");

                ps.setString(1, t1.getText());
                ps.setString(2, t2.getText());
                ps.setString(3, t3.getText());
                ps.setString(4, t4.getText());
                ps.setString(5, t5.getText());
                ps.setString(6, t6.getText());
                ps.setString(7, t7.getText());

                String botones[] = {"si", "no"};
                int eleccion = JOptionPane.showOptionDialog(this, "Realmente desea Registrar Asistencia?", p, 0, 0, null, botones, this);
                if (eleccion == JOptionPane.YES_OPTION) {
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Registro Exitoso");
                } else if (eleccion == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(null, "Se cancelo Registro");
                }

            } catch (Exception ex) {
                System.out.println(ex);
            }

        } else if (p.equals("Modificar")) {

            try {
                conn = Conexion.getConnnection();
                ps = conn.prepareStatement("UPDATE asistencia SET no_cuenta =?, nombres =?, apellidos =?,asesorias_tomadas =?, fecha = ?, tutor_asignado =?, asistencia_t = ? WHERE no_cuenta = ? ");

                ps.setString(1, t1.getText());
                ps.setString(2, t2.getText());
                ps.setString(3, t3.getText());
                ps.setString(4, t4.getText());
                ps.setString(5, t5.getText());
                ps.setString(6, t6.getText());
                ps.setString(7, t7.getText());

                ps.setString(8, t1.getText());

             

//                ps = conn.prepareStatement("UPDATE usuarios_cade SET no_cuenta =?,correo =?, nombres =?, apellidos =? tipo_usuario = ? WHERE no_cuenta = ? ");
//
//                ps.setString(1, t1.getText());
//                ps.setString(2, t2.getText());
//                ps.setString(3, t3.getText());
//                ps.setString(4, t4.getText());
//                ps.setString(5, t8.getText());
//
//                ps.setString(6, t1.getText());
                String botones[] = {"si", "no"};
                int eleccion = JOptionPane.showOptionDialog(this, "Realmente desea Modificar Asistencia?", p, 0, 0, null, botones, this);
                if (eleccion == JOptionPane.YES_OPTION) {
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Modificacion Exitosa");
                } else if (eleccion == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(null, "Se cancelo Modificacion");
                }

            } catch (Exception ex) {
                System.out.println(ex);
            }

        } else if (p.equals("Eliminar")) {

            try {
                conn = Conexion.getConnnection();
                ps = conn.prepareStatement("DELETE FROM asistencia WHERE no_cuenta = ?");

                ps.setString(1, t1.getText());

//                ps.executeUpdate();
//
//                ps = conn.prepareStatement("DELETE FROM usuarios_cade WHERE no_cuenta = ?");
//                ps.setString(1, t1.getText());

                String botones[] = {"si", "no"};
                int eleccion = JOptionPane.showOptionDialog(this, "Realmente desea Eliminar Asistencia?", p, 0, 0, null, botones, this);
                if (eleccion == JOptionPane.YES_OPTION) {
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Eliminacion Exitosa");
                } else if (eleccion == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(null, "Se cancelo Eliminacion");
                }

            } catch (Exception ex) {
                System.out.println(ex);
            }

        } else if (p.equals("Limpiar")) {

            t1.setText(null);
            t2.setText(null);
            t3.setText(null);
            t4.setText(null);
            t5.setText(null);
            t6.setText(null);
            t7.setText(null);

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
                rs = s.executeQuery("select no_cuenta,nombres,apellidos,asesorias_tomadas,fecha,tutor_asignado,asistencia_t from asistencia");
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
      
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (p.equals("Generar-PDF")) {
            Document documento = new Document();

            try {
                String ruta = System.getProperty("user.home");
                PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Asistencia.pdf"));
                
                Paragraph parrafo = new Paragraph();
                parrafo.setAlignment(Paragraph.ALIGN_CENTER);
                parrafo.add("Formato de asistencia © \n\n");
                parrafo.setFont(FontFactory.getFont("Arial", 8, Font.BOLD, BaseColor.DARK_GRAY));
                parrafo.add("ASISTENCIA DE ALUMNOS \n\n");
                
                documento.open();
                documento.add(parrafo);

                PdfPTable tabla = new PdfPTable(7);
                tabla.setWidthPercentage(100);
                tabla.addCell("no_cuenta");
                tabla.addCell("nombres");
                tabla.addCell("apellidos");
                tabla.addCell("asesorias_tomadas");
                tabla.addCell("fecha");
                tabla.addCell("tutor_asignado");
                tabla.addCell("asistencia_t");

                try {
                    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "system");
                    PreparedStatement pst = conn.prepareStatement("select * from asistencia");

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
        } else if (p.equals("Regresar al menu")) {

            new Menu();
            this.dispose();

        }

    
    
        
        
        
        
    }
}
