/**
 * Book.java - Assignment 01
 * @author Jake Farrell
 */

enum BookMedium {
  PhysicalBook("PhysicalBook"), EBook("EBook"), AudioBook("AudioBook");
  private String value1;

  BookMedium(String value1) {
    this.value1 = value1;
  }
}

enum BookGenre { 
  Fiction("Fiction"), NonFiction("NonFiction");
  private String value2;

  BookGenre(String value2) {
    this.value2 = value2;
  }
}

enum BookRating {
  Rating5("5"), Rating4("4"), Rating3("3"), Rating2("2"), Rating1("1");
  private final String value3;

  BookRating(String value3) {
    this.value3 = value3;
  }

  public String getValue() { // used to get the number value ("5"), instead of Rating5
    return value3;
  }
}

class Book {
    // fields are private
      private String title;
      private String author;
      private BookGenre bookgenre;
      private BookMedium bookmedium;
      private int publisheddate;
      private int readdate;
      private BookRating bookrating;

      

    /**
     * Default constructor takes title, author, and genre
     */
      public Book(String title, String author, BookGenre bookgenre) {
      this.title = title;
      this.author = author;
      this.bookgenre = bookgenre;
    }
    /**
     * Additional constructor also takes published date
     */
    public Book(String title, String author, BookGenre bookgenre, int publisheddate) {
      this.title = title;
      this.author = author;
      this.bookgenre = bookgenre;
      this.publisheddate = publisheddate;
    }
    /**
     * Additional constructor also takes published date,
     * read date, read medium, and rating
     */
    public Book(String title, String author, BookGenre bookgenre, int publisheddate, int readdate, BookMedium bookmedium, BookRating bookrating) {
      this.title = title;
      this.author = author;
      this.bookgenre = bookgenre;
      this.publisheddate = publisheddate;
      this.readdate = readdate;
      this.bookmedium = bookmedium;
      this.bookrating = bookrating;
    }

    // getters
    public String getTitle() {
      return title;
    }
    public String getAuthor() {
      return author;
    }
    public BookGenre getGenre() {
      return bookgenre;
    }
    public int getPublishedDate() {
      return publisheddate;
    }
    public int getReadDate() {
      return readdate;
    }
    public BookMedium getMedium() {
      return bookmedium;
    }
    public BookRating getRating() {
      return bookrating;
    }
    
    // setters
    public void setTitle(String title) {
      this.title = title;
    }
    
    public void setAuthor(String author) {
      this.author = author;
    }
    public void setBookGenre(BookGenre bookgenre) {
      this.bookgenre = bookgenre;
    }
    public void setPublishedDate(int publisheddate) {
      this.publisheddate = publisheddate;
    }
    public void setReadDate(int readdate) {
      this.readdate = readdate;
    }
    public void setBookMedium(BookMedium bookmedium) {
      this.bookmedium = bookmedium;
    }
    public void setBookRating(BookRating bookrating) {
      this.bookrating = bookrating;
    }
    /**
     * toString implementation
     * Depends on available information
     * For title, an author, and a genre - Title by Author
     * If publication date is present - Title by Author (Year of Publication)
     * If read date, read medium, and rating is present -
     * Title by Author (Year of Publication) - read in Year of Reading, rated rating/5
     */
    public String toString() {
        if (this.publisheddate == 0) { // if published date is not provided
            return this.title + " by " + this.author;
        } 
        else if (this.publisheddate != 0 && this.readdate == 0) { // if published date but not read date are provided
            return this.title + " by " + this.author + " (" + this.publisheddate +")";
        }
        else { // otherwise when all data is provided
            return this.title + " by " + this.author + " (" + this.publisheddate +") - read in " + this.readdate + ", rated " + this.bookrating.getValue() + "/5";
        }
    }
    public static void main(String[] args) { // Code to test implementation of program
        Book b1 = new Book("Children of Time", "Adrian Tchaikovsky", BookGenre.Fiction);
        System.out.println(b1);
        Book b2 = new Book("The Fifth Season", "N. K. Jemesin", BookGenre.Fiction, 2015);
        System.out.println(b2);
        Book b3 = new Book("Perdido Street Station", "China Mieville",
        BookGenre.Fiction, 2000, 2020, BookMedium.EBook, BookRating.Rating5);
        System.out.println(b3);

        System.out.println(b1.getTitle());
        System.out.println(b1.getAuthor());
        System.out.println(b1.getGenre());
        System.out.println(b2.getPublishedDate());
        System.out.println(b3.getReadDate());
        System.out.println(b3.getMedium());
        System.out.println(b3.getRating());
    }
}