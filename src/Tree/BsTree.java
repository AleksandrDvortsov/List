package Tree;

import java.lang.reflect.Array;
import java.util.Iterator;

import javax.xml.transform.Templates;

public class BsTree<T> implements BsTreeInterface<T>
{
	public Node root = null;

	public class Node
	{
		public T val;
		public Node left = null;
		public Node right = null;

		public Node ( T val )
		{
			this.val = val;
		}
	}

	@Override
	public void clear() 
	{
		root = null;
	}

	@Override
	public void init(T[] ini) 
	{
		if ( ini == null )
		{
			ini = (T[]) new Comparable[0];
			clear();
			return;
		}
		
		for ( int i = 0; i < ini.length; i++ )
		{
			add( ini[i] );
		}
	}

	@Override
	public void add(T val)
	{
		if ( root == null )
		{
			root = new Node ( val );
			return;
		}
		addNode ( root, val );
	}

	private void addNode(Node p, T val) 
	{
		if ( val instanceof Comparable)
		{		
			if ( ((Comparable)val).compareTo(p.val) < 0 )
//		if ( val < p.val )
			{
				if ( p.left == null )
				{
					p.left = new Node ( val );
				}
				else 
				{
					addNode(p.left, val);
				}
			}
			
			else 
			{
				if ( p.right == null )
				{
					p.right = new Node ( val );
				}
				else 
				{
					addNode(p.right, val);
				}
			}
		}
	}

	@Override
	public int size() 
	{
		return sizeNode( root );
	}
	private int sizeNode( Node p ) 
	{
		if ( p == null )
		{
			return 0;
		}
		int res = 0;
		res += sizeNode(p.left);
		res++;
		res += sizeNode(p.right);
		return res;
	}

	@Override
	public int nodes() 
	{
		return NodesNode( root );
	}

	private int NodesNode( Node p ) 
	{
		int count = 0;
		if ( p == null )
		{
			return 0;
		}
		if ( p.left != null && p.right != null )
		{
			count += NodesNode( p.left ) + NodesNode( p.right );
			count++;
		}
		return count;
	}

	@Override
	public int leaves() 
	{
		return leavesNode( root );
	}

	private int leavesNode( Node p ) 
	{
		int count = 0;
		if (p == null)
		{
			return 0;
		}
		if ( p.left == null && p.right == null )
		{
			count ++;
		}
		count += leavesNode(p.left) + leavesNode(p.right);
		return count;
	}

	@Override
	public int height() 
	{
		if ( root == null ) 
		{
			return 0;
		}
		if ( size() == 1 )
		{
			return 1;
		}
		else
		{
			return heightNode( root );
		}
	}

	private int heightNode( Node p ) 
	{
		if ( p == null )
		{
			return 0;
		}

		return 1+Math.max(heightNode(p.left), heightNode(p.right));
	}

	@Override
	public int widht() 
	{
		int[] ar = new int[height()];
		widhtNode ( root, ar , 0);
		return max(ar) ;
	}

	private int max ( int[] ar ) 
	{
		if ( ar == null || ar.length == 0 )
		{
			return 0;
		}
		int val = ar[0];
		for ( int i = 0; i < ar.length; i++ )
		{
			if ( ar[i] > val )
			{
				val = ar[i];
			}
		}
		return val;
	}

	private void widhtNode( Node p, int[]ar, int lvl ) 
	{
		if ( p == null )
		{
			return;
		}
		widhtNode(p.left, ar, lvl+1);
		ar[lvl]++;
		widhtNode(p.right, ar, lvl+1);
	}

	@Override
	public T[] toArray() 
	{
		T[] temp = (T[]) Array.newInstance ( Integer.class, size() );
//		T[] temp = (T[]) new Comparable[size()];
		nodeToArray( root, temp, new Counter() );
		return temp;
	}

	class Counter
	{
		int i=0;
	}
	private void nodeToArray( Node p, T[] ar, Counter ii )
	{
		if( p == null )
			return;

		nodeToArray( p.left, ar,ii );
		ar [ii.i++ ]= p.val;
		nodeToArray( p.right, ar,ii );
	}

	public String toString()
	{
		return ToString( root );
	}

	private String ToString( Node p ) 
	{
		if ( p == null )
		{
			return "";
		}
		else 
		{
			return ToString(p.left) + p.val + " " + ToString(p.right) ;
		}
	}

//	private Node min(Node p)
//	{
//		if(p.left == null)
//			return p;
//		return min(p.left);
//	}

