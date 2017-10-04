import org.junit.*;
import static org.junit.Assert.*;

import org.mockito.*;

public class RentACatTester{
	RentACat _r;

	@Before
	public void setup(){
		_r = new RentACat();
	}

	// testing that a cat can be returned
	@Test
	public void returnCatTest(){
		// create double of Cat class
		Cat c = Mockito.mock(Cat.class);

		// stub out c.getRented() method
		Mockito.when(c.getRented()).thenReturn(true);
		boolean result = _r.returnCat(c);
		assertEquals(true, result);
	}

	// testing if rentCat returns false if cat is rented.
	@Test
	public void rentCatTest(){
		Cat c = Mockito.mock(Cat.class);

		Mockito.when(c.getRented()).thenReturn(true);
		boolean result = _r.rentCat(c);
		assertEquals(false,result);
		
	}

}
