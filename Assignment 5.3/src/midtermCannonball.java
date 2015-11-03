
public class midtermCannonball {

	public static void main(String [] args){
		System.out.println(cannonballs(5));
	}

	public static int cannonballs(int height){
		//FIGURE OUT BASE CASE FIRST!!
		//In this case, if the height is 1, then there
		//is just one cannonball.
		//Then figure out what the program is going to do
		// and use it that way.  In this case, the program
		// is going to return the number of cannonballs
		// for a certain height.
		if(height==1){
			return 1;
		}
		int numCannonballs=height*height+cannonballs(height-1);
		return numCannonballs;

		/*
			OR, you could just say:
			return height*height+cannonballs(height-1)
		 */
	}		
}


