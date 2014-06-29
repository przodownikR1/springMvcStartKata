package pl.java.borowiec.view;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogCore
 *         Creating time : 13-04-2013 17:20:38
 */
public class ExcelTestView extends AbstractExcelView {
	@Override
	protected void buildExcelDocument(@SuppressWarnings("rawtypes") Map model, HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int currentColumn = 0;
		int currentRow = 0;
		HSSFSheet sheet = workbook.createSheet("Spring Excel View");
		List<String> headerNames = (List<String>) model.get("headerNames");
		for (String headerName : headerNames) {
			HSSFCell header = getCell(sheet, currentRow, currentColumn);
			setText(header, headerName);
			currentColumn++;
		}

		List<List<Object>> rows = (List<List<Object>>) model.get("rows");
		HSSFRow row = null;
		for (List<Object> fila : rows) {
			currentRow++;
			row = sheet.createRow(currentRow);
			currentColumn = 0;
			for (Object value : fila) {
				asignarValor(row, value, currentColumn);
				currentColumn++;
			}
		}

		sheet.setDefaultColumnWidth((short) 12);
		HSSFCell cell = getCell(sheet, 0, 0);
		setText(cell, "spring - excel");
		HSSFCellStyle dateStyle = workbook.createCellStyle();
		dateStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));
		cell = getCell(sheet, 1, 0);
		cell.setCellValue(new Date());
		cell.setCellStyle(dateStyle);
	}

	private void asignarValor(HSSFRow row, Object value, int currentColumn) throws Exception {

		if (value instanceof Boolean) {
			row.createCell((short) currentColumn).setCellValue(((Boolean) value).booleanValue());

		} else if (value instanceof Calendar) {
			row.createCell((short) currentColumn).setCellValue((Calendar) value);

		} else if (value instanceof Date) {
			row.createCell((short) currentColumn).setCellValue((Date) value);

		} else if (value instanceof Double) {
			row.createCell((short) currentColumn).setCellValue(((Double) value).doubleValue());

		} else if (value instanceof String) {
			row.createCell((short) currentColumn).setCellValue(new HSSFRichTextString((String) value));

		} else
			throw new Exception("unknown type");

	}

}