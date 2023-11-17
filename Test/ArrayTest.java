import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static java.beans.Beans.isInstanceOf;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ArrayTest {
    ArrayExtensions arrayExtensions;
    ArrayComparator arrayComparator;
    @BeforeEach
    void setUp(){
        arrayExtensions=new ArrayExtensions();
        arrayComparator=new ArrayComparator(arrayExtensions);
    }

    ///тест ArrayExtensions
    @Test
    void testNullableArray(){
        assertThatThrownBy(()->arrayExtensions.arrayAverage(null)
        ).isInstanceOf(NullPointerException.class);
    }

    @Test
    void testEmptyArray(){
        assertThatThrownBy(()->arrayExtensions.arrayAverage(new double[]{})
        ).isInstanceOf(EmptyListException.class);
    }

    @Test
    void testArrayAvarage(){
        assertEquals(2,arrayExtensions.arrayAverage(new double[]{1,2,3}));
    }

    ///тест ArrayComparator
    @Test
    void testArrayComparator(){
        ArrayExtensions mockArrayExtension=mock(ArrayExtensions.class);
        ArrayComparator arrayComparator1=new ArrayComparator(mockArrayExtension);
        when(mockArrayExtension.arrayAverage(null)).thenReturn(
                1.0,1.0,
                1.0,2.0,
                2.0,1.0);
        assertEquals(0,arrayComparator1.compareArray(null,null));
        assertEquals(-1,arrayComparator1.compareArray(null,null));
        assertEquals(1,arrayComparator1.compareArray(null,null));
    }

    ///тест ArrayComparator и ArrayExtensions в связке
    @Test
    void testArrayAvarageComparator(){
        assertEquals(0,arrayComparator.compareArray(new double[]{1,2,3},new double[]{1,2,3}));
        assertEquals(-1,arrayComparator.compareArray(new double[]{1,2,0},new double[]{1,2,3}));
        assertEquals(1,arrayComparator.compareArray(new double[]{1,2,3},new double[]{1,2,0}));
    }
}
