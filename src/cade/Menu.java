package cade;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener {

    public JLabel logo = new JLabel("CADE-PRO ");
    public JLabel lMenu = new JLabel("MENU");
    public JLabel lbIma = new JLabel();

    public JButton bAlum = new JButton();
    public JButton bHora = new JButton();
    public JButton bProf = new JButton();
    public JButton bLista = new JButton();
    public JButton bEvaluacion = new JButton();
    public JButton bTutor = new JButton();
    public JButton bCerrar = new JButton("Cerrar sesion");

    public JLabel lAlum = new JLabel("Alumnos");
    public JLabel lHora = new JLabel("Horario");
    public JLabel lProf = new JLabel("Asesore");
    public JLabel lLista = new JLabel("Asistencia");
    public JLabel lEvaluacion = new JLabel("Evaluación");
    public JLabel lTutor = new JLabel("Tutores");


    public JPanel p1 = new JPanel();

    public ImageIcon fondo;
    public ImageIcon alumno;
    public ImageIcon horario;
    public ImageIcon profesor;
    public ImageIcon lista;
    public ImageIcon evaluacion;
    public ImageIcon tutores;

    public Menu() {

        add(p1);
        p1.setLayout(null);

        fondo = new ImageIcon("..\\Cade\\imagenes\\fondo.jpg");
        p1.add(lbIma);
        lbIma.setIcon(fondo);
        lbIma.setSize(1400, 800);
        lbIma.setLocation(0, 0);
        lbIma.setVisible(true);

        lbIma.add(logo);
        logo.setFont(new Font("Arial Black", 0, 36));
        logo.setForeground(Color.WHITE);
        logo.setBounds(30, 5, 300, 100);

        lbIma.add(lMenu);
        lMenu.setFont(new Font("Arial Black", 0, 36));
        lMenu.setForeground(Color.WHITE);
        lMenu.setBounds(610, 60, 300, 100);

        alumno = new ImageIcon("..\\Cade\\imagenes\\alumnos.png");
        bAlum = new JButton(alumno);
        lbIma.add(bAlum);
        bAlum.addActionListener(this);
        bAlum.setActionCommand("Alumnos");
        bAlum.setSize(100, 100);
        bAlum.setLocation(400, 200);
        bAlum.setContentAreaFilled(false);
        bAlum.setVisible(true);

        lbIma.add(lAlum);
        lAlum.setFont(new Font("Arial Black", 0, 16));
        lAlum.setForeground(Color.WHITE);
        lAlum.setBounds(415, 280, 100, 100);

        horario = new ImageIcon("..\\Cade\\imagenes\\horario.png");
        bHora = new JButton(horario);
        lbIma.add(bHora);
        bHora.addActionListener(this);
        bHora.setActionCommand("Horario");
        bHora.setSize(100, 100);
        bHora.setLocation(620, 200);
        bHora.setContentAreaFilled(false);
        bHora.setVisible(true);

        lbIma.add(lHora);
        lHora.setFont(new Font("Arial Black", 0, 16));
        lHora.setForeground(Color.WHITE);
        lHora.setBounds(635, 280, 100, 100);

        profesor = new ImageIcon("..\\Cade\\imagenes\\profesor.png");
        bProf = new JButton(profesor);
        lbIma.add(bProf);
        bProf.addActionListener(this);
        bProf.setActionCommand("Asesores");
        bProf.setSize(100, 100);
        bProf.setLocation(840, 200);
        bProf.setContentAreaFilled(false);
        bProf.setVisible(true);

        lbIma.add(lProf);
        lProf.setFont(new Font("Arial Black", 0, 16));
        lProf.setForeground(Color.WHITE);
        lProf.setBounds(855, 280, 200, 100);

        lista = new ImageIcon("..\\Cade\\imagenes\\lista.png");
        bLista = new JButton(lista);
        lbIma.add(bLista);
        bLista.addActionListener(this);
        bLista.setActionCommand("Asistencia");
        bLista.setSize(100, 100);
        bLista.setLocation(400, 410);
        bLista.setContentAreaFilled(false);
        bLista.setVisible(true);

        lbIma.add(lLista);
        lLista.setFont(new Font("Arial Black", 0, 16));
        lLista.setForeground(Color.WHITE);
        lLista.setBounds(405, 480, 200, 100);

        evaluacion = new ImageIcon("..\\Cade\\imagenes\\evaluacion.png");
        bEvaluacion = new JButton(evaluacion);
        lbIma.add(bEvaluacion);
        bEvaluacion.addActionListener(this);
        bEvaluacion.setActionCommand("Evaluacion");
        bEvaluacion.setSize(100, 100);
        bEvaluacion.setLocation(625, 410);
        bEvaluacion.setContentAreaFilled(false);
        bEvaluacion.setVisible(true);

        lbIma.add(lEvaluacion);
        lEvaluacion.setFont(new Font("Arial Black", 0, 16));
        lEvaluacion.setForeground(Color.WHITE);
        lEvaluacion.setBounds(625, 480, 200, 100);
        
        tutores = new ImageIcon("..\\Cade\\imagenes\\tutor.png");
        bTutor = new JButton(tutores);
        lbIma.add(bTutor);
        bTutor.addActionListener(this);
        bTutor.setActionCommand("Tutores");
        bTutor.setSize(100, 100);
        bTutor.setLocation(840, 410);
        bTutor.setContentAreaFilled(false);
        bTutor.setVisible(true);

        lbIma.add(lTutor);
        lTutor.setFont(new Font("Arial Black", 0, 16));
        lTutor.setForeground(Color.WHITE);
        lTutor.setBounds(855, 480, 200, 100);
        
        
        bCerrar.setBounds(1100, 600, 190, 40);
        bCerrar.addActionListener(this);
        bCerrar.setActionCommand("Cerrar sesion");
        bCerrar.setFont(new Font("Arial Black", 0, 13));
        bCerrar.setForeground(Color.WHITE);
        bCerrar.setBackground(Color.RED);
        lbIma.add(bCerrar);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String s = e.getActionCommand();

        if (s.equals("Alumnos")) {

            new Alumnos();
            this.dispose();

        }else if (s.equals("Asistencia")) {

            new Asistencia();
            this.dispose();

        }else if (s.equals("Asesores")) {

            new Asesores();
            this.dispose();

        }else if (s.equals("Tutores")) {

            new Tutores();
            this.dispose();

        }else if (s.equals("Evaluacion")) {

            new Evaluacion();
            this.dispose();

        }else if (s.equals("Horario")) {

            new Horario();
            this.dispose();

        }else if (s.equals("Cerrar sesion")) {

            new Login();
            this.dispose();

        }


    }
}
