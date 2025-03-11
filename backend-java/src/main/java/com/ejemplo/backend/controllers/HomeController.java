package com.ejemplo.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.ejemplo.backend.models.Causa;
import com.ejemplo.backend.services.CausaService;
import org.springframework.ui.Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

      @Autowired
    private CausaService causaService;

    @GetMapping("/")
    public String mostrarInicio(){
        return "inicio";
    }
    @GetMapping("/inicio")
    public String mostrarLogin(){
        return "inicio";
    }

    @GetMapping("/principal")
    public String mostrarPrincipal() {
        return "principal";  //
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

    @GetMapping("/form")
    public String mostrarFormulario() {
        return "form";
    }
    
    @GetMapping("/admin")
    public String mostrarAdmin(){
        return "admin";
    }    
        
    @GetMapping("/menu")
    public String mostrarMenu(Model model){
         
        List<Causa> causas = causaService.obtenerTodas();
        model.addAttribute("causas", causas);
        

        return "menu";
    }
 

    @GetMapping("/nuevo")
    public String mostrarNuevo(Model model) {
        model.addAttribute("causa", new Causa());
        return "nuevo";
    }
   

    @ExceptionHandler(Exception.class)
    public String handleError(Exception e) {
        return "error";  // Asegúrate de tener una página de error configurada
    }

    @GetMapping("/popup")
    public String mostrarPopup() {
        return "popup";  
    }
    @GetMapping("/reporte")
    public String mostrarReporte(){
        return "reporte";
    }
    @GetMapping("/reqAutoridades")
    public String mostrarReqAutoridades(){
        return "reqAutoridades";
    }
     @GetMapping("/requerimiento")
    public String mostrarRequerimiento(){
        return "requerimiento";
    }
    @GetMapping("/seguimiento")
    public String mostrarSeguimiento(){
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
            causa.setFecha(fechaFormateada); // Guardar la fecha en el objeto causa
    
            // Guardar causa en la base de datos
            causaService.guardarCausa(causa);
    
            return "redirect:/menu";
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
        return "nuevo"; // Se reutiliza la vista
    }
}
