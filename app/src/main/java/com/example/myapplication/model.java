package com.example.myapplication;

public class model
{
    String Aadhaar_Hostel_Address,City,Email,Hostel_Name,Mobile_no,Price,Username;

    public model() {
    }

    public model(String aadhaar_Hostel_Address, String city, String email, String hostel_Name, String mobile_no, String price, String username) {
        Aadhaar_Hostel_Address = aadhaar_Hostel_Address;
        City = city;
        Email = email;
        Hostel_Name = hostel_Name;
        Mobile_no = mobile_no;
        Price = price;
        Username = username;
    }

    public String getAadhaar_Hostel_Address() {
        return Aadhaar_Hostel_Address;
    }

    public void setAadhaar_Hostel_Address(String aadhaar_Hostel_Address) {
        Aadhaar_Hostel_Address = aadhaar_Hostel_Address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getHostel_Name() {
        return Hostel_Name;
    }

    public void setHostel_Name(String hostel_Name) {
        Hostel_Name = hostel_Name;
    }

    public String getMobile_no() {
        return Mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        Mobile_no = mobile_no;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }
}
