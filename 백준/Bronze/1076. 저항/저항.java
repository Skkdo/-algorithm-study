import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    private static class Resistor {
        private String color;
        private int value;
        private int multiplier;

        private Resistor(String color, int value, int multiplier) {
            this.color = color;
            this.value = value;
            this.multiplier = multiplier;
        }
    }

    private static class ResistorSet {
        private Map<String, Resistor> map;

        private ResistorSet() {
            this.map = new HashMap<>();
        }

        private void addResistor(Resistor resistor) {
            this.map.put(resistor.color, resistor);
        }

        private long getValue(String firstColor, String secondColor, String thirdColor) {
            int firstValue = map.get(firstColor).value * 10;
            int secondValue = map.get(secondColor).value;
            return (long) (firstValue + secondValue) * map.get(thirdColor).multiplier;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ResistorSet resistorSet = new ResistorSet();
        init(resistorSet);

        String firstColor = st.nextToken();

        st = new StringTokenizer(br.readLine());
        String secondColor = st.nextToken();

        st = new StringTokenizer(br.readLine());
        String thirdColor = st.nextToken();

        long answer = resistorSet.getValue(firstColor, secondColor, thirdColor);
        System.out.println(answer);
    }

    private static void init(ResistorSet resistorSet) {
        resistorSet.addResistor(new Resistor("black", 0, 1));
        resistorSet.addResistor(new Resistor("brown", 1, 10));
        resistorSet.addResistor(new Resistor("red", 2, 100));
        resistorSet.addResistor(new Resistor("orange", 3, 1000));
        resistorSet.addResistor(new Resistor("yellow", 4, 10000));
        resistorSet.addResistor(new Resistor("green", 5, 100000));
        resistorSet.addResistor(new Resistor("blue", 6, 1000000));
        resistorSet.addResistor(new Resistor("violet", 7, 10000000));
        resistorSet.addResistor(new Resistor("grey", 8, 100000000));
        resistorSet.addResistor(new Resistor("white", 9, 1000000000));
    }
}
