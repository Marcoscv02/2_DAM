package marcos.psp.examen.harryPotter.model;

public class Book {
    private Integer number;
    private String title;
    private String originalTitle;
    private String releaseDate;
    private String description;
    private Integer pages;
    private String cover;
    private Integer index;

    public Book() {
    }

    public Book(Integer number, String title, String originalTitle, String releaseDate, String description, Integer pages, String cover, Integer index) {
        this.number = number;
        this.title = title;
        this.originalTitle = originalTitle;
        this.releaseDate = releaseDate;
        this.description = description;
        this.pages = pages;
        this.cover = cover;
        this.index = index;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "Book " + number + ", tittle: " + title +" (" + originalTitle + "), "+pages+" pages, releaseDate: " + releaseDate + ", descriptio: " + description ;
    }
}
