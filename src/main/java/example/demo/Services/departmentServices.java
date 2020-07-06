package example.demo.Services;

import example.demo.Entity.department;

import java.util.List;

public interface departmentServices {
    List<department> findAll();

    department findById(int id);

    department createDe(department department);

    boolean updateDe(department department);

    boolean deleteDe(department department);
}
