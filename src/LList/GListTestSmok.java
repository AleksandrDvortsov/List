package LList;

import static org.junit.Assert.*;

import org.junit.Test;

public class GListTestSmok
{

//	LList1 <Integer> lst = new LList1<Integer>();
//	GList<Integer> lst = new LList2<Integer>();
//	GList<Integer> lst = new AList0<Integer>();
//	GList<Integer> lst = new AList1<Integer>();
	GList<Integer> lst = new AList2<Integer>();

	@Test
	public void testSmoke_null() 
	{
		Integer[] ini = null;
		lst.init(ini);
		assertEquals(0, lst.size());
		Object[] exp = {};
		Object[] act = lst.toArray();
		assertArrayEquals(exp, act);
//		String ex = "";
//		String ac = lst.toString();
//		assertEquals(ex, ac);
//		lst.clear();
//		assertEquals(0, lst.size());
	}
	
	@Test
	public void testSmoke_0() 
	{
		Integer [] ini = null;
		lst.init(ini);
		assertEquals(0, lst.size());
		Object [] exp = {};
		Object [] act = lst.toArray();
		assertArrayEquals(exp, act);
		String ex = "";
		String ac = lst.toString();
		assertEquals(ex, ac);
		lst.clear();
		assertEquals(0, lst.size());
	}
	@Test
	public void testSmoke_1() 
	{
		Integer [] ini = {9};
		lst.init(ini);
		assertEquals(1, lst.size());
		Integer [] exp = {9};
		Integer [] act = lst.toArray();
		assertArrayEquals(exp, act);
		String ex = "9";
		String ac = lst.toString();
		assertEquals(ex, ac);
		lst.clear();
		assertEquals(0, lst.size());
	}
	@Test
	public void testSmoke_2() 
	{
		Integer [] ini = {9,15};
		lst.init(ini);
		assertEquals(2, lst.size());
		Integer [] exp = {9,15};
		Integer [] act = lst.toArray();
		assertArrayEquals(exp, act);
		String ex = "9, 15";
		String ac = lst.toString();
		assertEquals(ex, ac);
		lst.clear();
		assertEquals(0, lst.size());
	}
	@Test
	public void testSmoke_even() 
	{
		Integer [] ini = {10, 20, 30, 44, 55, 70};
		lst.init(ini);
		assertEquals(6, lst.size());
		Integer [] exp = {10, 20, 30, 44, 55, 70};
		Integer [] act = lst.toArray();
		assertArrayEquals(exp, act);
		String exp2 = "10, 20, 30, 44, 55, 70";
		String act2 = lst.toString();
		assertEquals(exp2, act2);
		lst.clear();
		assertEquals(0, lst.size());
	}
	@Test
	public void testSmoke_odd() 
	{
		Integer [] ini = {10, 20, 30, 44, 55, 70, 99};
		lst.init(ini);
		assertEquals(7, lst.size());
		Integer [] exp = {10, 20, 30, 44, 55, 70, 99};
		Integer [] act = lst.toArray();
		assertArrayEquals(exp, act);
		String exp2 = "10, 20, 30, 44, 55, 70, 99";
		String act2 = lst.toString();
		assertEquals(exp2, act2);
		lst.clear();
		assertEquals(0, lst.size());
	}

}
