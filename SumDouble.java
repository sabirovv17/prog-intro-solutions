import static java.lang.Character.isWhitespace;

public class SumDouble {
    public static void main(String[] arr) {
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            String mas = arr[i];
            StringBuilder sba = new StringBuilder();
            for (int j = 0; j < mas.length(); j++) {
                char c = mas.charAt(j);
                if (!isWhitespace(c)) {
                    sba.append(c);
                } else if (sba.length() > 0) {
                    double prom = Double.parseDouble(sba.toString());
                    sum += prom;
                    sba.setLength(0);
                }
            }
            if (sba.length() > 0) {
                double prom = Double.parseDouble(sba.toString());
                sum += prom;
            }
        }
        System.out.println(sum);
    }
}




