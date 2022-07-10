import java.util.Scanner;
public class TaxCalculator {


    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter your tax payer number.");
        int TaxPayerTaxPayerNumber = Integer.parseInt(myScanner.nextLine());
        //take in details of the tax player (not necessary for phase1)
        System.out.println("Enter your name.");
        String TaxPayerName = myScanner.nextLine();

        System.out.println("Enter your surname.");
        String TaxPayerSurname = myScanner.nextLine();

        System.out.println("Enter your age."); //for Rebate purposes
        int TaxPayerAge = Integer.parseInt(myScanner.nextLine());

        //Create a TaxPayer Object
        TaxPayer TP1 = new TaxPayer(TaxPayerTaxPayerNumber, TaxPayerName, TaxPayerSurname, TaxPayerAge);

        //take in info about taxpayer's income and set them in the TaxPayer method
        System.out.println("Enter your salary.");
        double TaxPayerSalary = Double.parseDouble(myScanner.nextLine());
        TP1.setTaxPayerSalary(TaxPayerSalary);

        System.out.println("Enter your bonus amount.");
        double TaxPayerBonuses = Double.parseDouble(myScanner.nextLine());
        TP1.setTaxPayerBonuses(TaxPayerBonuses);

        System.out.println("Enter your interest received.");
        double TaxPayerInterestReceived = Double.parseDouble(myScanner.nextLine());
        TP1.setTaxPayerInterestReceived(TaxPayerInterestReceived);

        System.out.println("Enter your dividends.");
        double TaxPayerDividends = Double.parseDouble(myScanner.nextLine());
        TP1.setTaxPayerDividends(TaxPayerDividends);

        System.out.println("Enter total capital gains.");
        double TaxPayerTotalCapitalGain = Double.parseDouble(myScanner.nextLine());
        TP1.setTaxPayerTotalCapitalGain(TaxPayerTotalCapitalGain);

        System.out.println("Enter your retirement funding.");
        double TaxPayerRetirementFunding = Double.parseDouble(myScanner.nextLine());
        TP1.setTaxPayerRetirementFunding(TaxPayerRetirementFunding);

        System.out.println("Enter your travel allowance.");
        double TaxPayerTravelAllowance = Double.parseDouble(myScanner.nextLine());
        TP1.setTaxPayerTravelAllowance(TaxPayerTravelAllowance);


        double taxPayerNetTaxPayable = TP1.calculateNetTaxPayable();

        /*
        //Calculate Tax Payable
        TaxTable t2021_2022 = new TaxTable(TaxPayerNetTaxableIncome);
        NetTaxPayable = t2021_2022.CalculateTaxPayable();

         */



        System.out.println("Your Nett Tax Payable is R" + taxPayerNetTaxPayable);

    }

}
