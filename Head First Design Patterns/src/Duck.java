/**
 * This is the superclass daddy class for all ducks, real, decoy, or whatever!
 * 
 * @author Bryan
 *
 */
public abstract class Duck {
	
	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;
	
	public void setQuackBehavior(QuackBehavior qb){
		quackBehavior=qb;
	}
	
	public void performQuack(){
		quackBehavior.quack();
	}
	
	public void setFlyBehavior(FlyBehavior fb){
		flyBehavior = fb;
	}
	
	public void performFly(){
		flyBehavior.fly();
	}
	
	public void swim(){
		System.out.println("All ducks float, even decoys!");
	}
	
	public void display(){
		
	}
	
}
