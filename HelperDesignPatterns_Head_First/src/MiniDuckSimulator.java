
public class MiniDuckSimulator {
	public static void main(String[] args){
		Duck mallardDuckie = new MallardDuck();
		mallardDuckie.display();
		mallardDuckie.performQuack();
		mallardDuckie.performFly();

		Duck modelDuckie = new ModelDuck();
		modelDuckie.display();
		 modelDuckie.performFly();
		 modelDuckie.setFlyBehavior(new FlyRocketPowered());
		 modelDuckie.performFly();
		 
		 DuckCallWhistle duckieCallWhistle = new DuckCallWhistle();
		 duckieCallWhistle.display();
		 duckieCallWhistle.performQuack();
	}
}
