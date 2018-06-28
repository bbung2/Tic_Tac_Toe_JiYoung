package git.Tic_Tac_Toe_JiYoung.bbung2.com.github;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Tic_Tac_Toe extends JPanel implements ActionListener {
	private JPanel panel;
	private JTextField txt;
	JButton[][] buttons = new JButton[3][3];
	private char turn = 'X';
	
	public Tic_Tac_Toe() {
		txt = new JTextField(20);
		add(txt, BorderLayout.NORTH);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 3));
		add(panel, BorderLayout.CENTER);
		Font f = new Font("Dialog", Font.ROMAN_BASELINE, 50);
		
		//버튼을 격자모양으로 배치한다.
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				buttons[i][j] = new JButton(" ");
				buttons[i][j].setBackground(Color.WHITE);
				buttons[i][j].setFont(f);
				buttons[i][j].addActionListener(this);
				buttons[i][j].setPreferredSize(new Dimension(100, 100));
				panel.add(buttons[i][j]);
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (e.getSource() == buttons[i][j] && buttons[i][j].getText().equals(" ") == true) { //텍스트가 ""인 버튼이 클릭되면 보드에 표시한다.
					if (turn == 'X') {
						buttons[i][j].setText("X");
						buttons[i][j].setForeground(Color.RED);
						turn = 'O';
						if (checkWin("X", i, j))
							txt.setText("X 승리!");
						else if (isDraw())
							txt.setText("비겼습니다.");
					} else {
						buttons[i][j].setText("O");
						buttons[i][j].setForeground(Color.BLUE);
						turn = 'X';
						if (checkWin("O", i, j))
							txt.setText("O 승리!");
						else if (isDraw())
							txt.setText("비겼습니다.");
					}
				}
			}
		}
	}
	
	//비겼는지 검사한다.
	public boolean isDraw() {
		for (int row = 0; row < 3; ++row) {
			for (int col = 0; col < 3; ++col) {
				if (buttons[row][col].getText().equals(" ")) {
					return false;
				}
			}
		}
		return true;
	}
	
	//이겼는지 검사한다.
	public boolean checkWin(String mark, int r, int c) {
		return (buttons[r][0].getText().equals(mark)
				&& buttons[r][1].getText().equals(mark)
				&& buttons[r][2].getText().equals(mark)
				|| buttons[0][c].getText().equals(mark)
				&& buttons[1][c].getText().equals(mark)
				&& buttons[2][0].getText().equals(mark) ||
				buttons[0][0].getText().equals(mark)
				&& buttons[1][1].getText().equals(mark)
				&& buttons[2][2].getText().equals(mark) ||
				buttons[0][2].getText().equals(mark)
				&& buttons[1][1].getText().equals(mark)
				&& buttons[2][0].getText().equals(mark));
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image img = kit.getImage("Tic_Tac_Toe.png");
		f.setIconImage(img);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new Tic_Tac_Toe());
		f.setSize(300, 371);
		f.setTitle("Tic_Tac_Toe");
		f.setVisible(true);
	}
}