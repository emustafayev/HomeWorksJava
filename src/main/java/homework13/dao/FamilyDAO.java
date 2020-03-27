package homework13.dao;

import homework13.entity.Family;

import java.util.List;

public interface FamilyDAO {
    List<Family> getAllFamilies();
    Family getFamilyByIndex(int index);
    boolean deleteFamily(int index);
    boolean deleteFamily(Family family);
    void saveFamily(Family family);
}
