public class E23N1 {
  private String title;
  private String published;
  private int number;
  private boolean approvedForPublication;

  E23N1() {
    this.title = "Untitled";
    this.published = "not set";
    this.number = 0;
    this.approvedForPublication = false;
  }

  E23N1(String title) {
    this.title = title;
    this.title = "Untitled";
    this.published = "not set";
    this.number = 0;
    
  }

  E23N1(String title, String published, int number, boolean approvedForPublication) {
    this.title = title;
    this.published = published;
    this.number = number;
    this.approvedForPublication = approvedForPublication;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getTitle() {
    return this.title;
  }

  public String toString() {
    if (!approvedForPublication) {
      return title + " - pending approval";
    } else if (approvedForPublication && published == "not set") {
      return title + " - to be published";
    } else {
      return title + " - " + published;
    }
    
  }
}