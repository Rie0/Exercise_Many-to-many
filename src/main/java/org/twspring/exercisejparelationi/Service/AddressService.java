package org.twspring.exercisejparelationi.Service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.twspring.exercisejparelationi.Api.ApiException;
import org.twspring.exercisejparelationi.DTO.AddressDTO;
import org.twspring.exercisejparelationi.Model.Address;
import org.twspring.exercisejparelationi.Model.Teacher;
import org.twspring.exercisejparelationi.Repository.AddressRepository;
import org.twspring.exercisejparelationi.Repository.TeacherRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

    public List<Address> getAllAddresses() { // can be removed/ignored, not logical
        return addressRepository.findAll();
    }

    public void addAddressToTeacher(AddressDTO addressDTO) {
        Teacher teacher=teacherRepository.findTeacherById(addressDTO.getTeacher_id());
        if (teacher==null) {
           throw new ApiException("Teacher with id "+addressDTO.getTeacher_id()+" not found");
        }

        Address address=new Address(null,addressDTO.getBuildingNumber(),addressDTO.getStreet(),addressDTO.getArea(),teacher);
        addressRepository.save(address);
    }

    public void updateAddress(AddressDTO addressDTO) {
        Address address=addressRepository.findAddressById(addressDTO.getTeacher_id());
        if (address==null) {
            throw new ApiException("Address with id "+addressDTO.getTeacher_id()+" not found");
        }
        address.setBuildingNumber(addressDTO.getBuildingNumber());
        address.setStreet(addressDTO.getStreet());
        address.setArea(addressDTO.getArea());
        addressRepository.save(address);
    }

    public void deleteAddress(Integer id) {//
        Teacher teacher=teacherRepository.findTeacherById(id);
        if (teacher==null) {
            throw new ApiException("Address with id "+id+" not found");
        }
        Address address=addressRepository.findAddressById(id);
        teacher.setAddress(null);
        teacherRepository.save(teacher);
        addressRepository.delete(address);
    }

}
