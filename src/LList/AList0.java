package LList;

import java.lang.reflect.Array;
import java.util.Iterator;

public class AList0<T> implements GList<T>
{
	T[] ar = ( T[] ) ( new Comparable[0] );

	@Override
	public void clear() 
	{
		ar = (T[]) new Comparable[0];		
	}

	@Override
	public void init(T[] ini) 
	{
		if ( ini == null || ini.length == 0 )
		{
			ini = (T[]) new Comparable[0];
		}	
		ar = (T[]) new Comparable[ini.length];
		for ( int i = 0; i < ini.length; i++ )
		{
			ar[i] = ini[i];
		}
	}

	@Override
	public T[] toArray()
	{
		
		T[] ret = (T[]) Array.newInstance(Integer.class, ar.length);
		for (int i = 0; i < ar.length; i++)
		{
			ret[i] = ar[i];	
		}
		return ret;
	}
	
	@Override
	public String toString()
	{
		String str = "";
		for ( int i = 0; i < ar.length; i++ )
		{
			if ( i > 0 )
			{
				str = str + ", ";
			}
			str = str + ar[i];	
		}
		return str;
	}

	@Override
	public int size() 
	{
		return ar.length;
	}

	@Override
	public void addStart(T val) 
	{
		T[] res = (T[]) new Comparable[ar.length + 1];
		for ( int i = 1; i < res.length; i++ )
		{
			res[i] = ar[i-1];
		}
		res[0] = val;
		ar = res;
	}

	@Override
	public void addEnd(T val) 
	{
		T[] res = (T[]) new Comparable[ar.length + 1];
		for ( int i = 0; i < ar.length; i++ )
		{
			res[i] = ar[i];
		}
		res[ar.length] = val;
		ar = res;
	}

	@Override
	public void addPos(int pos, T val) 
	{
		if ( pos < 0 || pos > ar.length )
		{
			throw new IllegalArgumentException();
		}
		T [] tmp = (T[]) new Comparable[ar.length + 1];
		for ( int i = 0; i < ar.length; i++ )
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
		if(ar.length == 0)
		{
			throw new IllegalArgumentException();
		}
		T res = ar[0];
		T [] tmp = (T[]) new Comparable[ar.length - 1];
		
		for ( int i = 1; i < ar.length; i ++ )
		{
			tmp [i-1] = ar[i];
		}
		ar = tmp;
		return res;
	}

	@Override
	public T delEnd() 
	{
		if ( ar.length == 0 )
		{
			throw new IllegalArgumentException();
		}
		T res = ar[0];
		T [] tmp = (T[]) new Comparable[ar.length - 1];
		
		for ( int i = 0; i < tmp.length; i++ )
		{
			tmp[i] = ar[i];
		}
		ar = tmp;
		return res;
	}

	@Override
	public T delPos(int pos) 
	{
		if ( pos < 0 || pos > ar.length-1 || ar.length == 0 )
		{
			throw new IllegalArgumentException();
		}
		T res = ar[pos];
		T [] tmp = (T[]) new Comparable[ar.length - 1];
		
		for (int i = 0; i < tmp.length; i++ )
		{
			if ( i < pos )
			{
				tmp[i] = ar[i];
			}
			else 
			{
				tmp[i] = ar[i+1];
			}
		}
		ar = tmp;
		return res;
	}

	@Override
	public T min() 
	{
		if ( ar.length == 0 )
		{
			throw new IllegalArgumentException();
		}
		T min = ar[0];
		for ( int i = 0; i < ar.length; i++ )
		{
			if ( ((Comparable)ar.length).compareTo(min) < 0 )
			{
				min = ar[i];
			}
		}
		return min;
	}

	@Override
	public T max() 
	{
		if ( ar.length == 0 )
		{
			throw new IllegalArgumentException();
		}
		T max = ar[0];
		for ( int i = 1; i < ar.length; i++ )
		{
			if ( ((Comparable)ar.length).compareTo(max) > 0 )
			{
				max = ar[i];
			}
		}
		return max;
	}

	@Override
	public int indMin() 
	{
		if ( ar.length == 0 )
		{
			throw new IllegalArgumentException();
		}
		int minInd = 0;
		for ( int i = 0; i < ar.length; i++ )
		{
			if ( ((Comparable)ar.length).compareTo(minInd) > 0 )
			{
				minInd = i;
			}
		}
		return minInd;
	}

	@Override
	public int indMax() 
	{
		if ( ar.length == 0 )
		{
			throw new IllegalArgumentException();
		}
		int maxInd = 0;
		for ( int i = 0; i < ar.length; i++ )
		{
			if ( ((Comparable)ar.length).compareTo(maxInd) < 0 )
			{
				maxInd = i;
			}
		}
		return maxInd;
	}

	@Override
	public void sort() 
	{
		for (int i = 1; i < ar.length; i++) 
		{
			for (int j = i; j > 0 && ((Comparable)ar[j-1]).compareTo(ar[j]) > 0; j--)
			{
				T tmp = ar[ j ];
				ar[ j ] = ar[ j - 1 ];
				ar[ j - 1 ] = tmp;					
			}
		}
	}

	@Override
	public void reverse() 
	{
		for ( int i = 0; i < ar.length/2; i++ )
		{
			T tmp = ar[i];
			ar[i] = ar [ar.length - 1 - i];
			ar [ar.length - 1 - i] = tmp;
		}
	}

	@Override
	public void halfReverse() 
	{
		int a = ar.length%2;
		for (int i = 0; i < ar.length/2; i++)
		{
			T temp = ar[i];
			ar[i] = ar[ar.length/2 + a + i];
			ar[ar.length/2 + a + i] = temp;
		}
	}

	@Override
	public void set(int pos, T val) 
	{
		if ( pos < 0 || pos > ar.length || size() == 0 )
		{
			throw new IllegalArgumentException();
		}
		ar[pos] = val;
	}

	@Override
	public T get(int pos) 
	{
		if ( pos < 0 || pos > ar.length || size() == 0 )
		{
			throw new IllegalArgumentException();
		}
		return ar[pos];
	}

	@Override
	public Iterator<T> iterator() 
	{
		return (Iterator<T>) new MyIter( ar );
	}
	
	class MyIter implements Iterator<Integer>
	{
		private T[] ar = null;
		private int i;
		private int size;
		
		public MyIter( T[] ar ) 
		{
			this.ar = ar;		
			i = 0;
			size = ar.length;
		}
		
		@Override
		public boolean hasNext() 
		{
			return i < size;
		}

		@Override
		public Integer next() 
		{
			return (Integer) ar[i++];
		}
	}

	@Override
	public int compareTo(T o) 
	{
		return 0;
	}
}
