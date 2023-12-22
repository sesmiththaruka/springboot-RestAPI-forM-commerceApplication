package lk.jiat.XpectWeb.service;

import jakarta.transaction.Transactional;
import lk.jiat.XpectWeb.dto.UserDTO;
import lk.jiat.XpectWeb.entity.User;
import lk.jiat.XpectWeb.repo.UserRepo;
import lk.jiat.XpectWeb.util.Varlist;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    public String saveUser(UserDTO userDTO) {
        if (userRepo.existsById(userDTO.getId())) {
            return Varlist.RSP_DULICATED;
        } else {
            userRepo.save(modelMapper.map(userDTO, User.class));
            return Varlist.RSP_SUCCESS;
        }
    }
    public String updateUser(UserDTO userDTO) {
        if (userRepo.existsById(userDTO.getId())) {
            userRepo.save(modelMapper.map(userDTO, User.class));
            return Varlist.RSP_SUCCESS;
        } else {
         return Varlist.RSP_NO_DATA_FOUND;
        }
    }

    public UserDTO getUserByUniqueId(String uniqueId) {
        User userByFirebaseUserId = userRepo.getUserByFirebaseUserId(uniqueId);
        return modelMapper.map(userByFirebaseUserId, UserDTO.class);

    }

    public void addNewUser(UserDTO userDTO){

        userRepo.save(modelMapper.map(userDTO,User.class));
    }

}
