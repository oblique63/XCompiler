package interpreter;

import interpreter.bytecode.ByteCode;
import java.util.List;
import java.util.Vector;


/**
 * Produces an object containing all the actual ByteCodes specified by the original
 * file input to the ByteCodeLoader object
 * @author Enrique Gavidia
 */
public class Program {
    private int codeNum;
    private List<ByteCode> codes;
    private List<Integer> labelIndexList;

    /**
     * Starts a new program
     */
    public Program() {
        codeNum = 0;
        codes = new Vector<ByteCode>();
        labelIndexList = new Vector<Integer>();
    }

    /**
     * Adds a Bytecode object to the program
     * @param bytecode
     */
    public void addCode(ByteCode bytecode) {
        String codeName = bytecode.getName();

        // Keep track of where all the LABEL codes are located for future
        // reference when resolving addresses
        if (codeName.matches("LABEL"))
            labelIndexList.add(codeNum);

        codes.add(bytecode);
        codeNum += 1;
    }

    /**
     * Gets the Bytecode object at the location given
     * @param codeNum index of the ByteCode requested
     * @return ByteCode at the given index, with its address resolved (if necessary)
     */
    public ByteCode getCode(int codeNum) {
        return resolveAddress(codeNum);
    }

    /**
     * Used to find the specific addresses of LABELs that certain ByteCodes are
     * meant to point to
     * @param codeNum Index of the requested ByteCode
     * @return The requested ByteCode object, with the address to the LABEL it is
     *         meant to point to
     */
    private ByteCode resolveAddress(int codeNum) {
        ByteCode code = codes.get(codeNum);
        String codeName = code.getName();

        // Only resolve addresses when necessary
        if (codeName.matches("FALSEBRANCH|GOTO|CALL|RETURN")) {
            String targetLabel = code.getArgs();

            // Iterate only through the LABEL Codes in the program
            for (int labelIndex : labelIndexList) {
                String label = codes.get(labelIndex).getArgs();

                // Once the right LABEL Code is found, initiate the requested
                // bytecode again with the resolved address, and break out of
                // the loop to prevent unnecessary iteration
                if (label.matches(targetLabel)) {
                    String address = Integer.toString(labelIndex);
                    String arg = code.getArgs() + " " + address;
                    code.init(arg);
                    break;
                }
            }
        }
        
        return code;
    }
}
