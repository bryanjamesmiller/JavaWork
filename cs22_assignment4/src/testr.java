
public class testr {
	public static boolean isHeapTree(arr [], int i)
	{
		if((arr.length - i) >= 3) //if there's at least a parent node with 
			//two children at this tree/subtree
		{
			if(arr[i] < arr[2 * i + 1])  //if the left child is larger than a parent, 
				//return false since it's not a heap
				return false;
			if(arr[i] < arr[2 * i + 2])  //if the right child is larger than a parent, 
				//return false since it's not a heap
				return false;
			else if((arr.length - i) == 3) //if there are no more subtrees we need to consider, 
				//and it passed the above conditions, this tree is a heap, so return true.
			{
				return true;
			}
			else //if there are more than three nodes, 
				//make a recursive call on the next node
				isHeapTree(arr[], i + 1)
		}

		if((arr.length - i) == 2) //if there's a parent node with one 
			//child at this tree/subtree
		{
			if(arr[i] < arr[2 * i + 1])  //if the only child is larger than a parent, 
				//return false since it's not a heap
				return false;
		}
		else // We've reached the end of the tree and it's a heap since
			// it passed the above conditions
			return true;
	}



	private static void dfTrav(Vertex v) 
	{
		System.out.println(v.id);
		v.done = true;
		Edge e = v.edges;
		Stack<Vertex> myStack = new LLStack<Vertex>();
		myStack.insert(v); //we want a stack so once we reach a leaf vertex,
		// we can get the most recently visited parent vertex,
		//and try to visit another path down to another leaf vertex.

		while(!myStack.isEmpty())
		{

			while (e != null) 
			{
				//Find the first available vertex in the adjacency list 
				Vertex w = e.end;

				//if the first available vertex in the adjacency list has not been visited, 
				//visit it and get its adjacency list
				if(w.done == false)
				{
					System.out.println(w.id);
					w.done = true; //mark the new vertex as visited             
					myStack.insert(w); //add this vertex to the stack
					Edge e = w.edges;  //get the new adjacency list from the newly visited vertex
				}

				//Otherwise, if that vertex has been visited, 
				// try the next edge in the adjacency list.  
				//If it doesn't have another edge, then e
				//will be set to null, and the inner while loop will quit.
				else if(w.done == true) 
					e = e.next;
			}

			//If the inner while loop quit, then all the edges from the adjacency list from the vertex it was considering have 
			//been tested, and all connected vertices have been visited, 
			//so move to the next parent vertex in the stack until there are no more, 
			//at which time v will be set to null and the outer loop will exit.
			Vertex v = myStack.remove(); 
			Edge e = v.edges;
		}
	}

	11.  
	public boolean isAdjacent(Vertex v1, Vertex v2)
	{
		Edge e1 = v1.edges;
		Edge e2 = v2.edges;

		while(e1 != null)
		{
			if(e1.end == v1)
				return true;
			else
				e1 = e1.next;
		}

		while(e2 != null)
		{
			if(e2.end == v1)
				return true;
			else
				e2 = e2.next;
		}
		return false;

	}

}
