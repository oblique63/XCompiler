package interpreter;

import interpreter.bytecode.ByteCode;
import java.util.Stack;


public class VirtualMachine {
    private Program program;
    private int programCounter;
    private RunTimeStack runStack;
    private Stack<Integer> returnAddrs;
    private Boolean isRunning, dump;

    VirtualMachine(Program program) {
        this.program = program;
    }

    void executeProgram() {
        programCounter = 0;
        runStack = new RunTimeStack();
        returnAddrs = new Stack<Integer>();
        isRunning = true;
        dump = false;

        while (isRunning) {
            ByteCode code = program.getCode(programCounter);
            code.execute(this);

            /*if (code.getClassName().matches("DumpCode"))
                if (code.getArgs().matches("ON"))
                    dump = true;
                else
                    dump = false;*/

            if (dump)
                runStack.dump();
            
            programCounter++;
        }
    }

    public void stopRunning() {
        isRunning = false;
    }

    //----{ runStack methods }--------------------------------------------------
    public int peekRunStack() {
        return runStack.peek();
    }

    public int popRunStack() {
        return runStack.pop();
    }

    public int pushRunStack(int i) {
        return runStack.push(i);
    }

    public Integer pushRunStack(Integer i) {
        return runStack.push(i);
    }

    public int storeRunStack(int offset) {
        return runStack.store(offset);
    }

    public int loadRunStack(int offset) {
        return runStack.load(offset);
    }

    public void newRunStackFrameAt(int offset) {
        runStack.newFrameAt(offset);
    }

    public void popRunStackFrame() {
        runStack.popFrame();
    }
    public void dumpRunStack(Boolean doDump) {
        dump = doDump;
    }

    //----{ returnAddrs methods }-----------------------------------------------
    public int peekReturnAddrs() {
        return returnAddrs.peek();
    }

    public int popReturnAddrs() {
        return returnAddrs.pop();
    }

    public int pushReturnAddrs(int i) {
        return returnAddrs.push(i);
    }

    public Integer pushReturnAddrs(Integer i) {
        return returnAddrs.push(i);
    }
}
