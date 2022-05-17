package model;

public interface INotebookItem {
	String getSurname();
	String getName();
	String getMiddleName();
	String getAddress();
	String getTelephone();
	String getAdditionalInfo();
	void setSurname(String surname);
	void setName(String name);
	void setMiddleName(String middleName);
	void setAddress(String address);
	void setTelephone(String telephone);
	void setAdditionalInfo(String additionalInfo);
	String toString();
}
