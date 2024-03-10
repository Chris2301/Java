package nl.kick.designpatterns;

/**
 * Builder pattern, where we have used it plenty over the years of let Lombok library let us generate it for us.
 *
 * It works perfectly with immutability or for fast en readable object initiation in code (but also in tests)
 *
 * When to use:
 * When you have cumbersome way of creating an object, with plenty of mandatory or optional fields
 * When you constructors with a big list of parameters
 * When you have to create something like a pizza with different toppings or a car with different extra options ;)
 */
public class BuilderPattern {

    public static void main(String[] args) {
        Employee one = Employee.Builder.newInstance().firstName("Harry").lastName("Ludwigo").salary(4500).age(45).build();

        System.out.println("one.firstName = " + one.firstName);
        System.out.println("one.lastName = " + one.lastName);
        System.out.println("one.salary = " + one.salary);
        System.out.println("one.age = " + one.age);
    }

    static class Employee {
        private final String firstName;
        private final String lastName;
        private final int salary;
        private final int age;

        Employee(Builder builder) {
            this.firstName = builder.firstName;
            this.lastName = builder.lastName;
            this.salary = builder.salary;
            this.age = builder.age;
        }

        private static class Builder {

            private String firstName;
            private String lastName;
            private int salary;
            private int age;

            public static Builder newInstance()
            {
                return new Builder();
            }
            private Builder() {}
            public Builder firstName(String firstName) {
                this.firstName = firstName;
                return this;
            }

            public Builder lastName(String lastName) {
                this.lastName = lastName;
                return this;
            }

            public Builder salary(int salary) {
                this.salary = salary;
                return this;
            }

            public Builder age(int age) {
                this.age = age;
                return this;
            }

            public Employee build() {
                return new Employee(this);
            }
        }

    }

}
