import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestStreams {

    @Test
    public void testReduce(){
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        Streams stream = new Streams();
        stream.setIntList(list);
        int expected = 21;
        int actual = stream.reduce();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFirstNameList(){
        People person1 = new People("Carolynn","Vansant", 34, "female");
        People person2 = new People("Luis", "Romero", 38, "male");
        ArrayList<People> peopleList = new ArrayList<>(Arrays.asList(person1,person2));
        Streams stream = new Streams();
        stream.setPeopleList(peopleList);
        List<String> expected = new ArrayList<>(Arrays.asList("Carolynn", "Luis"));
        List<String> actual = stream.firstNameList();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testGetAverage(){
        Integer[] array = {1,2,3,4,5,6,9};
        Double actual = Streams.getAverage(array);
        Double expected = 4.28;
        Assert.assertEquals(expected,actual, .01);

    }
}
