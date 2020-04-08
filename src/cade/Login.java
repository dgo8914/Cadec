package cade;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    String sql;

    public JLabel lbIma = new JLabel();
    public JLabel lUnitec = new JLabel();
    public JLabel l1 = new JLabel("Ususario");
    public JLabel l2 = new JLabel("Contraseña");
    public JLabel logo = new JLabel("CADE-PRO ");

    public JLabel lPersonas = new JLabel();
    public JTextField t1 = new JTextField();
    public JPasswordField t2 = new JPasswordField();
    public JButton b1 = new JButton("Iniciar Sesion");
    public JPanel p1 = new JPanel();

    public ImageIcon fondo;
    public ImageIcon unitec;
    public ImageIcon franja;
    public ImageIcon personas;

    public Login() {

        add(p1);
        p1.setLayout(null);

        fondo = new ImageIcon("..\\Cade\\imagenes\\fondo.jpg");
        p1.add(lbIma);
        lbIma.setIcon(fondo);
        lbIma.setSize(780, 800);
        lbIma.setLocation(0, 0);
        lbIma.setVisible(true);

        lbIma.add(logo);
        logo.setFont(new Font("Arial Black", 0, 36));
        logo.setForeground(Color.WHITE);
        logo.setBounds(30, 5, 300, 100);

        unitec = new ImageIcon("..\\Cade\\imagenes\\unitec.jpg");
        lbIma.add(lUnitec);
        lUnitec.setIcon(unitec);
        lUnitec.setSize(500, 500);
        lUnitec.setLocation(290, 2);
        lUnitec.setVisible(true);


        personas = new ImageIcon("..\\Cade\\imagenes\\personas.png");
        p1.add(lPersonas);
        lPersonas.setIcon(personas);
        lPersonas.setSize(600, 650);
        lPersonas.setLocation(850, 30);
        lPersonas.setVisible(true);

        lbIma.add(l1);
        lbIma.add(l2);
        l1.setBounds(270, 370, 80, 30);
        l1.setForeground(Color.WHITE);
        l2.setBounds(270, 420, 80, 30);
        l2.setForeground(Color.WHITE);

        lbIma.add(t1);
        lbIma.add(t2);
        t1.setBounds(370, 370, 150, 30);
        t2.setBounds(370, 420, 150, 30);

        lbIma.add(b1);
        b1.setBounds(320, 480, 150, 60);

        b1.addActionListener(this);
        b1.setActionCommand("Iniciar Sesion");
        b1.setFont(new Font("Arial Black", 0, 13));
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.ORANGE);

        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

    }

    public void actionPerformed(ActionEvent e) {
        String p = e.getActionCommand();

        if (p.equals("Iniciar Sesion")) {
            loginusuario(t1.getText(), t2.getText());
        }

    }

    private void loginusuario(String usuario, String contraseña) {

        String T_Usuario;

        try {
            conn = Conexion.getConnnection();
            sql = "SELECT * FROM usuarios_cade WHERE correo = '" + usuario + "' AND no_cuenta = '" + contraseña + "'";

            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();

            if (rs.next()) {

                if (usuario != null && contraseña != null) {

                    T_Usuario = rs.getString("tipo_usuario");

                    switch (T_Usuario) {

                        case "1":

                            JOptionPane.showMessageDialog(null, "sesion Iniciada");
                            new Menu();
                            this.dispose();
                            break;

                        case "2":
                             JOptionPane.showMessageDialog(null, "sesion Iniciada");
                            new Alumnos();
                            this.dispose();
                            break;

                    }

                }

            } else {
                JOptionPane.showMessageDialog(null, "Usuario y/ó Contraseña Incorrectos");
            }
            conn.close();

        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

}
