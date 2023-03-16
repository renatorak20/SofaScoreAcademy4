package com.renato.sofascoreacademy4.entities

class Company(
     val name: String,
     val address: String,
     val city: String,
     val country: String,
     val founder: String,
     val email: String,
     val website: String,
     val description: String,
     val yearFounded: Int,
     val industry: Industry,
     val type:String
){

    override fun toString(): String {
        return "Company -- " +
                "\nname='$name'," +
                "\n address='$address'," +
                "\n city='$city'," +
                "\n country='$country'," +
                "\n founder='$founder'," +
                "\n email='$email'," +
                "\n website='$website'," +
                "\n description='$description'," +
                "\n foundation year='$yearFounded'" +
                "\n industry='$industry'" +
                "\n type='$type'"
    }
}
