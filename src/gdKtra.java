import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class gdKtra extends JFrame {

	private JPanel contentPane;
	private JTextField txtmasp;
	private JTextField txttensp;
	private JTextField txtsl;
	private JTextField txtdg;
	JLabel lbltt = new JLabel("");
	JComboBox comboBox = new JComboBox();
	private JTable table;
	
	Vector Vtieude=new Vector();
	Vector Vndung=new Vector();
	Vector Vdong;
	float tt=0;
	
	DefaultTableModel dtm=new DefaultTableModel();
	
	void Tieude() {
		Vtieude.add("Mã sp");
		Vtieude.add("Tên sp");
		Vtieude.add("Loại sp");
		Vtieude.add("Số lượng");
		Vtieude.add("Khuyến mãi");
		Vtieude.add("Đơn giá");
		Vtieude.add("Thành tiền");
	}

	void Nhap(SANPHAM SP) {
		Vdong =new Vector();
		Vdong.add(SP.getMsp());
		Vdong.add(SP.getTensp());
		if(comboBox.getSelectedIndex()==0) {
			Vdong.add("Điện Thoại");
			Vdong.add("20%");
		}
		if(comboBox.getSelectedIndex()==1) {
			Vdong.add("Điện Máy");
			Vdong.add("10%");
		}
		Vdong.add(SP.getSoluong());
		Vdong.add(SP.getDongia());
		Vdong.add(SP.tinhtien());
		Vndung.add(Vdong);
		tt+=tt;
		}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gdKtra frame = new gdKtra();
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
	public gdKtra() {
		Tieude();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 609, 558);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel IbISnPhm = new JLabel("SẢN PHẨM");
		IbISnPhm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		IbISnPhm.setBounds(26, 11, 100, 42);
		contentPane.add(IbISnPhm);
		
		
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Điện thoại ", "Điện máy"}));
		comboBox.setBounds(26, 61, 100, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Mã sp");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(166, 58, 49, 29);
		contentPane.add(lblNewLabel);
		
		txtmasp = new JTextField();
		txtmasp.setBounds(235, 64, 96, 20);
		contentPane.add(txtmasp);
		txtmasp.setColumns(10);
		
		JLabel lblTnSp = new JLabel("Tên sp");
		lblTnSp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTnSp.setBounds(166, 98, 49, 29);
		contentPane.add(lblTnSp);
		
		txttensp = new JTextField();
		txttensp.setColumns(10);
		txttensp.setBounds(235, 104, 96, 20);
		contentPane.add(txttensp);
		
		txtsl = new JTextField();
		txtsl.setColumns(10);
		txtsl.setBounds(235, 144, 96, 20);
		contentPane.add(txtsl);
		
		txtdg = new JTextField();
		txtdg.setColumns(10);
		txtdg.setBounds(235, 181, 96, 20);
		contentPane.add(txtdg);
		
		JLabel lblNewLabel_1_1 = new JLabel("Số lượng");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(166, 138, 56, 29);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Đơn giá");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(166, 175, 49, 29);
		contentPane.add(lblNewLabel_1_2);
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SANPHAM s=null;
				String masp=txtmasp.getText();
				String tensp=txttensp.getText();
				float sl=Float.parseFloat(txtsl.getText());
				float dg=Float.parseFloat(txtdg.getText());
				if(comboBox.getSelectedIndex()==0) {
					s=new DIENTHOAI(masp,tensp,sl,dg);
				}
				if(comboBox.getSelectedIndex()==1) {
					s=new DIENMAY(masp,tensp,sl,dg);
				}
				lbltt.setText(""+tt);
				Nhap(s);
				dtm.setDataVector(Vndung, Vtieude);
				table.setModel(dtm);
			}
		});
		btnNewButton.setBounds(93, 235, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Xóa");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtdg.setText("");
				txtmasp.setText("");
				txtsl.setText("");
				txttensp.setText("");
				Vdong.clear();
				dtm.setDataVector(Vdong, Vtieude);
				table.setModel(dtm);
			}
		});
		btnNewButton_1.setBounds(254, 235, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Thoát");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_2.setBounds(436, 235, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 426, 524, -168);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 sp", "T\u00EAn sp", "Lo\u1EA1i sp", "S\u1ED1 l\u01B0\u1EE3ng", "Khuy\u1EBFn m\u00E3i", "\u0110\u01A1n gi\u00E1", "Th\u00E0nh ti\u1EC1n"
			}
		));
		table.getColumnModel().getColumn(6).setMinWidth(18);
		table.setBounds(50, 279, 524, 175);
		contentPane.add(table);
		
		JLabel lblTngThnhTin = new JLabel("Tổng thành tiền");
		lblTngThnhTin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTngThnhTin.setBounds(220, 481, 100, 29);
		contentPane.add(lblTngThnhTin);
		
		
		lbltt.setForeground(Color.RED);
		lbltt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbltt.setBounds(403, 481, 49, 29);
		contentPane.add(lbltt);
	}
}
