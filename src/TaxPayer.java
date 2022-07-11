
public class TaxPayer {
    //constants
    private static final double INTEREST_RECEIVED_EXEMPTION = 23800.00;
    private static final double CAPITAL_GAINS_EXEMPTION = 40000.00;
    private static final double CAPITAL_GAINS_INCLUDED_RATE = 0.40;
    private static final double MEDICAL_CREDITS = 12000;
    private static final double PRIMARY_REBATE = 15714;
    private static final double SECONDARY_REBATE = 8613;
    private static final double TERTIARY_REBATE = 2871;


    //Tax Payer Attributes
    private int TaxPayerNumber;
    private String TaxPayerName;
    private String TaxPayerSurname;
    private int TaxPayerAge;
    private double TaxPayerSalary;
    private double TaxPayerBonuses;
    private double TaxPayerInterestReceived;
    private double TaxPayerDividends;
    private double TaxPayerTotalCapitalGain;
    private double TaxPayerRetirementFunding;
    private double TaxPayerTravelAllowance;

    public TaxPayer(int TaxPayerNumber, String TaxPayerName, String TaxPayerSurname, int TaxPayerAge) {
        this.TaxPayerNumber = TaxPayerNumber;
        this.TaxPayerName = TaxPayerName;
        this.TaxPayerSurname = TaxPayerSurname;
        this.TaxPayerAge = TaxPayerAge;
    }

    private double calculateTaxableIncome(){
        //calculate the taxable income
        double taxableIncome = 0;
        taxableIncome += TaxPayerSalary;
        taxableIncome += TaxPayerBonuses;
        if (TaxPayerInterestReceived >= INTEREST_RECEIVED_EXEMPTION){
            taxableIncome += TaxPayerInterestReceived - INTEREST_RECEIVED_EXEMPTION;
        }
<<<<<<< HEAD
        if (TaxPayerTotalCapitalGain > 40000){
            TaxableIncome += (TaxPayerTotalCapitalGain - 40000) * 0.4;
        }
        System.out.println("Your taxable income is:" + TaxableIncome);
        return TaxableIncome;
=======

        if (TaxPayerTotalCapitalGain > CAPITAL_GAINS_EXEMPTION){
            taxableIncome += (TaxPayerTotalCapitalGain - CAPITAL_GAINS_EXEMPTION) * CAPITAL_GAINS_INCLUDED_RATE;
        }
        return taxableIncome;
>>>>>>> main
        //no
    }



    private double calculateTaxDeductible(){
        double TaxDeductible = 0;
        TaxDeductible += TaxPayerTravelAllowance;
        //Add code for Retirement Funding here
        double TaxPayerRetirementMaxAllowed;

        if (0.275 * (TaxPayerSalary + TaxPayerBonuses) > 350000.00){
            TaxPayerRetirementMaxAllowed = 350000.00;
        }
        else {
            TaxPayerRetirementMaxAllowed = 0.275 * (TaxPayerSalary + TaxPayerBonuses);
        }

        if (TaxPayerRetirementFunding < TaxPayerRetirementMaxAllowed){
            TaxDeductible += TaxPayerRetirementFunding;
        }
        else {
            TaxDeductible += TaxPayerRetirementMaxAllowed;
        }
        System.out.println("Your tax deductable is:" + TaxDeductible);
        return TaxDeductible;
    }

    private double calculateNetTaxableIncome(){
        return calculateTaxableIncome() - calculateTaxDeductible();
    }

