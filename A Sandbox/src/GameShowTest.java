import java.util.*;
public class GameShowTest {
	public static void main(String[] args){
		double counter=0;
		for(int i=0; i<1000; i++){
			GameShowSimulator myTest = new GameShowSimulator();
			int prizeBox = myTest.prizeLocation();
			int userPick = myTest.contestantPick();
			int remainingPick = myTest.findRemainingBox(userPick, prizeBox);
			if(remainingPick==0)
				System.out.println("prizeBox = " + prizeBox + " and userPick = " + userPick);
			System.out.println("The Game Show Host says the prize isn't in Box " + remainingPick + "!");
			userPick=myTest.switchPick(userPick, remainingPick);
			System.out.println("Now your pick is box " + userPick);
			if(myTest.winTest(prizeBox, userPick))
				counter++;
		}
		System.out.println(counter/1000.0);
	}
}

class GameShowSimulator{
	Scanner userInput=new Scanner(System.in);
	int remainingPick;
	static int winCounter=0;
	static int numGamesPlayed=0;
	static double winPercentage=0;

	int prizeLocation(){
		System.out.println("The Game Show Host says pick a box!");
		int prizeBox = randomNumberGenerator(1, 3);
		System.out.println("The prize is in box " + prizeBox);
		return prizeBox;
	}

	int contestantPick(){
		//		System.out.print("Pick a number between 1 and 3: ");
		//		int userPick=userInput.nextInt();
		int userPick = randomNumberGenerator(1, 3);
		System.out.println("You've picked box " + userPick);
		return userPick;
	}

	int findRemainingBox(int userPick, int prizeBox){
		if(prizeBox==1)
		{
			if(userPick==1){
				return this.randomNumberGenerator(2,3);
			} else if(userPick==2){
				return 3;	
			} else if(userPick==3){
				return 2;
			}
		} 
		else if(prizeBox==2) {
			if(userPick==2){
				int randNum=2;
				while(randNum==2)
					randNum=this.randomNumberGenerator(1,3);
				return randNum;
			} else if(userPick==3){
				return 1;	
			} else if(userPick==1) {
				return 3;
			}
		}
		else if(prizeBox==3){
			if(userPick==3){
				return this.randomNumberGenerator(1, 2);
			} else if(userPick==1){
				return 2;
			}else if(userPick==2){
				return 1;
			}
		} 

		return userPick;
	}

	int switchPick(int userPick, int remainingPick){
		System.out.println("The Game Show Host says would you like to switch your pick?");
		System.out.println("You say, of course!");
		System.out.println("The contestant switches his pick with the 1 remaining box");
		if(userPick==1 && remainingPick==2)
			return 3;
		else if(userPick==1 && remainingPick==3)
			return 2;
		else if(userPick==2 && remainingPick==1)
			return 3;
		else if(userPick==2 && remainingPick==3)
			return 1;
		else if(userPick==3 && remainingPick==1)
			return 2;
		else //if(userPick==3 && remainingPick==2)
			return 1;
	}

	boolean winTest(int prizeBox, int userPick){
		numGamesPlayed++;
		if(prizeBox==userPick){
			System.out.println("You won!");
			winCounter++;
			return true;
		}else{
			System.out.println("You lost!");
		}
		return false;
	}


	int randomNumberGenerator (int a, int b)
	{
		return (a + (int)((b-a+1) * Math.random()));
	}

}
