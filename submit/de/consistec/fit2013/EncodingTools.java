package de.consistec.fit2013;

import java.util.HashMap;

public class EncodingTools {

	
	private static HashMap<Integer,Integer> lowerToUpperCase = new HashMap<Integer,Integer>();
	private static HashMap<Integer,Integer> upperToLowerCase = new HashMap<Integer,Integer>();
		
	
	public static int getMapping(int inValue)
	{
		int toReturn = -1;
		
		if(lowerToUpperCase.isEmpty() || upperToLowerCase.isEmpty())
		{
			initHashMaps();
		}
		
		if(isUpperCase(inValue))
		{
			toReturn = upperToLowerCase.get(inValue);
		}
		else if(isLowerCase(inValue))
		{
			toReturn = lowerToUpperCase.get(inValue);
		}
		else
		{
			toReturn = inValue;
		}
		
		return toReturn;
	}
		
	private static void initHashMaps()
	{
		lowerToUpperCase.put(97, 78);
		lowerToUpperCase.put(98, 65);
		lowerToUpperCase.put(99, 66);
		lowerToUpperCase.put(100, 67);
		lowerToUpperCase.put(101, 68);
		lowerToUpperCase.put(102, 69);
		lowerToUpperCase.put(103, 70);
		lowerToUpperCase.put(104, 71);
		lowerToUpperCase.put(105, 72);
		lowerToUpperCase.put(106, 73);
		lowerToUpperCase.put(107, 74);
		lowerToUpperCase.put(108, 75);
		lowerToUpperCase.put(109, 76);
		lowerToUpperCase.put(110, 77);
		lowerToUpperCase.put(111, 80);
		lowerToUpperCase.put(112, 81);
		lowerToUpperCase.put(113, 82);
		lowerToUpperCase.put(114, 83);
		lowerToUpperCase.put(115, 84);
		lowerToUpperCase.put(116, 85);
		lowerToUpperCase.put(117, 86);
		lowerToUpperCase.put(118, 87);
		lowerToUpperCase.put(119, 88);
		lowerToUpperCase.put(120, 89);
		lowerToUpperCase.put(121, 90);
		lowerToUpperCase.put(122, 79);
		
		upperToLowerCase.put(65, 109);
		upperToLowerCase.put(66, 110);
		upperToLowerCase.put(67, 97);
		upperToLowerCase.put(68, 98);
		upperToLowerCase.put(69, 99);
		upperToLowerCase.put(70, 100);
		upperToLowerCase.put(71, 101);
		upperToLowerCase.put(72, 102);
		upperToLowerCase.put(73, 103);
		upperToLowerCase.put(74, 104);
		upperToLowerCase.put(75, 105);
		upperToLowerCase.put(76, 106);
		upperToLowerCase.put(77, 107);
		upperToLowerCase.put(78, 108);
		upperToLowerCase.put(79, 113);
		upperToLowerCase.put(80, 114);
		upperToLowerCase.put(81, 115);
		upperToLowerCase.put(82, 116);
		upperToLowerCase.put(83, 117);
		upperToLowerCase.put(84, 118);
		upperToLowerCase.put(85, 119);
		upperToLowerCase.put(86, 120);
		upperToLowerCase.put(87, 121);
		upperToLowerCase.put(88, 122);
		upperToLowerCase.put(89, 111);
		upperToLowerCase.put(90, 112);
		
	}
	
	private static boolean isUpperCase(int inByte)
	{
		boolean toReturn = false;
		
		if(inByte <= 90 && inByte >= 65)
		{
			toReturn = true;
		}
		
		return toReturn;
	}

	private static boolean isLowerCase(int inByte)
	{
		boolean toReturn = false;
		
		if(inByte <= 122 && inByte >= 97)
		{
			toReturn = true;
		}
		
		return toReturn;
	}
}
