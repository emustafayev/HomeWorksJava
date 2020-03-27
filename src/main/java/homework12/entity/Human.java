package homework12.entity;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Human {
    public String name;
    public String surname;
    public int IQ_level;
    public Map<Schedules,String> activity;
    private long birthDate;
    private String gender;


    public Human(String name, String surname , int iq,long birthDate) {
        this.name=name;
        this.surname=surname;
        this.IQ_level = iq;
        this.birthDate=dateToMillis(birthDate);
        this.activity = new HashMap<>();
    }

    public Human(String name, String surname , int iq,long birthDate,String gender) {
        this.name=name;
        this.surname=surname;
        this.IQ_level = iq;
        this.birthDate=dateToMillis(birthDate);
        this.gender=gender;
        this.activity = new HashMap<>();
    }

    public Human(String name, String surname,String date_of_birth, int iq) throws ParseException {
        this.name=name;
        this.surname=surname;
        this.IQ_level = iq;
        this.birthDate=parseDate(date_of_birth);
    }
    private long dateToMillis(long rawDate) { // FIXME later datetomillis
        String pattern = "yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = dateFormat.parse(String.valueOf(rawDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
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
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(date);

    }

    public String getGender() {
        return gender;
    }

    String describeAge(){
        LocalDate localBirth = Instant.ofEpochMilli(birthDate).atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate localDate = LocalDate.now();
        Period age = Period.between(localBirth,localDate);
        return age.getYears()+"years"+age.getMonths()+" months"+age.getDays()+"days";
    }

    public String prettyFormat(){
        return String.format("{name='%s',surname='%s',birthdate='%s',iq=%d,schedule=%s}",
                this.name,
                this.surname,
                dateFormatter(this.birthDate),
                this.IQ_level,
                this.activity.toString());
    }

    @Override
    public String toString(){
        return String.format("Human{name=%s, surname=%s, dateOfBirth=%s, iq=%d",
                name,surname,dateFormatter(birthDate),IQ_level);
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


