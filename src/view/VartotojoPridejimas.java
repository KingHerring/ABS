package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javafx.scene.control.ComboBox;
import laboratorinis2.AktyvumoBaluSistema;
import laboratorinis2.Grupe;
import laboratorinis2.Studentas;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Font;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VartotojoPridejimas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JComboBox<String> comboBox;
	private JComboBox<String> comboBox_1;
	private AktyvumoBaluSistema abs;

	/**
	 * Create the dialog.
	 */
	public VartotojoPridejimas(AktyvumoBaluSistema abs) {
		
		this.abs = abs;
		
		setTitle("Vartotojo prid\u0117jimas");
		setBounds(100, 100, 357, 155);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblVardas = new JLabel("Vardas:");
			lblVardas.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblVardas.setBounds(10, 11, 46, 14);
			contentPanel.add(lblVardas);
		}
		{
			JLabel lblPavard = new JLabel("Pavard\u0117:");
			lblPavard.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblPavard.setBounds(10, 36, 46, 14);
			contentPanel.add(lblPavard);
		}
		{
			JLabel lblVartotojoTipas = new JLabel("Vartotojo tipas:");
			lblVartotojoTipas.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblVartotojoTipas.setBounds(10, 61, 75, 14);
			contentPanel.add(lblVartotojoTipas);
		}
		
		comboBox = new JComboBox<String>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PatikrintiTipa();
			}
		});
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 11));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"D\u0117stytojas", "Studentas"}));
		comboBox.setBounds(95, 58, 95, 20);
		contentPanel.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Grup\u0117:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(212, 61, 46, 14);
		contentPanel.add(lblNewLabel);
		
		comboBox_1 = new JComboBox<String>();
		comboBox_1.setEnabled(false);
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		comboBox_1.setModel(new DefaultComboBoxModel<String>(gautiGrupes()));
		comboBox_1.setBounds(256, 58, 75, 20);
		contentPanel.add(comboBox_1);
		
		textField = new JTextField();
		textField.setBounds(95, 8, 236, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(95, 33, 236, 20);
		contentPanel.add(textField_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						PridetiVartotoja();
					}
				});
				okButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Isjungti();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	private String[] gautiGrupes() {
		
		String[] grupes = new String[abs.getGrupes().size()];
		int i=0;
		for(Grupe g: abs.getGrupes()) {
			grupes[i]=g.getKodas();
			i++;
		}
		
		return grupes;
	}
	
	private void PatikrintiTipa() {
		if(comboBox.getModel().getSelectedItem() != null) {
			if(comboBox.getModel().getSelectedItem().equals("Dėstytojas")) comboBox_1.setEnabled(false);
			else if(comboBox.getModel().getSelectedItem().equals("Studentas")) comboBox_1.setEnabled(true);
		}
	}
	
	private void PridetiVartotoja() {
		if(comboBox.getModel().getSelectedItem().equals("Studentas")) {
			PridetiStudenta();
		}
		else if(comboBox.getModel().getSelectedItem().equals("Dėstytojas")) {
			PridetiDestytoja();
		}

		this.dispose();
	}
	
	
	private void PridetiStudenta(){
		try {
		String vardas = textField.getText();
		String pavarde = textField_1.getText();
		Studentas naujasStudentas = new Studentas(vardas, pavarde);
		
		String grupesKodas = comboBox_1.getModel().getSelectedItem().toString();	
		Grupe g = abs.GautiGrupePagalID(grupesKodas);
		naujasStudentas.setGrupe(g);	
		
		abs.PridetiStudenta(naujasStudentas);
		
		JOptionPane.showMessageDialog(null, "Studentas [" + naujasStudentas.getVardas()+ " " + naujasStudentas.getPavarde() + "] pridėtas į " + g, "Pridėtas vartotojas", JOptionPane.INFORMATION_MESSAGE);
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Nepavyko prideti studento", "Klaida", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void PridetiDestytoja() {
		String vardas = textField.getText();
		String pavarde = textField_1.getText();
		abs.PridetiDestytoja(vardas, pavarde);
		JOptionPane.showMessageDialog(null, "Destytojas [" + vardas + " " + pavarde + "] pridėtas" , "Pridėtas vartotojas", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void Isjungti() {
		this.dispose();
	}
}
