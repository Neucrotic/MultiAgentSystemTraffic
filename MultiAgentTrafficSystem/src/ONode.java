public class ONode extends OpenNode
{
	private int spawnRate;
	
	public ONode(int _spawnRate, int _id, Intersection _inter, int _x, int _y)
	{
		super(_id, _inter, _x, _y);
		this.spawnRate = _spawnRate;
		this.inter = _inter;
	}
	
	public void Update()
	{
		for (int i = 0; i < spawnRate; i++)
		{
			AddVehicle();
			System.out.println("Vehicle Spawned");
		}
		
		System.out.println("Origin " + this.id + " contains " + this.currentVehicles + " vehicles");
	}
}
