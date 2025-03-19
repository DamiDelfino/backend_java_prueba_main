package com.ejemplo.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ejemplo.backend.services.exports.ExcelExportService; // Importa tu servicio de exportación
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import com.ejemplo.backend.models.Causa;
import com.ejemplo.backend.services.CausaService;
import org.springframework.ui.Model;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
        private CausaService causaService;
    
        @GetMapping("/")
        public String mostrarInicio() {
            return "inicio";
        }
    
        @GetMapping("/inicio")
        public String mostrarLogin() {
            return "inicio";
        }
    
        @GetMapping("/principal")
        public String mostrarPrincipal() {
            return "principal"; //
        }
    
        @GetMapping("/notificaciones")
        public String mostrarNotificaciones() {
            return "notificaciones";
        }
    
        @GetMapping("/estadistica")
        public String mostrarEstadistica() {
            return "estadistica";
        }
    
        @GetMapping("/modificar")
        public String mostrarModificar() {
            return "modificar";
        }
        @GetMapping("/modificarEjemplo")
        public String mostrarModificarEjemplo() {
            return "modificarEjemplo";
        }
    
        @GetMapping("/form")
        public String mostrarFormulario() {
            return "form";
        }
    
        @GetMapping("/admin")
        public String mostrarAdmin(Model model) {
            List<Causa> causas = causaService.obtenerTodas();
            System.out.println("Causas obtenidas: " + causas);
            for (Causa causa : causas) {
                System.out.println("Expediente: " + causa.getExpediente() + ", Delito: " + causa.getDelito()
                        + ",expediente: " + causa.getExpediente() + ", Fecha Admin: " + causa.getFechaAdmin()
                        + "Requerimiento: " + causa.getRequerimiento());
                model.addAttribute("causas", causas);
            }
            return "admin";
        }
    
        @GetMapping("/menu")
        public String mostrarMenu(Model model) {
            List<Causa> causas = causaService.obtenerTodas();
            model.addAttribute("causas", causas);
            return "menu";
        }
    
        @GetMapping("/nuevo")
        public String mostrarNuevo(Model model) {
            model.addAttribute("causa", new Causa());
            return "nuevo";
        }
    
    
        @GetMapping("/formV")
        public String mostrarNuevoAdmin(Model model) {
            model.addAttribute("causa", new Causa());
            return "formV";
        }
        
    
        @ExceptionHandler(Exception.class)
        public String handleError(Exception e) {
            return "error"; // Asegúrate de tener una página de error configurada
        }
    
        @GetMapping("/popup")
        public String mostrarPopup() {
            return "popup";
        }
    
       
    
        @GetMapping("/reqAutoridades")
        public String mostrarReqAutoridades() {
            return "reqAutoridades";
        }
    
        @GetMapping("/requerimiento")
        public String mostrarRequerimiento() {
            return "requerimiento";
        }
    
        @GetMapping("/seguimiento")
        public String mostrarSeguimiento() {
            return "seguimiento";
        }
    
        @PostMapping("/guardar")
        public String guardarCausa(@ModelAttribute Causa causa, Model model) {
            try {
                // Convertir la fecha de yyyy-MM-dd a dd/MM/yyyy
                SimpleDateFormat formatoEntrada = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat formatoSalida = new SimpleDateFormat("dd/MM/yyyy");
    
                String fechaString = causa.getFecha(); // Fecha recibida en formato yyyy-MM-dd
                Date fecha = formatoEntrada.parse(fechaString); // Convertir la cadena de fecha a objeto Date
    
                // Convertir a formato dd/MM/yyyy para guardarlo en la base de datos
                String fechaFormateada = formatoSalida.format(fecha);
                causa.setFecha(fechaFormateada); // Guardar la fecha original en el objeto causa
    
                // Obtener fecha de hoy para la columna 'fechaAdmin'
                LocalDate fechaHoy = LocalDate.now();
                causa.setFechaAdmin(fechaHoy.toString()); // Guardar la fecha de hoy en fechaAdmin
    
                // Verificar el delito y asignar el requerimiento adecuado
                String requerimiento = "OCDE"; // Valor predeterminado
                if ("Lavado de Activos (Arts. 303 y 304 CPN)".equals(causa.getDelito())) {
                    requerimiento = "GAFI";
                }
                causa.setRequerimiento(requerimiento);
    
                // Guardar causa en la base de datos
                causaService.guardarCausa(causa);
    
                // Pasar la información a la vista de Admin
                model.addAttribute("expediente", causa.getExpediente());
                model.addAttribute("fechaAdmin", fechaHoy);
                model.addAttribute("estado", "En Revisión");
                model.addAttribute("autoridad", "Juzgado 4");
                model.addAttribute("requerimiento", requerimiento);
    
                return "redirect:/menu"; // Redirigir para mostrar la lista actualizada
            } catch (ParseException e) {
                // Manejar el error si la fecha no está en el formato correcto
                model.addAttribute("error", "Formato de fecha inválido.");
                return "nuevo"; // Redirigir de vuelta al formulario
            }
        }
    
        @GetMapping("/editar/{id}")
        public String editarCausa(@PathVariable Long id, Model model) {
            Causa causa = causaService.obtenerPorId(id).orElse(null);
            model.addAttribute("causa", causa);
            return "modificar"; // Se reutiliza la vista
        }
        @GetMapping("/editarAdmin/{id}")
        public String editarCausaAdmin(@PathVariable Long id, Model model) {
            Causa causa = causaService.obtenerPorId(id).orElse(null);
            model.addAttribute("causa", causa);
            return "formV"; // Se reutiliza la vista
        }
    
    
        @Autowired
        private ExcelExportService excelExportService;
    
       
    
        @GetMapping("/reporte")
        public String mostrarReporte(Model model) {
            List<Causa> causasGafi = causaService.obtenerPorRequerimiento("GAFI");
            List<Causa> causasOcde = causaService.obtenerPorRequerimiento("OCDE");
            model.addAttribute("causasGafi", causasGafi);
            model.addAttribute("causasOcde", causasOcde);
            return "reporte";
        }
    
        @GetMapping("/exportar-excel-gafi")
        public ResponseEntity<byte[]> exportarExcelGafi() {
            try {
                List<Causa> causasGafi = causaService.obtenerPorRequerimiento("GAFI");
                return generarResponseEntity(causasGafi, "causas-gafi.xlsx");
            } catch (IOException e) {
                e.printStackTrace();
                return ResponseEntity.status(500).body(null);
            }
        }
    
        @GetMapping("/exportar-excel-ocde")
        public ResponseEntity<byte[]> exportarExcelOcde() {
            try {
                List<Causa> causasOcde = causaService.obtenerPorRequerimiento("OCDE");
                return generarResponseEntity(causasOcde, "causas-ocde.xlsx");
            } catch (IOException e) {
                e.printStackTrace();
                return ResponseEntity.status(500).body(null);
            }
        }
    
        private ResponseEntity<byte[]> generarResponseEntity(List<Causa> causas, String nombreArchivo) throws IOException {
            byte[] excelBytes = excelExportService.exportarCausasAExcel(causas);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", nombreArchivo);
            return ResponseEntity.ok().headers(headers).body(excelBytes);
        }
    }
