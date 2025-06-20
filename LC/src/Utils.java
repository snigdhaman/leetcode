import java.util.List;

public class Utils {
    public static <T> void printList (List<T> list) {
        for (T el : list) {
            System.out.print(el + ", ");
        }
        System.out.println();
    }
}
