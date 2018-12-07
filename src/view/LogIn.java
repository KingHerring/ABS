package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import laboratorinis2.AktyvumoBaluSistema;
import laboratorinis2.Lab2;
import laboratorinis2.Studentas;
import laboratorinis2.Destytojas;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.sql.*
;public class LogIn extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JComboBox<String> comboBox;
	static private AktyvumoBaluSistema abs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		abs = new AktyvumoBaluSistema();
		Lab2.Init(abs);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn frame = new LogIn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LogIn() {
		
		
		setFont(new Font("Tahoma", Font.PLAIN, 12));
		setResizable(false);
		setTitle("Aktyvumo bal\u0173 sistema");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 359, 160);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnVartotojai = new JMenu("Vartotojai");
		mnVartotojai.setFont(new Font("Tahoma", Font.PLAIN, 12));
		menuBar.add(mnVartotojai);
		
		JMenuItem mntmSraas = new JMenuItem("Sąrašas");
		mntmSraas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//	abs.RodytiVisusDestytojus();
			//	abs.RodytiVisusStudentus();
				PerziuretiVartotojuInfo();
			}
		});
		mntmSraas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mnVartotojai.add(mntmSraas);
		
		JMenuItem mntmPridtiVartotoj = new JMenuItem("Pridėti vartotoją");
		mntmPridtiVartotoj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PridetiVartotoja();
			}
		});
		mntmPridtiVartotoj.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mnVartotojai.add(mntmPridtiVartotoj);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPrisijungti = new JButton("Prisijungti");
		btnPrisijungti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int kodas = Integer.parseInt(textField.getText());
					if(comboBox.getSelectedItem().equals("Dėstytojas")) {
						
						Destytojas destytojas = abs.GautiDestytojaPagalID(kodas);
						PrijungtiDestytoja(abs, destytojas);
					}
					else {	
						Studentas studentas = abs.GautiStudentaPagalID(kodas);
						PrijungtiStudenta(abs, studentas);
					}
				}catch(Exception e) {
					//JOptionPane.showMessageDialog(null, "Klaidingai įvestas kodas", "Klaida", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}
			}
		});
		btnPrisijungti.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPrisijungti.setBounds(210, 76, 118, 23);
		contentPane.add(btnPrisijungti);
		
		textField = new JTextField();
		textField.setBounds(186, 42, 142, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPrisijungimoKodas = new JLabel("Prisijungimo kodas:");
		lblPrisijungimoKodas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPrisijungimoKodas.setBounds(51, 45, 125, 14);
		contentPane.add(lblPrisijungimoKodas);
		
		JLabel lblNewLabel = new JLabel("Vartotojo tipas:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(51, 20, 105, 14);
		contentPane.add(lblNewLabel);
		
		comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Dėstytojas", "Studentas"}));
		comboBox.setBounds(186, 18, 142, 20);
		contentPane.add(comboBox);
	}
	
	public void PrijungtiDestytoja(AktyvumoBaluSistema abs, Destytojas destytojas) {
			DestytojasMain dm = new DestytojasMain(abs, destytojas);
			dm.setVisible(true);
			this.dispose();
	
	}
	
	public void PrijungtiStudenta(AktyvumoBaluSistema abs, Studentas studentas) {
		StudentasMain sm = new StudentasMain(abs, studentas);
		sm.setVisible(true);
		this.dispose();

	}
	
	private void PridetiVartotoja() {
		VartotojoPridejimas vp = new VartotojoPridejimas(abs);
		vp.setVisible(true);
	}
	
	private void PerziuretiVartotojuInfo() {
		VartotojuSarasas vs = new VartotojuSarasas(abs);
		vs.setVisible(true);
	}
}
