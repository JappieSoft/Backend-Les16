package nl.novi.vinylshop.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "profiles")
public class ProfileEntity extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String kcid;

    @ManyToMany
    List<AlbumEntity> albums = new ArrayList<>();

    public String getKcid() {
        return kcid;
    }

    public void setKcid(String kcid) {
        this.kcid = kcid;
    }

    public List<AlbumEntity> getAlbums() {
        return albums;
    }

    public void setAlbums(List<AlbumEntity> albums) {
        this.albums = albums;
    }
}