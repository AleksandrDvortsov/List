package LList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterizedGlistTestAll 
{
	private GList<Integer> gl = null;
	
	@Parameters
	public static Collection<Object[]> xz()
	{
		return Arrays.asList(new Object[][]
				{
					{new AList0<Integer>()},
					{new AList1<Integer>()},
					{new AList2<Integer>()},
					{new LList1<Integer>()},
					{new LList2<Integer>()}
				});
	}
	
	public ParameterizedGlistTestAll ( GList<Integer> parametr )
	{
		gl = parametr;
	}
	
		//===========================================================
		// AddEnd		
		//===========================================================
			@Test 
			public void testAddEnd_0()
			{
				Integer[] ini = {};
				gl.init(ini);
				gl.addEnd(7);
				Object [] exp = {7};
				Object [] act = gl.toArray();
				assertArrayEquals(exp, act);
				gl.clear();
			}
			@Test
			public void testAddEnd_1()
			{
				Integer [] ini = {1};
				gl.init(ini);
				gl.addEnd(7);
				Object [] exp = {1,7};
				Object [] act = gl.toArray();
				assertArrayEquals(exp, act);
				gl.clear();
			}
			@Test
			public void testAddEnd_2()
			{		
				Integer [] ini = {1,2};
				gl.init(ini);
				gl.addEnd(7);
				Object [] exp = {1,2,7};
				Object [] act = gl.toArray();
				assertArrayEquals(exp, act);
				gl.clear();
			}
			@Test
			public void testAddEnd_many()
			{
				gl.clear();
				Integer [] ini = {10,20,77,11,34};
				gl.init(ini);
				gl.addEnd(99);
				Object [] exp = {10,20,77,11,34,99};
				Object [] act = gl.toArray();
				assertArrayEquals(exp, act);
				gl.clear();
			}
			
			//===========================================================
			// AddPos		
			//===========================================================

			@Test (expected = IllegalArgumentException.class)
			public void testAddPos_0()
			{
				Integer [] ini = {};
				gl.init(ini);
				gl.addPos(-1,0);
				gl.clear();
			}
			@Test (expected = IllegalArgumentException.class)
			public void testAddPos_more_lenght()
			{
				Integer [] ini = {};
				gl.init(ini);
				gl.addPos(1,0);
				gl.clear();
			}
			@Test
			public void testAddPos_1()
			{
				Integer [] ini = {1};
				gl.init(ini);
				gl.addPos(1,7);
				Integer [] exp = {1,7};
				Integer [] act = gl.toArray();
				assertArrayEquals(exp, act);
				gl.clear();
			}
			@Test
			public void testAddPos_2()
			{
				Integer [] ini = {1,2};
				gl.init(ini);
				gl.addPos(2,7);
				Integer [] exp = {1,2,7};
				Integer [] act = gl.toArray();
				assertArrayEquals(exp, act);
				gl.clear();
			}
			@Test
			public void testAddPos_many()
			{
				Integer [] ini = {1,2,3,4,5,6};
				gl.init(ini);
				gl.addPos(2,7);
				Integer [] exp = {1,2,7,3,4,5,6};
				Integer [] act = gl.toArray();
				assertArrayEquals(exp, act);
				gl.clear();
			}
			@Test
			public void testAddPos_many_2()
			{
				Integer [] ini = {1,2,3,4,5,6};
				gl.init(ini);
				gl.addPos(5,7);
				Object [] exp = {1,2,3,4,5,7,6};
				Object [] act = gl.toArray();
				assertArrayEquals(exp, act);
				gl.clear();
			}
			@Test
			public void testAddPos_many_3()
			{
				Integer [] ini = {1,2,3,4,5,6};
				gl.init(ini);
				gl.addPos(0,7);
				Integer [] exp = {7,1,2,3,4,5,6};
				Integer [] act = gl.toArray();
				assertArrayEquals(exp, act);
				gl.clear();
			}
			
			//===========================================================
			// AddStart	
			//===========================================================
			@Test 
			public void testAddStart_0()
			{
				Integer [] ini = {};
				gl.init(ini);
				gl.addStart(7);
				Integer [] exp = {7};
				Integer [] act = gl.toArray();
				assertArrayEquals(exp, act);
				gl.clear();
			}
			@Test
			public void testAddStart_1()
			{
				Integer [] ini = {1};
				gl.init(ini);
				gl.addStart(7);
				Integer [] exp = {7,1};
				Integer [] act = gl.toArray();
				assertArrayEquals(exp, act);
				gl.clear();
			}
			@Test
			public void testAddStart_2()
			{
				Integer [] ini = {1,2};
				gl.init(ini);
				gl.addStart(7);
				Integer [] exp = {7,1,2};
				Integer [] act = gl.toArray();
				assertArrayEquals(exp, act);
				gl.clear();
			}

			@Test
			public void testAddStart_many()
			{
				Integer [] ini = {1,2,3,4,5,6};
				gl.init(ini);
				gl.addStart(7);
				Integer [] exp = {7,1,2,3,4,5,6};
				Integer [] act = gl.toArray();
				assertArrayEquals(exp, act);
				gl.clear();
			}
			//===========================================================
			// delEnd
			//===========================================================
			@Test (expected = IllegalArgumentException.class)
			public void test_delEnd_0()
			{
				Integer [] ini = {};
				gl.init(ini);
				gl.delEnd();
				gl.clear();
			}
			@Test
			public void test_delEnd_1()
			{
				Integer [] ini = {1};
				gl.init(ini);
				gl.delEnd();
				Object [] exp = {};
				Object [] act = gl.toArray();
				assertArrayEquals(exp, act);
				gl.clear();
				
			}
			@Test
			public void test_delEnd_2()
			{
				Integer [] ini = {1,2};
				gl.init(ini);
				gl.delEnd();
				Integer [] exp = {1};
				Integer [] act = gl.toArray();
				assertArrayEquals(exp, act);
				gl.clear();
			}
			@Test
			public void test_delEnd_many()
			{
				Integer [] ini = {9,6,7,8,10,15};
				gl.init(ini);
				gl.delEnd();
				Object [] exp = {9,6,7,8,10};
				Object [] act = gl.toArray();
				assertArrayEquals(exp, act);
				gl.clear();
			}
			//===========================================================
			// delPos
			//===========================================================

			@Test (expected = IllegalArgumentException.class)
			public void test_delPos_0()
			{
				Integer [] ini = {};
				gl.init(ini);
				gl.delPos(0);
				gl.clear();
			}
			@Test
			public void test_delPos_1()
			{
				Integer [] ini = {1};
				gl.init(ini);
				gl.delPos(0);
				Object [] exp = {};
				Object [] act = gl.toArray();
				assertArrayEquals(exp, act);
				gl.clear();
			}
			@Test
			public void test_delPos_2()
			{
				
				Integer [] ini = {1,2};
				gl.init(ini);
				gl.delPos(0);
				Integer [] exp = {2};
				Integer [] act = gl.toArray();
				assertArrayEquals(exp, act);
				gl.clear();
			}
			@Test
			public void test_delPos_many()
			{
				Integer [] ini = {2,4,7,8,5};
				gl.init(ini);
				gl.delPos(2);
				Integer [] exp = {2,4,8,5};
				Integer [] act = gl.toArray();
				assertArrayEquals(exp, act);
				gl.clear();
			}
			@Test
			public void test_delPos_many_0()
			{
				Integer [] ini = {2,4,7,8,5};
				gl.init(ini);
				gl.delPos(0);
				Integer [] exp = {4,7,8,5};
				Integer [] act = gl.toArray();
				assertArrayEquals(exp, act);
				gl.clear();
			}
			@Test
			public void test_delPos_many_4()
			{
				Integer [] ini = {2,4,7,8,5};
				gl.init(ini);
				gl.delPos(4);
				Integer [] exp = {2,4,7,8};
				Integer [] act = gl.toArray();
				assertArrayEquals(exp, act);
				gl.clear();
			}
			
			//===========================================================
			// delStart
			//===========================================================
			
			@Test (expected = IllegalArgumentException.class)
			public void test_delStart_0()
			{
				Integer [] ini = {};
				gl.init(ini);
				gl.delStart();
				gl.clear();
			}
			@Test
			public void test_delStart_1()
			{
//				gl.clear();
				Integer [] ini = {1};
				gl.init(ini);
				gl.delStart();
				Object [] exp = {};
				Object [] act = gl.toArray();
				assertArrayEquals(exp, act);
				gl.clear();
			}
			@Test
			public void test_delStart_2()
			{
				Integer [] ini = {1,2};
				gl.init(ini);
				gl.delStart();
				Integer [] exp = {2};
				Integer [] act = gl.toArray();
				assertArrayEquals(exp, act);
				gl.clear();
			}
			@Test
			public void test_delStart_many()
			{
				Integer [] ini = {7,8,10,23,54};
				gl.init(ini);
				gl.delStart();
				Integer [] exp = {8,10,23,54};
				Integer [] act = gl.toArray();
				assertArrayEquals(exp, act);
				gl.clear();
			}

			//===========================================================
			// get
			//===========================================================

			@Test ( expected = IllegalArgumentException.class )
			public void test_get_0()
			{
				Integer [] ini = {};
				gl.init(ini);
				gl.get(0);
				gl.clear();
			}
			@Test ( expected = IllegalArgumentException.class )
			public void test_get_less_0()
			{
				
				Integer [] ini = {3,4,2,5,1};
				gl.init(ini);
				gl.get(-1);
				gl.clear();
			}
			@Test ( expected = IllegalArgumentException.class )
			public void test_get_more_index()
			{
				
				Integer [] ini = {3,4,2,5,1};
				gl.init(ini);
				gl.get(6);
				gl.clear();
			}
			@Test
			public void test_get_1()
			{
				Integer [] ini = {3};
				gl.init(ini);
				int exp = 3;
				int act = gl.get(0);
				assertEquals(exp, act);
				gl.clear();
			}
			@Test
			public void test_get_2()
			{
				Integer [] ini = {3,4};
				gl.init(ini);
				int exp = 4;
				int act = gl.get(1);
				assertEquals(exp, act);
				gl.clear();
			}
			@Test
			public void test_get_many()
			{
				Integer [] ini = {3,4,6,5,1};
				gl.init(ini);
				int exp = 6;
				int act = gl.get(2);
				assertEquals(exp, act);
				gl.clear();
			}

			//===========================================================
			// halfReverse
			//=========================================================== 

			@Test 
			public void test_halfReverse_0()
			{
				Integer [] ini = {};
				gl.init(ini);
				gl.halfReverse();
				gl.clear();
			}
			@Test
			public void test_halfReverse_1()
			{
				Integer [] ini = {9};
				gl.init(ini);
				gl.halfReverse();
				Integer [] exp = {9};
				Integer [] act = gl.toArray();
				assertArrayEquals(exp, act);
				gl.clear();
			}
			@Test
			public void test_halfReverse_2()
			{
				Integer [] ini = {9,8};
				gl.init(ini);
				gl.halfReverse();
				Integer [] exp = {8,9};
				Integer [] act = gl.toArray();
				assertArrayEquals(exp, act);
				gl.clear();
			}
			@Test
			public void test_halfReverse_many_odd()
			{
				Integer [] ini = {9,8,7,6,4};
				gl.init(ini);
				gl.halfReverse();
				Integer [] exp = {6,4,7,9,8};
				Integer [] act = gl.toArray();
				assertArrayEquals(exp, act);
				gl.clear();
			}
			@Test
			public void test_halfReverse_many_even()
			{
				Integer [] ini = {9,8,7,6,4,11};
				gl.init(ini);
				gl.halfReverse();
				Integer [] exp = {6,4,11,9,8,7};
				Integer [] act = gl.toArray();
				assertArrayEquals(exp, act);
				gl.clear();
			}

		//===========================================================
		// min
		//===========================================================

		@Test ( expected = IllegalArgumentException.class )
		public void test_min_0()
		{
			Integer [] ini = {};
			gl.init(ini);
			gl.min();
			gl.clear();
		}
		@Test
		public void test_min_1()
		{
			Integer [] ini = {9};
			gl.init(ini);
			gl.min();
			int exp = 9;
			int act = gl.min();
			assertEquals(exp, act);
			gl.clear();
		}
		@Test
		public void test_min_2()
		{	
			Integer [] ini = {9,8};
			gl.init(ini);
			gl.min();
			Integer exp = 8;
			Integer act = gl.min();
			assertEquals(exp, act);
			gl.clear();
		}
		@Test
		public void test_min_many()
		{
			Integer [] ini = {9,8,7,-6,11};
			gl.init(ini);
			gl.min();
			Integer exp = -6;
			Integer act = gl.min();
			assertEquals(exp, act);
			gl.clear();
		}
			//===========================================================
			// max
			//===========================================================

			@Test (expected = IllegalArgumentException.class)
			public void test_max_0()
			{
				gl.clear();
				Integer [] ini = {};
				gl.init(ini);
				gl.max();
				gl.clear();
			}
			@Test
			public void test_max_1()
			{	
				Integer [] ini = {9};
				gl.init(ini);
				gl.max();
				Integer exp = 9;
				Integer act = gl.max();
				assertEquals(exp, act);
				gl.clear();
			}
			@Test
			public void test_max_2()
			{
				Integer [] ini = {9,8};
				gl.init(ini);
				gl.max();
				Integer exp = 9;
				Integer act = gl.max();
				assertEquals(exp, act);
				gl.clear();
			}
			@Test
			public void test_max_many()
			{
				Integer [] ini = {9,8,7,6,4};
				gl.init(ini);
				gl.max();
				Integer exp = 9;
				Integer act = gl.max();
				assertEquals(exp, act);
				gl.clear();
			}
		//===========================================================
		// minInd
		//===========================================================

		@Test ( expected = IllegalArgumentException.class )
		public void test_minInd_0()
		{
			Integer [] ini = {};
			gl.init(ini);
			gl.indMin();
			gl.clear();
		}
		@Test
		public void test_minInd_1()
		{
			Integer [] ini = {9};
			gl.init(ini);
			gl.indMin();
			int act = gl.indMin();
			assertEquals(0, act);
			gl.clear();
		}
		@Test
		public void test_minInd_2()
		{
			
			Integer [] ini = {9,8};
			gl.init(ini);
			gl.indMin();
			int exp = 1;
			int act = gl.indMin();
			assertEquals(exp, act);
			gl.clear();
		}
		@Test
		public void test_minInd_many()
		{
			
			Integer [] ini = {9,8,7,6,3};
			gl.init(ini);
			gl.indMin();
			int exp = 4;
			int act = gl.indMin();
			assertEquals(exp, act);
			gl.clear();
		}	
			//===========================================================
			// maxInd
			//===========================================================

			@Test ( expected = IllegalArgumentException.class )
			public void test_maxInd_0()
			{
				Integer [] ini = {};
				gl.init(ini);
				gl.indMax();
				gl.clear();
			}
			@Test
			public void test_maxInd_1()
			{
				Integer [] ini = {9};
				gl.init(ini);
				gl.indMax();
				int act = gl.indMax();
				assertEquals(0, act);
				gl.clear();
			}
			@Test
			public void test_maxInd_2()
			{
				Integer [] ini = {9,8};
				gl.init(ini);
				gl.indMax();
				int act = gl.indMax();
				assertEquals(0, act);
				gl.clear();
			}
			@Test
			public void test_maxInd_many()
			{
				Integer [] ini = {9,8,7,6,4};
				gl.init(ini);
				gl.indMax();
				int act = gl.indMax();
				assertEquals(0, act);
				gl.clear();
			}

			//===========================================================
			// reversee
			//=========================================================== 

			@Test 
			public void test_reverse_0()
			{
				Integer [] ini = {};
				gl.init(ini);
				gl.reverse();
				gl.clear();
			}
			@Test
			public void test_reverse_1()
			{
				Integer [] ini = {9};
				gl.init(ini);
				gl.reverse();
				Integer [] exp = {9};
				Integer [] act = gl.toArray();
				assertArrayEquals(exp, act);
				gl.clear();
			}
			@Test
			public void test_reverse_2()
			{
				Integer [] ini = {6,4};
				gl.init(ini);
				gl.reverse();
				Integer [] exp = {4,6};
				Integer [] act = gl.toArray();
				assertArrayEquals(exp, act);
				gl.clear();
			}
			@Test
			public void test_reverse_many_odd()
			{
				gl.clear();
				Integer [] ini = {9,8,7,6,4};
				gl.init(ini);
				gl.reverse();
				Object [] exp = {4,6,7,8,9};
				Object [] act = gl.toArray();
				assertArrayEquals(exp, act);
				gl.clear();
			}
			@Test
			public void test_reverse_many_even()
			{
				Integer [] ini = {9,8,7,6,4};
				gl.init(ini);
				gl.reverse();
				Integer [] exp = {4,6,7,8,9};
				Integer [] act = gl.toArray();
				assertArrayEquals(exp, act);
				gl.clear();
			}

			//===========================================================
			// set
			//===========================================================

			@Test ( expected = IllegalArgumentException.class )
			public void test_set_0()
			{
				Integer [] ini = {};
				gl.init(ini);
				gl.set(0, 10);
				gl.clear();
			}
			@Test ( expected = IllegalArgumentException.class )
			public void test_set_0_less()
			{
				Integer [] ini = {1,2,3,4};
				gl.init(ini);
				gl.set(-1, 10);
				gl.clear();
			}
			@Test ( expected = IllegalArgumentException.class )
			public void test_set_0_more_index()
			{
				Integer [] ini = {1,2,3,4};
				gl.init(ini);
				gl.set(5, 10);
				gl.clear();
			}
			@Test
			public void test_set_1()
			{
				Integer [] ini = {3};
				gl.init(ini);
				gl.set(0, 10);
				Integer [] exp = {10};
				Integer [] act = gl.toArray();
				assertArrayEquals(exp, act);
				gl.clear();
			}
			@Test
			public void test_set_2()
			{
				Integer [] ini = {3,4};
				gl.init(ini);
				gl.set(1, 10);
				Integer [] exp = {3,10};
				Integer [] act = gl.toArray();
				assertArrayEquals(exp, act);
				gl.clear();
			}
			@Test
			public void test_set_many_even()
			{
				Integer [] ini = {3,4,2,5,1};
				gl.init(ini);
				gl.set(2, 10);
				Integer [] exp = {3,4,10,5,1};
				Integer [] act = gl.toArray();
				assertArrayEquals(exp, act);
				gl.clear();
			}
			@Test
			public void test_set_many_odd()
			{
				Integer [] ini = {3,4,2,5,1,7};
				gl.init(ini);
				gl.set(2, 10);
				Integer [] exp = {3,4,10,5,1,7};
				Integer [] act = gl.toArray();
				assertArrayEquals(exp, act);
				gl.clear();
			}
	
//			//===========================================================
//			// sort
//			//===========================================================
//	
//			@Test 
//			public void test_sort_0()
//			{
//				Integer [] ini = {};
//				gl.init(ini);
//				gl.sort();
//			}
//			@Test
//			public void test_sort_1()
//			{
//				
//				Integer [] ini = {4};
//				gl.init(ini);
//				gl.sort();
//				Integer [] exp = {4};
//				Integer [] act = gl.toArray();
//				assertArrayEquals(exp, act);
//			}
//			@Test
//			public void test_sort_2()
//			{
//				Integer [] ini = {4,3};
//				gl.init(ini);
//				gl.sort();
//				Integer [] exp = {3,4};
//				Integer [] act = gl.toArray();
//				assertArrayEquals(exp, act);
//			}
//			@Test
//			public void test_sort_many()
//			{
//				Integer [] ini = {3,4,2,5,1};
//				gl.init(ini);
//				gl.sort();
//				Integer [] exp = {1,2,3,4,5};
//				Integer [] act = gl.toArray();
//				assertArrayEquals(exp, act);
//			}

}
