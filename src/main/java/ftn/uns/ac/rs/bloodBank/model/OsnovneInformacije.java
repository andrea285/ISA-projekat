package ftn.uns.ac.rs.bloodBank.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class OsnovneInformacije {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Transient
    private long korisnik;
    private String fullName;
    private String jmbg;
    private Date dateOfBirth;
    private char sex;
    private String address;
    private String district;
    private String city;
    private String homeNumber;
    private String jobNumber;
    private String mobile;
    private String occupation;
    private String jobTitle;
    private int previousDonations;
    private String url;

    @OneToOne
    private Korisnik korisnikId;

    public OsnovneInformacije() {
    }

    public OsnovneInformacije(Long id, long korisnik, String fullName, String jmbg, Date dateOfBirth, char sex, String address, String district, String city, String homeNumber, String jobNumber, String mobile, String occupation, String jobTitle, int previousDonations, String url, Korisnik korisnikId) {
        this.id = id;
        this.korisnik = korisnik;
        this.fullName = fullName;
        this.jmbg = jmbg;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.address = address;
        this.district = district;
        this.city = city;
        this.homeNumber = homeNumber;
        this.jobNumber = jobNumber;
        this.mobile = mobile;
        this.occupation = occupation;
        this.jobTitle = jobTitle;
        this.previousDonations = previousDonations;
        this.url = url;
        this.korisnikId = korisnikId;
    }

    public OsnovneInformacije(String fullName, String jmbg, Date dateOfBirth, char sex, String address, String district, String city, String homeNumber, String jobNumber, String mobile, String occupation, String jobTitle, int previousDonations, String url, Korisnik korisnikId) {
        this.fullName = fullName;
        this.jmbg = jmbg;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.address = address;
        this.district = district;
        this.city = city;
        this.homeNumber = homeNumber;
        this.jobNumber = jobNumber;
        this.mobile = mobile;
        this.occupation = occupation;
        this.jobTitle = jobTitle;
        this.previousDonations = previousDonations;
        this.url = url;
        this.korisnikId = korisnikId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullNameWithParent) {
        this.fullName = fullNameWithParent;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getPreviousDonations() {
        return previousDonations;
    }

    public void setPreviousDonations(int previousDonations) {
        this.previousDonations = previousDonations;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Korisnik getKorisnikId() {
        return korisnikId;
    }

    public long getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(long korisnik) {
        this.korisnik = korisnik;
    }

    public void setKorisnikId(Korisnik korisnikId) {
        this.korisnikId = korisnikId;
    }

    @Override
    public String toString() {
        return "OsnovneInformacije{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", jmbg='" + jmbg + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", sex=" + sex +
                ", address='" + address + '\'' +
                ", district='" + district + '\'' +
                ", city='" + city + '\'' +
                ", homeNumber='" + homeNumber + '\'' +
                ", jobNumber='" + jobNumber + '\'' +
                ", mobile='" + mobile + '\'' +
                ", occupation='" + occupation + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", previousDonations=" + previousDonations +
                ", url='" + url + '\'' +
                ", korisnikId=" + korisnikId +
                '}';
    }
}
