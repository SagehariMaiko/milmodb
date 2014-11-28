package controllers.milmodb;

import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.List;
import java.util.Map;

import util.common.ColumnNames;
import util.common.Fixed;
import util.function.CommonFunc;

public class Converter {

	public static List<Map<String, String>> datalist;
	public static List<Map<String, String>> columnlist;

	public Converter(List<Map<String, String>> datalist
			,List<Map<String, String>> columnlist) {
		super();
		this.datalist = datalist;
		this.columnlist = columnlist;
	}

	public List<Map<String, String>> isCovert() {
		List<Map<String, String>> newdatalist = this.datalist;
		for ( Map<String, String> c : columnlist){
			String cv = c.get(ColumnNames.CONV_LIST);
			for(int i=0;cv != null && i < cv.length();i++){
				ConverterEnum.converts(String.valueOf(cv.charAt(i)), newdatalist, c.get(ColumnNames.COLUMN_NAME));
			}
		}
		return newdatalist;
	}
}
