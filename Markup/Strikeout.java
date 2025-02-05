package markup;

import java.util.List;

public class Strikeout extends Marking {

    public Strikeout(List<Markable> content){
        super(content, "~", "s");
    }
}
