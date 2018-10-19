package LList;

import static org.junit.Assert.*;

import org.junit.Test;

public class EListTest
{

	LList1<Integer> lst = new LList1<Integer>();
//	LList2<Integer> lst = new LList2<Integer>();
//	AList0<Integer> lst = new AList0<Integer>();
//	AList1<Integer> lst = new AList1<Integer>();
//	AList2<Integer> lst = new AList2<Integer>();
	
	//===========================================================
	// AddEnd		
	//===========================================================
		@Test 
		public void testAddEnd_0()
		{
			Integer[] ini = {};
			lst.init(ini);
			lst.addEnd(7);
			Integer [] exp = {7};
			Integer [] act = lst.toArray();
			assertArrayEquals(exp, act);
		}
		@Test
		public void testAddEnd_1()
		{
			Integer [] ini = {1};
			lst.init(ini);
			lst.addEnd(7);
			Integer [] exp = {1,7};
			Integer [] act = lst.toArray();
			assertArrayEquals(exp, act);
		}
		@Test
		public void testAddEnd_2()
		{		
			Integer [] ini = {1,2};
			lst.init(ini);
			lst.addEnd(7);
			Integer [] exp = {1,2,7};
			Integer [] act = lst.toArray();
			assertArrayEquals(exp, act);
		}
		@Test
		public void testAddEnd_many()
		{
			Integer [] ini = {1,2,3,4,5,6};
			lst.init(ini);
			lst.addEnd(7);
			Integer [] exp = {1,2,3,4,5,6,7};
			Integer [] act = lst.toArray();
			assertArrayEquals(exp, act);
		}

		//===========================================================
		// AddPos		
		//===========================================================

		@Test (expected = IllegalArgumentException.class)
		public void testAddPos_0()
		{
			Integer [] ini = {};
			lst.init(ini);
			lst.addPos(-1,0);
		}
		@Test (expected = IllegalArgumentException.class)
		public void testAddPos_more_lenght()
		{
			Integer [] ini = {};
			lst.init(ini);
			lst.addPos(1,0);
		}
		@Test
		public void testAddPos_1()
		{
			Integer [] ini = {1};
			lst.init(ini);
			lst.addPos(1,7);
			Integer [] exp = {1,7};
			Integer [] act = lst.toArray();
			assertArrayEquals(exp, act);
		}
		@Test
		public void testAddPos_2()
		{
			Integer [] ini = {1,2};
			lst.init(ini);
			lst.addPos(2,7);
			Integer [] exp = {1,2,7};
			Integer [] act = lst.toArray();
			assertArrayEquals(exp, act);
		}
		@Test
		public void testAddPos_many()
		{
			Integer [] ini = {1,2,3,4,5,6};
			lst.init(ini);
			lst.addPos(2,7);
			Integer [] exp = {1,2,7,3,4,5,6};
			Integer [] act = lst.toArray();
			assertArrayEquals(exp, act);
		}
		@Test
		public void testAddPos_many_2()
		{
			Integer [] ini = {1,2,3,4,5,6};
			lst.init(ini);
			lst.addPos(5,7);
			Integer [] exp = {1,2,3,4,5,7,6};
			Integer [] act = lst.toArray();
			assertArrayEquals(exp, act);
		}
		@Test
		public void testAddPos_many_3()
		{
			Integer [] ini = {1,2,3,4,5,6};
			lst.init(ini);
			lst.addPos(0,7);
			Integer [] exp = {7,1,2,3,4,5,6};
			Integer [] act = lst.toArray();
			assertArrayEquals(exp, act);
		}
		//===========================================================
		// AddStart	
		//===========================================================
		@Test 
		public void testAddStart_0()
		{
			Integer [] ini = {};
			lst.init(ini);
			lst.addStart(7);
			Integer [] exp = {7};
			Integer [] act = lst.toArray();
			assertArrayEquals(exp, act);
			
		}
		@Test
		public void testAddStart_1()
		{
			Integer [] ini = {1};
			lst.init(ini);
			lst.addStart(7);
			Integer [] exp = {7,1};
			Integer [] act = lst.toArray();
			assertArrayEquals(exp, act);
		}
		@Test
		public void testAddStart_2()
		{
			Integer [] ini = {1,2};
			lst.init(ini);
			lst.addStart(7);
			Integer [] exp = {7,1,2};
			Integer [] act = lst.toArray();
			assertArrayEquals(exp, act);
		}

