import java.util.Scanner;
public class TaxCalculator {
    double InterestReceivedExemption = 23800.00;
    double CapitalGainsExemption = 40000.00;
    double CapitalGainsIncludedRate = 0.40;
    double MedicalCredits = 12000;
    double NetTaxPayable;

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter your tax payer number.");
        int TaxPayerNumber = Integer.parseInt(myScanner.nextLine());

        System.out.println("Enter your name.");
        String TaxPayerName = myScanner.nextLine();

        System.out.println("Enter your surname.");
        String TaxPayerSurname = myScanner.nextLine();

        System.out.println("Enter your age.");
        int TaxPayerAge = Integer.parseInt(myScanner.nextLine());

        TaxPayer TP1 = new TaxPayer(TaxPayerNumber, TaxPayerName, TaxPayerSurname, TaxPayerAge);

        System.out.println("Enter your salary.");
        double TaxPayerSalary = Double.parseDouble(myScanner.nextLine());
        TP1.setTaxPayerSalary(TaxPayerSalary);

        System.out.println("Enter your bonus amount.");
        double TaxPayerBonuses = Double.parseDouble(myScanner.nextLine());
        TP1.setTaxPayerSalary(TaxPayerBonuses);

        System.out.println("Enter your interest received.");
        double TaxPayerInterestReceived = Double.parseDouble(myScanner.nextLine());
        TP1.setTaxPayerInterestReceived(TaxPayerInterestReceived);

        System.out.println("Enter your dividends.");
        double TaxPayerDividends = Double.parseDouble(myScanner.nextLine());
        TP1.setTaxPayerDividends(TaxPayerDividends);

        System.out.println("Enter your retirement funding.");
        double TaxPayerRetirementFunding = Double.parseDouble(myScanner.nextLine());
        TP1.setTaxPayerInterestReceived(TaxPayerRetirementFunding);

        System.out.println("Enter your travel allowance.");
        double TaxPayerTravelAllowance = Double.parseDouble(myScanner.nextLine());
        TP1.setTaxPayerTravelAllowance(TaxPayerTravelAllowance);

    }

}
