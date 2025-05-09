package org.uv.DAPP01Practica05;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@Table(name = "clientes")
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clientes_clave_seq")
    @SequenceGenerator(name = "clientes_clave_seq", sequenceName = "clientes_clave_seq",
            initialValue = 1, allocationSize = 1)
    @Column
    private Long id;
    
    @Column
    private String nombre;
    
//    @JsonIgnore
//    @OneToMany(mappedBy = "clientes", fetch = FetchType.LAZY,cascade = CascadeType.ALL, orphanRemoval = false)
//    private List<Venta> lstVenta;
//
//    public List<Venta> getLstVenta() {
//        return lstVenta;
//    }
//
//    public void setLstVenta(List<Venta> lstVenta) {
//        this.lstVenta = lstVenta;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
