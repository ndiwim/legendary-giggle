
public class TaxPayer {
    private int TaxPayerNumber;
    private String TaxPayerName;
    String TaxPayerSurname;
    int TaxPayerAge;
    double TaxPayerSalary;
    double TaxPayerBonuses;
    double TaxPayerInterestReceived;
    double TaxPayerDividends;
    double TaxPayerTotalCapitalGain;
    double TaxPayerRetirementFunding;
    double TaxPayerTravelAllowance;

    public TaxPayer(int TaxPayerNumber, String TaxPayerName, String TaxPayerSurname, int TaxPayerAge) {
        this.TaxPayerNumber = TaxPayerNumber;
        this.TaxPayerName = TaxPayerName;
        this.TaxPayerSurname = TaxPayerSurname;
        this.TaxPayerAge = TaxPayerAge;
    }

    public double CalculateTaxableIncome(){
        //calculate the taxable income
        double TaxableIncome = 0;
        TaxableIncome += TaxPayerSalary;
        TaxableIncome += TaxPayerBonuses;
        if (TaxPayerInterestReceived >= 23800){
            TaxableIncome += TaxPayerInterestReceived - 23800;
        }

        if (TaxPayerTotalCapitalGain > 40000){
            TaxableIncome += (TaxPayerTotalCapitalGain - 40000) * 0.4;
        }
        return TaxableIncome;
        //no
    }



    public double CalculateTaxDeductible(){
        double TaxDeductible = 0;
        TaxDeductible += TaxPayerTravelAllowance;
        //Add code for Retirement Funding here
        double TaxPayerRetirementMaxAllowed = 0;

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

        return TaxDeductible;
    }

    public double CalculateNettTaxableIncome(){
        return CalculateTaxableIncome() - CalculateTaxDeductible();
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

}
