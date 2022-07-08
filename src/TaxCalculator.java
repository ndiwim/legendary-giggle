import java.util.Scanner;
public class TaxCalculator {

    static final double InterestReceivedExemption = 23800.00;
    static final double CapitalGainsExemption = 40000.00;
    static final double CapitalGainsIncludedRate = 0.40;
    static final double MedicalCredits = 12000;
    static final double PrimaryRebate = 15714;
    static final double SecondaryRebate = 8613;
    static final double TertiaryRebate = 2871;
    static  double NetTaxPayable = 0;

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter your tax payer number.");
        int TaxPayerNumber = Integer.parseInt(myScanner.nextLine());
        //take in details of the tax player (not necessary for phase1)
        System.out.println("Enter your name.");
        String TaxPayerName = myScanner.nextLine();

        System.out.println("Enter your surname.");
        String TaxPayerSurname = myScanner.nextLine();

        System.out.println("Enter your age."); //for Rebate purposes
        int TaxPayerAge = Integer.parseInt(myScanner.nextLine());

        //Create a TaxPayer Object
        TaxPayer TP1 = new TaxPayer(TaxPayerNumber, TaxPayerName, TaxPayerSurname, TaxPayerAge);

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

        //Calculate Net Taxable Income for TP1
        double TaxPayerNetTaxableIncome = TP1.CalculateNettTaxableIncome();

        //Calculate Tax Payable
        TaxTable t2021_2022 = new TaxTable(TaxPayerNetTaxableIncome);
        NetTaxPayable = t2021_2022.CalculateTaxPayable();

        //PrimaryRebate and MedicalCredits accounted for in Tax Table
        //Secondary and Tertiary Rebate not applicable in phase1
        /*//Deduct Medical Credits
         -= MedicalCredits;

        //Deduct Primary Rebate
        NetTaxPayable -= PrimaryRebate;

        //Deduct Secondary Rebate
        if (TP1.TaxPayerAge >= 65) {
            NetTaxPayable -= SecondaryRebate;
        }

        //Deduct Tertiary Rebate
        if (TP1.TaxPayerAge <= 65) {
            NetTaxPayable -= TertiaryRebate;
        }
        */

        System.out.println("Your Nett Tax Payable is R" + NetTaxPayable);

    }

}
