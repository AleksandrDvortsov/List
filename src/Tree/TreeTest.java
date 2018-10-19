package Tree;
import static org.junit.Assert.*;
import org.junit.Test;

public class TreeTest 
{
	BsTree<Integer> lst = new BsTree<Integer>();
	BsTree<Integer> xz = new BsTree<Integer>();

	@Test
	public void test_Iterator()
	{
		Integer[] ini = {9,8,7,-6,11};
		lst.init(ini);
		lst.iterator();
		Integer [] ex = {-6, 7, 8, 9, 11};
		Integer [] ac = (Integer[]) lst.toArray();
		assertArrayEquals(ex, ac);
		String exp = ("-6 7 8 9 11 ");
		String act = lst.toString();
		assertEquals(exp, act);
	}
	
	//===========================================================
	// clear
	//===========================================================

	@Test 
	public void test_clear_null()
	{
		Integer [] ini = null;
		lst.init(ini);
		lst.clear();
		assertEquals(0, lst.size());
	}

	@Test 
	public void test_clear_1l()
	{
		Integer [] ini = {50};
		lst.init(ini);
		lst.clear();
		assertEquals(0, lst.size());
	}

	@Test 
	public void test_clear_2()
	{
		Integer [] ini = {50,25};
		lst.init(ini);
		lst.clear();
		assertEquals(0, lst.size());
	}

	@Test 
	public void test_clear_many()
	{
		Integer [] ini = {50,25,11,7,34,18,70,90,28,65};
		lst.init(ini);
		lst.clear();
		assertEquals(0, lst.size());
	}

	//===========================================================
	// init
	//===========================================================

	@Test 
	public void test_init_null()
	{
		Integer[] ini = null;
		lst.init(ini);
		assertEquals(0, lst.size());
	}

	@Test 
	public void test_init_0()
	{
		Integer[] ini = {};
		lst.init(ini);
		assertEquals(0, lst.size());
	}

	@Test 
	public void test_init_1()
	{
		Integer[] ini = {5};
		lst.init(ini);
		assertEquals(1, lst.size());
	}

	@Test 
	public void test_init_2()
	{
		Integer[] ini = {2,6};
		lst.init(ini);
		assertEquals(2, lst.size());
	}

	@Test 
	public void test_init_many_event()
	{
		Integer[] ini = {50,25,11,7,34,18,70,90,28,65};
		lst.init(ini);
		assertEquals(10, lst.size());
	}

	@Test 
	public void test_init_many_odd()
	{
		Integer[] ini = {50,25,11,7,34,18,70,90,28,65,69};
		lst.init(ini);
		assertEquals(11, lst.size());
	}

	//===========================================================
	// size
	//===========================================================

	@Test 
	public void test_size_null()
	{
		Integer [] ini = null;
		lst.init(ini);
		assertEquals(0, lst.size());
	}
	@Test 
	public void test_size_0()
	{
		Integer [] ini = {};
		lst.init(ini);
		assertEquals(0, lst.size());
	}
	@Test 
	public void test_size_1()
	{
		Integer [] ini = {50};
		lst.init(ini);
		assertEquals(1, lst.size());
	}
	@Test 
	public void test_size_2()
	{
		Integer [] ini = {50,25};
		lst.init(ini);
		assertEquals(2, lst.size());
	}
	@Test 
	public void test_size_many()
	{
		Integer [] ini = {50,25,11,7,34,18,70,90,28,65};
		lst.init(ini);
		assertEquals(10, lst.size());
	}

	//===========================================================
	// add
	//===========================================================

	@Test 
	public void test_add_null()
	{
		Integer[] ini = null;
		lst.init(ini);
		lst.add(50);
		Integer [] exp = {50};
		Integer [] act = (Integer[]) lst.toArray();
		assertArrayEquals(exp, act);
	}
	
	@Test 
	public void test_add_0()
	{
		Integer[] ini = {};
		lst.init(ini);
		lst.add(50);
		Integer[] exp = {50};
		Integer[] act = (Integer[]) lst.toArray();
		assertArrayEquals(exp, act);
	}

