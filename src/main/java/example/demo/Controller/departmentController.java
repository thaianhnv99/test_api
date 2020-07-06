package example.demo.Controller;

import example.demo.Entity.department;
import example.demo.Services.departmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("")
public class departmentController {

    @Autowired
    private departmentServices departmentServices;

    @RequestMapping(value = "/department", method = RequestMethod.GET)
    public ResponseEntity<List<department>> findAll() {
        return new ResponseEntity<>(departmentServices.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/department", method = RequestMethod.POST)
    public ResponseEntity<department> findById(@RequestBody department department) {
        department department1 = new department();
        department1 = departmentServices.findById(department.getId());
        return new ResponseEntity<>(department1, HttpStatus.OK);
    }

    @RequestMapping(value = "/createDepartment", method = RequestMethod.POST)
    public ResponseEntity<department> createDe(@RequestBody department department) {
        department de = new department();
        de = departmentServices.createDe(department);
        return new ResponseEntity<>(de, HttpStatus.OK);
    }

    @RequestMapping(value = "/department", method = RequestMethod.PUT)
    public boolean updateDe(@RequestBody department department) {
        boolean isUpdated = false;
        isUpdated = departmentServices.updateDe(department);
        return isUpdated;
    }

    @RequestMapping(value = "/deleteDepartment", method = RequestMethod.POST)
    public boolean deleteDe(@RequestBody department department) {
        return departmentServices.deleteDe(department);
    }
}
