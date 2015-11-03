
public class DuckCallWhistle{
	QuackBehavior quackBehavior = new Quack();
	
	public void performQuack(){
		quackBehavior.quack();
	}
	
	public void display(){
		System.out.println("I think I'm a duck whistle.......");
	}

}
