package LList;

public interface GList <T> extends Iterable<T>, Comparable<T>
{
	void  clear();
	void  init(T[] ini);
	T[] toArray();
	String toString();
	int   size();

	void  addStart(T val);
	void  addEnd(T val);
	void  addPos(int pos, T val);
	T   delStart();
	T   delEnd();
	T   delPos(int pos);

	T   min();
	T   max();
	int   indMin();
	int   indMax();

	void  sort();
	void  reverse();
	void  halfReverse();
	void set ( int pos, T val );
	T get ( int pos );
}
