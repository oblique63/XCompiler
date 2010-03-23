package interpreter.bytecode;

import interpreter.VirtualMachine;

public class GotoCode extends ByteCode {
    private String label;
    public GotoCode(){}

    @Override
    public void init(String args) {
        label = args;
    }

    @Override
    public void execute(VirtualMachine vm) {
        try {
        int goToAddress = Integer.parseInt(label.split("<<")[1].split(">>")[0]);
        vm.setProgramCounter(goToAddress-1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String getArgs() {
        return label;
    }
}
