package game;

import java.util.Random;
import java.util.Scanner;

public class NumGame {
    public static void main(String[] args) {
        int endNumber = 0; // 게임 종료 여부를 나타내는 변수 (0: 계속, 1: 승리, 2: 패배)
        int programCount = 0; // 플레이어 시도 횟수를 추적하는 변수
        Scanner s = new Scanner(System.in); // 사용자 입력을 받기 위한 스캐너 생성
        int computerNumber[] = computerNumber(); // 컴퓨터가 생성한 3자리 난수 저장
        boolean firstAttempt = true; // 처음 시도 여부를 추적하기 위한 변수
        int totalAttempts = 0; // 플레이어의 총 시도 횟수를 추적하는 변수

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (endNumber != 2) { // 게임 종료 여부가 2가 아닌 동안 반복
            if (!firstAttempt) {
                System.out.println("숫자를 입력해주세요.");
            } else {
                System.out.println("숫자를 입력해주세요.");
                firstAttempt = false;
            }

            int userInput = s.nextInt(); // 사용자가 입력한 숫자를 저장
            if (userInput < 100 || userInput > 999) {
                System.out.println("3자리 숫자를 입력해주세요.");
                continue; // 3자리 숫자가 아닌 경우 다시 입력
            }
            int strikeCount = judge(computerNumber, parseUserNumber(userInput)); // 입력한 숫자를 평가하고 스트라이크 수 계산
            programCount += 1; // 시도 횟수 증가
            totalAttempts += 1; // 총 시도 횟수 증가

            if (strikeCount == 3) { // 3 스트라이크인 경우, 승리
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료.\n");
                System.out.println("총 시도 횟수: " + totalAttempts); // 총 시도 횟수 출력
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
                endNumber = s.nextInt(); // 새로운 게임을 시작하거나 종료 여부 입력
                programCount = 0; // 시도 횟수 초기화
                computerNumber = computerNumber(); // 새로운 랜덤 숫자 생성
                firstAttempt = true;
                totalAttempts = 0; // 총 시도 횟수 초기화
            }
        }
    }

    // 사용자가 입력한 숫자를 컴퓨터가 생성한 숫자와 비교하여 스트라이크와 볼을 판단하는 메서드
    static int judge(int[] computerNumber, int[] userNumber) {
        int strikeCount = 0;
        int ballCount = 0;
        for (int i = 0; i < computerNumber.length; i++) {
            if (computerNumber[i] == userNumber[i]) {
                strikeCount += 1; // 같은 자리에 같은 숫자이면 스트라이크 증가
            } else if (computerNumber[i] != userNumber[i]) {
                int compareNumber = computerNumber[i];
                ballCount += findBall(compareNumber, userNumber); // 같은 숫자가 다른 자리에 있으면 볼 증가
            }
        }

        if (strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱"); // 하나도 맞지 않을 때 "낫싱" 출력
        } else {
            System.out.println(strikeCount + " 볼 , " + ballCount + " 스트라이크 "); // 스트라이크와 볼 수 출력
        }

        return strikeCount; // 스트라이크 수 반환
    }

    // 컴퓨터가 선택한 숫자 중, 사용자 입력 숫자와 같은 숫자의 개수를 찾는 메서드
    static int findBall(int compareNumber, int[] userNumber) {
        int sameCount = 0;
        for (int i = 0; i < userNumber.length; i++) {
            if (compareNumber == userNumber[i]) {
                sameCount += 1; // 같은 숫자를 찾으면 볼 증가
            }
        }
        return sameCount; // 볼 수 반환
    }

    // 사용자 입력으로 받은 숫자를 100자리, 10자리, 1자리로 분리하여 배열에 저장하는 메서드
    static int[] parseUserNumber(int userInput) {
        int[] userNumber = new int[3];
        userNumber[0] = userInput / 100; // 100 자리 숫자 추출
        userNumber[1] = (userInput % 100) / 10; // 10 자리 숫자 추출
        userNumber[2] = userInput % 10; // 1 자리 숫자 추출
        return userNumber; // 숫자 배열 반환
    }

    // 컴퓨터가 생성한 랜덤 숫자를 생성하는 메서드
    static int[] computerNumber() {
        int max = 9;
        int[] baseballNumber = new int[3];
        Random createRandom = new Random();
        baseballNumber[0] = randomNumber();
        do {
            baseballNumber[1] = randomNumber();
        } while (baseballNumber[0] == baseballNumber[1]);
        do {
            baseballNumber[2] = randomNumber();
        } while (baseballNumber[0] == baseballNumber[1] || baseballNumber[1] == baseballNumber[2]);
        return baseballNumber; // 컴퓨터가 생성한 랜덤 숫자 배열 반환
    }

    // 0부터 9 사이의 랜덤 숫자를 생성하는 메서드
    static int randomNumber() {
        int randomNumber;
        Random createRandom = new Random();
        randomNumber = createRandom.nextInt(9);
        return randomNumber; // 랜덤 숫자 반환
    }
}