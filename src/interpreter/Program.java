package interpreter;

import interpreter.bytecode.ByteCode;
import interpreter.bytecode.LabelCode;
import java.util.Vector;


public class Program {
    private int codeNum;
    private Vector<ByteCode> codes;
    private Vector<Integer> labelIndexList;

    public Program() {
        codeNum = 0;
        codes = new Vector<ByteCode>();
        labelIndexList = new Vector<Integer>();
    }

    public void addCode(ByteCode bytecode) {
        codes.add(bytecode);

        String codeClass = bytecode.getClassName(); //bytecode.getClass().getName().replaceFirst("interpreter.bytecode.", "");
        // Keep track of where all the LABEL codes are located
        if (codeClass.matches("LabelCode"))
            labelIndexList.add(codeNum);

        codeNum += 1;
    }

    public ByteCode getCode(int codeNum) {

        return resolveAddress(codeNum);
    }

    private ByteCode resolveAddress(int codeNum) {
        ByteCode code = codes.get(codeNum);
        String codeClass = code.getClassName(); //code.getClass().getName().replaceFirst("interpreter.bytecode.", "");
        String label, address;

        if (codeClass.matches("FalsebranchCode|GotoCode|CallCode|ReturnCode")) {
            label = code.getArgs();

            for (int index = 0; index < labelIndexList.size(); index++) {
                String targetLabel = codes.get(labelIndexList.get(index)).getArgs();

                if(label.matches(targetLabel)) {
                    address = Integer.toString(labelIndexList.get(index));
                    code.init(address);
                    break;
                }
            }
        }
        
        return code;
    }
}
