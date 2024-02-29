import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/rings-and-rods/description/
 */
public class RingsAndRods {

    public int countPoints(String rings){

        Map<Integer, List<ColouredRing>> ringsByRod = parse(rings)
                .stream().collect(Collectors.groupingBy(ColouredRing::getRod));

        long rodsWithAllThreeColours = ringsByRod.entrySet().stream().filter(rodAndRings -> {
            List<ColouredRing> colouredRingsOnRod = rodAndRings.getValue();
            boolean hasRedRing = colouredRingsOnRod.stream().anyMatch(ColouredRing::isRed);
            boolean hasGreenRing = colouredRingsOnRod.stream().anyMatch(ColouredRing::isGreen);
            boolean hasBlueRing = colouredRingsOnRod.stream().anyMatch(ColouredRing::isBlue);
            return hasRedRing && hasGreenRing && hasBlueRing;
        }).count();

        return (int)rodsWithAllThreeColours;
    }

    private List<ColouredRing> parse(String rings) {
        List<ColouredRing> colouredRings = new ArrayList<>();
        for (int i = 0; i < rings.length(); i=i+2){
            colouredRings.add(new ColouredRing(rings.substring(i, i+2)));
        }
        return colouredRings;
    }


    public static class ColouredRing {

        private final char colour;

        private final int rod;

        public ColouredRing(String colourAndRod){
            this(colourAndRod.charAt(0), Character.getNumericValue(colourAndRod.charAt(1)));
        }

        public ColouredRing(char colour, int rod) {
            this.colour = colour;
            this.rod = rod;
        }

        public int getRod() {
            return rod;
        }

        public boolean isRed(){
            return colour == 'R';
        }
        public boolean isGreen(){
            return colour == 'G';
        }
        public boolean isBlue(){
            return colour == 'B';
        }

        @Override
        public String toString() {
            return "ColouredRing{" +
                    "colour=" + colour +
                    ", rod=" + rod +
                    '}';
        }

    }


}