	@Test 
	public void test_add_1()
	{
		Integer[] ini = {50};
		lst.init(ini);
		lst.add(25);
		Integer[] exp = {25,50};
		Integer[] act = (Integer[]) lst.toArray();
		assertArrayEquals(exp, act);
	}

		@Test 
		public void test_add_2()
		{
			Integer[] ini = {50,25};
			lst.init(ini);
			lst.add(11);
			Integer[] exp = {11,25,50};
			Integer[] act = (Integer[]) lst.toArray();
			assertArrayEquals(exp, act);
		}

		@Test 
		public void test_add_many()
		{
			Integer[] ini = {50,25,11,7,34,18,70,90};
			lst.init(ini);
			lst.add(28);
			Integer[] exp = {7,11,18,25,28,34,50,70,90};
			Integer[] act = (Integer[]) lst.toArray();
			assertArrayEquals(exp, act);
		}

		//===========================================================
		// nodes
		//===========================================================

		@Test 
		public void test_nodes_null()
		{
			Integer[] ini = null;
			lst.init(ini);
			int act =  lst.nodes();
			assertEquals(0, act);
		}

		@Test 
		public void test_nodes_1()
		{
			Integer[] ini = {50};
			lst.init(ini);
			int act = lst.nodes();
			assertEquals(0, act);
		}

		@Test 
		public void test_nodes_2()
		{
			Integer[] ini = {50,25};
			lst.init(ini);
			int act = lst.nodes();
			assertEquals(0, act);
		}

		@Test 
		public void test_nodes_3()
		{
			Integer[] ini = {50,25,70};
			lst.init(ini);
			int act = lst.nodes();
			assertEquals(1, act);
		}

		@Test 
		public void test_nodes_many()
		{
			Integer[] ini = {50,25,11,7,34,18,70,90,28,65};
			lst.init(ini);
			int exp = 4;
			int act = lst.nodes();
			assertEquals(exp, act);
		}

		//===========================================================
		// leaves
		//===========================================================

		@Test 
		public void test_leaves_null()
		{
			Integer[] ini = null;
			lst.init(ini);
			int act = lst.leaves();
			assertEquals(0, act);
		}

		@Test 
		public void test_leaves_0()
		{
			Integer[] ini = {};
			lst.init(ini);
			int act = lst.leaves();
			assertEquals(0, act);
		}

		@Test 
		public void test_leaves_1()
		{
			Integer[] ini = {50};
			lst.init(ini);
			int act = lst.leaves();
			assertEquals(1, act);
		}

		@Test 
		public void test_leaves_2()
		{
			Integer[] ini = {50,25};
			lst.init(ini);
			int act = lst.leaves();
			assertEquals(1, act);
		}

		@Test 
		public void test_leaves_many()
		{
			Integer[] ini = {50,25,11,7,34,18,70,90,28,65};
			lst.init(ini);
			int exp = 5;
			int act = lst.leaves();
			assertEquals(exp, act);
		}

		//===========================================================
		// height
		//===========================================================

		@Test 
		public void test_height_null()
		{
			Integer[] ini = null;
			lst.init(ini);
			int act = lst.height();
			assertEquals(0, act);
		}

		@Test 
		public void test_height_0()
		{
			Integer[] ini = {0};
			lst.init(ini);
			int act = lst.height();
			assertEquals(1, act);
		}

		@Test 
		public void test_height_1()
		{
			Integer[] ini = {50};
			lst.init(ini);
			int act = lst.height();
			assertEquals(1, act);
		}

		@Test 
		public void test_height_2()
		{
			Integer[] ini = {50,25};
			lst.init(ini);
			int act = lst.height();
			assertEquals(2, act);
		}

		@Test 
		public void test_height_many()
		{
			Integer[] ini = {50,25,11,7,34,18,70,90,28,65};
			lst.init(ini);
			int exp = 4;
			int act = lst.height();
			assertEquals(exp, act);
		}

