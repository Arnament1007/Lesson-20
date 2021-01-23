import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        // 1
        Stream.of().skip(1).distinct().findAny();

        // 2
        List<String> list = Arrays.asList("first", "second", "third");

        List<String> stringList = list.stream()
                .filter(string -> string.contains("r"))
                .filter(string -> string.length() > 3)
                .collect(Collectors.toList());

        System.out.println(stringList);

        // 3
        Collection<String> collection = Arrays.asList("1", "2", "3");
        Stream<String> streamFromCollection = collection.stream();
        System.out.println(streamFromCollection.collect(Collectors.toList()));

        // 4
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");

        Set<Object> optionalMap = new HashSet<>(map.values());
        optionalMap.forEach(System.out::println);

        // 5
        List<String> coll = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        Stream<String> streamCollection = coll.stream()
                .skip(1)
                .limit(8)
                .mapToInt(v -> Integer.parseInt(v))
                .filter((p -> p % 2 == 0))
                .distinct()
                .collect(Collectors.toList());

        // 6
        Stream<String> sixthStream = Stream.of("Anna", "Vova", "Denis", "Oleg");
            Optional<String> parallelStream = sixthStream.parallel()
                .sorted()
                .filter(string -> string.contains("e"))
                .findFirst();
        System.out.println(((Optional) parallelStream));

        // 7


    }
}
