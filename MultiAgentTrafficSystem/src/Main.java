
public class Main
{

	public static void main(String[] args)
	{
		Network network = new Network(5);
		
		while (network.run)
		{
			network.Update();
			network.Draw();
		}
	}

}