		//===========================================================
		// widht
		//===========================================================

		@Test 
		public void test_widht_null()
		{
			Integer[] ini = null;
			lst.init(ini);
			int act = lst.widht();
			assertEquals(0, act);
		}

		@Test 
		public void test_widht_0()
		{
			Integer[] ini = {};
			lst.init(ini);
			int act = lst.widht();
			assertEquals(0, act);
		}

		@Test 
		public void test_widht_1()
		{
			Integer[] ini = {50};
			lst.init(ini);
			int act = lst.widht();
			assertEquals(1, act);
		}

		@Test 
		public void test_widht_2()
		{
			Integer[] ini = {50,25};
			lst.init(ini);
			int act = lst.widht();
			assertEquals(1, act);
		}

		@Test 
		public void test_widht_3()
		{
			Integer[] ini = {50,25,70};
			lst.init(ini);
			int act = lst.widht();
			assertEquals(2, act);
		}

		@Test 
		public void test_widht_many()
		{
			Integer[] ini = {50,25,11,7,34,18,70,90,28,65};
			lst.init(ini);
			int exp = 4;
			int act = lst.widht();
			assertEquals(exp, act);
		}

		//===========================================================
		// toString
		//===========================================================

		@Test 
		public void test_toString_null()
		{
			Integer[] ini = null;
			lst.init(ini);
			String exp = "";
			String act = lst.toString();
			assertEquals(exp, act);
		}

		@Test 
		public void test_toString_0()
		{
			Integer[] ini = {};
			lst.init(ini);
			String exp = "";
			String act = lst.toString();
			assertEquals(exp, act);
		}

		@Test 
		public void test_toString_1()
		{
			Integer[] ini = {1};
			lst.init(ini);
			String exp = "1 ";
			String act = lst.toString();
			assertEquals(exp, act);
		}

		@Test 
		public void test_toString_2()
		{
			Integer[] ini = {1,7};
			lst.init(ini);
			String exp = "1 7 ";
			String act = lst.toString();
			assertEquals(exp, act);
		}

		@Test 
		public void test_toString_many()
		{
			Integer[] ini = {50,25,11,7,34,18,70,90,28,65};
			lst.init(ini);
			String exp = "7 11 18 25 28 34 50 65 70 90 ";
			String act = lst.toString();
			assertEquals(exp, act);
		}

		//===========================================================
		// toArray
		//===========================================================

		@Test 
		public void test_toArray_null()
		{
			Integer [] ini = null;
			lst.init(ini);
			Integer [] exp = {};
			Integer [] act = (Integer[]) lst.toArray();
			assertArrayEquals(exp, act);
		}

		@Test 
		public void test_toArray_0()
		{
			Integer [] ini = {};
			lst.init(ini);
			Integer [] exp = {};
			Integer [] act = (Integer[]) lst.toArray();
			assertArrayEquals(exp, act);
		}

		@Test 
		public void test_toArray_1()
		{
			Integer [] ini = {50};
			lst.init(ini);
			Integer [] exp = {50};
			Integer [] act = (Integer[]) lst.toArray();
			assertArrayEquals(exp, act);
		}

		@Test 
		public void test_toArray_2()
		{
			Integer [] ini = {50,25};
			lst.init(ini);
			Integer [] exp = {25,50};
			Integer [] act = (Integer[]) lst.toArray();
			assertArrayEquals(exp, act);
		}

		@Test 
		public void test_toArray_many()
		{
			Integer [] ini = {50,25,11,7,34,18,70,90,28,65};
			lst.init(ini);
			Integer [] exp = {7,11,18,25,28,34,50,65,70,90};
			Integer [] act = (Integer[]) lst.toArray();
			assertArrayEquals(exp, act);
		}

		//===========================================================
		// del
		//===========================================================
		
		@Test ( expected = IllegalArgumentException.class)
		public void test_del_0()
		{
			Integer[] ini = {};
			lst.init(ini);
			lst.del(1);
		}
		
