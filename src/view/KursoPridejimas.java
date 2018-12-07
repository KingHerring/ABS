package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import laboratorinis2.AktyvumoBaluSistema;
import laboratorinis2.Destytojas;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KursoPridejimas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private Destytojas destytojas;
	private AktyvumoBaluSistema abs;

	/**
	 * Create the dialog.
	 */
	public KursoPridejimas(AktyvumoBaluSistema abs, Destytojas destytojas) {
		
		this.abs = abs;
		this.destytojas = destytojas;
		
		setModal(true);
		setResizable(false);
		setTitle("Kurso prid\u0117jimas");
		setBounds(100, 100, 450, 128);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(117, 25, 280, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblPavadinimas = new JLabel("Pavadinimas:");
		lblPavadinimas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPavadinimas.setBounds(37, 28, 70, 14);
		contentPanel.add(lblPavadinimas);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Prid\u0117ti");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						PridetiKursa();
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
					public void actionPerformed(ActionEvent e) {
						Isjungti();
					}
				});
				cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	private void PridetiKursa() {
		abs.DestytojuiPridetiKursa(destytojas, textField.getText());
		//destytojas.PridetiKursa(textField.getText());
		this.dispose();
	}
	
	private void Isjungti() {
		this.dispose();
	}
}
