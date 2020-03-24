package homework9;

import java.text.Collator;
import java.util.*;
import java.util.stream.Collectors;

public class CollectionFamilyDAO implements FamilyDAO {
    private List<Family> data = new ArrayList<>();
    private Console console = new Console();

    public List<Family> getData() {
        return data;
    }

    @Override
    public List<Family> getAllFamilies() {
        return data;
    }

    @Override
    public Family getFamilyByIndex(int index) {
        if (data.stream().noneMatch(family -> family.getIndex() == index)) {
            return null;
        }
        return data.stream().filter(family -> family.getIndex() == index).collect(Collectors.toList()).get(0);
    }

    @Override
    public boolean deleteFamily(int index) {
        int beforeDeletion = this.data.size();
        this.data = this.data.stream().filter(family -> family.getIndex() != index).collect(Collectors.toList());
        return beforeDeletion > data.size();
    }

    @Override
    public boolean deleteFamily(Family family) {
        int beforeDeletion = this.data.size();
        this.data.remove(family);
        return beforeDeletion > data.size();
    }
    @Override
    public void saveFamily(Family newFamily) {
        if(data.stream().filter(f -> f.getIndex() == newFamily.getIndex()).count() == 0){
            data.add(newFamily);
        }else{
            Family originFamily = data.stream().filter(f -> f.getIndex() == newFamily.getIndex()).collect(Collectors.toList()).get(0);
            originFamily.setChildren(newFamily.getChildren());
            originFamily.setPet(newFamily.getPet());
            originFamily.countFamily();
        }
    }

    public int count(){
        return data.size();
    }

}
