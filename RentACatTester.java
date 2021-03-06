import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.mockito.*;



public class RentACatTester{
	RentACat _r;

	@Before
	public void setup(){
		_r = new RentACat();
	}

	// testing that a cat can be returned
	@Test
	public void returnCatTest1(){
		// create double of Cat class
		Cat c = Mockito.mock(Cat.class);

		// stub out c.getRented() method
		Mockito.when(c.getRented()).thenReturn(true);
		boolean result = _r.returnCat(c);
		assertEquals(true, result);
	}

	// Testing that a cat can be rejected if it hasn't been rented out
	@Test
	public void returnCatTest2(){
		Cat c = Mockito.mock(Cat.class);

		Mockito.when(c.getRented()).thenReturn(false);
		boolean result = _r.returnCat(c);
		assertEquals(false, result);
	}

	// testing if rentCat returns false if cat is rented.
	@Test
	public void rentCatTest(){
		Cat c = Mockito.mock(Cat.class);

		Mockito.when(c.getRented()).thenReturn(true);
		boolean result = _r.rentCat(c);
		assertEquals(false,result);

	}

	//testing if rentCat returns false if cat is null
	@Test
	public void rentCatTest2(){
		boolean result = _r.rentCat(null);
		assertEquals(false,result);
	}

	// testing whether catExists() returns true when id is found
	// the last Cat in the list is given the desired Id to check that catExists() method iterates throughout whole ArrayList
	@Test
	public void catExistsTest1(){
		ArrayList<Cat> catList = new ArrayList<Cat>();
		int id = 1;

		Cat c1 = Mockito.mock(Cat.class);
		Cat c2 = Mockito.mock(Cat.class);
		Cat c3 = Mockito.mock(Cat.class);

		catList.add(c1);
		catList.add(c2);
		catList.add(c3);

		// stub out return values for each Cat double
		Mockito.when(c1.getId()).thenReturn(5);
		Mockito.when(c2.getId()).thenReturn(3);
		Mockito.when(c3.getId()).thenReturn(1);

		boolean result = _r.catExists(1, catList);

		assertEquals(true, result);
	}

	// test that sending an empty arraylist returns false
	@Test
	public void catExistsTest2(){
		ArrayList<Cat> catList = new ArrayList<Cat>();

		boolean result = _r.catExists(1, catList);

		assertEquals(false, result);
	}

	//test that checks if there is only 1 cat in the list and it is not available for rent.
	//Should return empty string.
	@Test
	public void catListTest(){
		ArrayList<Cat> catList = new ArrayList<Cat>();

		Cat c1 = Mockito.mock(Cat.class);
		catList.add(c1);

		Mockito.when(c1.getRented()).thenReturn(true);
		String result = _r.listCats(catList);
		assertEquals("",result);
	}

}
