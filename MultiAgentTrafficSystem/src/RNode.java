public class RNode extends Node
{
	private QNode bestRoute = null;
	
	public RNode(int _maxVehicles, int _x, int _y)
	{
		super(_maxVehicles, _x, _y);
	}
	
	public void SetBestRoute(QNode _q)
	{
		this.bestRoute = _q;
	}
}
