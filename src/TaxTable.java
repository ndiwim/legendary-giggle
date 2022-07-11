public class TaxTable {
    //implements the tax table to calculate tax payable
    double TaxableIncome;
    double TaxPayable = 0;
    double PrimaryRebate = 15714;
    double MedicalCredits = 12000;

    public TaxTable(double taxableIncome) {
        TaxableIncome = taxableIncome;
    }
    public double CalculateTaxPayable() {
            if (TaxableIncome >= 0.00) {
                TaxPayable += (216200.00 - 0.00) * 0.18;
                if (TaxableIncome >= 216201.00) {
                    TaxPayable += (337800.00 - 216200.00) * 0.26;
                    if (TaxableIncome >= 337801.00) {
                        TaxPayable += (467500.00 - 337800.00) * 0.31;
                        if (TaxableIncome >= 467501.00) {
                            TaxPayable += (613600.00 - 467500.00) * 0.36;
                            if (TaxableIncome >= 613601.00) {
                                TaxPayable += (782200.00 - 613600.00) * 0.39;
                                if (TaxableIncome >= 782201.00) {
                                    TaxPayable += (1656600.00 - 782200.00) * 0.41;
                                    if (TaxableIncome >= 1656601.00) {
                                        TaxPayable += (1000_000_000.00 - 1_656_600.00) * 0.45;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            TaxPayable = TaxPayable - PrimaryRebate - MedicalCredits;
            return TaxPayable;
    }

}
