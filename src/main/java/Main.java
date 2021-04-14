public class Main {
    public static void main(String[] args) {
        int[] answer = setRandomNum();
    }

    public static int[] setRandomNum() {
        int[] answer = new int[3];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = (int) (Math.random() * 10);
        }
        return answer;
    }
}
