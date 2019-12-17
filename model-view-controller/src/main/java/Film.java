public class Film {
    public int id;
    public String title;
    public String genre;
    public String director;
    public int year;
    public int rating;

    public Film(String title, String genre, String director, int year, int rating) {
        this.title = title;
        this.genre = genre;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getDirector() {
        return director;
    }

    public int getYear() {
        return year;
    }

    public int getRating() {
        return rating;
    }
}
