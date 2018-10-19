package LList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
//@SuiteClasses({ EListTest.class, GListTestSmok.class })
public class ParameterizedTestSmoke 
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
	
	public ParameterizedTestSmoke(GList<Integer> prm)
	{
		gl = prm;
	}
	
	@Test
	public void testSmoke_null() 
	{
		Integer[] ini = null;
		gl.init(ini);
		assertEquals(0, gl.size());
		Object [] exp = {};
		Object [] act = gl.toArray();
		assertArrayEquals(exp, act);
		String ex = "";
		String ac = gl.toString();
		assertEquals(ex, ac);
		gl.clear();
		assertEquals(0, gl.size());
	}
	@Test
	public void testSmoke_0() 
	{
		Integer [] ini = null;
		gl.init(ini);
		assertEquals(0, gl.size());
		Integer [] exp = {};
		Integer [] act = gl.toArray();
		assertArrayEquals(exp, act);
		String ex = "";
		String ac = gl.toString();
		assertEquals(ex, ac);
		gl.clear();
		assertEquals(0, gl.size());
	}
	@Test
	public void testSmoke_1() 
	{
		Integer [] ini = {9};
		gl.init(ini);
		assertEquals(1, gl.size());
		Integer [] exp = {9};
		Integer [] act = gl.toArray();
		assertArrayEquals(exp, act);
		String ex = "9";
		String ac = gl.toString();
		assertEquals(ex, ac);
		gl.clear();
		assertEquals(0, gl.size());
	}
	@Test
	public void testSmoke_2() 
	{
		Integer [] ini = {9,15};
		gl.init(ini);
		assertEquals(2, gl.size());
		Integer [] exp = {9,15};
		Integer [] act = gl.toArray();
		assertArrayEquals(exp, act);
		String ex = "9, 15";
		String ac = gl.toString();
		assertEquals(ex, ac);
		gl.clear();
		assertEquals(0, gl.size());
	}
	@Test
	public void testSmoke_even() 
	{
		Integer [] ini = {10, 20, 30, 44, 55, 70};
		gl.init(ini);
		assertEquals(6, gl.size());
		Integer [] exp = {10, 20, 30, 44, 55, 70};
		Integer [] act = gl.toArray();
		assertArrayEquals(exp, act);
		String exp2 = "10, 20, 30, 44, 55, 70";
		String act2 = gl.toString();
		assertEquals(exp2, act2);
		gl.clear();
		assertEquals(0, gl.size());
	}
	@Test
	public void testSmoke_odd() 
	{
		Integer [] ini = {10, 20, 30, 44, 55, 70, 99};
		gl.init(ini);
		assertEquals(7, gl.size());
		Integer [] exp = {10, 20, 30, 44, 55, 70, 99};
		Integer [] act = gl.toArray();
		assertArrayEquals(exp, act);
		String exp2 = "10, 20, 30, 44, 55, 70, 99";
		String act2 = gl.toString();
		assertEquals(exp2, act2);
		gl.clear();
		assertEquals(0, gl.size());
	}
	
}
