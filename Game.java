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
	public boolean[] dirty = new boolean[9];
	
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
			boolean current = XorO[i];
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
					int winner = endGame();

					if(winner != -1){ //there is a winner or its a tie
					
						if(winner == 0){

							if(current == true){}
								map.setTitle("X is the Winner! Closing in 5");
								Thread.sleep(5000);
							}else{
								map.setTitle("O is the Winner! Closing in 5");
								Thread.sleep(5000);

							}
						}else if(winner == 1){

						}else if(winner == 2){

						}else if(winner == 3){

						}else if(winner == 4){

						}
							
					
					}
					
				}
			});
		}


		map.setLayout(new GridLayout(3,3));
		for(int i = 0 ; i < 9 ; i++){

			map.add(buttons[i]);
			dirty[i] = false; //full check for array
		}
		

		map.setVisible(true);
		
		
	}
	
	public void checkGame(int num , boolean val){

		XorO[num] = val;
		dirty[num] = true;
		


	}	

	public int endGame(){ // which way did they win

		for(int i = 0 ; i < 9 ; i+=3){ //horizontal check

			if(XorO[i] == XorO[i+1])
				if(XorO[i+1] == XorO[i+2])
					return 0;								
		}

		for(int i = 0 ; i < 3 ; i++){ //vertical check

			if(XorO[i] == XorO[i+3])
				if(XorO[i+3] == XorO[i+6])
					return 1;								
		}

			if(XorO[0] == XorO[4])
				if(XorO[4] == XorO[8]) //CrossCheckLeftToRight
					return 2;	

		
			if(XorO[2] == XorO[4])
				if(XorO[4] == XorO[6]) //CrossCheckRightToLeft
					return 3;	

			if(isFull())
				return 4;
			return -1; //no winner yet
	}

	boolean isFull(){

		for(int i = 0 ; i < 9 ; i++)
			if(dirty[i] == false)
				return false;
		return true;
	}

	public static void main(String[] args) {
		
		Game newGame = new Game();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}