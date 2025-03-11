package com.ejemplo.backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "causas")
@Getter
@Setter
public class Causa {

    // Tabla de Datos de la Causa
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String expediente;
    private String lex;
    private String delito;
    private String delitoPrecdedente;
    private int anioInicio;
    private int anioIngreso;

    // Tabla Estado Procesal
    private String estado;
    private String fecha;

    // Tabla Sentencia
    private String sentencia;
    private String tipoSentencia;
    private String sentenciaFirme;

    // Tabla de Participación de Otros Actores
    private String organismoPublicos;
    private String calidad;
    private String fiscaliasEspecializadas;

    // Tabla de Personas Fisicas
    private int imputados;
    private int procesados;
    private int suspension;
    private int sobreseidos;
    private int condenados;
    private int absueltos;

    // Tabla de Funcionarios Publicos
    private String calidadFunPublico;
    private int cantidadFunPublico;

    // Tabla de Personas Juridicas
    private String vehiculoPersJuridica;
    private String tipoPersJuridica;

    // segunda Tabla Personas Juridicas
    private String tipoPersonaJuridica;
    private int imputadoPJ;
    private int procesadoPJ;
    private int absueltoPJ;
    private int sancionadoPJ;
    private String tipoSancion;

    // Tabla de Recupero de Activos
    private String tipoMedida;
    private String fechaMedida;
    private int inmuebles;
    private int inmueblesValor;
    private String tipoVehiculo;
    private int vehiculo;
    private int vehiculoValor;

    // Tabla de Recupero de Activos - segunda parte
    private int equipoElectronico;
    private int equipoElectronicoValor;
    private int productoFinanciero;
    private int productoFinancieroValor;

    // Tabla de Recupero de Activos - tercera parte
    private int pesos;
    private int dolares;
    private int euros;
    private String otrasMonedas;
    private String otros;

    // Tabla de Cooperación
    private String tipoCooperacion;
    private String estadoCooperacion;
    private String pais;

    //Tabla archivos adjuntos
    private String observaciones;
}
