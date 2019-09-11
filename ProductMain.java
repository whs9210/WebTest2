package db연결연습;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProductMain {
	private static JTextField t1;
	private static JTextField t2;
	private static JTextField t3;
	private static JTextField t4;

	public static void main(String[] args) throws Exception {
		JFrame f = new JFrame();
		f.setSize(500, 500);
		f.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("ID : ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 25));
		lblNewLabel.setBounds(79, 67, 97, 21);
		f.getContentPane().add(lblNewLabel);

		t1 = new JTextField();
		t1.setHorizontalAlignment(SwingConstants.CENTER);
		t1.setFont(new Font("굴림", Font.PLAIN, 20));
		t1.setBounds(169, 66, 215, 30);
		f.getContentPane().add(t1);
		t1.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("NAME :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(58, 119, 97, 21);
		f.getContentPane().add(lblNewLabel_1);

		t2 = new JTextField();
		t2.setHorizontalAlignment(SwingConstants.CENTER);
		t2.setFont(new Font("굴림", Font.PLAIN, 20));
		t2.setBounds(169, 118, 215, 30);
		f.getContentPane().add(t2);
		t2.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("CONTENT : ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(12, 170, 145, 21);
		f.getContentPane().add(lblNewLabel_2);

		t3 = new JTextField();
		t3.setHorizontalAlignment(SwingConstants.CENTER);
		t3.setFont(new Font("굴림", Font.PLAIN, 20));
		t3.setBounds(169, 169, 215, 30);
		f.getContentPane().add(t3);
		t3.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("PRICE : ");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("굴림", Font.PLAIN, 25));
		lblNewLabel_3.setBounds(58, 219, 97, 21);
		f.getContentPane().add(lblNewLabel_3);

		t4 = new JTextField();
		t4.setHorizontalAlignment(SwingConstants.CENTER);
		t4.setFont(new Font("굴림", Font.PLAIN, 20));
		t4.setBounds(169, 218, 215, 30);
		f.getContentPane().add(t4);
		t4.setColumns(10);

		JButton btnNewButton = new JButton("정보입력");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductDTO dto = new ProductDTO();
				String id = t1.getText();
				String name = t2.getText();
				String content = t3.getText();
				String price = t4.getText();

				ProductDAO db = new ProductDAO();

				dto.setId(id);
				dto.setName(name);
				dto.setContent(content);
				dto.setPrice(price);

				try {
					db.insert(dto);
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 25));
		btnNewButton.setBounds(79, 325, 145, 36);
		f.getContentPane().add(btnNewButton);

		JButton button = new JButton("정보찾기");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String data = t1.getText();
				ProductDAO db = new ProductDAO();
				ProductDTO dto;
				try {
					dto = db.select(data);
					t1.setText(dto.getId());
					t2.setText(dto.getName());
					t3.setText(dto.getContent());
					t4.setText(dto.getPrice());
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		button.setFont(new Font("굴림", Font.BOLD, 25));
		button.setBounds(278, 325, 145, 36);
		f.getContentPane().add(button);
		f.setVisible(true);

	}
}