	@Override
	public void del( T val ) 
	{
		if ( root == null )
			throw new IllegalArgumentException();
		nodeDel ( root, root, val );
	}
	private void nodeDel(Node cur, Node par, T val) 
	{
		if ( cur == null )
			throw new IllegalArgumentException();

		if ( ((Comparable)val).compareTo(cur.val) < 0 )
		{
			nodeDel( cur.left, cur, val );
		}
		else if ( ((Comparable)val).compareTo(cur.val) > 0 )
		{
			nodeDel( cur.right, cur, val );
		}
		else
		{
			if ( cur.left == null && cur.right == null )
			{
				if ( cur == root )
				{
					root = null;
				}
				else 
				{
					if ( cur == par.left )
					{
						par.left = null;
					}
					else 
					{
						par.right = null;
					}
				}
			}
			else if ( cur.right == null )
			{
				if ( cur == root )
				{
					root = cur.left;
				}
				else if ( cur == par.left ) 
				{
					par.left = cur.left;
				}
				else 
				{
					par.right = cur.left;
				}
			}
			else if ( cur.left == null )
			{
				if ( cur == root )
				{
					root = cur.right;
				}
				else if ( cur == par.left )
				{
					par.left = cur.right;
				}
				else 
				{
					par.right = cur.right;
				}
			}
			else 
			{
				Node tnp = searchNode ( cur.left );
				tnp.right = cur.right;

				if ( cur == root  )
				{
					root = cur.left;
				}
				else if ( cur == par.left )
				{
					par.left = cur.left;
				}
				else 
				{
					par.right = cur.left;
				}
			}
		}
	}

	private Node searchNode( Node p ) 
	{
		if ( p.right == null )
			return p;
		else 
		{
			return searchNode( p.right );
		}
	}

//	@Override
//	public void del( int val ) 
//	{
//		if ( root == null )
//			throw new IllegalArgumentException();
//		nodeDel ( root, val );
//	}
//
//		private Node nodeDel( Node p, int val ) 
//		{
//			
//				if ( p == null )
//				{
//					return p;
//				}
//	//	     Node ret = null;
//				else 
//				{
//				if ( val < p.val )
//				{
//					p.left = nodeDel(p.left, val);
//				}
//				else if ( val > p.val )
//				{
//					p.right = nodeDel(p.right, val);
//				}
//	// else 
////	{
////		if ( p.left == null && p.right == null )
////	{
////		ret = null;
////	}
////	else if ( p.right == null )
////	{
////		ret = p.left;
////	}
////	else if ( p.left .......){
////		-||-}
////	else 
////	{
////		return ret;
////	}
////	}
//				else if ( p.left != null && p.right != null )
//				{
//					p.val = min(p.right).val;
//					p.right = nodeDel(p.right, p.val);
//				}
//				else
//				{
//					if ( p.left != null )
//					{
//						p = p.left;
//					}
//					else 
//					{
//						p = p.right;
//					}
//				}
//			}
//			return p;
//		}

	public void print() 
	{
		print_Node(root);
	}

	public void print_Node ( Node p ) 
	{
		if ( p == null )
		{
			return;
		}
		print_Node( p.left );
		System.out.print( p.val +" " );
		print_Node( p.right );
	}

	@Override
	public void reverse() 
	{
		reverseNode(root);

	}

	private void reverseNode(Node p) 
	{
		if ( p ==null )
			return;
		Node tmp = p.right;
		p.right = p.left;
		p.left = tmp;

		if ( p.left != null )
		{
			reverseNode(p.left);
		}
		if ( p.right != null )
		{
			reverseNode(p.right);
		}
	}
	
	public boolean equals(BsTree tr)
	{
		return equalsNode ( root, tr.root );
	}

	private boolean equalsNode(Node p, Node tr) 
	{
		if ( p == null && tr == null )
			return true;
		return equalsNode(p.right, tr.right) && equalsNode(p.left, tr.left) &&
				p.val == tr.val;
	}

	@Override
	public Iterator<T> iterator() 
	{
		return new MyIter(root);
	}
	class MyIter implements Iterator<T>
	{
		Node p;
		public MyIter ( Node p )
		{
			this.p = p;
		}
		@Override
		public boolean hasNext() 
		{
			return p!=null;
		}
		@Override
		public T next() 
		{
			T tmp = p.left.val;
			p.right.val = p.left.val;
			p.left.val = tmp;
			T ret = tmp;
			return ret;
		}
	}

	@Override
	public int compareTo ( T o ) 
	{
		return 0;
	}
}
