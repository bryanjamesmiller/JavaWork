/**
 * 
 * This is an interface that all of the "duck" subclasses can program to.  It is kind of like a 
 * superclass/daddy class for different kinds of subclass fly behaviors, but instead of parent/child
 * classes, it is an interface/implementation relationship.  The interface just forces the implementation
 * to have the same methods found in the interface.
 * 
 * @author Bryan
 * 
 *   
 * One advantage of this is that if the duck subclasses need different kinds of 
 * flying behaviors, it can be changed using a new implementation of this interface.
 * Otherwise, a lot of recoding would be necessary if done through inheritance or just 
 * one main interface, and that code wouldn't be reusable (if done through an interface)
 * and that code wouldn't be variable (if done through inheritance).  
 * 
 * Another advantage of this is that the duck subclasses
 * can easily change their type of flying behavior if they need to by 
 * accessing different implementations of this interface.  
 */
public interface FlyBehavior {
	
	public void fly();
	
}
