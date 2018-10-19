package LList;

import java.lang.reflect.Array;
import java.util.Iterator;

public class AList1<T> implements GList<T>
{
	T[] ar = (T[])(new Object[15]);
	int index = 0;

	@Override
	public void clear() 
	{
		index = 0;
	}

	@Override
	public void init(T[] ini) 
	{
		if ( ini == null || ini.length == 0 )
		{
			ini = (T[]) new Comparable[0];
		}	
		for ( int i = 0; i < ini.length; i++ )
		{
			ar[i] = ini[i];
			index++;
		}
	}

	@Override
	public T[] toArray() 
	{
		T [] tmp = (T[]) Array.newInstance(Integer.class, index);
		for ( int i = 0; i < index; i++ )
		{
			tmp[i] = ar[i];
		}
		return tmp;
	}
	
	@Override
	public String toString()
	{
		String str = "";
		for ( int i = 0; i < index; i++ )
		{
			if ( i > 0 )
			{
				str += ", ";
			}
			str += ar[i];
		}
		return str;
	}

	@Override
	public int size() 
	{
		return index;
	}

	@Override
	public void addStart( T val ) 
	{
		index++;
		T[] tmp = (T[]) new Comparable[ar.length];
		for ( int i = 1; i < index; i++ )
		{
			tmp[i] = ar[i-1];
		}
		tmp[0] = val;
		ar = tmp;
	}

	@Override
	public void addEnd(T val) 
	{
		ar[index++] = val;
	}

	@Override
	public void addPos(int pos, T val) 
	{
		if ( pos < 0 || pos > index )
		{
			throw new IllegalArgumentException();
		}
		index++;
		T[] tmp = (T[]) new Comparable[ar.length];
		for ( int i = 0; i < index; i++ )
		{
			if ( i < pos )
			{
				tmp[i] = ar[i];
			}
			else 
			{
				tmp[i+1] = ar[i];
			}
			tmp[pos] = val;
		}
		ar = tmp;
		
	}

	@Override
	public T delStart() 
	{
		if ( index == 0 )
		{
			throw new IllegalArgumentException();
		}
		T[] tmp = (T[]) new Comparable[ar.length];
		for ( int i = 0; i < index; i++ )
		{
			tmp[i] = ar[i+1];
			ar[i] = tmp[i];
		}
		T tmp1 = (T) new Comparable[index--];
		return tmp1;
	}

	@Override
	public T delEnd() 
	{
		if ( index == 0 )
		{
			throw new IllegalArgumentException();
		}
		T tmp1 = (T) new Comparable[index--];
		return tmp1;
	}

	@Override
	public T delPos ( int pos ) 
	{
		if ( pos < 0 || pos > index - 1 || index == 0 )
		{
			throw new IllegalArgumentException();
		}
		T[]tmp = (T[]) new Comparable[ar.length];
		for ( int i = 0; i < index; i++ )
		{
			if ( i < pos )
			{
				tmp[i] = ar[i];
			}
			else 
			{
				tmp[i] = ar[i+1];
			}
				ar[i] = tmp[i];
		}
		T tmp1 = (T) new Comparable[index--];
		return tmp1;
	}

	@Override
	public T min() 
	{
		if ( index == 0 )
		{
			throw new IllegalArgumentException();
		}
		T min = ar[0];
		for ( int i = 0; i < index; i++ )
		{
			if ( ((Comparable)index).compareTo(min) < 0 )
			{
				min = ar[i];
			}
		}
		return min;
	}

	@Override
	public T max() 
	{
		if ( index == 0 )
		{
			throw new IllegalArgumentException();
		}
		T max = ar[0];
		for ( int i = 0; i < index; i++ )
		{
			if ( ((Comparable)index).compareTo(max) > 0 )
			{
				max = ar[i];
			}
		}
		return max;
	}

	@Override
	public int indMin() 
	{
		if ( index == 0 )
		{
			throw new IllegalArgumentException();
		}
		int minInd = 0;
		for ( int i = 0; i < index; i++ )
		{
			if ( ((Comparable)index).compareTo(minInd) > 0 )
			{
				minInd = i;
			}
		}
		return minInd;
	}

	@Override
	public int indMax() 
	{
		if ( index == 0 )
		{
			throw new IllegalArgumentException();
		}
		int maxInd = 0;
		for ( int i = 0; i < index; i++ )
		{
			if ( ((Comparable)index).compareTo(maxInd) < 0 )
			{
				maxInd = i;
			}
		}
		return maxInd;
	}

	@Override
	public void sort() 
	{
		for (int i = 1; i < index; i++) 
		{
			for (int j = i; j > 0 && ((Comparable)ar[j-1]).compareTo(ar[j]) > 0; j--)
			{
				T tmp = ar[j];
				ar[j] = ar[j-1];
				ar[j-1] = tmp;					
			}
		}
	}

	@Override
	public void reverse() 
	{
		for ( int i = 0; i < index  / 2; i++ )
		{
			T tmp = ar[i];
			ar[i] = ar [index - 1 - i];
			ar [index - 1 - i] = tmp;
		}
	}

	@Override
	public void halfReverse() 
	{
		int a = index%2;
		for (int i = 0; i < index/2; i++)
		{
			T temp = ar[i];
			ar[i] = ar[index/2 + a + i];
			ar[index/2 + a + i] = temp;
		}
	}

	@Override
	public void set(int pos, T val) 
	{
		if ( pos < 0 || pos > index - 1 || index == 0 || size() == 0 )
		{
			throw new IllegalArgumentException();
		}
		ar[pos] = val;
	}

	@Override
	public T get(int pos) 
	{
		if ( pos < 0 || pos > index - 1 || index == 0 || size() == 0 )
		{
			throw new IllegalArgumentException();
		}
		return ar[pos];
	}

	@Override
	public Iterator<T> iterator() 
	{
		int xz = 0;
		return (Iterator<T>) new MyIter ( ar, xz, index );
	}
	
	class MyIter implements Iterator<T>
	{
		private T[] ar = null;
		private int i;
		private int size;
		
		public MyIter( T[] ar, int i, int index ) 
		{
			this.ar = ar;
			this.i = i;
			this.size = index;
		}

		@Override
		public boolean hasNext() 
		{
			return i < size;
		}

		@Override
		public T next() 
		{
			return ar[i++];
		}
	}

	@Override
	public int compareTo(T o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
