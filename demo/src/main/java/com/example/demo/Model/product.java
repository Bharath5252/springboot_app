package com.example.demo.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;




@Document
@XmlRootElement(name="product")
@XmlType(propOrder = {
    "id",
    "name",
    "price",
    "description"
})
public class product {
    @Id
    public String id;
    public String name;
    public String price;
    public String description;
}


