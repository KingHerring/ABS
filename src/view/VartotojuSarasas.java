package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import laboratorinis2.AktyvumoBaluSistema;
import laboratorinis2.Destytojas;
import laboratorinis2.Grupe;
import laboratorinis2.Studentas;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;

public class VartotojuSarasas extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private AktyvumoBaluSistema abs;
	private JTable table_1;

	/**
	 * Create the frame.
	 */
	public VartotojuSarasas(AktyvumoBaluSistema abs) {
		setTitle("Vartotojų sąrašas");
		
		this.abs = abs;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 677, 242);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 32, 264, 160);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
				GetDestytojaiDuom(),
			new String[] {
				"Kodas", "Vardas", "Pavarde"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(304, 32, 347, 160);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
				GetStudentaiDuom(),
				new String[] {
					"Kodas", "Vardas", "Pavarde", "Grupė"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
		
		JLabel lblDstytojai = new JLabel("Dėstytojai:");
		lblDstytojai.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDstytojai.setBounds(10, 7, 69, 14);
		contentPane.add(lblDstytojai);
		
		JLabel lblStudentai = new JLabel("Studentai:");
		lblStudentai.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblStudentai.setBounds(305, 11, 60, 14);
		contentPane.add(lblStudentai);
		table.getColumnModel().getColumn(1).setResizable(false);
	}
	
	private String[][] GetDestytojaiDuom(){
		String[][] destytojai = new String[abs.getDestytojai().size()][3]; // 3 stulpeliai
		
		int i = 0;
		for(Destytojas d: abs.getDestytojai()) {
			destytojai[i][0] = Integer.toString(d.getKodas());
			destytojai[i][1] = d.getVardas();
			destytojai[i][2] = d.getPavarde();
			i++;
		}
		
		return destytojai;
	}
	
	private String[][] GetStudentaiDuom(){
		
		String[][] studentai = new String[abs.getStudentai().size()][4];
		
		int i = 0;
		for(Studentas s: abs.getStudentai()) {
			studentai[i][0] = Integer.toString(s.getKodas());
			studentai[i][1] = s.getVardas();
			studentai[i][2] = s.getPavarde();
			studentai[i][3] = s.getGrupe().toString();
			i++;
		}
					
		return studentai;
	}
	
}
