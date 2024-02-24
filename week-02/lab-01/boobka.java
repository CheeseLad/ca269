/**
 * Book.java - Assignment 01
 * @author Jake Farrell
 */

enum BookMedium { PhysicalBook, EBook, AudioBook
}

//BookMedium medium = BookMedium.

enum BookGenre { Fiction, NonFiction
}

enum BookRating { Rating5, Rating4, Rating3, Rating2, Rating1
}

class Book {
  private String title;
  private String author;
  private int publishedDate;
  private int readDate;
  // , BookGenre bookgenre, int publishedDate, int readDate, BookMedium bookmedium, BookRating bookrating

  public Book(String title, String author) {
      this.title = title;
      this.author = author;
    }

   public String getTitle() {
      return title;
    }
    
    public void setTitle(String title) {
      this.title = title;
    }

    public String getAuthor() {
      return author;
    }
    
    public void setAuthor(String author) {
      this.author = author;
    }

      public int getPublishedDate() { // <-- getter
        return publishedDate;
    }
    public void setPublishedDate(int publishedDate) { // <-- setter
            this.publishedDate = publishedDate;
    }
   public int getReadDate() { // <-- getter
        return publishedDate;
    }
    public void setReadDate(int setReadDate) { // <-- setter
            this.setReadDate = setReadDate;
    }

       public int getMedium() { // <-- getter
        return BookMedium;
    }
    public void BookMedium(int BookMedium) { // <-- setter
            this.BookMedium = BookMedium;
    }

    //public Book(String title, String author) {
    //  this.title = title;
     // this.author = author;
    //}


    /**
     * Additional constructor also takes published date
     */



    /**
     * Additional constructor also takes published date,
     * read date, read medium, and rating
     */

    // getters


    // setters

    /**
     * toString implementation
     * Depends on available information
     * For title, an author, and a genre - Title by Author
     * If publication date is present - Title by Author (Year of Publication)
     * If read date, read medium, and rating is present -
     * Title by Author (Year of Publication) - read in Year of Reading, rated rating/5
     */

    public String toString() {
        return this.title + " by " + this.author;
    }

     public static void main(String[] args) {
Book b3 = new Book("Perdido Street Station", "China Mieville",
    BookGenre.Fiction);
System.out.println(b3);
System.out.println(b3.getReadDate());
System.out.println(b3.getMedium());
System.out.println(b3.getRating());
    }
}