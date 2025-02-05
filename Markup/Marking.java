package markup;
import java.util.*;

public abstract class Marking implements Markable {
    private final List<Markable> content;
    private final String marker;
    private final String m2;


    public Marking(List<Markable> content, String marker, String m2){
        this.content = content;
        this.marker = marker;
        this.m2 = m2;
    }

    public void toMarkdown(StringBuilder bimbim) {
        bimbim.append(marker);
        for (Markable element : content){
            element.toMarkdown(bimbim);
        }
        bimbim.append(marker);
    }
    public void toBBCode(StringBuilder bimbim) {
        bimbim.append("[").append(m2).append("]");
        for (Markable element : content){
            element.toBBCode(bimbim);
        }
        bimbim.append("[/").append(m2).append("]");
    }
}
