import java.util.BitSet;
import java.util.List;
import java.util.Scanner;

public class Game {
    private int inputCount;

    private InputView inputView;
    private OutputView outputView;

    public Game() {
        inputCount = 0;
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void play(Scanner scanner) {
        String computerNumber = Computer.generateRandomNumber();
        //System.out.println(computerNumber);

        while(inputCount != Constants.NUMBER_OF_ATTEMPT) {
            inputView.inputInputNumber();
            if(Validator.validate(inputView.getInputNumber())) {
                inputCount++;
            }
            BaseballScore baseballScore = compareInputNumberWithComputerNumber(computerNumber, inputView.getInputNumber());
            if(inputCount == Constants.NUMBER_OF_ATTEMPT) {
                outputView.showFailureMessage();
            }

            if(baseballScore.strike != 3) {
                printHint(baseballScore);
            } else {
                outputView.showVictoryMessage();
                break;
            }

        }
    }

    private BaseballScore compareInputNumberWithComputerNumber(String computerNumber, String inputNumber) {
        BaseballScore baseballScore = new BaseballScore(0,0);

        for(int i = 0; i < Constants.DIGITOFNUMBER; i++) {
            if(inputNumber.charAt(i) == computerNumber.charAt(i)) {
                baseballScore.strike++;
            } else if(computerNumber.contains(Character.toString(inputNumber.charAt(i)))) {
                baseballScore.ball++;
            }
        }
        return baseballScore;
    }

    private void printHint(BaseballScore baseballScore) {
        if(baseballScore.ball == 4) {
            outputView.showFourBallResult();
        } else if (baseballScore.strike == 0 && baseballScore.ball > 0) {
            outputView.showOnlyBallResult(baseballScore);
        } else if(baseballScore.strike > 0 && baseballScore.ball == 0) {
            outputView.showOnlyStrikeResult(baseballScore);
        } else if(baseballScore.strike > 0 && baseballScore.ball > 0) {
            outputView.showStrikeAndBallResult(baseballScore);
        }
    }
}
