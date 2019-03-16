import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Game{
	
	
	public JFrame map = null;
	public JButton[] buttons = new JButton[9];
	public boolean[] XorO = new boolean[9];
	public int counter = 0;
	
	Game() {
		
		int width = 300;
		int height = 300;
		map = new JFrame("TicTacToe Game");
		map.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		map.setSize(width,height);
		for(int i = 0 ; i < 9 ; i++){
			buttons[i] = new JButton();
			JButton thisbutton = buttons[i];
			buttons[i].setSize(10,10);
			buttons[i].addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					
					
					if(counter % 2 == 0){
						thisbutton.setText("X");
						checkGame(i,true);
					}else{
						thisbutton.setText("O");
						checkGame(i,false);
					}
					counter++;
				}
			});
		}

		map.setLayout(new GridLayout(3,3));
		for(int i = 0 ; i < 9 ; i++){

			map.add(buttons[i]);

		}
		

		map.setVisible(true);
		
		
	}
	
	public void CheckGame(int num , boolean val){

		XorO[num] = val;
		if(XorO[num] == XorO[num+1])
			if(XorO[num+1] == XorO[num+2])					

	}	
	public static void main(String[] args) {
		
		Game newGame = new Game();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}