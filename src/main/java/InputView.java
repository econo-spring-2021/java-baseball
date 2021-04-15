import java.util.Scanner;

public class InputView {
    private String inputNumber;

    public InputView() {
        inputNumber = "";
    }

    public String getInputNumber() {
        return inputNumber;
    }

    public String inputInputNumber(/*Scanner scanner*/) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Constants.MESSAGE_COMMAND_INPUT);
        inputNumber = scanner.nextLine();
        inputNumber = inputNumber.replaceAll("\\s", "");
        return inputNumber;
    }

}
