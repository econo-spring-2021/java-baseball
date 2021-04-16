public class Ball implements Comparable<Ball>{
    private int number;

    public Ball(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object obj) {
        return number == ((Ball)obj).number;
    }

    @Override
    public int compareTo(Ball o) {
        return o.number - number;
    }

    @Override
    public String toString() {
        return "Ball{" +
                "number=" + number +
                '}';
    }
}
