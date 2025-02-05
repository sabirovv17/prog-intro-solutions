package markup;

public class Text implements Markable {
    private final String text;

    public Text(String text) {
        this.text = text;
    }

    public void toMarkdown(StringBuilder bimbim){
        bimbim.append(text);
    }
    public void toBBCode(StringBuilder bimbim){
        bimbim.append(text);
    }
}