		@Test
		public void testAddStart_many()
		{
			Integer [] ini = {1,2,3,4,5,6};
			lst.init(ini);
			lst.addStart(7);
			Integer [] exp = {7,1,2,3,4,5,6};
			Integer [] act = lst.toArray();
			assertArrayEquals(exp, act);
		}
		//===========================================================
		// delEnd
		//===========================================================
		@Test (expected = IllegalArgumentException.class)
		public void test_delEnd_0()
		{
			Integer [] ini = {};
			lst.init(ini);
			lst.delEnd();
			
		}
		@Test
		public void test_delEnd_1()
		{
			Integer [] ini = {1};
			lst.init(ini);
			lst.delEnd();
			Integer [] exp = null;
			Integer [] act = lst.toArray();
			assertArrayEquals(exp, act);
		}
		@Test
		public void test_delEnd_2()
		{
			Integer [] ini = {1,2};
			lst.init(ini);
			lst.delEnd();
			Integer [] exp = {1};
			Integer [] act = lst.toArray();
			assertArrayEquals(exp, act);
		}
		@Test
		public void test_delEnd_many()
		{
			Integer [] ini = {9,6,7,8,10,15};
			lst.init(ini);
			lst.delEnd();
			Integer [] exp = {9,6,7,8,10};
			Integer [] act = lst.toArray();
			assertArrayEquals(exp, act);
		}
		//===========================================================
		// delPos
		//===========================================================

		@Test (expected = IllegalArgumentException.class)
		public void test_delPos_0()
		{
			Integer [] ini = {};
			lst.init(ini);
			lst.delPos(0);
		}
		@Test
		public void test_delPos_1()
		{
			Integer [] ini = {1};
			lst.init(ini);
			lst.delPos(0);
			Integer [] exp = null;
			Integer [] act = lst.toArray();
			assertArrayEquals(exp, act);
		}
		@Test
		public void test_delPos_2()
		{
			
			Integer [] ini = {1,2};
			lst.init(ini);
			lst.delPos(0);
			Integer [] exp = {2};
			Integer [] act = lst.toArray();
			assertArrayEquals(exp, act);
		}
		@Test
		public void test_delPos_many()
		{
			Integer [] ini = {2,4,7,8,5};
			lst.init(ini);
			lst.delPos(2);
			Integer [] exp = {2,4,8,5};
			Integer [] act = lst.toArray();
			assertArrayEquals(exp, act);
		}
		@Test
		public void test_delPos_many_0()
		{
			Integer [] ini = {2,4,7,8,5};
			lst.init(ini);
			lst.delPos(0);
			Integer [] exp = {4,7,8,5};
			Integer [] act = lst.toArray();
			assertArrayEquals(exp, act);
		}
		@Test
		public void test_delPos_many_4()
		{
			Integer [] ini = {2,4,7,8,5};
			lst.init(ini);
			lst.delPos(4);
			Integer [] exp = {2,4,7,8};
			Integer [] act = lst.toArray();
			assertArrayEquals(exp, act);
		}
		
		//===========================================================
		// delStart
		//===========================================================
		
		@Test (expected = IllegalArgumentException.class)
		public void test_delStart_0()
		{
			Integer [] ini = {};
			lst.init(ini);
			lst.delStart();
		}
		@Test
		public void test_delStart_1()
		{
			Integer [] ini = {1};
			lst.init(ini);
			lst.delStart();
			Integer [] exp = null;
			Integer [] act = lst.toArray();
			assertArrayEquals(exp, act);
		}
		@Test
		public void test_delStart_2()
		{
			Integer [] ini = {1,2};
			lst.init(ini);
			lst.delStart();
			Integer [] exp = {2};
			Integer [] act = lst.toArray();
			assertArrayEquals(exp, act);
			
		}
		@Test
		public void test_delStart_many()
		{
			Integer [] ini = {7,8,10,23,54};
			lst.init(ini);
			lst.delStart();
			Integer [] exp = {8,10,23,54};
			Integer [] act = lst.toArray();
			assertArrayEquals(exp, act);
		}

		//===========================================================
		// get
		//===========================================================

		@Test ( expected = IllegalArgumentException.class )
		public void test_get_0()
		{
			Integer [] ini = {};
			lst.init(ini);
			lst.get(0);
		}
		@Test ( expected = IllegalArgumentException.class )
		public void test_get_less_0()
		{
			
			Integer [] ini = {3,4,2,5,1};
			lst.init(ini);
			lst.get(-1);
		}
		@Test ( expected = IllegalArgumentException.class )
		public void test_get_more_index()
		{
			
			Integer [] ini = {3,4,2,5,1};
			lst.init(ini);
			lst.get(6);
		}
		@Test
		public void test_get_1()
		{
			Integer [] ini = {3};
			lst.init(ini);
			int exp = 3;
			int act = lst.get(0);
			assertEquals(exp, act);
		}
		@Test
		public void test_get_2()
		{
			Integer [] ini = {3,4};
			lst.init(ini);
			int exp = 4;
			int act = lst.get(1);
			assertEquals(exp, act);
		}
		@Test
		public void test_get_many()
		{
			Integer [] ini = {3,4,6,5,1};
			lst.init(ini);
			int exp = 6;
			int act = lst.get(2);
			assertEquals(exp, act);
		}

