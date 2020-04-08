package cade;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import java.awt.*;


public class Evaluacion extends JFrame implements ActionListener {

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    Statement s;

    public JButton b1 = new JButton("Ver Preguntas");
    public JButton b3 = new JButton("Editar Preguntas");
    public JButton b6 = new JButton("Limpiar");
    public JButton b2 = new JButton("Ver Respuestas");
    public JButton b7 = new JButton("Generar-PDF");
    public JButton b8 = new JButton("Regresar al menu");
    public JLabel log = new JLabel("CADE-PRO ");

//    public JLabel lCuenta = new JLabel("No. Cuenta: ");
    public JComboBox cb = new JComboBox();
    public JTextField t1 = new JTextField();
    public JTextField t2 = new JTextField();
    public JTextField t3 = new JTextField();
    public JTextField t4 = new JTextField();
    public JTextField t5 = new JTextField();
    public JTextField t6 = new JTextField();
    public JTextField t7 = new JTextField();
    public JTextField t8 = new JTextField();
    public JTextField t9 = new JTextField();

    public JButton bCSe = new JButton("Cerrar Sesion");
    public JLabel lLogo = new JLabel("LOGO");
    public JPanel p1 = new JPanel();

    public JLabel logo = new JLabel("CADE-PRO ");
    public JLabel lbIma = new JLabel();
    public ImageIcon fondo;

    public Evaluacion() {

        add(p1);
        p1.setLayout(null);

        fondo = new ImageIcon("..\\Cade\\imagenes\\fondo.jpg");
        p1.add(lbIma);
        lbIma.setIcon(fondo);
        lbIma.setSize(1400, 800);
        lbIma.setLocation(0, 0);
        lbIma.setVisible(true);

        b1.setBounds(100, 90, 180, 40);
        b1.addActionListener(this);
        b1.setActionCommand("Ver Preguntas");
        b1.setFont(new Font("Arial Black", 0, 13));
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.ORANGE);
        
        b2.setBounds(1100, 90, 180, 40);
        b2.addActionListener(this);
        b2.setActionCommand("Ver Respuestas");
        b2.setFont(new Font("Arial Black", 0, 13));
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.ORANGE);

        b3.setBounds(300, 90, 180, 40);
        b3.addActionListener(this);
        b3.setActionCommand("Editar Preguntas");
        b3.setFont(new Font("Arial Black", 0, 13));
        b3.setForeground(Color.WHITE);
        b3.setBackground(Color.ORANGE);

        b6.setBounds(500, 90, 130, 40);
        b6.addActionListener(this);
        b6.setActionCommand("Limpiar");
        b6.setFont(new Font("Arial Black", 0, 13));
        b6.setForeground(Color.WHITE);
        b6.setBackground(Color.ORANGE);

        b8.setBounds(1100, 600, 190, 40);
        b8.addActionListener(this);
        b8.setActionCommand("Regresar al menu");
        b8.setFont(new Font("Arial Black", 0, 13));
        b8.setForeground(Color.WHITE);
        b8.setBackground(Color.RED);

        lbIma.add(b1);
        lbIma.add(b2);
        lbIma.add(b3);

        lbIma.add(b6);
        lbIma.add(b7);
        lbIma.add(b8);

        log.setFont(new Font("Arial Black", 0, 36));
        log.setForeground(Color.WHITE);
        log.setBounds(30, 5, 300, 100);
//        lCuenta.setBounds(100, 180, 100, 40);
//        lCuenta.setForeground(Color.WHITE);

        lbIma.add(log);
//        lbIma.add(lCuenta);

        cb.setBounds(655, 90, 190, 40);
        cb.setBackground(Color.ORANGE);
        cb.setForeground(Color.WHITE);
        cb.setFont(new Font("Arial Black", 0, 13));
        cb.addItem("Seleccionar");
        cb.addItem("Asesores");
        cb.addItem("Tutores");

        t1.setBounds(300, 185, 650, 25);
        t2.setBounds(300, 235, 650, 25);
        t3.setBounds(300, 285, 650, 25);
        t4.setBounds(300, 335, 650, 25);
        t5.setBounds(300, 385, 650, 25);
        t6.setBounds(300, 435, 650, 25);
        t7.setBounds(300, 485, 650, 25);
        t8.setBounds(300, 535, 650, 25);
        t9.setBounds(300, 585, 650, 25);
        
        lbIma.add(cb);
        lbIma.add(t1);
        lbIma.add(t2);
        lbIma.add(t3);
        lbIma.add(t4);
        lbIma.add(t5);
        lbIma.add(t6);
        lbIma.add(t7);
        lbIma.add(t8);
        lbIma.add(t9);
      
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

        if (p.equals("Ver Preguntas")) {

            try {
                conn = Conexion.getConnnection();
                ps = conn.prepareStatement("SELECT tipo,pregunta1,pregunta2,pregunta3,pregunta4,pregunta5,pregunta6,pregunta7,pregunta8,pregunta9  FROM pre_evaluacion WHERE tipo = ?");

                ps.setString(1, (String) cb.getSelectedItem());

                rs = ps.executeQuery();

                if (rs.next()) {
                    t1.setText(rs.getString("pregunta1"));
                    t2.setText(rs.getString("pregunta2"));
                    t3.setText(rs.getString("pregunta3"));
                    t4.setText(rs.getString("pregunta4"));
                    t5.setText(rs.getString("pregunta5"));
                    t6.setText(rs.getString("pregunta6"));
                    t7.setText(rs.getString("pregunta7"));
                    t8.setText(rs.getString("pregunta8"));
                    t9.setText(rs.getString("pregunta9"));

                } else {
                    JOptionPane.showMessageDialog(null, "No se encontro ningun alumno con esa cuenta");
                }

            } catch (Exception ex) {
                System.out.println(ex);
            }

        } else if (p.equals("Editar Preguntas")) {

            try {
                conn = Conexion.getConnnection();
                ps = conn.prepareStatement("UPDATE pre_evaluacion SET tipo =?, pregunta1 =?, pregunta2 =?,pregunta3 =?, pregunta4 = ?, pregunta5 =?, pregunta6 = ?,pregunta7 = ?, pregunta8 =?, pregunta9 = ? WHERE tipo = ? ");

                ps.setString(1, (String) cb.getSelectedItem());
                ps.setString(2, t1.getText());
                ps.setString(3, t2.getText());
                ps.setString(4, t3.getText());
                ps.setString(5, t4.getText());
                ps.setString(6, t5.getText());
                ps.setString(7, t6.getText());
                ps.setString(8, t7.getText());
                ps.setString(9, t8.getText());
                ps.setString(10, t9.getText());

                ps.setString(11, (String) cb.getSelectedItem());

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

        } else if (p.equals("Limpiar")) {

            t1.setText(null);
            t2.setText(null);
            t3.setText(null);
            t4.setText(null);
            t5.setText(null);
            t6.setText(null);
            t7.setText(null);
            t8.setText(null);
            t9.setText(null);

        }  else if (p.equals("Ver Respuestas")) {

            new Respuestas();
            this.dispose();

        }else if (p.equals("Regresar al menu")) {

            new Menu();
            this.dispose();

        }

    }
}
