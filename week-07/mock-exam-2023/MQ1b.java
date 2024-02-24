class Q1b {
    private String title;
    public int number;
    private int marks;

    Q1b() {
      this.title = "untitled";
      this.number = 0;
      this.marks = 0;
    }

    Q1b(String title, int number, int marks) {
        this.title = title;
        this.number = number;
        this.marks = marks;
    }

    public String toString() {
        return this.number + " " + this.title + " ( " + this.marks + " )";
    }

    public void setTitle(String title) {
      this.title = title;
    }
    
    public void setNumber(int number) {
      this.number = number;
    }
    
    public void setMarks(int marks) {
      if (marks >= 0 || marks <= 99) {
        this.marks = marks;
      } else {
        this.marks = 0;
      }
    }

    public String getTitle() {
      return this.title;
    }

    public int getNumber() {
      return this.number;
    }

    public int getMarks() {
      return this.marks;
    }
}