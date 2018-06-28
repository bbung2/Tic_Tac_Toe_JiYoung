package git.Tic_Tac_Toe_JiYoung.bbung2.com.github;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tic_Tac_Toe extends JPanel implements ActionListener {
	double A, B, C;
	JButton[][] buttons = new JButton[3][3];
	char[][] board = new char[3][3];
	private char turn = 'X';
	
	public Tic_Tac_Toe() {
		setLayout(new GridLayout(3, 3, 5, 5));
		Font f = new Font("Dialog", Font.ROMAN_BASELINE, 50);
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				buttons[i][j] = new JButton(" ");
				buttons[i][j].setBackground(Color.WHITE);
				buttons[i][j].setFont(f);
				buttons[i][j].addActionListener(this);
				add(buttons[i][j]);
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (e.getSource() == buttons[i][j] && buttons[i][j].getText().equals(" ") == true) {
					if (turn == 'X') {
						buttons[i][j].setText("X");
						buttons[i][j].setForeground(Color.RED);
						turn = 'O';
					}
					else {
						buttons[i][j].setText("O");
						buttons[i][j].setForeground(Color.BLUE);
						turn = 'X';
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image img = kit.getImage("Tic_Tac_Toe.png");
		f.setIconImage(img);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new Tic_Tac_Toe());
		f.setSize(300, 300);
		f.setTitle("Tic_Tac_Toe");
		f.setVisible(true);
	}
}
