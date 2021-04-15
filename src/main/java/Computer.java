import org.apache.commons.lang3.RandomUtils;

public class Computer {
    private String randomNumber = "";

    public String generateRandomNumber() {
        for(int i = 0; i < Constants.DIGITOFNUMBER; i ++) {
            randomNumber = randomNumber.concat(Integer.toString(RandomUtils.nextInt(1,9)));
        }
        return randomNumber;
    }

}
