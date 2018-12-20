package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import laboratorinis2.AktyvumoBaluSistema;
import laboratorinis2.AtliktasDarbas;
import laboratorinis2.Uzduotis;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vertinimas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Uzduotis uzduotis;
	private AtliktasDarbas atliktasDarbas;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextArea textArea;
	private JTextArea textArea_1;
	private JTextArea textArea_2;
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			Vertinimas dialog = new Vertinimas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public Vertinimas(AtliktasDarbas atliktasDarbas, Uzduotis uzduotis) {
		setTitle("Vertinimas");
		setModal(true);
		this.atliktasDarbas = atliktasDarbas;
		this.uzduotis = uzduotis;
		System.out.println(uzduotis.getKodas());
		System.out.println(atliktasDarbas.getKodas());
		setBounds(100, 100, 450, 390);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("U\u017Eduotis:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 11, 64, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblAtliko = new JLabel("Atliko:");
		lblAtliko.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAtliko.setBounds(10, 36, 64, 14);
		contentPanel.add(lblAtliko);
		
		JLabel lblPateikimoData = new JLabel("Pateikimo data:");
		lblPateikimoData.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPateikimoData.setBounds(10, 61, 98, 14);
		contentPanel.add(lblPateikimoData);
		
		JLabel lblSlyga = new JLabel("U\u017Eduoties s\u0105lyga:");
		lblSlyga.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSlyga.setBounds(10, 96, 98, 14);
		contentPanel.add(lblSlyga);
		
		JLabel lblSprendimas = new JLabel("Sprendimas:");
		lblSprendimas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSprendimas.setBounds(10, 162, 117, 14);
		contentPanel.add(lblSprendimas);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(125, 9, 267, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(125, 34, 267, 20);
		contentPanel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(125, 59, 267, 20);
		contentPanel.add(textField_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(125, 92, 267, 53);
		contentPanel.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setBackground(SystemColor.menu);
		scrollPane.setViewportView(textArea);
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textArea.setEditable(false);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(125, 158, 267, 53);
		contentPanel.add(scrollPane_1);
		
		textArea_1 = new JTextArea();
		textArea_1.setWrapStyleWord(true);
		textArea_1.setLineWrap(true);
		textArea_1.setBackground(SystemColor.menu);
		scrollPane_1.setViewportView(textArea_1);
		textArea_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textArea_1.setEditable(false);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Vertinimas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 221, 385, 86);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Balai (max " + uzduotis.getMaxBalai() + " ):");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 22, 97, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblKomentaras = new JLabel("Komentaras:");
		lblKomentaras.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKomentaras.setBounds(10, 49, 86, 14);
		panel.add(lblKomentaras);
		
		textField_3 = new JTextField();
		textField_3.setBounds(120, 20, 86, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_2.setBounds(120, 45, 250, 30);
		panel.add(scrollPane_2);
		
		textArea_2 = new JTextArea();
		textArea_2.setWrapStyleWord(true);
		scrollPane_2.setViewportView(textArea_2);
		textArea_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textArea_2.setLineWrap(true);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Patvirtinti vertinim\u0105");
				okButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						RasytiVertinima();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Atgal");
				cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Isjungti();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		FillInfo();
	}
	
	public void FillInfo() {
		textField.setText(uzduotis.getPavadinimas());
		textField_1.setText(atliktasDarbas.getStudentas().getVardas() + " " + atliktasDarbas.getStudentas().getPavarde());
		textField_2.setText(atliktasDarbas.getPateikimoLaikas());
		textArea.setText(uzduotis.getSalyga());
		textArea_1.setText(atliktasDarbas.getSprendimas());
		if(atliktasDarbas.getIvertinimas()!=-1) textField_3.setText(Float.toString(atliktasDarbas.getIvertinimas()));
		if(atliktasDarbas.getKomentaras() != null) textArea_2.setText(atliktasDarbas.getKomentaras());
	}
	
	public void RasytiVertinima() {
		try {
			float balai = Float.parseFloat(textField_3.getText());
			if(balai >= 0 && balai <= uzduotis.getMaxBalai());{
				atliktasDarbas.setIvertinimas(balai);
				atliktasDarbas.setKomentaras(textArea_2.getText());
				AktyvumoBaluSistema abs = new AktyvumoBaluSistema();
				abs.AtnaujintiAtliktaDarba(atliktasDarbas);
				Isjungti();
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void Isjungti() {
		this.dispose();
	}
}