		//===========================================================
		// halfReverse
		//=========================================================== 

		@Test 
		public void test_halfReverse_0()
		{
			Integer [] ini = {};
			lst.init(ini);
			lst.halfReverse();
		}
		@Test
		public void test_halfReverse_1()
		{
			Integer [] ini = {9};
			lst.init(ini);
			lst.halfReverse();
			Integer [] exp = {9};
			Integer [] act = lst.toArray();
			assertArrayEquals(exp, act);
		}
		@Test
		public void test_halfReverse_2()
		{
			Integer [] ini = {9,8};
			lst.init(ini);
			lst.halfReverse();
			Integer [] exp = {8,9};
			Integer [] act = lst.toArray();
			assertArrayEquals(exp, act);
		}
		@Test
		public void test_halfReverse_many_odd()
		{
			Integer [] ini = {9,8,7,6,4};
			lst.init(ini);
			lst.halfReverse();
			Integer [] exp = {6,4,7,9,8};
			Integer [] act = lst.toArray();
			assertArrayEquals(exp, act);
		}
		@Test
		public void test_halfReverse_many_even()
		{
			Integer [] ini = {9,8,7,6,4,11};
			lst.init(ini);
			lst.halfReverse();
			Integer [] exp = {6,4,11,9,8,7};
			Integer [] act = lst.toArray();
			assertArrayEquals(exp, act);
		}

	//===========================================================
	// min
	//===========================================================

	@Test ( expected = IllegalArgumentException.class )
	public void test_min_0()
	{
		Integer [] ini = {};
		lst.init(ini);
		lst.min();
	}
	@Test
	public void test_min_1()
	{
		Integer [] ini = {9};
		lst.init(ini);
		lst.min();
		int exp = 9;
		int act = lst.min();
		assertEquals(exp, act);
	}
	@Test
	public void test_min_2()
	{	
		Integer [] ini = {9,8};
		lst.init(ini);
		lst.min();
		Integer exp = 8;
		Integer act = lst.min();
		assertEquals(exp, act);
	}
	@Test
	public void test_min_many()
	{
		Integer [] ini = {9,8,7,-6,11};
		lst.init(ini);
		lst.min();
		Integer exp = -6;
		Integer act = lst.min();
		assertEquals(exp, act);
	}
		//===========================================================
		// max
		//===========================================================

		@Test (expected = IllegalArgumentException.class)
		public void test_max_0()
		{
			Integer [] ini = {};
			lst.init(ini);
			lst.max();
		}
		@Test
		public void test_max_1()
		{	
			Integer [] ini = {9};
			lst.init(ini);
			lst.max();
			Integer exp = 9;
			Integer act = lst.max();
			assertEquals(exp, act);
		}
		@Test
		public void test_max_2()
		{
			Integer [] ini = {9,8};
			lst.init(ini);
			lst.max();
			Integer exp = 9;
			Integer act = lst.max();
			assertEquals(exp, act);
		}
		@Test
		public void test_max_many()
		{
			Integer [] ini = {9,8,7,6,4};
			lst.init(ini);
			lst.max();
			Integer exp = 9;
			Integer act = lst.max();
			assertEquals(exp, act);
		}
	//===========================================================
	// minInd
	//===========================================================

	@Test ( expected = IllegalArgumentException.class )
	public void test_minInd_0()
	{
		Integer [] ini = {};
		lst.init(ini);
		lst.indMin();
	}
	@Test
	public void test_minInd_1()
	{
		Integer [] ini = {9};
		lst.init(ini);
		lst.indMin();
		int act = lst.indMin();
		assertEquals(0, act);
	}
	@Test
	public void test_minInd_2()
	{
		
		Integer [] ini = {9,8};
		lst.init(ini);
		lst.indMin();
		int exp = 1;
		int act = lst.indMin();
		assertEquals(exp, act);
	}
	@Test
	public void test_minInd_many()
	{
		
		Integer [] ini = {9,8,7,6,3};
		lst.init(ini);
		lst.indMin();
		int exp = 4;
		int act = lst.indMin();
		assertEquals(exp, act);
	}	
		//===========================================================
		// maxInd
		//===========================================================

		@Test ( expected = IllegalArgumentException.class )
		public void test_maxInd_0()
		{
			Integer [] ini = {};
			lst.init(ini);
			lst.indMax();
		}
		@Test
		public void test_maxInd_1()
		{
			Integer [] ini = {9};
			lst.init(ini);
			lst.indMax();
			int act = lst.indMax();
			assertEquals(0, act);
		}
		@Test
		public void test_maxInd_2()
		{
			Integer [] ini = {9,8};
			lst.init(ini);
			lst.indMax();
			int act = lst.indMax();
			assertEquals(0, act);
		}
		@Test
		public void test_maxInd_many()
		{
			Integer [] ini = {9,8,7,6,4};
			lst.init(ini);
			lst.indMax();
			int act = lst.indMax();
			assertEquals(0, act);
		}

