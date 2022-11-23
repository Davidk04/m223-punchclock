package ch.zli.m223.model;

import javax.persistence.*;

import java.util.Set;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.OneToMany;

@Entity
public class Rolle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(readOnly = true)
    private Long id;

    @Column(nullable = false)
    private String titel;

    @OneToMany(mappedBy = "rolle")
    @JsonIgnore
    private Set<Benutzer> benutzer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public Set<Benutzer> getBenutzer() {
        return benutzer;
    }

    public void setBenutzer(Set<Benutzer> benutzer) {
        this.benutzer = benutzer;
    }
}
