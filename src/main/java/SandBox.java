import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class SandBox {

    static Predicate<Integer> divideByThree = (Integer i) -> i%3 == 0;
    static Supplier<String> divideByThreeSupplier = () -> "hakuna ";
    static Predicate<Integer> divideByFive = (Integer i) -> i%5 == 0;
    static Supplier<String> divideByFiveSupplier = () -> "matata ";
    static Predicate<Integer> divideBySeven = (Integer i) -> i%7 == 0;
    static Supplier<String> divideBySevenSupplier = () -> "aye ";
    static StringBuilder sb;
    static String numbers_regex = "\\b\\d+\\b";

    public static void main(String[] args){
        Stream.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,21,105).forEach(SandBox::check);
    }

    public static void check(Integer number){
        sb = new StringBuilder();
        appendAnswer(sb, checkNumber(number, divideByThree, divideByThreeSupplier));
        appendAnswer(sb, checkNumber(number, divideByFive, divideByFiveSupplier));
        appendAnswer(sb, checkNumber(number, divideBySeven, divideBySevenSupplier));
        System.out.println(sb.toString());
    }

    public static String checkNumber(Integer number, Predicate<Integer> predicate, Supplier<String> supplier){
        if(predicate.test(number))
            return supplier.get();
        else
            return number.toString();
    }

    public static void appendAnswer(StringBuilder sb, String s) {
        if(sb.toString().isEmpty())
            SandBox.sb = sb.append(s);
        else if (!(sb.toString().matches(numbers_regex)) && !(s.matches(numbers_regex)))
            SandBox.sb = sb.append(s);
        else if (sb.toString().matches(numbers_regex) && !(s.matches(numbers_regex)))
            SandBox.sb = new StringBuilder(sb.toString().replaceAll(numbers_regex, s));
    }


}
