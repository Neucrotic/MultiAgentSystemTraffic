import java.awt.Graphics;

public class Node 
{
	public int x;
	public int y;
	
	public Node(int _x, int _y)
	{
		this.x = _x;
		this.y = _y;
	}
	
	public void Draw(Graphics _g)
	{
		_g.drawOval(x, y, 50, 50);
	}
}
