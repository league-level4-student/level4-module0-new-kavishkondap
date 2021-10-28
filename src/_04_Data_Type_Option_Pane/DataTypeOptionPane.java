package _04_Data_Type_Option_Pane;

import javax.swing.JOptionPane;

public class DataTypeOptionPane {
    public static void main(String[] args) {

        DataType[] dataTypes = DataType.values ();
        int dataType = JOptionPane.showOptionDialog (null, "Which data type would you like to learn about", "DATA TYPES", JOptionPane.CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, dataTypes, null);
        
        
        switch (dataType) {
        case 0:
        	JOptionPane.showMessageDialog (null, "Integer Value, " + DataType.BYTE.getBits());
        	break;
        case 1:
        	JOptionPane.showMessageDialog (null, "Unicode character, " + DataType.CHAR.getBits());
        	break;
        case 2:
        	JOptionPane.showMessageDialog (null, "Integer value, " + DataType.SHORT.getBits());
        	break;
        case 3:
        	JOptionPane.showMessageDialog (null, "Integer value, " + DataType.INT.getBits());
        	break;
        case 4:
        	JOptionPane.showMessageDialog (null, "Integer value, " + DataType.LONG.getBits());
        	break;
        case 5:
        	JOptionPane.showMessageDialog (null, "Decimal value, " + DataType.FLOAT.getBits());
        	break;
        case 6:
        	JOptionPane.showMessageDialog (null, "Decimal value, " + DataType.DOUBLE.getBits());
        	break;
        case 7:
        	JOptionPane.showMessageDialog (null, "True/False value, " + DataType.BOOLEAN.getBits());
        	break;
        default:
        	JOptionPane.showMessageDialog (null, "ERROR");
        	break;
        }
   
}

enum DataType {
	BYTE (8), SHORT (16), INT (32), LONG (64), FLOAT (32), DOUBLE (64), BOOLEAN (1), CHAR (16);
	
	private final int bits;
	
	private DataType (int bits){
		this.bits = bits;
	}
	public int getBits () {
		return bits;
	}
}
}

