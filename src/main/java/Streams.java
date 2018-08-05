import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {


    ArrayList<Integer> intList;
    ArrayList<String> stringList;
    ArrayList<People> peopleList;

    public Streams(){
        this.intList = new ArrayList<>();
        this.stringList = new ArrayList<>();
    }


    public void setIntList(ArrayList<Integer> intList) {
        this.intList = intList;
    }

    public void setStringList(ArrayList<String> stringList) {
        this.stringList = stringList;
    }


    public void setPeopleList(ArrayList<People> peopleList) {
        this.peopleList = peopleList;
    }

    public int reduce(){
        return intList.stream().reduce(0, Integer::sum);
    }

    public List<String> firstNameList() {
        List<String> firstNames = peopleList.stream().map(e -> e.getFirstName()).collect(Collectors.toList());
        return firstNames;
    }

    public static Double getAverage(Integer[] intArray){
        Double count = (double)Arrays.stream(intArray).count();
        return (Arrays.stream(intArray).reduce(0,Integer::sum))/count;
    }


}
