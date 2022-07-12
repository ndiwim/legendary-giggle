import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TaxPayer {
    //constants
    private static double INTEREST_RECEIVED_EXEMPTION;
    private static double CAPITAL_GAINS_EXEMPTION;
    private static double CAPITAL_GAINS_INCLUDED_RATE;
    private static double MEDICAL_CREDITS;
    private static double PRIMARY_REBATE;
    private static double SECONDARY_REBATE;
    private static double TERTIARY_REBATE;
    //bands
    private static double FIRST_BAND_LOW;
    private static double FIRST_BAND_HIGH;
    private static double FIRST_BAND_PERCENTAGE;
    private static double SECOND_BAND_LOW;
    private static double SECOND_BAND_HIGH;
    private static double SECOND_BAND_PERCENTAGE;
    private static double THIRD_BAND_LOW;
    private static double THIRD_BAND_HIGH;
    private static double THIRD_BAND_PERCENTAGE;
    private static double FOURTH_BAND_LOW;
    private static double FOURTH_BAND_HIGH;
    private static double FOURTH_BAND_PERCENTAGE;
    private static double FIFTH_BAND_LOW;
    private static double FIFTH_BAND_HIGH;
    private static double FIFTH_BAND_PERCENTAGE;
    private static double SIXTH_BAND_LOW;
    private static double SIXTH_BAND_HIGH;
    private static double SIXTH_BAND_PERCENTAGE;
    private static double SEVENTH_BAND_LOW;
    private static double SEVENTH_BAND_HIGH;
    private static double SEVENTH_BAND_PERCENTAGE;




    JSONParser parser = new JSONParser();
    Object object;

    {
        try {
            object = parser.parse(new FileReader("TaxCalculatorConstants.json"));
            JSONObject jsonObject = (JSONObject) object;

            INTEREST_RECEIVED_EXEMPTION = (double) jsonObject.get("INTEREST_RECEIVED_EXEMPTION");
            CAPITAL_GAINS_EXEMPTION = (double) jsonObject.get("CAPITAL_GAINS_EXEMPTION");
            CAPITAL_GAINS_INCLUDED_RATE = (double) jsonObject.get("CAPITAL_GAINS_INCLUDED_RATE");
            MEDICAL_CREDITS = (double) jsonObject.get("MEDICAL_CREDITS");
            PRIMARY_REBATE = (double) jsonObject.get("PRIMARY_REBATE");
            SECONDARY_REBATE = (double) jsonObject.get("SECONDARY_REBATE");
            TERTIARY_REBATE = (double) jsonObject.get("TERTIARY_REBATE");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

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

        if (TaxPayerInterestReceived > INTEREST_RECEIVED_EXEMPTION){
            taxableIncome += TaxPayerInterestReceived - INTEREST_RECEIVED_EXEMPTION;
        }

        if (TaxPayerTotalCapitalGain > CAPITAL_GAINS_EXEMPTION){
            taxableIncome += (TaxPayerTotalCapitalGain - CAPITAL_GAINS_EXEMPTION) * CAPITAL_GAINS_INCLUDED_RATE;
        }
        System.out.println("Your taxable income is:" + taxableIncome);
        return taxableIncome;


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
