import mocking.ExternalDBMock;
import mocking.ObjectUnderTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestObjectUnderTest {
    @Test
    void test() {
        ExternalDBMock mockObject = mock(ExternalDBMock.class);
        //Dependency injection
        ObjectUnderTest objectUnderTest = new ObjectUnderTest(mockObject);

        when(mockObject.getValue("abc")).thenReturn(9);
        when(mockObject.getValue("def")).thenReturn(7);
        when(mockObject.getValue("xyz")).thenReturn(10);

        assertEquals(26, objectUnderTest.getTotalValues());

    }
}
