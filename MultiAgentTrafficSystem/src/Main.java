public class Main
{	
	public static void main(String[] args)
	{
		Network network = new Network(1);
		network.setTitle("MAS Traffic System");
		
		while (network.run)
		{
			network.Update();
		}
	}

}
