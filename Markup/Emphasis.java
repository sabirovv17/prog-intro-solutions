package markup;
import java.util.*;

public class Emphasis extends Marking {

    public Emphasis(List<Markable> content) {
        super(content, "*", "i");
    }
}
