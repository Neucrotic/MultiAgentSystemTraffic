public class Main
{	
	public static void main(String[] args)
	{
		Network network = new Network();
		network.setTitle("MAS Traffic System");
		
		network.StartOnEnter();
		
		while (network.run)
		{
			network.Update();
			//network.repaint();
			
			network.StartOnEnter();
		}
	}

}
