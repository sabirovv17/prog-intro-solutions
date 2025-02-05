package markup;
import java.util.*;

public class Paragraph implements Markable {
    private final List<Markable> content;

    public Paragraph(List<Markable> content) {
        this.content = content;

    }

    @Override
    public void toMarkdown(StringBuilder bimbim) {
        for (Markable element : content) {
            element.toMarkdown(bimbim);
        }
    }
    public void toBBCode(StringBuilder bimbim) {
        for (Markable element : content){
            element.toBBCode(bimbim);
        }
    }
}
