
public abstract class Pet {

	protected String petName;
	protected int petYearBorn;
	
	public Pet (String name, int year)
	{
		petName=name;
		petYearBorn=year;
	}
	
	public String speak()
	{
		return "";
	}
	
	public String getName()
	{
		return petName;
	}
}
