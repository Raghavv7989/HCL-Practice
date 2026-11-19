import java.security.SecureRandom;

public class OTPGeneration {
    public static void main(String[] args) {
        int digit = 4;
        SecureRandom random = new SecureRandom();

        int otpNumber = random.nextInt((int) Math.pow(10, digit));
        String otp = String.format("%0" + digit + "d", otpNumber);

        System.out.println("Generated OTP: " + otp);
    }
}
