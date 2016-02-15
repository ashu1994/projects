
public class gameplay {
	int player = 1;
	int setstroke = 0;
	int shotplayed = 0;
	int player1score =0;
	int player2score =0;
	
	public void changeplayer(){
		if(player == 1)
			player = 2;
		else 
			player = 1;
	
	}

	public void changescore(int j) {
		// TODO Auto-generated method stub
		if(j%2==0){
			if(player==1){
				player1score += 20; 
			}
			else{
				player2score += 20; 
			}
		}
		else{
			if(player==1){
				player1score += 10; 
			}
			else{
				player2score += 10; 
			}
		}
		System.out.println("player 1: " + player1score);
		System.out.println("player 2: " + player2score);
	}

	public void changescore() {
		// TODO Auto-generated method stub
		if(player==1){
			player1score += 50; 
		}
		else{
			player2score += 50; 
		}
	}
	
	
}