		@Test 
		public void test_del_1()
		{
			Integer[] ini = {50};
			lst.init(ini);
			lst.del(50);
			Integer [] exp = {};
			Integer [] act = (Integer[]) lst.toArray();
			assertArrayEquals(exp, act);
		}
		
		@Test 
		public void test_del_2()
		{
			Integer [] ini = {50,25};
			lst.init(ini);
			lst.del(25);
			Integer [] exp = {50};
			Integer [] act = (Integer[]) lst.toArray();
			assertArrayEquals(exp, act);
		}
		
		@Test 
		public void test_del_meny_1()
		{
			Integer [] ini = {50,25,11,7,34,18,70,90,28,65};
			lst.init(ini);
			lst.del(7);
			Integer [] exp = {11,18,25,28,34,50,65,70,90};
			Integer [] act = (Integer[]) lst.toArray();
			assertArrayEquals(exp, act);
		}
		
		@Test 
		public void test_del_meny_2()
		{
			Integer [] ini = {50,25,11,7,34,18,70,90,28,65};
			lst.init(ini);
			lst.del(34);
			Integer [] exp = {7,11,18,25,28,50,65,70,90};
			Integer [] act = (Integer[]) lst.toArray();
			assertArrayEquals(exp, act);
		}
		
		@Test 
		public void test_del_meny_3()
		{
			Integer [] ini = {50,25,11,7,34,18,70,90,28,65};
			lst.init(ini);
			lst.del(70);
			Integer [] exp = {7,11,18,25,28,34,50,65,90};
			Integer [] act = (Integer[]) lst.toArray();
			assertArrayEquals(exp, act);
		}

		//===========================================================
		// reverse
		//===========================================================

		@Test 
		public void test_reverse_null()
		{
			Integer [] ini = null;
			lst.init(ini);
			lst.reverse();
			Integer [] exp = {};
			Integer [] act = (Integer[]) lst.toArray();
			assertArrayEquals(exp, act);
		}
		
		@Test 
		public void test_reverse_0()
		{
			Integer [] ini = {};
			lst.init(ini);
			lst.reverse();
			Integer [] exp = {};
			Integer [] act = (Integer[]) lst.toArray();
			assertArrayEquals(exp, act);
		}
		
		@Test 
		public void test_reverse_1()
		{
			Integer [] ini = {50};
			lst.init(ini);
			lst.reverse();
			Integer [] exp = {50};
			Integer [] act = (Integer[]) lst.toArray();
			assertArrayEquals(exp, act);
		}
		
		@Test 
		public void test_reverse_2()
		{
			Integer [] ini = {50,25};
			lst.init(ini);
			lst.reverse();
			Integer [] exp = {50,25};
			Integer [] act = (Integer[]) lst.toArray();
			assertArrayEquals(exp, act);
		}
		
		@Test 
		public void test_reverse_3()
		{
			Integer [] ini = {50,25,11};
			lst.init(ini);
			lst.reverse();
			Integer [] exp = {50,25,11};
			Integer [] act = (Integer[]) lst.toArray();
			assertArrayEquals(exp, act);
		}
		
		@Test 
		public void test_reverse_many()
		{
			Integer [] ini = {50,25,11,7,34,18,70,90,28,65};
			lst.init(ini);
			lst.reverse();
			Integer [] exp = {90,70,65,50,34,28,25,18,11,7};
			Integer [] act = (Integer[]) lst.toArray();
			assertArrayEquals(exp, act);
		}
		
			//===========================================================
			// equals
			//===========================================================
			
			@Test 
			public void test_equals_many()
			{
			Integer [] ini = {50,25,11,7,34,18,70,90,28,65};
			Integer [] ini2 = {50,25,11,7,34,18,70,90,28,65};
			lst.init(ini);
			xz.init(ini2);
			lst.equals(xz);
			assertTrue(lst.equals(xz));
			}
	}
