package nl.novi.vinylshop.mappers;


import nl.novi.vinylshop.dtos.profile.ProfileResponseDto;
import nl.novi.vinylshop.entities.BaseEntity;
import nl.novi.vinylshop.entities.ProfileEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProfileDTOMapper{

    public ProfileResponseDto mapToDto(ProfileEntity entity){
        ProfileResponseDto dto = new ProfileResponseDto();
        if(entity.getAlbums()!=null) {
            dto.setAlbums(entity.getAlbums()
                    .stream()
                    .map(BaseEntity::getId)
                    .toList());
        }
        dto.setId(entity.getId());
        dto.setKcid(entity.getKcid());

        return dto;
    }

    public List<ProfileResponseDto> mapToDto(List<ProfileEntity> entity){
        return entity.stream().map(this::mapToDto).toList();
    }
}
