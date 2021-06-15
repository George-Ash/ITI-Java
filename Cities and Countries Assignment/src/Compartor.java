import java.util.Comparator;

public class Compartor implements Comparator<City> {

        public int compare(City c1, City c2) {
            return c1.getPopulation().compareTo(c2.getPopulation());
        }
}

