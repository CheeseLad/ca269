class Q1a {
    public String questionText;
    public int questionNumber;
    public int marks;

    Q1a(String questionText, int questionNumber, int marks) {
        this.questionText = questionText;
        this.questionNumber = questionNumber;
        this.marks = marks;
    }

    public String toString() {
        return this.questionNumber + " " + this.questionText + " ( " + this.marks + " )";
    }

    public static void main(String[] args) {
        Q1a question = new Q1a("text", 1, 1);
        System.out.println(question);
    }
}