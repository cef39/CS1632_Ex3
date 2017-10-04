import org.junit.*;
import static org.junit.Assert.*;

import org.mockito.*;

public class RentACatTester{
	RentACat _r;

	@Before
	public void setup(){
		_r = new RentACat();
	}

	@Test
	public void returnCatTest(){
		Cat c = Mockito.mock(Cat.class);
		boolean result = _r.returnCat(c);

		assertEquals(true, result);

	}

}