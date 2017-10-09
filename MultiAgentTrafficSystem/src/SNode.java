public class SNode extends OpenNode
{
	public SNode(int _id, Intersection _inter, int _x, int _y)
	{
		super(_id, _inter, _x, _y);
	}
	
	public void Update()
	{
		System.out.println(currentVehicles + " have made it to the sink");
	}
}
