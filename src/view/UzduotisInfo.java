package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import laboratorinis2.Kursas;
import laboratorinis2.Uzduotis;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class UzduotisInfo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private Uzduotis uzduotis;

	/**
	 * Create the dialog.
	 */
	public UzduotisInfo(Uzduotis uzduotis) {
		
		this.uzduotis = uzduotis;
		
		setModal(true);
		setTitle("U\u017Eduoties informacija");
		setBounds(100, 100, 450, 191);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblPavadinimas = new JLabel("Pavadinimas:");
		lblPavadinimas.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPavadinimas.setBounds(10, 11, 69, 14);
		contentPanel.add(lblPavadinimas);
		
		JLabel lblSlygas = new JLabel("S\u0105lyga:");
		lblSlygas.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSlygas.setBounds(10, 36, 46, 14);
		contentPanel.add(lblSlygas);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(89, 31, 300, 54);
		contentPanel.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setBackground(SystemColor.menu);
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textArea.setText(uzduotis.getSalyga());
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		JPanel panel = new JPanel();
		panel.setBorder(UIManager.getBorder("TextArea.border"));
		panel.setBounds(89, 8, 300, 20);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(0, 0, 300, 20);
		panel.add(textField);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField.setText(uzduotis.getPavadinimas());
		textField.setEditable(false);
		textField.setColumns(10);
		
		JLabel lblPabaigosLaikas = new JLabel("Pabaigos laikas:");
		lblPabaigosLaikas.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPabaigosLaikas.setBounds(10, 95, 85, 14);
		contentPanel.add(lblPabaigosLaikas);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField_1.setText(uzduotis.getPabaigosData());
		textField_1.setEditable(false);
		textField_1.setBounds(89, 92, 170, 20);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblBalai = new JLabel("Balai:");
		lblBalai.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblBalai.setBounds(269, 96, 46, 14);
		contentPanel.add(lblBalai);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField_2.setText(Float.toString(uzduotis.getMaxBalai()));
		textField_2.setEditable(false);
		textField_2.setBounds(303, 92, 86, 20);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Uzdaryti();
					}
				});
				cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	private void Uzdaryti() {
		this.dispose();
	}
}
