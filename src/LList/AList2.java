package LList;

import java.lang.reflect.Array;
import java.util.Iterator;

public class AList2<T> implements GList<T>
{
	T[] ar = (T[])(new Object[30]);
	int start = ar.length/2;
	int end = ar.length/2;

	@Override
	public void clear() 
	{
		start = ar.length/2;
		end = ar.length/2;
	}

	@Override
	public void init(T[] ini) 
	{
		if ( ini == null || ini.length == 0)
		{
			ini = (T[]) new Comparable[0];
		} 
		start = start - ini.length/2;
		end = start + ini.length;
		for ( int i = 0; i < ini.length; i++ )
		{	
			ar[start+i] = ini[i];
		}
	}

	@Override
	public T[] toArray() 
	{
		T[] tmp = (T[]) Array.newInstance(Integer.class, size());
		for ( int i = 0; i < tmp.length; i++ )
		{
			tmp[i] = ar[start+i];
		}
		return tmp;
	}
	
	@Override
	public String toString()
	{
		String str = "";
		for ( int i = start; i < end; i++ )
		{
			if ( i > start )
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
		return end - start;
	}

	@Override
	public void addStart(T val) 
	{
		ar[--start] = val;
	}

	@Override
	public void addEnd(T val) 
	{
		ar[end++] = val;
	}

	@Override
	public void addPos(int pos, T val) 
	{
		if ( pos < 0 || pos > size() )
		{
			throw new IllegalArgumentException();
		}
		end++;
		for ( int i = end; i > start + pos; i-- )
		{
			if ( i < pos )
			{
				ar[i] = ar[i];
			}
			else 
			{
				ar[i] = ar[i-1];
			}
		}
		ar[start + pos] = val;
	}

	@Override
	public T delStart() 
	{
		if( size() == 0)
		{
			throw new IllegalArgumentException();
		}
		T tmp1 = (T) new Comparable[start++];
		return tmp1;
	}

	@Override
	public T delEnd() 
	{
		if( size() == 0)
		{
			throw new IllegalArgumentException();
		}
		T tmp1 = (T) new Comparable[end--];
		return tmp1;
	}

	@Override
	public T delPos(int pos) 
	{
		if ( pos < 0 || pos > size() - 1 || size() == 0 )
		{
			throw new IllegalArgumentException();
		}
		for ( int i = 0; i < size(); i++ )
		{
			if ( i < pos )
			{
				ar[start+i] = ar[start+i];
			}
			else 
			{
				ar[start+i] = ar[start+i+1];
			}
		}
		T tmp1 = (T) new Comparable[end--];
		return tmp1;
	}

	@Override
	public T min() 
	{
		if ( size() == 0 )
		{
			throw new IllegalArgumentException();
		}
		T min = ar[start];
		for ( int i = 0; i < size(); i++ )
		{
			if ( ((Comparable)(ar[start+i])).compareTo(min) < 0 )
			{
				min = ar[start+i];
			}
		}
		return min;
	}

	@Override
	public T max() 
	{
		if ( size() == 0 )
		{
			throw new IllegalArgumentException();
		}
		T max = ar[start];
		for ( int i = 0; i < size(); i++ )
		{	
			if ( ((Comparable)(ar[start+i])).compareTo(max) > 0 )
			{
				max = ar[start+i];
			}
		}
		return max;
	}

	@Override
	public int indMin() 
	{
		if ( size() == 0 )
		{
			throw new IllegalArgumentException();
		}
		int indMin = 0;
		for ( int i = 0; i < size(); i++ )
		{
			if ( ((Comparable)(ar[start+i])).compareTo(ar[start]) < 0 )
			{
				indMin = i;
			}
		}
		return indMin;
	}

	@Override
	public int indMax() 
	{
		if ( size() == 0 )
		{
			throw new IllegalArgumentException();
		}
		int indMin = 0;
		for ( int i = 0; i < size(); i++ )
		{
			if ( ((Comparable)(ar[start+i])).compareTo(ar[start]) > 0 )
			{
				indMin = i;
			}
		}
		return indMin;
	}

	@Override
	public void sort() 
	{
		for ( int i = 1; i < size(); i++ )
		{
			for ( int j = i; j > 0 && ((Comparable)(ar[start+j-1])).compareTo(ar[start + j]) > 0; j--)
			{
				T tmp = ar[start+j];
				ar[start+j] = ar[start+j-1];
				ar[start+j-1] = tmp;
			}
		}
	}

	@Override
	public void reverse() 
	{
		for ( int i = 0; i < size() / 2; i++ )
		{
			T tmp = ar[start+i];
			ar[start+i] = ar [end - 1 - i];
			ar [end - 1 - i] = tmp;
		}
	}

	@Override
	public void halfReverse() 
	{
		int a = size()%2;
		for ( int i = 0; i < size() / 2; i++ )
		{
			T tmp = ar[start+i];
			ar[start+i] = ar[ size() / 2 + a + ( start + i ) ];
			ar[ size() / 2 + a + ( start+i ) ] = tmp;
		}
	}

	@Override
	public void set(int pos, T val) 
	{
		if ( pos < 0 || pos > size() - 1 || size() == 0 )
		{
			throw new IllegalArgumentException();
		}
		ar[start + pos] = val;
	}

	@Override
	public T get(int pos) 
	{
		if ( pos < 0 || pos > size() - 1 || size() == 0 )
		{
			throw new IllegalArgumentException();
		}
		return ar[start + pos];
	}

	@Override
	public Iterator<T> iterator() 
	{
		return (Iterator<T>) new MyIter ( ar, start, end);
	}
	class MyIter implements Iterator<T>
	{
		private T[] ar = null;
		private int i;
		private int size;
		
		public MyIter( T[] ar, int i, int size )
		{
			this.ar = ar;
			this.i = i;
			this.size = size;
		}

		@Override
		public boolean hasNext() 
		{
			return i < size;
		}

		@Override
		public T next() 
		{
			return  ar[ i++ ];
		}
	}
	@Override
	public int compareTo(T o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
