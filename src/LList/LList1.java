package LList;

import java.lang.reflect.Array;
import java.util.Iterator;

public class LList1<T> implements GList<T>
{
	Node root = null;

	public class Node
	{
		T val;
		Node next = null;
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
		clear();
		if ( ini == null || ini.length == 0 )
		{
			ini = (T[]) new Comparable[0];
		}
		for ( int i = 0; i < ini.length; i++ )
		{
			addStart( ini[ini.length - i - 1] );
		}
	}

	@Override
	public T[] toArray() 
	{
		int i = 0;
		Node tmp = root;
		T[] temp = null;
		if ( root == null )
		{
			temp = (T[]) new Comparable[0];
		}
		else 
		{
			temp = (T[]) Array.newInstance(tmp.val.getClass(),size());
		}
		while ( tmp != null )
		{
			temp[i++] = tmp.val;
			tmp = tmp.next;
		}
		return temp;
	}

	@Override
	public String toString()
	{
		if(root == null)
		{
			return "";
		}
		String str = "";
		T[] temp = (T[]) new Comparable[size()];
		Node tmp = root;
		int i = 0;
		while ( tmp != null )
		{
			if ( i > 0 )
			{
				str += ", ";
			}
			temp[i] = tmp.val;
			tmp = tmp.next;
			str += temp[i];
			i++;
		}
		return str;
	}

	@Override
	public int size() 
	{
		Node tmp = root;
		int count = 0;
		while ( tmp != null )
		{
			tmp = tmp.next;
			count ++;
		}
		return count;
	}

	@Override
	public void addStart(T val)
	{
		Node tmp = new Node (val);
		tmp.next = root;
		root = tmp;
	}

	@Override
	public void addEnd(T val)
	{
		if (root == null)
			root = new Node(val);
		else
		{
			Node tmp = root;
			while ( tmp.next != null )
			{
				tmp = tmp.next;
			}
			tmp.next = new Node (val);
		}
	}

	@Override
	public void addPos(int pos, T val) 
	{
		if ( pos < 0 || pos > size() )
		{
			throw new IllegalArgumentException();
		}
		else if ( pos == 0 || root == null )
		{
			addStart(val);
		}
		else 
		{
			Node tmp = root;
			int i = 1;
			Node valtemp = new Node (val);
			while ( i < pos )
			{
				tmp = tmp.next;
				i++;
			}
			valtemp.next = tmp.next;
			tmp.next = valtemp;
		}
	}

	@Override
	public T delStart() 
	{
		if ( size() == 0 )
		{
			throw new IllegalArgumentException();
		}
		Node tmp = root;
		T res = tmp.val;
		root = tmp.next;
	
		return res;
	}

	@Override
	public T delEnd() 
	{
		T res = null;
		if ( root == null )
		{
			throw new IllegalArgumentException();
		}
		if ( size() == 1 )
		{
			delStart();
		}
		else 
		{
			Node tmp = root;
			Node temp = null;
			while ( tmp.next != null )
			{
				temp = tmp;
				tmp = tmp.next;
			}
			temp.next = null;
			res =  tmp.val;
		}
		return res;
	}

	@Override
	public T delPos(int pos) 
	{
		if ( root == null || pos < 0 || pos > size() - 1 )
		{
			throw new IllegalArgumentException();
		}
		T res = null;
		Node tmp = root;
		Node tmpPos = null;

		if ( size() == 0  )
		{
			throw new IllegalArgumentException();
		}

		if ( size() == 1 || pos == 0 )
		{
			delStart();
		}
		else 
		{
			int i = 0;
			while ( i < pos )
			{
				tmpPos = tmp;
				tmp = tmp.next;
				i++;
			}
			tmpPos.next = tmp.next;
			res = tmp.val;
		}
		return res;
	}

	@Override
	public T min() 
	{
		T min = root.val;

		if ( root == null  )
		{
			throw new IllegalArgumentException();
		}
		else 
		{
			Node tmp = root.next;
			while ( tmp != null )
			{
				if ( ((Comparable)tmp.val).compareTo(min) < 0 )
				{
					min = tmp.val;
				}
				tmp = tmp.next;
			}
			
		}
		return min;
	}

