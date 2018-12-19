package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import laboratorinis2.Kursas;
import laboratorinis2.Uzduotis;

import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IkeltiSprendimai extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private Uzduotis uzduotis;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			IkeltiSprendimai dialog = new IkeltiSprendimai();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public IkeltiSprendimai(Uzduotis uzduotis) {
		this.uzduotis = uzduotis;
		setModal(true);
		setTitle("\u012Ekelti sprendimai");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 183);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		Object[] columns = {"Studentas","Įkėlimo data", "Įvertinimas"};
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		table.setModel(model);
		scrollPane.setViewportView(table);

	
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Vertinti");
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
	
	public void Isjungti() {
		this.dispose();
	}
}
