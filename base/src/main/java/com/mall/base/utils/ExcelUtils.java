package com.mall.base.utils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;

import com.mall.base.utils.support.excel.DataRow;
import org.apache.commons.lang3.Validate;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ClassPathResource;


/**
 * excel工具类
 * 
 * @author Cobain
 *
 */
public class ExcelUtils {

	private ExcelUtils() {
	}

	/**
	 * 读取excel
	 * 
	 */
	public void readExcel() {
	}

	/**
	 * 写入excel
	 * 
	 * @return
	 * 
	 */
	public static final byte[] toExcel(String path, String sheetName, List<DataRow> list) throws Exception {
		Validate.isTrue(StringUtils.isNotBlank(path));
		Validate.isTrue(StringUtils.endsWith(path, ".xls") || StringUtils.endsWith(path, ".xlsx"));
		/*Validate.isTrue(CollectionUtils.isNotEmpty(list));*/
		ClassPathResource resource = new ClassPathResource(path);
		Validate.isTrue(resource.exists());

		Workbook workbook = null;
		try (InputStream is = resource.getInputStream(); ByteArrayOutputStream os = new ByteArrayOutputStream();) {
			if (StringUtils.endsWith(path, ".xls")) {
				workbook = new HSSFWorkbook(is);
			} else if (StringUtils.endsWith(path, ".xlsx")) {
				workbook = new XSSFWorkbook(is);
			}
			
			Sheet sheet = workbook.getSheetAt(0);
			if (StringUtils.isNotBlank(sheetName)) {
				workbook.setSheetName(0, sheetName);
			}
			int index = 1;
			for (DataRow data : list) {
				Row row = sheet.createRow(index++);
				if (StringUtils.isNotBlank(data.getCell01())) {
					Cell cell = row.createCell(0);
					cell.setCellType(CellType.STRING);
					cell.setCellValue(data.getCell01());
				}
				if (StringUtils.isNotBlank(data.getCell02())) {
					Cell cell = row.createCell(1);
					cell.setCellType(CellType.STRING);
					cell.setCellValue(data.getCell02());
				}
				if (StringUtils.isNotBlank(data.getCell03())) {
					Cell cell = row.createCell(2);
					cell.setCellType(CellType.STRING);
					cell.setCellValue(data.getCell03());
				}
				if (StringUtils.isNotBlank(data.getCell04())) {
					Cell cell = row.createCell(3);
					cell.setCellType(CellType.STRING);
					cell.setCellValue(data.getCell04());
				}
				if (StringUtils.isNotBlank(data.getCell05())) {
					Cell cell = row.createCell(4);
					cell.setCellType(CellType.STRING);
					cell.setCellValue(data.getCell05());
				}
				if (StringUtils.isNotBlank(data.getCell06())) {
					Cell cell = row.createCell(5);
					cell.setCellType(CellType.STRING);
					cell.setCellValue(data.getCell06());
				}
				if (StringUtils.isNotBlank(data.getCell07())) {
					Cell cell = row.createCell(6);
					cell.setCellType(CellType.STRING);
					cell.setCellValue(data.getCell07());
				}
				if (StringUtils.isNotBlank(data.getCell08())) {
					Cell cell = row.createCell(7);
					cell.setCellType(CellType.STRING);
					cell.setCellValue(data.getCell08());
				}
				if (StringUtils.isNotBlank(data.getCell09())) {
					Cell cell = row.createCell(8);
					cell.setCellType(CellType.STRING);
					cell.setCellValue(data.getCell09());
				}
				if (StringUtils.isNotBlank(data.getCell10())) {
					Cell cell = row.createCell(9);
					cell.setCellType(CellType.STRING);
					cell.setCellValue(data.getCell10());
				}
				if (StringUtils.isNotBlank(data.getCell11())) {
					Cell cell = row.createCell(10);
					cell.setCellType(CellType.STRING);
					cell.setCellValue(data.getCell11());
				}
				if (StringUtils.isNotBlank(data.getCell12())) {
					Cell cell = row.createCell(11);
					cell.setCellType(CellType.STRING);
					cell.setCellValue(data.getCell12());
				}
				if (StringUtils.isNotBlank(data.getCell13())) {
					Cell cell = row.createCell(12);
					cell.setCellType(CellType.STRING);
					cell.setCellValue(data.getCell13());
				}
				if (StringUtils.isNotBlank(data.getCell14())) {
					Cell cell = row.createCell(13);
					cell.setCellType(CellType.STRING);
					cell.setCellValue(data.getCell14());
				}
				if (StringUtils.isNotBlank(data.getCell15())) {
					Cell cell = row.createCell(14);
					cell.setCellType(CellType.STRING);
					cell.setCellValue(data.getCell15());
				}
				if (StringUtils.isNotBlank(data.getCell16())) {
					Cell cell = row.createCell(15);
					cell.setCellType(CellType.STRING);
					cell.setCellValue(data.getCell16());
				}
				if (StringUtils.isNotBlank(data.getCell17())) {
					Cell cell = row.createCell(16);
					cell.setCellType(CellType.STRING);
					cell.setCellValue(data.getCell17());
				}
				if (StringUtils.isNotBlank(data.getCell18())) {
					Cell cell = row.createCell(17);
					cell.setCellType(CellType.STRING);
					cell.setCellValue(data.getCell18());
				}
				if (StringUtils.isNotBlank(data.getCell19())) {
					Cell cell = row.createCell(18);
					cell.setCellType(CellType.STRING);
					cell.setCellValue(data.getCell19());
				}
				if (StringUtils.isNotBlank(data.getCell20())) {
					Cell cell = row.createCell(19);
					cell.setCellType(CellType.STRING);
					cell.setCellValue(data.getCell20());
				}
				if (StringUtils.isNotBlank(data.getCell21())) {
					Cell cell = row.createCell(20);
					cell.setCellType(CellType.STRING);
					cell.setCellValue(data.getCell21());
				}
				if (StringUtils.isNotBlank(data.getCell22())) {
					Cell cell = row.createCell(21);
					cell.setCellType(CellType.STRING);
					cell.setCellValue(data.getCell22());
				}
				if (StringUtils.isNotBlank(data.getCell23())) {
					Cell cell = row.createCell(22);
					cell.setCellType(CellType.STRING);
					cell.setCellValue(data.getCell23());
				}
				if (StringUtils.isNotBlank(data.getCell24())) {
					Cell cell = row.createCell(23);
					cell.setCellType(CellType.STRING);
					cell.setCellValue(data.getCell24());
				}
				if (StringUtils.isNotBlank(data.getCell25())) {
					Cell cell = row.createCell(24);
					cell.setCellType(CellType.STRING);
					cell.setCellValue(data.getCell25());
				}
				if (StringUtils.isNotBlank(data.getCell26())) {
					Cell cell = row.createCell(25);
					cell.setCellType(CellType.STRING);
					cell.setCellValue(data.getCell26());
				}
				if (StringUtils.isNotBlank(data.getCell27())) {
					Cell cell = row.createCell(26);
					cell.setCellType(CellType.STRING);
					cell.setCellValue(data.getCell27());
				}
				if (StringUtils.isNotBlank(data.getCell28())) {
					Cell cell = row.createCell(27);
					cell.setCellType(CellType.STRING);
					cell.setCellValue(data.getCell28());
				}
				if (StringUtils.isNotBlank(data.getCell29())) {
					Cell cell = row.createCell(28);
					cell.setCellType(CellType.STRING);
					cell.setCellValue(data.getCell29());
				}
				if (StringUtils.isNotBlank(data.getCell30())) {
					Cell cell = row.createCell(29);
					cell.setCellType(CellType.STRING);
					cell.setCellValue(data.getCell30());
				}
			}
			workbook.write(os);
			return os.toByteArray();
		} finally {
			if (workbook != null) {
				workbook.close();
			}
		}
	}

}
