package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import laboratorinis2.Kursas;
import laboratorinis2.Uzduotis;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.time.Year;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class UzduotiesPridejimas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextArea textArea;
	private Kursas kursas;
	private JComboBox<String> metai;
	private JComboBox<String> menesis;
	private JComboBox<String> diena;
	private JComboBox<String> valanda;
	private JComboBox<String> minutes;


	/**
	 * Create the dialog.
	 */
	public UzduotiesPridejimas(Kursas kursas) {
		this.kursas = kursas;
		setModal(true);
		setTitle("Prid\u0117ti u\u017Eduot\u012F");
		setBounds(100, 100, 458, 346);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			textField = new JTextField();
			textField.setBounds(107, 30, 235, 20);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JLabel lblPavadinimas = new JLabel("Pavadinimas:");
			lblPavadinimas.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblPavadinimas.setBounds(10, 33, 87, 14);
			contentPanel.add(lblPavadinimas);
		}
		{
			JLabel lblSlyga = new JLabel("S\u0105lyga:");
			lblSlyga.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblSlyga.setBounds(10, 58, 87, 14);
			contentPanel.add(lblSlyga);
		}
		
		JLabel lblBalai = new JLabel("Balai:");
		lblBalai.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblBalai.setBounds(352, 33, 46, 14);
		contentPanel.add(lblBalai);
		
		textField_1 = new JTextField();
		textField_1.setBounds(387, 30, 33, 20);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel pane = new JPanel();
		pane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Pabaigos laikas:", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 11), new Color(0, 0, 0)));
		pane.setBounds(4, 161, 416, 102);
		contentPanel.add(pane);
		pane.setLayout(null);
		
		JLabel lblMetai = new JLabel("Metai:");
		lblMetai.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMetai.setBounds(10, 25, 46, 14);
		pane.add(lblMetai);
		
		metai = new JComboBox<String>();
		metai.setModel(new DefaultComboBoxModel<String>(getStringArray(Year.now().getValue(),Year.now().getValue()+1)));
		metai.setBounds(45, 23, 70, 20);
		pane.add(metai);
		
		JLabel lblMnuo = new JLabel("M\u0117nesis:");
		lblMnuo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMnuo.setBounds(125, 25, 46, 14);
		pane.add(lblMnuo);
		
		menesis = new JComboBox<String>();
		menesis.setModel(new DefaultComboBoxModel<String>(getStringArray(1,12)));
		menesis.setMaximumRowCount(12);
		menesis.setBounds(176, 23, 70, 20);
		pane.add(menesis);
		
		JLabel lblDiena = new JLabel("Diena:");
		lblDiena.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDiena.setBounds(10, 65, 46, 14);
		pane.add(lblDiena);
		
		JLabel lblNewLabel = new JLabel("Valanda:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(125, 65, 46, 14);
		pane.add(lblNewLabel);
		
		JLabel lblMinuts = new JLabel("Minut\u0117s:");
		lblMinuts.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMinuts.setBounds(256, 65, 46, 14);
		pane.add(lblMinuts);
		
		diena = new JComboBox<String>();
		diena.setModel(new DefaultComboBoxModel<String>(getStringArray(1,31)));
		diena.setBounds(45, 62, 70, 20);
		pane.add(diena);
		
		valanda = new JComboBox<String>();
		valanda.setModel(new DefaultComboBoxModel<String>(getStringArray(0,23)));
		valanda.setBounds(176, 62, 70, 20);
		pane.add(valanda);
		
		minutes = new JComboBox<String>();
		minutes.setModel(new DefaultComboBoxModel<String>(getStringArray(0,59)));
		minutes.setBounds(303, 62, 70, 20);
		pane.add(minutes);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(107, 61, 313, 95);
		contentPanel.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Prid\u0117ti");
				okButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						PridetiUzduoti();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Atgal");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Isjungti();
					}
				});
				cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	private String[] getStringArray(int start, int end){
		String[] intervalas = new String[end-start+1];
		for(int i=0; i<=end-start; i++) {
			intervalas[i] = (Integer.toString(i+start));
			if(intervalas[i].length()==1) {
				intervalas[i] = "0"+intervalas[i];
			}
		}
		return intervalas;
	}
	
	private void PridetiUzduoti() {
		
		try {
			Uzduotis u = new Uzduotis(textField.getText(), textArea.getText(), Float.parseFloat(textField_1.getText()), 
					metai.getModel().getSelectedItem().toString() + "-"
					+ menesis.getModel().getSelectedItem().toString() + "-"
					+ diena.getModel().getSelectedItem().toString() + " "
					+ valanda.getModel().getSelectedItem().toString() + ":"
					+ minutes.getModel().getSelectedItem().toString(), kursas);
			kursas.getUzduotys().add(u);
			this.dispose();
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Įvyko klaida. Patikrinkite įvestas reikšmes.", "Klaida", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void Isjungti() {
		this.dispose();
	}
}
