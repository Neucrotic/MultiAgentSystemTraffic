public class RNode extends Node
{
	private QNode bestRoute = null;
	
	public RNode(int _id, int _maxVehicles, int _x, int _y)
	{
		super(_id, _maxVehicles, _x, _y);
	}
	
	public void SetBestRoute(QNode _q)
	{
		this.bestRoute = _q;
	}
}
