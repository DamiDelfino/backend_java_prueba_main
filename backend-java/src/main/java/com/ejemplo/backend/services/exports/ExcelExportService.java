package com.ejemplo.backend.services.exports;

import com.ejemplo.backend.models.Causa;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

/*Este archivo hace referencia a la exportación de datos a un archivo de Excel
Desde el reporte.html para Tabla Recupero
*/ 

@Service
public class ExcelExportService {

    public byte[] exportarCausasAExcel(List<Causa> causas) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Causas");

        // Crear encabezados
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("ID");
        headerRow.createCell(1).setCellValue("Expediente");
        headerRow.createCell(2).setCellValue("LEX");
        headerRow.createCell(3).setCellValue("Delito");
        headerRow.createCell(4).setCellValue("Delito Precedente");
        headerRow.createCell(5).setCellValue("Año Inicio");
        headerRow.createCell(6).setCellValue("Año Ingreso");
        headerRow.createCell(7).setCellValue("Tipo Medida");
        headerRow.createCell(8).setCellValue("Fecha Medida");
        headerRow.createCell(9).setCellValue("Inmuebles");
        headerRow.createCell(10).setCellValue("Inmuebles Valor");
        headerRow.createCell(11).setCellValue("Tipo Vehículo");
        headerRow.createCell(12).setCellValue("Vehículo");
        headerRow.createCell(13).setCellValue("Vehículo Valor");
        headerRow.createCell(14).setCellValue("Equipo Electrónico");
        headerRow.createCell(15).setCellValue("Equipo Electrónico Valor");
        headerRow.createCell(16).setCellValue("Producto Financiero");
        headerRow.createCell(17).setCellValue("Producto Financiero Valor");
        headerRow.createCell(18).setCellValue("Pesos");
        headerRow.createCell(19).setCellValue("Dólares");
        headerRow.createCell(20).setCellValue("Euros");
        headerRow.createCell(21).setCellValue("Otras Monedas");
        headerRow.createCell(22).setCellValue("Otros");
        headerRow.createCell(23).setCellValue("Requerimiento");

        // Llenar datos
        int rowNum = 1;
        for (Causa causa : causas) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(causa.getId());
            row.createCell(1).setCellValue(causa.getExpediente());
            row.createCell(2).setCellValue(causa.getLex());
            row.createCell(3).setCellValue(causa.getDelito());
            row.createCell(4).setCellValue(causa.getDelitoPrecdedente());
            row.createCell(5).setCellValue(causa.getAnioInicio());
            row.createCell(6).setCellValue(causa.getAnioIngreso());
            row.createCell(7).setCellValue(causa.getTipoMedida());
            row.createCell(8).setCellValue(causa.getFechaMedida());
            row.createCell(9).setCellValue(causa.getInmuebles());
            row.createCell(10).setCellValue(causa.getInmueblesValor());
            row.createCell(11).setCellValue(causa.getTipoVehiculo());
            row.createCell(12).setCellValue(causa.getVehiculo());
            row.createCell(13).setCellValue(causa.getVehiculoValor());
            row.createCell(14).setCellValue(causa.getEquipoElectronico());
            row.createCell(15).setCellValue(causa.getEquipoElectronicoValor());
            row.createCell(16).setCellValue(causa.getProductoFinanciero());
            row.createCell(17).setCellValue(causa.getProductoFinancieroValor());
            row.createCell(18).setCellValue(causa.getPesos());
            row.createCell(19).setCellValue(causa.getDolares());
            row.createCell(20).setCellValue(causa.getEuros());
            row.createCell(21).setCellValue(causa.getOtrasMonedas());
            row.createCell(22).setCellValue(causa.getOtros());
            row.createCell(23).setCellValue(causa.getRequerimiento());
        }

        // Escribir a ByteArrayOutputStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        workbook.close();
        return outputStream.toByteArray();
    }
}
       