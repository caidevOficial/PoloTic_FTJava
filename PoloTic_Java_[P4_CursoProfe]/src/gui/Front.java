/*
 * Copyright (C) 2020 FacuFalcone - CaidevOficial
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package gui;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import java.awt.TextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import logic.Controller;
import logic.entities.Course;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.awt.Font;

@SuppressWarnings("serial")
public class Front extends JFrame {

    private JPanel contentPane;
    Controller control = new Controller();
    private JTextField textField_dni;
    private JTextField textField_nombre;
    private JTextField textField_apellido;
    private JTextField _textField_fechaNac;
    private JTextField textField_especialidad;

    public static void ErrorMessage(String tituloPane, String errorMsg) {
	   // ===================================================================
	   JOptionPane alerta = new JOptionPane(errorMsg);
	   alerta.setMessageType(JOptionPane.ERROR_MESSAGE);
	   // por defecto tiene un solo boton y toma el idioma del sistema.
	   JDialog dialogo = alerta.createDialog(tituloPane);
	   dialogo.setVisible(true);
	   dialogo.setAlwaysOnTop(true);
	   // ===================================================================
    }

    public static void SuccessMessage(String tituloPane, String errorMsg) {
	   // ===================================================================
	   JOptionPane alerta = new JOptionPane(errorMsg);
	   alerta.setMessageType(JOptionPane.CLOSED_OPTION);
	   // por defecto tiene un solo boton y toma el idioma del sistema.
	   JDialog dialogo = alerta.createDialog(tituloPane);
	   dialogo.setVisible(true);
	   dialogo.setAlwaysOnTop(true);
	   // ===================================================================
    }

    /**
     * Create the frame.
     */
    public Front() {
    	setForeground(Color.WHITE);
	   setResizable(false);
	   setTitle("Course Loader");
	   setBackground(Color.DARK_GRAY);
	   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   setBounds(100, 100, 899, 460);
	   contentPane = new JPanel();
	   contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	   contentPane.setLayout(new BorderLayout(0, 0));
	   setContentPane(contentPane);

	   JPanel panel = new JPanel();
	   panel.setBackground(Color.DARK_GRAY);
	   contentPane.add(panel, BorderLayout.CENTER);
	   panel.setLayout(null);

	   JPanel panel_1 = new JPanel();
	   panel_1.setBackground(Color.DARK_GRAY);
	   panel_1.setBounds(435, 7, 434, 393);
	   panel.add(panel_1);
	   panel_1.setLayout(null);

	   TextField Campo_nombreCurso = new TextField();
	   Campo_nombreCurso.setBounds(237, 61, 127, 19);
	   panel_1.add(Campo_nombreCurso);

	   TextField Campo_horasCurso = new TextField();
	   Campo_horasCurso.setBounds(237, 86, 127, 19);
	   panel_1.add(Campo_horasCurso);

	   JCheckBox Campo_certifCurso = new JCheckBox("");
	   Campo_certifCurso.setBounds(296, 111, 21, 23);
	   panel_1.add(Campo_certifCurso);

	   JLabel lblCertific = new JLabel("Con Certificado:");
	   lblCertific.setBounds(117, 111, 133, 23);
	   panel_1.add(lblCertific);
	   lblCertific.setForeground(Color.WHITE);

	   JLabel lblCargarCurso = new JLabel("Cargar Curso");
	   lblCargarCurso.setFont(new Font("Dialog", Font.BOLD, 16));
	   lblCargarCurso.setBounds(190, 0, 127, 25);
	   panel_1.add(lblCargarCurso);
	   lblCargarCurso.setForeground(Color.WHITE);

	   JLabel lblIdCurso = new JLabel("ID Curso Autoincremental");
	   lblIdCurso.setBounds(158, 36, 186, 15);
	   panel_1.add(lblIdCurso);
	   lblIdCurso.setForeground(Color.WHITE);

	   JLabel lblNombreCurso = new JLabel("Nombre Curso:");
	   lblNombreCurso.setBounds(117, 61, 105, 19);
	   panel_1.add(lblNombreCurso);
	   lblNombreCurso.setForeground(Color.WHITE);

	   JLabel lblHorasCurso = new JLabel("Horas Curso:");
	   lblHorasCurso.setBounds(127, 86, 93, 23);
	   panel_1.add(lblHorasCurso);
	   lblHorasCurso.setForeground(Color.WHITE);

	   JButton btnAgregar = new JButton("Cargar Curso");
	   btnAgregar.setBounds(237, 146, 127, 25);
	   panel_1.add(btnAgregar);
	   
	   JScrollPane scrollPane_1 = new JScrollPane();
	   scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	   scrollPane_1.setBounds(12, 228, 410, 101);
	   panel_1.add(scrollPane_1);

	   JTextArea textArea_ShowCourses = new JTextArea();
	   scrollPane_1.setViewportView(textArea_ShowCourses);

	   JComboBox<Course> comboBox_curso = new JComboBox<Course>();
	   comboBox_curso.setMaximumRowCount(10);
	   comboBox_curso.setBounds(135, 159, 114, 24);

	   JButton btnShowCourses = new JButton("Ver Cursos");
	   btnShowCourses.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent arg0) {
			 textArea_ShowCourses.setText(control.PrintCourses());
		  }
	   });
	   btnShowCourses.setBounds(165, 341, 117, 25);
	   panel_1.add(btnShowCourses);

	   btnAgregar.addActionListener(new ActionListener() {

		  public void actionPerformed(ActionEvent arg0) {
			 if (Campo_nombreCurso.getText().equals("") || Campo_horasCurso.getText().equals("")) {
				ErrorMessage("Error", "Hay al menos un campo vacio.");
			 } else {
				Controller.addCourseLL(Campo_horasCurso.getText(), Campo_nombreCurso.getText(), Campo_certifCurso.isSelected());
				SuccessMessage("Exito!", "Curso cargado con exito!");
				Iterator<Course> combo = Controller.getAllCourses().iterator();
				comboBox_curso.removeAllItems();
	    			while (combo.hasNext()) {
	    			    comboBox_curso.addItem(combo.next());
	    			}
			 }
		  }
	   });

	   JPanel panel_2 = new JPanel();
	   //panel_2.setBorder (new TitledBorder (new EtchedBorder(), "Display Area"));
	   panel_2.setBackground(Color.DARK_GRAY);
	   panel_2.setBounds(12, 7, 408, 398);
	   panel.add(panel_2);
	   panel_2.setLayout(null);

	   panel_2.add(comboBox_curso);

	   JLabel lblDni = new JLabel("DNI:");
	   lblDni.setForeground(Color.WHITE);
	   lblDni.setBounds(81, 36, 29, 15);
	   panel_2.add(lblDni);

	   JLabel lblCargarProfesor = new JLabel("Cargar Profesor");
	   lblCargarProfesor.setFont(new Font("Dialog", Font.BOLD, 16));
	   lblCargarProfesor.setBounds(110, 0, 152, 31);
	   lblCargarProfesor.setForeground(Color.WHITE);
	   panel_2.add(lblCargarProfesor);

	   JLabel lblNombre = new JLabel("Nombre:");
	   lblNombre.setForeground(Color.WHITE);
	   lblNombre.setBounds(53, 59, 70, 15);
	   panel_2.add(lblNombre);

	   JLabel lblApellido = new JLabel("Apellido:");
	   lblApellido.setForeground(Color.WHITE);
	   lblApellido.setBounds(53, 86, 70, 15);
	   panel_2.add(lblApellido);

	   JLabel lblFechaNac = new JLabel("Fecha Nac:");
	   lblFechaNac.setForeground(Color.WHITE);
	   lblFechaNac.setBounds(41, 113, 82, 15);
	   panel_2.add(lblFechaNac);

	   JLabel lblEspecialidad = new JLabel("Especialidad: ");
	   lblEspecialidad.setForeground(Color.WHITE);
	   lblEspecialidad.setBounds(25, 140, 98, 15);
	   panel_2.add(lblEspecialidad);

	   JLabel lblCurso = new JLabel("Curso:");
	   lblCurso.setForeground(Color.WHITE);
	   lblCurso.setBounds(70, 164, 53, 15);
	   panel_2.add(lblCurso);

	   textField_dni = new JTextField();
	   textField_dni.setBounds(135, 34, 114, 19);
	   panel_2.add(textField_dni);
	   textField_dni.setColumns(10);

	   textField_nombre = new JTextField();
	   textField_nombre.setBounds(135, 57, 114, 19);
	   panel_2.add(textField_nombre);
	   textField_nombre.setColumns(10);

	   textField_apellido = new JTextField();
	   textField_apellido.setText("");
	   textField_apellido.setBounds(135, 84, 114, 19);
	   panel_2.add(textField_apellido);
	   textField_apellido.setColumns(10);

	   _textField_fechaNac = new JTextField();
	   _textField_fechaNac.setText("");
	   _textField_fechaNac.setBounds(135, 111, 114, 19);
	   panel_2.add(_textField_fechaNac);
	   _textField_fechaNac.setColumns(10);

	   textField_especialidad = new JTextField();
	   textField_especialidad.setText("");
	   textField_especialidad.setBounds(135, 138, 114, 19);
	   panel_2.add(textField_especialidad);
	   textField_especialidad.setColumns(10);
	   
	   JScrollPane scrollPane = new JScrollPane();
	   scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	   scrollPane.setBounds(12, 229, 384, 98);
	   panel_2.add(scrollPane);

	   JTextArea textArea_verProfes = new JTextArea(5, 58);
	   scrollPane.setViewportView(textArea_verProfes);
	   textArea_verProfes.setEditable ( false );

	   JButton btnCargarProfe = new JButton("Cargar Profe");
	   btnCargarProfe.addActionListener(new ActionListener() {

		  public void actionPerformed(ActionEvent arg0) {
			 if (textField_dni.getText().equals("") || textField_nombre.getText().equals("") || textField_apellido.getText().equals("")
				    || textField_especialidad.getText().equals("") || _textField_fechaNac.getText().equals("")) {
				ErrorMessage("Error", "Hay al menos un campo sin completar!.");
			 } else {

				if (Controller.addProfessorLL(textField_dni.getText(), textField_nombre.getText(), textField_apellido.getText(), _textField_fechaNac.getText(),
					   textField_especialidad.getText(), comboBox_curso.getSelectedIndex())) {
				    SuccessMessage("Exito", "Profesor agregado con exito!");
				} else {
				    ErrorMessage("Error de carga", "Algo fallo al cargar el profesor.");
				}
			 }
		  }
	   });

	   btnCargarProfe.setBounds(119, 192, 130, 25);
	   panel_2.add(btnCargarProfe);

	   JButton btnVerProfes = new JButton("Ver Profes");
	   btnVerProfes.addActionListener(new ActionListener() {

		  public void actionPerformed(ActionEvent arg0) {
			 textArea_verProfes.setText(control.PrintProfessors());
		  }
	   });

	   btnVerProfes.setBounds(132, 339, 117, 25);
	   panel_2.add(btnVerProfes);
    }
}
