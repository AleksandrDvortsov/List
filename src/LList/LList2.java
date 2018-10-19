package LList;

import java.lang.reflect.Array;
import java.util.Iterator;

public class LList2<T> implements GList<T>
{
	Node front = null;
	Node rear = null;

	public class Node 
	{
		T val;
		Node next = null;
		Node prev = null;

		public Node ( T val )
		{
			this.val = val;
		}
		public Node ( T val, Node next )
		{
			this.val = val;
			this.next = next;
		}
		public Node ( T val, Node prev, Node next )
		{
			this.val = val;
			this.prev = prev;
			this.next = next;
		}
	}

	@Override
	public void clear() 
	{
		front = null;
		rear = null;
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
			addEnd(ini[i]);
		}
	}

	@Override
	public T[] toArray() 
	{
		int i = 0;
		Node tmp = front;
		T[]temp = null;
		if ( front == null )
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
		if( front == null )
		{
			return "";
		}
		String str = "";
		T[] temp = (T[]) new Comparable[size()];
		int i = 0;
		Node tmp = front;
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
		Node tmp = front;
		int count = 0;
		while (tmp != null ) 
		{
			tmp = tmp.next;
			count++;
		}
		return count;
	}

	@Override
	public void addStart(T val) 
	{
		if ( front == null )
		{
			front = rear = new Node ( val );
			return;
		}
		else
		{
			Node tmp  = new Node ( val , front, null );
			tmp.next = front;
			front = tmp;
		}
	}

	@Override
	public void addEnd(T val) 
	{
		if ( front == null )
		{
			front = rear = new Node ( val );
			return;
		}
		else
		{
			rear.next = new Node ( val , rear, null );
			rear = rear.next;
		}
	}

	@Override
	public void addPos(int pos, T val) 
	{
		if ( pos < 0 || pos > size() )
		{
			throw new IllegalArgumentException();
		}
		else if ( pos == 0 )
		{
			addStart(val);
		}
		else if ( pos == size())
		{
			addEnd(val);
		}
		else 
		{
			Node tmp = front;
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
		T res = null;
		if ( front == null )
		{
			throw new IllegalArgumentException();
		}
		if ( size() == 1 )
		{
			clear();
		}
		else 
		{
			res = front.val;
			front = front.next;
			front.prev = null;
		}
		return res;
	}

	@Override
	public T delEnd() 
	{
		if ( front == null )
		{
			throw new IllegalArgumentException();
		}
		if ( size() == 1 )
		{
			delStart();
		}
			T res = rear.val;
			rear = rear.prev;
			rear.next = null;
		
		return res;
	}

	@Override
	public T delPos(int pos) 
	{
		T res = null;
		if ( front == null || pos < 0 || pos > size() - 1  )
		{
			throw new IllegalArgumentException();
		}
		if ( size() == 1 || pos == 0 )
		{
			delStart();
		}
		else if (pos == size() - 1)
		{
			delEnd();
		} 
		else 
		{
			Node tmpfront = front;
			Node tmprear = rear;
			int size = size();

			if ( pos <= size/2 )
			{
				for (int i = 0; i < pos; i++)
				{
					tmpfront = tmpfront.next;
				}
				tmpfront.prev.next = tmpfront.next;
			}
			else 
			{
				for (int i = 1; i < size - pos; i++)
				{
					tmprear = tmprear.prev;
				}
				tmprear.next.prev = tmprear.prev;
			}
		}
		return res;
	}

	@Override
	public T min() 
	{
		T min = null;

		if ( front == null  )
		{
			throw new IllegalArgumentException();
		}
		else 
		{
			min = front.val;
			Node tmp = front.next;
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
		T max = null;
		if ( front == null )
		{
			throw new IllegalArgumentException();
		}
		else 
		{
			max = front.val;
			Node tmp = front.next;
			while ( tmp != null )
			{
				if (((Comparable)tmp.val).compareTo(max) > 0)
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
		if ( front == null  )
		{
			throw new IllegalArgumentException();
		}
		else 
		{
			T minVal = front.val;
			Node tmp = front.next;
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
		if ( front == null )
		{
			throw new IllegalArgumentException();
		}
		else 
		{
			T maxVal = front.val;
			Node tmp = front.next;
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
		if ( front == null || size() == 1 )
		{
			return;
		}
		else 
		{
		Node tmpMin = new Node(min());
		delPos(indMin());

		Node tmp1 = tmpMin;

		while ( front.next != null )
		{
			tmp1.next = new Node(min());
			delPos(indMin());
			tmp1 = tmp1.next;			
		}
		tmp1.next = new Node(front.val);
		front = tmpMin;
		}
	}

	@Override
	public void reverse() 
	{
		if (front == null || size() == 1)
		{
			return;
		}
		Node tmp = front;
		front = null;
		while ( tmp != null ) 
		{	
			addStart(tmp.val);
			tmp = tmp.next;
		}
	}

	@Override
	public void halfReverse() 
	{
		if( front == null || size() == 1 )
		{
			return;
		}
		int count = 0;
		Node tmp1 = front;
		Node tmp2 = front;

		while ( count < size() / 2 - 1 )
		{
			count++;		
			tmp1 = tmp1.next;							 
		}
		if( size() % 2 == 0 )
		{
			tmp2 = tmp1.next;
			rear.next = front;
			front.prev = rear.next;
		}
		else
		{
			tmp2 = tmp1.next.next;
			rear.next = tmp1.next;
			tmp1.next.prev = rear;
			rear.next.next = front;
			front.prev = rear.next.next;	
		}
		tmp1.next = null;
		tmp2.prev = null;
		front = tmp2;
		rear = tmp1;
	}

	@Override
	public void set(int pos, T val) 
	{
		if ( pos < 0 || pos > size() - 1 || front == null )
		{
			throw new IllegalArgumentException();
		}
		else 
		{
			Node tmp;
			if ( pos <= size()/2 )
			{
				tmp = front;
				for ( int i = 0; i < pos; i++ )
				{
					tmp = tmp.next;
				}
			}
			else 
			{
				tmp = rear;
				for ( int i = 1; i < size() - pos; i++ )
				{
					tmp = tmp.prev;
				}
			}
			tmp.val = val;
		}
	}

	@Override
	public T get(int pos) 
	{
		Node tmp = null;
		if ( pos < 0 || pos > size() - 1 || front == null )
		{
			throw new IllegalArgumentException();
		}
		else 
		{
			if ( pos <= size()/2)
			{
				tmp = front;
				for ( int i = 0; i < pos; i++ )
				{
					tmp = tmp.next;
				}
			}
			else 
			{
				tmp = rear;
				for ( int i = 1; i < size() - pos; i++ )
				{
					tmp = tmp.prev;
				}
			}
		}
		return tmp.val;
	}

	@Override
	public Iterator<T> iterator() 
	{
		return (Iterator<T>) new MyIter ( front );
	}
	class MyIter implements Iterator<T>
	{
		Node s;
		public MyIter ( Node front )
		{
			this.s = front;
		}
		@Override
		public boolean hasNext() 
		{
			return s!=null;
		}
		@Override
		public T next() 
		{
			T ret = s.val;
			s = s.next;
			return ret;
		}
	}

	@Override
	public int compareTo(T o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
