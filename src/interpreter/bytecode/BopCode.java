package interpreter.bytecode;

import interpreter.VirtualMachine;

public class BopCode extends ByteCode {
    private String operator;
    private int result;
    public BopCode(){}

    @Override
    public void init(String args) {
        operator = args;
    }

    @Override
    public void execute(VirtualMachine vm) {
        int topInt = vm.popRunStack();
        int lowerInt = vm.popRunStack();
        
        result = computeResult(topInt,lowerInt,operator);

        vm.pushRunStack(result);
    }

    @Override
    public String getArgs() {
        return operator;
    }

    private int computeResult(int topInt, int lowerInt, String operation) {
        int res = 0;
        
        if (operation.startsWith("+"))
            res = lowerInt + topInt;
        else if (operation.startsWith("-"))
            res = lowerInt - topInt;
        else if (operation.startsWith("*"))
            res = lowerInt * topInt;
        else if (operation.startsWith("/"))
            res = lowerInt / topInt;


        else if (operation.startsWith("=="))
            if (lowerInt == topInt)  res = 1;
            else  res = 0;

        else if (operation.startsWith("!="))
            if (lowerInt != topInt)  res = 1;
            else  res = 0;

        else if (operation.startsWith("<="))
            if (lowerInt <= topInt)  res = 1;
            else  res = 0;

        else if (operation.startsWith(">="))
            if (lowerInt >= topInt)  res = 1;
            else  res = 0;

        else if (operation.startsWith("<"))
            if (lowerInt < topInt)  res = 1;
            else  res = 0;

        else if (operation.startsWith(">"))
            if (lowerInt > topInt)  res = 1;
            else  res = 0;

        else if (operation.startsWith("&"))
            if ((lowerInt > 0) && (topInt > 0))  res = 1;
            else  res = 0;

        else if (operation.startsWith("|"))
            if ((lowerInt > 0) || (topInt > 0))  res = 1;
            else  res = 0;

        return res;
    }
}
