package ch.zli.m223.model;

import javax.persistence.*;

import java.util.Set;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "benutzer")
public class Benutzer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(readOnly = true)
    private Long id;

    @Column(nullable = false)
    private String vorname;

    @Column(nullable = false)
    private String nachname;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String passwort;

    @ManyToOne
    @JsonIgnore
    private Rolle rolle;

    @ManyToOne
    @JsonIgnore
    private Rang rang;

    @OneToMany(mappedBy = "benutzer")
    @JsonIgnore
    private Set<Buchung> buchung;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public Rolle getRolle() {
        return rolle;
    }

    public void setRolle(Rolle rolle) {
        this.rolle = rolle;
    }

    public Rang getRang() {
        return rang;
    }

    public void setRang(Rang rang) {
        this.rang = rang;
    }

    public Set<Buchung> getBuchung() {
        return buchung;
    }

    public void setBuchung(Set<Buchung> buchung) {
        this.buchung = buchung;
    }
}
