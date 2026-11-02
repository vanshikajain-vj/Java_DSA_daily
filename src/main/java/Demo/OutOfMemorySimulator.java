package Demo;

import java.util.ArrayList;
import java.util.List;

public class OutOfMemorySimulator {
    public static void main(String[] args) {

        List<byte[]> list = new ArrayList<>();

        while (true) {
            list.add(new byte[1024 * 1024]);
            System.out.println("1 MB added");
        }
    } 
}
