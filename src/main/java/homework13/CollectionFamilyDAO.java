package homework13;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionFamilyDAO implements FamilyDAO {
    private List<Family> data = new ArrayList<>();
    private String filePath = "./data/families.bin";

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

    public boolean saveDataToFile(){
        try{
            File file = new File(filePath);
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            List<Family> objects = this.data;
            oos.writeObject(objects);
            oos.close();
            fos.close();
            return true;
        }catch (IOException e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean loadData(){
        try {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            this.data = (List<Family>) ois.readObject();
            ois.close();
            fis.close();
            return true;
        }catch (IOException | ClassNotFoundException e){
            return false;
        }
    }

    @Override
    public boolean deleteFamily(Family family) {
        int beforeDeletion = this.data.size();
        this.data.remove(family);
        return beforeDeletion > data.size();
    }
    @Override
    public void saveFamily(Family newFamily) {
        if(data.stream().noneMatch(f ->
                f.getIndex() == newFamily.getIndex())){
            data.add(newFamily);
        }else{
            Family originFamily = data.stream().filter(f -> f.getIndex() == newFamily.getIndex()).collect(Collectors.toList()).get(0);
            originFamily.setChildren(newFamily.getChildren());
            originFamily.setPets(newFamily.getPets());
            originFamily.countFamily();
        }
    }

    public int count(){
        return data.size();
    }

    public void setData(List<Family> families){
        this.data=families;
    }
}
