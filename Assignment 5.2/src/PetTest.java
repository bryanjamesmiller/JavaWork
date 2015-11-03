public class PetTest 
{

	public static void main (String [] args)
	{
		Pet [] myPets = new Pet [3];
		myPets [0] = new Dog ("Boo-Boo", 1998);
		myPets [1] = new Cat ("Tigi", 1999);
		myPets [2] = new Cat ("Sheldon", 2001);
		for (Pet p : myPets)
		{
			System.out.println (p.getName() + " says "
					+ p.speak() );

		}
	}	
}
