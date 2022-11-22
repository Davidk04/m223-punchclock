package ch.zli.m223.model;

import javax.persistence.*;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Buchung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(readOnly = true)
    private Long id;

    @Column(nullable = false)
    private Boolean status;

    @Column(nullable = false)
    private Boolean halbtag;

    @Column(nullable = false)
    private Boolean stornieren;

    @ManyToOne
    @JsonIgnore
    private Benutzer benutzer;

    @ManyToOne
    @JsonIgnore
    private Raum raum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getHalbtag() {
        return halbtag;
    }

    public void setHalbtag(Boolean halbtag) {
        this.halbtag = halbtag;
    }

    public Boolean getStornieren() {
        return stornieren;
    }

    public void setStornieren(Boolean stornieren) {
        this.stornieren = stornieren;
    }

    public Benutzer getBenutzer() {
        return benutzer;
    }

    public void setBenutzer(Benutzer benutzer) {
        this.benutzer = benutzer;
    }

    public Raum getRaum() {
        return raum;
    }

    public void setRaum(Raum raum) {
        this.raum = raum;
    }
}
