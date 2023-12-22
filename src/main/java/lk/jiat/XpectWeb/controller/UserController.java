package lk.jiat.XpectWeb.controller;

import lk.jiat.XpectWeb.dto.ResponseDTO;
import lk.jiat.XpectWeb.dto.UserDTO;
import lk.jiat.XpectWeb.service.UserService;
import lk.jiat.XpectWeb.util.Varlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private ResponseDTO responseDTO;
    @Autowired
    private UserService userService;

    @PostMapping("/saveuser")
    public ResponseEntity saveUser(@RequestBody UserDTO userDTO) {
        try {

            String res = userService.saveUser(userDTO);
            responseDTO.setCode(Varlist.RSP_SUCCESS);
            responseDTO.setMessage("Success");
            responseDTO.setContent(userDTO);
            return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

        } catch (Exception ex) {

            responseDTO.setCode(Varlist.RSP_FAIL);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
    @PostMapping("/addnewuser")
     public void addNewUserByFirebaseUniqueId(@RequestBody UserDTO userDTO){
        userService.addNewUser(userDTO);
     }

    @PostMapping("/updateuser")
    public void updateUser(@RequestBody UserDTO userDTO) {
        userService.updateUser(userDTO);
    }

    @GetMapping("/getUserByUniqueId/{userId}")
    public UserDTO getUserByUniqueId(@PathVariable String userId) {
        return userService.getUserByUniqueId(userId);
    }

}
