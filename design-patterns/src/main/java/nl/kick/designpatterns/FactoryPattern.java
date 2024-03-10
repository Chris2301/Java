package nl.kick.designpatterns;

/**
 * Factory Pattern
 */
public class FactoryPattern {

    /**
     * Here is visible that the user of the factory does not need to know the implementation.
     * It just talks to the interface; 'hey calculate these taxes for me'
     */
    public static void main(String[] args) {

        int employeeOneSalary = 1950;
        int employeeTwoSalary = 2500;
        int employeeThreeSalary = 4500;

        TaxOnSalaryCalculatorFactory factory = new TaxOnSalaryCalculatorFactory();

        System.out.println("Employee One before tax: " + employeeOneSalary + " after tax: " + factory.getTaxCalculator(employeeOneSalary).calculate());
        System.out.println("Employee One before tax: " + employeeTwoSalary + " after tax: " + factory.getTaxCalculator(employeeTwoSalary).calculate());
        System.out.println("Employee One before tax: " + employeeThreeSalary + " after tax: " + factory.getTaxCalculator(employeeThreeSalary).calculate());
    }

    /**
     * Here is the logic to determine which class should be initiated. In other words 'the factory'
     * Beceause we loosely couple getTaxCalculator to an Interface the factory is possible.
     */
    public static class TaxOnSalaryCalculatorFactory {
        private TaxCalculation getTaxCalculator(int salary) {
            if (salary < 2000) {
                return new LowestSalary(salary);
            } else if (salary < 3000) {
                return new MediumSalary(salary);
            } else{
                return new HighestSalary(salary);
            }
        }
    }

    private interface TaxCalculation {
        double calculate();
    }

    static class LowestSalary implements TaxCalculation {

        int salary;
        public LowestSalary(int salary) {
            this.salary = salary;
        }

        @Override
        public double calculate() {
            return salary * 0.8;
        }
    }

    static class MediumSalary implements TaxCalculation {

        int salary;
        public MediumSalary(int salary) {
            this.salary = salary;
        }
        @Override
        public double calculate() {
            return salary * 0.6;
        }
    }

    static class HighestSalary implements TaxCalculation {

        int salary;
        public HighestSalary(int salary) {
            this.salary = salary;
        }
        @Override
        public double calculate() {
            return salary * 0.5;
        }
    }

}
