import markup.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Paragraph par = new Paragraph(List.of(
                new Strong(List.of(
                        new Text("1"),
                        new Strikeout(List.of(
                                new Text("2"),
                                new Emphasis(List.of(
                                        new Text("3"),
                                        new Text("4")
                                )),
                                new Text("5")
                        )),
                        new Text("6")
                ))
        ));
        StringBuilder bimbim = new StringBuilder();
        par.toMarkdown(bimbim);
        System.out.println(bimbim.toString());
        }
    }