public class ONode extends Node
{
	private int spawnRate;
	
	public ONode(int _spawnRate, int _maxVehicles, int _x, int _y)
	{
		super(_maxVehicles, _x, _y);
		this.spawnRate = _spawnRate;
	}
	
	public void Update()
	{
		for (int i = 0; i < spawnRate; i++)
		{
			if (HasCapacity())
			{
				AddVehicle();
				System.out.println("Vehicle Spawned");
			}
		}
	}
}
