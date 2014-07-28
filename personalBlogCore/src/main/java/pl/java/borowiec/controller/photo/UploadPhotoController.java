package pl.java.borowiec.controller.photo;

import java.time.ZonedDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
//TODO test
public class UploadPhotoController {
    
    @RequestMapping(value = "/api/photos", method = RequestMethod.POST)
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<?> createGalleryPicture( @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")final ZonedDateTime takenOn,@RequestParam("imageData")final MultipartFile imageData)
    {
      return new ResponseEntity<>(HttpStatus.OK);
    }

}
