interface Welcome {
    void showMessage();
}

interface GstCalculator {
    double calculate(double price);
}

interface BillCalculator {
    double getBill(double price, int quantity);
}

interface DiscountCalculator {
    double getDiscount(double amount);
}

interface FinalPayment {
    double payableAmount(double bill);
}

public class ShoppingApplicationLambda {
    public static void main(String[] args) {
        double productPrice = 5000;
        int productQuantity = 3;

        // Welcome message: no parameters
        Welcome shop = () ->
            System.out.println("Welcome to Raghav Shopping Store!");
        shop.showMessage();

        // Calculate 18% GST
        GstCalculator gst = price -> price * 18 / 100;
        double gstAmount = gst.calculate(productPrice);
        System.out.println("Product Price: " + productPrice);
        System.out.println("18% GST: " + gstAmount);

        // Calculate bill using price and quantity
        BillCalculator bill = (price, quantity) -> price * quantity;
        double totalBill = bill.getBill(productPrice, productQuantity);
        System.out.println("Quantity: " + productQuantity);
        System.out.println("Total Bill: " + totalBill);

        // Calculate 10% discount
        DiscountCalculator discount = amount -> amount * 0.10;
        double discountAmount = discount.getDiscount(totalBill);
        System.out.println("10% Discount: " + discountAmount);

        // Calculate final payable amount
        FinalPayment payment = amount -> {
            double discountValue = amount * 10 / 100;
            double finalAmount = amount - discountValue;
            return finalAmount;
        };

        double payable = payment.payableAmount(totalBill);
        System.out.println("Final Payable Amount: " + payable);
    }
}
