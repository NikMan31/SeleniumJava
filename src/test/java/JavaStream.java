import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStream {
    @Test
    public void withoutJavaScream() {
        ArrayList<String> name = new ArrayList<String>();
        name.add("Nikunj");
        name.add("Maniya");
        name.add("Bhai");
        name.add("Mayuri");
        int count = 0;

        //My requirement is find out how many element from name which is start with M
        for (int i = 0; i < name.size(); i++) {
            String element = name.get(i);
            if (element.startsWith("M")) {
                count++;
            }
        }
        System.out.println(count);
    }

    //For satisfy given condition you have to write this entire code but with the help of JavaScream you can reduce complexity of code

    //@Test
    public void withJavaScream() {
        ArrayList<String> name = new ArrayList<String>();
        name.add("Nikunj");
        name.add("Maniya");
        name.add("Bhai");
        name.add("Mayuri");

        //First of all you need to convert this list into scream by using scream function
        Long nameM = name.stream().filter(element -> element.startsWith("M")).count(); //Datatype for variable will always Long
        //Here, as the name suggest and one more thing scream() always accept lamba function means(leftHandSide variable nu name, rightHandSide condition
        // And count() is terminator and it will print all the output also filter() is itermediator

        //There is one more condition like if your terminator will run false then your intermeidator will not work so its necessary to be execute terminator successfully

        System.out.println(nameM);

        //My Another requirement is to print out all the element which start with M
        name.stream().filter(element -> element.startsWith("M")).forEach(element -> System.out.println(element)); // To print out alll the element JavaStream provide of the function called forEach and same like them at the leftHand side variable and RightHandSide side will be condition

        //You can perform all the stream function on direct Stream like you don't need to convert into List<> bla bla
        Stream.of("Nikunj", "maniya", "Bhai", "Mayuri").filter(element -> element.startsWith("N")).forEach(element -> System.out.println(element));

        //Another requirement is I want to print all the element which has more than 2 size

        System.out.println("-------------");
        name.stream().filter(element -> element.length() > 2).forEach(element -> System.out.println(element));
        //If you want only number then
        System.out.println(name.stream().filter(element -> element.length() > 2).count());
    }

    //@Test
    public void JavaStreamWithMap() {

        //Basically Map is use for performing manipulation on the output element for ex, uppercase, lowercase wtc.
        ArrayList<String> name = new ArrayList<String>();
        name.add("Nikunj");
        name.add("Maniya");
        name.add("Bhai");
        name.add("Mayuri");

        //Here my requirement is to retrieve all the element in form of Uppercase which has length more than 2
        name.stream().filter(element -> element.length() > 2).map(element -> element.toUpperCase()).forEach(element -> System.out.println(element));

        //Here my another requirement is to retrieve all the element in form of Uppercase and sorted
        name.stream().filter(element -> element.length() > 0).sorted().map(element -> element.toUpperCase()).forEach(element -> System.out.println(element));
        //Here sorted() is another terminator

        //Here my requirement is retrieve only 1st element from Stream
        name.stream().filter(element -> element.length() > 1).limit(1).forEach(element -> System.out.println(element));
    }

    //@Test
    public void StreamConcate() {
        ArrayList<String> name = new ArrayList<String>();
        name.add("Nikunj");
        name.add("Maniya");
        name.add("Bhai");


        ArrayList<String> name1 = new ArrayList<String>();
        name1.add("Mayuri");
        name1.add("Kachhadiya");
        name1.add("Ben");

        //Here my requirement is to merge both of the stream

        Stream<String> concatStream = Stream.concat(name.stream(), name1.stream()); //this is already Stream so you don't need to convert
        concatStream.map(elements -> elements.toUpperCase()).sorted().forEach(elements -> System.out.println(elements));

        //Here my another requirement is check whether Mayuri is in String or not
        boolean verifyName = name1.stream().anyMatch(element -> element.equalsIgnoreCase("Mayuri"));
        System.out.println(verifyName);
        Assert.assertTrue(verifyName);
        System.out.println("-------------------------");
        //Here my requirement is to convert Stream into List and then retrieve element on base of index
        List<String> streamToList=Stream.of("Mayuri", "Nikunj", "MayuNiku", "Mayu", "Niku").filter(element->element.endsWith("u")).collect(Collectors.toList());
        System.out.println(streamToList);
        System.out.println(streamToList.get(1));
    }

    @Test
    public void StreamWithInteger(){
        List<Integer> IntegerList=new ArrayList<>();
        IntegerList.add(5);
        IntegerList.add(6);
        IntegerList.add(9);
        IntegerList.add(8);
        IntegerList.add(5);
        IntegerList.add(6);

        //Here my requirement is top retrieve all the unique element
        //And for that Stream has one function name is distict()

        IntegerList.stream().distinct().forEach(element-> System.out.println(element));
    }
}

