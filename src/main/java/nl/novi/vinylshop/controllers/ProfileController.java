package nl.novi.vinylshop.controllers;

import nl.novi.vinylshop.dtos.album.AlbumResponseDTO;
import nl.novi.vinylshop.dtos.profile.ProfileAlbumRequestDto;
import nl.novi.vinylshop.dtos.profile.ProfileResponseDto;
import nl.novi.vinylshop.services.ProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController()
@RequestMapping("/profiles")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {this.profileService = profileService;}

    @GetMapping()
    public ResponseEntity<List<ProfileResponseDto>> getProfiles(Authentication authentication) {

        Set<String> authorities = AuthorityUtils.authorityListToSet(authentication.getAuthorities());;

        if(authorities.contains("ROLE_ADMIN")){
            List<ProfileResponseDto> profileDtos = profileService.findAllProfiles();
            return ResponseEntity.ok(profileDtos);
        } else if (authorities.contains("ROLE_USER")){
            ProfileResponseDto profileDto = profileService.findOrCreateProfile(authentication);
            return ResponseEntity.ok(List.of(profileDto));
        } else {
            return ResponseEntity.status(403).build();
        }

    }

    @GetMapping("/albums")
    public ResponseEntity<List<AlbumResponseDTO>> getAlbum(Authentication authentication){
        String kcid = authentication.getName();
        return ResponseEntity.ok(profileService.getAlbumForProfile(kcid));
    }

    @PostMapping("/albums")
    public ResponseEntity<Void> linkAlbum(Authentication authentication, @RequestBody ProfileAlbumRequestDto dto){
        profileService.linkAlbum(authentication, dto.getAlbumId());
        return ResponseEntity.ok().build();
    }
}