		//===========================================================
		// reversee
		//=========================================================== 

		@Test 
		public void test_reverse_0()
		{
			Integer [] ini = {};
			lst.init(ini);
			lst.reverse();
		}
		@Test
		public void test_reverse_1()
		{
			Integer [] ini = {9};
			lst.init(ini);
			lst.reverse();
			Integer [] exp = {9};
			Integer [] act = lst.toArray();
			assertArrayEquals(exp, act);
		}
		@Test
		public void test_reverse_2()
		{
			Integer [] ini = {6,4};
			lst.init(ini);
			lst.reverse();
			Integer [] exp = {4,6};
			Integer [] act = lst.toArray();
			assertArrayEquals(exp, act);
		}
		@Test
		public void test_reverse_many_odd()
		{
			Integer [] ini = {9,8,7,6,4};
			lst.init(ini);
			lst.reverse();
			Integer [] exp = {4,6,7,8,9};
			Integer [] act = lst.toArray();
			assertArrayEquals(exp, act);
		}
		@Test
		public void test_reverse_many_even()
		{
			Integer [] ini = {9,8,7,6,4};
			lst.init(ini);
			lst.reverse();
			Integer [] exp = {4,6,7,8,9};
			Integer [] act = lst.toArray();
			assertArrayEquals(exp, act);
		}

		//===========================================================
		// set
		//===========================================================

		@Test ( expected = IllegalArgumentException.class )
		public void test_set_0()
		{
			Integer [] ini = {};
			lst.init(ini);
			lst.set(0, 10);
		}
		@Test ( expected = IllegalArgumentException.class )
		public void test_set_0_less()
		{
			Integer [] ini = {1,2,3,4};
			lst.init(ini);
			lst.set(-1, 10);
		}
		@Test ( expected = IllegalArgumentException.class )
		public void test_set_0_more_index()
		{
			Integer [] ini = {1,2,3,4};
			lst.init(ini);
			lst.set(5, 10);
		}
		@Test
		public void test_set_1()
		{
			Integer [] ini = {3};
			lst.init(ini);
			lst.set(0, 10);
			Integer [] exp = {10};
			Integer [] act = lst.toArray();
			assertArrayEquals(exp, act);
		}
		@Test
		public void test_set_2()
		{
			Integer [] ini = {3,4};
			lst.init(ini);
			lst.set(1, 10);
			Integer [] exp = {3,10};
			Integer [] act = lst.toArray();
			assertArrayEquals(exp, act);
		}
		@Test
		public void test_set_many_even()
		{
			Integer [] ini = {3,4,2,5,1};
			lst.init(ini);
			lst.set(2, 10);
			Integer [] exp = {3,4,10,5,1};
			Integer [] act = lst.toArray();
			assertArrayEquals(exp, act);
		}
		@Test
		public void test_set_many_odd()
		{
			Integer [] ini = {3,4,2,5,1,7};
			lst.init(ini);
			lst.set(2, 10);
			Integer [] exp = {3,4,10,5,1,7};
			Integer [] act = lst.toArray();
			assertArrayEquals(exp, act);
		}

		//===========================================================
		// sort
		//===========================================================

		@Test 
		public void test_sort_0()
		{
			Integer [] ini = {};
			lst.init(ini);
			lst.sort();
		}
		@Test
		public void test_sort_1()
		{
			
			Integer [] ini = {4};
			lst.init(ini);
			lst.sort();
			Integer [] exp = {4};
			Integer [] act = lst.toArray();
			assertArrayEquals(exp, act);
		}
		@Test
		public void test_sort_2()
		{
			Integer [] ini = {4,3};
			lst.init(ini);
			lst.sort();
			Integer [] exp = {3,4};
			Integer [] act = lst.toArray();
			assertArrayEquals(exp, act);
		}
		@Test
		public void test_sort_many()
		{
			Integer [] ini = {3,4,2,5,1};
			lst.init(ini);
			lst.sort();
			Integer [] exp = {1,2,3,4,5};
			Integer [] act = lst.toArray();
			assertArrayEquals(exp, act);
		}
		
		///////////////////////////////////////////////////////////////////////////////////////////////////
		// Iter
		//////////////////////////////////////////////////////////////////////////////////////////////////
		
		@Test
		public void test_iter()
		{
			Integer [] ini = {3,4,2,5,1};
			lst.init(ini);
			lst.iterator();
			Integer [] exp = {3,4,2,5,1};
			Integer [] act = lst.toArray();
			assertArrayEquals(exp, act);
		}
		
}