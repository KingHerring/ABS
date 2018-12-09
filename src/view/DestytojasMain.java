package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import laboratorinis2.AktyvumoBaluSistema;
import laboratorinis2.Destytojas;
import laboratorinis2.Grupe;
import laboratorinis2.Kursas;
import laboratorinis2.Uzduotis;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.SystemColor;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class DestytojasMain extends JFrame {

	private JPanel contentPane;
	private AktyvumoBaluSistema abs;
	private Destytojas destytojas;
	private JTextField txt1;
	private Kursas kursas;


	/**
	 * Create the frame.
	 */
	public DestytojasMain(AktyvumoBaluSistema abs, Destytojas destytojas) {
		setTitle("Aktyvumo bal\u0173 sistema");
		
		this.abs = abs;
		this.destytojas = destytojas;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txt1 = new JTextField();
		txt1.setEditable(false);
		txt1.setBackground(SystemColor.menu);
		txt1.setBounds(0, 0, 587, 24);
		contentPane.add(txt1);
		txt1.setColumns(10);
		
		txt1.setText("Vartotojas: " + destytojas);
		
		JButton btn1 = new JButton("Atsijungti");
		btn1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Atsijungti();
				
			}
		});
		btn1.setBounds(584, -1, 90, 25);
		contentPane.add(btn1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 60, 230, 200);
		contentPane.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(260, 60, 90, 200);
		contentPane.add(scrollPane_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(375, 60, 250, 200);
		contentPane.add(scrollPane_2);
		
		JList<Uzduotis> list_2 = new JList<Uzduotis>();
		scrollPane_2.setViewportView(list_2);
		
		JList<Grupe> list_1 = new JList<Grupe>();
		list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(list_1);
		
		
		JList<Kursas> list = new JList<Kursas>();
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
			
				if(list.getSelectedIndex()>-1) {
					kursas = list.getModel().getElementAt(list.getSelectedIndex());
				}
				else { 
					kursas = null;
				}
				UpdateGrupesList(list_1);
				UpdateUzduotysList(list_2);
			}
		});
		scrollPane.setViewportView(list);
		list.setValueIsAdjusting(true);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		UpdateKursaiList(list);
		
		
		
		JLabel lblManoKursai = new JLabel("Mano kursai");
		lblManoKursai.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblManoKursai.setBounds(10, 35, 75, 14);
		contentPane.add(lblManoKursai);
		
		JLabel lblNewLabel = new JLabel("Kurso grup\u0117s");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(260, 35, 90, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnGrAdd = new JButton("Prid\u0117ti");
		btnGrAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PridetiGrupe(list_1);
				
			}
		});
		btnGrAdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnGrAdd.setBounds(260, 270, 90, 25);
		contentPane.add(btnGrAdd);
		
		JButton btnGrRmv = new JButton("\u0160alinti");
		btnGrRmv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PasalintiGrupe(list_1, list_1.getSelectedIndex());
			}
		});
		btnGrRmv.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnGrRmv.setBounds(260, 305, 90, 25);
		contentPane.add(btnGrRmv);
		
		JButton buttonKrAdd = new JButton("Pridėti");
		buttonKrAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PridetiKursa(list);
			}
		});
		buttonKrAdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buttonKrAdd.setBounds(10, 270, 90, 25);
		contentPane.add(buttonKrAdd);
		
		JButton buttonKrRmv = new JButton("Šalinti");
		buttonKrRmv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PasalintiKursa(list);
			}
		});
		buttonKrRmv.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buttonKrRmv.setBounds(10, 305, 90, 25);
		contentPane.add(buttonKrRmv);
		
		
		JLabel lblKursoUduotys = new JLabel("Kurso užduotys");
		lblKursoUduotys.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKursoUduotys.setBounds(375, 36, 99, 14);
		contentPane.add(lblKursoUduotys);
		
		JButton button = new JButton("Pridėti");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PridetiUzduoti(list_2);
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button.setBounds(375, 270, 90, 25);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Šalinti");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PasalintiUzduoti(list_2, list_2.getSelectedIndex());
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_1.setBounds(375, 307, 90, 25);
		contentPane.add(button_1);
		
		JButton btnRedaguoti = new JButton("Peržiūrėti");
		btnRedaguoti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PerziuretiUzduoti(list_2.getSelectedValue());
			}
		});
		btnRedaguoti.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRedaguoti.setBounds(536, 270, 90, 25);
		contentPane.add(btnRedaguoti);
		
	}
	
	private void Atsijungti() {
		LogIn li = new LogIn();
		li.setVisible(true);
		this.dispose();
	}
	
	private void UpdateKursaiList(JList<Kursas> list){
		
		try {
			this.destytojas = abs.GautiDestytojaPagalID(this.destytojas.getKodas());
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		DefaultListModel<Kursas> model = new DefaultListModel<>();
		for(Kursas k: destytojas.getKursai()) {
			model.addElement(k);
		}
		list.setModel(model);
		
	}
	
	private void UpdateGrupesList(JList<Grupe> list) {
		DefaultListModel<Grupe> model = new DefaultListModel<>();
		if(kursas!=null) {
			for(Grupe g: kursas.getGrupes()) {
				model.addElement(g);
			}	
		}
		list.setModel(model);
	}
	
	private void UpdateUzduotysList(JList<Uzduotis> list) {
		DefaultListModel<Uzduotis> model = new DefaultListModel<>();
		if(kursas!=null) {
			//System.out.println(kursas);
			for(Uzduotis u: kursas.getUzduotys()) {
				model.addElement(u);
			}		
		}	
		list.setModel(model);
	}
	
	private void PasalintiGrupe(JList<Grupe> list, int grupesIndex) {
		Grupe g;
		try {
		g = list.getModel().getElementAt(grupesIndex);
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, "Nepasirinkote grupės", "Klaida", JOptionPane.ERROR_MESSAGE);
			return;
		}

		kursas.getGrupes().remove(g);
		abs.AtnaujintiKursa(kursas);
		//g.getKursai().remove(kursas);
		UpdateGrupesList(list);
		
	}
	
	private void PasalintiUzduoti(JList<Uzduotis> list, int uzduotiesIndex) {
		Uzduotis u;
		try {
			u = list.getModel().getElementAt(uzduotiesIndex);
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Nepasirinkote užduoties", "Klaida", JOptionPane.ERROR_MESSAGE);
			return;
		}
		kursas.getUzduotys().remove(u);
		abs.PasalintiUzduoti(u);
		abs.AtnaujintiKursa(kursas);
		UpdateUzduotysList(list);
	}
	
	
	public void PasalintiKursa(JList<Kursas> list) {
		abs.PasalintiKursa(kursas);
		//destytojas.getKursai().remove(kursas);
		UpdateKursaiList(list);

	}
	
	private void PridetiGrupe(JList<Grupe> list) {
		if(kursas != null) {
			GrupiuPridejimas gp = new GrupiuPridejimas(abs, kursas);
			gp.setVisible(true);
			//Collections.sort((List<T>) kursas.getGrupes());
			UpdateGrupesList(list);
		}
		else { 
			JOptionPane.showMessageDialog(null, "Nepasirinkote kurso", "Klaida", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void PridetiKursa(JList<Kursas> list) {
		KursoPridejimas kp = new KursoPridejimas(abs, destytojas);
		kp.setVisible(true);
		UpdateKursaiList(list);
	}
	
	private void PridetiUzduoti(JList<Uzduotis> list) {
		if(kursas != null) {
			UzduotiesPridejimas up = new UzduotiesPridejimas(abs, kursas);
			up.setVisible(true);
			UpdateUzduotysList(list);
		}
		else { 
			JOptionPane.showMessageDialog(null, "Nepasirinkote kurso", "Klaida", JOptionPane.ERROR_MESSAGE);
		}		
	}
	
	private void PerziuretiUzduoti(Uzduotis uzduotis) {
		if(uzduotis != null) {
		UzduotisInfo ui = new UzduotisInfo(uzduotis);
		ui.setVisible(true);
		}
		
	}
}
