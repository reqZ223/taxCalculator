public class taxCalc
{
    public double tax;
    public double yearlyTax(double input) {
        if (input <= 18200) {
            tax = 0;
        }
        else if (input >= 18201 && input <=45000) {
            tax = (input - 18200)*0.19;
        }
        else if (input >=45001 && input <=120000) {
            tax = 5092 + (input-45000)*0.325;
        }
        else if (input >= 120001 && input <= 180000) {
            tax = 29467 + 0.37*(input-120000);
        }
        else if (input >= 180001) {
            tax = 51667 + 0.45*(input-180000);
        }
        // showTax(input, tax); 
        return tax; 
    }
    
    
    // public void showTax(double income,double tax) {
        // double netVal = income - tax; 
        // System.out.println("Your tax withheld is: $"+tax);
        // System.out.println("-------------------------------------");
        // System.out.println("Your income after tax is: $"+netVal);
    // }
}