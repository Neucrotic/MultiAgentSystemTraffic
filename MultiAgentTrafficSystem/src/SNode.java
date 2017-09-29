public class SNode extends Node
{
	public SNode(int _id, int _maxVehicles, int _x, int _y)
	{
		super(_id, _maxVehicles, _x, _y);
	}
	
	public void Update()
	{
		if (currentVehicles > 0)
		{
			System.out.println(currentVehicles + " arrived at the sink");
			currentVehicles = 0;
		}
	}
	
	//overriding
	public void AddVehicle()
	{
		super.AddVehicle();
	}
}
