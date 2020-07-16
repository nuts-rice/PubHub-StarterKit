package wsTest;

public class WebServiceTest {

	public TestClass test(int x, int y, String d)
	{
		TestClass tc = new TestClass();
		tc.x *= x;
		tc.y *= y;
		tc.description += d;
		return tc;
	}
}
