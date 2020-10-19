public class GuessANumber {
    public static void main(String[] args) {
        int rangeFrom = 0;
        int rangeTo = 9;
        int maxTries = 3;
        int requestedNumber = (int) (rangeFrom + Math.random() * rangeTo - rangeFrom);
    }
}
