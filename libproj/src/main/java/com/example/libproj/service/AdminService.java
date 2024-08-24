package com.example.libproj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.libproj.model.Admin;
import com.example.libproj.model.User;
import com.example.libproj.repository.AdminRepository;
import com.example.libproj.repository.UserRepository;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;
    
    
    @Autowired
    private UserRepository userRepository;

    public Admin createAdmin(Admin admin) {
        // Fetch the User entity by userId
        User user = userRepository.findById(admin.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Assign the Admin to the User
        user.setAdmin(admin);

        // Save the Admin, which will also save the User with the updated admin_id
        return adminRepository.save(admin);
    }

    public Admin updateAdmin(Long id, Admin newAdminData) {
        Optional<Admin> optionalAdmin = adminRepository.findById(id);

        if (optionalAdmin.isPresent()) {
            Admin existingAdmin = optionalAdmin.get();
            if (newAdminData.getName() != null)
                existingAdmin.setName(newAdminData.getName());
            if (newAdminData.getEmail() != null)
                existingAdmin.setEmail(newAdminData.getEmail());
            
            return adminRepository.save(existingAdmin);
        } else {
            throw new RuntimeException("Admin not found with id: " + id);
        }
    }

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Admin getAdminById(Long id) {
        return adminRepository.findById(id).orElseThrow(() -> new RuntimeException("Admin not found with id: " + id));
    }

    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }
}
