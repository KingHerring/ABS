package view;

import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import laboratorinis2.AktyvumoBaluSistema;
import laboratorinis2.Grupe;
import laboratorinis2.Kursas;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;



public class GrupiuPridejimas extends JDialog {
	
	private AktyvumoBaluSistema abs;
	private Kursas kursas;
	private JList<Grupe> list;

	private final JPanel contentPanel = new JPanel();
	public GrupiuPridejimas(AktyvumoBaluSistema abs, Kursas kursas) {
		this.abs = abs;
		this.kursas = kursas;
		
		setModal(true);
		setResizable(false);
		setTitle("Grupi\u0173 prid\u0117jimas");
		setBounds(100, 100, 177, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 23, 151, 205);
			contentPanel.add(scrollPane);
			list = new JList<Grupe>();
			scrollPane.setViewportView(list);
		}
		{
			UpdateGrupesList();
		}
		{
			JLabel lblGrupiSraas = new JLabel("Neprid\u0117tos grup\u0117s:");
			lblGrupiSraas.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblGrupiSraas.setBounds(10, 8, 128, 15);
			contentPanel.add(lblGrupiSraas);
		}
			
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Prid\u0117ti");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						PridetiGrupes();
					}
				});
				okButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Atgal");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Isjungti();
					}
				});
				cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	private void UpdateGrupesList() {

		DefaultListModel<Grupe> model = new DefaultListModel<Grupe>();
		//ArrayList<Grupe> nepridetosGrupes = abs.getGrupes();
		List<Grupe> nepridetosGrupes = abs.getNeitrauktosGrupes(kursas);


		/*for(Grupe g: kursas.getGrupes()) {
			nepridetosGrupes.remove(g);
		}*/
		
		for(Grupe g: nepridetosGrupes) {
			model.addElement(g);
		}
		list.setModel(model);		
	}
	
	private void PridetiGrupes() {
		try {
			ArrayList<Grupe> pasirinktosGrupes = (ArrayList<Grupe>) list.getSelectedValuesList();
	
			for(Grupe g: pasirinktosGrupes) {
				kursas.getGrupes().add(g);
				//g.getKursai().add(kursas);
			}
			abs.AtnaujintiKursa(kursas);
			this.dispose();
		
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Nepasirinkote grupes", "Klaida", JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
	
	private void Isjungti() {
		this.dispose();
	}

}
