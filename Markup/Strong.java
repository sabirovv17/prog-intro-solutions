package markup;
import java.util.*;

public class Strong extends Marking {

    public Strong(List<Markable> content){
        super(content, "__", "b");
    }
}
