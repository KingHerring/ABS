package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import laboratorinis2.AktyvumoBaluSistema;
import laboratorinis2.Kursas;
import laboratorinis2.Studentas;
import laboratorinis2.Uzduotis;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.ListSelectionModel;

public class StudentasMain extends JFrame {

	private JPanel contentPane;
	private AktyvumoBaluSistema abs;
	private Studentas studentas;
	private JTextField textField;
	private Kursas kursas;
	private JList<Kursas> list;
	private JList<Uzduotis> list_1;


	/**
	 * Create the frame.
	 */
	public StudentasMain(AktyvumoBaluSistema abs, Studentas studentas) {
		setResizable(false);
		
		this.abs = abs;
		this.studentas = studentas;
		
		setTitle("Aktyvumo bal\u0173 sistema");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 263);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Atsijungti");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Atsijungti();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton.setBounds(357, 0, 89, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField.setEditable(false);
		textField.setBounds(0, 1, 357, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField.setText("Vartotojas: " + studentas.toString() + "[" + studentas.getGrupe() +"]");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 46, 167, 152);
		contentPane.add(scrollPane);
		
		list = new JList<Kursas>();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if(list.getSelectedIndex()>-1) {
					kursas = list.getModel().getElementAt(list.getSelectedIndex());
				}
				else { 
					kursas = null;
				}
				UpdateUzduotysList(list_1);
			}
		});
		scrollPane.setViewportView(list);
		
		UpdateKursaiList(list);
		
		JLabel lblKursai = new JLabel("Kursai:");
		lblKursai.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblKursai.setBounds(10, 32, 46, 14);
		contentPane.add(lblKursai);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(207, 46, 217, 152);
		contentPane.add(scrollPane_1);
		
		list_1 = new JList();
		list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(list_1);
		
		JLabel lblNewLabel = new JLabel("Kurso u\u017Eduotys:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(207, 32, 103, 14);
		contentPane.add(lblNewLabel);
		
		JButton button = new JButton("Per\u017Ei\u016Br\u0117ti");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PerziuretiUzduoti(list_1.getSelectedValue());
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 11));
		button.setBounds(207, 200, 217, 23);
		contentPane.add(button);
	}
	
	private void Atsijungti() {
		LogIn li = new LogIn();
		li.setVisible(true);
		this.dispose();
	}
	
	
	private void UpdateKursaiList(JList<Kursas> list){
		DefaultListModel<Kursas> model = new DefaultListModel<>();
		for(Kursas k: studentas.getGrupe().getKursai()) {
			model.addElement(k);
		}
		list.setModel(model);
		
	}
	
	private void UpdateUzduotysList(JList<Uzduotis> list) {
		DefaultListModel<Uzduotis> model = new DefaultListModel<>();
		if(kursas!=null) {
			for(Uzduotis u: kursas.getUzduotys()) {
				model.addElement(u);
			}		
		}	
		list.setModel(model);
	}
	
	private void PerziuretiUzduoti(Uzduotis uzduotis) {
		if(uzduotis != null) {
		UzduotisInfo ui = new UzduotisInfo(uzduotis);
		ui.setVisible(true);
		}
		
	}
}
