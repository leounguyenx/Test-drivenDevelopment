package assertor;

public class Assertor {
    public static void main(String[] args) {
        Assertor assertor = new Assertor();
        assertor.assertSomething();
    }

    private void assertSomething() {
        int x = 5;
        x++;
        assert x < 5;
    }
}
