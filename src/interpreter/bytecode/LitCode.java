package interpreter.bytecode;

import interpreter.VirtualMachine;

/**
 * Stores a literal value on the Runtime stack
 * @author Enrique Gavidia
 */
public class LitCode extends ByteCode {
    private int value;
    private String id;
    public LitCode(){}

    @Override
    public void init(String args) {
        String argList[] = args.split("\\s");
        value = Integer.parseInt(argList[0]);
        if (argList.length > 1)
            id = argList[1];
        else
            id = "";
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.pushRunStack(value);
    }

    @Override
    public String getArgs() {
        return Integer.toString(value)+" "+id;
    }
}
