public class Main
{	
	public static void main(String[] args)
	{
		Network network = new Network(1);		
		//Renderer renderer = new Renderer(network.GetDrawables());
		network.setTitle("MAS Traffic System");
		
		network.StartOnEnter();
		network.InitEdgeTimers();
		
		while (network.run)
		{
			network.Update();
			network.repaint();
			
			//network.StartOnEnter();
		}
	}

}
