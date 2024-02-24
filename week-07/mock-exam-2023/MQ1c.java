class Q1c {
    private String title;
    public int number;
    private int marks;
    private static int MQUESTION_COUNT = 0;

    Q1c() {
      this.title = "untitled";
      this.number = 0;
      this.marks = 0;
      this.MQUESTION_COUNT++;
    }

    Q1c(String title, int number, int marks) {
        this.title = title;
        this.number = number;
        this.marks = marks;
        this.MQUESTION_COUNT++;
    }

    Q1c(String title, int marks) {
        this.title = title;
        this.number = MQUESTION_COUNT;
        this.marks = marks;
        this.MQUESTION_COUNT++;
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