    public double calculateNetTaxPayable(){
        double netTaxPayable = 0;
        double taxableIncomeRemainder = calculateNetTaxableIncome();
        double taxableIncomeBandDifference;

        //1st band
        if (taxableIncomeRemainder <= 216_200 - 0){
            taxableIncomeBandDifference = taxableIncomeRemainder;
        }
        else {
            taxableIncomeBandDifference = 216_200 - 0;
        }
        netTaxPayable += taxableIncomeBandDifference * 0.18;
        taxableIncomeRemainder -= taxableIncomeBandDifference;

        //2nd band
        if (taxableIncomeRemainder >  0) {
            if (taxableIncomeRemainder <= 337_800 - 216_201) {
                taxableIncomeBandDifference = taxableIncomeRemainder;
            } else {
                taxableIncomeBandDifference = 337_700 - 216_201;
            }
            netTaxPayable += taxableIncomeBandDifference * 0.26;
            taxableIncomeRemainder -= taxableIncomeBandDifference;
        }

        //3rd band
        if (taxableIncomeRemainder > 0) {
            if (taxableIncomeRemainder <= 467_500 - 337_801) {
                taxableIncomeBandDifference = taxableIncomeRemainder;
            } else {
                taxableIncomeBandDifference = 467_500 - 337_801;
            }
            netTaxPayable += taxableIncomeBandDifference * 0.31;
            taxableIncomeRemainder -= taxableIncomeBandDifference;
        }

        //4th band
        if (taxableIncomeRemainder > 0) {
            if (taxableIncomeRemainder <= 613_600 - 467_501) {
                taxableIncomeBandDifference = taxableIncomeRemainder;
            } else {
                taxableIncomeBandDifference = 613_600 - 467_501;
            }
            netTaxPayable += taxableIncomeBandDifference * 0.36;
            taxableIncomeRemainder -= taxableIncomeBandDifference;
        }

        //5th band
        if (taxableIncomeRemainder > 0) {
            if (taxableIncomeRemainder <= 782_200 - 613_601) {
                taxableIncomeBandDifference = taxableIncomeRemainder;
            } else {
                taxableIncomeBandDifference = 782_200 - 613_601;
            }
            netTaxPayable += taxableIncomeBandDifference * 0.39;
            taxableIncomeRemainder -= taxableIncomeBandDifference;
        }

        //6th band
        if (taxableIncomeRemainder > 0) {
            if (taxableIncomeRemainder <= 1_656_600 - 782_201) {
                taxableIncomeBandDifference = taxableIncomeRemainder;
            } else {
                taxableIncomeBandDifference = 1_656_600 - 782_201;
            }
            netTaxPayable += taxableIncomeBandDifference * 0.41;
            taxableIncomeRemainder -= taxableIncomeBandDifference;
        }

        //7th band
        if (taxableIncomeRemainder > 0) {
            if (taxableIncomeRemainder <= 1_000_000_000 - 1_656_601) {
                taxableIncomeBandDifference = taxableIncomeRemainder;
            } else {
                taxableIncomeBandDifference = 1_000_000_000 - 1_656_601;
            }
            netTaxPayable += taxableIncomeBandDifference * 0.35;
            taxableIncomeRemainder -= taxableIncomeBandDifference;
        }

        //DEDUCT MEDICAL CREDITS
        netTaxPayable -= MEDICAL_CREDITS;

        //DEDUCT PRIMARY REBATE
        netTaxPayable -= PRIMARY_REBATE;

        return netTaxPayable;

    }

    public double getTaxPayerTotalCapitalGain() {
        return TaxPayerTotalCapitalGain;

    }
    public void setTaxPayerTotalCapitalGain(double taxPayerTotalCapitalGain) {
        TaxPayerTotalCapitalGain = taxPayerTotalCapitalGain;
    }

    public double getTaxPayerSalary() {
        return TaxPayerSalary;
    }

    public void setTaxPayerSalary(double taxPayerSalary) {
        TaxPayerSalary = taxPayerSalary;
    }

    public double getTaxPayerBonuses() {
        return TaxPayerBonuses;
    }

    public void setTaxPayerBonuses(double taxPayerBonuses) {
        TaxPayerBonuses = taxPayerBonuses;
    }

    public double getTaxPayerInterestReceived() {
        return TaxPayerInterestReceived;
    }

    public void setTaxPayerInterestReceived(double taxPayerInterestReceived) {
        TaxPayerInterestReceived = taxPayerInterestReceived;
    }

    public double getTaxPayerDividends() {
        return TaxPayerDividends;
    }

    public void setTaxPayerDividends(double taxPayerDividends) {
        TaxPayerDividends = taxPayerDividends;
    }

    public double getTaxPayerRetirementFunding() {
        return TaxPayerRetirementFunding;
    }

    public void setTaxPayerRetirementFunding(double taxPayerRetirementFunding) {
        TaxPayerRetirementFunding = taxPayerRetirementFunding;
    }

    public double getTaxPayerTravelAllowance() {
        return TaxPayerTravelAllowance;
    }

    public void setTaxPayerTravelAllowance(double taxPayerTravelAllowance) {
        TaxPayerTravelAllowance = taxPayerTravelAllowance;
    }

    public int getTaxPayerNumber() {
        return TaxPayerNumber;
    }

    public void setTaxPayerNumber(int TaxPayerNumber) {
        TaxPayerNumber = TaxPayerNumber;
    }

    public String getTaxPayerName() {
        return TaxPayerName;
    }

    public void setTaxPayerName(String taxPayerName) {
        TaxPayerName = taxPayerName;
    }

    public String getTaxPayerSurname() {
        return TaxPayerSurname;
    }

    public void setTaxPayerSurname(String taxPayerSurname) {
        TaxPayerSurname = taxPayerSurname;
    }

    public int getTaxPayerAge() {
        return TaxPayerAge;
    }

    public void setTaxPayerAge(int taxPayerAge) {
        TaxPayerAge = taxPayerAge;
    }
}
