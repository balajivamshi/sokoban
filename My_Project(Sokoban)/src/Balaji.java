import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Balaji extends JFrame {

	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Balaji frame = new Balaji();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Balaji() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblWelcome = new JLabel("Welcome-to-Sokoban!!!");
		lblWelcome.setBackground(Color.CYAN);
		lblWelcome.setFont(new Font("Viner Hand ITC", Font.BOLD, 30));
		
		JLabel lblInstructions = new JLabel("Instructions :");
		lblInstructions.setFont(new Font("Tahoma", Font.PLAIN, 19));
		
		JButton btnStart = new JButton("Start");
		btnStart.setBackground(Color.GREEN);
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sokoban h = new Sokoban();
				h.setVisible(true);
				dispose();
			}
		});
		
		JButton btnCancle = new JButton("Cancel");
		btnCancle.setBackground(Color.RED);
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		
		JLabel lblPressstart = new JLabel("1. Press 'start' to play");
		
		JLabel lblPressr = new JLabel("2. Press 'R' to restart the game");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(78)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnStart)
									.addGap(93)
									.addComponent(btnCancle))
								.addComponent(lblInstructions)
								.addComponent(lblPressstart)
								.addComponent(lblPressr)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(20)
							.addComponent(lblWelcome)))
					.addContainerGap(132, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblWelcome)
					.addGap(13)
					.addComponent(lblInstructions)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblPressstart)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPressr)
					.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnStart)
						.addComponent(btnCancle))
					.addGap(50))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
