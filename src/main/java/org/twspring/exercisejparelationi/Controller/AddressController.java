package org.twspring.exercisejparelationi.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.twspring.exercisejparelationi.DTO.AddressDTO;
import org.twspring.exercisejparelationi.Model.Address;
import org.twspring.exercisejparelationi.Service.AddressService;

@RestController
@RequestMapping("api/v1/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @GetMapping("/get")
    public ResponseEntity getAllAddresses() {
        return ResponseEntity.status(200).body(addressService.getAllAddresses());
    }

    @PostMapping("/add")
    public ResponseEntity addAddressToTeacher(@Valid @RequestBody AddressDTO addressDTO) {
        addressService.addAddressToTeacher(addressDTO);
        return ResponseEntity.status(200).body("Address successfully added");
    }

    @PutMapping("/update")
    public ResponseEntity updateAddressToTeacher(@Valid @RequestBody AddressDTO addressDTO) {
        addressService.updateAddress(addressDTO);
        return ResponseEntity.status(200).body("Address successfully updated");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAddress(@PathVariable Integer id) {
        addressService.deleteAddress(id);
        return ResponseEntity.status(200).body("Address successfully deleted");
    }
}
