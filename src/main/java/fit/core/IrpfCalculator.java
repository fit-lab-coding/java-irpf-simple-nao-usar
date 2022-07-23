package fit.core;

public class IrpfCalculator {

    public static double calculateBaseSalary(double totalSalary) {
        var inss = 11.0 / 100.0;
        var inssValue = totalSalary * inss;

        return totalSalary - inssValue;
    }

    public static double calculateExemption() {
        return 1903.98;
    }

    public static double calculateDiscount(double baseSalary) {
        return baseSalary - calculateExemption();
    }

    /**
    *  Até 1.903,98	-	 
    *  De 1.903,99 até 2.826,65	7,5	142,80
    *  De 2.826,66 até 3.751,05	15	354,80
    *  De 3.751,06 até 4.664,68	22,50	636,13
    * Acima de 4.664,68	27,50	869,36
    */
    public static double calculateTaxLayer(double baseSalary) {
        if (baseSalary <= 1903.98) return 0.000;
        if (baseSalary <= 2826.65) return 0.075;
        if (baseSalary <= 3751.05) return 0.150;
        if (baseSalary <= 4664.68) return 0.225;
        
        return 0.275;
    }

    public static double calculateIrpf(double totalSalary) {
        var baseSalary = calculateBaseSalary(totalSalary);
        var discountSalary = calculateDiscount(baseSalary);
        var taxLayer = calculateTaxLayer(baseSalary);

        return discountSalary * taxLayer;
    }

}
