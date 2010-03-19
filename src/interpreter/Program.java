package interpreter;

import interpreter.bytecode.ByteCode;
import java.util.Vector;


public class Program {
    private int codeCount;
    private Vector<ByteCode> codes;
    private Vector<Integer> labelIndexList;

    public Program() {
        codeCount = 0;
        codes = new Vector<ByteCode>();
    }

    public void addCode(ByteCode bytecode) {
        codes.add(bytecode);
        codeCount += 1;
        String codeClass = bytecode.getClass().getName();
        if (codeClass.matches("LabelCode"))
            labelIndexList.add(codeCount);

        //System.out.println("Added Code: "+bytecode.getClass().getName());
    }

    public ByteCode getCode(int codeNum) {

        return resolveAddress(codeNum);
    }

    private ByteCode resolveAddress(int codeNum) {
        ByteCode code = codes.get(codeNum);
        String codeClass = code.getClass().getName();
        codeClass = codeClass.replaceFirst("interpreter.bytecode.", "");
        //System.out.println(codeClass);
        String label, address;

        if (codeClass.matches("FalsebranchCode|GotoCode|CallCode|ReturnCode")) {

            label = code.getArgs();
            // NOT WORKING!
            for (int index = 0; index < labelIndexList.size(); index++)
                if(label.matches(codes.get(labelIndexList.get(index)).getArgs())) {
                    address = Integer.toString(labelIndexList.get(index));
                    code.init(address);
                    index = labelIndexList.size();
                }
            
        }
        
        return code;
    }
}
