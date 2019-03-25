import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Game{
	
	static Game newGame = null;
	public JFrame map = null;
	public JButton[] buttons = new JButton[9];
	public int[] XorO = new int[9];
	public int counter = 0;
	public boolean[] dirty = new boolean[9];
	JOptionPane option = null;
	JOptionPane howTo = null;
	static boolean isFirstTime = true; //if not first time playing don't show startup popup
	Game() {
		
		int width = 300;
		int height = 300;
		map = new JFrame("TicTacToe Game");
		map.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		map.setLocationRelativeTo(null);

		map.setSize(width,height);
		map.setResizable(false);

		option = new JOptionPane();

		for(int i = 0 ; i < 9 ; i++){
			buttons[i] = new JButton();
			JButton thisbutton = buttons[i];
			buttons[i].setSize(10,10);
			int current = XorO[i];
			int number = i;
			buttons[i].addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					
					
					if(counter % 2 == 0){
						thisbutton.setText("X");
						checkGame(number,1);
						
					}else{
						thisbutton.setText("O");
						checkGame(number,2);
					}
					counter++;
					int winner = endGame();

					if(winner != -1){ //there is a winner or its a tie
					
						if(winner == 0){

							if(XorO[number] == 1){
								map.setTitle("X is the Winner!");
								optionPopUp("X is the Winner!");								
							}else{
								map.setTitle("O is the Winner!");
								optionPopUp("O is the Winner!");
							}
						
					}else if(winner == 1){


							if(XorO[number] == 1){
								map.setTitle("X is the Winner! ");
								optionPopUp("X is the Winner!");
								
							}else{
								map.setTitle("O is the Winner!");
								optionPopUp("O is the Winner!");

							}

						}else if(winner == 2){



							if(XorO[number] == 1){
								map.setTitle("X is the Winner!");
								optionPopUp("X is the Winner!");


							}else{
								map.setTitle("O is the Winner!");
								optionPopUp("O is the Winner!");



							}

						}else if(winner == 3){

							if(XorO[number] == 1){
								map.setTitle("X is the Winner! ");
								optionPopUp("X is the Winner!");
							}else{
								map.setTitle("O is the Winner!");
								optionPopUp("O is the Winner!");

							}

						}else if(winner == 4){


							if(XorO[number] == 1){
								map.setTitle("Its a TIE");
								optionPopUp("Its a TIE");
							}else{
								map.setTitle("Its a TIE");
								optionPopUp("Its a TIE");

							}
						}
					}
				}
			}); //end of action listener
		}

		map.setLayout(new GridLayout(3,3));
		for(int i = 0 ; i < 9 ; i++){

			map.add(buttons[i]);
			dirty[i] = false; //full check for array
		}
		

		map.setVisible(true);

		System.out.println(isFirstTime);
		
		if(isFirstTime){
			isFirstTime = false;
			howToPlayPopUp(); // Message box that tells about game
		}
		
		System.out.println(isFirstTime);
		
	}
	
	public void checkGame(int num , int val){

		XorO[num] = val;
		dirty[num] = true;
		


	}	

	boolean isDirty(int i){
		return dirty[i];
	}

	public int endGame(){ // which way did they win

		for(int i = 0 ; i < 9 ; i+=3){ //horizontal check

			if((XorO[i] == XorO[i+1]) && isDirty(i) && isDirty(i+1))
				if(XorO[i+1] == XorO[i+2] && isDirty(i+1) && isDirty(i+2))
					return 0;								
		}

		for(int i = 0 ; i < 3 ; i++){ //vertical check

			if(XorO[i] == XorO[i+3]&& isDirty(i) && isDirty(i+3))
				if(XorO[i+3] == XorO[i+6] && isDirty(i+3) && isDirty(i+6))
					return 1;								
		}

			if(XorO[0] == XorO[4]&& isDirty(0) && isDirty(4))
				if(XorO[4] == XorO[8] && isDirty(4) && isDirty(8)) //CrossCheckLeftToRight
					return 2;	

		
			if(XorO[2] == XorO[4] && isDirty(2) && isDirty(4))
				if(XorO[4] == XorO[6] && isDirty(4) && isDirty(6)) //CrossCheckRightToLeft
					return 3;	

			if(isFull()) //Its a tie
				return 4;
			return -1; //no winner yet
	}

	boolean isFull(){

		for(int i = 0 ; i < 9 ; i++)
			if(dirty[i] == false)
				return false;
		return true;
	}

	void optionPopUp(String title){
		int res = option.showConfirmDialog(null,"Do you want to play again?",title, JOptionPane.YES_NO_OPTION);
		if(res == JOptionPane.YES_OPTION){
			map.dispose();
			newGame = new Game();
		}else{

			map.dispose();
			System.exit(0);

		}

	}

	void howToPlayPopUp(){

		howTo = new JOptionPane();
		howTo.showMessageDialog(null,"This is a classical tictactoe game.\nWhere the XXX or OOO wins.\nMade by Mert Kaya - 2019", "How To Play", JOptionPane.DEFAULT_OPTION);
	}
	public static void main(String[] args) {
		
		newGame = new Game();
		
		
	}
}