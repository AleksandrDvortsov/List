package Tree;

public interface BsTreeInterface<T> extends Iterable<T>, Comparable<T>
{
	void clear();
	void init ( T[] ar );
	int size();
	void add ( T val );
	int nodes(); // количество узлов
	int leaves(); // крайняя точка
	int height(); // макс ур. дерева
	int widht(); // ширина дерева 
	String toString();
	T[] toArray();
	void del ( T val ); // уд олного эл.
	void reverse();
	// equals
}