	@Override
	public T max() 
	{
		T max = root.val;
		if ( root == null  )
		{
			throw new IllegalArgumentException();
		}
		else 
		{
			Node tmp = root.next;
			while ( tmp != null )
			{
				if ( ((Comparable)tmp.val).compareTo(max) > 0 )
				{
					max = tmp.val;
				}
				tmp = tmp.next;
			}
		}
		return max;
	}

	@Override
	public int indMin() 
	{
		int minInd = 0;
		if ( root == null || size() == 0 )
		{
			throw new IllegalArgumentException();
		}
		else 
		{
			T minVal = root.val;
			Node tmp = root.next;
			int i = 0;
			while ( tmp != null )
			{
				i++;
				if ( ((Comparable)tmp.val).compareTo(minVal) < 0 )
				{
					minInd = i;
				}
				tmp = tmp.next;
			}
		}
		return minInd;
	}

	@Override
	public int indMax() 
	{
		int maxInd = 0;
		if ( root == null  )
		{
			throw new IllegalArgumentException();
		}
		else 
		{
			T maxVal = root.val;
			Node tmp = root.next;
			int i = 0;
			while ( tmp != null )
			{
				i++;
				if ( ((Comparable)tmp.val).compareTo(maxVal) > 0 )
				{
					maxInd = i;
				}
				tmp = tmp.next;
			}
		}
		return maxInd;
	}

	@Override
	public void sort() 
	{
		if ( size() == 1 || root == null )
		{
			return;
		}
		else 
		{
				if (root == null || size() == 1)
					return;
				Node tmpMin = new Node(min());
				delPos(indMin());

				Node tmp1 = tmpMin;

				while(root.next != null)
				{
					tmp1.next = new Node(min());
					delPos(indMin());
					tmp1 = tmp1.next;			
				}
				tmp1.next = new Node(root.val);
				root = tmpMin;
		}
	}

	@Override
	public void reverse()
	{
		if (root == null || root.next == null)
		{
			return;
		}
		Node tmp = root;
		int count = 0;
		while ( tmp != null ) 
		{
			addStart(tmp.val);
			count++;
			tmp = tmp.next;
			delPos(count);
		}
	}

	@Override
	public void halfReverse() 
	{
		if ( root == null || size() == 1 )
		{
			return;
		}
		int count = 0;
		Node tmp1 = root;
		Node tmp2 = root;
		Node tmp3 = root;
		if ( size() == 2 )
		{
			reverse();
		}
		else
		{
			while ( tmp3.next != null ) 
			{
				tmp3 = tmp3.next;
				count++;
				if ( count < size() / 2 )
				{
					tmp1 = tmp1.next;
				}
			}
			if ( size() % 2 == 0 )
			{
				tmp2 = tmp1.next;
				tmp3.next = root;
			}
			else 
			{
				tmp2 = tmp1.next.next;
				tmp3.next = tmp1.next;
				tmp3.next.next = root;
			}
			tmp1.next = null;
			root = tmp2;
		}
	}

	@Override
	public void set(int pos, T val) 
	{
		if ( pos < 0 || pos > size() - 1 || root == null )
		{
			throw new IllegalArgumentException();
		}
		Node tmp = root;
		for ( int i = 0; i < pos; i++ )
		{
			tmp = tmp.next;
		}
		tmp.val = val;
	}

	@Override
	public T get(int pos) 
	{
		if ( pos < 0 || pos > size() - 1 || root == null )
		{
			throw new IllegalArgumentException();
		}
		Node tmp = root; 
		for ( int i = 0; i < pos; i++ )
		{
			tmp = tmp.next;
		}
		
		return tmp.val;
	}

	@Override
	public Iterator<T> iterator() 
	{
		return (Iterator<T>) new MyIter ( root );
	}
	class MyIter implements Iterator<T>
	{
		Node p = null;
		public MyIter ( Node p )
		{
			this.p = p;
		}
		@Override
		public boolean hasNext() 
		{
			return p != null;
		}
		@Override
		public T next() 
		{
			T ret = p.val;
			p = p.next;
			return ret;
		}
	}

	@Override
	public int compareTo(T o) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
