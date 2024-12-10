package Yearup.pluralsight.models;

public class Film
{
    private int filmId;
    private String title;
    private String description;
    private int releaseYear;
    private int length;

    public Film(int filmId, String title, String description, int releaseYear, int length) {
        this.filmId = filmId;
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.length = length;
    }

    @Override
    public String toString()
    {
        return "Title: " + title + " (" + releaseYear + "), Length: " + length + " mins";
    }
}
