package nl.novi.vinylshop.dtos.profile;

import java.util.List;

public class ProfileResponseDto {
    private Long id;
    private String kcid;
    private List<Long> albums;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKcid() {
        return kcid;
    }

    public void setKcid(String kcid) {
        this.kcid = kcid;
    }

    public List<Long> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Long> albums) {
        this.albums = albums;
    }
}