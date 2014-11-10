package util.function;

import java.util.*;

import util.common.*;

public class CreateColList {
	
	public static void CreateCol(List<Map<String, String>> columnlist, List<String> ColList) {
		for (Map<String, String> c : columnlist){
			ColList.add(c.get(ColumnNames.COLUMN_NAME).toString());
		}
	}

}
