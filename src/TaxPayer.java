
public class TaxPayer {
    int TaxPayerNumber;
    String TaxPayerName;
    String TaxPayerSurname;
    int TaxPayerAge;
    double TaxPayerSalary;
    double TaxPayerBonuses;
    double TaxPayerInterestReceived;
    double TaxPayerDividends;
    double TaxPayerRetirementFunding;
    double TaxPayerTravelAllowance;

    public TaxPayer(int taxPayerNumber, String TaxPayerName, String TaxPayerSurname, int TaxPayerAge) {
        TaxPayerNumber = taxPayerNumber;
        TaxPayerName = TaxPayerName;
        TaxPayerSurname = TaxPayerSurname;
        TaxPayerAge = TaxPayerAge;
    }

    public double CalculateTaxableIncome(){
        //calculate the taxable income
        double TaxableIncome = 0;
        TaxableIncome += TaxPayerSalary;
        TaxableIncome += TaxPayerBonuses;
        if (TaxPayerInterestReceived >= 23800){
            TaxableIncome += TaxPayerInterestReceived - 23800;
        }
        //Add code for Capital Gains Here
        return TaxableIncome;
        //no
    }



    public double CalculateTaxDeductible(){
        double TaxDeductible = 0;
        TaxDeductible += TaxPayerTravelAllowance;
        //Add code for Retirement Funding here

        return TaxDeductible;
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
