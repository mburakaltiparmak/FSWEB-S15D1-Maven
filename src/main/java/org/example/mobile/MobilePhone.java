package org.example.mobile;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MobilePhone {
    private String myNumber;
    private List<Contact> myContacts;

    public MobilePhone(String myNumber, List<Contact> myContacts) {
        this.myNumber = myNumber;
        this.myContacts = myContacts;
    }
    public Boolean addNewContact(Contact contact){
        if(!myContacts.contains(contact)){
            myContacts.add(contact);
            return true;
        }
        else {
            return false;
        }
    }
    public Boolean updateContact(Contact oldContact,Contact newContact){
        int oldContactIndex=myContacts.indexOf(oldContact);
        if(oldContactIndex<0){
            return false;
        }
        this.myContacts.set(oldContactIndex,newContact);
        return true;
    }
    public Boolean removeContact(Contact contact){
        if(myContacts.contains(contact)){
            int oldContactIndex = myContacts.indexOf(contact);
            myContacts.remove(oldContactIndex);
            return true;
        }
        else {
            return false;
        }
    }
    public int findContact(Contact contact){
        if(myContacts.contains(contact)){
            return myContacts.indexOf(contact);
        }
        else {
            return -1;
        }
    }
    public int findContact(String contactName) {
        for(int i = 0 ; i < this.myContacts.size() ; i++){
            Contact contact = this.myContacts.get(i);
            if(contact.getName().equalsIgnoreCase(contactName)){
                return i;
            }
        }
        return -1;
    }
    public Contact queryContact(String contactName){
        int index = findContact(contactName);
        if(index < 0){
            return null;
        }
        return this.myContacts.get(index);
    }
    public void printContacts(){
        for(int i = 0 ; i < this.myContacts.size() ; i++){
            Contact contact = this.myContacts.get(i);
            System.out.println((i+1)+". "+contact.getName()+" -> "+contact.getPhoneNumber());
        }
    }


    public String getMyNumber() {
        return myNumber;
    }

    public List<Contact> getMyContacts() {
        return myContacts;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MobilePhone that = (MobilePhone) o;
        return Objects.equals(myNumber, that.myNumber) && Objects.equals(myContacts, that.myContacts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(myNumber, myContacts);
    }

    @Override
    public String toString() {
        return "MobilePhone{" +
                "myNumber='" + myNumber + '\'' +
                ", myContacts=" + myContacts +
                '}';
    }
}
