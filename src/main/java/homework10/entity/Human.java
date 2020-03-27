package homework10.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.*;

public class Human {
    public String name;
    public String surname;
    public int IQ_level;
    public Map<Schedules,String> activity;
    private long birthDate;


    public Human(String name, String surname , int iq,long birthDate) throws ParseException {
        this.name=name;
        this.surname=surname;
        this.IQ_level = iq;
        this.birthDate=dateToMillis(birthDate);
    }
    public Human(String name, String surname,String date_of_birth, int iq) throws ParseException {
        this.name=name;
        this.surname=surname;
        this.IQ_level = iq;
        this.birthDate=parseDate(date_of_birth);
    }
    private long dateToMillis(long rawDate) throws ParseException {
        String pattern = "yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        Date date = dateFormat.parse(String.valueOf(rawDate));
        return date.getTime();
    }

    private long parseDate(String rawDate) throws ParseException {
        String pattern = "dd/MM/yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        Date date = dateFormat.parse(rawDate);
        return date.getTime();
    }

    public Human(String name, String surname, int IQ_level,long birthDate, HashMap<Schedules,String> activities) throws ParseException {
        this(name, surname, IQ_level,birthDate);
        this.activity=activities;
    }


    public int getYear(){
        LocalDate localBirth = Instant.ofEpochMilli(birthDate).atZone(ZoneId.systemDefault()).toLocalDate();
        return localBirth.getYear();
    }

    private String dateFormatter(long millis){
        Date date = new Date(millis);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/M/yyyy");
        return dateFormat.format(date);
    }

    private String dateFormatterDiff(long millis){
        Date date = new Date(millis);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(date);
    }


    String describeAge(){
        LocalDate localBirth = Instant.ofEpochMilli(birthDate).atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate localDate = LocalDate.now();
        Period age = Period.between(localBirth,localDate);
        return age.getYears()+"years"+age.getMonths()+" months"+age.getDays()+"days";
    }

    @Override
    public String toString(){
        return String.format("Human{name=%s, surname=%s, dateOfBirth=%s, iq=%d",
                name,surname,dateFormatterDiff(birthDate),IQ_level);
    }

    @Override
    public void finalize(){
        System.out.println("Object removed from memory!");
    }


    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return IQ_level == human.IQ_level &&
                Objects.equals(surname, human.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, birthDate, IQ_level);
    }
}


