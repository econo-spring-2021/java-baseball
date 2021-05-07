import org.apache.commons.lang3.RandomUtils;

public class Computer {
    private static String randomNumber = "";

    public static String generateRandomNumber() {
        randomNumber = "";
        for(int i = 0; i < Constants.DIGITOFNUMBER; i ++) {
            randomNumber = randomNumber.concat(Integer.toString(RandomUtils.nextInt(1,9)));
        }
        return randomNumber;
    }

}
