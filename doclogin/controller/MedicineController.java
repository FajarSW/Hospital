package com.hmsapp.hospitalmanagement.doclogin.controller;

import com.hmsapp.hospitalmanagement.doclogin.enity.Medicine;
import com.hmsapp.hospitalmanagement.doclogin.repository.MedicineRepository;
import com.hmsapp.hospitalmanagement.entity.Patient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.AttributeNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/v3")
public class MedicineController {

    MedicineRepository medicineRepository;

    public MedicineController(MedicineRepository medicineRepository) {
        super();
        this.medicineRepository = medicineRepository;
    }

    @PostMapping("/medicines")
    public Medicine createMedicine(@RequestBody Medicine medicine) {
        return medicineRepository.save(medicine);
    }

    @GetMapping("/medicines")
    public List<Medicine> getAllMedicine(){
        return medicineRepository.findAll();
    }

    @GetMapping("/medicines/{id}")
    public ResponseEntity<Medicine> getMedicineById(@PathVariable long id) throws AttributeNotFoundException {
        Medicine medicine = medicineRepository.findById(id)
                .orElseThrow(()-> new AttributeNotFoundException("Medicine not found by id "+id));

        return ResponseEntity.ok(medicine);
    }

    @PutMapping("/medicines/{id}")
    public ResponseEntity<Medicine> updateMedicineById(@PathVariable long id, @RequestBody Medicine medicineDetails) throws AttributeNotFoundException {
        Medicine medicine = medicineRepository.findById(id)
                .orElseThrow(() -> new AttributeNotFoundException("Medicine not found with id "+id));

        medicine.setDrugName(medicineDetails.getDrugName());
        medicine.setStock(medicineDetails.getStock());

        medicineRepository.save(medicine);

        return ResponseEntity.ok(medicine);
    }

    @DeleteMapping("/medicines/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteMedicine(@PathVariable long id) throws AttributeNotFoundException {
        Medicine medicine = medicineRepository.findById(id)
                .orElseThrow(() -> new AttributeNotFoundException("Medicine not found with id "+id));
        medicineRepository.delete(medicine);
        Map<String, Boolean> response=new HashMap<String, Boolean>();
        response.put("Delete", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }
}
