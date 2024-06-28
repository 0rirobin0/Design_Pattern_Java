package CreationalDP_SPFAB;

class Computer {
    private String cpu;
    private String ram;
    private String storage;

    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
    }

    public void displayInfo() {
        System.out.println("Computer Configuration:" +
                "\nCPU: " + cpu +
                "\nRAM: " + ram +
                "\nStorage: " + storage + "\n");
    }

    public static class Builder {
        private String cpu;
        private String ram;
        private String storage;

        public Builder setCPU(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder setRAM(String ram) {
            this.ram = ram;
            return this;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}

public class BuilderDP {
    public static void main(String[] args) {
        Computer gamingComputer = new Computer.Builder()
                .setCPU("Gaming CPU")
                .setRAM("16GB DDR4")
                .setStorage("1TB SSD")
                .build();

        gamingComputer.displayInfo();

        // You can create another type of computer using the same builder
        Computer officeComputer = new Computer.Builder()
                .setCPU("Office CPU")
                .setRAM("8GB DDR4")
                .setStorage("500GB SSD")
                .build();

        officeComputer.displayInfo();
    }
}
