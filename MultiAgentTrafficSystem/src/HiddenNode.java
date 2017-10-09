public class HiddenNode extends Node
{
	protected int maxVehicles;
	
	public HiddenNode(int _maxVehicles, int _id, int _x, int _y)
	{
		super(_id, _x, _y);
	}
	
	public boolean HasCapacity()
	{
		if (this.currentVehicles < this.maxVehicles)
		{
			return true;
		}
		
		return false;
	}
	
	public int GetMaxVehicles()
	{
		return this.maxVehicles;
	}
	
	public void AddNumVehicles(int _num)
	{
		for (int i = 0; i < _num; i++)
		{
			if (this.HasCapacity())
			{
				this.AddVehicle();
			}
		}
	}
	
	public void RemoveNumVehicles(int _num)
	{
		for (int i = 0; i < _num; i++)
		{
			if (this.currentVehicles > 0)
			{
				this.RemoveVehicle();
			}
		}
	}
}
