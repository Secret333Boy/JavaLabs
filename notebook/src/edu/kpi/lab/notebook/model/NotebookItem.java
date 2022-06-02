package edu.kpi.lab.notebook.model;

public class NotebookItem implements INotebookItem {
	private String surname;
	private String name;
	private String middleName;
	private String address;
	private String telephone;
	private String additionalInfo;

	public NotebookItem(String surname, String name, String middleName, String address, String telephone, String additionalInfo) {
		this.surname = surname;
		this.name = name;
		this.middleName = middleName;
		this.address = address;
		this.telephone = telephone;
		this.additionalInfo = additionalInfo;
	}

	@Override
	public String getSurname() {
		return surname;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getMiddleName() {
		return middleName;
	}

	@Override
	public String getAddress() {
		return address;
	}

	@Override
	public String getTelephone() {
		return telephone;
	}

	@Override
	public String getAdditionalInfo() {
		return additionalInfo;
	}

	@Override
	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Override
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	@Override
	public String toString() {
		String fmt = "%15s|%15s|%15s|%30s|%17s|%15s";
		return String.format(fmt, this.surname, this.name, this.middleName, this.address, this.telephone, this.additionalInfo);
	}
}
