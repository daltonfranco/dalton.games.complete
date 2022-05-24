package application.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
//import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
//import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.Set;
import java.util.HashSet;
@Entity
@Table(name="jogos")
public class Jogo {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String titulo;

    @ManyToMany(mappedBy = "id_generos")
    private Genero genero;

    @ManyToMany
    @JoinTable(
        name = "jogos_possuem_plataformas",
        joinColumns = @JoinColumn(name="plataformas_id"),
        inverseJoinColumns=@JoinColumn(name="plataformas_id")
    )

    private Set<Plataforma> plataformas = new HashSet<>();

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return this.id;
    }
    public Genero getGenero() {
        return genero;
    }
    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getTitulo(){
        return this.titulo;
    }
    public Set<Plataforma> getPlataformas() {
        return plataformas;
    }
    public void setPlataformas(Set<Plataforma> plataformas) {
        this.plataformas = plataformas;
    }
    
}