public class RE23N1 {
  private int volume;
  private String title;
  private String author;
  private boolean proofread;

  RE23N1() {
    this.title = "Untitled Article";
    this.author = "Anonymous";
    this.volume = 0;
    this.proofread = false;
  }

  RE23N1(String title, String author) {
    this.title = title;
    this.author = author;
    this.volume = 0;
    this.proofread = false;
  }

  public void setVolume(int volume) {
    if (volume < 0) {
      this.proofread = false;
    } else {
      this.proofread = true;
    }
    this.volume = volume;
  }
  public void setTitle(String title) {
    if (title.length() < 3 && title.length() > 25) {
      this.proofread = false;
    } else {
      this.proofread = true;
    }
    this.title = title;
  }
  public void setAuthor(String author) {
    if (author.length() < 2) {
      this.proofread = false;
    } else {
      this.proofread = true;
    }
    this.author = author;
  }
  public void setProofread(boolean proofread) {
    this.proofread = proofread;
  }

  public int getVolume() {
    return volume;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public boolean getProofread() {
    return proofread;
  }

  public String toString() {
    return title + " (" + author + ") in Vol." + volume;
  }

  public void checkProof() {
    if ((author.length() > 2) && (title.length() > 3 && title.length() < 25) && (volume > 0)) {
      this.proofread = true;
    } else {
      this.proofread = false;
    }
  }
}
