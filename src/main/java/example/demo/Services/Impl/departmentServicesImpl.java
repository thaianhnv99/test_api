package example.demo.Services.Impl;

import example.demo.Entity.department;
import example.demo.Repository.departmentRepository;
import example.demo.Services.departmentServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class departmentServicesImpl implements departmentServices {
    Logger logger = LoggerFactory.getLogger(departmentServicesImpl.class);
    @Autowired
    private departmentRepository departmentRepository;

    @Override
    public List<department> findAll() {
        List<department> listDe = new ArrayList<>();
        listDe = departmentRepository.findAll();
        return listDe;
    }

    @Override
    public department findById(int id) {
        department department = new department();
        department = departmentRepository.findById(id);
        return department;
    }

    @Override
    public department createDe(department department) {
        try {
            department department1 = new department();
            department1 = departmentRepository.findById(department.getId());
            if (department1 == null) {
                departmentRepository.save(department);
                return department;
            } else {
                return null;
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public boolean updateDe(department department) {
        try {
            if (department != null && departmentRepository.existsById(department.getId())) {
                departmentRepository.save(department);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return false;
    }

    @Override
    public boolean deleteDe(department department) {
        try {
            department department1 = departmentRepository.getOne(department.getId());
            if (department.getId() != 0 && department1 != null) {
                departmentRepository.delete(department1);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return false;
    }
}
