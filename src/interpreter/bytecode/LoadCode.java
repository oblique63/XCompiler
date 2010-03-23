package interpreter.bytecode;

import interpreter.VirtualMachine;

public class LoadCode extends ByteCode {
    private int offset;
    private String id;
    public LoadCode(){}

    @Override
    public void init(String args) {
        String argList[] = args.split("\\s");
        offset = Integer.parseInt(argList[0]);
        id = argList[1];
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.loadRunStack(offset);
    }

    @Override
    public String getArgs() {
        return Integer.toString(offset)+" "+id;
    }
}
