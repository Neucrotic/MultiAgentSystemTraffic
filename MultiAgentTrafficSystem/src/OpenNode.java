public class OpenNode extends Node
{
	protected Intersection inter;
	
	public OpenNode(int _id, Intersection _inter, int _x, int _y)
	{
		super(_id, _x, _y);
		this.inter = _inter;
	}
	
	public Intersection GetInter()
	{
		return this.inter;
	}
}
