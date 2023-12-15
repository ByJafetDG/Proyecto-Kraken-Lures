package com.programacionIV.proyectoFinal.api;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.programacionIV.proyectoFinal.entidades.PedidoLinea;
import com.programacionIV.proyectoFinal.servicios.PedidoLineaServicio;

@RestController
public class PedidoLineaController {

    private final PedidoLineaServicio pedidoLineaServicio;

    public PedidoLineaController(PedidoLineaServicio pedidoLineaServicio) {
        this.pedidoLineaServicio = pedidoLineaServicio;
    }

    @GetMapping(path = "/pedidosLinea", produces = "application/json")
    public Page<PedidoLinea> listadoPedidosLinea(@PageableDefault(sort = "linea", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<PedidoLinea> consultarPedidosLinea = pedidoLineaServicio.obtenerLineasDePedidoPaginadas(pageable);
        return consultarPedidosLinea;
    }

    @GetMapping(path = "/pedidosLinea/filteredById", produces = "application/json")
    public Page<PedidoLinea> listadoPedidosLineaFilteredId(@RequestParam(name = "linea", required = true) List<Integer> linea,
                                                           @PageableDefault(sort = "linea", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<PedidoLinea> consultaPedidosLineaId = pedidoLineaServicio.obtenerLineasDePedidoFiltradasPorId(linea, pageable);
        return consultaPedidosLineaId;
    }
}
