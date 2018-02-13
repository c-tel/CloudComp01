import java.util.Comparator;

public class Movie implements Comparable<Movie> {
    String name;
    int year;
    int box_office;
    static Comparator<Movie> cash_order = new CompCash();
    static Comparator<Movie> year_order = new CompYears();
    static Comparator<Movie> name_order = new CompNames();
    public Movie(String name, int year, int box_office) {
        this.name = name;
        this.year = year;
        this.box_office = box_office;
    }

    public int compareTo(Movie that) {
        return this.name.compareTo(that.name);
    }

    public static class CompYears implements Comparator<Movie> {
        @Override
        public int compare(Movie o1, Movie o2) {
            if (o1.year < o2.year)
                return 1;
            if (o1.year > o2.year)
                return -1;
            return 0;
        }
    }

    public static class CompNames implements Comparator<Movie> {
        @Override
        public int compare(Movie o1, Movie o2) {
            return -(o1.name.compareTo(o2.name));
        }
    }

    public static class CompCash implements Comparator<Movie> {
        @Override
        public int compare(Movie o1, Movie o2) {
            if (o1.box_office < o2.box_office)
                return 1;
            if (o1.box_office > o2.box_office)
                return -1;
            return 0;
        }
    }

    public String toString() {
        return name + ", " + year + ", box office: " + box_office;
    }
}
